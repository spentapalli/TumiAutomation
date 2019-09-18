package com.tumi.utilities;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.tumi.reports.Reports;

/**
 * @author Suuresh
 *
 */
public class GlobalConstants extends Reports {
	


	public static final String countryName = "US";
	// initiating driver

	// Stage akamai Canada
	// public static String url = "https://ca.stg-hybris-akamai.tumi.com";

	// Stage Akamai US
	public static String akamaiUrl = "https://www.stg-hybris-akamai.tumi.com/";
	// https://www.stg-hybris-akamai.tumi.com/p/continental-expandable-2-wheeled-carry-on-022021CHYA/

	// Stage2 US
	public static String S2 = "https://www.hybris-stage2.tumi.com/";

	// Stage3 US
	public static String S3 = "https://www.hybris-stage3.tumi.com/";

	// Satge2 Korea
	public static String urlkr = "https://kr.hybris-stage2.tumi.com/";

	// Stage2 Canada
	public static String urlca = "https://ca.hybris-stage2.tumi.com/";

	// Production
	public static String prodUrl = "https://www.tumi.com";
	
	//Stage4
	public static String stage4 = "https://www.hybris-stage4.tumi.com/";

	// production Canada
	// public static String url = "https://ca.tumi.com";

	// production Korea
	// public static String url = "https://kr.tumi.com";

	// dev US
	// public static String url = "https://eom-tumi.com:9002/";

	public static final String BROWSER = retrieveBrowser();
	public static final String URL = retrieveURL();

	// Drivers Path
	public static String chromeWinPath = System.getProperty("user.dir")
			+ "/BrowserDrivers/ChromeDriverWin/chromedriver.exe";
	public static String chromeLinuxPath = System.getProperty("user.dir") + "/BrowserDrivers//ChromeLinux/chromedriver";
	public static String chromeMacPath = System.getProperty("user.dir") + "/BrowserDrivers/ChromeDriverMac/chromedriver";
	public static String firefoxWinPath = System.getProperty("user.dir") + "/BrowserDrivers/FirefoxWin/geckodriver.exe";
	public static String firefoxLinuxPath = System.getProperty("user.dir") + "/BrowserDrivers/FirefoxLinux/geckodriver";

	public static String iePath = System.getProperty("user.dir")
			+ "/BrowserDrivers/IEDriverServer64/IEDriverServer.exe";

	// Driver System Set Property Syntax
	public static String chrome = "webdriver.chrome.driver";
	public static String firefox = "webdriver.gecko.driver";
	public static String ie = "webdriver.ie.driver";

	public static String excelPath = System.getProperty("user.dir") + "/TestData/Tumi.xlsx";
	public static String propertiesPath = System.getProperty("user.dir") + "/Validations/FlagMessages.properties";

	private static String retrieveBrowser() {

		String browser = System.getProperty("browsername");
		return browser;
	}

	private static String retrieveURL() {

		String url = System.getProperty("applicationUrl");
		return url;
	}

}
