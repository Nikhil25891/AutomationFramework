package com.qa.PageEvents;

import org.testng.Assert;

import com.qa.PageElements.LoginPageElements;
import com.qa.utils.ElementFetch;

public class LoginPageEvents {
	
	ElementFetch ele = new ElementFetch();
	
	public void verifyIfLoginPageIsLoaded()
	{
		Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.logInText).size()>0, "Element Not Found");
	}
	
	public void enterCredentials()
	{
		ele.getWebElement("XPATH", LoginPageElements.emailText).sendKeys("nikhilchandane94@gmail.com");
		ele.getWebElement("XPATH", LoginPageElements.passwordText).sendKeys("12345");
	}

}
