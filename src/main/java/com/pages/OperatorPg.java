package com.pages;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.objectRepositary.OperatorPgObjectRepositary;
import com.utility.ExcelUtility;
import com.utility.Utility;

public class OperatorPg extends OperatorPgObjectRepositary{
	WebDriver driver;

	public OperatorPg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public LoginPage clickLogout() {
		logoutBtn.click();
		return new LoginPage(driver);
	}
	public boolean getURLOfBrowser() {
		String expected = "file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/operators.html";
		String actual= driver.getCurrentUrl();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getTitleOfBrowser() {
		String expected="JavaByKiran | Operators";
		String actual= driver.getTitle();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getHeading() {
		String expected="Operators";
		String actual=Utility.stringText(heading);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getSubHeading() {
		String expected="Operator List";
		String actual=Utility.stringText(subheading);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean imageDisplay() {
		return image.isDisplayed();
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
	 public boolean getSortedNms() {
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Darshit");
		expData.add("Kiran");
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		
		ArrayList<String> actData = new ArrayList<String>();
		for (WebElement element : personNames) {
			String text = element.getText();
			actData.add(text);
		}
		Collections.sort(actData);
		if(actData.equals(expData))
			return true;
		else
			return false;	
	}
	public boolean checkHeaders() throws Exception {
		ArrayList<String> actData =Utility.getActualListOfHeadingOfTable(headers);
		ArrayList<String> expData=ExcelUtility.getTableColumnData("Data.xlsx","operatorHeader",0);
	
		if(actData.equals(expData))
			return true;
		else
			return false;
	}
	public boolean getOperatorTableRowdata() throws Exception{
		
		ArrayList<String> expData=ExcelUtility.getExcelTableRowData("Data.xlsx","operator");
		ArrayList<String> actData =Utility.getActualTableRowData(tableData);
		
			if(actData.equals(expData))
				return true;
			else
				return false;
	}

	public boolean getFooter() {
		String expfooter = "Design for Selenium Automation Test V 2.3.0\n"
				+ "Copyright © 2005-2019 JavaByKiran. All rights reserved.";
		String actual=Utility.stringText(footer);
		if(actual.equals(expfooter))
			return true;
		else
			return false;
	}
	public boolean getRightCornerHeading() {
		String expected="Home Operators";
		 String actual=Utility.stringText(homeUserRight);
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
	
	public boolean getNmKiran() {
		String expected="Kiran";
		String actual=Utility.stringText(kiranHead);
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean teachersNamesForMobNoStarting88(){
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Seema");
		expData.add("Varsha");
		expData.add("Darshit");
		int i=0;
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:mob){
			String text=element.getText();
			if(text.substring(0,2).equals("88"))
			{
				String name=personNames.get(i).getText();
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
	
	public boolean teachersNotPresentOnSunday(){
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Neelam");
		expData.add("Seema");
		int i=0;
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:timings){
			String text=element.getText();
			if(!text.contains("Sunday"))
			{
			     //row2 names
				String name=personNames.get(i).getText();
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
	
	public boolean teacherPresentOnMonday(){
		int i=0;
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kiran");
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:timings){
			String text=element.getText();
			if(text.contains("Monday"))
			{
				String name=personNames.get(i).getText();
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
	public boolean teacherPresentOnSunday(){
		ArrayList<String>actData=new ArrayList<String>();
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kiran");
		expData.add("Varsha");
		expData.add("Darshit");
		int i=0;
		for(WebElement element:timings){
			String text=element.getText();
			if(text.contains("Sunday"))
			{
				String name=personNames.get(i).getText();
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
	
	
	public boolean teacherPresentOnMondaySaturday(){
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Neelam");
		expData.add("Seema");
		int i=0;
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:timings){
			String text=element.getText();
			if(text.contains("Monday") && text.contains("Saturday"))
			{
				String name=personNames.get(i).getText();
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
	 public boolean teacherPresentForUrgentHelp(){
		ArrayList<String> expData = new ArrayList<String>();
		expData.add("Kiran");
		int i=0;
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement element:helpfor){
			String text=element.getText();
			if(text.contains("Urgent Technical Help"))
			{
				
				String name=personNames.get(i).getText();
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
	public boolean prefferedWayToConnect_WhatsApp_AND_PhoneCall(){
		ArrayList<String>actData=new ArrayList<String>();
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		int i=0;
		for(WebElement ele:preferWay){
			String contact=ele.getText();
			if(contact.contains("Whats App")&& contact.contains("Phone Call")){
				String faculty=personNames.get(i).getText();
				actData.add(faculty);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}
	public boolean prefferedWayToConnect_WhatsApp(){
		ArrayList<String>actData=new ArrayList<String>();
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Kiran");
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		expData.add("Darshit");
		int i=0;
		for(WebElement ele:preferWay){
			String contact=ele.getText();
			if(contact.contains("Whats App")){
				String faculty=personNames.get(i).getText();
				actData.add(faculty);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}
	public boolean prefferedWayToConnect_PhoneCall(){
		ArrayList<String>actData=new ArrayList<String>();
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		
		int i=0;
		for(WebElement ele:preferWay){
			String contact=ele.getText();
			if(contact.contains("Phone Call")){
				String faculty=personNames.get(i).getText();
				System.out.println(faculty);
				actData.add(faculty);
			}
			i++;
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
		}
	public boolean contactNoLength()
	{	
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Kiran");
		expData.add("Neelam");
		expData.add("Seema");
		expData.add("Varsha");
		expData.add("Darshit");
		
		System.out.println("Faculties having 10 digit Mobile No. : ");
	
		int i=0 ;
		
		for (WebElement element : mob)
		{
			String contact = element.getText();
			
			if (contact.length()==10)
			{
				String faculty = personNames.get(i).getText();
				System.out.println(faculty);
				actData.add(faculty);
			}
			i++ ;
		}
		
		if(actData.equals(expData))
			return true ;
		else 	
			return false ;
	}
	public boolean prefferedWayToConnect_WhatsApp_ButNot_PhoneCall ()
	{
		ArrayList <String>actData = new ArrayList <String>();
		
		ArrayList <String>expData = new ArrayList <String>();
		expData.add("Kiran");
		expData.add("Darshit");
		
		System.out.println("Faculties available on WhatsApp but not on Phone Call : ");
	
		int i=0 ;
		
		for (WebElement element : preferWay)
		{
			String contact = element.getText();
			
			if (contact.contains("Whats App"))
			{
				if (!contact.contains("Phone Call"))
				{
					String faculty = personNames.get(i).getText();
					//System.out.println(faculty);
					actData.add(faculty);
				}
			}
			i++ ;
		}
		
		if(actData.equals(expData))
			return true ;
		else 	
			return false ;
	}
	
	public boolean CompleteOperatorsTable () throws Exception
	{	ArrayList <String>actData=Utility.getActualDataOfTableFully(headers, tableData);
		ArrayList <String>expData=ExcelUtility.getTableDataFully("Data.xlsx","operatorTable");
		
		if(actData.equals(expData))
			return true ;
		else 	
			return false ;
	}
	public boolean getUserNmForWhatsApp() throws Exception {
		HashMap<String,String>exphm=ExcelUtility.readUnameAndPass("Data.xlsx","whatsappOnly", 0, 1);
		pageLog().info("Exp:"+exphm);
		Map<String, String>actualhm=Utility.getActualDataUsingMap("Whats App Only", personNames, preferWay);
		pageLog().info("Acr:"+actualhm);
	
	if(actualhm.equals(exphm))
			return true ;
		else 	
			return false ;
	}

		
	
}
