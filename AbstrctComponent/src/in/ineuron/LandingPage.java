package in.ineuron;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		System.out.println("LandingPage.LandingPage()");
	}
	
	public void landingMethod() {
		waitTillElementAppeared();
		CheckoutPage c=new CheckoutPage(driver);
		c.checkoutPageMethod();
	}
	
}
