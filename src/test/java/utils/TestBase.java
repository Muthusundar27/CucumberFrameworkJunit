package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browserProperty = prop.getProperty("browser");
		String browserMaven = prop.getProperty("browser");
		// terinary operator in java:  result = testcondition? value1 : value2
		
		String browser =  browserMaven!=null ? browserMaven : browserProperty;

		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} 
		 if (browser .equalsIgnoreCase("firefox")){
				// firefox code;
				driver	= new FirefoxDriver();
			}
			driver.get(url);
            driver.manage().window().maximize();
		}
		return driver;

	}
}
