package stepdefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OanageHRMFunctions 
{
	public static WebDriver driver;

	@Given("I Open Browser with url {string}")
	public void i_open_browser_with_url(String url)
	{
	   driver=new ChromeDriver();
	   driver.manage().deleteAllCookies();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	   driver.get(url);	    
	}
	
	@Then("I Should See Login Page")
	public void i_should_see_login_page()
	{
		if(driver.findElement(By.name("password")).isDisplayed())
		{
			System.out.println("Application Launched Successfully");
		}else
		{
			System.out.println("Application Launch Failed");
		}						    
	}
	
	@When("I Enter Username as {string}")
	public void i_enter_username_as(String uid) 
	{
		driver.findElement(By.name("username")).sendKeys(uid);
	   
	}
	@When("I Enter Password as {string}")
	public void i_enter_password_as(String pwd) 
	{
		driver.findElement(By.name("password")).sendKeys(pwd);	    
	}
	
	@When("I Click Login")
	public void i_click_login() 
	{
		driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
	   
	}
	
	@Then("I Should see Admin Home Page")
	public void i_should_see_admin_home_page() 
	{
		if(driver.findElement(By.linkText("Admin")).isDisplayed())
		{
			System.out.println("Admin Login Successfull");
		}else
		{
			System.out.println("Admin Login Failed");
		}	    
	}
	
	@When("I Click Admin Dropdown")
	public void i_click_admin_dropdown() 
	{
		driver.findElement(By.className("oxd-userdropdown-name")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-userdropdown-name")));	   
	}
	
	@Then("I Should See Logout Option")
	public void i_should_see_logout_option() 
	{
		driver.findElement(By.className("oxd-userdropdown-link")).isDisplayed();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-userdropdown-link")));	    	   
	}
	
	@When("I Click Logout option")
	public void i_click_logout_option() 
	{
		driver.findElement(By.linkText("Logout")).click();
	}
	
	@Then("I Should See Error Message")
	public void i_should_see_error_message() 
	{
		WebElement errmsgElement=driver.findElement(By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']"));
		String errmsgText=errmsgElement.getText();
		
		if(errmsgText.contains("Invalid"))
		{
			System.out.println("Login working as Expected for Invalid data");
		}else
		{
			System.out.println("Login not working as Expeced for Invalid data");
		}					    
	}
	
	@When("I Close Browser")
	public void i_close_browser() 
	{
		driver.close();   
	}	
}
