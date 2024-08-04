package com.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

WebDriver driver;
	
	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//div[@class='cartSection']//h3")
	List<WebElement> cartItems;
	By header=(By.xpath("//div[@class='heading cf']//h1"));
	
	@FindBy(xpath=("//button[text()='Checkout']"))
	WebElement checkoutbutton;
			
	
	public Boolean verifyProductDisplay(String productName)
	{
		waitForElementToAppear(header);
		Boolean match = cartItems.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public Checkout clickOnCheckout() {
		checkoutbutton.click();
		Checkout checkout= new Checkout(driver);
		return checkout;
		
	}
	
	
}