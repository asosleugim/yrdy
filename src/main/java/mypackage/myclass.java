package mypackage;
 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class myclass {
 
    public static void main(String[] args) {
/*        // declaration and instantiation of objects/variables
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://newtours.demoaut.com";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";
 
        // launch Firefox and direct it to the Base URL
        driver.get(baseUrl);
 
        // get the actual value of the title
        actualTitle = driver.getTitle();
 
        
         * compare the actual title of the page witht the expected one and print
         * the result as "Passed" or "Failed"
         
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
        //close Firefox
        driver.close();
        
        // exit the program explicitly
        System.exit(0);*/
    
    /*
        WebDriver driver = new FirefoxDriver();
        
        driver.get("http://www.popuptest.com/popuptest2.html");
        driver.quit();  // using QUIT all windows will close
*/    

/*    
    	   WebDriver driver = new FirefoxDriver();
    	   
           driver.get("http://selenium.googlecode.com/svn/trunk/docs/api/java/index.html");
           driver.switchTo().frame("classFrame");
           driver.findElement(By.linkText("Deprecated")).click();
       //  driver.quit();
           */
           
/*    	// Use the Alert method
        WebDriver driver = new FirefoxDriver();
        String alertMessage = "";
 
        driver.get("http://jsbin.com/usidix/1");
        driver.findElement(By.cssSelector("input[value=\"Go!\"]")).click();
        alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        
        System.out.println(alertMessage);
        driver.quit();*/
    	
/*    	//Locating GUI Elements
        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://www.facebook.com";
        String tagName = "";
 
        driver.get(baseUrl);
        tagName = driver.findElement(By.id("email")).getTagName();
        System.out.println(tagName);
        driver.close();
        System.exit(0);*/
    	
    	//Access GitHub website by sending credentials to UI
    	WebDriver driver = new FirefoxDriver();
    	String baseUrl = "https://github.com/login";
    	driver.get(baseUrl);
    	WebElement login = driver.findElement(By.xpath(".//*[@id='login_field']"));
    	login.sendKeys("asosleugim");
    	WebElement password = driver.findElement(By.name("password"));
    	password.sendKeys("miguelito70");
    	driver.findElement(By.name("password")).submit();
    	
    	
    	// Display in the console the title
    	System.out.println("Title of the page is: " + driver.getTitle());
    
    	// Display all the github links
    	List<WebElement> linkElements = driver.findElements(By.tagName("a"));
    
           //extract the link texts of each link element
        for (WebElement e : linkElements) {
        System.out.println(e.getText());
        }
    
   
    
/*    	WebDriver driver = new FirefoxDriver();
		driver.get("http:/google.com");
		boolean i = driver.findElement(By.linkText("Gmail")).isEnabled();
		System.out.println(i); */
    
    }
    
}