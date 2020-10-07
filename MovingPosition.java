package week4.Day1;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MovingPosition {
	

	
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/* Set up the WebDriver */
		WebDriverManager.chromedriver().setup();
		
		/* creating an object for the Chrome Driver class */
		
		ChromeDriver driver = new ChromeDriver();
		
		/* maximize the window */
		driver.manage().window().maximize();
		
		
		/* Launch the URL */
		driver.get("https://jqueryui.com/sortable/");
		
		/* halt for 3 seconds */
		Thread.sleep(3000);
		
		/* Invoke Java Script Executor to move the elements up */
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		/* Switching to Frame using Index. */
		driver.switchTo().frame(0);
		
		/* collating all the webelements */
		List<WebElement> items = driver.findElementsByXPath("//li[contains(text(),'Item')]");
		
		/* Printing the elements identified */
		for(WebElement item:items)
		{
			System.out.println(item.getText());
		}
		
		
		/*
		 Identify the Source and Target Element */
		WebElement item1 = driver.findElementByXPath("//li[text()='Item 1']");
		WebElement item4 = driver.findElementByXPath("//li[text()='Item 4']");
		
		Point location = item4.getLocation();
		
		int xPoint = location.getX();
		int yPoint = location.getY();
		
		 /* Invoking the Actions Class */
		Actions builder = new Actions(driver);
		
		/* Moving the position of Item1 to Item4 location */
		builder.dragAndDropBy(item1, xPoint, yPoint).perform();
		
		
		System.out.println(items.get(3).getText());
		
		
		
	}

}
