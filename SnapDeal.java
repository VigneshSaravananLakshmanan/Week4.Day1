package week4.Day1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {
	
	/* *******************NOT WORKING ********************* */
	
	public static void main(String[] args) throws InterruptedException {
	
	/* Set up the WebDriver */
	WebDriverManager.chromedriver().setup();
	
	/* creating an object for the Chrome Driver class */
	
	ChromeDriver driver = new ChromeDriver();
	
	/* maximize the window */
	driver.manage().window().maximize();
	
	/* Launch the URL */
	driver.get("https://www.snapdeal.com/");
	
	/* Wait for 2 seconds for the page to load */
	Thread.sleep(2000);
	
	/* Identified the Web Element */
	WebElement mFashion = driver.findElementByXPath("//a[@class='menuLinks leftCategoriesProduct ']/following::li[@class='navlink lnHeight']//span[@class='catText']");
	
	/* Find the Shirts element */
	WebElement Shirts = driver.findElementByXPath("(//span[text()='Shirts'])[2]");
	
	/* Find the first listed element in the navigated page */
	WebElement firstElement = driver.findElementByXPath("//section[@data-dpdit='h_lst']/div[@data-js-pos='0']/div[2]/div/div]");
	
	
	/* invoking Action Class */
	Actions builder = new Actions(driver);
	
	/* Navigate to Shirt Section */
	builder.moveToElement(mFashion).click().moveToElement(Shirts).click().perform();

	
	/* Wait for 2 seconds for the page to get loaded */
	Thread.sleep(5000);
	
	/* Click on the first element and click on Quick view */
	builder.moveToElement(firstElement).click().perform();
	
	/* Close current browser */ 
	driver.close();
	
	/* To close all the browser */ 
    driver.quit();
	
	}
}
