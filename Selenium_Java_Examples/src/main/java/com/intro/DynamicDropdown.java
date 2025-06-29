package com.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click(); //indexing
		// way
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();// parent child way
		//driver.findElement(By.xpath("//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-today']")).click();
		driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active']")).click();
	
	}
}
