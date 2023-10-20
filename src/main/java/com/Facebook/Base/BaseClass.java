package com.Facebook.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver; //declare global
	
	public WebDriver initializeBrowser(String url) throws Exception {
        
		try {
			Properties prop = new Properties(); //load a file //import properties
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Properties\\config.properties");//import file input stream and add throws declaration
			prop.load(fis);
			System.out.println(prop.getProperty("browser"));
			String browserName=prop.getProperty("browser");
			
			if(browserName.equals("chrome")) {
				WebDriverManager.chromedriver().setup(); //launching the chromedriver
				 driver=new ChromeDriver(); //import webdriver and chromedriver
			}else if (browserName.equals("firefox")){
				WebDriverManager.firefoxdriver().setup();
				 driver=new FirefoxDriver();//import firefox driver
			}else if (browserName.equals("edge")){
				WebDriverManager.edgedriver().setup();
				 driver=new EdgeDriver();//import Edgedriver
			}
			 driver.manage().window().maximize();
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//import Duration-java.time
			 driver.get(prop.getProperty(url));//load url
			
			
			
		}catch (Exception e) {
			
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			
			throw e;
		}
		
		return driver;
		 
		}	
		//explicit wait
	public void waitForVisibility(WebElement e) { //import webelement
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//import WebDriverWait
		wait.until(ExpectedConditions.visibilityOf(e));
		
	}
		
	public void waitUntilElementisClickable(WebElement e) { 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//import WebDriverWait
		wait.until(ExpectedConditions.elementToBeClickable(e));	
	}
	
	public void click(WebElement e) {
		waitForVisibility(e);
		waitUntilElementisClickable(e);
		e.click();
	}
		
	public void sendKeys(WebElement e,String text) {
		waitForVisibility(e);
		e.sendKeys(text);
	}
	
	public void clearText(WebElement e) {
		waitForVisibility(e);
		e.clear();
	}
	
	public String getText(WebElement e) {
		waitForVisibility(e);
		return e.getText();
	}
	
	 public void navigateback() {
		 driver.navigate().back();
	 }
	 
	 public void acceptAlert() {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 Alert alert = wait.until(ExpectedConditions.alertIsPresent()); //import alert
		 System.out.println("Alert -"+driver.switchTo().alert().getText());
		 alert.accept();
	 }
	 
	 public void dismissAlert() {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		 Alert alert = wait.until(ExpectedConditions.alertIsPresent()); //import alert
		 System.out.println("Alert -"+driver.switchTo().alert().getText());
		 alert.dismiss();
	 }
	 
	 public void scrollIntoView(WebElement e, int up,int down) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+up+","+down+")");
	 }
	 
	 public void scrollIntoView(WebElement e) {
		 ((JavascriptExecutor)driver).executeScript("arguments[0]scrollIntoViewIfNeeded()",e);
		 
	 }
     
	 public void switchToNextWindow() {
		 Set<String> windowPopup = driver.getWindowHandles();//import set
		 Iterator<String> iterate = windowPopup.iterator();//import Iterator-java.util
		 List<String> windowIndex = new ArrayList<String>();//import list and arraylist
		 while(iterate.hasNext()) {
			 windowIndex.add(iterate.next());
		 }
		 driver.switchTo().window(windowIndex.get(1));
		 driver.manage().window().maximize();
		 System.out.println("Switched to window");
		 System.out.println("Window Title-"+ driver.getTitle());
	 }
	 
	 public String getCurrentTime() {
		 DateFormat dateformat = new SimpleDateFormat("hh:mm a");//import date format and simple date format
		 Date time = new Date();//import date
		 String time1 = dateformat.format(time);
		 return time1;
     }
	 
	 public String getCurrentDate() {
		 DateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy");//import date format and simple date format
		 Date date = new Date();//import date
		 String date1 = dateformat.format(date);
		 return date1;
     }
	 
	 
	 
	 
	 
	 

}
