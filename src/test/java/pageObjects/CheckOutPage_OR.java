package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage_OR {
	public WebDriver driver;

	public CheckOutPage_OR(WebDriver driver) {
		this.driver = driver;
	}
	
	By productName = By.cssSelector("p[class=\"product-name\"]");
	By applyButton =  By.cssSelector("button[class=\"promoBtn\"]");
	By placeOrderButton = By.xpath("//button[text()=\"Place Order\"]");
	By cartIcon = By.cssSelector("img[alt=\"Cart\"]");
	By checkOutField = By.xpath("//button[text()=\"PROCEED TO CHECKOUT\"]");
	
	public String getProductText() {
		return driver.findElement(productName).getText().split("-")[0].trim();		
	}
	
	public boolean applyButton() {
		return driver.findElement(applyButton).isDisplayed();
	}
	
	public boolean placeOrderButton() {
		return driver.findElement(placeOrderButton).isDisplayed();
	}
	
	public void checkOutItems() {
		driver.findElement(cartIcon).click();
		driver.findElement(checkOutField).click();
	}
}
