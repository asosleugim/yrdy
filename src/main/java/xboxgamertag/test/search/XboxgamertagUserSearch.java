package xboxgamertag.test.search;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.TestCaseBase;
import xboxgamertag.basepages.XboxgamertagHomePage;
import xboxgamertag.basepages.XboxgamertagSearch;

public class XboxgamertagUserSearch extends TestCaseBase {

	@Test(groups = { "firefox", "ChromeWin32", "IEWin32" })
	public void testUserSearchPage() throws Exception {

		XboxgamertagHomePage xboxgamertagHomePage = XboxgamertagSearch.searchLeaderBoardUsers();

		Assert.assertTrue(xboxgamertagHomePage.compareLeaderBoard());

		xboxgamertagHomePage = XboxgamertagSearch.searchDefaultUser();

		Assert.assertTrue(xboxgamertagHomePage.compareGameBoard());

	}

}
