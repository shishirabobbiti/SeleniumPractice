package com.pageobjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents {
	
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	By productsList=By.cssSelector(".mb-3");
	
	//@FindBy(xpath="//button[contains(text(),'Add To Cart')]")
	//WebElement addToCart;
	
	By addToCart = By.xpath("//button[contains(text(),'Add To Cart')]");
	
	By visibleMsg  =By.xpath("//div[@id='toast-container']");
	By invisibleMsg=(By.xpath("//div[@id='toast-container']"));
	
	public List<WebElement> getProductList() {
		
		waitForElementToAppear(productsList);
		return products;
	}
	
	
	public void itemsAddedToCart(String productName ) {
	  // System.out.println(products.size());
       driver.findElement(By.xpath("//b[text()='"+productName+"']/parent::h5/following-sibling::button[2]")).click();		
		
		waitForElementToAppear(visibleMsg);
		waitForElementToDisappear(invisibleMsg);
	}
}