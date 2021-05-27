package com.objectRepositary;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utility.PageBase;

public class DownloadPgObjectRepositary extends PageBase {
	@FindBy(linkText="LOGOUT")
	public WebElement logoutBtn;
	
	@FindBy(xpath="//td[3]")
	public List<WebElement> vendors;
	
	@FindBy(xpath="//th")
	public List<WebElement> headers;
	
	@FindBy(xpath="//td")
	public List<WebElement>tableData;
	
	@FindBy(xpath="//footer")
	public WebElement footer;
	
	@FindBy(xpath="//b[contains(text(),'By')]")
	public WebElement jbk;
	
	@FindBy(tagName="h3")
	public WebElement subheading;
	
	@FindBy(tagName="h1")
	public WebElement heading;
	
	@FindBy(xpath="//td[4]")
	public List<WebElement> versions;

	@FindBy(xpath="//td[5]")
	public List<WebElement> bit32s;

	@FindBy(xpath="//td[6]")
	public List<WebElement> bit64s;
	
	@FindBy(xpath="//td[7]")
	public List<WebElement> commonCol;
	
	@FindBy(xpath="//td[8]")
	public List<WebElement> official;
	
	@FindBy(xpath="//a[text()=' Online']")
	public WebElement onlineStatus;
	
	@FindBy(xpath="//p[text()='Kiran']")
	public WebElement kiranHead;
	
	@FindBy(tagName="img")
	public WebElement image;
	
	@FindBy(xpath="//ul[@class='sidebar-menu']//span")
	public List<WebElement>navigator;
	
	@FindBy(xpath="//ol")
	public WebElement homeUserRight;
}
