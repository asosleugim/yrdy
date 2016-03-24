package yrdy.yrdy;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testClass {

	public static void main(String[] args) throws InterruptedException {
		// objects and variables instantiation
		WebDriver driver = new FirefoxDriver();
		String appUrl = "https://accounts.google.com";
		// launch the firefox browser and open the application url
		driver.get(appUrl);
		// maximize the browser window
		 driver.manage().window().maximize();
		// declare and initialize the variable to store the expected title of
		// the webpage.

		// enter a valid username in the email textbox
		driver.findElement(By.id("Email")).sendKeys("tommywei101@gmail.com");
		driver.findElement(By.id("next")).click();
		TimeUnit.SECONDS.sleep(1);
		// enter a valid password in the password textbox
		driver.findElement(By.id("Passwd")).sendKeys("Zhiwu67!");
		driver.findElement(By.id("signIn")).click();

	}
}