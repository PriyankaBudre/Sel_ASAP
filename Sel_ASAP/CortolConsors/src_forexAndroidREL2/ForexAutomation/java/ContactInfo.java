package ForexAutomation.java;

import io.appium.java_client.android.AndroidDriver;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import com.tieto.asap.CommonFunctions;
import com.tieto.asap.Global;
import com.tieto.asap.Reporting;

public class ContactInfo {

	private Reporting Reporter;
	private WebDriver driver;

	private HashMap<String, String> Dictionary;
	private HashMap<String, String> Environment;
	private CommonFunctions objCommon = new CommonFunctions();

	public ContactInfo() {
		Reporter = Global.Reporter;
		driver = Global.webDriver;
		Dictionary = Global.Dictionary;
		Environment = Global.Environment;
	}

	public String mainMenuImage = "id:=se.forex.android.mobilbank.test:id/mainMenuImg";
	public String layoutQuickMenu = "id:=se.forex.android.mobilbank.test:id/layoutQuickMenu_FullMenu";
	public String contactInfo = "name:=Kontaktuppgifter";
	public String homePhoneNo = "id:=se.forex.android.mobilbank.test:id/home_phone_layout";
	public String mobPhoneNo = "id:=se.forex.android.mobilbank.test:id/mobile_phone_layout";
	public String workPhoneNo = "id:=se.forex.android.mobilbank.test:id/work_phone_layout";
	public String editPhNo = "id:=se.forex.android.mobilbank.test:id/phone_number";
	public String cancelButton = "id:=se.forex.android.mobilbank.test:id/cancel_button";
	public String saveButon = "id:=se.forex.android.mobilbank.test:id/save_button";
	public String emailAddr = "id:=se.forex.android.mobilbank.test:id/email_layout";
	public String emailAddrEdit = "id:=se.forex.android.mobilbank.test:id/email_id";
	public String homeButton = "id:=se.forex.android.mobilbank.test:id/homeMenuImg";

	public void checkContactInfo() {

		System.out.println("Login Screen is being shown");

		objCommon.fGuiClick(mainMenuImage);
		objCommon.fGuiClick(layoutQuickMenu);
		objCommon.fGuiClick(contactInfo);
		objCommon.fGuiScroll();
		objCommon.fGuiLongPress(homePhoneNo);
		objCommon.fGuiEnterText(editPhNo, "01234567890");
		objCommon.fGuiClick(saveButon);
		objCommon.fGuiLongPress(mobPhoneNo);
		objCommon.fGuiEnterText(editPhNo, "091-8087498937");
		objCommon.fGuiClick(saveButon);
		objCommon.fGuiLongPress(workPhoneNo);
		objCommon.fGuiEnterText(editPhNo, "04534253426");
		objCommon.fGuiClick(saveButon);
		objCommon.fGuiLongPress(emailAddr);
		objCommon.fGuiEnterText(emailAddrEdit, "abc@gmail.com");
		objCommon.fGuiClick(saveButon);
		objCommon.fGuiClick(homeButton);

	}

}
