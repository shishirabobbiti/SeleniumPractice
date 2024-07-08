package com.intro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		// Implict wait ->to wait browser for specified time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Shishira Reddy");
		driver.findElement(By.name("inputPassword")).sendKeys("Hello");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Shishira Reddy");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("joshn@bdns.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();//indexing way
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("johnson@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("5678901234");
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		System.out.println(driver.findElement(By.xpath("//p[@class='infoMsg']")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();//parent-child
		driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("Shishira Reddy");
		driver.findElement(By.xpath("//input[contains(@type,'pass')]")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//div[@class='checkbox-container']/span[1]/input[1]")).click();//parent-child
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();//Regular expression
		
		
	}

}