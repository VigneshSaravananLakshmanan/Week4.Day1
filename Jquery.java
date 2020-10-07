package week4.Day1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Jquery {
	
	
	public static void main(String[] args) throws InterruptedException
	{
	
		/* Establishing the Web driver */
		WebDriverManager.chromedriver().setup();
		
		/* Launch the Chrome browser */
		
		ChromeDriver driver = new ChromeDriver();
		
		/*  Maximize the window */
		driver.manage().window().maximize();
		
		/* To change the resolution to 1920x1080*/
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("resolution", "1920x1080");
		
		/* Implicit wait */
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		/* Launch the URL */
		driver.navigate().to("https://jqueryui.com/selectable/");
		
		
		/* Halt for 5 seconds */
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//This will scroll the page till the element is found		
		js.executeScript("window.scrollBy(0,500)");
		
		
		// to get into frame
		driver.switchTo().frame(0);
		
		List<WebElement> listBox = driver.findElementsByXPath("//ol[@id='selectable']/li");
		
		System.out.println("The elements within the frame is"+" "+listBox);
		
		
		/* to find the length of values in the list */
		int size = listBox.size();
		
		 
		
		//List<WebElement> Element = driver.findElementsByXPath("(//ol[@id='selectable']/li)["+size+"]");
		
		
		
		
		/* Add the actions class */
		Actions builder = new Actions(driver);
		
		
		/* Inorder to select the buttons, as an user - press ctrl down + select button + select ctrl up. These actions are performed
		 * using the actions class
		 * 
		 */
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
		
		/* Close the browser */
		driver.close();
		

		
	}

}
