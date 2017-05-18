package com.gmail.cleanup;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.amdocs.asap.CommonFunctions;
import com.amdocs.asap.Global;
import com.amdocs.asap.Reporting;
import com.cortalconsors.web.HomePage;

public class LaunchGMail {
	private Reporting Reporter;
	private WebDriver driver;
	private HashMap<String, String> Dictionary;
	private HashMap<String, String> Environment;
	private CommonFunctions objCommon = new CommonFunctions();
	
	public String lnkCurrentAccount = "partiallinktext:=Girokonto";
	public String webbtnOpenCheckingAccount = "partiallinktext:=Girokonto eröffnen";
    
	//Define the constructor
	public HomePage openApplication()
	{
		//driver.get("https://www.cortalconsors.de/home");
		driver.get(Environment.get("http://gmail.com"));
		Reporter.fnWriteToHtmlOutput("Navigate to specified URL", "Gmail.com", "Navigated to URL:Gmail.com" , "Done");
		return new HomePage();
	}
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	
}
