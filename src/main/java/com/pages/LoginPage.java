package com.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.objectRepositary.LoginPgObjectRepositary;

import com.utility.Utility;


public class LoginPage extends LoginPgObjectRepositary {
	
WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public RegisterPage navigateToRegisterPg(){
		Utility.click(registerLink);
		return new RegisterPage(driver);
	}
	public DashboardPage navigateToDashboardPg(){
		Utility.sendkeys(uname, "kiran@gmail.com");
		Utility.sendkeys(pass, "123456");
		Utility.click(loginButton);
		return new DashboardPage(driver);
		}
	
	public boolean getURLOfBrowser() {
		pageLog().info("Verifying url of loginPage");
		String expected = "file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html";
		String actual= driver.getCurrentUrl();
		if(actual.equals(expected))
		{
			pageLog().info("Url is matched");
			return true;
		}
		else{
			pageLog().info("Url is  not matched");
			return false;
			}
	}
	public boolean getTitleOfBrowser() {
		String expected="JavaByKiran | Log in";
		String actual= driver.getTitle();
		if(actual.equals(expected))
		{
			
			return true;
		}
		else{
			
				return false;
			}
	}
	public void login(String email,String password){
		Utility.sendkeys(uname, email);
		Utility.sendkeys(pass, password);
		Utility.click(loginButton);
	}
	
	public boolean getPlaceholders(){
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Email");
		expData.add("Password");
		
		pageLog().info("verifying placeholders for email and password Textbox");
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement ele:placeholder){
			String text=ele.getAttribute("placeholder");
			actData.add(text);
		}
		if(actData.equals(expData)){
			pageLog().info("Actual getting matched with expected");
			return true;}
		else{
			pageLog().info("Actual not getting matched with expected");
			return false;}
	}
	
	public boolean getHeading1(){
		String expected="Java By Kiran";
		String actual=Utility.stringText(head1);
		 if(actual.equals(expected))
				return true;
			else
				return false;
	}
	public boolean getHeadingCourses(){
		String expected="JAVA | SELENIUM | PYTHON";
		String actual=Utility.stringText(head2);
	
		 if(actual.equals(expected))
				return true;
			else
				return false;
	}
	public boolean getHeadingSign(){
		String expected="Sign in to start your session";
		String actual=Utility.stringText(signhead);
	
		 if(actual.equals(expected))
				return true;
			else
				return false;
	}
	
	public boolean displayImage(){
		if(logo.isDisplayed()==true)
		{
			
			return true ;
		}
		else
		{
			pageLog().info("Logo is not displayed");
			return false ;
		}
	}
	public boolean loginSuccessfully(){
		login("kiran@gmail.com","123456");
		
		String actual=Utility.getTitle(driver);
		String expected="JavaByKiran | Dashboard";
		
		if(actual.equals(expected)){	
			pageLog().info("Title is matched");
			return true;
			}
		else{	
			pageLog().info("Title is not matched");
			return false;
			}
	}
	public boolean getErrorMsgForBlankEntry(){
		login("","");
	
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Please enter email.");
		expData.add("Please enter password.");
				
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement ele:errormsg){
			String text=ele.getText();
			actData.add(text);
		}
		 if(actData.equals(expData))
				return true;
			else
				return false;
	}
	public boolean getErrorMsgForInvalidEntry(){
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Please enter email as kiran@gmail.com");
		expData.add("Please enter password 123456");
		login("kk@gmail.com","yyy");
		
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement ele:errormsg){
			String text=ele.getText();
			actData.add(text);
		}
		 if(actData.equals(expData))
				return true;
			else
				return false;
	}
	public boolean getTitleOfRegisterPg() {
		Utility.click(registerLink);
		
		String expected="JavaByKiran | Registration Page";
		String actual= driver.getTitle();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	
	public void loginWithAllData(HashMap<String,String>hm)
	{
			Set<String>keys=hm.keySet();
			for(String key:keys)
			{
				Utility.sendkeys(uname, key);
				Utility.sendkeys(pass, hm.get(key));
				Utility.click(loginButton);
				if(Utility.getTitle(driver).contains("Dashboard"))
				{
					DashboardPage dp=new DashboardPage(driver);
					dp.clickLogout();
				}
				else
				{
					Utility.clear(uname);
					Utility.clear(pass);
				}
			}
	  }
	
}

