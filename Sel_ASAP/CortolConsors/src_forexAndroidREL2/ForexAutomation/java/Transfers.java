package ForexAutomation.java;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.math.MathContext;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.tieto.asap.CommonFunctions;
import com.tieto.asap.Global;
import com.tieto.asap.Reporting;

public class Transfers {

	private Reporting Reporter;
	private AndroidDriver driver;
	private HashMap<String, String> Dictionary;
	private HashMap<String, String> Environment;
	private CommonFunctions objCommon = new CommonFunctions();

	// Define the constructor
	public Transfers() {
		Reporter = Global.Reporter;
		driver = (AndroidDriver) Global.webDriver;
		Dictionary = Global.Dictionary;
		Environment = Global.Environment;
	}

	@SuppressWarnings("static-access")
	public String SearchAC = "id:=se.forex.android.mobilbank.test:id/bgpg_search_fieldtext";
	public String PopUp = "id:=se.forex.android.mobilbank.test:id/tv_account_name";
	public String currency_value = "id:=se.forex.android.mobilbank.test:id/currency_value";
	public String one_time_transfer = "id:=se.forex.android.mobilbank.test:id/one_time_transfer";
	public String sign_button = "id:=se.forex.android.mobilbank.test:id/sign_button";
	public String recurring_transfer = "id:=se.forex.android.mobilbank.test:id/recurring_transfer";
	public String ToAc = "id:=se.forex.android.mobilbank.test:id/to_label_view";
	public String OCR = "id:=se.forex.android.mobilbank.test:id/ocr_value";
	public String Note = "id:=se.forex.android.mobilbank.test:id/note_value";
	public String SaveNew = "id:=se.forex.android.mobilbank.test:id/save_and_new_payment_button";
	public String FromAC = "id:=se.forex.android.mobilbank.test:id/from_account_number";
	public String date = "id:=se.forex.android.mobilbank.test:id/date_value";
	public String Yes = "id:=android:id/button1";
	public String single = "id:=android:id/button2";
	public String Home = "id:=se.forex.android.mobilbank.test:id/homeMenuImg";
	public String NewPay = "id:=se.forex.android.mobilbank.test:id/make_new_payment";
	public String AccList = "id:=se.forex.android.mobilbank.test:id/tv_account_number";
	public String MatchAccList = "xpath:=//se.forex.android.mobilbank.test:id/tv_account_number[@index=1]";
	public String AMT = "id:=se.forex.android.mobilbank.test:id/transaction_amount";
	public String AMOUNT = "id:=currency_value";
	public String TRANSFER = "id:=trasfer_payment_button";
	public String accountRowLayout = "Xpath:=//android.widget.ListView[@index='0']//android.widget.LinearLayout[@index='1']";
	public String FromAcc = "id:=se.forex.android.mobilbank.test:id/from_account_name";
	public String ErrorTxt = "id:=se.forex.android.mobilbank.test:id/error_text";
	// public String NewAmt = objCommon.fGuiRandomNumber();
	public String ErrorMsg = "id:=se.forex.android.mobilbank.test:id/error_text_ocr";
	public String TxnLayout = "id:=se.forex.android.mobilbank.test:id/transaction_info_layout";
	public String TxnAccBal = "xpath:=//android.widget.TextView[@text=*]";
	public String TxnListBal = "xpath:=//android.widget.TextView[@text=*]";

	// ******** Verification of Functionalities************//

	// Verifying the DragDrop Transfer features
	public boolean dragdrop() throws MalformedURLException {
		driver.unlockDevice();
		if (objCommon.fGuiClick(Home) == false) {
			return false;
		}
		@SuppressWarnings("unchecked")
		List<WebElement> xpath = driver.findElements(By
				.xpath("//android.widget.ListView/*"));
		int xpathCount = xpath.size();
		System.out.println("Total xpath: " + xpathCount);
		Reporter.fnWriteToHtmlOutput("Number of Avavilable Accounts",
				"User should have more than one account for Transfer.",
				"User have more than one account for Transfer", "Pass");
		if (xpathCount >= 2) {
			for (xpathCount = 1; xpathCount <= xpath.size() - 5; xpathCount++) {
				String xStart = "Xpath:=//android.widget.ListView[@index='0']//android.widget.LinearLayout[@index='";
				String xend = "']";
				String NewAccCount = xStart + xpathCount + xend;
				accountRowLayout = NewAccCount;
				if (objCommon.fGuidragdrop("accountRowLayout", 0, xpathCount) == false) {
					return false;
				}
				String NewAmt = objCommon.fGuiRandomNumber();
				if (objCommon.fGuiEnterText(AMOUNT, NewAmt) == false) {
					return false;
				}
				if (objCommon.fGuiHideKeyBoard() == false) {
					return false;
				}
				if (objCommon.fGuiClick(TRANSFER) == false) {
					return false;
				}
				if (objCommon.fGuiBackPress() == false) {
					return false;
				}
				Reporter.fnWriteToHtmlOutput("Quick Transfer",
						"Quick transfer with drag and drop should Done",
						"Quick transfer with drag and drop is Done", "Pass");
				System.out
						.println("Quick Transfer is Completed by drag and drop own accounts");
				// Checking Balance.
				String A = TxnAccBal.valueOf(TxnAccBal);
				objCommon.fGuiClick(accountRowLayout);
				String B = TxnListBal.valueOf(TxnListBal);
				if (A == B) {
					System.out.println("Transaction Balance are same");
				} else {
					System.out.println("Transaction Balance got differed");
				}

				// Verify the Txn for the Account
				System.out.println("Verifying the available txn in records");
				List<WebElement> Txnpath = driver
						.findElements(By
								.xpath("//android.widget.LinearLayout[@index='3']/android.widget.LinearLayout/*"));
				int TxnpathCount = Txnpath.size();
				System.out.println("Total xpath: " + TxnpathCount);
				Reporter.fnWriteToHtmlOutput("Number of Avavilable Txn",
						"User should have more than one Transfer txn.",
						"User have more Transfer txn.", "Pass");
				System.out.println("User have other account to transfer.");
				if (TxnpathCount >= 1) {
					for (TxnpathCount = 1; TxnpathCount <= Txnpath.size(); TxnpathCount += 2) {
						String TxnStart = "Xpath:=//android.widget.LinearLayout[@index='3']/android.widget.LinearLayout[@index='";
						String Txnend = "']";
						String NewTxn = TxnStart + TxnpathCount + Txnend;
						TxnLayout = NewTxn;
						System.out.println("Verifying " + TxnpathCount
								+ " Items of Txn");
						objCommon.fGuiClick(TxnLayout);
					}
					if (objCommon.fGuiBackPress() == false) {
						return false;
					}
				} else {
					Reporter.fnWriteToHtmlOutput("Number of Avavilable Txn",
							"User dont't have more than one Transfer txn.",
							"User dont't have more Transfer txn.", "Fail");
					System.out
							.println("There is no txn available in this account");
				}
			}

		} else {
			Reporter.fnWriteToHtmlOutput("Number of Avavilable Accounts",
					"User don't have more than one account for Transfer.",
					"User don't have more than one account for Transfer.",
					"Fail");
			System.out.println("User don't have other account to transfer.");
		}
		return MakeNewTransferOnce();
	}

	// Verify New Transfer
	public boolean MakeNewTransferOnce() {

		if (objCommon.fGuiClick(Home) == false) {
			return false;
		}

		// Verify the Negative amount is not possible as KeyBoard doesn't allow.
		// No Validation is required.

		// Verifying Once transfer flow -Parameterize for various set of test.
		if (objCommon.fGuiEnterText(SearchAC, Dictionary.get("BENEF1")) == false) {
			return false;
		}
		if (objCommon.fGuiClick(PopUp) == false) {
			return false;
		}
		System.out.println("Enter into flow for one time tranafer");
		if (objCommon.fGuiEnterText(currency_value, Dictionary.get("AMT")) == false) {
			return false;
		}
		objCommon.fGuiHideKeyBoard();

		if (objCommon.fGuiClick(sign_button) == false) {
			return false;
		}

		if (objCommon.fGuiIsDisplayed(ErrorMsg) == false) {
			return false;
		}

		String NewAmt = objCommon.fGuiRandomNumber();
		if (objCommon.fGuiEnterText(currency_value, NewAmt) == false) {
			return false;
		}
		objCommon.fGuiHideKeyBoard();

		// Verify the GUI are visible once transfer page.
		if (objCommon.fGuiIsDisplayed(currency_value) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(one_time_transfer) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(recurring_transfer) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(sign_button) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(ToAc) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(OCR) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(Note) == false) {
			return false;
		}
		if (objCommon.fGuiEnterText(OCR, Dictionary.get("OCR")) == false) {
			return false;
		}
		objCommon.fGuiHideKeyBoard();

		if (objCommon.fGuiEnterText(Note, Dictionary.get("Note")) == false) {
			return false;
		}
		objCommon.fGuiHideKeyBoard();
		if (objCommon.fGuiClick(one_time_transfer) == false) {
			return false;
		}
		if (objCommon.fGuiClick(sign_button) == false) {
			return false;
		}
		if (objCommon.fGuiClick(NewPay) == false) {
			return false;
		}
		if (objCommon.fGuiClick(Home) == false) {
			return false;
		}
		System.out.println("Once Transfer is done");
		return MakeNewTransferOnceRecurring();

	}

	public boolean MakeNewTransferOnceRecurring() {

		// Verifying recurring transfer-"Need to Parameterize for various data.

		if (objCommon.fGuiEnterText(SearchAC, Dictionary.get("BENEF2")) == false) {
			return false;
		}
		if (objCommon.fGuiClick(PopUp) == false) {
			return false;
		}
		System.out.println("Enter into flow for recurring tranafer");
		if (objCommon.fGuiEnterText(currency_value, Dictionary.get("AMT")) == false) {
			return false;
		}
		objCommon.fGuiHideKeyBoard();
		if (objCommon.fGuiClick(sign_button) == false) {
			return false;
		}

		if (objCommon.fGuiIsDisplayed(ErrorMsg) == false) {
			return false;
		}
		String NewAmt = objCommon.fGuiRandomNumber();
		if (objCommon.fGuiEnterText(currency_value, NewAmt) == false) {
			return false;
		}
		objCommon.fGuiHideKeyBoard();

		if (objCommon.fGuiEnterText(OCR, Dictionary.get("OCR")) == false) {
			return false;
		}
		objCommon.fGuiHideKeyBoard();

		// Verify the GUI are visible once transfer page.
		if (objCommon.fGuiIsDisplayed(currency_value) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(one_time_transfer) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(recurring_transfer) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(sign_button) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(ToAc) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(OCR) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(Note) == false) {
			return false;
		}

		if (objCommon.fGuiEnterText(Note, Dictionary.get("Note")) == false) {
			return false;
		}
		if (objCommon.fGuiHideKeyBoard() == false) {
			return false;
		}
		if (objCommon.fGuiClick(recurring_transfer) == false) {
			return false;
		}
		if (objCommon.fGuiClick(sign_button) == false) {
			return false;
		}
		if (objCommon.fGuiBackPress() == false) {
			return false;
		}
		if (objCommon.fGuiClick(Home) == false) {
			return false;
		}
		System.out.println("Recurring Transfer is done");
		return SaveOwnAccount();
	}

	// Verify user can Save new Transfer functionality i.e. Other users account
	public boolean SaveOwnAccount() {

		if (objCommon.fGuiEnterText(SearchAC, Dictionary.get("BENEF3")) == false) {
			return false;
		}
		if (objCommon.fGuiClick(PopUp) == false) {
			return false;
		}
		System.out
				.println("Enter into flow to recurring tranafer to Other users");
		if (objCommon.fGuiEnterText(currency_value, Dictionary.get("AMT")) == false) {
			return false;
		}
		objCommon.fGuiHideKeyBoard();

		if (objCommon.fGuiClick(sign_button) == false) {
			return false;
		}

		if (objCommon.fGuiIsDisplayed(ErrorMsg) == false) {
			return false;
		}

		String NewAmt = objCommon.fGuiRandomNumber();
		if (objCommon.fGuiEnterText(currency_value, NewAmt) == false) {
			return false;
		}
		if (objCommon.fGuiHideKeyBoard() == false) {
			return false;
		}
		if (objCommon.fGuiEnterText(OCR, Dictionary.get("OCR")) == false) {
			return false;
		}
		if (objCommon.fGuiHideKeyBoard() == false) {
			return false;
		}

		// Verify the GUI are visible once transfer page.
		if (objCommon.fGuiIsDisplayed(currency_value) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(one_time_transfer) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(recurring_transfer) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(sign_button) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(ToAc) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(OCR) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(Note) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(SaveNew) == false) {
			return false;
		}

		if (objCommon.fGuiEnterText(Note, Dictionary.get("Note")) == false) {
			return false;
		}
		if (objCommon.fGuiHideKeyBoard() == false) {
			return false;
		}
		if (objCommon.fGuiClick(recurring_transfer) == false) {
			return false;
		}
		if (objCommon.fGuiClick(SaveNew) == false) {
			return false;
		}
		// if (objCommon.fGuiClick(single) == false) {
		// return false;
		// }
		if (objCommon.fGuiClick(Home) == false) {
			return false;
		}
		System.out.println("Recurring tranafer to Other user is completed");
		return SaveOtherAccount();
	}

	// Verify user can Save new Transfer functionality i.e. OtherBanks account
	public boolean SaveOtherAccount() {

		if (objCommon.fGuiEnterText(SearchAC, Dictionary.get("BENEF4")) == false) {
			return false;
		}
		if (objCommon.fGuiClick(PopUp) == false) {
			return false;
		}
		System.out
				.println("Enter into flow for recurring tranafer to Other Banks Account");
		if (objCommon.fGuiEnterText(currency_value, Dictionary.get("AMT")) == false) {
			return false;
		}
		objCommon.fGuiHideKeyBoard();
		if (objCommon.fGuiClick(sign_button) == false) {
			return false;
		}

		if (objCommon.fGuiIsDisplayed(ErrorMsg) == false) {
			return false;
		}
		String NewAmt = objCommon.fGuiRandomNumber();
		if (objCommon.fGuiEnterText(currency_value, NewAmt) == false) {
			return false;
		}
		if (objCommon.fGuiHideKeyBoard() == false) {
			return false;
		}

		// Verify the GUI are visible once transfer page.
		if (objCommon.fGuiIsDisplayed(currency_value) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(one_time_transfer) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(recurring_transfer) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(sign_button) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(ToAc) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(OCR) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(Note) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(SaveNew) == false) {
			return false;
		}
		if (objCommon.fGuiEnterText(OCR, Dictionary.get("OCR")) == false) {
			return false;
		}
		if (objCommon.fGuiHideKeyBoard() == false) {
			return false;
		}

		if (objCommon.fGuiEnterText(Note, Dictionary.get("Note")) == false) {
			return false;
		}
		if (objCommon.fGuiHideKeyBoard() == false) {
			return false;
		}
		if (objCommon.fGuiClick(recurring_transfer) == false) {
			return false;
		}
		if (objCommon.fGuiClick(SaveNew) == false) {
			return false;
		}
		// if (objCommon.fGuiClick(single) == false) {
		// return false;
		// }
		if (objCommon.fGuiClick(Home) == false) {
			return false;
		}
		System.out
				.println("Recurring Transfer to Other Banks Account is completed.");
		return true;
	}

}