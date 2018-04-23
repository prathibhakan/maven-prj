package com.ScreenFunctions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class DeleteCustomer extends GenericFunctions{

	//Delete Customer link from Admin home page in Admin module
	@FindBy(how=How.XPATH,using="//a[text()='Delete customer']")
	public static WebElement admin_delete_customer_lnk;
	
	//Delete Customer Details link from Delete customer page in Admin module
	@FindBy(how=How.XPATH,using="//table[2]//input")
	public static WebElement admin_delete_customer_delCustDet_lnk;
	
	//Table data from Delete customer page in Admin module
		@FindBy(how=How.XPATH,using="//table[1]")
	public static WebElement admin_delete_customer_deletetable_rdo;
		
		
	public static boolean deleteCustomer()
	{
		boolean status=true;
		
		status = hoverAndClick(admin_delete_customer_lnk);
		if(status){
			System.out.println("Delete Customer link clicked");
			logEvent("Pass", "Delete Customer link clicked");
			String nominee= getdata("DeleteCustomer", "nominee", 1);
			String mobileNo= getdata("DeleteCustomer", "mobile", 1);
			
			status=radioButtonTable(nominee, mobileNo);
			if(status){
				System.out.println("Able to ");
				logEvent("Pass", "Able to delete customer" );
			}
			else{
				System.out.println("Not Able");
				logEvent("Pass", "Not Able to delete customer" );
			}
		}
		else{
			System.out.println("Delete Customer Not-link clicked");
			logEvent("Pass", "Delete Customer Not-link clicked");
		}
		return status;
	}	
}
