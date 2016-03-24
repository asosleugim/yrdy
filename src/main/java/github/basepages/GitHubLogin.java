package github.basepages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import util.SystemUtil;

public class GitHubLogin {

	public static GitHubHomePage signInDefaultUser() throws Exception {

		Properties USER_GIT_HUB = SystemUtil.loadPropertiesResources("testdata_GitHubLoginLogout.properties");
		String email = USER_GIT_HUB.getProperty("email");
		String pwd = USER_GIT_HUB.getProperty("password");

		GitHubHomePage gitHubHomePage = new GitHubHomePage();
		gitHubHomePage.open();
		// Do a time sleep
		GitHubLoginPage gitHubLoginPage = gitHubHomePage.gotoLoginPage();

		TimeUnit.SECONDS.sleep(2);
		return gitHubLoginPage.signIn(email, pwd);
	}
}
