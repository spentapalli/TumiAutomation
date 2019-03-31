package com.tumi.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;

/**
 * @author Suuresh
 *
 */
public class GenericMethods extends GlobalConstants {

	public static Actions action;

	public static void captureOrderConfScreen(String name) {

		// long time = ZonedDateTime.now().toInstant().toEpochMilli();
		getScreen("./ExtentReports/ScreenShots/" + name + ".png");
		String location = "./ScreenShots/" + name + ".png";
		try {
			logger.info("Reference", MediaEntityBuilder.createScreenCaptureFromPath(location).build());
		} catch (Exception e) {
			Assert.fail("Fail to Capture Screen " + e.getMessage());
		}
	}

	public void removeCards() {
		try {
			click(myacc.getMyProfile(), "View Your Profile");
			click(myacc.getMyPayments(), "Payment/Gift Card");
			if (myacc.getAvailableCards().size() > 1) {
				for (WebElement ele : myacc.getAvailableCards()) {
					click(myacc.getRemoveCards(), "Remove Card");
					delay(5000);
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void login(String sheetName, String testCaseName) {
		try {
			Map<String, String> testData = ReadTestData.getJsonData(sheetName, testCaseName);

			click(home.getHeaderSignIn(), "Sign In");
			input(home.getUserName(), testData.get("EmailID"), "Email Address");
			input(home.getPassWord(), testData.get("Password"), "Password");
			click(home.getLogOn(), "Login");

			if (myacc.getSignout().isDisplayed()) {
				logger.log(Status.INFO, "Successfully logged with Regular user valid credentials");

			} else {
				Assert.fail("user signin is failed");
			}
			click(myacc.getMyAccountClose(),"Close My Account");
		} catch (Exception e) {
			Assert.fail("Fail to Login due to " + e.getMessage());
		}
		// removeExistingCart();
	}

	public static void click(WebElement element, String buttonName) {

		try {
			if (element.isDisplayed()) {
				// Clicking on WebElement
				element.click();
				logger.log(Status.INFO, "Clicked on " + buttonName);
				WaitForJStoLoad();
			} else {
				logger.log(Status.FAIL, "Button is not enabled " + buttonName);
				Assert.fail(buttonName + " " + "is not Enabled or Unable to interact at this point");
			}
		} catch (Exception e) {
			Assert.fail(buttonName + " " + "is not Enabled or Unable to interact at this point");
		}
		// captureScreen(buttonName);
	}

	public static void webclick(WebElement element, String buttonName) {
		try {
			if (element.isDisplayed()) {
				element.click();
				logger.log(Status.INFO, "Clicked on " + buttonName);
			}
		} catch (Exception e) {
			Assert.fail(buttonName + " " + "is not Enabled or Unable to interact at this point");
		}

	}

	public static void input(WebElement element, String Value, String fieldName) {
		try {
			if (element.isDisplayed()) {
				// To clear the existed value
				element.clear();
				// To enter current value
				element.sendKeys(Value);
				logger.log(Status.INFO, "Entered the value in " + fieldName + " as: " + Value);
				// WaitForJStoLoad();
			} else {

				Assert.fail("Fail to Enter Value in  " + fieldName);
			}
		} catch (Exception e) {
			Assert.fail("Fail to Enter Value in  " + fieldName + e.getMessage());
		}

	}

	public static String getText(WebElement element) {
		String text = null;
		try {
			if (element.isDisplayed()) {
				text = element.getText().trim();
			} else {
				// Assert.fail("Unable to Fetch text from" +element);
			}
		} catch (Exception e) {
			// Assert.fail("Unable to Fetch text from" + element + "due to
			// "+e.getMessage());
		}
		return text;
	}

	public static String getInnerText(WebElement element) {
		String text = null;
		try {
			if (element.isDisplayed()) {
				text = element.getAttribute("innerHTML").trim();
			} else {
				Assert.fail("Unable to Fetch text from" + element);
			}
		} catch (Exception e) {
			Assert.fail("Unable to Fetch innerHTML " + e.getMessage());
		}
		return text;
	}

	public static String getAttributeValue(WebElement element) {
		String text = null;
		try {
			if (element.isDisplayed()) {
				text = element.getAttribute("value").trim();
			} else {
				Assert.fail("Unable to Fetch text from" + element);
			}
		} catch (Exception e) {
			Assert.fail("Unable to Fetch value " + e.getMessage());
		}
		return text;
	}

	public static WebElement explicitWait(WebElement element) {
		try {
			// WebDriverWait Initialization
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.getMessage();
		}
		return element;
	}

	public static WebElement elementToBeClickable(WebElement element) {
		try {
			// WebDriverWait Initialization
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.getMessage();
		}
		return element;
	}

	public static void selectByVisibleText(WebElement ele, String testData, String fieldName) {
		try {
			new Select(ele).selectByVisibleText(testData);
			logger.log(Status.INFO, "Selected " + testData + " from " + fieldName);
		} catch (Exception e) {
			Assert.fail("Fail to Select " + testData + " from " + fieldName + "Error " + e.getMessage());
		}
	}

	public static void selectByValue(WebElement ele, String testData, String fieldName) {
		try {
			new Select(ele).selectByValue(testData);
			logger.log(Status.INFO, "Selected " + testData + " from " + fieldName);
		} catch (Exception e) {
			Assert.fail("Fail to Select " + testData + " from " + fieldName + "Error " + e.getMessage());
		}
	}

	public static void selectByIndex(WebElement ele, int testData, String fieldName) {
		try {
			new Select(ele).selectByIndex(testData);
			logger.log(Status.INFO, "Selected " + testData + " from " + fieldName);
		} catch (Exception e) {
			Assert.fail("Fail to Select " + testData + " from " + fieldName + "Error " + e.getMessage());
		}
	}

	public static void domClick(WebElement element, String fieldName) {

		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			logger.log(Status.INFO, "Successfully Clicked on " + fieldName);
			WaitForJStoLoad();
		} catch (Exception e) {
			Assert.fail("Failed to Click on " + fieldName + "Error " + e.getMessage());
		}
	}

	public static void jsClick(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
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
				logger.log(Status.INFO, "Page load Incomplete");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsLoad;

	}

	public static boolean switchToFrame(String frameType, int index, String nameOrId, WebElement frameElement) {
		boolean isFrameSwitched = false;
		try {
			switch (frameType.toLowerCase()) {
			case "index":
				driver.switchTo().frame(index);
				isFrameSwitched = true;
				break;
			case "nameorid":
				driver.switchTo().frame(nameOrId);
				isFrameSwitched = true;
				break;
			case "frameelement":
				driver.switchTo().frame(frameElement);
				isFrameSwitched = true;
				break;
			default:
				logger.log(Status.FAIL, "Please give proper 'input' to Switch to Frame");
			}
		} catch (Exception e) {
			Assert.fail("Swith to Frame is Failed due to " + e.getMessage());
		}
		return isFrameSwitched;
	}

	public static boolean defaultContent() {
		boolean isDefaultContent = false;
		try {
			driver.switchTo().defaultContent();
			WaitForJStoLoad();
			isDefaultContent = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDefaultContent;
	}

	public String getPageTitle() {
		String strWebPageTitle = null;
		try {
			strWebPageTitle = driver.getTitle().trim();
			logger.log(Status.INFO, "Page Title : " + strWebPageTitle);
		} catch (Exception e) {
			Assert.fail("Unable to Fetch Page Title");
		}
		return strWebPageTitle;
	}

	public static void scrollDown(int num) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + num + ")", "");
		WaitForJStoLoad();
	}

	public static void scrollUp() {
		delay(2000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,0)", "");
		WaitForJStoLoad();
	}

	public void scrollToWebElement(WebElement ele) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView(true);", ele);
			WaitForJStoLoad();
		} catch (Exception e) {
			Assert.fail("Unable to Scroll " + e.getMessage());
		}
	}

	public String toolTip(WebElement ele) {
		try {
			action = new Actions(driver);
			action.moveToElement(ele).perform();
		} catch (Exception e) {
			Assert.fail("Fail to Fetch Tool Tip " + e.getMessage());
		}
		return getText(ele);
	}

	public static void mouseHover(WebElement ele) {
		try {
			action = new Actions(driver);
			action.moveToElement(ele).build().perform();
		} catch (Exception e) {
			Assert.fail("Fail to MouseHover " + e.getMessage());
		}
	}

	public static String getProperty(String propertyName) {
		prop = new Properties();
		try {
			String propPath = propertiesPath;
			File file = new File(propPath);
			FileInputStream fin = new FileInputStream(file);
			prop.load(fin);

		} catch (Exception e) {
			Assert.fail("Unable to Load Properties " + e.getMessage());
		}
		return prop.getProperty(propertyName);
	}

	public static void killSession() {
		try {

			if (null == browserName.toUpperCase() || browserName.toUpperCase().isEmpty()
					|| browserName.toUpperCase().equals("CHROME")) {
				try {
					Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
				} catch (Exception e) {
					Runtime.getRuntime().exec("pkill chrome");
					Runtime.getRuntime().exec("pkill chromedriver");
				}
			} else if (browserName.toUpperCase().equals("FIREFOX")) {
				try {
					Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
				} catch (Exception e) {
					Runtime.getRuntime().exec("pkill firefox");
					Runtime.getRuntime().exec("pkill geckodriver");
				}
			} else if (browserName.toUpperCase().equals("IE")) {
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
			}
		} catch (Exception e) {
			Assert.fail("Unable to Kill the Session");
		}
	}

	public static void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			logger.log(Status.FAIL, "No Alert Present in this window");
		}
	}

	public static void verifyAssertEquals(String actual, String expected) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (Exception e) {
			logger.log(Status.FAIL, e.getMessage());
		}
	}

	public static void verifyAssertInt(int actual, int expected) {
		try {
			Assert.assertEquals(actual, expected);
		} catch (Exception e) {
			logger.log(Status.FAIL, e.getMessage());
		}
	}

	public static void verifyAssertContains(String actual, String text, String errorMsg) {
		try {
			Assert.assertTrue(actual.contains(text), errorMsg);
		} catch (Exception e) {
			logger.log(Status.FAIL, e.getMessage());
		}
	}

	public static void executeAutoITFile(String path) {
		try {
			Runtime.getRuntime().exec(path);
		} catch (Exception e) {
			Assert.fail("Fail to Execute .exe file " + e.getMessage());
		}
	}

	public static String getFirstSelectedOption(WebElement ele) {
		String option = null;
		try {
			option = new Select(ele).getFirstSelectedOption().getText();
		} catch (Exception e) {
			Assert.fail("Unable to Fetch First Selected Option due to " + e.getMessage());
		}
		return option;
	}

	public static void keyEnter(WebElement ele) {
		ele.sendKeys(Keys.ENTER);
		WaitForJStoLoad();
	}

	public static void keyTab(WebElement ele) {
		ele.sendKeys(Keys.TAB);
	}

	/**
	 * Desc : Provide a Delay while the Browser is loaded.
	 * 
	 * @param time
	 */
	public static void waitForLoad(int time) {
		boolean status = false;
		Calendar startTime = Calendar.getInstance();
		Calendar endTime = Calendar.getInstance();
		long timeTaken;
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver input) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, time);
		do {

			try {
				wait.until(pageLoadCondition);
				if (wait.until(pageLoadCondition) == true) {
					status = true;
				} else {
					status = false;
				}
			} catch (NoSuchElementException e) {
				status = false;
			}
			endTime = Calendar.getInstance();
			timeTaken = (endTime.getTimeInMillis() - startTime.getTimeInMillis()) / 1000;
			if (timeTaken > time) {
				timeTaken = timeTaken - time;
				startTime = Calendar.getInstance();
			}
		} while (status == false && timeTaken <= time);
	}

	/**
	 * Desc :Provide a Delay till the page Javascript is loaded.
	 * 
	 * @param locater
	 * @param timeOut
	 * @return
	 * @throws InterruptedException
	 */
	public static long waitForJavaScriptLoad(WebElement locater, int timeOut) throws InterruptedException {
		boolean status = false;
		Calendar startTime = Calendar.getInstance();
		Calendar endTime = Calendar.getInstance();
		long timeTaken;
		do {
			try {
				if (locater.getText().equals("")) {
					status = true;
				} else {
					status = false;
				}
			} catch (NoSuchElementException e) {
				status = false;
			}
			endTime = Calendar.getInstance();
			timeTaken = (endTime.getTimeInMillis() - startTime.getTimeInMillis()) / 1000;

		} while (status == false && timeTaken <= timeOut);
		System.out.println("Time taken for Loading is " + timeTaken);
		if (timeTaken > timeOut) {
			System.out.println("timeTaken > timeOut  case");
			Thread.sleep(30000);
		}
		return timeTaken;
	}

	/**
	 * Desc: Provide a wait Till the Page got updated with Javascripts
	 * 
	 * @param timeOut
	 * @throws InterruptedException
	 */
	@SuppressWarnings("unlikely-arg-type")
	public static void waitUnitlrocDetailsLoad(int timeOut) throws InterruptedException {
		boolean status = false;
		Calendar startTime = Calendar.getInstance();
		Calendar endTime = Calendar.getInstance();
		long timeTaken;
		do {
			try {
				String string = "loading";
				if (!driver.findElement(By.tagName("title")).equals(string)) {
					status = true;
				} else {
					status = false;
				}
			} catch (NoSuchElementException e) {
				status = false;
			}
			endTime = Calendar.getInstance();
			timeTaken = (endTime.getTimeInMillis() - startTime.getTimeInMillis()) / 1000;

		} while (status == false && timeTaken <= timeOut);
		System.out.println("Time taken for Tags got Loading is " + timeTaken);
		if (timeTaken > timeOut) {
			System.out.println("timeTaken > timeOut  case");
			Thread.sleep(30000);
		}
	}

	/**
	 * Desc: Get All the Links and Images and Verify whether they are broken or not
	 * 
	 * @throws IOException
	 */
	public void verifyBrokenLinksAndImages() {

		List<WebElement> totalLinksAndImages = driver.findElements(By.tagName("a"));
		totalLinksAndImages.addAll(driver.findElements(By.tagName("img")));

		System.out.println("total number of links and images are ----->" + totalLinksAndImages.size());

		List<String> activeLinks = new ArrayList<String>();

		for (int i = 0; i < totalLinksAndImages.size(); i++) {
			if (totalLinksAndImages.get(i).getAttribute("href") != null) {
				activeLinks.add(totalLinksAndImages.get(i).getAttribute("href"));
			}
		}
		System.out.println("total number of active links are ----->" + activeLinks.size());

		int count = 1;
		for (int j = 0; j < activeLinks.size(); j++) {
			String url = activeLinks.get(j);
			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j)).openConnection();
				connection.connect();
				String massage = connection.getResponseMessage();
				connection.disconnect();
				System.out.println(count + "--->" + url + "----->" + massage);
				count++;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Desc: Delete All Cookies
	 */
	public static void deleteAllCookies() {
		driver.manage().deleteAllCookies();
		delay(2000);
	}

	public static void delay(int mili) {
		try {
			Thread.sleep(mili);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void waitForElement(WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementToBeClickable(WebElement element, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public String randomNumber() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMYYmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public void softAssertEquals(String actual, String expected) {
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(actual, expected);
		softAssertion.assertAll();
	}

	public void softAssertContains(String actual, String expected) {
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(actual.contains(expected));
		softAssertion.assertAll();
	}

	public static int parseInt(String name) {

		return Integer.parseInt(name);
	}

	public static void removeExistingCart() {

		try {
			UIFunctions.delay(3000);
			if (!getText(home.getMinicartCount()).contains("0")) {
				webclick(home.getMinicart(), "Minicart");
				UIFunctions.delay(5000);
				try {
					int cart = parseInt(getText(home.getMinicartCount()));
					if (cart != 0) {
						delay(5000);
						for (WebElement ele : checkout.getRemoveMinicartProducts()) {
							webclick(checkout.getRemoveProduct(), "Remove Existing Product");
							delay(5000);
						}
					}
				} catch (Exception e) {

					e.printStackTrace();
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			myacc.getMyAccountClose().click();
		} catch (Exception e) {}
	}

	public void userLogin(String sheetName, String testCaseName) {
		try {
			Map<String, String> testData = ReadTestData.getJsonData(sheetName, testCaseName);

			click(home.getHeaderSignIn(), "Sign In");
			input(home.getUserName(), testData.get("EmailID"), "Email Address");
			input(home.getPassWord(), testData.get("Password"), "Password");
			click(home.getLogOn(), "Login");

			if (myacc.getSignout().isDisplayed()) {
				logger.log(Status.INFO, "Successfully logged with Regular user valid credentials");

			} else {
				Assert.fail("user signin is failed");
			}

			myacc.getMyAccountClose().click();
		} catch (Exception e) {
			Assert.fail("Fail to Login due to " + e.getMessage());
		}
		// removeExistingCart();
	}
}
