package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.utility.Constants;
import com.qa.hubspot.utility.ElementUtil;

public class HomePage extends BasePage {
	WebDriver driver;
	ElementUtil elementutil;
	
	
	By header= By.cssSelector("h1.private-page__title");
	By accoutName= By.xpath("//h1[text()='Sales Dashboard']");
	By contactsprimary= By.id("nav-primary-contacts-branch");
	By contactssecondary= By.id("nav-secondary-contacts");

	
	

public HomePage(WebDriver driver){
		this.driver= driver;
		elementutil=new ElementUtil(driver);
		}
public String homePageTitle(){
	return elementutil.waitForTitleToBePresent(Constants.HOMEPAGETITLE, 10);
	
}
public String gethomepageheader(){
	if (elementutil.doIsDisplayed(header)){
	return elementutil.doGetText(header);
}
return null;
}
public String getAccountname(){
	elementutil.waitForElementToBePresent(accoutName, 10);
	if (elementutil.doIsDisplayed(accoutName)){
		return elementutil.doGetText(accoutName);
}
return null;

}
public ContactsPage gotoContactspage(){
	clickoncontact();
	return new ContactsPage(driver);
	
}
	

private void clickoncontact(){
	elementutil.waitForElementToBeClickable(contactsprimary, 10);
	elementutil.doClick(contactsprimary);
	elementutil.waitForElementToBePresent(contactssecondary, 5);
	elementutil.doClick(contactssecondary);

}
}