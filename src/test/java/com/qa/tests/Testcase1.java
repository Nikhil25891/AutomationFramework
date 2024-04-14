package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.PageEvents.HomePageEvents;
import com.qa.PageEvents.LoginPageEvents;
import com.qa.baseTest.BaseTest;
import com.qa.utils.ElementFetch;

public class Testcase1 extends BaseTest{
	
	ElementFetch ele = new ElementFetch();
	HomePageEvents homePage = new HomePageEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	
  @Test
  public void enterCredentialsTestMethod() {
	  
	  homePage.SignInButton();
	  loginPage.verifyIfLoginPageIsLoaded();
	  loginPage.enterCredentials();
  }
}
