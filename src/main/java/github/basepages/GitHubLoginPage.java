package github.basepages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Page;
import util.Waiting;

public class GitHubLoginPage extends Page {

	public static String TITLE = "Sign in to GitHub · GitHub";

	@FindBy(id = "login_field")
	public WebElement input_email;

	@FindBy(id = "password")
	public WebElement input_pass;

	@FindBy(name = "password")
	public WebElement button_submit;

	public GitHubHomePage signIn(String usr, String pwd) throws Exception {
		TimeUnit.SECONDS.sleep(2);
		input_email.sendKeys(usr);

		input_pass.sendKeys(pwd);

		button_submit.submit();

		return new GitHubHomePage();
	}

	public GitHubLoginPage waitPageLoad() throws InterruptedException {
		Waiting.until(button_submit);
		return this;
	}

}
