package com.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
	    driver.findElement(By.xpath("//a[@value='ATQ']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='JAI']")).click();//parent child way
		driver.findElement(By.xpath("//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']")).click();
		driver.findElement(By.xpath("//input[contains(@id,'SeniorCitizenDiscount')]")).click();
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
       {
		 Assert.assertTrue(true);
		 System.out.println("Its disabled");
       }
		else{
		  Assert.assertTrue(false);
		}
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		String value1= driver.findElement(By.id("divpaxinfo")).getText();
		for (int i = 1; i < 3; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		driver.findElement(By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']")).click();
		}
    
}
