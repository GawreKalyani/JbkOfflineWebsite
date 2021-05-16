package com.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import com.objectRepositary.LoginPgObjectRepositary;

public class LoginPage extends LoginPgObjectRepositary {
	
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public boolean getURLOfBrowser() {
		String expected = "file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/index.html";
		String actual= driver.getCurrentUrl();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getTitleOfBrowser() {
		String expected="JavaByKiran | Log in";
		String actual= driver.getTitle();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getPlaceholders(){
		ArrayList<String>expData=new ArrayList<String>();
		expData.add("Email");
		expData.add("Password");
		
		ArrayList<String>actData=new ArrayList<String>();
		for(WebElement ele:placeholder){
			String text=ele.getAttribute("placeholder");
			actData.add(text);
		}
		if(actData.equals(expData))
			return true;
		else
			return false;
	}
	
	public boolean getHeading1(){
		String expected="Java By Kiran";
		String actual= head1.getText();
		 if(actual.equals(expected))
				return true;
			else
				return false;
	}
	public boolean getHeadingCourses(){
		String expected="JAVA | SELENIUM | PYTHON";
		String actual= head2.getText();
		 if(actual.equals(expected))
				return true;
			else
				return false;
	}
	public boolean getHeadingSign(){
		String expected="Sign in to start your session";
		String actual= signhead.getText();
		 if(actual.equals(expected))
				return true;
			else
				return false;
	}
	
	public boolean displayImage(){
		if(logo.isDisplayed()==true)
		{
			System.out.println("Logo is displayed");
			return true ;
		}
		else
		{
			System.out.println("Logo is not displayed");
			return false ;
		}
	}
	public boolean loginSuccessfully(){
		uname.sendKeys("kiran@gmail.com");
		pass.sendKeys("123456");
		loginButton.click();
		String actual=driver.getTitle();
		String expected="JavaByKiran | Dashboard";
		logout.click();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	public boolean getErrorMsgForBlankEntry(){
		
			uname.sendKeys("");
			pass.sendKeys("");
			loginButton.click();
			
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
			uname.sendKeys("kk@gmail.com");
			pass.sendKeys("yyy");
			loginButton.click();
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
		
		registerLink.click();
		String expected="JavaByKiran | Registration Page";
		String actual= driver.getTitle();
		if(actual.equals(expected))
			return true;
		else
			return false;
	}
	
	
	
}
