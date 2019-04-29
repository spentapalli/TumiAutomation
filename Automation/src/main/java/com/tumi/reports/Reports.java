package com.tumi.reports;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.Base64;
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
import com.tumi.webPages.ComparePage;
import com.tumi.webPages.CreateAccountPage;
//import com.tumi.webPages.TumiTracerPage;
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
import com.tumi.webPages.PDPage;
import com.tumi.webPages.ShippingMethodPage;
import com.tumi.webPages.ShippingPage;
import com.tumi.webPages.SignInBillingPage;
import com.tumi.webPages.SignInShippingPage;
import com.tumi.webPages.SinglePageCheckout;
import com.tumi.webPages.TumiStudio;
import com.tumi.webPages.TumiTracerPage;

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
	public static PDPage pdp = null;
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
	public static ComparePage compare = null;
	public static TumiTracerPage tracer = null;

	@BeforeSuite(alwaysRun = true)
	public void extentReportConfiguration() {

		// exeBrowserStack();
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
		if (!browserName.equalsIgnoreCase("Remote") && !browserName.equals("iphone")) {
			maximizeBrowser();
			if (browserName.equals("ie")) {
				GenericMethods.delay(2000);
				driver.navigate().to("javascript:document.getElementById('overridelink').click()");
				UIFunctions.WaitForJStoLoad();
				UIFunctions.verifyVPN();
				UIFunctions.closeSignUp();
			} else {
				getURL(GlobalConstants.URL);

			}
		}
		UIFunctions.selectCountry();
	}

	@AfterMethod(alwaysRun = true)
	public static void closeBrowser() {

		if (browserName.equals("Remote")) {
			driver.quit();
		} else {
			driver.close();
		}
	}

	@BeforeMethod(alwaysRun = true)
	public static void initiatePageObjects(Method name) {
		// Create Extent Report
		logger = report.createTest(name.getName(), name.getDeclaringClass().getName());

		System.out.println(
				"Test Case Name " + name.getName() + " And Declaration Name " + name.getDeclaringClass().getName());

		// Create Object of Each Page Class
		home = new HomePage(driver);
		minicart = new MiniCartPage(driver);
		shipping = new ShippingPage(driver);
		pdp = new PDPage(driver);
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
		compare = new ComparePage(driver);
		tracer = new TumiTracerPage(driver);
		/*
		 * if (driver.getCurrentUrl().contains("akamai")) {
		 * GenericMethods.click(home.getAkamaiSelectCountry(), "Country");
		 * GenericMethods.click(home.getAkamaiSelectUS(), "US");
		 * UIFunctions.delay(2000); UIFunctions.closeSignUp(); }
		 */
	}

	@AfterMethod(alwaysRun = true)
	public void verifyTestResult(ITestResult result) {

		try {
			if (result.getStatus() == ITestResult.FAILURE) {

				// Timestamp time = new Timestamp(System.currentTimeMillis());
				logger.fail(MarkupHelper.createLabel(result.getName() + " Test Case Failed", ExtentColor.RED));
				logger.fail(result.getThrowable());
				getScreen(System.getProperty("user.dir")+"/ExtentReports/Screenshots/" +
				result.getName() + ".png");
				String screenlocation = System.getProperty("user.dir")+"/ExtentReports/Screenshots/" +
						result.getName() + ".png";

				logger.fail("Screen Shot Reference:  ",
						MediaEntityBuilder.createScreenCaptureFromPath(screenlocation).build());
			}
		} catch (Exception e) {
			//logger.log(Status.FAIL, "Faile to due to below error");
			//Assert.fail(e.getMessage());
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
		if (browserName.equalsIgnoreCase("iphone")) {
			iphone();
			getIphoneURL();
		} else if (browserName.equalsIgnoreCase("Remote")) {
			remoteAccess();
			// sauceConnect();
			getURL(GlobalConstants.URL);
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
				options.addArguments("--disable-browser-side-navigation");
				// options.addArguments("--disable-gpu");

				System.setProperty(GlobalConstants.chrome, getChromeDriverPath());
				driver = new ChromeDriver(options);
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

	public static String localTesting() {

		String local = System.getProperty("localTesting");
		if (local == null || local.isEmpty()) {

			return "false";
		} else {

			return local;
		}

	}

	public static void remoteAccess() throws Exception {

		final String USERNAME = "kurrysuresh1";
		final String AUTOMATE_KEY = "zKp1VrRqTkUXqi4efALq";
		String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("browser", "Safari");
		caps.setCapability("browser_version", "12.0");
		caps.setCapability("os", "OS X");
		caps.setCapability("os_version", "Mojave");
		caps.setCapability("resolution", "1024x768");
		caps.setCapability("browserstack.local", localTesting());
		caps.setCapability("browserstack.debug", "true");
		caps.setCapability("browserstack.networkLogs", "false");

		caps.setCapability("browserstack.geoLocation", "US");
		caps.setCapability("browserstack.hosts", "23.200.116.157,www.stg-hybris-akamai.tumi.com");
		driver = new RemoteWebDriver(new URL(URL), caps);
	}


		Map<String, Object> prefs1 = new HashMap<String, Object>();


	public static void iphone() throws Exception {

		final String USERNAME = "kurrysuresh1";
		final String AUTOMATE_KEY = "zKp1VrRqTkUXqi4efALq";
		String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("browserName", "iPhone");
		caps.setCapability("device", "iPhone XS");
		caps.setCapability("realMobile", "true");
		caps.setCapability("os_version", "12");

		caps.setCapability("browserstack.local", localTesting());
		caps.setCapability("browserstack.debug", "true");
		caps.setCapability("browserstack.networkLogs", "false");
		caps.setCapability("browserstack.geoLocation", "US");
		// caps.setCapability("browserstack.hosts",
		// "23.200.116.157,www.stg-hybris-akamai.tumi.com");
		driver = new RemoteWebDriver(new URL(URL), caps);
	}

	public static void sauceConnect() {

		final String USERNAME = "skurry189";
		final String ACCESS_KEY = "297e9a77-83f5-4acf-afa3-04c19a7d08b8";
		final String URL = "http://ondemand.saucelabs.com:80/wd/hub";

		DesiredCapabilities caps = new DesiredCapabilities().safari();

		// set your user name and access key to run tests in Sauce
		caps.setCapability("username", USERNAME);

		// set your sauce labs access key
		caps.setCapability("accessKey", ACCESS_KEY);

		caps.setCapability("platform", "macOS 10.14");
		caps.setCapability("version", "12.0");
		caps.setCapability("recordVideo", "false");
		caps.setCapability("recordScreenshots", "false");
		/*
		 * // set browser to Safari capabilities.setCapability("browserName", "Safari");
		 * 
		 * // set operating system to macOS version 10.13
		 * capabilities.setCapability("platform", "macOS 10.13");
		 * 
		 * // set the browser version to 11.1 capabilities.setCapability("version",
		 * "11.1");
		 */

		try {
			driver = new RemoteWebDriver(new URL(URL), caps);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public static void getURL(String url) {

		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "Environments");

		applicationUrl = url;

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
		} else if (applicationUrl.toLowerCase().equalsIgnoreCase("akamais2")) {

			if (!browserName.equals("ie")) {
				driver.get(testData.get("akamaiS2"));

			}
		} else if (applicationUrl.toLowerCase().equalsIgnoreCase("prod")) {

			driver.get(testData.get("prod"));
			if(browserName.equals("iphone")) {
				GenericMethods.acceptAlert();
			}
			
			UIFunctions.verifyVPN();
			UIFunctions.closeSignUp();
			// UIFunctions.countrySelection("United States");
		}
		UIFunctions.verifyVPN();
		UIFunctions.closeSignUp();
	}
	
	public static void getIphoneURL() {

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
		} else if (applicationUrl.toLowerCase().equalsIgnoreCase("akamais2")) {

			if (!browserName.equals("ie")) {
				driver.get(testData.get("akamaiS2"));

			}
		} else if (applicationUrl.toLowerCase().equalsIgnoreCase("prod")) {

			driver.get(testData.get("prod"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			GenericMethods.acceptAlert();
			//UIFunctions.verifyVPN();
			//UIFunctions.closeSignUp();
			// UIFunctions.countrySelection("United States");
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

	public static String getBase64Screen() {
		Date oDate = new Date();
		SimpleDateFormat oSDF = new SimpleDateFormat("yyyyMMddHHmmss");
		String sDate = oSDF.format(oDate);
		String encodedBase64 = null;
		FileInputStream fileInputStream = null;
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ExtentReports\\Screenshots\\" + "Screenshot_" + sDate
				+ ".png";
		File finalDestination = new File(destination);
		try {
			FileHandler.copy(source, finalDestination);
		} catch (Exception e1) {
		}

		try {
			fileInputStream = new FileInputStream(finalDestination);
			byte[] bytes = new byte[(int) finalDestination.length()];
			fileInputStream.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "data:image/png;base64," + encodedBase64;
	}

	public static void exeBrowserStack() {

		try {
			Process p = Runtime.getRuntime().exec("cmd /c start C:\\suresh\\BrowserStack\\BrowserStackLocal.bat");
			/*
			 * InputStream in = p.getInputStream(); int c; while ((c = in.read()) != -1) {
			 * System.out.print(c); } in.close(); p.waitFor(); System.out.println("done");
			 */
			Thread.sleep(5000);
		} catch (Exception e) {
		}
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
