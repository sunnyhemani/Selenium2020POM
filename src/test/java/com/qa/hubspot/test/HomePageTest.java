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

public class HomePageTest {
	Properties prop;
	BasePage basePage;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = new Properties();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1, enabled= false)
	public void VerifyHomepageTitletest() {
		String pagetitle = homePage.homePageTitle();
		System.out.println("Home page title =  " + pagetitle);
		Assert.assertEquals(pagetitle, Constants.HOMEPAGETITLE);
	}
	@Test(priority = 2)
	public void VerifyHomepageHeadertest(){
		String hpheader=homePage.gethomepageheader();
		Assert.assertEquals(hpheader, Constants.HOMEPAGEHEADER);
	}
	@Test(priority = 3)
	public void LoggedinUsertest(){
		String accountnametest=homePage.getAccountname();
		Assert.assertEquals(accountnametest, prop.getProperty("accountname"));
	}
	
		

	@AfterTest
	public void tearDown(){
	driver.quit();
	}
	
	
}

					
	
	
	
	
	
	
