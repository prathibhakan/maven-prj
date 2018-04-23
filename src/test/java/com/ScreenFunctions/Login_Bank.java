package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Login_Bank extends GenericFunctions{

	//Admin link 
		@FindBy(how=How.XPATH,using="//a[(text()='Admin ')]")
		public static WebElement lnk_admin;
	
	//Username	
		@FindBy(how=How.XPATH, using="//input[@name='uname']")
		public static WebElement txt_username;
		
	//Password		
		@FindBy(how=How.XPATH,using="//input[@name='pwd']")
		public static WebElement txt_password;

	//login button
		@FindBy(how=How.XPATH,using="//input[@name='submitBtn']")
		public static WebElement btn_login;
		
		
		/*************************************************
		
		Function Name:Login_Admin
		
		Purpose:-This Function is used to login into the Banking Application as an Admin when ever the user is required
		
		Input Parameters:-NA
		
		Output Parameters:-This method will return a boolean value stating whether the user logged into in the system with the valid credentials
		
		Author:-Prathibha
		
		Creation date:-04/04/2018
		
		**************************************************/
		
		
		public static boolean login_Admin() {
			boolean status = true;

			// Wait forAdminLink to be visible
			status = waitForElement(lnk_admin);
			if (status) {
				// get the status of the admin link and click on it
				try {
					lnk_admin.click();
					System.out.println("Admin Link is clicked sucessfully");
				} catch (Exception e) {
					status = false;
				}

				// once the above step is true and continue to enter username and password
				if (status) {
					try {
						String username = getCommontestdata("Username");
						txt_username.click();
						txt_username.clear();
						txt_username.sendKeys(username);

					}

					catch (Exception e) {
						status = false;
					}

					if (status) {

						// Enter password

						try {
							String password = getCommontestdata("Password");
							txt_password.click();
							txt_password.clear();
							txt_password.sendKeys(password);

						}

						catch (Exception e) {
							status = false;
						}

						// Based on the Password status Click on the Login Button
						if (status) {

							try {
								btn_login.click();

							}

							catch (Exception e) {
								status = false;
							}

						}

					}

				}

			}

			return status;

		}

	}
