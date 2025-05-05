package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//html, xml, json, junit, extentreports
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", glue="stepDefinitions", monochrome=true, tags="@Smoke",
plugin = {"pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
		"rerun:target/failed_scenarios.txt"})
//, dryRun=true
public class JunitTestRunnerTest {

}

