package ForexAutomation.java;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.tieto.asap.CommonFunctions;
import com.tieto.asap.Global;
import com.tieto.asap.Reporting;

public class BeneficiaryRegister {
	public Reporting Reporter;
	public WebDriver driver;
	public HashMap<String, String> Dictionary;
	public HashMap<String, String> Environment;
	public CommonFunctions objCommon = new CommonFunctions();
	AndroidDriver driver1;

	// Define the constructor
	public BeneficiaryRegister() {
		Reporter = Global.Reporter;
		driver = Global.webDriver;
		Dictionary = Global.Dictionary;
		Environment = Global.Environment;
	}

	// Global menu Strings
	public String GLOBALMENU = "id:=mainMenuImg";
	public String FULLMENU = "id:=tvQuickMenu_FullMenu";
	public String NEWPAYMENTSCR = "name:=Betalningar och överföringar";
	public String BENEFICIARYOPT = "name:=Mottagarregister";
	public String HEADERACC = "id:=balance_layout";
	public String LOGOUT = "id:=home_logout";
	public String TITLE = "id:=page_header_text_view";
	public String FOOTERHOME = "id:=homeMenuImg";
	public String NOTIFICATION = "id:=notificationMenuImg";
	public String FILTERLABEL = "id:=filter_result_label";
	public String SEARCHLABLE = "name:=Sök";

	// Add beneficiary

	public String ADDBENE = "id:=add_beneficiary_layout";
	public String ENTERNOLABEL = "id:=input_beneficiary_view";
	public String ENTERNO = "id:=input_beneficiary";
	public String NEXT = "id:=btnNext";
	public String ACCNOLABEL = "id:=beneficiaryAccount_view";
	public String ACCTYPELABEL = "id:=beneficiaryBankName_view";
	public String ENTERNAMELABEL = "id:=beneficiaryName_view";
	public String ENTERNAME = "id:=beneficiaryName_value";
	public String SAVEBTN = "id:=btnAddBeneficiary";
	public String SELECTTYPE = "id:=beneficiaryBankName_value";
	public String SELECT = "xpath:=//android.widget.FrameLayout[@index = '0']//android.widget.LinearLayout[@index='1']";
	public String ADDALERT = "id:=alertTitle";
	public String ADDALERTOK = "id:=button1";
	public String INCOK = "id:=button1";

	// Search beneficiary
	public String ALERTTITLE = "id:=alertTitle";
	public String SEARCHTEXT = "id:=input_search_beneficiary";
	public String FILTER = "id:=spinner_filter_beneficiary";
	public String ALL = "id:=from_account_name";
	public String ACCOUNT = "xpath:=//android.widget.FrameLayout[@index='0']//android.widget.LinearLayout[@index='1']";
	public String COMPANY = "xpath:=//android.widget.FrameLayout[@index='0']//android.widget.LinearLayout[@index='2']";
	public String NOBENE = "id:=no_matching_record";

	// Delete or Update beneficiary
	public String COMPANYENTRY = "xpath:=//android.widget.TextView[@text='Dec Drift-Energi-Control AB']";
	public String DELETE = "xpath:=//android.widget.FrameLayout[@index='0']//android.widget.LinearLayout[@index='0']";
	public String ACCENTRY = "xpath:=//android.widget.TextView[@text='A TEST ACC']";
	public String UPDATE = "xpath:=//android.widget.FrameLayout[@index='0']//android.widget.LinearLayout[@index='0']";
	public String DELETE1 = "xpath:=//android.widget.FrameLayout[@index='0']//android.widget.LinearLayout[@index='1']";
	public String UPDATEDDEL = "xpath:=//android.widget.TextView[@text='B TEST ACC']";
	public String ENTRYFILTER = "id:=alertTitle";
	public String DELALERT = "id:=message";
	public String DELOK = "id:=button1";
	public String DELCANCEL = "id:=button2";
	public String UPDATEENTRYNOLABEL = "id:=beneficiary_account_view";
	public String UPDATEENTRYTYPELABEL = "id:=beneficiary_bankName_view";
	public String UPDATEENTRYNAMELABEL = "id:=beneficiary_name_view";
	public String UPDATEBTN = "id:=btn_save_beneficiary";
	public String UPDATEENTRYNAME = "id:=beneficiary_name_value";

	public String Filter = "id:=se.forex.android.mobilbank.test:id/from_account_name";
	public String FilterItems = "xpath:=//android.widget.ListView[@index='0']//android.widget.LinearLayout[@index='0']";
	public String BenefRecords = "xpath:=//android.widget.LinearLayout[@index='6']//android.widget.RelativeLayout[@index='0']";

	// Add beneficiary
	public boolean Addbeneficiary() {

		// Global menu
		if (objCommon.fGuiClick(GLOBALMENU) == false) {
			return false;
		}
		if (objCommon.fGuiClick(FULLMENU) == false) {
			return false;
		}

		if (objCommon.fGuiClick(NEWPAYMENTSCR) == false) {
			return false;
		}

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		if (objCommon.fGuiScroll() == false) {
			return false;
		}
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		if (objCommon.fGuiClick(BENEFICIARYOPT) == false) {
			return false;
		}

		// Beneficiary screen UI element
		System.out.println("Beneficiary screen UI objects");

		if (objCommon.fGuiIsDisplayed(HEADERACC) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(LOGOUT) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(TITLE) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(SEARCHLABLE) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(FILTERLABEL) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(FOOTERHOME) == false) {
			return false;
		}

		if (objCommon.fGuiIsDisplayed(NOTIFICATION) == false) {
			return false;
		}

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		Reporter.fnWriteToHtmlOutput("UI component of beneficiary screen",
				"App should show all the UI component of beneficiary screen",
				"App is showing all the UI component of beneficiary screen",
				"Pass");

		// Add beneficiary
		System.out.println("Add beneficiary screen");
		if (objCommon.fGuiClick(ADDBENE) == false) {
			return false;
		}

		// UI of Add beneficiary screen
		System.out.println("Add beneficiary UI objects");
		if (objCommon.fGuiIsDisplayed(HEADERACC) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(LOGOUT) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(TITLE) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(ENTERNOLABEL) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(NEXT) == false) {
			return false;
		}

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		Reporter.fnWriteToHtmlOutput(
				"UI component of Add beneficiary screen",
				"App should show all the UI component of Add beneficiary screen",
				"App is showing all the UI component of Add beneficiary screen",
				"Pass");

		// Add account number
		System.out.println("Add account number");
		if (objCommon.fGuiClick(ENTERNO) == false) {
			return false;
		}
		if (objCommon.fGuiEnterText(ENTERNO, Dictionary.get("BENEF6")) == false) {
			return false;
		}
		if (objCommon.fGuiHideKeyBoard() == false) {
			return false;
		}
		if (objCommon.fGuiClick(NEXT) == false) {
			return false;
		}

		// UI of Save account beneficiary screen

		System.out.println("Save Account beneficiary UI objects");
		if (objCommon.fGuiIsDisplayed(HEADERACC) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(LOGOUT) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(TITLE) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(ACCNOLABEL) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(ACCTYPELABEL) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(ENTERNAMELABEL) == false) {
			return false;
		}

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		Reporter.fnWriteToHtmlOutput(
				"UI component of Save beneficiary screen",
				"App should show all the UI component of Save beneficiary screen",
				"App is showing all the UI component of Save beneficiary screen",
				"Pass");

		// Functional flow of Save beneficiary screen

		System.out.println("Save account beneficiary");

		if (objCommon.fGuiClick(ENTERNAME) == false) {
			return false;
		}
		if (objCommon.fGuiEnterText(ENTERNAME, Dictionary.get("BENENAME")) == false) {
			return false;
		}

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		if (objCommon.fGuiHideKeyBoard() == false) {
			return false;
		}
		if (objCommon.fGuiClick(SAVEBTN) == false) {
			return false;
		}

		System.out.println("Account number is added");

		Reporter.fnWriteToHtmlOutput("Add account beneficiary",
				"App should add account beneficiary",
				"App is adding account beneficiary", "Pass");

		// Add company beneficiary
		System.out.println("Add company beneficiary");

		if (objCommon.fGuiClick(ADDBENE) == false) {
			return false;
		}

		if (objCommon.fGuiClick(ENTERNO) == false) {
			return false;
		}
		if (objCommon.fGuiEnterText(ENTERNO, Dictionary.get("BENEF5")) == false) {
			return false;
		}
		if (objCommon.fGuiHideKeyBoard() == false) {
			return false;
		}
		if (objCommon.fGuiClick(NEXT) == false) {
			return false;
		}
		if (objCommon.fGuiClick(SELECTTYPE) == false) {
			return false;
		}
		if (objCommon.fGuiClick(SELECT) == false) {
			return false;
		}
		if (objCommon.fGuiClick(SAVEBTN) == false) {
			return false;
		}

		System.out.println("Company number is added");

		Reporter.fnWriteToHtmlOutput("Add company beneficiary",
				"App should add company beneficiary",
				"App is adding company beneficiary", "Pass");

		// Duplicate beneficiary
		System.out.println("Error while adding Duplicate beneficiary");
		if (objCommon.fGuiClick(ADDBENE) == false) {
			return false;
		}

		if (objCommon.fGuiClick(ENTERNO) == false) {
			return false;
		}
		if (objCommon.fGuiEnterText(ENTERNO, Dictionary.get("BENEF5")) == false) {
			return false;
		}
		if (objCommon.fGuiHideKeyBoard() == false) {
			return false;
		}
		if (objCommon.fGuiClick(NEXT) == false) {
			return false;
		}
		if (objCommon.fGuiClick(SELECTTYPE) == false) {
			return false;
		}
		if (objCommon.fGuiClick(SELECT) == false) {
			return false;
		}
		if (objCommon.fGuiClick(SAVEBTN) == false) {
			return false;
		}

		// Duplicate beneficiary alert UI
		System.out.println("Duplicate beneficiary UI objects");
		if (objCommon.fGuiIsDisplayed(ALERTTITLE) == false) {
			return false;
		}

		if (objCommon.fGuiIsDisplayed(INCOK) == false) {
			return false;
		}

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		Reporter.fnWriteToHtmlOutput(
				"UI component of Duplicate beneficiary alert",
				"App should show all the UI component of Duplicate beneficiary alert",
				"App is showing all the UI component of Duplicate beneficiary alert",
				"Pass");

		if (objCommon.fGuiClick(ADDALERTOK) == false) {
			return false;
		}

		Reporter.fnWriteToHtmlOutput("Duplicate beneficiary alert",
				"App should show Duplicate beneficiary alert",
				"App is showing Duplicate beneficiary alert", "Pass");

		if (objCommon.fGuiBackPress() == false) {
			return false;
		}

		// Error while adding incorrect company beneficiary
		System.out.println("Error while adding incorrect beneficiary");
		if (objCommon.fGuiClick(ADDBENE) == false) {
			return false;
		}
		if (objCommon.fGuiClick(ENTERNO) == false) {
			return false;
		}
		if (objCommon.fGuiEnterText(ENTERNO, Dictionary.get("BENEF3")) == false) {
			return false;
		}
		if (objCommon.fGuiHideKeyBoard() == false) {
			return false;
		}
		if (objCommon.fGuiClick(NEXT) == false) {
			return false;
		}
		System.out.println("Alert message gets appeared");

		// Incorrect beneficiary alert UI
		System.out.println("Incorrect beneficiary error UI objects");
		if (objCommon.fGuiIsDisplayed(ALERTTITLE) == false) {
			return false;
		}

		if (objCommon.fGuiIsDisplayed(INCOK) == false) {
			return false;
		}

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		Reporter.fnWriteToHtmlOutput(
				"UI component of Incorrect beneficiary alert",
				"App should show all the UI component of Incorrect beneficiary alert",
				"App is showing all the UI component of Incorrect beneficiary alert",
				"Pass");

		if (objCommon.fGuiClick(ADDALERTOK) == false) {
			return false;
		}
		Reporter.fnWriteToHtmlOutput("Incorrect beneficiary alert",
				"App should show Incorrect beneficiary alert",
				"App is showing Incorrect beneficiary alert", "Pass");

		if (objCommon.fGuiBackPress() == false) {
			return false;
		}

		return SearchBeneficiary();

	}

	// Search beneficiary

	public boolean SearchBeneficiary() {
		
		if (objCommon.fGuiClick(SEARCHTEXT) == false) {
			return false;
		}
		if (objCommon
				.fGuiEnterText(SEARCHTEXT, Dictionary.get("INVALIDSEARCH")) == false) {
			return false;
		}
		if (objCommon.fGuiHideKeyBoard() == false) {
			return false;
		}
		// No beneficiary message UI
		System.out.println("No beneficiary message");
		if (objCommon.fGuiIsEnabled(NOBENE) == false) {
			return false;
		}

		Reporter.fnWriteToHtmlOutput(
				"No beneficiary",
				"App should show No Beneficiary message after adding incorrect inputs",
				"App is showing No beneficiary message", "Pass");

		// Search beneficiary by valid input

		System.out.println("Searh results for valid input");
		if (objCommon.fGuiClick(SEARCHTEXT) == false) {
			return false;
		}

		if (objCommon.fGuiEnterText(SEARCHTEXT, Dictionary.get("SEARCH")) == false) {
			return false;
		}
		if (objCommon.fGuiHideKeyBoard() == false) {
			return false;
		}

		Reporter.fnWriteToHtmlOutput(
				"Search beneficiary",
				"App should show search result after adding inputs under Search field",
				"App is showing search result", "Pass");

		// Search beneficiary by filter
		if (objCommon.fGuiClick(FILTER) == false) {
			return false;
		}

		// Search filter UI
		System.out.println("Search Filter UI objects");
		if (objCommon.fGuiIsDisplayed(ALERTTITLE) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(ALL) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(COMPANY) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(ACCOUNT) == false) {
			return false;
		}

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		Reporter.fnWriteToHtmlOutput("UI component of Search filter",
				"App should show all the UI component of Search filter",
				"App is showing all the UI component of Search filter", "Pass");

		// Functional flow Search filter

		System.out.println("Search result for Filter - Company");
		if (objCommon.fGuiClick(ACCOUNT) == false) {
			return false;
		}
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		if (objCommon.fGuiClick(FILTER) == false) {
			return false;
		}
		System.out.println("Search result for Filter - Account number");
		if (objCommon.fGuiClick(COMPANY) == false) {
			return false;
		}
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		if (objCommon.fGuiClick(FILTER) == false) {
			return false;
		}
		System.out.println("Search result for Filter - All");
		if (objCommon.fGuiClick(ALL) == false) {
			return false;
		}
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		Reporter.fnWriteToHtmlOutput("Search filter",
				"App should change search filter",
				"App successfully changes search filter", "Pass");

		return DeleteBeneficiary();

	}

	// Delete beneficiary
	public boolean DeleteBeneficiary() {
		// Deleting Company beneficiary
		System.out.println("Deleting Company beneficiary entry");
		if (objCommon.fGuiClick(COMPANYENTRY) == false) {
			return false;
		}

		// UI of selection filter
		System.out.println("UI of company entry selection filter");
		if (objCommon.fGuiIsDisplayed(ENTRYFILTER) == false) {
			return false;
		}

		if (objCommon.fGuiIsDisplayed(DELETE) == false) {
			return false;
		}
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		Reporter.fnWriteToHtmlOutput("UI component of selection filter",
				"App should show all the UI component of selection filter",
				"App is showing all the UI component of selection filter",
				"Pass");

		// Selecting Delete button
		if (objCommon.fGuiClick(DELETE) == false) {
			return false;
		}

		// UI of delete Popup
		System.out.println("Delete popup UI objects");
		if (objCommon.fGuiIsDisplayed(DELALERT) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(DELCANCEL) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(DELOK) == false) {
			return false;
		}

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		Reporter.fnWriteToHtmlOutput("UI component of Delete popup",
				"App should show all the UI component of Delete popup",
				"App is showing all the UI component of Delete popup", "Pass");

		// Abort delete Action
		System.out.println("Delete - Cancel button Action");
		if (objCommon.fGuiClick(DELCANCEL) == false) {
			return false;
		}

		Reporter.fnWriteToHtmlOutput(
				"Abort delete action",
				"App should abort the delete action after tapping 'Cancel' button",
				"App successfully aborts the delete action", "Pass");

		// Deleting Entry
		System.out.println("Delete - OK button action");
		if (objCommon.fGuiClick(COMPANYENTRY) == false) {
			return false;
		}
		if (objCommon.fGuiClick(DELETE) == false) {
			return false;
		}
		if (objCommon.fGuiClick(DELOK) == false) {
			return false;
		}

		Reporter.fnWriteToHtmlOutput("Delete company beneficiary",
				"App should delete company beneficiary",
				"App successfully delets company beneficiary", "Pass");

		return UpdateBeneficiary();

	}

	public boolean UpdateBeneficiary() {
		// Deleting Company beneficiary
		System.out.println("Deleting Company beneficiary entry");
		if (objCommon.fGuiClick(ACCENTRY) == false) {
			return false;
		}
		// UI of account beneficiary selection filter
		System.out.println("UI of Account entry selection filter");
		if (objCommon.fGuiIsDisplayed(ENTRYFILTER) == false) {
			return false;
		}

		if (objCommon.fGuiIsDisplayed(UPDATE) == false) {
			return false;
		}

		if (objCommon.fGuiIsDisplayed(DELETE1) == false) {
			return false;
		}
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		Reporter.fnWriteToHtmlOutput(
				"UI component of account beneficiary  selection filter",
				"App should show all the UI component of account beneficiary selection filter",
				"App is showing all the UI component of account beneficiary selection filter",
				"Pass");

		// Selecting Update button
		System.out.println("Navigation to Update account beneficiary screen");
		if (objCommon.fGuiClick(UPDATE) == false) {
			return false;
		}

		// UI of Update account beneficiary screen
		System.out.println("Update account beneficiary screen UI objects");
		if (objCommon.fGuiIsDisplayed(HEADERACC) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(LOGOUT) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(TITLE) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(UPDATEENTRYNOLABEL) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(UPDATEENTRYTYPELABEL) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(UPDATEENTRYNAMELABEL) == false) {
			return false;
		}
		if (objCommon.fGuiIsDisplayed(UPDATEBTN) == false) {
			return false;
		}

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		Reporter.fnWriteToHtmlOutput(
				"UI component of Update Account beneficiary name screen",
				"App should show all the UI component of Account beneficiary name screen",
				"App is showing all the UI component of Account beneficiary name screen",
				"Pass");

		// Update account beneficiary name
		System.out.println("Updating account beneficiary name");

		if (objCommon.fGuiClick(UPDATEENTRYNAME) == false) {
			return false;
		}
		objCommon.fGuiEnterText(UPDATEENTRYNAME,
				Dictionary.get("UPDATEBENENAME"));

		if (objCommon.fGuiHideKeyBoard() == false) {
			return false;
		}

		if (objCommon.fGuiClick(UPDATEBTN) == false) {
			return false;
		}

		Reporter.fnWriteToHtmlOutput("Update account beneficiary name",
				"App should update account beneficiary name",
				"App successfully updates account beneficiary name", "Pass");

		// Delete updated entry
		System.out.println("Delete updated account beneficiary entry");

		if (objCommon.fGuiClick(UPDATEDDEL) == false) {
			return false;
		}

		if (objCommon.fGuiClick(DELETE1) == false) {
			return false;
		}

		if (objCommon.fGuiClick(DELOK) == false) {
			return false;
		}

		Reporter.fnWriteToHtmlOutput("Delete updated account beneficiary",
				"App should Delete updated account beneficiary",
				"App successfully Delete updated account beneficiary", "Pass");

		return true;
	}

	public boolean SearchValidation() {

		if (objCommon.fGuiClick(GLOBALMENU) == false) {
			return false;
		}
		if (objCommon.fGuiClick(FULLMENU) == false) {
			return false;
		}

		if (objCommon.fGuiClick(NEWPAYMENTSCR) == false) {
			return false;
		}

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		if (objCommon.fGuiScroll() == false) {
			return false;
		}
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		if (objCommon.fGuiClick(BENEFICIARYOPT) == false) {
			return false;
		}

		if (objCommon.fGuiClick(ADDBENE) == false) {
			return false;
		}

		Random rand = new Random();
		for (Integer i = (rand.nextInt(10) + 1); i <= 1000000000; i *= 11) {
			System.out.println(i);

			if (objCommon.fGuiClick(ENTERNO) == false) {
				return false;
			}
			if (objCommon.fGuiEnterText(ENTERNO, i.toString()) == false) {
				return false;
			}
			if (objCommon.fGuiIsEnabled(NEXT) == false) {
				System.out.println("Next button is not Enable for number " + i);
			} else {
				System.out.println("Next button is  Enable for number " + i);
			}
		}
		// driver.findElements(By.id(ENTERNO)).clear();
		return true;
	}
	
	
	
	//Verify Filter... 
	
	public boolean Benefilter() {
		if (objCommon.fGuiClick(GLOBALMENU) == false) {
			return false;
		}
		if (objCommon.fGuiClick(FULLMENU) == false) {
			return false;
		}

		if (objCommon.fGuiClick(NEWPAYMENTSCR) == false) {
			return false;
		}

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		if (objCommon.fGuiScroll() == false) {
			return false;
		}
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		if (objCommon.fGuiClick(BENEFICIARYOPT) == false) {
			return false;
		}

		// Search beneficiary by incorrect input
		// System.out.println("Search beneficiary by incorrect input");
		objCommon.fGuiClick(Filter);
		List<WebElement> Lpath = driver
				.findElements(By
						.xpath("//android.widget.ListView[@index='0']//android.widget.LinearLayout/*"));
		int LpathCount = Lpath.size();
		System.out.println(LpathCount);
		if (LpathCount > 0) {
			for (LpathCount = 0; LpathCount < Lpath.size(); LpathCount++) {
				String LStart = "Xpath:=//android.widget.ListView[@index='0']//android.widget.LinearLayout[@index='";
				String Lend = "']";
				String NewFilterItems = LStart + LpathCount + Lend;
				FilterItems = NewFilterItems;
				// Selecting Items from Filter dropdown.
				if (objCommon.fGuiClick(FilterItems) == false) {
					return false;
				}
				if (objCommon.fGuiScroll() == false) {
					return false;
				}
				// Verifying Items from BeneficiaryList.
				List<WebElement> Bpath = driver
						.findElements(By
								.xpath("//android.widget.LinearLayout[@index='6']//android.widget.RelativeLayout/* "));
				int BpathCount = Bpath.size();
				if (BpathCount > 0) {
					System.out.println(BpathCount);
					for (BpathCount = 0; BpathCount <= Bpath.size(); BpathCount++) {
						String BStart = "Xpath:=//android.widget.LinearLayout[@index='6']//android.widget.RelativeLayout[@index='";
						String Bend = "']";
						String NewBenefRecords = BStart + BpathCount + Bend;
						BenefRecords = NewBenefRecords;
						
						// String a =
						// driver.findElement(By.id(BenefRecords)).getText();
						// System.out.println(a);
						// String REGEX = "\b";
						// String INPUT = a;
						// // private static String REPLACE = "-";
						// Pattern p = Pattern.compile(REGEX);
						// Matcher m = p.matcher(INPUT);
						// if (m.matches() == true){
						// System.out.println("This is BG or PG Beneficia");
						// }
						
						if (objCommon.fGuiClick(BenefRecords) == false) {
							return false;
						}
						objCommon.fGuiBackPress();
					}
				} else {
					System.out.println("List hasd no records available");
				}
			}
		} else {
			System.out.println("There is no records availble to select");
		}
		return true;
	}
}
