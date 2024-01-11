
@tag
Feature: Admin Login
  I want to use this template to check OrangeHRM Admin Login

  @tag1
  Scenario: Check Admin Login with valid data
    Given I Open Browser with url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    Then I Should See Login Page
    When I Enter Username as "Admin"
    And I Enter Password as "admin123"
    And I Click Login
    Then I Should see Admin Home Page
    When I Click Admin Dropdown
    Then I Should See Logout Option
    When I Click Logout option
    Then I Should See Login Page
    When I Close Browser
    
	@tag2
	Scenario Outline: Check Admin Login with invalid data
	Given I Open Browser with url "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
	Then I Should See Login Page
  When I Enter Username as "<uid>"
  And I Enter Password as "<pwd>"
  And I Click Login
  Then I Should See Error Message
  When I Close Browser
  
  Examples:
  	|uid|pwd|
  	|Admin|abcd|
  	|abcd|admin123|
  	|abcd|xyz|
  	
  
	
    

 
