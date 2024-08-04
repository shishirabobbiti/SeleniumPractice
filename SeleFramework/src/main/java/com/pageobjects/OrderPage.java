package com.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		 super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//tr[@class='ng-star-inserted']/td[2]")
	List<WebElement> orderList;
	
	public Boolean verifyOrderDisplay(String productName)
	{
		
		Boolean match = orderList.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
		return match;
	}

}
