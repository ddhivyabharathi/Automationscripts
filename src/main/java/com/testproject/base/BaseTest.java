/**
 * 
 */
package com.testproject.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import bsh.org.objectweb.asm.Constants;

/**
 * @author Admin
 *
 */
public class BaseTest {

	public static WebDriver driver;
	
	public void init()
	{
		System.setProperty("webdriver.chrome.driver","D:/Dhivya/Selenium/Workspace/EcomWebsiteTesting/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://learningnetworkstore-stg.cisco.com/on-demand-e-learning");
	}
	
	public void teardown()
	{
		driver.quit();
	}
	
	/*public static void main(String[] args) throws InterruptedException 
	{
	*/	
	
	/*System.setProperty("webdriver.chrome.driver","D:/Dhivya/Selenium/Workspace/EcomWebsiteTesting/driver/chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://learningnetworkstore-stg.cisco.com/on-demand-e-learning");
	WebElement element_trainingtitle = driver.findElement(By.xpath("//*[@id='equalHeight']/div[2]/div/div[1]/div[2]/h1"));
	String training_title = driver.findElement(By.xpath("//*[@id='equalHeight']/div[2]/div/div[1]/div[2]/h1")).getText();
	
	
	if (element_trainingtitle.isDisplayed())
	{
		System.out.println("Traning Name"+training_title);
	}
	
	WebElement element_content = driver.findElement(By.xpath("//*[@id='pdc-aisle-cnt']/div[1]"));
	String content = driver.findElement(By.xpath("//*[@id='pdc-aisle-cnt']/div[1]")).getText();
	
	if (element_content.isDisplayed())
	{
		System.out.println("Descrition of the training"+content);
	}
	
	List<WebElement> pagination = driver.findElements(By.xpath("//*[@id='equalHeight']/div[2]/div/div[1]/ul/li"));
    int s = pagination.size();
    System.out.println("Page numbers" +s);
    for(int i=1;i<=s;i++){
    	int size;
    	List<WebElement> pagination1 = driver.findElements(By.xpath("//*[@id='equalHeight']/div[2]/div/div[1]/ul/li"));
        int s1 = pagination1.size();
        
        	Thread.sleep(5000);
   		 size = driver.findElements(By.xpath("//*[@class='product-list']")).size();
   		System.out.println(size);
               Thread.sleep(5000);
         if( s == pagination1.size())
        {
        
    	pagination = driver.findElements(By.xpath("//*[@id='equalHeight']/div[2]/div/div[1]/ul/li"));
        
        pagination.get(i).click();
        Thread.sleep(5000);
		 size = driver.findElements(By.xpath("//*[@class='product-list']")).size();
		System.out.println(size);
            Thread.sleep(5000);
        }
        
        else
        {
        	pagination = driver.findElements(By.xpath("//*[@id='equalHeight']/div[2]/div/div[1]/ul/li"));
            
            pagination.get(i+1).click();
            Thread.sleep(5000);
    		 size = driver.findElements(By.xpath("//*[@class='product-list']")).size();
    		System.out.println(size);
                Thread.sleep(5000);
        }
            
    
       // pagination = driver.findElements(By.xpath("//*[@id='equalHeight']/div[2]/div/div[1]/ul/li"));
        for(int j=2;j<=size;j++)
		{
			String traning_list =  driver.findElement(By.xpath("//*[@id='equalHeight']/div[2]/div/div["+j+"]/div/article/div[1]/h2/a")).getText();

			System.out.println("traning:"+traning_list);
		}
       
        
        
        
    }
    
	
	int page_count = driver.findElements(By.xpath("//*[@id='equalHeight']/div[2]/div/div[1]/ul/li")).size();
	System.out.println(page_count -1);
	
	
	
	for(int i=1;i<=page_count-1;i++){
		driver.findElement(By.xpath("//*[@id='equalHeight']/div[2]/div/div[1]/ul/li["+i+"]")).click();
		Thread.sleep(15000);
		int size = driver.findElements(By.xpath("//*[@class='product-list']")).size();
		System.out.println(size);	
		
		for(int j=2;j<=size;j++)
		{
			String traning_list =  driver.findElement(By.xpath("//*[@id='equalHeight']/div[2]/div/div["+j+"]/div/article/div[1]/h2/a")).getText();

			System.out.println("traning:"+traning_list);
		}
		//*[@id="equalHeight"]/div[2]/div/div[2]/div/article/div[1]/h2/a
		//*[@id="equalHeight"]/div[2]/div/div[2]/div/article/div[1]/h2/a
		//*[@id="equalHeight"]/div[2]/div/div[3]/div/article/div[1]/h2/a
	//}
	
	
	List<WebElement> pagination = driver.findElements(By.xpath("//div[@class='pagination-container']//a"));
    int s = pagination.size();
    for(int i=0;i<=s;i++){
        this.getAuthors();
            driver.get(Constants.url);
            Thread.sleep(5000);

        pagination = driver.findElements(By.xpath("//div[@class='pagination-container']//a"));
        pagination.get(i).click();
        Thread.sleep(5000);
    }

	
	*/
	
}
