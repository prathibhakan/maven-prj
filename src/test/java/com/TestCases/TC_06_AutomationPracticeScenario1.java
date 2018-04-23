package com.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.GenericFunctions.GenericFunctions;
import com.ScreenFunctions.Login_AutomationPractice;

public class TC_06_AutomationPracticeScenario1 extends GenericFunctions{
	@Test
	public static void AutomationPracticeScenarioSignin()
	{
		//Launch Application
		GenericFunctions gnf = new GenericFunctions();
		gnf.launchApplication("firefox");
		
		Login_AutomationPractice lap = PageFactory.initElements(driver, Login_AutomationPractice.class);
		lap.signIn();
	}
}
