package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Add_Staff;
import com.ScreenFunctions.Bank_Login_Generic;
import com.ScreenFunctions.Login_Bank;

public class TC_03_AddStaff extends GenericFunctions{
	
	@Test
	public static void addStaff()
	{
		//Launch Application by passing browser name  as parameter
		GenericFunctions gnf = new GenericFunctions();
		gnf.launchApplication("firefox");
		
		//Initialize elements of login page using page Factory class
		Bank_Login_Generic lgnbnk = PageFactory.initElements(driver, Bank_Login_Generic.class);
		lgnbnk.adminLogin();
		
		//Initialize elements of Add Staff details from Add_staff class
		Add_Staff addstf = PageFactory.initElements(driver, Add_Staff.class);
		addstf.addStaff();				
		
	}

}
