package com.objectRepositary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utility.PageBase;

public class RegisterPgObjectRepositary extends PageBase{
	@FindBy(tagName="b")
	public WebElement heading1;

	@FindBy(xpath="//div[contains(@id,'error')]")
	public List<WebElement> rgErrormsg;

	@FindBy(id="name")
	public WebElement name;

	@FindBy(id="mobile")
	public WebElement mobile;

	@FindBy(id="email")
	public WebElement uname;

	@FindBy(id="password")
	public WebElement pass;

	@FindBy(xpath="//button")
	public WebElement loginButton;

	@FindBy(xpath="//a[contains(text(),'I')]")
	public WebElement alreadyMember;
	
	@FindBy(xpath="//input")
	public List<WebElement>placeholdersList;
	
	
}
