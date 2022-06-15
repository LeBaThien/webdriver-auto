package org.web.automation.testcases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_015_Crawling_Data_From_Realstate {
	ChromeDriver driver;
//	String fileName = "data/textout";
	// Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
 
    // CSV file header
    private static final String FILE_HEADER = "id,content";
    private static final String FILENAME = "data/data.csv";
    
    
  
    
	
	 @BeforeMethod
	 public void startBrowser(){
			
			System.setProperty("webdriver.chrome.driver", "/home/lebathien/Documents/crawling"
					+ "/working_with_eclipse/WebDriverAutomationProject-1/WebDriverAutomationProject/Driver/chromedriver");
			driver = new ChromeDriver();   // Browser Will start
			driver.manage().window().maximize();                   // Maximizing browser window
//			driver.get("https://batdongsan.com.vn/nha-dat-ban-quy-nhon-bdd");   // Putting URL to Browser
//			driver.get("https://www.redmine.org//projects//redmine//issues");
			driver.get("https://alonhadat.com.vn/nha-dat/can-ban/nha-dat/binh-dinh/479/thanh-pho-quy-nhon.html"); 
			
		
 	}

	 @AfterMethod
	 public void closeBrowser(){
			//driver.quit();
	 }
	
	@Test
	public void tc001() throws InterruptedException {


  
		int page_number_active = Integer.parseInt(driver.findElement(By.xpath(".//a[@class='active']")).getText());
	    
//	    System.out.print(page_number_active);
	    for(; page_number_active <= 42; page_number_active++) {
		
			List<WebElement> elements = driver.findElements(By.xpath(".//div[@class='ct_title']/a"));
//			List<WebElement> elements1 = driver.findElements(By.xpath(".//span[@class='floors']"));
//			List<WebElement> elements2 = driver.findElements(By.xpath(".//span[@class='bedroom']"));
			List<WebElement> elements1 = driver.findElements(By.xpath(".//div[@class='content-item']/div[@class='text']"));
//			List<WebElement> elements1 = driver.findElements(By.xpath(".//div[@class='characteristics']/span[@class='floors']"));
//			List<WebElement> elements2 = driver.findElements(By.xpath(".//div[@class='characteristics']/span[@class='bedrooom']"));
//			
//			
//			for (WebElement element : elements) {
////			    System.out.println("Product name: " + element.getText());
//			    try {
//		            FileWriter fw = new FileWriter("/home/lebathien/Documents/crawling/working_with_eclipse/WebDriverAutomationProject-1/WebDriverAutomationProject/data/textout.txt");
//		            fw.write(element.getText());
//		            fw.close();
//		        } catch (Exception e) {
//		            System.out.println(e);
//		        }
//		        System.out.println("Success...");
//			}
			
		
			
//			for (int i = 0; i < elements.size(); i++) {
//				System.out.println("Tilte: " + elements.get(i).getText());
//			}
			
//			for (WebElement element : elements) {
//			 System.out.println("title: " + element.getText());
//			}

			
//			for (WebElement element1 : elements1) {
//				 System.out.println("floors: " + element1.getText());
//			}
//		
//		
//			for (WebElement element2 : elements2) {
//				 System.out.println("Number of bedroom : " + element2.getText());
//			}
			
			
//			for (WebElement element1 : elements1) {
//			 System.out.println("PRODUCT INFO: " + element1.getText());
//			}
			
			
//			FileWriter fileWriter = null;
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {
				// không cần đóng BufferedWriter (nó đã tự động đóng)
				// bw.close();
				for (int i = 0; i < elements.size(); i++) {
					 bw.write(String.valueOf(i));
					bw.write(COMMA_DELIMITER);
					bw.write(elements.get(i).getText());
//					fileWriter.append(COMMA_DELIMITER);
					bw.write(NEW_LINE_SEPARATOR);
				}
				System.out.print("CSV file was created successfully!!!");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
//			try {
//				fileWriter = new FileWriter(fileName);
//				//Write the CSV file header
////				fileWriter.append(FILE_HEADER);
//				
//				//Add a new line separator after the header
////				fileWriter.append(NEW_LINE_SEPARATOR);
//				for (int i = 0; i < elements.size(); i++) {
//					fileWriter.append(String.valueOf(i));
//					fileWriter.append(COMMA_DELIMITER);
//					fileWriter.append(elements.get(i).getText());
////					fileWriter.append(COMMA_DELIMITER);
//					fileWriter.append(NEW_LINE_SEPARATOR);
//				}
//				System.out.print("CSV file was created successfully!!!");
//			} catch (Exception e) {
//				System.out.println("Error in CsvFileWriter !!!");
//	            e.printStackTrace();
//	        } finally {
//	            try {
//	                fileWriter.flush();
//	                fileWriter.close();
//	            } catch (IOException e) {
//	                System.out.println("Error while flushing/closing fileWriter !!!");
//	                e.printStackTrace();
//	            }
//	        }
		
	
			String page_number_str = String.valueOf(page_number_active);
					   
			 Thread.sleep(1000);
			 driver.findElement(By.xpath(".//div[@class='page']/a[" + page_number_str + "]")).click();
			 Thread.sleep(2000);
			 System.out.println("page: " + page_number_str + "\n");
			
		}
	 
	    
	}
	
}
