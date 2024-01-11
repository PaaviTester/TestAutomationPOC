package testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "featurefiles", glue = "stepdefinitions", dryRun = false,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        "html:target/cucumber-report.html" })
public class OrangeHRMTestRunner {

}
