package ForexAutomation.java;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.tieto.asap.CommonFunctions;
import com.tieto.asap.Global;
import com.tieto.asap.Reporting;

@Test public class UnconfirmedOps {
	public Reporting Reporter;
	public WebDriver driver;
	public HashMap<String, String> Dictionary;
	public HashMap<String, String> Environment;
	public CommonFunctions objCommon = new CommonFunctions();
	AndroidDriver driver1;
	
	//Define the constructor
		public UnconfirmedOps()
		{
			Reporter = Global.Reporter;
			driver = Global.webDriver;
			Dictionary = Global.Dictionary;
			Environment = Global.Environment;
		}
		
		public String GLOBALMENU = "id:=mainMenuImg";
		public String FULLMENU = "id:=tvQuickMenu_FullMenu";
		public String NEWPAYMENTSCR = "name:=Betalningar och överföringar";
		public String UNSIGNED = "name:=Uppdrag att signera";
		public String ENTRY= "id:=payment_info_layout";
		public String DELETE= "name:=Ta bort";
		public String EDITSIGN= "name:=Signera";
		public String EDIT= "name:=Ändra";
		public String AMOUNT= "id:=currency_value";
		public String SIGNENTRY= "id:=Signera";
		public String SIGN = "name:=Signera";
		public String NINE= "name:=9";
		public String EIGHT= "name:=8";
		public String SEVEN= "name:=7";
		public String SIX= "name:=6";
		public String FIVE= "name:=5";
		public String FOUR= "name:=4";
		public String OKBTN= "name:=OK";
		
	
		public void Deleteunsigned() throws MalformedURLException 
		  {
			//Login Here need to call Login function
//			  System.out.println("Login Screen is being shown");
//			  Login login = new Login();
//			  login.ForexID();
			//Global menu  
			  objCommon.fGuiClick(GLOBALMENU);
			  objCommon.fGuiClick(FULLMENU);
			  objCommon.fGuiClick(NEWPAYMENTSCR);
			//navigation to Unsigned screen
			  objCommon.fGuiClick(UNSIGNED);
			  objCommon.fGuiLongPress(ENTRY);
			  objCommon.fGuiClick(DELETE);
			  objCommon.fGuiClick(OKBTN);
		  }
		
		public void sign() throws MalformedURLException 
		  {
			//Login Here need to call Login function
			  System.out.println("Login Screen is being shown");
			  Login login = new Login();
			  login.ForexID();
			  
			//Direct Sign single entry
			  objCommon.fGuiClick(GLOBALMENU);
			  objCommon.fGuiClick(FULLMENU);
			  objCommon.fGuiClick(NEWPAYMENTSCR);
			  objCommon.fGuiClick(UNSIGNED);
			  objCommon.fGuiLongPress(ENTRY);
			  objCommon.fGuiClick(EDITSIGN);
			  driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
			  
			//Edit and Sign entry
			  objCommon.fGuiLongPress(ENTRY);
			  objCommon.fGuiClick(EDIT);			  
			  objCommon.fGuiEnterText(AMOUNT, "7");
			  objCommon.fGuiScroll();
			  objCommon.fGuiClick(SIGNENTRY);
			  driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			 //FOREX ID Authentication
			 /* objCommon.fGuiClick(SIGN);
			  objCommon.fGuiClick(NINE);
			  objCommon.fGuiClick(EIGHT);
			  objCommon.fGuiClick(SEVEN);
			  objCommon.fGuiClick(SIX);
			  objCommon.fGuiClick(FIVE);
			  objCommon.fGuiClick(FOUR);
			  objCommon.fGuiClick(OKBTN);*/ 
			  driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		  }
		
}