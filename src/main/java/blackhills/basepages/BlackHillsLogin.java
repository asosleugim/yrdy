package blackhills.basepages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import util.SystemUtil;

public class BlackHillsLogin {

	public static BlackHillsInternalLandingPage signInInternalDefaultUser() throws Exception {

		Properties USER_GIT_HUB = SystemUtil.loadPropertiesResources("testdata_GitHubLoginLogout.properties");
		String email = USER_GIT_HUB.getProperty("email");
		String pwd = USER_GIT_HUB.getProperty("password");

		BlackHillsInternalLandingPage gitHubHomePage = new BlackHillsInternalLandingPage();
		gitHubHomePage.open();
		// Do a time sleep
		BlackHillsLoginPage gitHubLoginPage = gitHubHomePage.gotoLoginPage();

		TimeUnit.SECONDS.sleep(2);
		return gitHubLoginPage.signIn(email, pwd);
	}
	
	public static BlackHillsExternalLandingPage signInExternalDefaultUser() throws Exception {

		Properties USER_GIT_HUB = SystemUtil.loadPropertiesResources("testdata_GitHubLoginLogout.properties");
		String email = USER_GIT_HUB.getProperty("email");
		String pwd = USER_GIT_HUB.getProperty("password");

		BlackHillsExternalLandingPage BHCHomePage = new BlackHillsExternalLandingPage();
		// gitHubHomePage.open();
		// Do a time sleep
		// BlackHillsLoginPage gitHubLoginPage = gitHubHomePage.gotoLoginPage();

		TimeUnit.SECONDS.sleep(2);
		// return gitHubLoginPage.signIn(email, pwd);

		return BHCHomePage;

	}
	
	
}
