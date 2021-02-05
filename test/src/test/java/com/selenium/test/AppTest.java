package com.selenium.test;

import org.openqa.selenium.By; 
import org.openqa.selenium.Keys; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.testng.Assert; 
import org.testng.annotations.Test; 

public class AppTest 
{
    @Test
	  public void exampleTest() {       
    	  //Save in a property the path where the chrome driver .exe file is
		  System.setProperty("webdriver.chrome.driver","src/test/java/example/chromedriver.exe");  
		  //Create WebDriver object
		  WebDriver driver = new ChromeDriver(); 
		  // Open in chrome web site of amazon
		  driver.get("https://www.amazon.com/");  
		  //Search input element with this especific id and give value "Software Test Design"
		  driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys("Software Test Design");
		  driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
		  //Will be good know if search bottom also worked
		  //driver.findElement(By.cssSelector("input[id='nav-search-submit-button']")).sendKeys(Keys.ENTER);   
		  
		  try {            
			  Thread.sleep(1000);        
			  } catch (InterruptedException e) {           
				  e.printStackTrace();        }        
		  
		 //Will be important know if a element exist or not. So, we should use some exceptions like NoSuchElementException or other 
		 //Fix: next element not found because the link is into img element 
		 //driver.findElement(By.cssSelector("div[data-component-id='1']")).click();
		 // data-image-index='1' refers to second images cause index start at 0
		 // can use next line 
		 driver.findElement(By.cssSelector("img[data-image-index='0']")).click();
		
		 //Fix: cann't compare element with text. The two element to compare must be same type
		 //Assert.assertEquals(driver.findElement(By.cssSelector("span[id='productTitle']")),"A Practitioner's Guide to Software Test Design");
		 //So, we need value of span, not element (object) span
		  WebElement title = driver.findElement(By.id("productTitle"));
		  System.out.println(title.getText());
		  Assert.assertEquals(title.getText(),"A Practitioner's Guide to Software Test Design","Titles of the book do not match"); 
		 //Will be good personalize with a message         
		  
		  //test for knows if mediaTab_heading (pasta blanda) is displayed
		  Assert.assertTrue(driver.findElement(By.cssSelector("#mediaTab_heading_2 > a > span > div:nth-child(1) > span")).isDisplayed(),"Paperback tab was not shown pre-selected ");        
		  //Close test
		  driver.close();   
	    } 
}
