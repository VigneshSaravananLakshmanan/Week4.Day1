package week4.Day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
	
  

	public static void main(String[] args) throws InterruptedException {
		
		/* *******************NOT WORKING ********************* */
		
		/* Set up the WebDriver */
		WebDriverManager.chromedriver().setup();
		
		/* creating an object for the Chrome Driver class */
		
		ChromeDriver driver = new ChromeDriver();
		
		/* maximize the window */
		driver.manage().window().maximize();
		
		/* Launch the URL */
		driver.get("https://jqueryui.com/droppable/");
		
		/* Frames can be identified using ID, index, WebElement, name */
		WebElement iFrame = driver.findElementByXPath("//iframe[@class='demo-frame']");
		
		/* Switch the driver control to Frame */
		driver.switchTo().frame(iFrame);
		
		
			/* Identifying the Source */
			WebElement source = driver.findElementById("draggable");
		
			/* identifying the target */
			WebElement target = driver.findElementById("droppable");
		
			
			Thread.sleep(2000);
		
			/* Invoking the Class - Actions to perform User controls */
			Actions builder = new Actions(driver);
			
			
		    /* The action is to drag and drop the source to the drop position. All "actions" should end calling 'perform()'method
		     * to enable the driver to perform action
		     */
		    builder.dragAndDrop(source, target).perform();
		    
		    driver.switchTo().parentFrame();
		    
		    driver.close();
		
		
	
	}

}
