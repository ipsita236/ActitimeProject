package com.Actitime.Testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Actitime.GenericLibrary.Baseclass;
import com.Actitime.GenericLibrary.FileLibrary;
import com.Actitime.GenericLibrary.ListenerImplementation;
import com.Actitime.POM.HomePage;
import com.Actitime.POM.TaskListPage;
@Listeners(ListenerImplementation.class)
public class CreateCustomer extends Baseclass
{
	FileLibrary f = new FileLibrary();
	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException
	{
		HomePage hp = new HomePage(driver);
		hp.getTaskelmnt().click();
		
		TaskListPage tp = new TaskListPage(driver);
		tp.getAddnewbtn().click();
		tp.getNewcust().click();
		String name = f.readDataFromExcelFile("CustomerData", 2, 1);
		tp.getCustname().sendKeys(name);
		String desc = f.readDataFromExcelFile("CustomerData", 2, 2);
		tp.getCustdesc().sendKeys(desc);
		tp.getCreatecustbtn().click();
		String expectedResult = name;
		String actualResult = driver.findElement(By.xpath("(//div[.='"+name+"'])[2]")).getText();
		SoftAssert s = new SoftAssert();
		s.assertEquals(expectedResult, actualResult);
		Reporter.log("testscript passes successfully",true);
		s.assertAll();
		
	}

}
