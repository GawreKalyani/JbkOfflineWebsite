package com.testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.base.Testbase;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.UserPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserTest extends Testbase {
	WebDriver driver;
	LoginPage lp = null;
	DashboardPage dp = null;
	UserPage up = null;

	@BeforeSuite
	public void setup() throws Exception {
		driver = initialization();
		lp = new LoginPage(driver);
		lp.uname.sendKeys("kiran@gmail.com");
		lp.pass.sendKeys("123456");
		lp.loginButton.click();
		dp=new DashboardPage(driver);
		dp.userBtn.click();
		up=new UserPage(driver);
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
	}

	@Test(priority=1)
	public void verifyUrl() {

		Assert.assertTrue(up.getURLOfBrowser());
	}

	@Test(priority=2)
	public void verifyTitle() {
		Assert.assertTrue(up.getTitleOfBrowser() );
	}

	@Test(priority=3)
	public void checkToolTipMsg() {
		
		Assert.assertTrue(up.getToolTip() );
	}

	@Test(priority=4)
	public void verifyHeading() {
		Assert.assertTrue(up.getHeading());
	}

	@Test(priority=5)
	public void verifySubHeading() {
		Assert.assertTrue(up.getSubHeading());
	}

	@Test(priority=6)
	public void verifyFooter() {
		Assert.assertTrue(up.getFooter());
	}

	@Test(priority=7)
	public void headingOfTable() throws Exception {
		
		Assert.assertTrue(up.checkHeaders() );
	}
	@Test(priority=8)
	public void readUserTableData() throws Exception{
		Assert.assertTrue(up.getUserTableRowdata());
	}
	@Test (priority=9) 
	public void verifyComplete_UsersTable() throws Exception 
	{
		Assert.assertTrue(up.CompleteUsersTable());
	}
	@Test(priority=10)
	public void checkNavigation() {
		
		Assert.assertTrue(up.getNavigator());
	}

	@Test(priority=11)
	public void checkRightCornerHeading() {
		Assert.assertTrue(up.getRightCornerHeading() );
	}

	@Test(priority = 12)
	public void checkLeftCornerHeading() {
		Assert.assertTrue(up.getNmKiran());
	}
	@Test(priority = 13)
	public void checkLeftCornerMainHeading() {
		Assert.assertTrue(up.getJbkheading());
	}

	@Test(priority=14)
	public void verifyUserStatus() {
		Assert.assertTrue(up.getStatus());
	}

	@Test(priority=15)
	public void checkImage() {
		Assert.assertTrue(up.imageDisplay());
	}
	@Test(priority=16)
	public void verifyPersonNamesFromMaharashtra(){
	
		Assert.assertTrue(up.verifyNamesForMahararshtra());
	}
	@Test(priority=17)
	public void verifyPersonNamesFromPunjab(){
		
		Assert.assertTrue(up.verifyNamesForPunjab());
	}
	@Test(priority=18)
	public void properIncrementationOfSrno(){

		
		Assert.assertTrue(up.checksrno());
	}
	@Test(priority=19)
	public void VerifyEmails(){
		Assert.assertTrue(up.checkgmailIsProper());
	}
	@Test(priority=20)
	public void verifyTeacherNameForJava(){

		Assert.assertTrue(up.verifyNamesForJava());
	}
	@Test(priority=21)
	public void verifyTeacherNameForSelenium(){
		
		Assert.assertTrue(up.verifyNamesForSelenium() );
	}
	@Test(priority=22)
	public void verifyTeacherNameForPython(){
		
		Assert.assertTrue(up.verifyNamesForPython() );
	}
	@Test(priority=23)
	public void verifyTeacherNameForPHP(){
		
		Assert.assertTrue(up.verifyNamesForPHP() );
	}
	@Test(priority=24)
	public void verifyNamesOfMaleTeacher(){
		
		Assert.assertTrue(up.verifyNamesForGenderMale() );
	}
	@Test(priority=25)
	public void verifyNamesOfFemaleTeacher(){
		
		Assert.assertTrue(up.verifyNamesForGenderFemale() );
	}
	@Test(priority=26)
	public void verifyMobileNoOfNineDigit(){
		
		Assert.assertTrue(up.verifyNineDigMobno());
	}
	@Test(priority=27)
	public void verifyMobileNoOfTenDigit(){
		
		Assert.assertTrue(up.verifyTenDigMobno() );
	}
	@Test(priority=28)
	public void verifyActionText(){
		
		Assert.assertTrue(up.actionText());
	}
	@Test(priority=29)
	public void sortingNames(){
		
		Assert.assertTrue(up.userNameSorting());
	}
	@Test(priority=30)
	public void alertMsgForDeleteBtn1and3(){
		
		Assert.assertTrue(up.verifyAlertMsgForRow1and3DeleteBtn() );
	}
	@Test(priority=31)
	public void alertMsgForDeleteBtn2and4AfterDismissingAlert(){
		
		Assert.assertTrue(up.verifyAlertMsgForRow2and4DeleteBtn() );
	}
	@Test(priority=32)
	public void secondAlertMsgForDltBtn2And4(){
		
		Assert.assertTrue(up.verifySecondAlertMsg() );
	}
	
	@Test(priority=33)
	public void verifyAddUserTitle(){
		
		Assert.assertTrue(up.getTitleForAddUserPg());
		
	}
}
