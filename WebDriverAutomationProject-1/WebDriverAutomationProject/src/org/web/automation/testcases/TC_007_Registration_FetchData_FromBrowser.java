package org.web.automation.testcases;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TC_007_Registration_FetchData_FromBrowser{
	
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
		
        System.out.println("URL of Current Page is : -->  " + driver.getCurrentUrl());
        System.out.println("Title of Page is : -- > " + driver.getTitle());
        System.out.println("HTML OF PAGE IS HERE : -- > " +  driver.getPageSource());
        
        System.out.println("Inner text is :---> "+driver.findElementByXPath("//a[text()='Read Detail']").getText());
        System.out.println("Attribute Value is : -  "+ driver.findElementByName("terms").getAttribute("type"));
        System.out.println("Cordinates of element is : -  "+  driver.findElementByName("fld_username").getLocation());
        
        
        System.out.println("Element Enable : " + driver.findElementByXPath("//input[@value='Sign up']").isEnabled());
        System.out.println("Element Visible : " + driver.findElementByXPath("//input[@value='Sign up']").isDisplayed());
        System.out.println(driver.findElementByName("terms").isSelected());
        driver.findElementByName("terms").click();
        System.out.println(driver.findElementByName("terms").isSelected());

	}
	
}
