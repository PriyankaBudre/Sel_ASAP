package ForexAutomation.java;

import io.appium.java_client.android.AndroidDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import com.sun.org.apache.xpath.internal.operations.And;
import com.tieto.asap.CommonFunctions;
import com.tieto.asap.Global;
import com.tieto.asap.Reporting;

public class NewPayment {

	private Reporting Reporter;
	private WebDriver driver;

	private HashMap<String, String> Dictionary;
	private HashMap<String, String> Environment;
	private CommonFunctions objCommon = new CommonFunctions();

	public NewPayment() {
		Reporter = Global.Reporter;
		driver = Global.webDriver;
		Dictionary = Global.Dictionary;
		Environment = Global.Environment;
	}

	public String mainMenuImage = "id:=se.forex.android.mobilbank.test:id/mainMenuImg";
	public String newPaymentButton = "id:=se.forex.android.mobilbank.test:id/tvQuickMenuPayment";
	public String searchBeneficiaryName = "id:=se.forex.android.mobilbank.test:id/bgpg_search_fieldtext";
	public String searchBeneficiaryButton = "id:=se.forex.android.mobilbank.test:id/search_buton_image";
	public String saveButton = "id:=se.forex.android.mobilbank.test:id/save_button";
	public String editCurrency = "id:=se.forex.android.mobilbank.test:id/currency_value";
	public String ocrValue = "id:=se.forex.android.mobilbank.test:id/ocr_value";
	public String saveAndPaymentoButton = "id:=se.forex.android.mobilbank.test:id/save_and_new_payment_button";
	public String signButton = "id:=se.forex.android.mobilbank.test:id/sign_button";
	public String signEndast = "id:=android:id/button2";
	public String okButton = "name:=OK";

	public void checkNewPayment() {

		/*
		 * objCommon.fGuiIsDisabled(mainMenuImage);
		 * objCommon.fGuiIsDisabled(newPaymentButton);
		 * objCommon.fGuiIsDisabled(searchBeneficiaryName);
		 * objCommon.fGuiIsDisabled(searchBeneficiaryButton);
		 * objCommon.fGuiIsDisabled(saveButton);
		 * objCommon.fGuiIsDisabled(editCurrency);
		 */

		objCommon.fGuiClick(mainMenuImage);
		objCommon.fGuiClick(newPaymentButton);
		// BG
		objCommon.fGuiEnterText(searchBeneficiaryName, "3228756");
		objCommon.fGuiClick(searchBeneficiaryButton);
		objCommon.fGuiClick(saveButton);
		objCommon.fGuiEnterText(editCurrency, "21");
		// objCommon.fGuiHideKeyBoard();
		objCommon.fGuiEnterText(ocrValue, "10966400227");
		// objCommon.fGuiHideKeyBoard();
		objCommon.fGuiScroll();
		objCommon.fGuiClick(signButton);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		objCommon.fGuiClick(signEndast);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

		// PG
		/*
		 * objCommon.fGuiClick(mainMenuImage);
		 * objCommon.fGuiClick(newPaymentButton);
		 * objCommon.fGuiEnterText(searchBeneficiaryName,"9200031");
		 * objCommon.fGuiClick(searchBeneficiaryButton);
		 * objCommon.fGuiClick(saveButton);
		 * objCommon.fGuiEnterText(editCurrency,"21");
		 * objCommon.fGuiHideKeyBoard();
		 * objCommon.fGuiEnterText(ocrValue,"1013677580314660");
		 * objCommon.fGuiHideKeyBoard(); objCommon.fGuiScroll();
		 * objCommon.fGuiClick(signButton); objCommon.fGuiClick(okButton);
		 * objCommon.fGuiBackPress();
		 */

	}

}
