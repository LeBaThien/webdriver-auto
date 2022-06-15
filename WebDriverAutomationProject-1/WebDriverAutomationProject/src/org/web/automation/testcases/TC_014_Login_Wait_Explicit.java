package org.web.automation.testcases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_014_Login_Wait_Explicit{
	
    ChromeDriver driver;
	
	@BeforeMethod
	public void startBrowser(){
		
		System.setProperty("webdriver.chrome.driver", "/home/lebathien/Documents/crawling"
				+ "/working_with_eclipse/WebDriverAutomationProject-1/WebDriverAutomationProject/Driver/chromedriver");
		driver = new ChromeDriver();   // Browser Will start
		driver.manage().window().maximize();                   // Maximizing browser window
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://thetestingworld.com/testings/");   // Putting URL to Browser
	
	}

	@AfterMethod
	public void closeBrowser(){
		//driver.quit();
	}



	
	@Test
	public void tc001() throws InterruptedException, IOException {
	  driver.findElementByXPath("//label[text()='Login']//parent::li").click();
	  driver.findElementByName("_txtUserName").sendKeys("test");
	  driver.findElementByName("_txtPassword").sendKeys("test");
	  driver.findElementByXPath("//input[@value='Login']").click();
	  driver.findElementByXPath("//button[text()='View Me']").click();
	  
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.invisibilityOf(driver.findElementByXPath("//div[@class='modal-content']")));
	  driver.findElementByXPath("//a[text()='Download']").click();
	  
	}
	
}
