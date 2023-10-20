package com.Facebook.Test;


import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Facebook.Base.BaseClass;
import com.Facebook.Pages.SignIn;

public class SignInTests extends BaseClass{ //import baseclass
	
	public static WebDriver driver;
	public static SignIn signin; //declare global
	
	
	@BeforeMethod //import
	public void beforeMethod(Method m) throws Exception {
		driver = initializeBrowser("facebookURL");
		
		System.out.println("****Starting Test****"+m.getName()+"*****");
	}

	@Test (priority = 1) //import
	public void loginwithValidCredentials() {
		 signin = new SignIn(driver); //import SignIn then declare global
		 
		 signin.enterEmail("tanushreetapikar@gmail.com");
		 signin.enterpassword("Tanushree@22041996");
		 signin.ClickonLoginButton();
		 
	}

	
	@Test (priority = 2) //import
	public void loginwithInvalidEmail() {
		 signin = new SignIn(driver); //import SignIn then declare global
		 
		 signin.enterEmail("abc123@gmail.com");
		 signin.enterpassword("Tanushree@22041996");
		 signin.ClickonLoginButton();
		 
	}
	
	@Test(priority = 3)  //import
	public void loginwithInvalidPassword() {
		 signin = new SignIn(driver); //import SignIn then declare global
		 
		 signin.enterEmail("tanushreetapikar@gmail.com");
		 signin.enterpassword("abc1234");
		 signin.ClickonLoginButton();
		 
	}
	
	@Test (priority = 4) //import
	public void loginwithBlankCredentials() {
		 signin = new SignIn(driver); //import SignIn then declare global
		 
		 signin.enterEmail("");
		 signin.enterpassword("");
		 signin.ClickonLoginButton();
		 
		 
		 String actualtxt = signin.verifymsgafterenteringblankcredentials();
		 String expectedtxt = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		 Assert.assertEquals(actualtxt, expectedtxt,"Message doesn't match - ");
		 
		 
	}

	
	
}