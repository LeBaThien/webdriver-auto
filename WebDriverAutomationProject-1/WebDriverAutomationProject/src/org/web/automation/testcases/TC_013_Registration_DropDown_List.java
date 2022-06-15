package org.web.automation.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_013_Registration_DropDown_List  {
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
	public void tc001() {
		
	
		driver.findElementByName("fld_username").sendKeys("Hello"); // Write Data
		driver.findElementByName("fld_username").clear();
		driver.findElementByName("fld_username").sendKeys("Testing");
		
        Select  country = new Select(driver.findElementById("countryId"));
        country.selectByVisibleText("India");  // 3rd Approach
        
        // Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElementById("stateId"), "Delhi"));
        
        Select  state = new Select(driver.findElementById("stateId"));
        state.selectByVisibleText("Delhi");
        
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElementById("cityId"), "Delhi"));
        Select  city = new Select(driver.findElementById("cityId"));
        city.selectByVisibleText("Delhi");
        

	}
	
}
