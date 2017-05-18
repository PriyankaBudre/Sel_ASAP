package ForexAutomation.java;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.tieto.asap.CommonFunctions;
import com.tieto.asap.Global;
import com.tieto.asap.Reporting;

public class LoginAuth {

	private Reporting Reporter;
	private AndroidDriver driver;
	private HashMap<String, String> Dictionary;
	private HashMap<String, String> Environment;
	private CommonFunctions objCommon = new CommonFunctions();

	// Define the constructor
	public LoginAuth() {
		Reporter = Global.Reporter;
		driver = (AndroidDriver) Global.webDriver;
		Dictionary = Global.Dictionary;
		Environment = Global.Environment;
	}

	public String spinner_text_Control = "id:=spinner_text";
	public String SSN = "id:=se.forex.android.mobilbank.test:id/personal_number_input";
	public String LOGINBTN = "id:=se.forex.android.mobilbank.test:id/login_button";
	public String SIGN = "name:=Signera";
	public String NINE = "name:=9";
	public String EIGHT = "name:=8";
	public String SEVEN = "name:=7";
	public String SIX = "name:=6";
	public String FIVE = "name:=5";
	public String FOUR = "name:=4";
	public String OKBTN = "name:=OK";

	// Test login
	public void TEST() {
		objCommon.fGuilogin("TEST");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		// objCommon.fGuiClick(SSN);
		 objCommon.fGuiEnterText(SSN,Dictionary.get("SSN"));
//		objCommon.fGuiEnterText(SSN, "46000220");
//		for (int start = Dictionary.size(); start <= Dictionary.size(); start++) {
//		objCommon.fGuiEnterText(SSN, Dictionary.get("SSN"));
//		}
	
		objCommon.fGuiHideKeyBoard();
		// driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		objCommon.fGuiClick(LOGINBTN);
		Reporter.fnWriteToHtmlOutput("Login with TestMethod",
				"Login with Test Method should Done",
				"Login with Test Method is Done", "Pass");
		System.out.println("Login is Completed by TEST Method");
		// driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}

	// Demo login

	public void Demo() {
		objCommon.fGuilogin("Demo");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		objCommon.fGuiClick(LOGINBTN);
		Reporter.fnWriteToHtmlOutput("Login with DemoMethod",
				"Login with Demo Method should Done",
				"Login with Demo Method is Done", "Pass");
		System.out.println("Login is Completed by Demo Method");
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}

	// ForexID login

	public void ForexID() {
		objCommon.fGuilogin("FOREX ID");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		objCommon.fGuiEnterText(SSN, "5504305771");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		objCommon.fGuiClick(LOGINBTN);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		objCommon.fGuiClick(SIGN);
		objCommon.fGuiClick(NINE);
		objCommon.fGuiClick(EIGHT);
		objCommon.fGuiClick(SEVEN);
		objCommon.fGuiClick(SIX);
		objCommon.fGuiClick(FIVE);
		objCommon.fGuiClick(FOUR);
		objCommon.fGuiClick(OKBTN);
		System.out.println("Login is Completed by Forex ID Method");
		Reporter.fnWriteToHtmlOutput("Login with Forex ID Method",
				"Login with Forex ID Method should Done",
				"Login with Forex ID Method is Done", "Pass");
		// driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
	}

}