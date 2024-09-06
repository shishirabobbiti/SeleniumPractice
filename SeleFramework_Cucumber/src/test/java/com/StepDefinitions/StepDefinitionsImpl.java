package com.StepDefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.pageobjects.CartPage;
import com.pageobjects.Checkout;
import com.pageobjects.ConfirmationPage;
import com.pageobjects.HomePage;
import com.pageobjects.ProductCatalogue;
import com.tests.BaseTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionsImpl extends BaseTest {
	
  public HomePage homePage;
  public ProductCatalogue productCatalogue;
  public ConfirmationPage confirmationPage;
	@Given("I landed on Ecommerce page")
		public void  I_landed_on_Ecommerce_page() {
		
		homePage=launchApplication();
			
		}
	@Given("^Logged in with username (.+) and password (.+)$")
	 public void Loggedin_username_and_password(String username,String password) {
		productCatalogue =homePage.loginApplication(username,password);
	
 }
	 @When ("^I add product \"([^\"]*)\" to Cart$")
	 public void add_product_to_cart(String productName) {
		 
		 List<WebElement> products = productCatalogue.getProductList();
			productCatalogue.itemsAddedToCart(productName);
	 }
	 
	 @When ("^Checkout \"([^\"]*)\" and submit the order$")
	 public void checkout_submit_order( String productName) throws InterruptedException {
		 
		 CartPage cartPage=productCatalogue.goToCart();
			Thread.sleep(2000);
			boolean match = cartPage.verifyProductDisplay(productName);	
			System.out.println(match);
			assertTrue(match);
			Checkout checkoutPage=cartPage.clickOnCheckout();
			checkoutPage.selectCountry();
			 confirmationPage=checkoutPage.clickOnPlaceOrder();
		 
	 }
	 @Then("{string} is displayed on the confirmation page")
	 public void message_displayed_confirmationpage(String string) {
		 String confirmationmsg=confirmationPage.getConfirmationMessage();
			Assert.assertTrue(confirmationmsg.equalsIgnoreCase(string));
			driver.close();
}
	 
	 @ Then ("{string} message is displayed")
	 public void message_displayed_Errormessage(String string) {
		 Assert.assertEquals(string, "Incorrect email  password.");
			driver.close();
		 
		 
	 }
}

