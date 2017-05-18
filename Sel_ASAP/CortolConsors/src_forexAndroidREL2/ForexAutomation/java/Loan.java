package ForexAutomation.java;

import io.appium.java_client.android.AndroidDriver;

import java.awt.List;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import com.tieto.asap.CommonFunctions;
import com.tieto.asap.Driver;
import com.tieto.asap.Global;
import com.tieto.asap.Reporting;

public class Loan {

	private Reporting Reporter;
	private AndroidDriver driver;
	private HashMap<String, String> Dictionary;
	private HashMap<String, String> Environment;
	private CommonFunctions objCommon = new CommonFunctions();

	// Define the constructor
	public Loan() {
		Reporter = Global.Reporter;
		driver = (AndroidDriver) Global.webDriver;
		Dictionary = Global.Dictionary;
		Environment = Global.Environment;
	}

	public String GLOBALMENU = "id:=mainMenuImg";
	public String FULLMENU = "id:=se.forex.android.mobilbank.test:id/tvQuickMenu_FullMenu";
	public String LoanMenu = "name:=Lån";
	public String LoanItem = "Xpath:=//android.widget.ListView[@index='0']//android.widget.RelativeLayout[@index='1']";
	public String LoanName = "id:=se.forex.android.mobilbank.test:id/loan_nickname";
	public String LoanBalance = "id:=se.forex.android.mobilbank.test:id/loan_balance_text";
	public String LoanActNo = "id:=se.forex.android.mobilbank.test:id/loan_account_number";
	public String LoanImage = "id:=se.forex.android.mobilbank.test:id/loan_type_image";
	public String LoanBar = "id:=se.forex.android.mobilbank.test:id/loan_seekbar_progress";
	public String LoanInterest = "id:=se.forex.android.mobilbank.test:id/loan_intrest_rate_view";
	public String LoanIntAmt = "id:=se.forex.android.mobilbank.test:id/loan_initial_debit_value";
	public String LoanAmtVal = "id:=se.forex.android.mobilbank.test:id/loan_amount_value";
	public String LoanIntVal = "id:=se.forex.android.mobilbank.test:id/loan_current_interest_value";
	public String LoanDueDate = "id:=se.forex.android.mobilbank.test:id/loan_due_date_value";
	public String LoanProtect = "id:=se.forex.android.mobilbank.test:id/loan_insurance_status";
	public String isProtect = "name:=Ja";
	public String LoanList = "id:=se.forex.android.mobilbank.test:id/loan_list";
	public String NoTxn = "id:=se.forex.android.mobilbank.test:id/no_transaction_view";
	public String Block = "class:=android.widget.RelativeLayout";
	public String NoLoan = "id:=se.forex.android.mobilbank.test:id/no_loan_view";
	public String LoanTxn = "Xpath:=//android.widget.LinearLayout[@index='1']//android.widget.LinearLayout[@index='1']";
	public String LoanTxnAmt = "id:=se.forex.android.mobilbank.test:id/transaction_amount";
	public String LoanExpTyp = "id:=se.forex.android.mobilbank.test:id/expenses_type";
	public String LoanExp = "id:=se.forex.android.mobilbank.test:id/expenses";

	// Verify # of Loans available in LoanList along with the Displayed Content.
	public boolean LoanPage() {
		// Write code to verify the Loan List
		if (objCommon.fGuiClick(GLOBALMENU) == false) {
			return false;
		}
		if (objCommon.fGuiClick(FULLMENU) == false) {
			return false;
		}
		if (objCommon.fGuiClick(LoanMenu) == false) {
			return false;
		}
		System.out.println("Verifying Loan Items Into the LoanList Page");

		@SuppressWarnings("rawtypes")
		java.util.List counter = driver.findElements(By
				.xpath("//android.widget.ListView/*"));
		int x = counter.size();
		if (x == 0) {
			System.out.println("No loan accounts are available for the User.");
		} else {
			for (int i = 1; i <= counter.size() - 5; i++) {
				String xStart = "Xpath:=//android.widget.ListView[@index='0']//android.widget.RelativeLayout[@index='";
				String xend = "']";
				String NewLoanItem = xStart + i + xend;
				LoanItem = NewLoanItem;
				if (objCommon.fGuiIsDisplayed(LoanItem) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(LoanName) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(LoanBalance) == false)
					return false;
				if (objCommon.fGuiIsDisplayed(LoanActNo) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(LoanImage) == false) {
					return false;
				}
				System.out.println(i + " Loan Items got verified");
			}
		}
		return LoanDetails();
	}

	// Verify the Content of Loan Details for # of Loans available in list.
	public boolean LoanDetails() {

		@SuppressWarnings("rawtypes")
		java.util.List counter = driver.findElements(By
				.xpath("//android.widget.ListView/*"));
		int x = counter.size();
		if (x == 0) {
			Reporter.fnWriteToHtmlOutput("Number of avavilable Loan Accounts",
					"User should have min one Loan account.",
					"User dont have min one Loan account.", "fail");
			System.out.println("No loan accounts are available for the User.");
			return false;
		} else {

			Reporter.fnWriteToHtmlOutput("Number of avavilable Loan Accounts",
					"User should have min one Loan account.",
					"User have more Loan account.", "Pass");
			System.out.println("Enter Into the Details Page");
			// System.out.println(x);
			for (int i = 1; i <= counter.size() - 5; i++) {

				String xStart = "Xpath:=//android.widget.ListView[@index='0']//android.widget.RelativeLayout[@index='";
				String xend = "']";
				String NewLoanItem = xStart + i + xend;
				LoanItem = NewLoanItem;
				AssertJUnit.assertNotNull("Loan Item is not found in the Page",
						LoanItem);
				if (objCommon.fGuiClick(LoanItem) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(LoanBar) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(LoanIntAmt) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(LoanIntVal) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(LoanDueDate) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(LoanProtect) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(LoanAmtVal) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(isProtect) == true) {
					System.out.println(i + " Loan Item is Protected");
				} else {
					System.out.println(i + " Loan Item is not Protected");
				}
				if (objCommon.fGuiBackPress() == false) {
					return false;
				}
			}
		}
		return LoanTxn();
	}

	// Verify the shown LoanTransaction.
	public boolean LoanTxn() {
		// Write code to verify the Loan Transaction
		@SuppressWarnings("rawtypes")
		java.util.List counter = driver.findElements(By
				.xpath("//android.widget.ListView/*"));
		int x = counter.size();
		if (x == 0) {
			Reporter.fnWriteToHtmlOutput("Number of avavilable Loan Accounts",
					"User should have min one Loan account.",
					"User dont have min one Loan account.", "fail");
			System.out.println("No loan accounts are available for the User.");
			return false;
		} else {
			Reporter.fnWriteToHtmlOutput("Number of avavilable Loan Accounts",
					"User should have min one Loan account.",
					"User have more Loan account.", "Pass");
			System.out.println("Need to verify the txn scenario in detail");

			System.out.println("Enter Into the Details Page");
			// System.out.println(x);
			for (int i = 1; i <= counter.size(); i++) {
				String xStart = "Xpath:=//android.widget.ListView[@index='0']//android.widget.RelativeLayout[@index='";
				String xend = "']";
				String NewLoanItem = xStart + i + xend;
				LoanItem = NewLoanItem;
				AssertJUnit.assertNotNull("Loan Item is not found in the Page",
						LoanItem);
				if (objCommon.fGuiClick(LoanItem) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(LoanBar) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(LoanIntAmt) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(LoanIntVal) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(LoanDueDate) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(LoanProtect) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(LoanAmtVal) == false) {
					return false;
				}
				if (objCommon.fGuiIsDisplayed(isProtect) == true) {
					System.out.println(i + " Loan Item is Protected");
				} else {
					System.out.println(i + " Loan Item is not Protected");
				}
				// *** No Idea about the Test Scenario and conditions****//
				System.out
						.println("Verifying if the Loan account has transaction(s).");

				java.util.List Txncount = driver
						.findElements(By
								.xpath("//android.widget.LinearLayout[@index='1']/android.widget.LinearLayout[@index='1']"));
				int Txn = Txncount.size();
				System.out.println(Txn);
				if (Txn == 0) {
					System.out.println(i + "Loan account has No Txn");
					if (objCommon.fGuiBackPress() == false) {
						return false;
					}
				} else {
					for (Txn = 1; Txn <= Txncount.size(); Txn++) {
						String TxnStart = "Xpath:=//android.widget.LinearLayout[@index='1']//android.widget.LinearLayout[@index='";
						String Txnend = "']";
						String NewLoanTxn = TxnStart + Txn + Txnend;
						LoanTxn = NewLoanTxn;

						if (objCommon.fGuiIsDisplayed(LoanTxnAmt) == false) {
							return false;
						}
						if (objCommon.fGuiIsDisplayed(LoanExpTyp) == false) {
							return false;
						}
						if (objCommon.fGuiIsDisplayed(LoanExp) == false) {
							return false;
						}
						if (objCommon.fGuiBackPress() == false) {
							return false;
						}
					}

				}
			}
		}
		return true;
	}
}
