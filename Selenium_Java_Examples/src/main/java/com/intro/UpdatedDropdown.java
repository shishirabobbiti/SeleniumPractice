package com.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		String value1= driver.findElement(By.id("divpaxinfo")).getText();
		//Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"1 Adult");
		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		String value2=driver.findElement(By.id("divpaxinfo")).getText();
		//Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
		Assert.assertNotEquals(value1, value2);
		
	}

}
