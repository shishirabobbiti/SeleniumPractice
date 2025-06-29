package com.intro;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class StreamDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//th[@aria-label='Veg/fruit name: activate to sort column ascending']")).click();
		// capture all the webelements into list
		List<WebElement> veggies = driver.findElements(By.xpath("//tr//td[1]"));
		// capture text of all webelements into new (original)list
		List<String> originallist = veggies.stream().map(s -> s.getText()).collect(Collectors.toList());
		System.out.println(originallist);
		// sort of all original list by step 3->sorted list
		List<String> sortedlist = originallist.stream().sorted().collect(Collectors.toList());
		// compare two lists
		// Assert.assertEquals(originallist, sortedlist);
		Assert.assertTrue(originallist.equals(sortedlist));
		// scan the name column with getText ->Beans->print the price of the Rice
		List<String> price;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr//td[1]"));

			price = rows.stream().filter(s -> s.getText().contains("Strawberry")).map(s -> getpriceveggie(s))

					.collect(Collectors.toList());
			price.forEach(a -> System.out.println(a)); // to perform actions on every object
			price.forEach(a -> {
				a = a + "Maruthi";
				System.out.println(a);
			});
			price.forEach(System.out::println); // to print the Groups of objects
			if (price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while (price.size() < 1);
	}

	private static String getpriceveggie(WebElement s) {

		String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}
