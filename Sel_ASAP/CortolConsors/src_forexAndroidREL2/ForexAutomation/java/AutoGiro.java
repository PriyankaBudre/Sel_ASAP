package ForexAutomation.java;

import io.appium.java_client.android.AndroidDriver;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.tieto.asap.CommonFunctions;
import com.tieto.asap.Global;
import com.tieto.asap.Reporting;

public class AutoGiro {
	
	private Reporting Reporter;
	private WebDriver driver;
	private HashMap<String, String> Dictionary;
	private HashMap<String, String> Environment;
	private CommonFunctions objCommon = new CommonFunctions();
	
	public AutoGiro()
	{
		Reporter = Global.Reporter;
		driver = Global.webDriver;
		Dictionary = Global.Dictionary;
		Environment = Global.Environment;
	}
	
	
	public String mainMenuImage="id:=se.forex.android.mobilbank.test:id/mainMenuImg";
	public String layoutQuickMenu="id:=se.forex.android.mobilbank.test:id/layoutQuickMenu_FullMenu";
	public String Paymentstransfer="name:=Betalningar och överföringar";
	public String autoGiro="name:=Autogiro";
	public String searchAutogiro="id:=se.forex.android.mobilbank.test:id/search_autogiro_layout";
	public String inputSearchAutogiro="id:=se.forex.android.mobilbank.test:id/input_search_autogiro";
	public String inputSearchAutogiroName="name:=Sök efter företag";
	public String searchButton="id:=se.forex.android.mobilbank.test:id/search_button";
	public String autoGiroNumber1="name:=Bankgiro 5595-8771";
	public String autoGiroNumber2="name:=Bankgiro 5178-5608";
	public String betarNumber="id:=se.forex.android.mobilbank.test:id/tv_payer_num_value";
	public String chechBox="id:=se.forex.android.mobilbank.test:id/checkTermsConditions";
	public String subscribe="id:=se.forex.android.mobilbank.test:id/autogiro_subscribe_button";
	public String hyperlink="id:=se.forex.android.mobilbank.test:id/hyperlinkTermsConditionText";
	public String dialog="name:=OK";
	public String homeButton="id:=se.forex.android.mobilbank.test:id/homeMenuImg";
	
	public void checkAutoGiro() {
		
		System.out.println("Login Screen is being shown");
		Login Login = new Login();
		Login.ForexID();
		
		objCommon.fGuiClick(mainMenuImage);
		objCommon.fGuiClick(layoutQuickMenu);
		objCommon.fGuiClick(Paymentstransfer);
		objCommon.fGuiClick(autoGiro);
		objCommon.fGuiClick(inputSearchAutogiroName);
		objCommon.fGuiEnterText(inputSearchAutogiroName,Dictionary.get("Name"));
		objCommon.fGuiHideKeyBoard();
		objCommon.fGuiClick(searchButton);
		objCommon.fGuiClick(autoGiroNumber1);
		objCommon.fGuiScroll();
		objCommon.fGuiEnterText(betarNumber,Dictionary.get("Value"));
		objCommon.fGuiHideKeyBoard();
		objCommon.fGuiCheckCheckBox(chechBox);
		objCommon.fGuiClick(hyperlink);
		objCommon.fGuiBackPress();
		objCommon.fGuiClick(subscribe);
		objCommon.fGuiClick(dialog);
		objCommon.fGuiBackPress();
		objCommon.fGuiClick(homeButton);
		
		
		
		}

}
