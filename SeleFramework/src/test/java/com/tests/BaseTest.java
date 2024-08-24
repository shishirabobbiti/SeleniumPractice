package com.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pageobjects.HomePage;



public class BaseTest {
	
	public WebDriver driver;
	public HomePage homePage;

	public WebDriver intializationDriver()
	{
		Properties	properties = new Properties();
    try (InputStream input = new FileInputStream("src\\main\\java\\com\\resources\\GlobalData.properties")) {
	properties.load(input);
	String browserName = properties.getProperty("browser");
	
	if (browserName.equals("chrome")) {	
		ChromeOptions options=new ChromeOptions();
		options.addArguments("headless");
	
		driver = new ChromeDriver(options);
	} else if (browserName.equals("Firefox")) {
		driver = new FirefoxDriver();

	} else if (browserName.equals("Edge")) {
		driver = new EdgeDriver();
	}

	PageFactory.initElements(driver, this);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	

} 
    catch (IOException e) {
	System.out.println("GlobalData File is not available");

}
	return driver;
	} 
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//read json to string
	String jsonContent = 	FileUtils.readFileToString(new File(filePath), 
			StandardCharsets.UTF_8);
	
	//String to HashMap- Jackson Databind
	
	ObjectMapper mapper = new ObjectMapper();
	  List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
      });
	  return data;
	
	//{map, map}

	}
	
	public String getScreenshot(String testcaseName,WebDriver driver) throws IOException {
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		File destFile=new File(System.getProperty("user.dir")+"//reports//" +testcaseName+ ".png");
	    FileUtils.copyFile(sourceFile, destFile);
		return System.getProperty("user.dir")+"//reports//" +testcaseName+ ".png";
		
	}
	@BeforeMethod(alwaysRun=true)
    public HomePage launchApplication() {
    	
      	driver=intializationDriver();
		homePage = new HomePage(driver);
		homePage.goTo();
		return homePage;
    }
    	
   @AfterMethod(alwaysRun=true)
   public void tearDown() {
	   
	   driver.quit();
	   
   }
	
    }

