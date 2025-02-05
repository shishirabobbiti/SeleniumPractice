package in.ineuron;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}


	public void checkoutPageMethod() {
		waitTillElementAppeared();
	}
}
