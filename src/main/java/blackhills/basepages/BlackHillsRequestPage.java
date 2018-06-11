package blackhills.basepages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.FunctionUtil;
import util.Page;

public class BlackHillsRequestPage extends Page {

	public final static String ACCOUNT_NUMBER = "123456789";
	public final static String SERVICE_REQUEST = "123456789";
	public final static String STREET_NUMBER = "1231114444";
	public final static String STREET_NAME = "Main Street";
	public final static String CITY = "Houston";
	public final static String STATE = "Texas";
	
	@FindBy(className = "this will test the request search")
	public WebElement requestSearch;
	
	@FindBy(className = "this will test the customer search")
	public WebElement customerSearch;
	
	@FindBy(className = "this will be the link id for account number")
	public WebElement accountNumber;
	
	@FindBy(className = "this will be the link id for account number")
	public WebElement requestNumber;
	
	@FindBy(className = "this will be the link id for account number")
	public WebElement streetNumber;
	
	@FindBy(className = "this will be the link id for account number")
	public WebElement streetName;
	
	@FindBy(className = "this will be the link id for account number")
	public WebElement city;
	
	@FindBy(className = "this will be the link id for account number")
	public WebElement state;
	
	@FindBy(className = "this will test to submit button")
	public WebElement searchButton;
	
	@FindBy(className = "this will test the clear button")
	public WebElement clearButton;
	
	@FindBy(className = "this will be the link id for account number")
	public WebElement accountNumberLink;
	
	@FindBy(className = "this will be the link id for account number")
	public WebElement requestNumberLink;
	
	
	public BlackHillsRequestPage selectByRequestOption() {
		requestSearch.click();

		return new BlackHillsRequestPage();
	}
	
	public BlackHillsInternalLandingPage selectByCustomerOption() {
		customerSearch.click();

		return new BlackHillsInternalLandingPage();
	}
	

	public void searchRequestDetails() throws InterruptedException{
		
		searchRequestByAccountNumber();
		
		searchRequestByRequestNumber();
		
		searchRequestByCityAndState();
		

		
	}
	
	public void searchRequestByAccountNumber() throws InterruptedException{
		
		accountNumber.sendKeys(ACCOUNT_NUMBER);
		
		searchButton.click();
		
		timeLoading();
		
		clearButton.click();
		
	}
	
	public void searchRequestByRequestNumber() throws InterruptedException{
		
		city.sendKeys(SERVICE_REQUEST);
		
		searchButton.click();
		
		timeLoading();
		
		clearButton.click();
		
	}
	
	public void searchRequestByCityAndState() throws InterruptedException{
		
		city.sendKeys(CITY);
		
		state.sendKeys(STATE);
		
		searchButton.click();
		
		timeLoading();
		
		clearButton.click();
		
	}
	// This will take us to the Account Number View Details page
	public void viewAccountNumberLink(){
		
		accountNumberLink.click();
		
	}
	
	// This will take us to the Account Number View Details page
	public void viewRequestNumberLink(){
		
		requestNumberLink.click();
		
	}
	// use this method to wait until the page loads.
	// usually it is not the page loads but a specific element loads
	// here we use loginLink, because our test cases need to use this link
	// so if this link is visible, the test cases can continue
	public BlackHillsRequestPage waitPageLoad() throws InterruptedException {

		return this;
	}

	
	public void timeLoading() throws InterruptedException{
		
		TimeUnit.SECONDS.sleep(5);
	}

	// sign out
	public BlackHillsRequestPage logout() throws InterruptedException {

		return this;
	}


}
