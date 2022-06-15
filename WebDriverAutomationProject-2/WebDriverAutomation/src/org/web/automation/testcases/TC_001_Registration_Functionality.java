package org.web.automation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.web.automation.base.InitiateDriver;

public class TC_001_Registration_Functionality extends InitiateDriver{
	
	
	@Test
	public void tc001() {
	
		driver.findElement(By.name("fld_username")).sendKeys("Hello"); // Write Data
		driver.findElement(By.name("fld_email")).sendKeys("Hello@yahoo.com"); // Write Data
		driver.findElement(By.xpath("//input[@value='Sign up']")).click();  // Click on Element

	}
	
}
