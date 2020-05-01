package com.qa.hubspot.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.ContactsPage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.utility.Constants;
import com.qa.hubspot.utility.ExcelUtil;

public class ContactListTest {

	Properties prop;
	BasePage basePage;
	WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = new Properties();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.gotoContactspage();
	}
	@DataProvider
	public Object[][] getContactsdata(){
		Object data[][]=ExcelUtil.getTestData(Constants.EXCEL_SHEET);
		return data;
		
	}
	
	
	@Test(priority=1, dataProvider="getContactsdata")
	public void formtest(String emailID, String firstName, String lastName, String jobTitle){
		contactsPage.fillform(emailID, firstName, lastName, jobTitle);
	}
	@Test(priority=2, enabled=false)
	public void deletion(){
		contactsPage.deletion("sunny hemani", "1");
		
	}
		
	
	@AfterTest
	public void tearDown(){
	driver.quit();
	}

}
