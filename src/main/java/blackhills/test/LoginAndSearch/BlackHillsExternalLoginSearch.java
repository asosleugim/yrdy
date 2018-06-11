package blackhills.test.LoginAndSearch;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import blackhills.basepages.BlackHillsExternalLandingPage;
import blackhills.basepages.BlackHillsLogin;
import util.TestCaseBase;

public class BlackHillsExternalLoginSearch extends TestCaseBase {

	@Test(groups = { "firefox", "ChromeWin32", "IEWin32" })
	public void testLoginLogout() throws Exception {

		BlackHillsExternalLandingPage blackHillsLandingPage = BlackHillsLogin.signInExternalDefaultUser();

		Assert.assertTrue(blackHillsLandingPage.isUserSignedIn());

		blackHillsLandingPage.logout();

		TimeUnit.SECONDS.sleep(3);

		Assert.assertTrue(!blackHillsLandingPage.isUserSignedIn());

	}
}