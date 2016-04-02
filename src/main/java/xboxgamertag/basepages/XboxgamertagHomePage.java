package xboxgamertag.basepages;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Page;
import util.SystemUtil;
import util.TestCaseBase;

public class XboxgamertagHomePage extends Page {

	XboxgamertagLeaderBoardPage xboxgamertagLeaderBoardPage;

	XboxgamertagUserPage xboxgamertagUserPage;

	@FindBy(xpath = ".//*[@id='Menu']/li[5]/a")
	public WebElement search_leaderBoardUsers;

	@FindBy(xpath = ".//*[@id='mainSearch']/input[1]")
	public WebElement lookup_user;

	@FindBy(id = "mainSearch")
	public WebElement submit;

	public void openHomePage() throws Exception {
		// read the url from property file
		Properties PROPERTIES_RESOURCES = SystemUtil.loadPropertiesResources("/testdata_xboxgamertag.properties");
		String URL = PROPERTIES_RESOURCES.getProperty("xboxgamertag.url");
		TestCaseBase.threadDriver.get().navigate().to(URL);
	}

	public XboxgamertagLeaderBoardPage searchLeaderBoardUsersPage() throws Exception {

		openHomePage();

		search_leaderBoardUsers.click();

		TimeUnit.SECONDS.sleep(3);

		return new XboxgamertagLeaderBoardPage();

	}

	public XboxgamertagUserPage searchUserPage() throws Exception {

		openHomePage();

		lookup_user.sendKeys("Duskamo");

		submit.submit();

		TimeUnit.SECONDS.sleep(3);

		return new XboxgamertagUserPage();
	}

	public boolean compareLeaderBoard() {

		List<WebElement> currentListElements = xboxgamertagLeaderBoardPage.getLeaderBoardTopFiveElements();
		List<String> currentListTexts = xboxgamertagLeaderBoardPage.getLeaderBoardTopFiveTexts();

		boolean isTopFive = true;

		for (WebElement element : currentListElements) {
			if (!(currentListTexts.contains(element.getText()))) {
				isTopFive = false;
				break;
			}
		}

		return isTopFive;

	}

	public boolean compareGameBoard() {

		List<WebElement> currentListElements = xboxgamertagUserPage.getTopFiveGamesElements();
		List<String> currentListTexts = xboxgamertagUserPage.getTopFiveGameTexts();

		boolean isTopFive = true;

		for (WebElement element : currentListElements) {
			if (!(currentListTexts.contains(element.getText()))) {
				isTopFive = false;
				break;
			}
		}

		return isTopFive;

	}

	public XboxgamertagLeaderBoardPage getXboxgamertagLeaderBoardPage() {
		return xboxgamertagLeaderBoardPage;
	}

	public void setXboxgamertagLeaderBoardPage(XboxgamertagLeaderBoardPage xboxgamertagLeaderBoardPage) {
		this.xboxgamertagLeaderBoardPage = xboxgamertagLeaderBoardPage;
	}

	public XboxgamertagUserPage getXboxgamertagUserPage() {
		return xboxgamertagUserPage;
	}

	public void setXboxgamertagUserPage(XboxgamertagUserPage xboxgamertagUserPage) {
		this.xboxgamertagUserPage = xboxgamertagUserPage;
	}

}