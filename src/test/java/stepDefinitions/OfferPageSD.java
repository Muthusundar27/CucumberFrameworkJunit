package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage_OR;
import pageObjects.OfferPage_OR;
import utils.TestContextSetup;

public class OfferPageSD {
	// single responsiblity principle
	//loosly coupled
	public String offerPageProductName;
	TestContextSetup testContextSetup;

	public OfferPageSD(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

//	@Then("User searched for {string} shortname in offers page")
	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortname) {
		switchToOffersPage();
		OfferPage_OR offerPage = testContextSetup.pageObjectManager.getOfferPage();
		offerPage.searchItem(shortname);
		offerPageProductName = offerPage.getProductName();

	}

	public void switchToOffersPage() {
//		if switched to offer page --> skip below part
//		if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		LandingPage_OR landingPage=	testContextSetup.pageObjectManager.getLandingPage();
//		LandingPage_OR landingPage = new LandingPage_OR(testContextSetup.driver);
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.switchwindowToChild();
		//explicity waits, to pass the string
	}

	@Then("Validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
//		Assert.assertEquals(testContextSetup.landingPageProductName, offerPageProductName);
	}
}
