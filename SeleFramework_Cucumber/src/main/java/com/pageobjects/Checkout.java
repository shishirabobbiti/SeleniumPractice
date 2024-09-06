package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AbstractComponents.AbstractComponents;


public class Checkout extends AbstractComponents {

	WebDriver driver;
	JavascriptExecutor js;

	public Checkout(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;

	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;
	By countryResults =( By.xpath("//section[contains(@class,'ta-results')]"));
	By header=(By.xpath("//div[@class='heading cf']//h1"));
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectcountry;

	@FindBy(xpath = "//a[contains(text(),'Place Order')]")
	WebElement placeOrderButton;

	public void selectCountry() {

		country.sendKeys("India");
		waitForElementToAppear(countryResults);
		js.executeScript("arguments[0].click();", selectcountry);
	}



	public ConfirmationPage clickOnPlaceOrder() {

		js.executeScript("arguments[0].click();", placeOrderButton);
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
		
		
	}
}
