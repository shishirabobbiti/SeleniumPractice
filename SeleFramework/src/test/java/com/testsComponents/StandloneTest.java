package com.testsComponents;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pageobjects.CartPage;
import com.pageobjects.Checkout;
import com.pageobjects.ConfirmationPage;
import com.pageobjects.OrderPage;
import com.pageobjects.ProductCatalogue;
import com.tests.BaseTest;
import org.junit.*;


public class StandloneTest extends BaseTest {
	//String productName = "ZARA COAT 3";
	@Test(dataProvider="getData",groups={"purchase"})
	public void submitOrder(HashMap<String,String> input) throws InterruptedException 
	//public void submitOrder(String email,String password,String productName) throws InterruptedException 

	{
		
		ProductCatalogue productCatalogue =homePage.loginApplication(input.get("email"),input.get("password"));

		//ProductCatalogue productCatalogue =homePage.loginApplication(email,password));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.itemsAddedToCart(input.get("productName"));
		CartPage cartPage=productCatalogue.goToCart();
		Thread.sleep(2000);
		boolean match = cartPage.verifyProductDisplay(input.get("productName"));	
		System.out.println(match);
		assertTrue(match);
		Checkout checkoutPage=cartPage.clickOnCheckout();
		checkoutPage.selectCountry();
		ConfirmationPage confirmationPage=checkoutPage.clickOnPlaceOrder();
		String confirmationmsg=confirmationPage.getConfirmationMessage();
		assertEquals(confirmationmsg, "THANKYOU FOR THE ORDER.");
			}
	
	
	@Test(dependsOnMethods={"submitOrder"})
	public void orderHistory() {
		ProductCatalogue productCatalogue =homePage.loginApplication("shishira@gmail.com", "Shishira@123");
		OrderPage orderPage = productCatalogue.goToOrders();
		boolean match=orderPage.verifyOrderDisplay("ZARA COAT 3");
		assertTrue(match);
		
	}
	@DataProvider
	public Object[][] getData() throws IOException{
		
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email", "shishira@gmail.com");
//		map.put("password", "Shishira@123");
//		map.put("productName","ADIDAS ORIGINAL");

//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email", "shetty@gmail.com");
//		map1.put("password", "Iamking@000");
//		map1.put("productName","ZARA COAT 3");
		
		List<HashMap<String,String>>data=getJsonDataToMap("src\\main\\java\\com\\data\\purchaseOrder.json");
		
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}
//	@DataProvider
//	public Object[][]  getData() {
//		
//		return new Object[][] {{"shishira@gmail.com","Shishira@123" ,"ADIDAS ORIGINAL"} ,
//			{"shetty@gmail.com","Iamking@000" ,"ZARA COAT 3"},{"shetty@gmail.com","Iamking@000" ,"IPHONE 13 PRO"}};
//		
//	}
	

	
}


