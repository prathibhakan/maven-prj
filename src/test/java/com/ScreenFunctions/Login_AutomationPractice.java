package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Login_AutomationPractice extends GenericFunctions{
	@FindBy(how=How.XPATH,using="//a[normalize-space(text())='Signin']")
	public static WebElement automation_signIn_lnk;
	@FindBy(how=How.XPATH,using="//input[@id='email_create']")
	public static WebElement automation_Email_edi;
	
	public static boolean signIn()
	{
		boolean status = true;
		status = hoverAndClick(automation_signIn_lnk);
		if(status)
		{
			System.out.println("Sign in link clicked");
			logEvent("Pass", "Sign in link clicked");
		}
		else{
			System.out.println("Sign in link not clicked");
			logEvent("Fail", "Sign in link not clicked" );
		}
		
		status = elementEnabled(automation_signIn_lnk);
		
		
		return status;		
	}
}
