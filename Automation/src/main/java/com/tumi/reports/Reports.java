package com.tumi.reports;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.UIFunctions;
import com.tumi.webPages.CartPage;
import com.tumi.webPages.CheckOutPage;
import com.tumi.webPages.CreateAccountPage;
import com.tumi.webPages.GiftServices;
import com.tumi.webPages.GooglePage;
import com.tumi.webPages.GuestBillingPage;
import com.tumi.webPages.HomePage;
import com.tumi.webPages.InstaPage;
import com.tumi.webPages.LoginPage;
import com.tumi.webPages.MiniCartPage;
import com.tumi.webPages.MultiShippingPage;
import com.tumi.webPages.MyAccountPage;
import com.tumi.webPages.MyProfile;
import com.tumi.webPages.OrderConfirmationPage;
import com.tumi.webPages.OrderReviewPage;
import com.tumi.webPages.PGP;
import com.tumi.webPages.PayPalPage;
import com.tumi.webPages.Personalization;
import com.tumi.webPages.ProductDetailPage;
import com.tumi.webPages.ShippingMethodPage;
import com.tumi.webPages.ShippingPage;
import com.tumi.webPages.SignInBillingPage;
import com.tumi.webPages.SignInShippingPage;
import com.tumi.webPages.SinglePageCheckout;
import com.tumi.webPages.TumiStudio;

/**
 * @author Suuresh clean test -Dsurefire.suiteXmlFiles=regressionTests.xml
 */
public class Reports {
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static WebDriver driver = null;
	String timeStamp;
	String extentReportPath;

	public static String OS = null;

	public static String browser = null;
	public static Properties prop = null;
	public static HomePage home = null;
	public static MiniCartPage minicart = null;
	public static ShippingPage shipping = null;
	public static ProductDetailPage pdp = null;
	public static SinglePageCheckout singlePage = null;
	public static GuestBillingPage guestBillPage = null;
	public static CartPage mainCart = null;
	public static ShippingMethodPage shipMethod = null;
	public static LoginPage login = null;
	public static OrderReviewPage review = null;
	public static MyAccountPage myacc = null;
	public static MyProfile profile = null;
	public static Personalization mono = null;
	public static GiftServices gift = null;
	public static PayPalPage paypal = null;
	public static TumiStudio tumiId = null;
	public static MultiShippingPage multiShip = null;
	public static CreateAccountPage register = null;
	public static CheckOutPage checkout = null;
	public static GooglePage google = null;
	public static InstaPage insta = null;
	public static SignInBillingPage signinBill = null;
	public static SignInShippingPage signinShip = null;
	public static OrderConfirmationPage confirmation = null;
	public static String selectedCountry = "US";
	public static String orderNumber = null;
	public static String browserName = null;
	public static String applicationUrl = null;
	public static PGP pgp = null;

	@BeforeSuite(alwaysRun = true)
	public void extentReportConfiguration() {
		timeStamp = new SimpleDateFormat("dd-MMM-yy  hh.mm.ss aa").format(Calendar.getInstance().getTime());
		extentReportPath = System.getProperty("user.dir") + "/ExtentReports/Screenshots/TumiReport.html";
		htmlreport = new ExtentHtmlReporter(extentReportPath);
		htmlreport.loadXMLConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
		report = new ExtentReports();
		report.attachReporter(htmlreport);
	}

	@AfterSuite(alwaysRun = true)
	public void endReport() {
		// writing everything to document
		// flush() - to write or update test information to your report.
		report.flush();
		try {
			GenericMethods.killSession();
		} catch (Exception e) {
			logger.log(Status.INFO, "Unable to Kill Browser Instance");
		}
	}

	@SuppressWarnings("deprecation")
	public static void launchMobile(String name) {

		/*
		 * Device Name: iPhone X,Galaxy S5 Pixel 2
		 */
		System.setProperty(GlobalConstants.chrome, getChromeDriverPath());

		Map<String, String> emu = new HashMap<String, String>();
		emu.put("deviceName", name);
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("mobileEmulation", emu);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		// Create object of HashMap Class
		Map<String, Object> prefs = new HashMap<String, Object>();
		// Set the notification setting it will override the default setting
		prefs.put("profile.default_content_setting_values.notifications", 2);

		ChromeOptions chromeOpt = new ChromeOptions();
		chromeOpt.setExperimentalOption("prefs", prefs);
		chromeOpt.addArguments("disable-infobars");
		chromeOpt.addArguments("--disable-notifications");
		chromeOpt.merge(capabilities);
		driver = new ChromeDriver(capabilities);
	}

	@BeforeMethod(alwaysRun = true)
	public static void initiateApplication() throws Exception {

		getBrowser(GlobalConstants.BROWSER);
		if (!browserName.equalsIgnoreCase("Remote")) {
			maximizeBrowser();
			if (browserName.equals("ie")) {
				GenericMethods.delay(2000);
				driver.navigate().to("javascript:document.getElementById('overridelink').click()");
				UIFunctions.WaitForJStoLoad();
				UIFunctions.verifyVPN();
				UIFunctions.closeSignUp();
			} else {
				getURL();
			}
		}
		UIFunctions.selectCountry();
		// driver.navigate().to("https://ca.stg-hybris-akamai.tumi.com");
	}

	@AfterMethod(alwaysRun = true)
	public static void closeBrowser() {

		if (browserName.equalsIgnoreCase("Remote")) {
			try {
				driver.quit();
			} catch (Exception e) {

			}
		} else {
			try {
				driver.close();
			} catch (Exception e) {

			}
		}

	}

	@BeforeMethod(alwaysRun = true)
	public static void initiatePageObjects(Method name) {
		// Create Extent Report
		logger = report.createTest(name.getName(), name.getDeclaringClass().getName());

		// Create Object of Each Page Class
		home = new HomePage(driver);
		minicart = new MiniCartPage(driver);
		shipping = new ShippingPage(driver);
		pdp = new ProductDetailPage(driver);
		singlePage = new SinglePageCheckout(driver);
		guestBillPage = new GuestBillingPage(driver);
		mainCart = new CartPage(driver);
		shipMethod = new ShippingMethodPage(driver);
		login = new LoginPage(driver);
		review = new OrderReviewPage(driver);
		myacc = new MyAccountPage(driver);
		profile = new MyProfile(driver);
		mono = new Personalization(driver);
		gift = new GiftServices(driver);
		paypal = new PayPalPage(driver);
		tumiId = new TumiStudio(driver);
		multiShip = new MultiShippingPage(driver);
		google = new GooglePage(driver);
		insta = new InstaPage(driver);
		register = new CreateAccountPage();
		checkout = new CheckOutPage();
		signinBill = new SignInBillingPage(driver);
		signinShip = new SignInShippingPage(driver);
		confirmation = new OrderConfirmationPage(driver);
		pgp = new PGP(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void verifyTestResult(ITestResult result) {

		try {
			if (result.getStatus() == ITestResult.FAILURE) {

				// Timestamp time = new Timestamp(System.currentTimeMillis());
				logger.fail(MarkupHelper.createLabel(result.getName() + " Test Case Failed", ExtentColor.RED));
				logger.fail(result.getThrowable());
				getScreen("./ExtentReports/Screenshots/" + result.getName() + ".png");
				String screenlocation = "./Screenshots/" + result.getName() + ".png";

				logger.fail("Screen Shot Reference:  ",
						MediaEntityBuilder.createScreenCaptureFromPath(screenlocation).build());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite(alwaysRun = true)
	public static void removeExistingFiles() {
		try {
			File files = new File(System.getProperty("user.dir") + "/ExtentReports/Screenshots/");
			for (File file : files.listFiles()) {
				if (!file.isDirectory()) {
					if (file.getName().contains("TumiReport.html")) {
						continue;
					}
					file.delete();
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@DataProvider(name = "Location")
	public static Object[][] credentials() {

		// The number of times data is repeated, test will be executed the same no. of
		// times

		// Here it will execute two times

		return new Object[][] { { "United States" }, { "Canada" }, { "Korea" } };

	}

	public static void enableLocalTesting() {

		try {
			File file = new File("C:\\suresh\\BrowserStack");

			Runtime.getRuntime().exec("c:\\windows\\system32\\cmd.exe /c BrowserStackLocal.bat", null, file);
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static void getBrowser(String browser) throws Exception {

		browserName = browser;

		System.out.println("Parameter " + browserName);

		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "BrowserStack");

		if (browserName.equalsIgnoreCase("Remote")) {

			enableLocalTesting();
			remoteAccess(testData.get("remoteBrowser"), testData.get("remoteBrowserVersion"), testData.get("remoteOS"),
					testData.get("remoteOsVersion"));
			getURL();

		} else {

			if (null == browserName || browserName.isEmpty() || browserName.equalsIgnoreCase("chrome")) {

				// Create object of HashMap Class
				Map<String, Object> prefs = new HashMap<String, Object>();
				// Set the notification setting it will override the default setting
				prefs.put("profile.default_content_setting_values.notifications", 2);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("disable-infobars");
				options.addArguments("--disable-notifications");
				options.addArguments("--disable-extensions");
				/*
				 * options.addArguments("--headless"); options.addArguments("--disable-gpu");
				 * options.addArguments("--no-sandbox");
				 */
				System.setProperty(GlobalConstants.chrome, getChromeDriverPath());
				driver = new ChromeDriver(options);

				// logger.log(Status.INFO, "Chrome Browser is initiated Execution");

			} else if (browserName.equalsIgnoreCase("firefox")) {

				FirefoxProfile geoDisabled = new FirefoxProfile();
				geoDisabled.setPreference("geo.enabled", false);
				geoDisabled.setPreference("geo.provider.use_corelocation", false);
				geoDisabled.setPreference("geo.prompt.testing", false);
				geoDisabled.setPreference("geo.prompt.testing.allow", false);
				DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
				System.setProperty(GlobalConstants.firefox, getFirefoxDriverPath());
				driver = new FirefoxDriver(capabilities);
				// logger.log(Status.INFO, "Firefox Browser is initiated Execution");

			} else if (browserName.equalsIgnoreCase("ie")) {

				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability("ignoreZoomSetting", true);
				capabilities.setCapability("nativeEvents", false);
				capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, GlobalConstants.S2);
				System.setProperty(GlobalConstants.ie, GlobalConstants.iePath);
				driver = new InternetExplorerDriver(capabilities);
				// logger.log(Status.INFO, "InternetExplorer Browser is initiated Execution");

			} else if (browserName.equalsIgnoreCase("mobile")) {

				launchMobile("iPhone X");
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static void remoteAccess(String remoteBrowser, String remoteBrowserVersion, String remoteOS,
			String remoteOsVersion) throws Exception {

		final String USERNAME = "kurrysuresh1";
		final String AUTOMATE_KEY = "zKp1VrRqTkUXqi4efALq";
		String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("browser", remoteBrowser);
		caps.setCapability("browser_version", remoteBrowserVersion);
		caps.setCapability("os", remoteOS);
		caps.setCapability("os_version", remoteOsVersion);
		caps.setCapability("browserstack.local", "true");
		caps.setCapability("browserstack.debug", "true");
		caps.setCapability("browserstack.networkLogs", "true");
		caps.setCapability("resolution", "1024x768");
		caps.setCapability("browserstack.selenium_version", "3.13.0");

		Map<String, Object> prefs1 = new HashMap<String, Object>();

		prefs1.put("profile.default_content_setting_values.notifications", 2);

		ChromeOptions options = new ChromeOptions();

		options.setExperimentalOption("prefs", prefs1);

		options.addArguments("disable-infobars");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-extensions");
		options.merge(caps);
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new RemoteWebDriver(new URL(URL), caps);
	}

	public static void maximizeBrowser() {
		if (!browserName.equalsIgnoreCase("Remote")) {
			driver.manage().window().maximize();
			GenericMethods.deleteAllCookies();
		}

		/*
		 * try { if (OSFinder.isWindows()) { driver.manage().window().maximize(); } else
		 * { driver.manage().window().setSize(new Dimension(1600, 900)); } } catch
		 * (Exception e) {
		 * 
		 * e.printStackTrace(); }
		 */}

	/**
	 * @param URL
	 */
	public static void getURL() {

		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "Environments");

		applicationUrl = System.getProperty("applicationUrl");

		System.out.println("Application Name " + applicationUrl);

		if (null == applicationUrl || applicationUrl.isEmpty()
				|| applicationUrl.toLowerCase().equalsIgnoreCase("stage2")) {

			if (!browserName.equals("ie")) {
				driver.get(testData.get("stage2"));
			}
		} else if (applicationUrl.toLowerCase().equalsIgnoreCase("stage3")) {

			if (!browserName.equals("ie")) {
				driver.get(testData.get("stage3"));
			}
		} else if (applicationUrl.toLowerCase().equalsIgnoreCase("prod")) {

			driver.get(testData.get("prod"));
			UIFunctions.verifyVPN();
			UIFunctions.closeSignUp();
			UIFunctions.countrySelection("United States");
		}
		UIFunctions.verifyVPN();
		UIFunctions.closeSignUp();
	}

	public static String getChromeDriverPath() {

		try {
			OS = System.getProperty("os.name");

			System.out.println("Current Operating System " + OS);

			if (OS.contains("Window")) {

				return GlobalConstants.chromeWinPath;

			} else if (OS.contains("linux")) {

				return GlobalConstants.chromeLinuxPath;
			} else {

				return GlobalConstants.chromeLinuxPath;
			}
		} catch (Exception e) {
			Assert.fail("Unable to get the Chrome File Path");
		}
		return OS;
	}

	public static String getFirefoxDriverPath() {

		try {
			OS = System.getProperty("os.name");
			if (OS.contains("Window")) {

				return GlobalConstants.firefoxWinPath;

			} else if (OS.contains("linux")) {

				return GlobalConstants.firefoxLinuxPath;
			} else {

				return GlobalConstants.firefoxLinuxPath;
			}
		} catch (Exception e) {
			Assert.fail("Unable to get the Firefox File Path");
		}
		return OS;
	}

	public static void getScreen(String path) {
		try {
			File destination = new File(path);
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, destination);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
