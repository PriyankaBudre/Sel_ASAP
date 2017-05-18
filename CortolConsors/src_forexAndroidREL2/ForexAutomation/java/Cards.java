package ForexAutomation.java;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.OBJ_ADAPTER;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.tieto.asap.CommonFunctions;
import com.tieto.asap.Global;
import com.tieto.asap.Reporting;

@Test
public class Cards {
	public Reporting Reporter;
	public WebDriver driver;
	public HashMap<String, String> Dictionary;
	public HashMap<String, String> Environment;
	public CommonFunctions objCommon = new CommonFunctions();
	AndroidDriver driver1;

	// Define the constructor
	public void details() {
		Reporter = Global.Reporter;
		driver = Global.webDriver;
		Dictionary = Global.Dictionary;
		Environment = Global.Environment;
	}

	public String GLOBALMENU = "id:=mainMenuImg";
	public String FULLMENU = "id:=tvQuickMenu_FullMenu";
	public String CARD = "name:=Kort";
	public String TAPCARD = "id:=card_number_view";
	public String CARDDETAILS = "id:=card_overview_show_text";
	public String CARDREGION = "id:=card_region";
	public String TOGGLE = "id:=card_region_switch";
	public String ACTIVATE = "id:=inActiveCardView";
	public String VBV = "id:=verify_card_layout";
	public String PWD = "id:=card_verified_by_visa_chooses_password";
	public String RETYPE = "id:=card_verified_by_visa_retype_password";
	public String MSG = "id:=card_verified_by_visa_verification_note";
	public String DONE = "id:=button_done";

	public void carddetails() throws MalformedURLException {
		// Login Here need to call Login function
		// navigation to Card list screen
		objCommon.fGuiBackPress();
		objCommon.fGuiClick(GLOBALMENU);
		objCommon.fGuiClick(FULLMENU);
		objCommon.fGuiClick(CARD);
		objCommon.fGuiClick(TAPCARD);
		// navigation to Card details screen
		objCommon.fGuiClick(CARDDETAILS);
		// navigation to Card region tab
		objCommon.fGuiClick(CARDREGION);
		objCommon.fGuiScroll();
		objCommon.fGuiClick(TOGGLE);

	}

	public void cardlist() throws MalformedURLException {
		// Login Here need to call Login function

		// navigation to Card list screen
		objCommon.fGuiBackPress();
		objCommon.fGuiClick(GLOBALMENU);
		objCommon.fGuiClick(FULLMENU);
		objCommon.fGuiClick(CARD);
		objCommon.fGuiClick(TAPCARD);

	}

	public void activatecard() throws MalformedURLException {
		// Login Here need to call Login function

		// navigation to Card list screen
		objCommon.fGuiBackPress();
		objCommon.fGuiClick(GLOBALMENU);
		objCommon.fGuiClick(FULLMENU);
		objCommon.fGuiClick(CARD);
		objCommon.fGuiClick(ACTIVATE);
		Reporter.fnWriteToHtmlOutput("Activate Card",
				"Activate Card should be Done", "Activate Card is Done", "Pass");

	}

	public void regionblock() throws MalformedURLException {
		// Login Here need to call Login function

		// navigation to Card list screen
		objCommon.fGuiBackPress();
		objCommon.fGuiClick(GLOBALMENU);
		objCommon.fGuiClick(FULLMENU);
		objCommon.fGuiClick(CARD);
		objCommon.fGuiClick(TAPCARD);
		// navigation to Card details screen
		objCommon.fGuiClick(CARDDETAILS);
		// navigation to Card region tab
		objCommon.fGuiClick(CARDREGION);
		objCommon.fGuiScroll();
		objCommon.fGuiClick(TOGGLE);
		Reporter.fnWriteToHtmlOutput("RegionBlock",
				"RegionBlock status should change",
				"RegionBlock status is Changed", "Pass");
		System.out.println("RegionBlock toggle status is changed");

	}

	public void vbv() throws MalformedURLException {
		// Login Here need to call Login function
		// navigation to Card list screen
		objCommon.fGuiBackPress();
		objCommon.fGuiClick(GLOBALMENU);
		objCommon.fGuiClick(FULLMENU);
		objCommon.fGuiClick(CARD);

		// navigation to Verified by VISA screen
		objCommon.fGuiClick(VBV);
		// Add Password and Message
		objCommon.fGuiScroll();
		objCommon.fGuiEnterText(PWD, "123test");
		objCommon.fGuiHideKeyBoard();
		objCommon.fGuiScroll();
		objCommon.fGuiEnterText(RETYPE, "123test");
		objCommon.fGuiHideKeyBoard();
		objCommon.fGuiScroll();
		objCommon.fGuiEnterText(MSG, "test123");
		objCommon.fGuiHideKeyBoard();
		// Tap 'Done' button
		objCommon.fGuiClick(DONE);

	}
}
