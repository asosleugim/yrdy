package xboxgamertag.basepages;

import java.util.List;

import org.openqa.selenium.WebElement;

public class XboxgamertagSearch {

	public static XboxgamertagHomePage searchLeaderBoardUsers() throws Exception {

		XboxgamertagHomePage xboxgamertagHomePage = new XboxgamertagHomePage();

		XboxgamertagLeaderBoardPage xboxgamertagLeaderBoardPage = xboxgamertagHomePage.searchLeaderBoardUsersPage();

		List<WebElement> topFiveList = xboxgamertagLeaderBoardPage.addLeaderBoardTopFiveElements();

		xboxgamertagLeaderBoardPage.setLeaderBoardTopFiveElements(topFiveList);

		List<String> topFiveList2 = xboxgamertagLeaderBoardPage.addLeaderBoardTopFiveTexts();

		xboxgamertagLeaderBoardPage.setLeaderBoardTopFiveTexts(topFiveList2);

		xboxgamertagHomePage.setXboxgamertagLeaderBoardPage(xboxgamertagLeaderBoardPage);

		return xboxgamertagHomePage;
	}

	public static XboxgamertagHomePage searchDefaultUser() throws Exception {

		XboxgamertagHomePage xboxgamertagHomePage = new XboxgamertagHomePage();

		XboxgamertagUserPage xboxgamertagUserPage = xboxgamertagHomePage.searchUserPage();

		List<WebElement> topFiveGameElementList = xboxgamertagUserPage.addTopFiveGameElements();

		xboxgamertagUserPage.setTopFiveGamesElements(topFiveGameElementList);

		List<String> topFiveGameTextList = xboxgamertagUserPage.addTopFiveGameTexts();

		xboxgamertagUserPage.setTopFiveGameTexts(topFiveGameTextList);

		xboxgamertagHomePage.setXboxgamertagUserPage(xboxgamertagUserPage);

		return xboxgamertagHomePage;

	}
}
