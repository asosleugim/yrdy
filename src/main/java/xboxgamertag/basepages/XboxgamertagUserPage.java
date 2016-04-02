package xboxgamertag.basepages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import util.Page;
import util.SystemUtil;

public class XboxgamertagUserPage extends Page {

	List<WebElement> topFiveGamesElements;

	List<String> topFiveGameTexts;

	@FindBy(linkText = "DARK SOULS II")
	public WebElement gameOne;

	@FindBy(linkText = "Skyrim")
	public WebElement gameTwo;

	@FindBy(linkText = "AC Revelations")
	public WebElement gameThree;

	@FindBy(linkText = "Minecraft")
	public WebElement gameFour;

	@FindBy(linkText = "UFC® Undisputed\u2122 3")
	public WebElement gameFive;

	public List<WebElement> addTopFiveGameElements() {

		List<WebElement> leaderBoardTopFive = new ArrayList<WebElement>();
		leaderBoardTopFive.add(gameOne);
		leaderBoardTopFive.add(gameTwo);
		leaderBoardTopFive.add(gameThree);
		leaderBoardTopFive.add(gameFour);
		leaderBoardTopFive.add(gameFive);

		return leaderBoardTopFive;

	}

	public List<String> addTopFiveGameTexts() {

		Properties PROPERTIES_RESOURCES = SystemUtil
				.loadPropertiesResources("/testdata_XboxgamertagUserSearch.properties");
		String gameOne = PROPERTIES_RESOURCES.getProperty("xboxgamertag.game1");
		String gameTwo = PROPERTIES_RESOURCES.getProperty("xboxgamertag.game2");
		String gameThree = PROPERTIES_RESOURCES.getProperty("xboxgamertag.game3");
		String gameFour = PROPERTIES_RESOURCES.getProperty("xboxgamertag.game4");
		String gameFive = PROPERTIES_RESOURCES.getProperty("xboxgamertag.game5");

		List<String> topFiveList = new ArrayList<String>();
		topFiveList.add(gameOne);
		topFiveList.add(gameTwo);
		topFiveList.add(gameThree);
		topFiveList.add(gameFour);
		topFiveList.add(gameFive);
		return topFiveList;
	}

	public List<WebElement> getTopFiveGamesElements() {
		return topFiveGamesElements;
	}

	public void setTopFiveGamesElements(List<WebElement> topFiveGamesElements) {
		this.topFiveGamesElements = topFiveGamesElements;
	}

	public List<String> getTopFiveGameTexts() {
		return topFiveGameTexts;
	}

	public void setTopFiveGameTexts(List<String> topFiveGameTexts) {
		this.topFiveGameTexts = topFiveGameTexts;
	}

}
