package org.web.automation.testcases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
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
import org.web.automation.base.InitiateDriver;
import org.web.automation.library.PropertyReader;

public class TC_014_Login_Wait_Explicit  extends InitiateDriver{
	
	
	@Test
	public void tc001() throws InterruptedException, IOException {
	  driver.findElement(By.xpath("//label[text()='Login']//parent::li")).click();
	  driver.findElement(By.name("_txtUserName")).sendKeys(PropertyReader.applicationConfigReader("Application_Username"));
	  driver.findElement(By.name("_txtPassword")).sendKeys(PropertyReader.applicationConfigReader("Application_Password"));
	  driver.findElement(By.xpath("//input[@value='Login']")).click();
	  driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//button[text()='View Me']")).click();
	  
	  WebDriverWait wait = new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='modal-content']"))));
	  driver.findElement(By.xpath("//a[text()='Download']")).click();
	  
	}
	
}
