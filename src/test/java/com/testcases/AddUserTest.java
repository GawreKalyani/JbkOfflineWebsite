package com.testcases;





import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;

import com.base.Testbase;
import com.pages.AddUserPage;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.UserPage;

public class AddUserTest extends Testbase {
	WebDriver driver;
	LoginPage lp=null;
	DashboardPage dp=null;
	UserPage up=null;
	AddUserPage ap=null;
	
	@BeforeSuite
	public void setup() throws Exception{
		driver=initialization();
		lp=new LoginPage(driver);
		lp.uname.sendKeys("kiran@gmail.com");
		lp.pass.sendKeys("123456");
		lp.loginButton.click();
		dp=new DashboardPage(driver);
		dp.userBtn.click();
		up=new UserPage(driver);
		up.addUserButton.click();
		ap=new AddUserPage(driver);
	}
	
	@AfterSuite
	public void tearDown(){
		driver.close();
	}
	@Test(priority=1)
	public void addUser(){
		Assert.assertTrue(ap.addUserValid());
	}
	
	@Test(priority=2)
	public void checkLabels(){
	Assert.assertTrue(ap.getLabels());
	}
	@Test(priority=3)
	public void verifyStateList(){
		Assert.assertTrue(ap.getListOfStateOptions());
	}
	@Test(priority=4)
	public void verifyStateListThroughExcel() throws Exception{
		Assert.assertTrue(ap.getOptFromExcel());
	}
	
	
	
}
