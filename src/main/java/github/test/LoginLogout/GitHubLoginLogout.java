package github.test.LoginLogout;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import github.basepages.GitHubHomePage;
import github.basepages.GitHubLogin;
import util.TestCaseBase;


public class GitHubLoginLogout extends TestCaseBase {

	@Test(groups = { "firefox", "ChromeWin32", "IEWin32" })	
	public void testLoginLogout() throws Exception {

		GitHubHomePage gitHubHomePage = GitHubLogin.signInDefaultUser();

		//Assert.assertTrue(gitHubHomePage.titleIs(GitHubHomePage.TITLE));
		Assert.assertTrue(gitHubHomePage.isUserSignedIn());

		gitHubHomePage.logout();

		TimeUnit.SECONDS.sleep(3);

		Assert.assertTrue(!gitHubHomePage.isUserSignedIn());

	}
}