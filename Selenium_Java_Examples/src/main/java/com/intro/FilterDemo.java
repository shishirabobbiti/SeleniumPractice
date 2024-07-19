package com.intro;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterDemo {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");
		List<WebElement> items = driver.findElements(By.xpath("//tr//td[1]"));
       List<String> expectedlist=items.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> filteritems = items.stream().map(s->s.getText()).filter(s->s.contains("Rice"))
				.collect(Collectors.toList());

		Assert.assertEquals(expectedlist, filteritems);

	}

}
