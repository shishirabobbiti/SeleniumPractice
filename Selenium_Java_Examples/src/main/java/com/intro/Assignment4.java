package com.intro;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment4 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("learning");
		driver.findElement(By.xpath("//input[@value='user']")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5000));
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@id='okayBtn']")));

		driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
		WebElement staticdropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByValue("consult");
		driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
		w.until(ExpectedConditions.titleIs("ProtoCommerce"));
		//System.out.println(driver.getTitle());
		List<WebElement> products = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
		for (int i = 0; i < products.size(); i++) {
			products.get(i).click();

		}
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
		driver.quit();
	}

}
