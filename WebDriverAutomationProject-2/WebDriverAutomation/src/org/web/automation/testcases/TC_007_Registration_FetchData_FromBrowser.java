package org.web.automation.testcases;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.web.automation.base.InitiateDriver;

public class TC_007_Registration_FetchData_FromBrowser extends InitiateDriver{
	
	
	@Test
	public void tc001() {
		driver.findElement(By.name("fld_username")).sendKeys("Hello"); // Write Data
		driver.findElement(By.name("fld_username")).clear();
		driver.findElement(By.name("fld_username")).sendKeys("Testing");
		
        System.out.println("URL of Current Page is : -->  " + driver.getCurrentUrl());
        System.out.println("Title of Page is : -- > " + driver.getTitle());
        System.out.println("HTML OF PAGE IS HERE : -- > " +  driver.getPageSource());
        
        System.out.println("Inner text is :---> "+driver.findElement(By.xpath("//a[text()='Read Detail']")).getText());
        System.out.println("Attribute Value is : -  "+ driver.findElement(By.name("terms")).getAttribute("type"));
        System.out.println("Cordinates of element is : -  "+  driver.findElement(By.name("fld_username")).getLocation());
        
        
        System.out.println("Element Enable : " + driver.findElement(By.xpath("//input[@value='Sign up']")).isEnabled());
        System.out.println("Element Visible : " + driver.findElement(By.xpath("//input[@value='Sign up']")).isDisplayed());
        System.out.println(driver.findElement(By.name("terms")).isSelected());
        driver.findElement(By.name("terms")).click();
        System.out.println(driver.findElement(By.name("terms")).isSelected());

	}
	
}
