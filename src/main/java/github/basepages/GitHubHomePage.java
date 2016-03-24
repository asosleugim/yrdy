package github.basepages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import util.SystemUtil;
import util.TestCaseBase;;

public class GitHubHomePage {

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
}
