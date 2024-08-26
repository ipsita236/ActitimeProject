package com.Actitime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy(xpath="//div[.='Tasks']")
	private WebElement taskelmnt;
	
	@FindBy(xpath="//div[.='Time-Track']")
	private WebElement timeelmnt;
	
	@FindBy(xpath="//div[.='Reports']")
	private WebElement reportelmnt;
	
	@FindBy(xpath="//div[.='Users']")
	private WebElement userelmnt;
	
	@FindBy(id="logoutLink")
	private WebElement lgoutlink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getTaskelmnt() {
		return taskelmnt;
	}

	public WebElement getTimeelmnt() {
		return timeelmnt;
	}

	public WebElement getReportelmnt() {
		return reportelmnt;
	}

	public WebElement getUserelmnt() {
		return userelmnt;
	}

	public WebElement getLgoutlink() {
		return lgoutlink;
	}
	
	

}
