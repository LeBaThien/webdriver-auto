package org.web.automation.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TC_005_Registration_Radio_Checkbox{
	ChromeDriver driver;
	
	 @BeforeMethod
	 public void startBrowser(){
			
			System.setProperty("webdriver.chrome.driver", "/home/lebathien/Documents/crawling"
					+ "/working_with_eclipse/WebDriverAutomationProject-1/WebDriverAutomationProject/Driver/chromedriver");
			driver = new ChromeDriver();   // Browser Will start
			driver.manage().window().maximize();                   // Maximizing browser window
			driver.get("https://thetestingworld.com/testings/");   // Putting URL to Browser
		
 	}

	 @AfterMethod
	 public void closeBrowser(){
			//driver.quit();
	 }
	
	@Test
	public void tc001() {
		driver.findElementByName("fld_username").sendKeys("Hello"); // Write Data
		driver.findElementByName("fld_username").clear();
		driver.findElementByName("fld_username").sendKeys("Testing");
		driver.findElementByXPath("//input[@name='add_type' and @value='home']").click();  // Radio Button
		driver.findElementByName("terms").click();

	}
	
}
