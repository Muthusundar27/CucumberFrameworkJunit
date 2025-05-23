package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	TestContextSetup testContextSetup;

	public Hooks(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@After
	public void afterScenario() throws IOException {
		testContextSetup.testBase.WebDriverManager().quit();

	}
	
	@AfterStep
	public void AfterScenario(Scenario scenario) throws WebDriverException, IOException {
		if(scenario.isFailed()) {
			//screenshot if steps failed
			File src =((TakesScreenshot)testContextSetup.testBase.WebDriverManager()).getScreenshotAs(OutputType.FILE);
			byte[] fileContent =FileUtils.readFileToByteArray(src);
			scenario.attach(fileContent, "image/png", "image");
		
		}
	}
}
