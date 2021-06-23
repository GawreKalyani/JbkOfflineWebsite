package com.utility;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectMutipleOption {
	public static void selectMultiple(WebElement element,List<String>options)
	{	Select s=new Select(element);
		if(s.isMultiple())
		{
			for(String option:options)
				s.selectByVisibleText(option);
		}
	}
	public static void selectMultiple(List<String>options,WebElement element)
	{	Select s=new Select(element);
		if(s.isMultiple())
		{
			for(String option:options)
				s.selectByValue(option);
		}
	}
}