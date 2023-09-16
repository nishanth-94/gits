package org.sample.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

   public static WebDriver driver;
   public static WebDriver ChromeBrowser() {
	 WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   return driver;
    }
  public static  WebDriver BrowserLaunch(String bname) {
	 if(bname.equalsIgnoreCase("chrome")) {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	 }
	 else if(bname.equalsIgnoreCase("edge")) {
		 WebDriverManager.edgedriver().setup();
		 driver=new EdgeDriver();
	 }
	 else if(bname.equalsIgnoreCase("firefox")) {
		 WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
	 }
	 return driver;
	  
  }
 
  public static  WebDriver BrowserLaunch2(String bname) {
	  switch(bname) {
	  case "chrome":
		  WebDriverManager.chromedriver().setup();  
		  driver=new ChromeDriver();
	      break;
	  case "edge":   
		  WebDriverManager.edgedriver().setup();
		  driver=new EdgeDriver(); 
	      break;
	  case "firefox":    
		  WebDriverManager.firefoxdriver().setup();   
		  driver=new FirefoxDriver();
		  break;
	  }
	  
	return driver;  
  }
   
   
  public static void urlLaunch(String url) {
	   driver.get(url);
	   driver.manage().window().maximize();
    }   
   public static void implicitlyWait(int a) {
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
   }   
   public static void sendkeys(WebElement e,String value) {
		e.sendKeys(value);
   }   
   public static void click(WebElement e) {
	   e.click(); 
   }
   public static String getCurrentUrl() {
	String currentUrl = driver.getCurrentUrl();
	   return currentUrl;
   }
   public static String getTitle() {
	String title = driver.getTitle();
	return title; 
   }
   public static void quit() {
	driver.quit();  
   }
   public static void clear(WebElement e) {
	e.clear();
	}   	   
   public static String getText(WebElement e) {
		String text = e.getText();
		return text;
	}   
   public static String getAttribute(WebElement e ) {
		String attribute = e.getAttribute("value");
		return attribute;
	}   	   
   public static void moveToElement(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
	}     
   public static void dragAndDrop(WebElement src,WebElement dest) {
		Actions a=new Actions(driver);
        a.dragAndDrop(src, dest).perform();
	}   
   public static void selectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.selectByIndex(index);
   }
   public static void selectByValue(WebElement e,String value) {
	   Select s=new Select(e);
	   s.selectByValue(value);
   }
   public static void selectByVisibleText(WebElement e,String value) {
	   Select s=new Select(e);
	   s.selectByVisibleText(value);
   }
   public static void deSelectAll(WebElement e) {
	   Select s=new Select(e);
       s.deselectAll();
   }
  
  
    }
