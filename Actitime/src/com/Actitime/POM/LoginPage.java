package com.Actitime.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(id="username")
	private WebElement untbx;
	
	@FindBy(name="pwd")
	private WebElement pwtbx;
	
	@FindBy(id="keepLoggedInCheckBox")
	private WebElement chkbx;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement lgbtn;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getUntbx() {
		return untbx;
	}

	public WebElement getPwtbx() {
		return pwtbx;
	}

	public WebElement getChkbx() {
		return chkbx;
	}

	public WebElement getLgbtn() {
		return lgbtn;
	}
	

}
