package com.testcases;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.base.Testbase;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.utility.ExcelUtility;

import org.testng.Assert;


public class LoginTest extends Testbase {
	
	public static LoginPage lp=null;
	DashboardPage dp=null;
	
	@BeforeSuite
	public void setup() throws Exception{
		//log.info("loginPage is launched");
		driver=initialization("config.properties");
		lp=new LoginPage(driver);
		dp=new DashboardPage(driver);
		}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
	
	@Test(priority=1)
	public void checkUrl(){
		testLog().info("verifying url of browser");
		Assert.assertTrue(lp.getURLOfBrowser());
	}
	
	@Test(priority=2)
	public void checkLogo(){
		Assert.assertTrue(lp.displayImage());
	}
	@Test(priority=3)
	public void verifyTitle(){ 
		Assert.assertTrue(lp.getTitleOfBrowser());
	}
	@Test(priority=4)
	public void checkHeadingJavabykiran(){
		Assert.assertTrue(lp.getHeading1());
	}
	@Test(priority=5)
	public void verifyCoursesHeading(){
		Assert.assertTrue(lp.getHeadingCourses());
	}
	@Test(priority=6)
	public void verifySignInHeading()
	{
		Assert.assertTrue(lp.getHeadingSign());
	}
	@Test(priority=7)
	public void checkPlaceholderList(){
		Assert.assertTrue(lp.getPlaceholders());
	}
	
	@Test(priority=8)
	public void checkLoginSuccessfullyDone()
	{	
		Assert.assertTrue(lp.loginSuccessfully());
		dp.clickLogout();
	}
	@Test(priority=9)
	public void verifyLoginTitleWithMultipledata()throws Exception{
		lp.loginWithAllData(ExcelUtility.readUnameAndPass("Data.xlsx", "login", 0, 1));
	}
	
	@Test(priority=10)
	public void verifyBlankEmailPasswordErrorMsg()
	{  
		Assert.assertTrue(lp.getErrorMsgForBlankEntry());
	}
	
	@Test(priority=11)
	public void verifyInvalidLoginEntryErrorMessage()
	{
		Assert.assertTrue(lp.getErrorMsgForInvalidEntry());
	}
	
	@Test(priority=12)
	public void checkRegistrationTitle()
	{
		Assert.assertTrue(lp.getTitleOfRegisterPg());
	}
		
}
