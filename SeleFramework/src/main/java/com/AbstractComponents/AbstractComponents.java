package com.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pageobjects.CartPage;
import com.pageobjects.OrderPage;

public class AbstractComponents {

	WebDriver driver;
	WebDriverWait wait;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	@FindBy(xpath="//button//i[@class='fa fa-shopping-cart']")
	WebElement cartButton;

	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement ordersButton;
	public void waitForElementToAppear(By findBy) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	
	public void waitForWebElementToAppear(WebElement ele) {

		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	public void waitForElementToDisappear(By findBy) {

		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public CartPage goToCart()
	{
		cartButton.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrders() 
	{
		ordersButton.click();
		OrderPage orderPage=new OrderPage(driver);
		return orderPage;
		
	}

}
