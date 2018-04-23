package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Bank_Login_Generic;
import com.ScreenFunctions.Changepassword;
import com.ScreenFunctions.DeleteCustomer;

public class TC_05_DeleteCustomer extends GenericFunctions{
	@Test
	public static void deleteCust()
	{
		//Launch Application by passing browser name  as parameter
		GenericFunctions gnf = new GenericFunctions();
		gnf.launchApplication("firefox");
		
		//Initialize elements of login page using page Factory class
		Bank_Login_Generic lgnbnk = PageFactory.initElements(driver, Bank_Login_Generic.class);
		lgnbnk.adminLogin();
		
		//Initialize elements of Change Password using Page Factory class
		DeleteCustomer deltCust = PageFactory.initElements(driver, DeleteCustomer.class);
		deltCust.deleteCustomer();
	}
}