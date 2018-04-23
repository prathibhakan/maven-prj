package com.ScreenFunctions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Changepassword extends GenericFunctions{

	//Change Password link from Admin home page in Admin module
	@FindBy(how=How.XPATH,using="//a[text()='Change password']")
	public static WebElement admin_changepwd_lnk;
	
	//Enter old password from Change password page in admin module
	@FindBy(how=How.XPATH,using="//input[@name='old_password']")
	public static WebElement admin_changepassword_enterOldPassword_edi;
	
	//Enter New password from Change password page in admin module
	@FindBy(how=How.XPATH,using="//input[@name='new_password']")
	public static WebElement admin_changepassword_enterNewPassword_edi;
		
	//Enter password again from Change password page in admin module
	@FindBy(how=How.XPATH,using="//input[@name='again_password']")
	public static WebElement admin_changepassword_enterPasswordAgain_edi;
	
	//Click change password button from Change password page in admin module
	@FindBy(how=How.XPATH,using="//input[@name='change_password']")
	public static WebElement admin_changepassword_changePassword_btn;
	
	
	/****************************************************************************
	  Function name: changePwd
	  
	  Purpose: This function is used Change the Password in Change password page by clicking on Change password link
	  
	  Input Parameters: NA
	  
	  Output Parameters: This method will return boolean value based on the details given in the form
	  
	  Author : Prathibha K
	  
	  Creation Date: 04-09-2018  	
	  
	**************************************************************************** */
	
	public static boolean changePwd()
	{
		boolean status=true;
		//Check whether Change Password link is found or not 
			status = waitForElement(admin_changepwd_lnk);
			System.out.println("Change password link found");
			//If Change password link found then click on it
			status = hoverAndClick(admin_changepwd_lnk);
			System.out.println("Change Password link clicked");
			
			//Get the no.of invalid links by using cssSelector 
			List<WebElement>links=driver.findElements(By.cssSelector("input:invalid"));
			int invalidCount = links.size();
			System.out.println("Total no.of Invalid fields in Change Password page are: " +invalidCount);
			
			/*status= elementEnabled(admin_changepassword_enterOldPassword_edi);
			if(status)
			{
				String oldPassword=getdata("ChangePassword", "EnterOldPassword", 1);
				status=setData(admin_changepassword_enterOldPassword_edi,oldPassword);
				System.out.println("Old Password entered ..");
			}*/
			
			status = elementEnabled(admin_changepassword_enterNewPassword_edi);
			if(status)
			{
				String newPassword = getdata("ChangePassword", "EnterNewPassword", 1);
				status = setData(admin_changepassword_enterNewPassword_edi, newPassword);
				System.out.println("New Password entered");
			}
			
			status = elementEnabled(admin_changepassword_enterPasswordAgain_edi);
			if(status)
			{
				String passwordAgain = getdata("ChangePassword", "EnterPasswordAgain", 1);
				status = setData(admin_changepassword_enterPasswordAgain_edi, passwordAgain);
				System.out.println("Password  again entered");
			}
			
				status = hoverAndClick(admin_changepassword_changePassword_btn);
				System.out.println("Password  again entered");
			
				//Again get again the no.of invalid links by using cssSelector 
				//Get the no.of invalid links by using cssSelector 
				List<WebElement>links1=driver.findElements(By.cssSelector("input:invalid"));
				int invalidCount2 = links1.size();
				System.out.println("Total no.of Invalid fields again in Change Password page are: " +invalidCount2);
			
			if(invalidCount2==0)
			{
				System.out.println("User able to change password");
			}
			else
			{
				System.out.println("Not able to change");
			}
		return status;
		
	}
	
	
}
