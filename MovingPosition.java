package week4.Day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MovingPosition {
	
	/* *******************NOT WORKING ********************* */
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Set up the WebDriver */
		WebDriverManager.chromedriver().setup();
		
		/* creating an object for the Chrome Driver class */
		
		ChromeDriver driver = new ChromeDriver();
		
		/* maximize the window */
		driver.manage().window().maximize();
		
		/* Launch the URL */
		driver.get("https://jqueryui.com/sortable/");
		
		/* Identify the Source and Target Element */
		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement item4 = driver.findElementByXPath("//li[text()='Item 4']");
		
		/* Invoking the Actions Class */
		Actions builder = new Actions(driver);
		
		builder.clickAndHold(item1).moveToElement(item4).release().perform();
		
		

	}

}
