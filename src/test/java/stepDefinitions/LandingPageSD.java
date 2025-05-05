package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage_OR;
import utils.TestContextSetup;

public class LandingPageSD {
	public WebDriver driver;
	public String landingPageProductName;
	TestContextSetup testContextSetup;
	LandingPage_OR landingPage;

	public LandingPageSD(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("User is on Greencart landing page")
	public void user_is_on_greencart_landing_page() {

	}

//	@When("User searched with shortname {string} and extracted actual name of product")
	@When("^User searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname)
			throws InterruptedException {
//		PageObjectManager pageObjectManager = new PageObjectManager(testContextSetup.driver);
//		LandingPage_OR landingPage = new LandingPage_OR(testContextSetup.driver);
		landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchItem(shortname);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
//		System.out.println(landingPageProductName);

	}

//	@When("Add the items to the cart and click on checkout button")
//	public void add_the_items_to_the_cart_and_click_on_checkout_page() throws InterruptedException {
//		for (int i = 0; i < 3; i++) {
//			landingPage = testContextSetup.pageObjectManager.getLandingPage();
//			landingPage.increaseItemQty();
//
//		}
//		landingPage.addToCart();
//		landingPage.clickCartIcon();
//		Thread.sleep(1000);
//		landingPage.clickCheckOutButton();
//		Thread.sleep(1000);
//	}

	@When("Add {string} items of the selected part to cart")
	public void added_items_product(String quantity) {
		landingPage.increaseItemQty(Integer.parseInt(quantity));
		landingPage.addToCart();
	}

}
