package com.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.base.Testbase;
import com.pages.AddUserPage;
import com.pages.LoginPage;


public class AddUserTest extends Testbase {
	
	LoginPage lp=null;
	
	AddUserPage ap=null;
	
	@BeforeSuite
	public void setup() throws Exception{
		driver=initialization("config.properties");
		lp=new LoginPage(driver);
		ap=lp.navigateToDashboardPg().navigateToUserPg().navigateToAddUserPage();
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
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
