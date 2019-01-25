package com.tumi.utilities;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.webPages.HomePage;

/**
 * @author Suuresh
 *
 */
public class TumiLibs extends GenericMethods {
	
	

	public static void closeSignUp() {
		try {
			HomePage home = PageFactory.initElements(driver, HomePage.class);
			try {
				home.getSignupPopup().click();
			} catch (Exception e) {
				// logger.log(Status.INFO, "SignUp Window is Already Closed");
			}
		} catch (Exception e) {
			// logger.log(Status.INFO, "SignUp Window is Not Displayed");
		}
	}

	public static void closeSignUpForUS() {
		try {
			home.getSignupPopup().click();
		} catch (Exception e) {
			// logger.log(Status.INFO, "Sign Up Pop Up is not displayed for US");
		}
		try {
			home.getCASignupPopup().click();
		} catch (Exception e) {
			// logger.log(Status.INFO, "Sign Up Pop Up is not displayed for CANADA");
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

		Map<String, String> testData = ReadTestData.retrieveData(sheet, testCase);

		final String pdpURL = GlobalConstants.url + "/p/" + testData.get("SKUID");
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

	public static void addMonogram(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.retrieveData(sheet, testCase);

		mouseHover(mono.getComplimentaryMono());
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

	public static void completeOrder(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.retrieveData(sheet, testCase);

		click(mainCart.getProceedToCheckout(), "Cart");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email");
		click(singlePage.getContinueAsGuest(), "Continue As Guest");
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address line1");
		delay(2000);
		for (WebElement ele : shipping.getListAddressLine1()) {
			if (getText(ele).equals("1001 6Th Ave Ph 1, New York NY 10018")) {
				click(ele, "AddressList");
				break;
			}
		}

		/*
		 * added code for Canada
		 * 
		 */
		/*
		 * for (WebElement ele : shipping.getListAddressLine1()) { if
		 * (getText(ele).equals("10 SUMAS WAY, ABBOTSFORD, BC, V2S 8B7")) { click(ele,
		 * "AddressList"); break; } }
		 */
		input(shipping.getPostcode(), testData.get("PostCode"), "Post code");
		input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
		click(shipping.getContinueShippingMethod(), "Continue shipping Method");
		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		TumiLibs.addCardDetails("PlaceOrder", "TumiOrder");
		delay(2000);
		click(review.getPlaceOrder(), "Place Order");
		do {
			delay(2000);
		} while (driver.findElement(By.xpath("//div[@class='loader-image']")).isDisplayed());

		if (!driver.findElement(By.xpath("//section[@id='confirmation-info-ctnr']/div/div[1]")).isDisplayed()) {

			Assert.fail("Faile to Place An Order");
		}
		captureOrderConfScreen("OrderConfirmation");
	}

	public static void addGiftMessage(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.retrieveData(sheet, testCase);

		click(gift.getCheckMessage(), " check Message");
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
		Map<String, String> testData = ReadTestData.retrieveData(sheet, testCase);
		for (int i = 0; i < 2; i++) {
			TumiLibs.searchProducts(i, testData.get("PrdouctName"));
			delay(3000);
			click(pdp.getAddToCart(), "Add to Cart");
			click(minicart.getContinueShopping(), "Continue shopping");
		}
	}
	
	public static void countrySelection(String name) {
		
		click(home.getHomeCountry(), "Default Country");
		for (WebElement ele : home.getCountriesList()) {

			if (getText(ele).equalsIgnoreCase(name)) {
				click(ele,getText(ele));
				break;
			}
		}	
		
	}

	public static void selectCountry(String name) {
		
		switch (name.toUpperCase()) {
		case "US":
			countrySelection("United States");
			break;
		case "CANADA":
			countrySelection("Canada");
			break;
		case "KOREA":
			countrySelection("Korea");
			break;
		default:
			countrySelection("United States");
			break;
		}
		selectedCountry = home.getHomeCountry().getText();
	}
}
