package com.intro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("Ar");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		
		for(int i=0;i<options.size();i++)
		{
			WebElement option=options.get(i);
			if(option.getText().equalsIgnoreCase("Aruba")){
			option.click();
			break;
		}
		}
//		for (WebElement option : options) {
//			if (option.getText().equalsIgnoreCase("Aruba")) {
//				option.click();
//				break;
//			}
//		}
	}
}
