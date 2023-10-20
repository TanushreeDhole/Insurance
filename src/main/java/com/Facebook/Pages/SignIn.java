package com.Facebook.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Facebook.Base.BaseClass;

public class SignIn extends BaseClass{//import BaseClass

	
	//Initializing PageFactory
	public SignIn(WebDriver rdriver) {//import WebDriver
    driver=rdriver;
    PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(id="email") private WebElement email;//import FindBy and WebElement
	@FindBy(id="pass") private WebElement password;
	@FindBy(xpath="//button[@type='submit']") private WebElement loginbutton;
	@FindBy(xpath="//*[@id=\"u_0_2_RZ\"]/div[3]/a") private WebElement forgottenpassword;
	@FindBy(xpath="(//a[@role='button'])[2]") private WebElement createnewaccount;
	@FindBy(xpath="//div[@class='_9ay7']")	private WebElement message;
	
	
	public SignIn enterEmail(String text) {
		sendKeys(email,text);
		System.out.println("Entered email address");
		return this;
	}
	
	public SignIn enterpassword(String text) {
		sendKeys(password,text);
		System.out.println("Entered password");
		return this;
	}
	
	public SignIn ClickonLoginButton() {
		click(loginbutton);
		System.out.println("Clicked on login button");
		return this;	
	}
	
	public SignIn ClickonForgottenPassword() {
		click(forgottenpassword);
		System.out.println("Clicked on forgotten password link");
		return this;
	}
	
	public SignIn Clickoncreatenewaccount() {
		click(createnewaccount);
		System.out.println("Clicked on Create new account button");
		return this;
	}
	
   public String verifymsgafterenteringblankcredentials() {
	   String textmsg = getText(message);
	   return textmsg;
   }
	
}
