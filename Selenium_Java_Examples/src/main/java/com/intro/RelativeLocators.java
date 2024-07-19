package com.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
  
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameEditBox=driver.findElement(By.xpath("//input[@name='name']"));
		//above
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		WebElement dateofbirthBox=driver.findElement(By.xpath("//label[@for='dateofBirth']"));
		//below
		driver.findElement(with(By.tagName("input")).below(dateofbirthBox)).click();
		WebElement iceCream=driver.findElement(By.xpath("//label[@class='form-check-label']"));
		//left
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCream)).click();
		WebElement radio=driver.findElement(By.xpath("//input[@value='option1']"));
		//Right
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radio)).getText());
		
		}

}
