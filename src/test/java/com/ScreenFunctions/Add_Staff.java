package com.ScreenFunctions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.GenericFunctions.GenericFunctions;

public class Add_Staff extends GenericFunctions{
	//Add Staff link from Admin home page in Admin module
	@FindBy(how=How.XPATH,using="//a[text()='Add staff member']")
	public static WebElement admin_addstaff_lnk;
	
	//Staff name from Addstaff page in Admin module
	@FindBy(how=How.XPATH,using="//input[@name='staff_name']")
	public static WebElement admin_addstaff_staffname_edi;
	
	//Gender from Addstaff page in Admin module
	@FindBy(how=How.XPATH,using="//input[@name='staff_gender']")
	public static WebElement admin_addstaff_gender_rdo;
	
	//DOB from Addstaff page in Admin module
	@FindBy(how=How.XPATH,using="//input[@type='date'][@name='staff_dob']")
	public static WebElement admin_addstaff_DOB_edi;
	
	//DOJ from Addstaff page in Admin module
	@FindBy(how=How.XPATH,using="//input[@type='date'][@name='staff_doj']")
	public static WebElement admin_addstaff_DOJ_edi;
	
	//Relationship status from Addstaff page in Admin module
	@FindBy(how=How.XPATH,using="//select[@name='staff_status']")
	public static WebElement admin_addstaff_relationship_drp;
	
	//Relationship status from Addstaff page in Admin module
	@FindBy(how=How.XPATH,using="//select[@name='staff_dept']")
	public static WebElement admin_addstaff_department_drp;
	
	//Address from Addstaff page in Admin module
	@FindBy(how=How.XPATH,using="//textarea[@name='staff_address']")
	public static WebElement admin_addstaff_Address_edi;
	
	//Mobile number from Addstaff page in Admin module
	@FindBy(how=How.XPATH,using="//input[@name='staff_mobile']")
	public static WebElement admin_addstaff_mobile_edi;
	
	//Email id from Addstaff page in Admin module
	@FindBy(how=How.XPATH,using="//input[@name='staff_email']")
	public static WebElement admin_addstaff_emailid_edi;
	
	//Password from Addstaff page in Admin module
	@FindBy(how=How.XPATH,using="//input[@name='staff_pwd']")
	public static WebElement admin_addstaff_password_edi;
	
	//Addstaff member button from Addstaff page in Admin module
	@FindBy(how=How.XPATH,using="//input[@name='add_staff']")
	public static WebElement admin_addstaff_addstaffmember_btn;
	
/****************************************************************************
  Function name addStaff
  
  Purpose: This function is used to enter all details in Addstaff page by clicking Add Staff member link
  
  Input Parameters: NA
  
  Output Parameters: This method will return boolean value based on the details given in the form
  
  Author : Prathibha K
  
  Creation Date: 04-09-2018  	
  
**************************************************************************** */
	public static boolean addStaff()
	{
		boolean status = true;
		//Check whether Addstaff link is found or not 
		status = waitForElement(admin_addstaff_lnk);
		if (status)
		{   
			System.out.println("Add Staff Link found..");
			logEvent("Pass", "Add Staff Link found");
			
			//Based on the Addstaff link status click on it			
			status = hoverAndClick(admin_addstaff_lnk);
			System.out.println("Add staff link Clicked ..");
			logEvent("Pass", "Add staff link Clicked ..");
			if (status)
			{
				//Based on the addStaff status Enter all details to Add Staff form
				
				//Checking the Staff Name enabled and Enter data in it
				status= elementEnabled(admin_addstaff_staffname_edi);
				if(status){					
					String staffName=getdata("AddStaffMember", "Staffname", 1);
					status=setData(admin_addstaff_staffname_edi,staffName);
					System.out.println("Staff name entered ..");
					logEvent("Pass", "Staff name entered ..");
				}
				else
				{
					System.out.println("Staff name not Entered ..");
					logEvent("Fail", "Staff name not entered ..");
				}
				//Checking the Gender enabled and Enter data in it
				status= elementEnabled(admin_addstaff_gender_rdo);
				if(status){
					String gender = getdata("AddStaffMember", "gender", 1);
					status = radioButton(admin_addstaff_gender_rdo, gender);
					System.out.println("Gender Selected ..");
					logEvent("Pass", "Gender Selected ..");
				}
				else
				{
					System.out.println("Gender not Selected ..");
					logEvent("Fail", "Gender not Selected ..");
				}
				//DOB selected
				status= elementEnabled(admin_addstaff_DOB_edi);
				if(status){
					String dob = getdata("AddStaffMember", "DateOfBirth", 1);
					status = setData(admin_addstaff_DOB_edi, dob);
					System.out.println("Date Of Birth Selected ..");
					logEvent("Pass", "Date Of Birth Selected ..");
				}
				else
				{
					System.out.println("Date Of Birth Selected ..");
					logEvent("Fail", "Date Of Birth Selected ..");
				}
				
				//DOJ selected
				status= elementEnabled(admin_addstaff_DOJ_edi);
				if(status){
					String dob = getdata("AddStaffMember", "DateOfJoin", 1);
					status = setData(admin_addstaff_DOJ_edi, dob);
					System.out.println("Date Of Join Selected ..");
					logEvent("Pass", "Date Of Join Selected ..");
				}
				else
				{
					System.out.println("Date Of Join Selected ..");
					logEvent("Fail", "Date Of Join Selected ..");
				}
				
				//Working on Relationship dropdown									
				String relationship = getdata("AddStaffMember", "Relationship", 1);
				status = dropDown(admin_addstaff_relationship_drp, relationship);  
				System.out.println("Relationship selected from dropdown ..");
				if(status)
				{
					logEvent("Pass", "Relationship selected from dropdown ..");	
				}
				else
				{
					System.out.println("Relationship not Selected ..");
					logEvent("Fail", "Relationship not Selected ..");
				}
				
				//Working on Department dropdown									
				String department = getdata("AddStaffMember", "Department", 1);
				status = dropDown(admin_addstaff_department_drp, department);  
				System.out.println("Department selected from dropdown ..");
				if(status)
				{
					logEvent("Pass", "Department selected from dropdown ..");	
				}
				else
				{
					logEvent("Fail", "Department not selected from dropdown ..");
				}
				
				//Checking the Address enabled and Enter data in it
				status= elementEnabled(admin_addstaff_Address_edi);
				if(status){
					String address = getdata("AddStaffMember", "Address", 1);
					status = setData(admin_addstaff_Address_edi, address);  
					System.out.println("Address entered ..");
					logEvent("Pass", "Address entered ..");
				}
				else{
					logEvent("Fail", "Address not entered ..");
				}
				//Checking the Mobile enabled and Enter data in it
				status= elementEnabled(admin_addstaff_mobile_edi);
				if(status){
					String mobile = getdata("AddStaffMember", "Mobile", 1);
					status = setData(admin_addstaff_mobile_edi, mobile);  
					System.out.println("Mobile entered ..");
					logEvent("Pass", "Mobile entered ..");
				}
				else{
					logEvent("Fail", "Mobile not entered ..");
				}
				//Checking the Email id enabled and Enter data in it 
				status= elementEnabled(admin_addstaff_emailid_edi);
				if(status){
					String emailid = getdata("AddStaffMember", "EmailId", 1);
					status = setData(admin_addstaff_emailid_edi, emailid);  
					System.out.println("Email id entered ..");
					logEvent("Pass", "Email id entered ..");
				}
				else{
					logEvent("Fail", "Email id not entered ..");
				}
				//Checking the Password enabled and Enter data in it 
				status= elementEnabled(admin_addstaff_password_edi);
				if(status){
					String password = getdata("AddStaffMember", "Password", 1);
					status = setData(admin_addstaff_password_edi, password);  
					System.out.println("Password entered ..");
					logEvent("Pass", "Password entered ..");
				}
				else{
					logEvent("Fail", "Password not entered ..");
				}
				//Clicking on Add Staff Member
				status = elementClicked(admin_addstaff_addstaffmember_btn);
				if(status)
				{
					System.out.println("Add Staff Member button clicked");
					logEvent("Pass", "Add Staff Member button clicked");
				}
				else
				{
					logEvent("Fail", "Add Staff Member button not clicked");
				}
			}else
			{
				System.out.println("Add Staff Link Not found");
				logEvent("Fail", "Add Staff Link Not found");
			}
		}else
		{
			System.out.println("Add Staff Link Not-clicked");
			logEvent("Fail", "Add Staff Link Not-clicked");	
		}
		return status;
	}
}