package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utility.Constants;
import com.qa.hubspot.utility.ElementUtil;

public class LoginPageTest {
	Properties prop;
	BasePage basePage;
	WebDriver driver;
	LoginPage loginPage;
	ElementUtil elementutil;

	@BeforeTest
	public void setUp(){
		basePage= new BasePage();
		prop= new Properties();
		elementutil= new ElementUtil(driver);
				prop=basePage.init_prop();
				driver = basePage.init_driver(prop);
				loginPage= new LoginPage(driver);
			
	}
	@Test(priority=1)
	public void VerifyLoginPagetest(){
		String title=loginPage.getloginPagetitle();
		System.out.println("login page title is :  " + loginPage);
		Assert.assertEquals(title,Constants.LOGINPAGETITLE, "title is not found");
	}
	
	@Test(priority=2)
	public void Signuplink(){
		Assert.assertTrue(loginPage.checksinguplnk(),"signup link not found");
	}
	@Test(priority=3)
	public void logintest(){
		HomePage homePage=loginPage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(homePage.getAccountname(), prop.getProperty("accountname"),"login failed");
		
	}
			
	
	
		
	
	
	
		
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
}
