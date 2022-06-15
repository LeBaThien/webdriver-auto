package org.web.automation.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.web.automation.base.InitiateDriver;

public class TC_012_Keyboard_And_MouseOperation extends InitiateDriver{
	
	
	@Test
	public void tc001() throws InterruptedException {
	  driver.findElement(By.xpath("//label[text()='Login']//parent::li")).click();
	  driver.findElement(By.name("_txtUserName")).sendKeys("test");
	  driver.findElement(By.name("_txtPassword")).sendKeys("test");
	  driver.findElement(By.xpath("//input[@value='Login']")).click();
	  //Thread.sleep(15000);
	  Actions act = new Actions(driver);
	  act.keyDown(Keys.CONTROL).click(driver.findElement(By.xpath("//a[text()='Download']"))).keyUp(Keys.CONTROL).build().perform();
	  
	}
	
}
