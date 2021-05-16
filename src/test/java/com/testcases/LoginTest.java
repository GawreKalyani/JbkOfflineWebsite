package com.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.base.Testbase;
import com.pages.LoginPage;
import org.testng.Assert;


public class LoginTest extends Testbase {
	WebDriver driver;
	public static LoginPage lp=null;
	
	
	@BeforeSuite
	public void setup() throws Exception{
		driver=initialization();
		lp=new LoginPage(driver);
	
		}
	
	@AfterSuite
	public void tearDown(){
		driver.close();
	}
	
	@Test(priority=1)
	public void checkUrl(){
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
	
	}
	@Test(priority=9)
	public void verifyBlankEmailPasswordErrorMsg()
	{  
		Assert.assertTrue(lp.getErrorMsgForBlankEntry());
	}
	
	@Test(priority=10)
	public void verifyInvalidLoginEntryErrorMessage()
	{
		
		Assert.assertTrue(lp.getErrorMsgForInvalidEntry());
	}
	
	@Test(priority=11)
	public void checkRegistrationTitle()
	{
		Assert.assertTrue(lp.getTitleOfRegisterPg());
	}
		
}
