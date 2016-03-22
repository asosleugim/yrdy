package mypackage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LindaDong {
	public WebDriver driver;

	@BeforeClass
	public void setup() {
		this.driver = new FirefoxDriver();
		driver.get("http://www.lindadong.com");
	}

	@AfterClass
	public void stop() {
		this.driver.quit();
	}
	
	@Test
	public void testTitle(){
		
		
		Assert.assertEquals(driver.getTitle(), "Linda Dong", "Incorrect");
	}

	@Test
	public void loadPage() {
		List<WebElement> elements = driver.findElements(By.tagName("strong"));

		// Location 1 Stylus Design
		// Location 2 Surface Design
		// Location 3 Drawing

		List<String> expectedWebElementsText = new ArrayList<String>();
		expectedWebElementsText.add("Stylus Design");
		expectedWebElementsText.add("Surface Design");
		expectedWebElementsText.add("Drawing");

		List<String> webElementsText = new ArrayList<String>();
		webElementsText.add(elements.get(0).getText());
		webElementsText.add(elements.get(1).getText());
		webElementsText.add(elements.get(2).getText());

		Assert.assertEquals(webElementsText, expectedWebElementsText, "Incorrect Text Elements");


		for (WebElement element : elements) {
				System.out.println(element.getText());
		}

	}
	@Test
	public void testingGroups(){
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
	   int linkElementsSize = linkElements.size();
	   Assert.assertEquals(58, linkElementsSize);

	}

}