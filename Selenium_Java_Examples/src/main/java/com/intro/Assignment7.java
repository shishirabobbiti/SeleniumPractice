package com.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment7 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();
		String checkbox = driver.findElement(By.xpath("//div[@id='checkbox-example']//label[@for='honda']")).getText();
		System.out.println(checkbox);
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select dropdowns = new Select(dropdown);
		dropdowns.selectByVisibleText(checkbox);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(checkbox);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		String alertdata = driver.switchTo().alert().getText();
		Assert.assertEquals(alertdata,"Hello Option3, share this practice page and share your knowledge");
		driver.quit();

	}

}
