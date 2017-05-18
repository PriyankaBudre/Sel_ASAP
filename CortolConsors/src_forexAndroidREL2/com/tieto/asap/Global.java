package com.tieto.asap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import com.tieto.asap.Reporting;

public class Global {
	
	//Define all public static variables
	public static HashMap <String, String> Environment = new HashMap<String, String>();
	public static HashMap <String, String> Dictionary = new HashMap<String, String>();
	public static final Reporting Reporter = new Reporting();
	public static AndroidDriver androidDriver;
	public static IOSDriver iosDriver;
	public static WebDriver webDriver;
	public static boolean flgJenkinsHtml = false;
	//public static AndroidDriver androidDriver;
	

}
