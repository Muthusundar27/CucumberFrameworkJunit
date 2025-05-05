package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage_OR {

	public WebDriver driver;
	
	public OfferPage_OR(WebDriver driver) {
		this.driver = driver;
	}
	
	By searchItem = By.id("search-field");
	By productName = By.xpath("//tbody//tr//td[1]");	
	
	public void searchItem(String name) {
		driver.findElement(searchItem).sendKeys(name);
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
}
