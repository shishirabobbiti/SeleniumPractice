 package com.intro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavascriptexecutorDemo {

	public static void main(String[] args) throws InterruptedException {
		int sum = 0;
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=3000");
		List<WebElement> amount = driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody//td[4]"));
		for (int i = 0; i < amount.size(); i++) {
			sum = sum + Integer.parseInt(amount.get(i).getText());
		}
		System.out.println(sum);
		int expectedamount = Integer
				.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, expectedamount);
	}

}
