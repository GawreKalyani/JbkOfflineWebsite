package com.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.base.Testbase;
import com.pages.DashboardPage;
import com.pages.LoginPage;
import com.pages.OperatorPg;
import com.pages.UserPage;

public class OperatorTest extends Testbase {
	WebDriver driver;
	LoginPage lp = null;
	DashboardPage dp = null;
	UserPage up = null;
	OperatorPg op=null;

	@BeforeSuite
	public void setup() throws Exception {
		driver = initialization("config.properties");
		lp = new LoginPage(driver);
		lp.uname.sendKeys("kiran@gmail.com");
		lp.pass.sendKeys("123456");
		lp.loginButton.click();
		dp=new DashboardPage(driver);
		dp.operatorBtn.click();
		op=new OperatorPg(driver);
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
	}

	@Test(priority=1)
	public void verifyUrl() {

		Assert.assertTrue(op.getURLOfBrowser());
	}

	@Test(priority=2)
	public void verifyTitle() {
		Assert.assertTrue(op.getTitleOfBrowser());
	}

	@Test(priority=3)
	public void verifyHeading() {
		Assert.assertTrue(op.getHeading());
	}

	@Test(priority=4)
	public void verifySubHeading() {
		Assert.assertTrue(op.getSubHeading());
	}

	@Test(priority=5)
	public void verifyFooter() {
	
		Assert.assertTrue(op.getFooter());
	}

	@Test(priority=6)
	public void headingOfTable()throws Exception {
		Assert.assertTrue(op.checkHeaders());
	}
	
	@Test(priority=7)
	public void operatorTableData()throws Exception {
		Assert.assertTrue(op.getOperatorTableRowdata());
	}
	
	@Test(priority=8)
	public void checkNavigation() {
		Assert.assertTrue(op.getNavigator());
	}

	@Test(priority=9)
	public void checkRightCornerHeading() {
		Assert.assertTrue(op.getRightCornerHeading());
	}

	@Test(priority = 10)
	public void checkLeftCornerHeading() {
		Assert.assertTrue(op.getNmKiran());
	}

	@Test(priority=11)
	public void verifyUserStatus() {
		Assert.assertTrue(op.getStatus());
	}

	@Test(priority=12)
	public void checkImage() {
		Assert.assertTrue(op.imageDisplay());
	}
	@Test(priority=13)
	public void check_all_teacher_names_not_present_on_sunday(){
		
		Assert.assertTrue(op.teachersNotPresentOnSunday() );
	}
	@Test(priority=14)
	public void check_all_teacher_names_on_monday(){
		
		Assert.assertTrue(op.teacherPresentOnMonday() );
	}
	
	@Test(priority=15)
	public void check_all_teacher_names_on_monday_and_saturday(){
		
		Assert.assertTrue(op.teacherPresentOnMondaySaturday() );
	}
	@Test(priority=16)
	public void check_all_teacher_names_on_sunday(){
		
		Assert.assertTrue(op.teacherPresentOnSunday()); 
	}
	@Test(priority=17)
	public void verifyTeacherNameHavingMobnoStart88(){
	
		Assert.assertTrue(op.teachersNamesForMobNoStarting88());
	}
	@Test(priority=18)
	public void teacherNmForUrgentTechnicalHelp(){
		
		Assert.assertTrue(op.teacherPresentForUrgentHelp());
	}
	@Test(priority=19)
	public void SortedNames(){
		Assert.assertTrue(op.getSortedNms());
	}
	@Test(priority=20)
	public void facultyHavingWhatsAppAndPhonecall(){
		Assert.assertTrue(op.prefferedWayToConnect_WhatsApp_AND_PhoneCall());
	}
	@Test(priority=21)
	public void facultyAvailableOnPhoneCall(){
		Assert.assertTrue(op.prefferedWayToConnect_PhoneCall());
	}
	@Test(priority=22)
	public void facultyAvailableOnWhatsApp(){
		Assert.assertTrue(op.prefferedWayToConnect_WhatsApp());
	}
	@Test (priority=23)
	public void verifycontactNoLength()
	{
		Assert.assertTrue(op.contactNoLength());
	}
	@Test (priority=24)
	public void verifyPrefferedWayToConnect_WhatsApp_ButNot_PhoneCall()
	{
		Assert.assertTrue(op.prefferedWayToConnect_WhatsApp_ButNot_PhoneCall());
	}
	@Test (priority=25)
	public void verifyComplete_OperatorsTable() throws Exception
	{
		Assert.assertTrue(op.CompleteOperatorsTable());
	}
}
