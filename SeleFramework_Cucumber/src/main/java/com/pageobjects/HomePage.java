package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AbstractComponents.AbstractComponents;

public class HomePage extends AbstractComponents {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='userEmail']")
	WebElement userEmail;
	
	@FindBy(xpath="//input[@id='userPassword']")
	WebElement pwd;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement login;
	
	@FindBy(xpath="//div[contains(@class,'toast-message')]")
      WebElement errorMessage;
	
	public ProductCatalogue loginApplication(String email,String passwd)
	{
		userEmail.sendKeys(email);
		pwd.sendKeys(passwd);
		login.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getErrorMessage() {
		
		waitForWebElementToAppear(errorMessage);
		
		return errorMessage.getText();
		
		
		
	}

	
}
