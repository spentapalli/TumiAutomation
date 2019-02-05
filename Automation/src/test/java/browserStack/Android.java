package browserStack;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class Android extends GenericMethods {

	public static final String USERNAME = "suresh699";
	public static final String AUTOMATE_KEY = "kBYKj5mv1pcJQhmE5dCL";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static WebDriver driver;

	// public static WebDriver driver;
	// public static Map<String, String> testData =
	// ReadTestData.retrieveData("PlaceOrder", "OrderWithVochercode");

	@Test
	public void localAndriod() throws Exception {

		DesiredCapabilities caps = new DesiredCapabilities();

		caps.setCapability("geo.enabled", "false");
		caps.setCapability("os_version", "6.0");
		caps.setCapability("device", "Samsung Galaxy S7");
		caps.setCapability("browser", "chrome");
		caps.setCapability("autoGrantPermissions", "true");
		caps.setCapability("locationServicesAuthorized", "true");
		caps.setCapability("autoAcceptAlerts", "true");

		caps.setCapability("realMobile", "true");
		caps.setCapability("browserstack.debug", "true");
		// caps.setCapability("browserstack.safari.enablePopups", "true");
		caps.setCapability("browserstack.video", "true");
		caps.setCapability("browserstack.console", "warnings");
		caps.setCapability("browserstack.local", "true");

		caps.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
		caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);

		ChromeOptions options = new ChromeOptions();

		options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.addArguments("disable-infobars");
		options.addArguments("start-maximized");
		options.addArguments("test-type");
		options.addArguments("enable-strict-powerful-feature-restrictions");
		options.addArguments("disable-geolocation");

		options.merge(caps);

		String pdpURL = "https://www.hybris-stage2.tumi.com/p/013234CPT";

		driver = new RemoteWebDriver(new URL(URL), options);

		driver.get(pdpURL);

		click(driver.findElement(By.xpath("//button[@id='addToCartBtn']")));

		click(driver.findElement(By.xpath("//span[@id='cart_content']")));

		click(driver.findElement(By.xpath("//button[contains(text(),'Proceed to Checkout')]")));

		input(driver.findElement(By.xpath("(//input[@name='email'])[1]")), "skomma@coredatalabs.com");
		UIFunctions.waitForContinueToEnable();
		click(driver.findElement(By.xpath("//button[contains(text(),'Continue as a Guest')]")));
		UIFunctions.addGuestDetails();
		click(driver.findElement(By.xpath("//button[contains(text(), 'Continue to Shipping Method')]")));
		click(driver.findElement(By.xpath("//button[contains(text(), 'Proceed to Payment')]")));
		UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
		UIFunctions.completeOrder();

		// TumiLibs.addProductToCart("PlaceOrder", "OrderWithGiftServices");
		/*
		 * domClick(pdp.getAddToCart(), "Add To Cart");
		 * click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		 * TumiLibs.addPromotionalCode("PlaceOrder", "PreOrderWithVoucher");
		 * TumiLibs.completeOrder("PlaceOrder", "OrderWithGiftServices");
		 * 
		 * 
		 */
		driver.quit();

	}

	private void input(WebElement ele, String string) {

		ele.clear();
		ele.sendKeys(string);

	}

	public static void jsClick(WebElement ele) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			Thread.sleep(10000);
		} catch (InterruptedException e) {

		}
	}

	public void click(WebElement ele) {

		ele.click();
		WaitForJStoLoad();

	}

	public static boolean WaitForJStoLoad() {
		boolean jsLoad = false;
		try {
			for (int i = 0; i < 180; i++) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				jsLoad = (Boolean) executor.executeScript("return jQuery.active == 0");
				Thread.sleep(1000);
				if (jsLoad)
					break;
			}
			if (!jsLoad) {
				// logger.log(Status.FAIL, "Page load Incomplete");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsLoad;
	}

	/*
	 * public static void jsClick(WebElement ele) { try { JavascriptExecutor
	 * executor = (JavascriptExecutor) driver;
	 * executor.executeScript("arguments[0].click();", ele); Thread.sleep(10000); }
	 * catch (InterruptedException e) {
	 * 
	 * } }
	 */
}
