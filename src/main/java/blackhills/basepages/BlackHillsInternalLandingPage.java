package blackhills.basepages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.FunctionUtil;
import util.Page;
import util.SystemUtil;
import util.TestCaseBase;



public class BlackHillsInternalLandingPage extends Page {
	public final static String ACCOUNT_NUMBER = "123456789";
	public final static String LASTNAME_COMPNAME = "DELL";
	public final static String PHONE_NUMBER = "1231114444";
	
	
	@FindBy(className = "main-content")
	public WebElement mainClassNameInternal;
	
	@FindBy(className = "main-content")
	public WebElement mainClassNameExternal;
	
	@FindBy(className = "this will test the request search")
	public WebElement requestSearch;
	
	@FindBy(className = "this will test the customer search")
	public WebElement customerSearch;
	
	@FindBy(xpath = ".//*[@id='user-links']/li[3]/div/div/form/button")
	public WebElement accountNumber;
	
	@FindBy(className = "this will test the request search")
	public WebElement lastNameOrCompanyName;
	
	@FindBy(className = "this will test the customer search")
	public WebElement phoneNumber;
	
	@FindBy(className = "this will test to submit button")
	public WebElement searchButton;
	
	@FindBy(className = "this will test the clear button")
	public WebElement clearButton;
	
	@FindBy(className = "this will be the link id for account number")
	public WebElement accountNumberLink;

	public BlackHillsInternalLandingPage open() throws Exception {
		// read the url from property file
		Properties PROPERTIES_RESOURCES = SystemUtil.loadPropertiesResources("/testdata_github.properties");
		String URL = PROPERTIES_RESOURCES.getProperty("github.url");
		TestCaseBase.threadDriver.get().navigate().to(URL);

		return this;
	}
	
	public BlackHillsRequestPage selectByRequestOption() {
		requestSearch.click();

		return new BlackHillsRequestPage();
	}
	
	public BlackHillsInternalLandingPage selectByCustomerOption() {
		customerSearch.click();

		return new BlackHillsInternalLandingPage();
	}

	// goto sign in page
	public BlackHillsLoginPage gotoLoginPage() throws Exception {

		// read the url from property file
		Properties PROPERTIES_RESOURCES = SystemUtil.loadPropertiesResources("/testdata_github.properties");
		String LoginURL = PROPERTIES_RESOURCES.getProperty("github.login");

		TestCaseBase.threadDriver.get().navigate().to(LoginURL);
		TimeUnit.SECONDS.sleep(2);
		return new BlackHillsLoginPage();
	}
	
	public void searchCustomerDetails() throws InterruptedException{
		
		searchCustomerDetailsByAccount();
		searchCustomerDetailsByLastName();
		searchCustomerDetailsByPhoneNumber();
		
	}
	
	public void searchCustomerDetailsByAccount() throws InterruptedException {

		accountNumber.sendKeys(ACCOUNT_NUMBER);
		
		searchButton.click();
		
		timeLoading();
		
		clearButton.click();
		
	}
	
	public void searchCustomerDetailsByLastName() throws InterruptedException {

		lastNameOrCompanyName.sendKeys(LASTNAME_COMPNAME);
		
		searchButton.click();
		
		timeLoading();
		
		clearButton.click();
		
	}
	
	public void searchCustomerDetailsByPhoneNumber() throws InterruptedException {

		phoneNumber.sendKeys(PHONE_NUMBER);
		
		searchButton.click();
		
		timeLoading();
		
	}

	// This will take us to the Account Number View Details page
	public void viewAccountNumberLink(){
		
		accountNumberLink.click();
		
	}
	// use this method to wait until the page loads.
	// usually it is not the page loads but a specific element loads
	// here we use loginLink, because our test cases need to use this link
	// so if this link is visible, the test cases can continue
	public BlackHillsInternalLandingPage waitPageLoad() throws InterruptedException {

		return this;
	}

	// this is for assertion. checking if user is signed in
	public boolean isUserSignedIn() {
		// String browserFlag = TestCaseBase.browserFlag;
		boolean result = false;

		if (FunctionUtil.isExist(mainClassNameInternal)) {
			result = true;
		} else if (FunctionUtil.isExist(mainClassNameExternal)) {
			result = true;
		}
		return result;

	}
	
	public void timeLoading() throws InterruptedException{
		
		TimeUnit.SECONDS.sleep(5);
	}

	// sign out
	public BlackHillsInternalLandingPage logout() throws InterruptedException {

		return this;
	}
}