package com.tumi.reports;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
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

	@BeforeSuite(alwaysRun = true)
	public void startReport() {
		timeStamp = new SimpleDateFormat("dd-MMM-yy  hh.mm.ss aa").format(Calendar.getInstance().getTime());
		extentReportPath = System.getProperty("user.dir") + "/ExtentReports/TumiReport.html";
		htmlreport = new ExtentHtmlReporter(extentReportPath);
		htmlreport.loadXMLConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
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
		System.setProperty(GlobalConstants.chrome, GlobalConstants.chromePath);

		Map<String, String> emu = new HashMap<String, String>();
		emu.put("deviceName", name);
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("mobileEmulation", emu);
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		ChromeOptions chromeOpt = new ChromeOptions();
		chromeOpt.addArguments("disable-infobars");
		chromeOpt.addArguments("--disable-notifications");
		chromeOpt.merge(capabilities);
		driver = new ChromeDriver(capabilities);
	}

	@BeforeClass(alwaysRun = true)
	public static void launchBrowser() throws Exception {
		getBrowser();
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

		UIFunctions.selectCountry();
		// driver.navigate().to("https://ca.stg-hybris-akamai.tumi.com");
	}

	@AfterClass(alwaysRun = true)
	public static void closeBrowser() {
		driver.close();
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
	}

	@AfterMethod(alwaysRun = true)
	public void verifyTestResult(ITestResult result) {

		try {
			if (result.getStatus() == ITestResult.FAILURE) {

				// Timestamp time = new Timestamp(System.currentTimeMillis());
				logger.fail(MarkupHelper.createLabel(result.getName() + " Test Case Failed", ExtentColor.RED));
				logger.fail(result.getThrowable());
				getScreen("./ExtentReports/Screenshots/" + result.getName() + ".png");
				String screenlocation = System.getProperty("user.dir")+"/Screenshots/" + result.getName() + ".png";
				
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

	@SuppressWarnings("deprecation")
	public static void getBrowser() throws Exception {

		// logger = report.createTest("Browser Name");

		browserName = System.getProperty("browsername");

		System.out.println("Parameter " + browserName);

		if (null == browserName || browserName.isEmpty() || browserName.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--disable-notifications");
			System.setProperty(GlobalConstants.chrome, GlobalConstants.chromePath);
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
			System.setProperty(GlobalConstants.firefox, GlobalConstants.firefoxPath);
			driver = new FirefoxDriver(capabilities);
			// logger.log(Status.INFO, "Firefox Browser is initiated Execution");

		} else if (browserName.equalsIgnoreCase("ie")) {

			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability("nativeEvents", false);
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, GlobalConstants.url);
			System.setProperty(GlobalConstants.ie, GlobalConstants.iePath);
			driver = new InternetExplorerDriver(capabilities);
			// logger.log(Status.INFO, "InternetExplorer Browser is initiated Execution");

		} else if (browserName.equalsIgnoreCase("mobile")) {

			launchMobile("iPhone X");
		}
	}

	public static void maximizeBrowser() {
		driver.manage().window().maximize();
		GenericMethods.deleteAllCookies();
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

		String url = System.getProperty("applicationUrl");

		System.out.println("Application Name " + url);

		if (null == url || url.isEmpty() || url.toLowerCase().equalsIgnoreCase("stage2")) {

			if (!browserName.equals("ie")) {
				driver.get(GlobalConstants.url);
			}
		} else if (url.toLowerCase().equalsIgnoreCase("akamai")) {

			if (!browserName.equals("ie")) {
				driver.get(GlobalConstants.akamaiUrl);
			}
		}
		UIFunctions.verifyVPN();
		UIFunctions.closeSignUp();
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
