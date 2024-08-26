package com.Actitime.GenericLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.Actitime.POM.HomePage;
import com.Actitime.POM.LoginPage;

public class Baseclass 
{
	public static WebDriver driver;
	FileLibrary f = new FileLibrary();
	
	
	@BeforeSuite
	public void databaseConnection()
	{
		Reporter.log("database is connected",true);
	}
	
	@BeforeTest
	public void launchBrowser() throws IOException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		String URL = f.readDataFromPropertyFile("url");
		driver.get(URL);
		Reporter.log("Browser launched successfully",true);
	}
	
	@BeforeMethod
	public void login() throws IOException
	{
		String un = f.readDataFromPropertyFile("username");
		LoginPage lp = new LoginPage(driver);
		lp.getUntbx().sendKeys(un);
		String pw = f.readDataFromPropertyFile("password");
		lp.getPwtbx().sendKeys(pw);
		lp.getLgbtn().click();
		Reporter.log("Logged in successfully",true);
	}
	
	@AfterMethod
	public void logout()
	{
		HomePage hp = new HomePage(driver);
		hp.getLgoutlink().click();
		Reporter.log("logged out successfully",true);
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		Reporter.log("browser closed successfully",true);
	}
	
	@AfterSuite
	public void disconnectDatabase()
	{
		Reporter.log("database disconnected",true);
	}

}
