package com.intro;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment3 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
	    
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Maruthi");
		//driver.findElement(By.xpath("//input[@class='form-control ng-pristine ng-invalid ng-touched']")).sendKeys("Maruthi");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Maruthi03@gmail.com");
		driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("Maruthi");
		driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
		WebElement Genderdropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown=new Select(Genderdropdown);
		dropdown.selectByVisibleText("Female");
		driver.findElement(By.xpath("//input[@id='inlineRadio2']")).click();
		driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("01/21/2000");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		//System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText(), "×" + "\n" +
				 "Success! The Form has been submitted successfully!.");
		
	}

}
