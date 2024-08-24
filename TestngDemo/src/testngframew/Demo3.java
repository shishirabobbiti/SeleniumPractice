package testngframew;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo3 {

	
	@Test
	public void Weblogincar() {
		
		System.out.println("Weblogincar_123");
	}
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("Beforeclass");
	}
	@AfterClass
	public void afterclass()
	{
		System.out.println("Afterclass");
	}
	@Test
	public void Mobilelogincar() {
		
		System.out.println("Mobilelogincar");
	}
	
	@Test
	public void APIlogincar() {
		
		System.out.println("APIlogincar");
	}
	
	@BeforeSuite
	public void beforesuite() {
		System.out.println("I am No 1");
	}
	@Parameters({"URL"})
	 @BeforeMethod
	  public void beforemethod(String URL)
	  {
		  System.out.println("will call before every test method");
		  System.out.println(URL);
		  
	  }
	 @AfterMethod
	  public void aftermethod()
	  {
		  System.out.println("will call after every test method");
	  }
	 @Test(groups={"Smoke"})
		public void nissancarloan() {
			
			System.out.println("nissancarloan");
		}
}
