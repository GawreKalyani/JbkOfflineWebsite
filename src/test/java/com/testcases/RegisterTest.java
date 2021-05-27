package com.testcases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.base.Testbase;
import com.pages.LoginPage;
import com.pages.RegisterPage;

public class RegisterTest extends Testbase{
	WebDriver driver;
	LoginPage lp=null;
	RegisterPage rp=null;
	
	@BeforeSuite
	public void OpenBrowser () throws Exception
	{
		driver=initialization("config.properties");
		lp=new LoginPage(driver);
		rp=lp.navigateToRegisterPg();
	}
	@AfterSuite
	public void CloseBrowser()
	{
		driver.quit();
	}
	@Test(priority=1)
	public void verifyUrl(){
		Assert.assertTrue(rp.getUrl());
	}
	@Test(priority=2)
	public void verifyTitle(){
		Assert.assertTrue(rp.getTitleOfPage());
	}
	
	@Test(priority=3)
	public void verifyHeading(){
		Assert.assertTrue(rp.heading());	
	}
	@Test(priority=4)
	public void verifyAlreadyMemberText() 
	{ 
		Assert.assertTrue(rp.alreadyMemberText());
	}
	@Test(priority=5)
	public void verifyAllPlaceholderText() 
	{ 
		Assert.assertTrue(rp.placeholders());
	}
	@Test(priority=4)
	public void registerNewMember(){
		Assert.assertTrue(rp.validSignIn());
	}
	
	@Test(priority=5)
	public void blankFillingFormErrorMsg(){
		Assert.assertTrue(rp.getRegPgErrorMsg());
	}
	@Test(priority=6)
	public void InvalidDataFillingErrorMsgs(){
		Assert.assertTrue(rp.invalidDataEntry());
	}
	
	@Test(priority=7)
	public void clickAlreadyRegisterLink(){
		Assert.assertTrue(rp.alreadyMemberLink());
		}
}
