package ForexAutomation.java;


import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;








import com.tieto.asap.CommonFunctions;
import com.tieto.asap.Global;
import com.tieto.asap.Reporting;

public class Einvoice {
	
	private Reporting Reporter;
	private WebDriver driver;
	private HashMap<String, String> Dictionary;
	private HashMap<String, String> Environment;
	private CommonFunctions objCommon = new CommonFunctions();
	
	public Einvoice()
	{
		Reporter = Global.Reporter;
		driver = Global.webDriver;
		Dictionary = Global.Dictionary;
		Environment = Global.Environment;
	}
	
	
	public String mainMenuImage="id:=se.forex.android.mobilbank.test:id/mainMenuImg";
	public String layoutQuickMenu="id:=se.forex.android.mobilbank.test:id/layoutQuickMenu_FullMenu";
	public String Paymentstransfer="name:=Betalningar och överföringar";
	public String Einvoice="name:=E-faktura";
	public String RequestedSubscription1="name:=Bankgiro 590-9080";
	public String RequestedSubscription2="name:=Bankgiro 120-2001";
	public String Remove="name:=Remove";
	public String OkButton="name:=OK";
	public String HomeButton="id:=se.forex.android.mobilbank.test:id/homeMenuImg";
	
	
	
	
	public void checkEInvoice(){
		
		
		objCommon.fGuiClick(mainMenuImage);
		objCommon.fGuiClick(layoutQuickMenu);
		objCommon.fGuiClick(Paymentstransfer);
		objCommon.fGuiClick(Einvoice);
		objCommon.fGuiClick(RequestedSubscription1);
		objCommon.fGuiClick(RequestedSubscription1);
		objCommon.fGuiClick(RequestedSubscription2);
		objCommon.fGuiClick(RequestedSubscription2);
		objCommon.fGuiClick(HomeButton);
		
	}
	

}
