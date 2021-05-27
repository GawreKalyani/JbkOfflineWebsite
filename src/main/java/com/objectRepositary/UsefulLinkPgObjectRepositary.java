package com.objectRepositary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utility.PageBase;

public class UsefulLinkPgObjectRepositary extends PageBase {
	@FindBy(linkText="LOGOUT")
	public WebElement logoutBtn;
	
	@FindBy(xpath="//b[contains(text(),'Java')]")
	public WebElement jbk;
	
	@FindBy(xpath="//a[text()=' Online']")
	public WebElement onlineStatus;
	
	@FindBy(xpath="//p[text()='Kiran']")
	public WebElement kiranHead;
	
	@FindBy(tagName="img")
	public WebElement image;
	
	@FindBy(tagName="h1")
	public WebElement heading;

	@FindBy(xpath="//h3[@class='box-title']")
	public WebElement subheading;
	
	@FindBy(xpath="//footer")
	public WebElement footer;
	
	@FindBy(xpath="//td")
	public List<WebElement>tableData;

	@FindBy(xpath="//span[contains(text(),'Go !')]//preceding::li//span")
	public List<WebElement>navigator;
	
	@FindBy(xpath="//ol")
	public WebElement homeUseFulRight;
	
	@FindBy(xpath="//th")
	public List<WebElement>headers;

	@FindBy(xpath="//span[text()='Go !']")
	public List<WebElement> goCol;
	
	@FindBy(xpath="//td[2]")
	public List<WebElement> content;
}
