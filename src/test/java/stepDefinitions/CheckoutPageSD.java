package stepDefinitions;


import org.junit.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckOutPage_OR;
import utils.TestContextSetup;

public class CheckoutPageSD {
	TestContextSetup testContextSetup;
	public CheckOutPage_OR checkOutPage;
	
	public CheckoutPageSD(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkOutPage = testContextSetup.pageObjectManager.getCheckoutPage();

	}
	
	@Then("Validate whether the same product is displaying in Checkout page")
	public void validate_whether_the_same_product_is_displaying_in_checkout_page() {
		         checkOutPage = testContextSetup.pageObjectManager.getCheckoutPage();
		      String productName = checkOutPage.getProductText();
		      System.out.println(productName);
		      Assert.assertEquals(testContextSetup.landingPageProductName, productName);
		      System.out.println(checkOutPage.applyButton());
//		      Assert.assertTrue(checkOutPage.applyButton(), "Apply button is displayed in checkout page");
		      System.out.println(checkOutPage.placeOrderButton());
//		      Assert.assertTrue(checkOutPage.placeOrderButton(), "Place order button is displayed in checkout page");
	}
	
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page(String name) throws InterruptedException {
		checkOutPage.checkOutItems();
		Thread.sleep(2000);
		 Assert.assertEquals(checkOutPage.getProductText(),testContextSetup.landingPageProductName);
	}
	
	
	@Then("Verify user has ability to enter the promo code and place the order")
	public void verify_user_has_ability_to_enter_the_promo_code_and_place_the_order() {
        Assert.assertTrue(checkOutPage.applyButton());
        Assert.assertTrue(checkOutPage.placeOrderButton());
	}
}
