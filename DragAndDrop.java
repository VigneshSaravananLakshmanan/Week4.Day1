package week4.Day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) {
		
		/* *******************NOT WORKING ********************* */
		
		/* Set up the WebDriver */
		WebDriverManager.chromedriver().setup();
		
		/* creating an object for the Chrome Driver class */
		
		ChromeDriver driver = new ChromeDriver();
		
		/* maximize the window */
		driver.manage().window().maximize();
		
		/* Launch the URL */
		driver.get("https://jqueryui.com/droppable/");
		
		
		/* Identifying the Source */
		WebElement source = driver.findElementById("draggable");
		
		/* identifying the target */
		WebElement target = driver.findElementById("droppable");
		
		
		/* Invoking the Class */
		Actions builder = new Actions(driver);
		
		builder.dragAndDrop(source, target).perform();
		
		
		
	
	}

}
