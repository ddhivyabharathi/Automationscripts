package com.testproject.testsuit;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.relevantcodes.extentreports.ExtentTest;
import com.testproject.base.BaseTest;
import com.testproject.util.Common_Utility;
import com.testproject.util.*;
public class TraningPageTest {
  BaseTest basetest;
  Common_Utility common_utility;
 // Log log;
  
  public static WebDriver driver;
  public static ExtentTest logger;
  JavascriptExecutor jse = (JavascriptExecutor)driver;
  
  Random ran = new Random();
  
  
  
  @BeforeClass
  public void beforeClass() 
  {
	  //basetest.init();
	  
	  String url="https://learningnetworkstore-stg.cisco.com/";
	  String driver_path="D:/Dhivya/Selenium/Workspace/TestProject/chromedriver.exe";
	  
	  System.setProperty("webdriver.chrome.driver",driver_path);
	  DOMConfigurator.configure("log4j.xml");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();

  }

  @Test
  public void verify_homepage() throws InterruptedException, IOException
  {
	  WebElement homepage_title= driver.findElement(By.xpath("//*[@id='app']/div/div/div[1]/header/div/nav/div/div[1]/span/div/div[2]/a/h2"));
	  
	  if(homepage_title.isDisplayed())
	  {
		  System.out.println("Home Age Title: "+homepage_title.getText());
		  Log.info("Home Age Title: "+homepage_title.getText());
	  }
	  
	  // To verify the menu options.
	  Log.info("Verifying the Certificate Traning Menu");
	  Actions certificate_traning_actions = new Actions(driver);
	  WebElement  certificate_traning_menu = driver.findElement(By.xpath("//*[@id='Certificate-Training']"));
	  certificate_traning_actions.moveToElement(certificate_traning_menu).perform();
	 
	// Take screenshot and store as a file format
	  File src1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(src1, new File("D:/Dhivya/Selenium/Workspace/TestProject/Screenshots/certificate_traning_menu.png"));
	  Thread.sleep(5000);
	  
	  Log.info("Verifying the Technology Training Menu");
	  Actions technology_traning_actions = new Actions(driver);
	  WebElement  technology_traning_menu = driver.findElement(By.xpath("//*[@id='Technology-Training']"));
	  technology_traning_actions.moveToElement(technology_traning_menu).perform();
	
	  File src2= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(src2, new File("D:/Dhivya/Selenium/Workspace/TestProject/Screenshots/technologu_traning_menu.png"));
	  Thread.sleep(5000);
	  
	  Log.info("Verifying the All training Menu");
	  Actions all_traning_actions = new Actions(driver);
	  WebElement  all_traning_menu = driver.findElement(By.xpath("//*[@id='Popular-Products']"));
	  all_traning_actions.moveToElement(all_traning_menu).perform();
	  
	  File src3= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(src3, new File("D:/Dhivya/Selenium/Workspace/TestProject/Screenshots/all_traning_menu.png"));
	  Thread.sleep(5000);
  }
  
  @Test
  public void verify_ondemandtraning_menu() throws InterruptedException
  {
	  //Click on on-demand traning
	  WebElement ondemand_traning = driver.findElement(By.xpath("//*[@id='header-nav-coll']/ul/li[4]/ul/li[3]/a/a"));
	  ondemand_traning.click();
	  
	  WebElement element_trainingtitle = driver.findElement(By.xpath("//*[@id='equalHeight']/div[2]/div/div[1]/div[2]/h1"));
		String training_title = driver.findElement(By.xpath("//*[@id='equalHeight']/div[2]/div/div[1]/div[2]/h1")).getText();
		
		
		if (element_trainingtitle.isDisplayed())
		{
			System.out.println("Traning Name:"+"\n"+training_title);
			Log.info("Traning Name:"+"\n"+training_title);
		}
		
		WebElement element_content = driver.findElement(By.xpath("//*[@id='pdc-aisle-cnt']/div[1]"));
		String content = driver.findElement(By.xpath("//*[@id='pdc-aisle-cnt']/div[1]")).getText();
		
		if (element_content.isDisplayed())
		{
			System.out.println("Descrition of the training:"+"\n"+content);
			Log.info("Descrition of the training:"+"\n"+content);
		}
		driver.manage().timeouts().implicitlyWait(15000,TimeUnit.SECONDS);
		
		List<WebElement> pagination = driver.findElements(By.xpath("//*[@id='equalHeight']/div[2]/div/div[1]/ul/li"));
	    int s = pagination.size()-1;
	    int size;
	    for(int i=1;i<=s;i++)
	    {
	    	
	   		size = driver.findElements(By.xpath("//*[@class='product-list']")).size();
	   		System.out.println("Number of products in page "+i+""+"\n"+size);
	   		Log.info("Number of products in page "+i+""+"\n"+size);
	   		Thread.sleep(5000);
	   		System.out.println("Traning LIST"+"\n");
	   		for(int j=2;j<=size;j++)
			{
				String traning_list =  driver.findElement(By.xpath("//*[@id='equalHeight']/div[2]/div/div["+j+"]/div/article/div[1]/h2/a")).getText();

				System.out.println(traning_list);
				Log.info(traning_list);
			}
	   		
	       
	   		if(i != s)
	   		{
	   			driver.findElement(By.xpath("//li[@value='pagination-next-onestep']")).click();
	   		}
	    }
	  
  }
  
 /*@Test
  
  public void add_tocart_test() throws InterruptedException
  {
	  WebElement ondemand_traning = driver.findElement(By.xpath("//*[@id=h'eader-nav-coll']/ul/li[4]/ul/li[3]"));
	  ondemand_traning.click();
	  Random ran = new Random();
	  List<WebElement> pagination = driver.findElements(By.xpath("//*[@id='equalHeight']/div[2]/div/div[1]/ul/li"));
	  int s = pagination.size()-1;
	    int product_size;
	    for(int i=1;i<=s;i++)
	    {
	    	
	   		product_size = driver.findElements(By.xpath("//*[@class='product-list']")).size();
	   		System.out.println("Number of products in page "+i+""+"\n"+product_size);
	   		Thread.sleep(5000);
	   		
	   		int addcart_ran = ran.nextInt(product_size);
			driver.findElement(By.xpath("//*[@id='equalHeight']/div[2]/div/div["+addcart_ran+"]/div/article/div[2]/div[2]/div/button"));
		
	    }
	    
	    Thread.sleep(5000);
  }
  */

 
  @Test
  
  public void verify_traning_filter() throws InterruptedException
  {
	  int list_size= driver.findElements(By.xpath("//*[@id='pdc-filter']/div[3]/div[3]/div/div/div[1]/div/div/label")).size();
	
		  
		 for(int j=2; j<=list_size;j++)
	 {
		WebElement  certificate_traning_menu = driver.findElement(By.xpath("//*[@id='pdc-filter']/div[3]/div[3]/div/div/div[1]/div/div/label["+j+"]/span[1]"));
		 Actions traning_actions = new Actions(driver);
		 traning_actions.moveToElement(certificate_traning_menu).click(certificate_traning_menu).build().perform();;
		  
		 Thread.sleep(2000);
		 
		 
	 }
		 for(int j=1; j<=list_size;j++)
		 {
			WebElement  certificate_traning_menu = driver.findElement(By.xpath("//*[@id='pdc-filter']/div[3]/div[3]/div/div/div[1]/div/div/label["+j+"]/span[1]"));
			 Actions traning_actions = new Actions(driver);
			 traning_actions.moveToElement(certificate_traning_menu).click(certificate_traning_menu).build().perform();;
			  
			 Thread.sleep(2000);
			 
			 
		 }
	
	
  }
  
@Test
  
  public void verify_addcart()
  {
	  //Click on cart icon
	  driver.findElement(By.xpath("//*[@id='utility-nav']/ul/li[4]/a/button/i"));
	  
  }
 
  @AfterClass
  public void afterClass() 
  {
	  driver.quit();
  }

}
