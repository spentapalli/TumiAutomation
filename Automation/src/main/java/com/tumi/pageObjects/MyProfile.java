package com.tumi.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;

public class MyProfile {
	
	public MyProfile(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH, using="//i[@id='profile.titleSelectBoxItArrow']")
	private WebElement title;
	
	public WebElement getTitle() {
		return title;
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='profile.firstName']")
	private WebElement name;
	
	public WebElement getName() {
		return name;
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='profile.lastName']")
	private WebElement surname;
	
	public WebElement getSurname() {
		return surname;
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='profile.phone']")
	private WebElement phone;
	
	public WebElement getPhone() {
		return phone;
	}
	
	
	@FindBy(how=How.XPATH, using="//input[@id='textNotification']")
	private WebElement notifications;
	
	public WebElement getNotifications() {
		return notifications;
	}
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Save Updates')]")
	private WebElement save;
	
	public WebElement getSave() {
		return save;
	}

	@FindBy(how=How.XPATH, using="//a[contains(text(),'Cancel')]")
	private WebElement cancel;

	public WebElement getCancel() {
		return cancel;
	}


}
