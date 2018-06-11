package blackhills.test.LoginAndSearch;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import blackhills.basepages.BlackHillsInternalLandingPage;
import blackhills.basepages.BlackHillsLogin;
import blackhills.basepages.BlackHillsRequestPage;
import util.TestCaseBase;

public class BlackHillsInternalLoginSearch extends TestCaseBase {

	@Test(groups = { "firefox", "ChromeWin32", "IEWin32" })
	public void testLoginLogout() throws Exception {

		// Login to the Internal Customer Search Landing Page
		BlackHillsInternalLandingPage blackHillsLandingPage = BlackHillsLogin.signInInternalDefaultUser();

		// Test that Login is successful
		Assert.assertTrue(blackHillsLandingPage.isUserSignedIn());

		// Test the Landing page Search Options
		
		blackHillsLandingPage.searchCustomerDetails();

		BlackHillsRequestPage blackHillsRequest = blackHillsLandingPage.selectByRequestOption();
		
		blackHillsRequest.searchRequestDetails();
		
		blackHillsRequest.viewAccountNumberLink();
		
		

		blackHillsLandingPage.logout();

		TimeUnit.SECONDS.sleep(3);

		Assert.assertTrue(!blackHillsLandingPage.isUserSignedIn());

	}
}