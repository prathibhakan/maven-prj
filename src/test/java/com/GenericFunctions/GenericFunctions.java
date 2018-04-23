package com.GenericFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;


public class GenericFunctions extends TestNGListeners {
	
	
	public static  WebDriver driver;
	
	/*************************************************
	
	Function Name:launchApplication
	
	Purpose:-This Function is used to launch the HRM Application when ever the user is required
	
	Input Parameters:-User must send in which browser does the application need to be launch
	
	Output Parameters:-This method will return a boolean value stating wheter the user logged into in the system
	
	Author:-Veera Prathap Malepati
	
	Creationn date:-12/30/2017
	
	**************************************************/
		
	public static boolean launchApplication(String browser) {
		
		boolean status=true;
		
		switch (browser.toLowerCase()) {
		case "ie":
			
			break;

		case "firefox":
			
			driver= new FirefoxDriver();
			//String url=getCommontestdata("Url");//For Bank
			//For Automation practice
			String url=getdata("CommonTestdata", "Url", 1);
			driver.get(url);			
			driver.manage().window().maximize();		
			break;
			
		case "chrome":
			
			break;
			
		default:
			break;
		}
		
	return status;	
		
	}
	
	/*************************************************
	
	
	Function Name:GetCommonTestdata 
	
	Purpose:-This Function is used to get the common test data which can be accessed commonly for each testcase such as Environment,Url,Username,Password
	
	Input Parameters:-User must send an argument stating what data that is required
	
	Output Parameters:-This method will return a string value for the User given input(If data is not found it will return a null)
	
	Author:-Veera Prathap Malepati
	
	Creationn date:-12/31/2017
	
	
	**************************************************/
	
	
	
	public static String getCommontestdata(String data)
	{
		
		String strQuery="Select "+ data+" from CommonTestdata";
		
		System.out.println(strQuery);
		
		Recordset recordset;
		
		String fetcheddata="";
		
		
		try {
			
			recordset = TestNGListeners.connection.executeQuery(strQuery);
			
			while(recordset.next()){
				
				System.out.println("Data is found and the data is " +recordset.getField(data));
				
				fetcheddata=recordset.getField(data);
				break;
				}
			recordset.close();
			
		} catch (FilloException e) {
			
			System.out.println("No Records Found");
		}
		 
		return fetcheddata;
		
		
	}
	
	
	public static String getdata(String sheetname,String userdata,int itr)
	{
		
		String strQuery="Select "+ userdata+" from "+sheetname+ " where Tc_Name='"+crntclass+"' and Iteration="+itr;
		System.out.println(strQuery);
		
		Recordset recordset;
		
		String fetcheddata="";
		
		
		try {
			
			recordset = TestNGListeners.connection.executeQuery(strQuery);
			
			while(recordset.next()){
				
				System.out.println("Data is found and the data is " +recordset.getField(userdata));
				
				fetcheddata=recordset.getField(userdata);
				break;
				
				
				}
				 
				recordset.close();
			
			
		} catch (FilloException e) {
			
			System.out.println("No Records Found");
		}
		 
		return fetcheddata;
		
		
	}
	
	public static boolean waitForElement(WebElement element)
	{
		boolean status = true;
		
		if(status)
		{
			for(int i=1;i<=10;i++)
			{
				try
				{
					status = true;
					System.out.println("Wait is executing");
					Actions acc=new Actions(driver);
					acc.moveToElement(element).build().perform();
					
					System.out.println("Element Found");
					break;
				}
				catch(Exception e)
				{
					try
					{
						Thread.sleep(1000);
						
					} 
					catch (InterruptedException e1)
					{
						e1.printStackTrace();
					}
				}
		}
		
	}
	return status;		
	}
	
	
	public static boolean hoverAndClick(WebElement element)
	{
	boolean status=true;
		
		try
		{
			waitForElement(element);
			Actions acc=new Actions(driver);
			acc.moveToElement(element).click().build().perform();
		}
		catch(Exception e)
		{
			
			status=false;
		}	
	return status;
	}	
	
	
	
	public static boolean setData(WebElement element, String data)
	{
		boolean status = true;		
		status = waitForElement(element);
		try{
			element.click();
			element.clear();
			element.sendKeys(data);
		}
		catch(Exception e)
		{
			status=false;
		}
		return status;	
	}

/*************************************************
	
	Function Name:elementEnabled
	
	Purpose:-This Function is used to check whether the element is enabled
	
	Input Parameters:-User must send arguments WebElement
	
	Output Parameters:-This method will give true if the element is enabled
		
	Author:-Prathibha
	
	Creation date:-04/06/2018
	
	
	**************************************************/
	
	public static boolean elementEnabled(WebElement element)
	{
		boolean status = true;		
		status = waitForElement(element);
		try{
			element.isDisplayed();
			element.isEnabled();
		}
		catch(Exception e)
		{
			status=false;
		}
		return status;	
	}
	

	public static void forceClick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public static boolean dropDown(WebElement element, String optionData)
	{
		boolean status = true;
		try
		{
			Select sel = new Select(element);
			sel.selectByVisibleText(optionData);
			System.out.println("Option"+optionData+" selected for the element" +element);
		}
		catch(Exception e)
		{
			status=false;
			System.out.println("Unable to select "+optionData+" for the element " +element);
		}
		return status;
	}
	
/*************************************************
	
	
	Function Name:RadioButton
	
	Purpose:-This Function is used to select radio buttons dynamically
	
	Input Parameters:-User must send arguments WebElement and string data
	
	Output Parameters:-This method will select appropriate radio button value based upon the input value
	
	Author:-Prathibha
	
	Creation date:-04/06/2018
	
	
	**************************************************/
	public static boolean radioButton(WebElement element, String radioval)
	{
		boolean status = true;		
		try{
			element = driver.findElement(By.xpath("//input[@type='radio'][@value='"+radioval+"']"));
			
			element.click();
		}
		catch(Exception e)
		{
			status=false;
		}
		return status;	
	}
	
	public static boolean radioButtonTable(String radvalname,String radvalphone)
	{
		boolean status = true;
		try{
			WebElement ele= driver.findElement(By.xpath("//table[1]//tr[4]/td[5][text()='"+radvalname+"']/following-sibling::td[3][text()='"+radvalphone+"']/preceding-sibling::td[7]/input"));
			hoverAndClick(ele);
		}
		catch(Exception e)
		{
			status=false;
		}
		return status;
	}
	public static boolean elementClicked(WebElement element)
	{
		boolean status = true;		
		status = elementEnabled(element);
		try{
			element.click();
		}
		catch(Exception e)
		{
			status=false;
		}
		return status;	
	}

}
