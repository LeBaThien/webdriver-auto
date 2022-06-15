package org.web.automation.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.web.automation.library.PropertyReader;

public class InitiateDriver {
	
    public WebDriver driver;
	
	@BeforeMethod
	public void startBrowser() throws InterruptedException, IOException{
		if(PropertyReader.applicationConfigReader("BrowserName").equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();   // Browser Will start
		}
		else if(PropertyReader.applicationConfigReader("BrowserName").equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver = new FirefoxDriver();   // Browser Will start
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver = new ChromeDriver();   // Browser Will start
		}
		driver.manage().window().maximize();                   // Maximizing browser window
		driver.get(PropertyReader.applicationConfigReader("Application_URL")); // Putting URL to Browser
	
	}

	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}

}
