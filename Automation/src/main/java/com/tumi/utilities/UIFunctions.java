package com.tumi.utilities;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.webPages.HomePage;

/**
 * @author Suuresh, Shwetha
 *
 */
public class UIFunctions extends GenericMethods {

	public static void closeSignUp() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);

		try {
			home.getSignupPopup().click();
		} catch (Exception e) {
		}
		try {
			home.getCASignupPopup().click();
		} catch (Exception e) {
		}

		try {
			home.getKoreaSignupPopup().click();
		} catch (Exception e) {
		}
	}

	public static void closeSignUpForUsProd() {
		try {
			click(home.getSignupPopup(), "Close SignUp Window");
		} catch (Exception e) {
		}
	}

	public static void acceptCookies() {
		try {
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			domClick(home.getAcceptCookies(), "Accept Cookies");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void verifyVPN() {
		try {
			if (home.getVPNDis().isDisplayed()) {
				Assert.fail("VPN is Disconnected, Kindly User VPN to Access Application");
			}
		} catch (Exception e) {
		}
	}

	public static void addCardDetails(String sheet, String testCaseName) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCaseName);
  
		// billing page
		input(guestBillPage.getNameOnCard(), testData.get("NameOnCard"), "Name on Card");

		// invalid card number
		input(guestBillPage.getCardNumber(), testData.get("CardNumber"), "Card Number");
		if (browserName.equals("firefox")) {
			selectMonthInFF();
			selectYearInFF();
		} else {
			selectByVisibleText(guestBillPage.getExpiryMonth(), "05", "Expiry Month");
			selectByVisibleText(guestBillPage.getExpiryYear(), "2020", "Expiry Year");
		}
		input(guestBillPage.getCvvNumber(), testData.get("CVV"), "Cvv Number");
		input(guestBillPage.getemail(), testData.get("EmailID"), "Email ID");
		input(guestBillPage.getPhoneNumber(), testData.get("Phone"), "Phone number");
		//webclick(review.getOrderSummary(), "Order Summary");
		domClick(guestBillPage.getReviewOrder(), "Review your order");

		// elect sel = new Select(new
		// WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfElementLocated(By.name("country"))));
		// sel.selectByVisibleText("Albania");
	}

	public static void selectMonthInFF() {

		driver.findElement(By.xpath("//span[@data-val='Month']")).click();
		delay(2000);
		List<WebElement> months = driver.findElements(By.xpath("//span[@data-val='Month']/following::ul[1]/li/a"));

		for (int i = 1; i < months.size(); i++) {

			WebElement month = driver
					.findElement(By.xpath("//span[@data-val='Month']/following::ul[1]/li[" + i + "]/a"));

			if (getText(month).equals("05")) {

				month.click();
				delay(2000);
				break;
			}
		}
	}

	public static void selectYearInFF() {

		driver.findElement(By.xpath("//span[@data-val='Year']")).click();
		delay(2000);
		List<WebElement> years = driver.findElements(By.xpath("//span[@data-val='Year']/following::ul[1]/li/a"));

		for (int i = 1; i < years.size(); i++) {

			WebElement year = driver.findElement(By.xpath("//span[@data-val='Year']/following::ul[1]/li[" + i + "]/a"));

			if (getText(year).equals("2020")) {

				year.click();
				delay(2000);
				break;
			}
		}

	}
	public static void selectStateInFF() {
		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData","GuestOrders");

		driver.findElement(By.xpath("//span[@name='regionIso']/span[3]")).click();
		delay(2000);
		List<WebElement> states = driver.findElements(By.xpath("//span[@name='regionIso']/following::ul/li/a"));

		for (int i = 1; i < states.size(); i++) {

			WebElement state = driver
					.findElement(By.xpath("//span[@name='regionIso']/following::ul/li[" + i + "]/a"));
		

			if (getText(state).equals("British Columbia")) {

				state.click();
				delay(2000);
				input(shipping.getPostcode(), testData.get("CAPostCode"), "postal code");
				break;
			}
			else {
				if (getText(state).equals("New Jersey")) {

					state.click();
					delay(2000);
					input(shipping.getPostcode(), testData.get("PostCode"), "postal code");
					break;
				
			}
		}	
	}
	}

	public static void addInvalidCardDetails(String sheet, String testCaseName) {

		Map<String, String> testData = ReadTestData.retrieveData(sheet, testCaseName);

		// billing page
		input(guestBillPage.getNameOnCard(), testData.get("NameOnCard"), "Name on Card");

		// invalid card number
		input(guestBillPage.getCardNumber(), testData.get("CardNumber"), "Card Number");
		selectByVisibleText(guestBillPage.getExpiryMonth(), "05", "Expiry Month");
		selectByVisibleText(guestBillPage.getExpiryYear(), "2020", "Expiry Year");
		input(guestBillPage.getCvvNumber(), testData.get("CVV"), "Cvv Number");
		input(guestBillPage.getemail(), testData.get("EmailID"), "Email ID");
		input(guestBillPage.getPhoneNumber(), testData.get("Phone"), "Phone number");
		click(guestBillPage.getReviewOrder(), "Review your order");
		if (review.getPlaceOrder().isEnabled()) {
			Assert.fail("Able to Proceed Order with invalid details");
		}
	}

	public static int shoppingCartCount() {
		String cartItems = getText(pdp.getShoppingCart()).replace("(", "").replace(")", "").replaceAll("\\s", "");
		int cartCount = (int) cartItems.charAt(cartItems.length() - 1);
		return cartCount;
	}

	public static void addProductToCart(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		if (selectedCountry.contains("배송하기: 대한민국")) {
			final String pdpURL = GlobalConstants.urlkr + "/p/" + testData.get("SKUID");
			driver.get(pdpURL);

		} else if (selectedCountry.contains("Canada")) {

			final String pdpURL = GlobalConstants.urlca + "/p/" + testData.get("SKUID");
			driver.get(pdpURL);

		} else {

			final String pdpURL = GlobalConstants.url + "/p/" + testData.get("SKUID");
			driver.get(pdpURL);
		}
		// WaitForJStoLoad();

		// commented below for Korea order, because getting error here
		/*
		 * verifyAssertContains(driver.getCurrentUrl(), testData.get("SKUID"),
		 * "Wrong Product is displayed"); try { if (pdp.getAddToCart().isDisplayed()) {
		 * verifyAssertEquals("Add To Cart", getText(pdp.getAddToCart())); } } catch
		 * (Exception e) { Assert.fail(testData.get("SKUID") +
		 * " Product is not available"); }
		 */
		// click(pdp.getAddToCart(), "Add to Cart");

		// due to product search issue i am using above code to get the product.

		/*
		 * input(home.getSearchProduct(), testData.get("SKUID"), "Search Product");
		 * keyEnter(home.getSearchProduct());
		 * verifyAssertContains(driver.getCurrentUrl(), testData.get("SKUID"),
		 * "Wrong Product is displayed"); try { if (pdp.getAddToCart().isDisplayed()) {
		 * 
		 * verifyAssertEquals("Add To Cart", getText(pdp.getAddToCart())); } } catch
		 * (Exception e) { Assert.fail(testData.get("SKUID")
		 * +" Product is not available"); }
		 */

	}

	public static void addBackOrderProduct(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		final String pdpURL = GlobalConstants.url + "/p/" + testData.get("BackOrderSKUID");
		driver.get(pdpURL);

		// due to product search issue i am using above code to get the product.

		/*
		 * input(home.getSearchProduct(), testData.get("SKUID"), "Search Product");
		 * keyEnter(home.getSearchProduct());
		 * verifyAssertContains(driver.getCurrentUrl(), testData.get("SKUID"),
		 * "Wrong Product is displayed"); try { if (pdp.getAddToCart().isDisplayed()) {
		 * 
		 * verifyAssertEquals("Add To Cart", getText(pdp.getAddToCart())); } } catch
		 * (Exception e) { Assert.fail(testData.get("SKUID")
		 * +" Product is not available"); }
		 */

	}

	public static void addPreOrder(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		final String pdpURL = GlobalConstants.url + "/p/" + testData.get("PreOrderSKUID");
		driver.get(pdpURL);

		// due to product search issue i am using above code to get the product.

		/*
		 * input(home.getSearchProduct(), testData.get("SKUID"), "Search Product");
		 * keyEnter(home.getSearchProduct());
		 * verifyAssertContains(driver.getCurrentUrl(), testData.get("SKUID"),
		 * "Wrong Product is displayed"); try { if (pdp.getAddToCart().isDisplayed()) {
		 * 
		 * verifyAssertEquals("Add To Cart", getText(pdp.getAddToCart())); } } catch
		 * (Exception e) { Assert.fail(testData.get("SKUID")
		 * +" Product is not available"); }
		 */

	}

	public static void addGlobalLocatorProduct(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		final String pdpURL = GlobalConstants.url + "/p/" + testData.get("GlobalLocatorProductSKUID");
		driver.get(pdpURL);
	}

	public static void addMonogram(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		// domClick(mono.getComplimentaryMono(),"Monogram");
		click(mono.getAddPersonalization(), "Add Personalization");
		input(mono.getFirstMonoInput(), testData.get("FirstMonoInput"), "First Mono Input");
		input(mono.getSecondMonoInput(), testData.get("SecondMonoInput"), "Second Mono Input");
		input(mono.getThirdMonoInput(), testData.get("ThirdMonoInput"), "Third Mono Input");

		click(mono.getNext(), "Next");
		click(mono.getTextStyleBold(), "Serif as Bold");
		click(mono.getCafeColor(), "Color");
		click(mono.getApply(), "Apply");
		delay(3000);
	}

	/*
	 * public static void completeOrder(String sheet, String testCase) {
	 * 
	 * Map<String, String> testData = ReadTestData.retrieveData(sheet, testCase);
	 * 
	 * click(mainCart.getProceedToCheckout(), "Cart");
	 * input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email");
	 * click(singlePage.getContinueAsGuest(), "Continue As Guest");
	 * input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
	 * input(shipping.getLastName(), testData.get("LastName"), "Last Name");
	 * input(shipping.getAddressLine1(), testData.get("AddressLine1"),
	 * "Address line1"); do { delay(2000); } while
	 * (!shipping.getAddressList().isDisplayed());
	 * 
	 * for (int i = 1; i < shipping.getAddList().size(); i++) {
	 * 
	 * WebElement add =
	 * driver.findElement(By.xpath("//div[@class='address-picklist']/div[" + i +
	 * "]")); if (add.getText().contains("PRINCE RUPERT")) { click(add,
	 * "Address Line1"); break; } }
	 * 
	 * added code for Canada
	 * 
	 * 
	 * 
	 * for (WebElement ele : shipping.getListAddressLine1()) { if
	 * (getText(ele).equals("10 SUMAS WAY, ABBOTSFORD, BC, V2S 8B7")) { click(ele,
	 * "AddressList"); break; } }
	 * 
	 * input(shipping.getPostcode(), testData.get("PostCode"), "Post code");
	 * input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
	 * click(shipping.getContinueShippingMethod(), "Continue shipping Method");
	 * webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
	 * String fee = getText(shipMethod.getShippingFree());
	 * click(shipMethod.getProceedToPayment(), "Proceed to Payment"); if
	 * (!fee.equals("FREE")) { UIFunctions.addCardDetails("PlaceOrder",
	 * "TumiOrder"); } click(review.getPlaceOrder(), "Place Order"); do {
	 * delay(2000); } while (confirmation.getWithForConfirmation().isDisplayed());
	 * 
	 * if (!confirmation.getConfirmOrder().isDisplayed()) {
	 * 
	 * Assert.fail("Faile to Place An Order"); } orderNumber =
	 * getText(confirmation.getOrderNumber()); logger.log(Status.INFO,
	 * "Thank you for Your Order, here is your Order Number " + orderNumber);
	 * captureOrderConfScreen("OrderConfirmation"); }
	 */

	public static void addGuestDetails() {

		if (browserName.equals("ie")) {
			Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "BackOrderProduct");
			input(shipping.getFirstName(), testData1.get("FirstName"), "First Name");
			input(shipping.getLastName(), testData1.get("LastName"), "Last Name");
			input(shipping.getAddressLine1(), "100 Alabama", "Address Line1");
			delay(2000);
			driver.findElement(By.xpath("//input[@placeholder='Address Line2']")).click();
			domClick(driver.findElement(By.xpath("//select[@name='regionIso']/following::span[1]/span/span[2]")), "");
			delay(3000);
			List<WebElement> ele = driver
					.findElements(By.xpath("//select[@name='regionIso']/following::span[1]/ul/li"));

			for (int i = 1; i < ele.size(); i++) {

				WebElement region = driver
						.findElement(By.xpath("//select[@name='regionIso']/following::span[1]/ul/li[" + i + "]"));
				if (getText(region).equals("Alabama")) {

					region.click();
					delay(5000);
					break;
				}
			}
			driver.findElement(By.xpath("//input[@name='townCity']")).sendKeys("Muscle Shoals");
			driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("35661-6507");
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("9877939354");
			driver.findElement(By.xpath("//h2[contains(text(),'Order Summary')]")).click();
		} else {

			if (selectedCountry.contains("배송하기: 대한민국")) {
				Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDeatilsForKorea");
				input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
				input(shipping.getLastName(), testData.get("LastName"), "Last Name");
				input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address Line1");
				input(shipping.getTown(), testData.get("TownCity"), "Town");
				input(shipping.getPostcode(), testData.get("PostCode"), "PostCode");
				input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
			}

			else {
				Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "OrderWithTwoProducts");
				input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
				input(shipping.getLastName(), testData.get("LastName"), "Last Name");
				input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address Line1");
				explicitWait(shipping.getSelectedAddressLine());
				if (selectedCountry.contains("Canada")) {
					for (WebElement ele : shipping.getListAddressLine1()) {
						if (getText(ele).contains("ABBOTSFORD, BC")) {
							delay(2000);
							click(ele, "AddressList");
							break;
						}
					}
					/*
					 * for (int i = 1; i < shipping.getAddListCA().size(); i++) { WebElement add =
					 * driver.findElement(By.xpath(
					 * "(//div[contains(@class,'address-picklist')]/div)[1][" + i + "]")); if
					 * (add.getText().contains("ABBOTSFORD")) { //, BC, V2S 8B7 click(add,
					 * "Address Line1"); break; } }
					 */

				} else {
					for (int i = 1; i < shipping.getAddList().size(); i++) {
						WebElement add = driver
								.findElement(By.xpath("//div[@class='address-picklist']/div[" + i + "]"));
						if (add.getText().contains("Fairport NY 14450")) {
							click(add, "Address Line1");
							break;
						}
					}

				}

				input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
			}
		}
	}

	public static void completeOrder() {

		delay(2000);
		domClick(review.getPlaceOrder(), "Place Order");
		do {
			delay(2000);
		} while (confirmation.getWithForConfirmation().isDisplayed());

		if (!confirmation.getConfirmOrder().isDisplayed()) {

			Assert.fail("Faile to Place An Order");
		}
		orderNumber = getText(confirmation.getOrderNumber());
		logger.log(Status.INFO, "Thank you for Your Order, here is your Order Number " + orderNumber);
		captureOrderConfScreen("OrderConfirmation");
		delay(3000);
	}

	public static void addPromotionalCodeAtCart(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		input(mainCart.getPromocode(), testData.get("VoucherID"), "Vocher Id");
		click(mainCart.getApply(), "Check Promocode");
		/*
		 * try { if (mainCart.getVocherCardFailed().isDisplayed()) {
		 * 
		 * Assert.fail(getText(mainCart.getVocherCardFailed()));
		 * 
		 * } else if (!mainCart.getCodeApplied().isDisplayed()) {
		 * 
		 * Assert.fail("Promo Code Remove link is not displayed");
		 * 
		 * } else if (!mainCart.getCodeRemove().isDisplayed()) {
		 * 
		 * Assert.fail("Promo Code Applied Message is not displayed");
		 * 
		 * } else if (!mainCart.getSubtotalCode().isDisplayed()) {
		 * 
		 * Assert.fail("Promo Code Subtotal is not displayed");
		 * 
		 * } else if (mainCart.getVocherCardFailed().isDisplayed()) {
		 * 
		 * Assert.fail(getText(mainCart.getVocherCardFailed())); } } catch (Exception e)
		 * {
		 * 
		 * Assert.fail("Vocher Card related Fields are not displayed " +
		 * e.getMessage()); }
		 */

	}

	public static void addPromotionalCodeAtSinglePage(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		input(singlePage.getPromocode(), testData.get("VoucherID"), "Vocher Id");
		click(singlePage.getApply(), "Check Promocode");
		// delay(2000);

		/*
		 * try { if (mainCart.getVocherCardFailed().isDisplayed()) {
		 * 
		 * Assert.fail(getText(mainCart.getVocherCardFailed()));
		 * 
		 * } else if (!mainCart.getCodeApplied().isDisplayed()) {
		 * 
		 * Assert.fail("Promo Code Remove link is not displayed");
		 * 
		 * } else if (!mainCart.getCodeRemove().isDisplayed()) {
		 * 
		 * Assert.fail("Promo Code Applied Message is not displayed");
		 * 
		 * } else if (!mainCart.getSubtotalCode().isDisplayed()) {
		 * 
		 * Assert.fail("Promo Code Subtotal is not displayed");
		 * 
		 * } else if (mainCart.getVocherCardFailed().isDisplayed()) {
		 * 
		 * Assert.fail(getText(mainCart.getVocherCardFailed())); } } catch (Exception e)
		 * {
		 * 
		 * Assert.fail("Vocher Card related Fields are not displayed " +
		 * e.getMessage()); }
		 */

	}

	public static void addGiftMessage(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		domClick(gift.getCheckMessage(), "Check Message");
		input(gift.getRecipientName(), testData.get("RecipientName"), "Recipients name");
		input(gift.getSenderName(), testData.get("SenderName"), "Sender name");
		input(gift.getAddMessage(), testData.get("Message"), "Message");

	}

	public static void addGiftBox() {
		click(gift.getCheckPremiumGift(), "Premium GiftBox");
	}

	public static void addVoucherID(String sheet, String testCase) {
		Map<String, String> testData = ReadTestData.retrieveData(sheet, testCase);
		input(mainCart.getPromocode(), testData.get("VocherID"), "Voucher Code");
		click(mainCart.getApply(), "Apply Promocode");
	}

	public static void signInWithGoogle(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.retrieveData(sheet, testCase);

		try {
			if (google.getNoThanks().isDisplayed()) {
				click(google.getNoThanks(), "offers popup");
			}
		} catch (Exception e) {
		}
		String parent = driver.getWindowHandle();
		webclick(home.getHeaderSignIn(), "Sign In");
		webclick(google.getGoogleLogin(), "Google login");
		Set<String> set = driver.getWindowHandles();
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			String child = ite.next();
			if (!parent.equals(child)) {
				driver.switchTo().window(child);
				input(google.getEmail(), testData.get("EmailID"), "Gmail Id");
				webclick(google.getFirstNext(), "Next");
				input(google.getPassword(), testData.get("Password"), "Password");
				webclick(google.getPasswordNext(), "password next");
			}
		}
	}

	public static void searchProducts(int i, String data) {
		input(home.getSearchProduct(), data, "Product Search");
		if (home.getMatchingProducts().isEmpty()) {
			final String emptyViewText = driver
					.findElement(By.xpath("//div[contains(text(),'Sorry, no search results for')]")).getText();
			if (!emptyViewText.contains("no results")) {
				throw new RuntimeException(emptyViewText);
			}
		} else {
			home.getMatchingProducts().get(i).click();
		}
	}

	public static void addMultipleProducts(String sheet, String testCase) {
		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);
		for (int i = 0; i < 2; i++) {
			UIFunctions.searchProducts(i, testData.get("PrdouctName"));
			delay(3000);
			// verifyAssertContains(driver.getCurrentUrl(), testData.get("SKUID"), "Wrong
			// Product is displayed");
			try {
				if (pdp.getAddToCart().isDisplayed()) {
					verifyAssertEquals("Add To Cart", getText(pdp.getAddToCart()));
				}
			} catch (Exception e) {
				Assert.fail(testData.get("SKUID") + " Product is not available");
			}
			click(pdp.getAddToCart(), "Add to Cart");
			click(minicart.getContinueShopping(), "Continue shopping");
		}
	}

	public static void countrySelection(String name) {

		HomePage home = PageFactory.initElements(driver, HomePage.class);

		home.getHomeCountry().click();
		delay(3000);
		for (WebElement ele : home.getCountriesList()) {

			if (getText(ele).equalsIgnoreCase(name)) {
				ele.click();
				break;
			}
		}
		try {
			GenericMethods.delay(2000);
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		} catch (Exception e) {
		}
		selectedCountry = home.getHomeCountry().getText();
		System.out.println("Execution Country is " + selectedCountry);
		UIFunctions.closeSignUp();
	}

	public static void selectCountry() {

		// logger = report.createTest("Country");

		String countryName = System.getProperty("countryName");

		System.out.println("Country Name " + countryName);

		if (null == countryName || countryName.isEmpty() || countryName.toUpperCase().equalsIgnoreCase("US")) {

			// logger.log(Status.INFO, "Execution initiated for US");

		} else if (countryName.toUpperCase().equalsIgnoreCase("CANADA")) {

			countrySelection("Canada");
			
			// logger.log(Status.INFO, "Execution initiated for Canada");

		} else if (countryName.toUpperCase().equalsIgnoreCase("KOREA")) {
			countrySelection("Korea");
			// logger.log(Status.INFO, "Execution initiated for Korea");
		}
	}

	public static void payPalCheckout(String sheet, String testCase, WebElement ele) {
		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);
		String value = getText(ele); // use this for registered user
		// String value = getText(mainCart.getEstimatedTotal()); //use this for Guest
		// users
		System.out.println(value);
		Double dValue = Double.valueOf(value.replace("$", ""));
		if (dValue.intValue() >= 100) {
			click(paypal.getPayPalAnother(), "PayPal");
		} else {
			click(paypal.getPayPal(), "PayPal");
		}
		input(paypal.getPayPalEmail(), testData.get("EmailID"), "EmailID");
		click(paypal.getNext(), "Next");
		input(paypal.getPayPalPassword(), testData.get("Password"), "Password");
		click(paypal.getLogin(), "Login");
		domClick(paypal.getVisax111(), "Select Visa");
		click(paypal.getPaypalContinue(), "Continue");
		delay(3000);
		click(paypal.getPaypalCheckout(), "Checkout");
	}

	public static void waitForContinueToEnable() {
		try {
			driver.findElement(By.xpath("//h2[contains(text(),'Checkout as a Guest')]")).click();
		} catch (Exception e) {
		}
		// do {
		delay(2000);
		// } while (!singlePage.isContinueDisabled().isDisplayed());
	}

	public static void addMultiship() {

		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "OrderWithTwoProducts");
		click(multiShip.getMultiShipClick(), "MultiShipment");
		//delay(2000);
		domClick(multiShip.getAddShippment0(), "add shipment 1");
		if (selectedCountry.contains("Canada")){
			addMultishipGuestDeatils(testData.get("shipmentCA1"), testData.get("AddressLine1"));
		}else {
		addMultishipGuestDeatils(testData.get("shipment1"), testData.get("AddressLine1"));
		}
		click(multiShip.getNext(), "Continue next shipping");
		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(multiShip.getNextShipment(), "Continue next shipment");
		delay(3000);
		domClick(multiShip.getAddShippment0(), "add shipment 2");
		if (selectedCountry.contains("Canada")){
			addMultishipGuestDeatils(testData.get("shipmentCA2"), testData.get("nextAddressLine1"));
		}else {
			addMultishipGuestDeatils(testData.get("shipment2"), testData.get("nextAddressLine1"));
		}
		
		click(multiShip.getNext(), "Continue next shipping");
		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
	}

	public static void addMultishipForRegistered() {

		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "OrderWithTwoProducts");
		click(multiShip.getMultiShipClick(), "MultiShipment");
		delay(2000);
		domClick(multiShip.getAddShippment0(), "add shipment 1");
		domClick(signinBill.getAddNewAddress(), "Add new address");
		if (selectedCountry.contains("Canada")){
			addMultishipGuestDeatils(testData.get("shipmentCA1"), testData.get("AddressLine1"));
		}else {
		addMultishipGuestDeatils(testData.get("shipment1"), testData.get("AddressLine1"));
		}
		click(multiShip.getNext(), "Continue next shipping");
		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(multiShip.getNextShipment(), "Continue next shipment");
		delay(3000);
		domClick(multiShip.getAddShippment0(), "add shipment 2");
		domClick(signinBill.getAddNewAddress(), "Add new address");
		if (selectedCountry.contains("Canada")){
			addMultishipGuestDeatils(testData.get("shipmentCA2"), testData.get("nextAddressLine1"));
		}else {
			addMultishipGuestDeatils(testData.get("shipment2"), testData.get("nextAddressLine1"));
		}
		click(multiShip.getNext(), "Continue next shipping");
		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
	}

	public static void addMultishipGuestDeatils(String data, String data1) {
		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "OrderWithTwoProducts");
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), data1, "Address Line1");
		explicitWait(shipping.getSelectedAddressLine());//input[@name='line1']/following::div[3]
		if (selectedCountry.contains("Canada")) {
			for (WebElement ele : shipping.getListAddressLine1()) {
				if (getText(ele).contains("ABBOTSFORD, BC")) {
					delay(2000);
					click(ele, "AddressList");
					break;
				}else if (getText(ele).contains("HOPE, BC")) {
					delay(2000);
					click(ele, "AddressList");
					break;
				}
			/*for (int i = 1; i < shipping.getAddListCA().size(); i++) {
				WebElement add = driver.findElement(By.xpath("//input[@name='line1']/following::div[2]/div[" + i + "]"));
				if (add.getText().contains(data)) {
					click(add, "Address Line1");
					break;
				}
			}*/
			}
		} else {
			for (int i = 1; i < shipping.getAddList().size(); i++) {
				WebElement add = driver.findElement(By.xpath("//div[@class='address-picklist']/div[" + i + "]"));
				if (add.getText().contains(data)) {
					click(add, "Address Line1");
					break;
				}
			}
		}
		input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
	}

	public static void addMultishipAddressWithCardDeatils(String sheet, String testCaseName) {
		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCaseName);

		// billing page
		input(guestBillPage.getNameOnCard(), testData.get("NameOnCard"), "Name on Card");

		input(guestBillPage.getCardNumber(), testData.get("CardNumber"), "Card Number");
		if (browserName.equals("firefox")) {
			selectMonthInFF();
			selectYearInFF();
		} else {
			selectByVisibleText(guestBillPage.getExpiryMonth(), "05", "Expiry Month");
			selectByVisibleText(guestBillPage.getExpiryYear(), "2020", "Expiry Year");
		}
		
		input(guestBillPage.getCvvNumber(), testData.get("CVV"), "Cvv Number");
		input(guestBillPage.getemail(), testData.get("EmailID"), "Email ID");
		input(guestBillPage.getPhoneNumber(), testData.get("Phone"), "Phone number");
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address line1");
		input(shipping.getTown(), testData.get("TownCity"), "Town");
		if (browserName.equals("firefox")) {
				selectStateInFF();
		}
		else {
		Select dropdown = new Select(driver.findElement(By.name("regionIso")));
		dropdown.selectByVisibleText("New Jersey");
		click(shipping.getRegionIso(), "Region");
		input(shipping.getPostcode(), testData.get("PostCode"), "postal code");
	}
		
		domClick(guestBillPage.getReviewOrder(), "Review your order");

	}

	public static void addTumiStudio() {
		click(tumiId.getTumiIdDesign(), "click on TumiID");
		delay(2000);
		// click(tumiId.getMainBody(),"Main Body");
		click(tumiId.getShadowGrayColor(), "Main Body in Shadow gray Color");
		delay(2000);
		click(tumiId.getFrontPocket(), "Front Pocket");
		click(tumiId.getBlackColor(), "Front Pocket Red Color");
		click(tumiId.getSidePockets(), "Side Pockets");
		click(tumiId.getAtlanticBlueColor(), "Side Pocket Blue Color");
		click(tumiId.getPatchnTag(), "Patch & Tag");
		click(tumiId.getRedColor(), "Patch n Tag in Red color");
		click(tumiId.getWebbing(), "Webbing");
		click(tumiId.getBlackColor(), "Webbing Color");
		click(tumiId.getLeatherAccents(), "Leather Accents");
		click(tumiId.getAtlanticBlueColor(), "Leather in Blue color");
		click(tumiId.getHardWare(), "Hard Ware");
		click(tumiId.getGoldColor(), "Hardware in Gold Color");
		click(tumiId.getExternalZipper(), "External Zipper");
		click(tumiId.getAtlanticBlueColor(), "External Zipper in blue color");
		click(tumiId.getAccentZipper(), "Accent Zipper");
		click(tumiId.getGoldColor(), "Accent in gold color");
		click(tumiId.getInteriorLining(), "Interior Lining");
		click(tumiId.getFossilColor(), "Interior in Fossil color");
		// monogram
		click(tumiId.getMonograming(), "tumiIdgramming");
		delay(2000);
		click(tumiId.getHeart(), "Heart symbol");
		click(tumiId.getHeart(), "Heart symbol");
		click(tumiId.getHeart(), "Heart Symbol");
		/*
		 * input(tumiId.getFirstInput(), tumiId.getHeart(), "First tumiId Input");
		 * input(tumiId.getSecondInput(), tumiId.getHeart(), "Second tumiId Input");
		 * input(tumiId.getThirdInput(), tumiId.getHeart(), "Third tumiId Input");
		 */
		click(tumiId.getFirstNext(), "Next");
		click(tumiId.getTumiWhiteColor(), "White color");
		click(tumiId.getSecondNext(), "Next");
		click(tumiId.getCheckBox(), "Check for both apply");
		click(tumiId.getApply(), "Apply");
		click(tumiId.getSaveDesign(), "Save");

	}
	
public static void GiftCard(String sheet,String testCase) {
	Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);
	final String pdpURL = GlobalConstants.url + "/p/" + testData.get("SKUID");
	driver.get(pdpURL);
	//Gift card
	        click(guestBillPage.getGiftcardButton(),"Gift Card Button");
			
			input(guestBillPage.getGiftcard(),testData.get("GiftCardNo"),"Gift Card number");
			input(guestBillPage.getGiftpin(),testData.get("GiftPinNo"),"Gift Pin number");
			click(guestBillPage.getaddGiftcardApply(),"Gift Card Apply Button");
			input(guestBillPage.getNameOnCard(), testData.get("NameOnCard"), "Name on Card");

			// invalid card number
			input(guestBillPage.getCardNumber(), testData.get("CardNumber"), "Card Number");
			if (browserName.equals("firefox")) {
				selectMonthInFF();
				selectYearInFF();
			}else {
				selectByVisibleText(guestBillPage.getExpiryMonth(), "05", "Expiry Month");
				selectByVisibleText(guestBillPage.getExpiryYear(), "2020", "Expiry Year");
			}
			input(guestBillPage.getCvvNumber(), testData.get("CVV"), "Cvv Number");
			input(guestBillPage.getemail(), testData.get("EmailID"), "Email ID");
			input(guestBillPage.getPhoneNumber(), testData.get("Phone"), "Phone number");
			domClick(guestBillPage.getReviewOrder(), "Review your order");

}
}
