package xboxgamertag.basepages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Page;
import util.SystemUtil;

public class XboxgamertagLeaderBoardPage extends Page {

	List<WebElement> topFiveListElements;

	List<String> topFiveListTexts;

	@FindBy(linkText = "Stallion83")
	public WebElement leaderOne;

	@FindBy(linkText = "smrnov")
	public WebElement leaderTwo;

	@FindBy(linkText = "Celtic Force")
	public WebElement leaderThree;

	@FindBy(linkText = "MRMAGNIFICENT25")
	public WebElement leaderFour;

	@FindBy(linkText = "Neverland Mods")
	public WebElement leaderFive;

	public List<WebElement> addLeaderBoardTopFiveElements() {

		List<WebElement> leaderBoardTopFive = new ArrayList<WebElement>();
		leaderBoardTopFive.add(leaderOne);
		leaderBoardTopFive.add(leaderTwo);
		leaderBoardTopFive.add(leaderThree);
		leaderBoardTopFive.add(leaderFour);
		leaderBoardTopFive.add(leaderFive);

		return leaderBoardTopFive;

	}

	public List<String> addLeaderBoardTopFiveTexts() {

		Properties PROPERTIES_RESOURCES = SystemUtil
				.loadPropertiesResources("/testdata_XboxgamertagLeaderBoardUsers.properties");
		String leaderOne = PROPERTIES_RESOURCES.getProperty("xboxgamertag.leaderboard1");
		String leaderTwo = PROPERTIES_RESOURCES.getProperty("xboxgamertag.leaderboard2");
		String leaderThree = PROPERTIES_RESOURCES.getProperty("xboxgamertag.leaderboard3");
		String leaderFour = PROPERTIES_RESOURCES.getProperty("xboxgamertag.leaderboard4");
		String leaderFive = PROPERTIES_RESOURCES.getProperty("xboxgamertag.leaderboard5");

		List<String> topFiveList = new ArrayList<String>();
		topFiveList.add(leaderOne);
		topFiveList.add(leaderTwo);
		topFiveList.add(leaderThree);
		topFiveList.add(leaderFour);
		topFiveList.add(leaderFive);
		return topFiveList;
	}

	public void setLeaderBoardTopFiveElements(List<WebElement> topFiveListElements) {
		this.topFiveListElements = topFiveListElements;
	}

	public void setLeaderBoardTopFiveTexts(List<String> topFiveListTexts) {
		this.topFiveListTexts = topFiveListTexts;
	}

	public List<WebElement> getLeaderBoardTopFiveElements() {
		return topFiveListElements;
	}

	public List<String> getLeaderBoardTopFiveTexts() {
		return topFiveListTexts;
	}

	public Boolean compareLeaderBoard(ArrayList<WebElement> currentListOne, List<String> currentListTwo) {

		Boolean isTopFive = true;

		for (WebElement element : currentListOne) {
			if (!(currentListTwo.contains(element.getText())))
				isTopFive = false;
		}

		return isTopFive;

	}

}