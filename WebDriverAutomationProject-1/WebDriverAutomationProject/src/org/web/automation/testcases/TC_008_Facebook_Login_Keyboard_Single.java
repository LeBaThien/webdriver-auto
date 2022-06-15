package org.web.automation.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TC_008_Facebook_Login_Keyboard_Single{
	
    ChromeDriver driver;
	
	@BeforeMethod
	public void startBrowser(){
		
		System.setProperty("webdriver.chrome.driver", "/home/lebathien/Documents/crawling"
				+ "/working_with_eclipse/WebDriverAutomationProject-1/WebDriverAutomationProject/Driver/chromedriver");
		driver = new ChromeDriver();   // Browser Will start
		driver.manage().window().maximize();                   // Maximizing browser window
		driver.get("https://www.facebook.com");   // Putting URL to Browser
	
	}

	@AfterMethod
	public void closeBrowser(){
		//driver.quit();
	}
	
	@Test
	public void tc001() {
	  
       driver.findElementById("email").sendKeys("Hello");
       Actions act = new Actions(driver);
       act.sendKeys(Keys.TAB).perform();
       act.sendKeys("HelloWorld").perform();
       act.sendKeys(Keys.ENTER).perform();
	}
	
}
