package com.objectRepositary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utility.PageBase;

public class LoginPgObjectRepositary extends PageBase{
	@FindBy(tagName="img")
	public WebElement logo;
	
	@FindBy(tagName="b")
	public WebElement head1;
	
	@FindBy(tagName="h4")
	public WebElement head2;
	
	@FindBy(tagName="p")
	public WebElement signhead;
	
	@FindBy(xpath="//div[contains(@id,'error')]")
	public List<WebElement>errormsg;
	
	@FindBy(xpath="//input")
	public List<WebElement>placeholder;
	
	@FindBy(id="email")
	public WebElement uname;
	
	@FindBy(id="password")
	public WebElement pass;
	
	@FindBy(xpath="//button")
	public WebElement loginButton;
	
	@FindBy(partialLinkText="Register")
	public WebElement registerLink;
	
	
	
}
