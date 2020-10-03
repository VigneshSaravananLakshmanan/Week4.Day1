package week4.Day1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyTrainNamesAreUnique {

	public static void main(String[] args) throws InterruptedException {
		
		
		/* Set up the WebDriver */
		WebDriverManager.chromedriver().setup();
		
		/* creating an object for the Chrome Driver class */
		
		ChromeDriver driver = new ChromeDriver();
		
		/* maximize the window */
		driver.manage().window().maximize();
		
		/* Launch the URL */
		driver.navigate().to("https://erail.in/");
		
		/* halt for 2 seconds for the page to load */
		Thread.sleep(2000);
		
		/* uncheck the Sort on Date checkbox */
		driver.findElementById("chkSelectDateOnly").click();
		
		/* Verification of checkbox Sort of Date is unchecked*/
		System.out.println("The checkbox for Sort on Date flag is set as : "+driver.findElementById("chkSelectDateOnly").isSelected());
		
		
		/* type "ms"in the from station text field */
		driver.findElementById("txtStationFrom").clear();
		driver.findElementById("txtStationFrom").sendKeys("ms");
		driver.findElementById("txtStationFrom").sendKeys(Keys.TAB);
		
		/* type "mdu" in the To station text field */
		driver.findElementById("txtStationTo").clear();
		driver.findElementById("txtStationTo").sendKeys("mdu");
		driver.findElementById("txtStationTo").sendKeys(Keys.TAB);
		
		/* Wait for 2 seconds */
		Thread.sleep(2000);
		
		
		
		/* to find the number of rows in the table */
		int trainCount = driver.findElementsByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr").size();
		
		/* Declaring a List */
		List<String>listTrain = new ArrayList<String>();
		
		
		
		for(int i=1;i<=trainCount;i++)
		{
			String TempTrain = driver.findElementByXPath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]").getText();
			listTrain.add(TempTrain);
		
		}
		
		/* Print the train names from list */
		System.out.println("The trains listed in the List table is "+listTrain);
		
		/* Count the elements in the list */
		int ListSize = listTrain.size();
		
		/* As Set does not hold any duplicate values, Create a Set and copy the details from the List */
		Set<String>setTrain = new LinkedHashSet<String>(listTrain);
		
		/* Print the train names from Set */
		System.out.println("The trains listed in the Set table is "+setTrain);
		
		/* Count the elements in the list */
		int setSize = setTrain.size();
		
		
		/* compare the count of List and Set Elements */
		if(ListSize==setSize)
		{
			System.out.println("The table did not hold any duplicate entries");
		}
		else
		{
			System.out.println("The table holds duplicate entries");
		}
		
		

	}

}
