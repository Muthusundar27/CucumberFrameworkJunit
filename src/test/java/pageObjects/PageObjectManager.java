package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public WebDriver driver;
	public LandingPage_OR landingPage;
	public OfferPage_OR offerPage;
	public CheckOutPage_OR checkOutPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public LandingPage_OR getLandingPage() {		
		 landingPage= new LandingPage_OR(driver);
		 return landingPage;
	}
	
	public OfferPage_OR getOfferPage() {
		offerPage = new OfferPage_OR(driver);
		return offerPage;
	}
	
	public CheckOutPage_OR getCheckoutPage() {
		checkOutPage = new CheckOutPage_OR(driver);
		return checkOutPage;
	}
}
