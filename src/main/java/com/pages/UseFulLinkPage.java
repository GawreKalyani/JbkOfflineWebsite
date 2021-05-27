package com.pages;


import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.objectRepositary.UsefulLinkPgObjectRepositary;
import com.utility.ExcelUtility;
import com.utility.Utility;

public class UseFulLinkPage extends UsefulLinkPgObjectRepositary{
WebDriver driver;
	public UseFulLinkPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickLogout() {
		logoutBtn.click();
		return new LoginPage(driver);
	}
	public boolean getURLOfBrowser() {
		String expected = "file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/links.html";
		String actual= driver.getCurrentUrl();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getTitleOfBrowser() {
		String expected="JavaByKiran | Useful Links";
		String actual= driver.getTitle();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	
	public boolean getHeading(){	
		String expected="Useful Links";
		String actual=Utility.stringText(heading);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getStatus() {
		String expected="Online";
		String actual=Utility.stringText(onlineStatus);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getheadJBK() {
		String expected="Java By Kiran";
		String actual=Utility.stringText(jbk);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getNmKiran() {
		String expected="Kiran";
		String actual=Utility.stringText(kiranHead);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean checkHeader() throws Exception {
		ArrayList<String> actData=Utility.getActualListOfHeadingOfTable(headers);
		
		ArrayList<String>exp=ExcelUtility.readRow("Data.xlsx", "rowUsefulHeader", 0);
		
		if(actData.equals(exp))
			return true;
		else
			return false;
	}
	public boolean imageDisplay() {
		return image.isDisplayed();
	}
	public boolean getSubHeading(){
		String expected="* Internet Required";
		String actual=Utility.stringText(subheading); 
		if(actual.equals(expected))
			return true;
		else
			return false;
		}
	public boolean getRightCornerHeading() {
		String expected="Home Useful Links";
		String actual=Utility.stringText(homeUseFulRight);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	
	public boolean getFooter() {
		String expected = "Design for Selenium Automation Test V 2.3.0\n"
				+ "Copyright © 2005-2019 JavaByKiran. All rights reserved.";
		String actual=Utility.stringText(footer);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getNavigator() {
		ArrayList<String> expNavigationMenuText=Utility.getExpectedNavigation();
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : navigator) {
			String text = element.getText();
			actData.add(text);
		}
		if(actData.equals(expNavigationMenuText))
			return true;
		else
			return false;
	}
	
	public boolean getUsefulLinkTableRowdata() throws Exception{
		ArrayList<String> expData=Utility.getActualTableRowData(tableData);
		ArrayList<String> actData=ExcelUtility.getExcelTableRowData("Data.xlsx","useful");
		
			if(actData.equals(expData))
				return true;
			else
				return false;
	}
	
	public boolean contentForClickCol(){
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Schedule");
		expData.add("Video Lactures All Topics");
		expData.add("Selenium Interview Questions");
		expData.add("Java Interview Questions");
		expData.add("Courses");
		expData.add("Placement");
		
		int i=0;
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:goCol){
			String text=element.getText();
			if(text.contains("Go !"))
			{
			   String name=content.get(i).getText();
				System.out.println(name);
				actData.add(name);
			}
			i++;
		}
	if(actData.equals(expData))
			return true;
	else
		return false;
	}
	public boolean clickGO() throws Exception
	{
		ArrayList <String>actData =Utility.getWindowHandleVerifyingTitle(driver, goCol);
		
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Page not found | javabyKiran");
		expData.add("Page not found | javabyKiran");
		expData.add("Page not found | javabyKiran");
		expData.add("Page not found | javabyKiran");
		expData.add("Live Videos | javabyKiran");
		expData.add("Page not found | javabyKiran");
	
		if(actData.equals(expData))
			return true ;
		else 	
			return false ;	
	}
	
	public boolean clickGoExcel() throws Exception 
	{
		ArrayList <String>actData = Utility.getWindowHandleVerifyingTitle(driver, goCol);
		
		ArrayList <String>expData =ExcelUtility.getDataOfAnyColumn("Data.xlsx","goLink",0);

		if(actData.equals(expData))
			return true ;
		else 	
			return false ;	
	}
	
	public boolean complete_UsefulLinksTable() throws Exception 
	{
		ArrayList <String>actData=Utility.getActualDataOfTableFully(headers, tableData);
		ArrayList <String>expData=ExcelUtility.getTableDataFully("Data.xlsx","useful");
		
		if(actData.equals(expData))
			return true ;
		else 	
			return false ;
	}
}
