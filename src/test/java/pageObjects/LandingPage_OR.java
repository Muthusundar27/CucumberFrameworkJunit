package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage_OR {
	public WebDriver driver;

	public LandingPage_OR(WebDriver driver) {
		this.driver = driver;
	}

	By search = By.cssSelector("input[class=\"search-keyword\"]");
	By productName = By.cssSelector("h4[class=\"product-name\"]");
	By selectTopDeals = By.xpath("//a[text()=\"Top Deals\"]");
	By increaseQty = By.xpath("//a[@class=\"increment\"]");
	By addToCart = By.xpath("//button[text()=\"ADD TO CART\"]");
	By cartIcon = By.cssSelector("img[alt=\"Cart\"]");
	By checkOutField = By.xpath("//button[text()=\"PROCEED TO CHECKOUT\"]");

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDealsPage() {
		driver.findElement(selectTopDeals).click();
	}
	
	public void increaseItemQty(int quantity) {
		int i=quantity-1;
		while(i>0) {
			driver.findElement(increaseQty).click();
            i--;
		}
	}
	
	public void addToCart() {
		driver.findElement(addToCart).click();
	}
	
	public void clickCartIcon() {
		driver.findElement(cartIcon).click();
	}
	
	public void clickCheckOutButton() {
		driver.findElement(checkOutField).click();
	}
}
