package ForexAutomation.java;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tieto.asap.CommonFunctions;
import com.tieto.asap.Driver;
import com.tieto.asap.Global;

public class TestForDemo {

	// Variables
	String className;
	String dataSheetName;
	String env;
	String buildNumber;
	String jobName;

	// Instances
	Driver asapDriver;
	WebDriver driver;
	CommonFunctions objCommon;
	private String[] args;

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("Before Class TestsForTransfer");

		// Set the DataSheet name by getting the class name
		String[] strClassNameArray = this.getClass().getName().split("\\.");
		className = strClassNameArray[strClassNameArray.length - 1];
		Global.Environment.put("CLASSNAME", className);

		// Initiate asapDriver
		asapDriver = new Driver();

		// Check if POM has env, if null, get it from config file
		if (System.getProperty("envName") == null)
			env = asapDriver.fGetEnv();
		else
			env = System.getProperty("envName");

		// Add env global environments
		Global.Environment.put("ENV_CODE", env);

		// Create folder structure
		asapDriver.createExecutionFolders();

		// Get Environment Variables
		asapDriver.fetchEnvironmentDetails();

		// Create HTML Summary Report
		Global.Reporter.fnCreateSummaryReport();

		// Update Jenkins report
		Global.Reporter.fnJenkinsReport();

		System.out.println("your value is " + asapDriver.fGetPlatform());

		// Checks the type of OS

		/*
		 * if(System.getProperty("os.name").equals("Windows 7|Windows 8|Windows 10"
		 * )){ System.out.println("Android Working"); //Initiate WebDriver
		 * Global.androidDriver = (AndroidDriver) asapDriver.fGetWebDriver();
		 * driver = Global.androidDriver;
		 * 
		 * } else{ System.out.println("Ios Working"); Global.iosDriver =
		 * (IOSDriver) asapDriver.fGetWebDriver(); driver = Global.iosDriver; }
		 */
		// Checks the kind of platform
		if (asapDriver.fGetPlatform().equals("Android")) {
			System.out.println("Android Working");
			// Initiate WebDriver
			Global.androidDriver = (AndroidDriver) asapDriver.fGetWebDriver();
			Global.webDriver = Global.androidDriver;
		} else {
			System.out.println("Ios Working");
			Global.iosDriver = (IOSDriver) asapDriver.fGetWebDriver();
			Global.webDriver = Global.iosDriver;
		}
		// Set implicit time
		if (Global.webDriver != null)
			Global.webDriver.manage().timeouts()
					.implicitlyWait(30, TimeUnit.SECONDS);
		// Initialize Common functions
		objCommon = new CommonFunctions();
	}

	@BeforeMethod
	public void beforeMethod(Method method) {

		// Get the test name
		String testName = method.getName();

		System.out.println("Before Method" + testName);

		// Get the data from DataSheet corresponding to Class Name & Test Name
		asapDriver.fGetDataForTest(testName);

		// Create Individual HTML Report
		Global.Reporter.fnCreateHtmlReport(testName);
	}

	@Test
	public void transfer() throws MalformedURLException {
		System.out.println("Into Test Code");

		// Login to application Functionality
		LoginAuth Login = new LoginAuth();
		Login.TEST();

		// HomeSearch findBGPG = new HomeSearch();
		// findBGPG.SearchValidation();

		// Verifying Loan features are working
		// Loan MyLoan = new Loan();
		// MyLoan.LoanPage();

		// Verifying Secure mail Functionality
		// SecureMail SMOps = new SecureMail();
		// SMOps.InBoxMail();

		// Save Transfer Functionality
		// Transfers TransferOps = new Transfers();
		// TransferOps.MakeNewTransferOnce();
		// AssertJUnit.assertNotNull("Assert Transfer Page object is not null",
		// TransferOps);
		//
		// HomeSearch HM = new HomeSearch();
		// HM.SearchValidation();

		BeneficiaryRegister Benef = new BeneficiaryRegister();
		// Benef.SearchValidation();
		Benef.Benefilter();
	}
}
