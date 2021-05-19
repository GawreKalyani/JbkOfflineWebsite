package com.testcases;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.base.Testbase;
import com.pages.DashboardPage;
import com.pages.LoginPage;


public class DashboardTest extends Testbase {
	WebDriver driver=null;
	LoginPage lp=null;
	DashboardPage dp=null;
	
	@BeforeSuite
	public void setup() throws Exception {
		driver = initialization("config.properties");
		lp=new LoginPage(driver);
		lp.uname.sendKeys("kiran@gmail.com");
		lp.pass.sendKeys("123456");
		lp.loginButton.click();
		dp = new DashboardPage(driver);
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
	}
	
	@Test(priority=1)
	public void checkUrl(){
		Assert.assertTrue(dp.url());
	}
	@Test(priority=2)
	public void checkTitle(){
		Assert.assertTrue(dp.title());
	}
	@Test(priority=3)
	public void checkImage(){
		Assert.assertTrue(dp.userImage());
	}
	@Test(priority=4)
	public void checkHeading(){
		Assert.assertTrue(dp.cornerHeading());
	}
	@Test(priority=5)
	public void checkSubHeading(){
		Assert.assertTrue( dp.getDashHeading());
	}
	@Test(priority=6)
	public void checkCourses(){
		
		Assert.assertTrue(dp.getCourses());
	}
	@Test(priority=7)
	public void checkSubcourse(){
		
		Assert.assertTrue(dp.getSubCourses());
	}
	@Test(priority=8)
	public void checkSeqHomeDash(){
		Assert.assertTrue(dp.getSeq() );
	}
	@Test(priority=9)
	public void checkLeftCornerHeading(){
		Assert.assertTrue(dp.getNmKiran());
	}
	@Test(priority=10)
	public void verifyUserStatus () 
	{		Assert.assertTrue(dp.getStatus() );
	}
	@Test(priority=11)
	public void verifyFooterStatement () 
	{
		Assert.assertTrue(dp.getFooter());
	}
	@Test(priority=12)
	public void verifyNavigationMenuText() 
	{
		Assert.assertTrue(dp.getNavigatorLinks());
	}

	@Test(priority=13)
	public void verifyCoursesMoreinfo()throws Exception 
	{
		Assert.assertTrue(dp.getMoreInfoLinks());
	}
	
	@Test(priority=14)
	public void clickUsersAndVerifyTitle(){
		Assert.assertTrue(dp.usersMenu());
		
	}
	@Test(priority=15)
	public void clickUsefulLinkAndVerifyTitle(){
		Assert.assertTrue(dp.usefulLinkMenu());
	}
	@Test(priority=16)
	public void clickOperatorsAndVerifyTitle(){
		Assert.assertTrue(dp.operatorsMenu());
	}
	@Test(priority=18)
	public void clickDownloadsAndVerifyTitle(){
		Assert.assertTrue(dp.downloadsMenu());	
	}
	
	@Test(priority=19)
	public void windowHandle(){

		Assert.assertTrue(dp.getAllWindow());	
	}
	@Test (priority=20)
	public void verifyJBK_Link () throws Exception 
	{
		Assert.assertTrue(dp.jbk_Link());
	}
	@Test (priority=22)
	public void verifyCourseHeading () throws Exception 
	{
		Assert.assertTrue(dp.courseHeadingExcel());
	}
	
	@Test (priority=23)
	public void verifyCourseSubHeading () throws Exception 
	{
		Assert.assertTrue(dp.courseSubHeadingExcel());
	}
	@Test(priority=24)
	public void verifyTitleOnLogout(){
		
		Assert.assertTrue(dp.verifyRightCornerLogOutLink());
	}
}
