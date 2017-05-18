package ForexAutomation.java;

import io.appium.java_client.android.AndroidDriver;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.tieto.asap.CommonFunctions;
import com.tieto.asap.Global;
import com.tieto.asap.Reporting;

public class SecureMail {

	private Reporting Reporter;
	private AndroidDriver driver;
	private HashMap<String, String> Dictionary;
	private HashMap<String, String> Environment;
	private CommonFunctions objCommon = new CommonFunctions();

	// Define the constructor
	public SecureMail() {
		Reporter = Global.Reporter;
		driver = (AndroidDriver) Global.webDriver;
		Dictionary = Global.Dictionary;
		Environment = Global.Environment;
	}

	public String GLOBALMENU = "id:=mainMenuImg";
	public String FULLMENU = "id:=se.forex.android.mobilbank.test:id/tvQuickMenu_FullMenu";
	public String SMMenu = "name:=Meddelanden";
	public String NewMsg = "id:=se.forex.android.mobilbank.test:id/row_new_mail";
	public String Spiner = "id:=se.forex.android.mobilbank.test:id/from_account_name";
	public String SubjectTyp = "name:=Konto";
	public String SubjectVal = "id:=se.forex.android.mobilbank.test:id/subject";
	public String FullMSG = "id:=se.forex.android.mobilbank.test:id/text";
	public String SendBtn = "Xpath:=//android.widget.TextView[@index=2]";
	public String InBox = "id:=se.forex.android.mobilbank.test:id/row_inbox";
	// public String MailItem =
	// "Xpath:=//android.widget.RelativeLayout[@index='1']";
	public String From = "id:=se.forex.android.mobilbank.test:id/row_inbox_detail_from_to_value";
	public String To = "id:=se.forex.android.mobilbank.test:id/row_inbox_detail_category_value";
	public String attachment = "id:=se.forex.android.mobilbank.test:id/row_inbox_detail_subject_value";
	public String SentBox = "id:=se.forex.android.mobilbank.test:id/row_sent";
	// public String InBoxItem
	// ="Xpath:=//android.widget.CheckedTextView[@index=1]";
	public String InBoxItem = "Xpath:=//android.widget.ListView[@index='0']//android.widget.RelativeLayout[@index='1']";
	public String NotiMenu = "id:=se.forex.android.mobilbank.test:id/notificationMenuImg";
	public String NotiItems = "Xpath:=//android.widget.RelativeLayout[@index='4']//android.widget.LinearLayout[@index='0']";
	public String MailCount = "id:=se.forex.android.mobilbank.test:id/notification_icon";
	public String TCount = "id:=se.forex.android.mobilbank.test:id/notification_icon";

	// Verify # of InBox mailItems and its content.
	public boolean InBoxMail() {
		if (objCommon.fGuiClick(GLOBALMENU) == false) {
			return false;
		}
		if (objCommon.fGuiClick(FULLMENU) == false) {
			return false;
		}
		if (objCommon.fGuiClick(SMMenu) == false) {
			return false;
		}
		if (objCommon.fGuiClick(InBox) == false) {
			return false;
		}

		List<WebElement> xpath = driver
				.findElements(By
						.xpath("//android.widget.ListView['0']//android.widget.RelativeLayout/*"));
		int xpathCount = xpath.size();
		System.out.println("Total xpath:" + xpathCount);

		if (xpathCount == 0) {
			System.out.println("There is no eMail available in InBox ");
		} else {
			for (int i = 1; i <= xpathCount; i++) {
				System.out.println("Validating " + i
						+ " emails in InBox Folder.");
				String xStart = "Xpath:=//android.widget.ListView['0']//android.widget.RelativeLayout[@index='";
				String xend = "']";
				String NewInBoxItem = xStart + i + xend;
				InBoxItem = NewInBoxItem;
				if (objCommon.fGuiClick(InBoxItem) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(From) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(To) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(attachment) == false) {
					return false;
				}
				if (objCommon.fGuiBackPress() == false) {
					return false;
				}
			}
			System.out.println("Initials emails in InBox Folder.");
			objCommon.fGuiBackPress();
		}
		return Newemail();
	}

	// Write here for NewMessage mail verification.
	public boolean Newemail() {

		if (objCommon.fGuiClick(GLOBALMENU) == false) {
			return false;
		}
		if (objCommon.fGuiClick(FULLMENU) == false) {
			return false;
		}
		if (objCommon.fGuiClick(SMMenu) == false) {
			return false;
		}
		if (objCommon.fGuiClick(NewMsg) == false) {
			return false;
		}

		System.out.println("Sending emails from New Email.");
		for (int i = 0; i <= 1; i++) {
			String xStart = "Xpath:=//android.widget.CheckedTextView[@index='";
			String xend = "']";
			String NewSubjectTyp = xStart + i + xend;
			System.out.println(i);
			SubjectTyp = NewSubjectTyp;

			if (objCommon.fGuiClick(Spiner) == false) {
				return false;
			}
			if (objCommon.fGuiClick(SubjectTyp) == false) {
				return false;
			}
			if (objCommon.fGuiEnterText(SubjectVal, Dictionary.get("SUBJECT")) == false) {
				return false;
			}
			if (objCommon.fGuiHideKeyBoard() == false) {
				return false;
			}
			if (objCommon.fGuiEnterText(FullMSG, Dictionary.get("MESSAGE")) == false) {
				return false;
			}
			if (objCommon.fGuiHideKeyBoard() == false) {
				return false;
			}
			if (objCommon.fGuiClick(SendBtn) == false) {
				return false;
			}
			if (objCommon.fGuiBackPress() == false) {
				return false;
			}
		}
		return SentItem();
	}

	// Write here for SentIyem mail verification.
	public boolean SentItem() {
		System.out.println("Validating Sent emails from sent Items.");
		objCommon.fGuiClick(SentBox);
		for (int i = 0; i <= 3; i++) {
			String xStart = "Xpath:=//android.widget.CheckedTextView[@index='";
			String xend = "']";
			String NewInBoxItem = xStart + i + xend;
			InBoxItem = NewInBoxItem;
			if (objCommon.fGuiCheckObjectExistence("Hello World") == true) {
				System.out.println("Found the sent email");
			}
			if (objCommon.fGuiBackPress() == false) {
				return false;
			}
		}
		return true;
	}

//	public boolean notification() {
//		objCommon.fGuiClick(NotiMenu);
////		WebElement MyCount = (WebElement) driver.findElements(By.id(TCount));
////		 String x = MyCount.getText().toString();
////		System.out.println(x);
//		List<WebElement> Notipath = driver
//				.findElements(By
//						.xpath("//android.widget.RelativeLayout[@index='4']//android.widget.LinearLayout/*"));
//		int NotipathCount = Notipath.size();
//		for (int i = 1; i <= NotipathCount; i++) {
//			String NotiStart = "Xpath:=//android.widget.RelativeLayout[@index='4']//android.widget.LinearLayout[@index='";
//			String Notiend = "']";
//			String NewNotiItems = NotiStart + i + Notiend;
//			NotiItems = NewNotiItems;
//
//			if (objCommon.fGuiClick(NotiItems) == false) {
//				System.out.println("Validating " + i
//						+ "Item in Notify is Clicked.");
//				return false;
//			}
//			if (objCommon.fGuiBackPress() == false) {
//				return false;
//			}
//			if (objCommon.fGuiClick(NotiMenu) == false) {
//				return false;
//			}
//		}
//		return true;
//	}

}
