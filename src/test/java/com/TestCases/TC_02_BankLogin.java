package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.ApplyLeave;
import com.ScreenFunctions.Bank_Login_Generic;
import com.ScreenFunctions.Dashboard;
import com.ScreenFunctions.Login;
import com.ScreenFunctions.Login_Bank;

public class TC_02_BankLogin extends GenericFunctions{

	@Test
	public static void BankLogin()
	{
		//Step1:-Launch Appplication
		GenericFunctions gnf=new GenericFunctions();
		gnf.launchApplication("firefox");
		
		//Step2:Enter Login Credentials from Bank_Login_Generic class
	
		Bank_Login_Generic lgnbnk = PageFactory.initElements(driver, Bank_Login_Generic.class);
		
		lgnbnk.adminLogin();
	}		
}
