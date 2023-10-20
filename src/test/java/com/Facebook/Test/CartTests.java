package com.Facebook.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Facebook.Base.BaseClass;

public class CartTests extends BaseClass { //import BaseClass
	
	public static WebDriver driver; //import WebDriver
	
	
	
	@Test //import Test
	public void openURL() throws Exception {
		driver = initializeBrowser("amazonLiveURL"); //add throws declaration
		
		
		
	}
	

}
