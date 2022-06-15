package org.web.automation.testcases;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TC_006_Registration_DropDown_List{
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
		
        Select  country = new Select(driver.findElementById("countryId"));
        country.selectByVisibleText("India");  // 3rd Approach
        
        //System.out.println(country.getFirstSelectedOption().getText());
        
        List<WebElement> allOptions = country.getOptions();
        for(WebElement e : allOptions){
        	System.out.println(e.getText());
        }
        
        Select  gender = new Select(driver.findElementByName("sex"));
        gender.selectByVisibleText("Male");  // 3rd Approach
        
        //country.selectByIndex(10);    // 1st Approach
        //country.selectByValue("21");  // 2nd Approach
        

        

	}
	
}
