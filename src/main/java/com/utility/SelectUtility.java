package com.utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtility { //Method Overloading
	
	public static void selectBy(WebElement element, String text) 
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public static void selectBy(String value,WebElement element) 
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public static void selectBy(int index,WebElement element) 
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
}
