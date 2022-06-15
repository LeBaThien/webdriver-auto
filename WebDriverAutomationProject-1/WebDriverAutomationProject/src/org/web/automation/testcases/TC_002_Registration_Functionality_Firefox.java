package org.web.automation.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_002_Registration_Functionality_Firefox {
	FirefoxDriver driver;
	
	@BeforeMethod
	public void startBrowser(){
		System.setProperty("webdriver.gecko.driver", "/home/lebathien/Documents/crawling/working_with_eclipse/WebDriverAutomationProject-1/WebDriverAutomationProject/Driver/chromedriver");
		driver = new FirefoxDriver();   // Browser Will start
		driver.get("https://thetestingworld.com/testings/");
	}

	@AfterMethod
	public void closeBrowser(){
	    driver.close();
	}
	
	@Test
	public void tc001(){
	
		
		driver.findElementByName("fld_username").sendKeys("Hello"); // Write Data
		driver.findElementByName("fld_email").sendKeys("Hello@yahoo.com"); // Write Data
		driver.findElementByXPath("//input[@value='Sign up']").click();  // Click on Element

	}
	
}
