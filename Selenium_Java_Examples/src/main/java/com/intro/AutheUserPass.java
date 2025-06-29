package com.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutheUserPass{
	   public static void main(String[] args) {
	      //System.setProperty("webdriver.chrome.driver","C:\Users\ghs6kor\Desktop\Java\chromedriver.exe");
	     WebDriver driver=new ChromeDriver();
	      String a = "admin";
	      // appending username, password with URL
	      String s = "https://" + a + ":" + a + "@" +
	      "the-internet.herokuapp.com/basic_auth";
	      driver.get(s);
	      // identify text
	      String m = driver.findElement(By.cssSelector("p")).getText();
	      System.out.println("Text is: " + m);
	      driver.close();
	   }
	}
