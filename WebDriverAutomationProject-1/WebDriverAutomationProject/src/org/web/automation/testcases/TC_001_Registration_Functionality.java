package org.web.automation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TC_001_Registration_Functionality{
	
	 ChromeDriver driver;
	
	 @BeforeMethod
	 public void startBrowser() throws InterruptedException{
			
			System.setProperty("webdriver.chrome.driver", "/home/lebathien/Documents/crawling/working_with_eclipse/WebDriverAutomationProject-1/WebDriverAutomationProject/Driver/chromedriver");
			driver = new ChromeDriver();   // Browser Will start
			driver.manage().window().maximize();     // Maximizing browser window

			driver.get("https://www.google.com");
			driver.get("https://thetestingworld.com/testings/");
			//driver.navigate().to("https://www.google.com");
			//driver.navigate().to("https://thetestingworld.com/testings/");
			driver.navigate().back();
			Thread.sleep(5000);
			driver.navigate().forward();
			Thread.sleep(5000);
			driver.navigate().refresh();
		 
 	 }

	 @AfterMethod
	 public void closeBrowser(){
			//driver.quit();
	 }
	
	@Test
	public void tc001() {
	
		driver.findElement(By.name("fld_username")).sendKeys("Hello"); // Write Data
		driver.findElement(By.name("fld_email")).sendKeys("Hello@yahoo.com"); // Write Data
		driver.findElement(By.xpath("//input[@value='Sign up']")).click();  // Click on Element

	}
	
}
