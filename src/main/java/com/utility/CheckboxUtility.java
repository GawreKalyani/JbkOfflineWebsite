package com.utility;

import java.util.List;

import org.openqa.selenium.WebElement;

public class CheckboxUtility {

	public static void checkbox(List<String>strings,List<WebElement>elements){
		for(String s:strings)
		{
			for(WebElement element:elements)
			{
				if(element.getAttribute("value").equals(s))
				{
					element.click();
					break;
				}
			}
		}
	
	}
}
