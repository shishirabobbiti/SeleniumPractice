package com.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		Actions a = new Actions(driver);
		Thread.sleep(5000);
		//a.moveToElement(driver.findElement(By.xpath("//a[@id='nav-link-accountList']"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav-link-accountList']"))).build().perform();
		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT)
				.sendKeys("car").doubleClick().build().perform();
		a.moveToElement(driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav-link-accountList']"))).contextClick().build()
				.perform();
	}

}
