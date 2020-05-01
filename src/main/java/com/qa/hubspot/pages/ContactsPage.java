package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.utility.ElementUtil;

public class ContactsPage {
	WebDriver driver;
	ElementUtil elementutil;
	By email = By.xpath("//input[@data-field='email']");
	By firstname = By.xpath("//input[@data-field='firstname']");
	By lastname = By.xpath("//input[@data-field='lastname']");
	By createcontactfirst = By.xpath("//button[@data-button-use='primary']");
	By jobtitle = By.xpath("//input[@data-field='jobtitle']");
	By phonenumber = By.xpath("//input[@data-field='phone']");
	By createcontact2 = By.xpath("(//span[text()='Create contact'])[2]");
	By delete= By.xpath("//span[text()='Delete']");
	By formunput=By.xpath("//textarea[@id='UIFormControl-30']");
	By deletebutton=By.xpath("(//span[text()='Delete'])[2]");
	By backtocontacts=By.xpath("(//i18n-string[@data-key='profileHeader.backButton.CONTACT'])[2]");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementutil = new ElementUtil(driver);
	}

	public void fillform(String emailID, String firstName, String lastName, String jobTitle) {
		elementutil.waitForElementToBeClickable(createcontactfirst, 10);
		elementutil.doClick(createcontactfirst);
		elementutil.waitForElementToBePresent(email, 5).sendKeys(emailID);
		elementutil.waitForElementToBePresent(firstname, 5).sendKeys(firstName);
		elementutil.waitForElementToBePresent(lastname, 5).sendKeys(lastName);
		elementutil.waitForElementToBePresent(jobtitle, 5).sendKeys(jobTitle);
		elementutil.doActionsClick(createcontact2);
		elementutil.waitForElementToBeClickable(backtocontacts, 10);
		elementutil.doClick(backtocontacts);

	}
	public void deletion(String name, String value){
		elementutil.doClick(By.xpath("//span[text()='sunny hemani']//parent::span//parent::a//parent::div//parent::td//preceding-sibling::td//span[@class='private-checkbox__indicator']"));
		elementutil.waitForElementToBeClickable(delete, 10).click();
		elementutil.waitForElementToBePresent(formunput, 5);
		elementutil.doActionsSendKeys(formunput, value);
		elementutil.doActionsClick(deletebutton);
}
}
