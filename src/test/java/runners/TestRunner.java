package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\features",
	glue = "stepdefinitions",
	tags = "@validCredentials")

public class TestRunner extends AbstractTestNGCucumberTests{
	
}
