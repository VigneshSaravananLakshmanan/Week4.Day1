package week4.Day1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jquery {
	
	/* *******************NOT WORKING ********************* */
	
	public static void main(String[] args) throws InterruptedException
	{
	
		/* Establishing the Web driver */
		WebDriverManager.chromedriver().setup();
		
		/* Launch the Chrome browser */
		
		ChromeDriver driver = new ChromeDriver();
		
		/*  Maximize the window */
		driver.manage().window().maximize();
		
		
		/* Launch the URL */
		driver.navigate().to("https://jqueryui.com/selectable/");
		
		/* Halt for 5 seconds */
		Thread.sleep(5000);
		
		
		// to get into frame
		driver.switchTo().frame(0);
		
		List<WebElement> listBox = driver.findElementsByXPath("//ol[@id='selectable']/li");
		
		
		/* to find the length of values in the list */
		int size = listBox.size();
		
		/* Add the actions class */
		Actions builder = new Actions(driver);
		
		/* click on the control key down */
		builder.keyDown(Keys.CONTROL).perform();
		
		/* Iterate to click only on odd buttons */
		for(int i=1;i<=size;i++)
		{
			if(i%2!=0)
			{
			
			   WebElement selectBox = driver.findElementByXPath("(//ol[@id='selectable']/li)["+i+"]");
			   System.out.println(selectBox.getText());
			   builder.click(selectBox).perform();
			}
			
		}
		
		
		builder.keyUp(Keys.CONTROL).perform();
		
		
		driver.quit();
		

		
	}

}
