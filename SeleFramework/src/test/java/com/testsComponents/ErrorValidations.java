package com.testsComponents;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.pageobjects.CartPage;
import com.pageobjects.ProductCatalogue;
import com.tests.BaseTest;

import junit.framework.Assert;


public class ErrorValidations extends BaseTest {

	@Test(groups={"ErrorHandling"})
	public void loginErrorvaliations() {

	     homePage.loginApplication("shishir@gmail.com", "Shishira@123");
		Assert.assertEquals(homePage.getErrorMessage(), "Incorrect email or password.");

	}
@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue =homePage.loginApplication("shishira@gmail.com", "Shishira@123");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.itemsAddedToCart(productName);
		CartPage cartPage=productCatalogue.goToCart();
		Boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");	
		Assert.assertFalse(match);
		
	

	}
	
}
