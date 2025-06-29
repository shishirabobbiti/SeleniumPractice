package com.intro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment9 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.xpath("//input[@class='inputs ui-autocomplete-input']")).sendKeys("Uni");
		Thread.sleep(3000);
		List<WebElement> items = driver.findElements(By.xpath("//ul[@id='ui-id-1']//li"));
		// System.out.println(items.size());

		for (int i = 0; i < items.size(); i++) {
			WebElement it=items.get(i);
			if (it.getText().equalsIgnoreCase("United Kingdom (UK)"))

			{   
				
				String item = it.getText();
				it.click();
				//System.out.println(item);

				Assert.assertEquals(item, "United Kingdom (UK)");
				break;
			}
		}
		driver.close();
	}

}
