package com.qa.PageEvents;

import com.qa.PageElements.HomePageElements;
import com.qa.utils.ElementFetch;

public class HomePageEvents {
	ElementFetch ele = new ElementFetch();
	
	public void SignInButton()
	{
		ele.getWebElement("XPATH", HomePageElements.signInButtonText).click();
	}

}
