package test.java;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amdocs.asap.CommonFunctions;
import com.amdocs.asap.Driver;
import com.amdocs.asap.Global;
import com.cortalconsors.web.CheckingAccountDetails;
import com.cortalconsors.web.CheckingAccountEntry;
import com.cortalconsors.web.HomePage;
import com.cortalconsors.web.LaunchApplication;

public class TestsForCortalConsorsWeb {	
	//Variables
	String className;
	String dataSheetName;
	String env;
	String buildNumber;
	String jobName;
	
	//Instances
	Driver asapDriver;
	WebDriver driver;
	CommonFunctions objCommon;

	
  @BeforeClass
  public void beforeClass() throws IOException
  {
	  System.out.println("Before Class TestForCortalConsorsWeb");
	  	
	  //Set the DataSheet name by getting the class name
	  String[] strClassNameArray = this.getClass().getName().split("\\.");
	  className = strClassNameArray[strClassNameArray.length-1];
	  Global.Environment.put("CLASSNAME", className);		
	  	 
	   //Initiate asapDriver
	   asapDriver = new Driver();	   	  
	   
		//Check if POM has env, if null, get it from config file
	   if(System.getProperty("envName")== null) 		   
		   env = asapDriver.fGetEnv();	  		   
	   else 
		   env = System.getProperty("envName");		
	  
		
		//Add env global environments
		Global.Environment.put("ENV_CODE", env);
				
		//Create folder structure
		asapDriver.createExecutionFolders();	 		  
		
	   //Get Environment Variables
	   asapDriver.fetchEnvironmentDetails();
     
	   //Create HTML Summary Report
	   Global.Reporter.fnCreateSummaryReport();
	   
	   //Update Jenkins report
	   Global.Reporter.fnJenkinsReport();
	   
	   //Initiate WebDriver
	   Global.webDriver = asapDriver.fGetWebDriver();
	   driver = Global.webDriver;
	   
	   //Set implicit time
	   if(driver != null) driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   
	   //Initialize Common functions
	   objCommon = new CommonFunctions();
	   
   }
	   
   @BeforeMethod
   public void beforeMethod(Method method)
   {

	   
	   //Get the test name
	   String testName = method.getName();
	   
	   System.out.println("Before Method" + testName);
	   
	   //Get the data from DataSheet corresponding to Class Name & Test Name
	   asapDriver.fGetDataForTest(testName);
	   
	   //Create Individual HTML Report	
	   Global.Reporter.fnCreateHtmlReport(testName);	  
   }
	   
	   
   @Test
   public void testConsorsPOC()
   {
	   System.out.println("testRegisterUser");		   
	   
	   //Create object of Launch Application class
		LaunchApplication launchApplication = new LaunchApplication();
		
		//Call  the function to launch the application url that return MercuryHomePage object
		HomePage objHP = launchApplication.openApplication();
		
		//if the returned object is null then return false
		Assert.assertNotNull(objHP, "Assert Cortol Consors Home Page object is not null");
				
		// Click on link 
		Assert.assertTrue(objHP.clickCurrentAccount(), "Click Link: Current account");

		//Check whether required page is opened
	     Assert.assertTrue(objCommon.fValidatePageDisplayed("Girokonto"), "Validate title : Girokonto");
		 
	    //Click on Button open Checking Account
		CheckingAccountEntry objCA= objHP.clickOpenCheckingAccount();
		
		//if the returned object is null then return false
		Assert.assertNotNull(objCA, "Assert Checking Account Entry Page object is not null");		
					
		CheckingAccountDetails objCAD= objCA.openCheckingAccountForm();
		
		//if the returned object is null then return false
		Assert.assertNotNull(objCAD, "Assert Checking Account Details  Page object is not null"); 
	
		// Click on link 
		Assert.assertTrue(objCAD.enterPersonalDetails(), "Enter Personal Deatails");
		
		Assert.assertTrue(objCAD.enterAddressDetails(), "Enter Adress Deatails");
		Assert.assertTrue(objCAD.enterContactDetails(), "Enter Contact Deatails");
		Assert.assertTrue(objCAD.enterProfessionalDetails(), "Enter Profesional Deatails");
		
	     
		/*//Click on the register link that returns RegisterUserObject
		RegisterUser registerUser = mercuryHomePage.clickRegister();    
		
		//if the returned object is null then return false
		Assert.assertNotNull(registerUser, "Assert Register User Page object is not null");

		
	    //Check whether required page is opened
		Assert.assertTrue(objCommon.fValidatePageDisplayed("Register: Mercury Tours"), "Validate title : Register: Mercury Tours");      
      
	     //Call the function to register the user that returns RegisterUserResult page object
	     RegisterUserResultPage registerUserResultPage = registerUser.fGuiRegisterUser();

		//if the returned object is null then return false
	     Assert.assertNotNull(registerUserResultPage, "Assert Register User Result Page object is not null");*
	     
	     
	     
		/*Assert.assertTrue(ObjCA.selectNonExistingCustomer(), "Click Option: Non Existing Customer");
		
		Assert.assertTrue(ObjCA.selectNoJointAccount(), "Click Option: No Joint account");*/	   		 		   
   }
   
   @Test
   public void testLogin()
   {
	   System.out.println("testLogin");

   }
	   
	   
   @AfterMethod
   public void afterMethod(Method method)
   {
	   //System.out.println("After Method");
	   
	   //Get the test name
	   String testName = method.getName();
	   
	   System.out.println("After Method" + testName);
	   	   
	   //Update the KeepRefer Sheet
	   asapDriver.fSetReferenceData();
	   
	   //Close Individual Summary Report & Update Summary Report
	   Global.Reporter.fnCloseHtmlReport(testName);
	   	   		  
   }
   	   	   
   @AfterClass
   public void afterClass()
   {
	   System.out.println("After Class TestForCortalConsorsWeb");
	   
	   //Close HTML Summary report
	   Global.Reporter.fnCloseTestSummary();
	   
	   //Copy reports under build path
	   
	   //QUit webdriver
	   if(Global.webDriver != null) Global.webDriver.quit();
   }
	 
}