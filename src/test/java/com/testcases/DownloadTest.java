package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.base.Testbase;
import com.pages.DownloadPage;
import com.pages.LoginPage;

public class DownloadTest extends Testbase {

	LoginPage lp = null;

	DownloadPage dwp = null;

	@BeforeSuite
	public void setup() throws Exception {
		driver = initialization("config.properties");
		lp = new LoginPage(driver);
		dwp=lp.navigateToDashboardPg().navigateToDownloadPg();
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyUrl() {
		testLog().info("verifying url of downloadPage");
		Assert.assertTrue(dwp.getURLOfBrowser());
	}

	@Test(priority = 2)
	public void verifyTitle() {
		Assert.assertTrue(dwp.getTitleOfBrowser() );
	}

	@Test(priority = 4)
	public void verifyHeading() {
		Assert.assertTrue(dwp.getHeading() );
	}

	@Test(priority = 5)
	public void verifySubHeading() {
		Assert.assertTrue(dwp.getSubHeading() );
	}

	@Test(priority = 6)
	public void verifyFooter() {
		Assert.assertTrue(dwp.getFooter());
	}

	@Test(priority = 7)
	public void headingOfTable() throws Exception {
		Assert.assertTrue(dwp.checkHeader() );
	}

	@Test(priority = 8)
	public void checkNavigation() {
		
		Assert.assertTrue(dwp.getNavigator());
	}

	@Test(priority = 9)
	public void checkRightCornerHeading() {
		Assert.assertTrue(dwp.getRightCornerHeading() );
	}

	@Test(priority = 10)
	public void checkLeftCornerHeading() {
		Assert.assertTrue(dwp.getNmKiran());
	}

	@Test(priority = 11)
	public void verifyUserStatus() {
		Assert.assertTrue(dwp.getStatus());
	}

	@Test(priority = 12)
	public void checkImage() {
		Assert.assertTrue(dwp.imageDisplay());
	}

	@Test(priority = 13)
	public void leftCornerHeading() {
		Assert.assertTrue(dwp.getheadJBK());
	}

	@Test(priority=14)
	public void verifyNmsFor32bitBtn() {
		
		Assert.assertTrue(dwp.getNmFor32bit() );
	}

	@Test(priority=15)
	public void verifyNmsFor64bitBtn() {
		
		Assert.assertTrue(dwp.getNmFor64bit() );
	}

	@Test(priority=16)
	public void verifyNmsForCommanBtnAndOtherBtn() {
		
		Assert.assertTrue(dwp.getNmForCommonbtnAndOther() );
	}

	@Test(priority=17)
	public void verifyNmsForCommanColumnBlankEntry() {
		
		Assert.assertTrue(dwp.getNmForCommonColBlankData() );
	}

	@Test(priority=18)
	public void verifyVendorForVersion76() {
		
		Assert.assertTrue(dwp.getNmForVersion76() );
	}

	@Test(priority=19)
	public void verifyVendorForOfficialWebsiteColumn() {
	
		Assert.assertTrue(dwp.getNmForOfficialWeb() );
	}
	@Test (priority=20)
	public void verifyComplete_DownloadsTable() throws Exception
	{
		Assert.assertTrue(dwp.completeDownloadsTable());
	}
	@Test(priority=21)
	public void verifyVendorAndVersionFor_32bit() throws Exception{
		
		Assert.assertTrue(dwp.getVendorAndVersionFor32bit());
	}
}
