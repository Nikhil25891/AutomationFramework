package com.qa.utils;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.qa.baseTest.BaseTest;

public class ElementFetch 
{
	public WebElement getWebElement(String indentifierType, String IdentifierValue)
	{
		switch(indentifierType)
		{
		case "XPATH":
			return BaseTest.driver.findElement(By.xpath(IdentifierValue));
		case "CSS":
			return BaseTest.driver.findElement(By.cssSelector(IdentifierValue));
		case "ID":
			return BaseTest.driver.findElement(By.id(IdentifierValue));
		case "NAME":
			return BaseTest.driver.findElement(By.name(IdentifierValue));
		case "TAGNAME":
			return BaseTest.driver.findElement(By.tagName(IdentifierValue));
			
			default:
				return null;
		}
	}
	
	public List<WebElement> getWebElements(String indentifierType, String IdentifierValue)
	{
		switch(indentifierType)
		{
		case "XPATH":
			return BaseTest.driver.findElements(By.xpath(IdentifierValue));
		case "CSS":
			return BaseTest.driver.findElements(By.cssSelector(IdentifierValue));
		case "ID":
			return BaseTest.driver.findElements(By.id(IdentifierValue));
		case "NAME":
			return BaseTest.driver.findElements(By.name(IdentifierValue));
		case "TAGNAME":
			return BaseTest.driver.findElements(By.tagName(IdentifierValue));
			
			default:
				return null;
		}
	}
}
