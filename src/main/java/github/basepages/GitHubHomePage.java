package github.basepages;

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

public class GitHubHomePage extends Page {
	
	public static String TITLE="GitHub";

	@FindBy(className = "main-content")
	public WebElement mainClassName;

	@FindBy(xpath = ".//*[@id='user-links']/li[3]/div/div/form/button")
	public WebElement logout_goofy;
	
	@FindBy(className = "header-nav-link name tooltipped tooltipped-sw js-menu-target")
	public WebElement testLogout;

	public GitHubHomePage open() throws Exception {
		// read the url from property file
		Properties PROPERTIES_RESOURCES = SystemUtil.loadPropertiesResources("/testdata_github.properties");
		String URL = PROPERTIES_RESOURCES.getProperty("github.url");
		TestCaseBase.threadDriver.get().navigate().to(URL);

		return this;
	}

	// goto sign in page
	public GitHubLoginPage gotoLoginPage() throws Exception {

		// read the url from property file
		Properties PROPERTIES_RESOURCES = SystemUtil.loadPropertiesResources("/testdata_github.properties");
		String LoginURL = PROPERTIES_RESOURCES.getProperty("github.login");

		TestCaseBase.threadDriver.get().navigate().to(LoginURL);
		TimeUnit.SECONDS.sleep(2);
		return new GitHubLoginPage();
	}

	// use this method to wait until the page loads.
	// usually it is not the page loads but a specific element loads
	// here we use loginLink, because our test cases need to use this link
	// so if this link is visible, the test cases can continue
	public GitHubHomePage waitPageLoad() throws InterruptedException {
		// Thread.sleep(2000);
		// Waiting.implicitly(2);

		/*
		 * if (FunctionUtil.isExist(pageLoad)) { Waiting.until(pageLoad,5000); }
		 * else if (FunctionUtil.isExist(pageLoad_symbol_failure)) {
		 * Waiting.until(pageLoad_symbol_failure,5000); } else if
		 * (FunctionUtil.isExist(pageLoad_goofy)) {
		 * Waiting.until(pageLoad_goofy,5000); }
		 */

		return this;
	}

	// this is for assertion. checking if user is signed in
	public boolean isUserSignedIn() {
		// String browserFlag = TestCaseBase.browserFlag;
		boolean result = false;

		if (FunctionUtil.isExist(mainClassName)) {
			result = true;
		}
		return result;

	}

	// sign out
	public GitHubHomePage logout() throws InterruptedException {
		
		
		
	//	WebElement elem = yourWebDriverInstance.findElement(By.xpath("//*[@class='goog-menu goog-menu-vertical uploadmenu density-tiny']/input"));
		String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";

		
		if (TestCaseBase.threadDriver.get().findElements(By.className("header-nav-link name tooltipped tooltipped-sw js-menu-target")).size() > 0) {
	//	if (TestCaseBase.threadDriver.get().findElements(By.xpath(".//*[@id='user-links']/li[3]/div/div/form/button")).size() > 0) {

			((JavascriptExecutor) TestCaseBase.threadDriver.get()).executeScript(js, testLogout);
			testLogout.click();
			TimeUnit.SECONDS.sleep(3);
			
			//logout_goofy.click();

		}
		return this;
	}
}