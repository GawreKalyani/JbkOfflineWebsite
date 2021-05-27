package com.pages;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import com.objectRepositary.RegisterPgObjectRepositary;
import com.utility.Utility;

public class RegisterPage extends RegisterPgObjectRepositary {
	WebDriver driver;

	public RegisterPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean getUrl()
	{
		String expectedUrl = "file:///C:/Users/rajat/Downloads/Selenium%20Softwares/Offline%20Website/Offline%20Website/pages/examples/register.html" ; 
		String actualUrl = driver.getCurrentUrl() ;
		
		if(actualUrl.equals(expectedUrl))
		{
			System.out.println("Url is matched");
			return true ;
		}
		else
		{
			System.out.println("Url is not matched");
			return false ;
		}
	}
	public boolean getTitleOfPage() 
	{ 	
		String expectedTitle = "JavaByKiran | Registration Page" ; 
		String actualTitle = driver.getTitle() ;
		
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Title is matched");
			return true ;
		}
		else 
		{
			System.out.println("Title not matched");
			return false ;
		}		
	}
	public boolean heading() 
	{ 	
		String actualHeading =Utility.stringText(heading1);
		String expectedHeading = "Java By Kiran" ;
		
		if(actualHeading.equals(expectedHeading))
		{
			System.out.println("Heading is matched");
			return true ;
		}
		else 
		{
			System.out.println("Heading not matched");
			return false ;
		}
	}
	public boolean alreadyMemberText() 
	{ 	
		String actualAlreadyMemberLinkText = Utility.stringText(alreadyMember);
		String expectedAlreadyMemberLinkText = "I already have a membership" ;
		
		if(actualAlreadyMemberLinkText.equals(expectedAlreadyMemberLinkText))
		{
			System.out.println("Text is matched");
			return true ;
		}
		else 
		{
			System.out.println("Text not matched");
			return false ;
		}
	}
	public boolean placeholders() 
	{ 	
		ArrayList <String>actPlaceholderText = new ArrayList <String>();
		
		ArrayList <String>expPlaceholderText = new ArrayList <String>();
		expPlaceholderText.add("Name");
		expPlaceholderText.add("Mobile");
		expPlaceholderText.add("Email");
		expPlaceholderText.add("Password");
		
		for (WebElement element : placeholdersList)
		{
			actPlaceholderText.add(element.getAttribute("placeholder"));
		}
		
		if(actPlaceholderText.equals(expPlaceholderText))
		{
			System.out.println("Placeholders are matched");
			return true ;
		}
		else 
		{
			System.out.println("Placeholders are not matched");
			return false ;
		}
	}
	public boolean validSignIn() 
	{
		Utility.sendkeys(name, "Alisha");
		Utility.sendkeys(mobile, "9666666612");
		Utility.sendkeys(uname, "alisha@gmail.com");
		Utility.sendkeys(pass, "123999");
		Utility.click(loginButton);
	
		String alMessage=Utility.alertHandle(driver);
		System.out.println(alMessage);
		if(alMessage.equals("User registered successfully."))
		{
			System.out.println("Registered successfully.");
			return true ;
		}
		else 
		{
			System.out.println("Registered unsuccessfully.");
			return false ;
		}
	}
	public boolean invalidDataEntry()
	{	Utility.clear(name);
		Utility.clear(mobile);
		Utility.clear(uname);
		Utility.clear(pass);
		Utility.sendkeys(name, "uo");
		Utility.sendkeys(mobile, "96");
		Utility.sendkeys(uname, "ala");
		Utility.sendkeys(pass, "1239");
		Utility.click(loginButton);		
				
		
		String alMessage=Utility.alertHandle(driver);
		System.out.println(alMessage);
		if(alMessage.equals("User registered successfully."))
		{
			System.out.println("Registered successfully.");
			return true ;
		}
		else 
		{
			System.out.println("Registered unsuccessfully.");
			return false ;
		}
	}
	
	public boolean alreadyMemberLink() 
	{ 	Utility.click(alreadyMember);	
		
		String expectedTitle = "JavaByKiran | Log in" ; 
		String actualTitle = driver.getTitle() ;
		
		
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Link is Working Properly");
			return true ;
		}
		else 
		{
			System.out.println("Link is not Working Properly");
			return false ;
		}
	}
	
public boolean getRegPgErrorMsg(){
	Utility.clear(name);
	Utility.clear(mobile);
	Utility.clear(uname);
	Utility.clear(pass);
	Utility.sendkeys(name, "");
	Utility.sendkeys(mobile, "");
	Utility.sendkeys(uname, "");
	Utility.sendkeys(pass, "");
	Utility.click(loginButton);
	
	ArrayList<String>expData=new ArrayList<String>();
	expData.add("Please enter Name.");
	expData.add("Please enter Mobile.");
	expData.add("Please enter Email.");
	expData.add("Please enter Password.");
	
	ArrayList<String>actData=new ArrayList<String>();
	for(WebElement ele:rgErrormsg){
		String text=ele.getText();
		actData.add(text);
		System.out.println(text);
	}
	if(actData.equals(expData)){
		System.out.println("Text is matched");
		return true;
		}
	else
		{	System.out.println("Text not matched");
			return false;
		}
				
}

}
