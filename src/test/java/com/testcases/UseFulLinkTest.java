package com.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.base.Testbase;
import com.pages.LoginPage;
import com.pages.UseFulLinkPage;

public class UseFulLinkTest extends Testbase {

	LoginPage lp = null;
	
	UseFulLinkPage ufp = null;

	@BeforeSuite
	public void setup() throws Exception {
		driver = initialization("config.properties");
		lp = new LoginPage(driver);
		ufp=lp.navigateToDashboardPg().navigateToUseFulLinkPage();
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void verifyUrl() {
		Assert.assertTrue(ufp.getURLOfBrowser());
	}

	@Test(priority = 2)
	public void verifyTitle() {
		Assert.assertTrue(ufp.getTitleOfBrowser());
	}

	@Test(priority = 3)
	public void verifyHeading() {
		Assert.assertTrue(ufp.getHeading());
	}

	@Test(priority = 4)
	public void verifySubHeading() {
		Assert.assertTrue(ufp.getSubHeading());
	}

	@Test(priority = 5)
	public void verifyFooter() {
		Assert.assertTrue(ufp.getFooter());
	}

	@Test(priority = 6)
	public void checkNavigation() {
		Assert.assertTrue(ufp.getNavigator());
	}

	@Test(priority = 7)
	public void checkRightCornerHeading() {
		Assert.assertTrue(ufp.getRightCornerHeading());
	}

	@Test(priority = 10)
	public void checkLeftCornerHeading() {
		Assert.assertTrue(ufp.getNmKiran());
	}

	@Test(priority = 11)
	public void verifyUserStatus() {
		Assert.assertTrue(ufp.getStatus());
	}

	@Test(priority = 12)
	public void checkImage() {
		Assert.assertTrue(ufp.imageDisplay());
	}

	@Test(priority = 13)
	public void leftCornerHeading() {

		Assert.assertTrue(ufp.getheadJBK());
	}

	@Test(priority = 14)
	public void checkHeadersOfTable() throws Exception {

		Assert.assertTrue(ufp.checkHeader());
	}

	@Test(priority = 15)
	public void verifyDataPresentInTable() throws Exception {
		Assert.assertTrue(ufp.getUsefulLinkTableRowdata());
	}

	@Test(priority = 16)
	public void verifyClickGO() throws Exception {
		Assert.assertTrue(ufp.clickGO());
	}

	@Test(priority = 17)
	public void verifyClickGoExcel() throws Exception {
		Assert.assertTrue(ufp.clickGoExcel());
	}

	@Test(priority = 18)
	public void verifyComplete_UsefulLinksTable() throws Exception {
		Assert.assertTrue(ufp.complete_UsefulLinksTable());
	}

	@Test(priority = 19)
	public void verifyContentForClickGo() {
		Assert.assertTrue(ufp.contentForClickCol());
	}

}
