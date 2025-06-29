package com.intro;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		int rows = driver.findElements(By.xpath("//table[@name='courses']//tr")).size();
		System.out.println("Rows " + rows);
		int columns = driver.findElements(By.xpath("//table[@name='courses']//th")).size();
		System.out.println("Columns " + columns);
		// System.out.println(driver.findElement(By.xpath("//table[@name='courses']//tr
		// [3]")).getText()); //data is printed in single row
		List<WebElement> secondrow = driver.findElements(By.xpath("//table[@name='courses']//tr[3]//td"));
		for (int i = 0; i < secondrow.size(); i++) {
			System.out.println(secondrow.get(i).getText());
		}
//        System.out.println(secondrow.get(0).getText());
//        System.out.println(secondrow.get(1).getText());
//        System.out.println(secondrow.get(2).getText());
//        		
	}

}
