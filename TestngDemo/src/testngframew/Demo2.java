package testngframew;

import org.testng.annotations.Test;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo2 {
	
	@Test
	public void thirdtest()
	{
		System.out.println("Good");
	}
  @AfterSuite
  public void aftersuite()
  {
	  System.out.println("i am no last");
  }
 
}
