package com.intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerdriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		WebElement columndiver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int columnlinks = columndiver.findElements(By.tagName("a")).size();
		System.out.println(columnlinks);
		for (int i = 1; i < columnlinks; i++) {
			if (i == 1) {
				System.out.println(driver.getTitle());
			}
			String clinkonTabs = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columndiver.findElements(By.tagName("a")).get(i).sendKeys(clinkonTabs);
			Thread.sleep(5000);
			Set<String> windows = driver.getWindowHandles();
			ArrayList<String> list = new ArrayList<>(windows);
			driver.switchTo().window(list.get(list.size() - 1));// 2 windows are present(practice,Rest API)
			System.out.println(driver.getTitle());
			driver.switchTo().window(list.get(0));

		}
	}

}
