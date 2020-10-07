package week4.Day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToysWithTables {

	public static void main(String[] args) throws InterruptedException {
		
		/* IS THERE A WAY TO PREVENT HARDCODiNg to take second column value TR[2] */
		
		/* Set up the WebDriver */
		WebDriverManager.chromedriver().setup();
		
		/* creating an object for the Chrome Driver class */
		
		ChromeDriver driver = new ChromeDriver();
		
		/* maximize the window */
		driver.manage().window().maximize();
		
		/* Launch the URL */
		driver.get("http://leafground.com/pages/table.html");
		
		/* *****************Get the Count of Number of Columns in the table********************** */
		
		List<WebElement> columns = driver.findElementsByXPath("//table[@class='display']//tr/th");
		
		System.out.println("The Columns within the table is "+columns.size());
		
		/* ************************Get the Count of Number of Columns in the table********************* */
		List<WebElement> rows = driver.findElementsByXPath("//table[@class='display']//tr");
		
		int rSize = rows.size();
		
		System.out.println("The row within the table is "+rSize);
		
		
		/* ***************** Get the progress value of Learn to Interact with Elements ****************** */
		/* Identify the position of Progress Header */
		/* taking the progress value - identify the header position of Progress */
		List<WebElement> Header = driver.findElementsByXPath("//table[@id='table_id']//th");
		int headerSize = Header.size();
		
		int count = 0;
		
		for(int j=1;j<=headerSize;j++)
		{
			WebElement header = driver.findElementByXPath("//table//tr/th["+j+"]");
			
			if(header.getText().contains("Progress"))
			{
				System.out.println("The position of Prgress header is "+j);
					count =  j;
					break;
			}
			
		}
		
		
		for(int i=2;i<=rSize;i++)
		{
			WebElement firstRow = driver.findElementByXPath("//table[@class='display']//tr["+i+"]/td");
			String details = firstRow.getText();
			
			
			if(details.contains("Learn to interact with Elements"))
			{
				String value = driver.findElementByXPath("//table[@class='display']//tr["+i+"]/td["+count+"]").getText();
				System.out.println("The progress value of Learn to interact with Elements is "+value);
				break;
			}
		
			
		}
		
		/* Declare a List */
		
		
		
		
		/* ********************** Check the Vital task for least completed progress***************************  */
		/* Declare an Array List to store all the Progress values in the table . The value of Count is 2 which is obtained 
		 * in previous code lines
		 */
		List<String> progressValues = new ArrayList<String>();
		
		for(int k=2;k<=rSize;k++)
		{
			String progress = driver.findElementByXPath("//table//tr["+k+"]/td["+count+"]").getText();
			progressValues.add(progress);    // The values of Progress is added into the List
		}
		System.out.println(progressValues);   // Print the List array
		
		/* declare another List array of int type */
		List<Integer> progressinInt = new ArrayList<Integer>();  // Declaring a second array where the String data type of the "Progress
		                                                         // value list is stored as Integer values in ProgressinInt List
		
		for(String temp:progressValues)
		{
			String removePercent = temp.replaceAll("\\D", "");
			Integer finalValue = Integer.valueOf(removePercent);
		
			progressinInt.add(finalValue);		
			
		}
		
		System.out.println(progressinInt);
		
		Integer minProgressVal = Collections.min(progressinInt); // The min value from the collection is obtained.
		
		String minVal = String.valueOf(minProgressVal);  // Converting again the Integer value into String
		
		System.out.println("The Vital task for least completed progress "+minVal);
		
		
		// The below code is to click on the check box corresponding to the minimum Progress value
		for(int i=2;i<=rSize;i++)
		{
			String prgEachRow = driver.findElementByXPath("//table[@class='display']//tr["+i+"]/td["+count+"]").getText();
			
			
			if(prgEachRow.contains(minVal))
			{
				
				
				
				driver.findElementByXPath("//table[@class='display']//tr["+i+"]/td[3]").click();
				
				
				if(driver.findElementByXPath("//table[@class='display']//tr["+i+"]/td[3]").isSelected())
						{
					System.out.println("The Checkbox corresponding to the "+minVal+" is selected");
						}
				
				
				
			}
		
			
		}
		
		

		
		Thread.sleep(5000);
		
		

		
		
		
		
		driver.close();
		
		
		
		
		

	}

}
