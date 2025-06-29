package com.intro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CalendraDemo {

	public static void main(String[] args) {

		String month = "3";
		String day = "3";
		String year = "2028";
		String[] expectedlist = { month, day, year };
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
		driver.findElements(
				By.xpath("//button[@class='react-calendar__tile react-calendar__year-view__months__month']"))
				.get(Integer.parseInt(month) - 1).click();
		driver.findElement(By.xpath("//abbr[text()='" + day + "']")).click();
		List<WebElement> actuallist = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for (int i = 0; i < actuallist.size(); i++) {
			System.out.println(actuallist.get(i).getAttribute("value"));
			Assert.assertEquals(actuallist.get(i).getAttribute("value"), expectedlist[i]);
		}

	}

}
