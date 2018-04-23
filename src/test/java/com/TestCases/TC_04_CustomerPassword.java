package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Bank_Login_Generic;
import com.ScreenFunctions.Changepassword;

public class TC_04_CustomerPassword extends GenericFunctions{

	@Test
	public static void custPwd()
	{
		//Launch Application by passing browser name  as parameter
		GenericFunctions gnf = new GenericFunctions();
		gnf.launchApplication("firefox");
		
		//Initialize elements of login page using page Factory class
		Bank_Login_Generic lgnbnk = PageFactory.initElements(driver, Bank_Login_Generic.class);
		lgnbnk.adminLogin();
		
		//Initialize elements of Change Password using Page Factory class
		Changepassword changePwd = PageFactory.initElements(driver, Changepassword.class);
		changePwd.changePwd();
	}
}

