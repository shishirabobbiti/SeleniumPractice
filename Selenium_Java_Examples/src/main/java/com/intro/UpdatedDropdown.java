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
		Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		//System.out.println(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).click();
		//System.out.println(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).isSelected());
		//check how many checkboxes
		System.out.println("checkboxes " + driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		//Assert.assertTrue(driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date2']")).isEnabled());
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		//Assert.assertTrue(driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date2']")).isEnabled());
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
       {
		 Assert.assertTrue(true);
		 System.out.println("Its enabled");
       }
		else{
		  Assert.assertFalse(true);
		}
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
