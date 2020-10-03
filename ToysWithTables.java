package week4.Day1;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToysWithTables {

	public static void main(String[] args) {
		
		/* IS THERE A WAY TO PREVENT HARDCODiNg to take second column value TR[2] */
		
		/* Set up the WebDriver */
		WebDriverManager.chromedriver().setup();
		
		/* creating an object for the Chrome Driver class */
		
		ChromeDriver driver = new ChromeDriver();
		
		/* maximize the window */
		driver.manage().window().maximize();
		
		/* Launch the URL */
		driver.get("http://leafground.com/pages/table.html");
		
		/* Get the Count of Number of Columns in the table */
		
		List<WebElement> columns = driver.findElementsByXPath("//table[@class='display']//tr/th");
		
		System.out.println("The Columns within the table is "+columns.size());
		
		/* Get the Count of Number of Columns in the table */
		List<WebElement> rows = driver.findElementsByXPath("//table[@class='display']//tr");
		
		int rSize = rows.size();
		
		System.out.println("The row within the table is "+rSize);
		
		/* Get the progress value of Learn to contact with elements */
		
		for(int i=2;i<=rSize;i++)
		{
			WebElement firstRow = driver.findElementByXPath("//table[@class='display']//tr["+i+"]/td");
			String details = firstRow.getText();
			
			if(details.contains("Learn to interact with Elements"))
			{
				String value = driver.findElementByXPath("//table[@class='display']//tr["+i+"]/td[2]").getText();
				System.out.println("The progress value of Learn to interact with Elements is "+value);
			}
		
			
		}
		
		driver.quit();
		
		
		
		
		

	}

}
