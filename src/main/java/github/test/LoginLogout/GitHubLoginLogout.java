package github.test.LoginLogout;

import org.testng.annotations.Test;

import github.basepages.GitHubHomePage;
import github.basepages.GitHubLogin;
import util.TestCaseBase;

public class GitHubLoginLogout extends TestCaseBase {

	@Test(groups = { "firefox", "ChromeWin32", "IEWin32" })
	public void testLoginLogout() throws Exception {

		GitHubHomePage gitHubHomePage = GitHubLogin.signInDefaultUser();

		// Assert.assertTrue(gitHubHomePage.isUserSignedIn());

	}
}
