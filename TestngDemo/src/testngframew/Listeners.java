package testngframew;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
	
	@Override
	 public  void onTestStart(ITestResult result) {
		   // System.out.println("started Listeners");
		  }
   @Override
	public void onTestSuccess(ITestResult result) {
	  // System.out.println("success Listeners");
	    
	  }
	@Override
	public void onTestFailure(ITestResult result) {
		 System.out.println("failure Listeners " + result.getName());
	  }

}
