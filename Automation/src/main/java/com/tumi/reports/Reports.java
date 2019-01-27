package com.tumi.reports;

import java.io.File;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.OSFinder;
import com.tumi.utilities.TumiLibs;
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
import com.tumi.webPages.ShiipingPageForSignedIn;
import com.tumi.webPages.ShippingMethodPage;
import com.tumi.webPages.ShippingPage;
import com.tumi.webPages.SignInBillingPage;
import com.tumi.webPages.SinglePageCheckout;
import com.tumi.webPages.TumiStudio;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Suuresh
 *
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
	public static ShiipingPageForSignedIn signinShip = null;
	public static OrderConfirmationPage confirmation = null;
	public static String selectedCountry = "test";
	public static String orderNumber = null;

	@BeforeTest(alwaysRun = true)
	public void startReport(ITestContext ctx) {
		timeStamp = new SimpleDateFormat("dd-MMM-yy  hh.mm.ss aa").format(Calendar.getInstance().getTime());
		// String suiteName = ctx.getCurrentXmlTest().getSuite().getName();
		extentReportPath = System.getProperty("user.dir") + "/ExtentReports/TumiReport.html";
		htmlreport = new ExtentHtmlReporter(extentReportPath);
		htmlreport.loadXMLConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
		report = new ExtentReports();
		report.attachReporter(htmlreport);
	}

	@AfterTest(alwaysRun = true)
	public void endReport() {
		// writing everything to document
		// flush() - to write or update test information to your report.
		report.flush();
	}

	// @BeforeClass(alwaysRun = true)
	public static void launchBrowser() throws Exception {
		getBrowser(GenericMethods.getProperty("tumi.browserName"));
		maximizeBrowser();
		getURL(GenericMethods.getProperty("tumi.appName"));

		// driver.navigate().to("https://ca.stg-hybris-akamai.tumi.com");
	}

	//@AfterClass(alwaysRun = true)
	public static void closeBrowser() {
		driver.close();
		try {
			GenericMethods.killSession();
		} catch (Exception e) {
			logger.log(Status.INFO, "Unable to Kill Browser Instance");
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
		signinShip = new ShiipingPageForSignedIn(driver);
		confirmation = new OrderConfirmationPage(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void verifyTestResult(ITestResult result) {

		try {
			if (result.getStatus() == ITestResult.SUCCESS) {

				logger.log(Status.PASS, "Test Method : " + result.getName() + "is Passed");

			} else if (result.getStatus() == ITestResult.FAILURE) {

				Timestamp time = new Timestamp(System.currentTimeMillis());
				String screenlocation = System.getProperty("user.dir") +"/Screenshots/" + result.getName() + ""
						+ time.getTime() + ".png";
				getScreen(System.getProperty("user.dir") + "/ExtentReports/Screenshots/" + result.getName() + ""
						+ time.getTime() + ".png");
				logger.fail(MarkupHelper.createLabel(result.getName() + " Test Case Failed", ExtentColor.RED));
				logger.fail(result.getThrowable());
				logger.fail("Screen Shot Reference:  ",
						MediaEntityBuilder.createScreenCaptureFromPath(screenlocation).build());

			} else if (result.getStatus() == ITestResult.SKIP) {

				logger.log(Status.SKIP, "Test Method : " + result.getName() + "is Skipped");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite(alwaysRun = true)
	public static void removeExistingFiles() {
		try {
			File files = new File(System.getProperty("user.dir")+"/ExtentReports/Screenshots/");
			for (File file : files.listFiles()) {
				if (!file.isDirectory()) {
					file.delete();
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void getBrowser(String browserName) throws Exception {
		browser = browserName;

		if (browserName.equalsIgnoreCase("firefox")) {

			System.setProperty(GlobalConstants.firefox, GlobalConstants.firefoxPath);
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("disable-infobars");
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			// logger.log(Status.INFO, "Chrome has been successfully Launched");
		} else if (browserName.equalsIgnoreCase("ie")) {
			System.setProperty(GlobalConstants.ie, GlobalConstants.iePath);
			driver = new InternetExplorerDriver();
		} else {
			Assert.fail("No Browser has been selected");
		}
	}

	public static void maximizeBrowser() {
		if (OSFinder.isWindows()) {
			driver.manage().window().maximize();
		} else {
			driver.manage().window().setSize(new Dimension(1600, 900));
		}
	}

	/**
	 * @param URL
	 */
	public static void getURL(String URL) {

		if (URL.equalsIgnoreCase("stage2")) {

			driver.get(GlobalConstants.url);

		} else if (URL.equalsIgnoreCase("")) {
			driver.get("");
			logger.log(Status.INFO, "Successfully Navigated to " + URL + " Environment");
		}
		TumiLibs.verifyVPN();
		TumiLibs.closeSignUp();
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
