package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Bank_Login_Generic extends GenericFunctions{
	  @FindBy(how=How.XPATH,using="//input[@name='uname']")
	    public static WebElement Admin_edi_Username;
		 
		 @FindBy(how=How.XPATH,using="//input[@name='pwd']")
		 public static WebElement Admin_edi_Password;
		 
		 @FindBy(how=How.XPATH,using="//input[@name='submitBtn']")
		 public static WebElement Admin_btn_Login;
		 
		 public static void adminLogin(){
			 boolean status=true;
			 
			 status=waitForElement(Admin_edi_Username);
			 if(status)	{
				 System.out.println("UserName Found ..");
				 //get the userName name from the CommonTestData sheet	
				  String userName= getCommontestdata("Username");
				  status=setData(Admin_edi_Username,userName);
				   }
			else {
				System.out.println("UserName Not-Found ..");
			}
			 
			 status=waitForElement(Admin_edi_Password);
			 if(status)	{
				 System.out.println("PAssword Found ..");
				 //get the PAssword name from the CommonTestData sheet	
				  String passWord= getCommontestdata("Password");
				  status=setData(Admin_edi_Password,passWord);
			   }
			else {
				System.out.println("PAssword Not-Found ..");
			  }
			 
			 status=hoverAndClick(Admin_btn_Login);
			 if(status)	{
				 System.out.println("Admin Login Button Clicked ..");
				   }
			else {
				System.out.println("Admin Login Button Not-Found ..");
			 }
		 }
	}
