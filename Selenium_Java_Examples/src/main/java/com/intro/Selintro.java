package com.intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selintro {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		// WebDriver driver=new EdgeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}

}
