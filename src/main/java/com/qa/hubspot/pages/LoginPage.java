package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utility.Constants;
import com.qa.hubspot.utility.ElementUtil;

public class LoginPage extends BasePage {
	WebDriver driver;
	ElementUtil elementutil;
	
	//1. add the locators FIRST
	By username=By.id("username");
	By password= By.id("password");
	By loginbutton= By.id("loginBtn");
	By signuplink= By.linkText("Sign up");
	
	//2. Create a constructor
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementutil= new ElementUtil(driver);
	}
	
	//3. add your actions
	
	public String getloginPagetitle(){
		return elementutil.waitForTitleToBePresent(Constants.LOGINPAGETITLE, 10);
	}
	public boolean checksinguplnk(){
		return elementutil.doIsDisplayed(signuplink);
	}
	public HomePage dologin(String um, String pw){
		elementutil.doActionsSendKeys(username, um);
		elementutil.doActionsSendKeys(password, pw);
		elementutil.doActionsClick(loginbutton);
		return new HomePage(driver);
		
	}

}
