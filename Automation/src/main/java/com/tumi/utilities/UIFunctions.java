package com.tumi.utilities;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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
		delay(5000);
		try {
			jsClick(home.getNoThanks());
			delay(5000);
		} catch (Exception e) {
		}

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
		try {
			driver.findElement(By.xpath("//a[contains(text(),'Close')]")).click();
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
			delay(5000);
			if (driver.getTitle().equals("www.hybris-stage2.tumi.com")) {
				logger.log(Status.FAIL, "Failed due to VPN");
				Assert.fail("VPN is Disconnected, Kindly Use VPN to Access Application");
			}
		} catch (Exception e) {
		}
	}

	public static void addCardDetails(String sheet, String testCaseName) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCaseName);
		Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "CreditCardDetails");

		// billing page
		input(guestBillPage.getNameOnCard(), testData.get("NameOnCard"), "Name on Card");

		// invalid card number
		input(guestBillPage.getCardNumber(), testData.get("CardNumber"), "Card Number");
		if (browserName.equals("firefox")) {
			selectMonthInFF();
			selectYearInFF();
		} else {
			selectByVisibleText(guestBillPage.getExpiryMonth(), testData.get("ExipryMonth"), "Expiry Month");
			selectByVisibleText(guestBillPage.getExpiryYear(), testData.get("ExpiryYear"), "Expiry Year");
		}
		input(guestBillPage.getCvvNumber(), testData.get("CVV"), "Cvv Number");
		input(guestBillPage.getemail(), testData.get("EmailID"), "Email ID");
		input(guestBillPage.getPhoneNumber(), testData.get("Phone"), "Phone number");
		domClick(guestBillPage.getReviewOrder(), "Review your order");
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
		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");

		driver.findElement(By.xpath("//span[@name='regionIso']/span[3]")).click();
		delay(2000);
		List<WebElement> states = driver.findElements(By.xpath("//span[@name='regionIso']/following::ul/li/a"));

		for (int i = 1; i < states.size(); i++) {

			WebElement state = driver.findElement(By.xpath("//span[@name='regionIso']/following::ul/li[" + i + "]/a"));

			if (getText(state).equals("British Columbia")) {

				state.click();
				delay(2000);
				input(shipping.getPostcode(), testData.get("CAPostCode"), "postal code");
				break;
			} else {
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

		UIFunctions.closeSignUp();
		//removeExistingCart();
		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);
		Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "Environments");

		if (selectedCountry.equals("US") || selectedCountry.contains("United States") || selectedCountry.isEmpty()) {

			if (applicationUrl.equals("stage2")) {

				final String pdpURL = GlobalConstants.S2 + "/p/" + testData.get("SKUID");
				driver.navigate().to(pdpURL);

			} else if (applicationUrl.equals("stage3")) {

				final String pdpURL = GlobalConstants.S3 + "/p/" + testData.get("SKUID");
				driver.navigate().to(pdpURL);

			}else if (applicationUrl.equals("akamaiS2")) {
			

				final String pdpURL = GlobalConstants.akamaiUrl + "/p/" + testData.get("SKUID");
				driver.navigate().to(pdpURL);

			} else if (applicationUrl.equals("prod")) {

				final String pdpURL = testData1.get("prod") + "/p/" + testData.get("SKUID");
				driver.navigate().to(pdpURL);
				UIFunctions.closeSignUp();
			}

		} else if (selectedCountry.contains("Canada")) {

			final String pdpURL = GlobalConstants.urlca + "/p/" + testData.get("SKUID");
			driver.get(pdpURL);

		} else {

			final String pdpURL = GlobalConstants.urlkr + "/p/" + testData.get("KoreaSKUID");
			driver.get(pdpURL);
		}

		UIFunctions.verifyVPN();
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

	public static void addToCart(String sheet, String testCase) {
		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);
		Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "Environments");

		if (selectedCountry.equals("US") || selectedCountry.contains("United States") || selectedCountry.isEmpty()) {

			if (applicationUrl.equals("stage2")) {

				final String pdpURL = GlobalConstants.S2 + "/p/" + testData.get("SKUID");
				driver.get(pdpURL);

			} else if (applicationUrl.equals("stage3")) {

				final String pdpURL = GlobalConstants.S3 + "/p/" + testData.get("SKUID");
				driver.get(pdpURL);

			} else if (applicationUrl.equals("prod")) {

				final String pdpURL = testData1.get("prod") + "/p/" + testData.get("SKUID");
				driver.get(pdpURL);
			}

		} else if (selectedCountry.contains("Canada")) {

			final String pdpURL = GlobalConstants.urlca + "/p/" + testData.get("SKUID");
			driver.get(pdpURL);

		} else {

			final String pdpURL = GlobalConstants.urlkr + "/p/" + testData.get("KoreaSKUID");
			driver.get(pdpURL);
		}
		UIFunctions.verifyVPN();
	}

	public static void addBackOrderProduct(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		final String pdpURL = GlobalConstants.S2 + "/p/" + testData.get("BackOrderSKUID");
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

		final String pdpURL = GlobalConstants.S2 + "/p/" + testData.get("PreOrderSKUID");
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

		final String pdpURL = GlobalConstants.S2 + "/p/" + testData.get("GlobalLocatorProductSKUID");
		driver.get(pdpURL);
	}

	public static void addProductForBreadCrumbs(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);
		if (selectedCountry.contains("US")) {

			final String pdpURL = GlobalConstants.S2 + "/p/" + testData.get("BreadCrumbsTest");
			driver.get(pdpURL);
		} else if (selectedCountry.contains("Canada")) {

			final String pdpURL = GlobalConstants.urlca + "/p/" + testData.get("BreadCrumbsTest");
			driver.get(pdpURL);

		} else {

			final String pdpURL = GlobalConstants.urlkr + "/p/" + testData.get("BreadCrumbsTest");
			driver.get(pdpURL);
		}
		UIFunctions.verifyVPN();
	}

	public static void addMonogram(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		// domClick(mono.getComplimentaryMono(),"Monogram");
		domClick(mono.getAddPersonalization(), "Add Personalization");
		input(mono.getFirstMonoInput(), testData.get("FirstMonoInput"), "First Mono Input");
		input(mono.getSecondMonoInput(), testData.get("SecondMonoInput"), "Second Mono Input");
		input(mono.getThirdMonoInput(), testData.get("ThirdMonoInput"), "Third Mono Input");

		click(mono.getNext(), "Next");
		click(mono.getTextStyleBold(), "Serif as Bold");
		click(mono.getCafeColor(), "Color");
		click(mono.getApply(), "Apply");
		delay(3000);
	}

	public static void removeMonogram() {
		try {
			if (mono.getRemove().isDisplayed()) {
				click(mono.getRemove(), "Removed added monogram");
			}
		} catch (Exception e) {
		}
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

	public static void addGuestDetailsForIE() {

		Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
		input(shipping.getFirstName(), testData1.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData1.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), "100 Alabama", "Address Line1");
		delay(2000);
		driver.findElement(By.xpath("//input[@placeholder='Address Line2']")).click();
		domClick(driver.findElement(By.xpath("//select[@name='regionIso']/following::span[1]/span/span[2]")), "");
		delay(3000);
		List<WebElement> ele = driver.findElements(By.xpath("//select[@name='regionIso']/following::span[1]/ul/li"));

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
	}

	public static void addGuestDetails() {

		if (browserName.equals("ie")) {
			addGuestDetailsForIE();
		} else {

			if (selectedCountry.contains("US") || selectedCountry.contains("Canada")
					|| selectedCountry.contains("United States")) {

				Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
				input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
				input(shipping.getLastName(), testData.get("LastName"), "Last Name");
				input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address Line1");
				explicitWait(shipping.getSelectedAddressLine());
				if (selectedCountry.contains("Canada")) {
					for (WebElement ele : shipping.getListAddressLine1()) {
						if (getText(ele).contains("ABBOTSFORD, BC")) {
							delay(5000);
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
			} else {

				Map<String, String> korea = ReadTestData.getJsonData("TumiTestData", "GuestDeatilsForKorea");

				input(shipping.getFirstName(), korea.get("FirstName"), "First Name");
				input(shipping.getLastName(), korea.get("LastName"), "Last Name");
				input(shipping.getAddressLine1(), korea.get("AddressLine1"), "Address Line1");
				input(shipping.getTown(), korea.get("TownCity"), "Town");
				input(shipping.getPostcode(), korea.get("PostCode"), "PostCode");
				input(shipping.getPhoneNumber(), korea.get("Phone"), "Phone Number");
			}
		}
	}

	public static void completeOrder() {
		if (applicationUrl.equals("prod")) {
			logger.log(Status.PASS,"Scripts are executing in Production");
		} else {
			domClick(review.getPlaceOrder(), "Place Order");
			scrollUp();
			do {
				delay(2000);

			} while (confirmation.getWithForConfirmation().isDisplayed());
			if (!confirmation.getConfirmOrder().isDisplayed()) {

				Assert.fail("Faile to Place An Order");
			}
			orderNumber = getText(confirmation.getOrderNumber());
			logger.log(Status.INFO, "Thank you for Your Order, here is your Order Number " + orderNumber);
			delay(3000);
			// captureOrderConfScreen("OrderConfirmation");
		}
	}

	public static void addPromotionalCodeAtCart(String sheet, String testCase) {
	
	
	
		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);
		if (selectedCountry.contains("US")) {
			String beforeTotal = getText(mainCart.getEstimatedTotal());
			Double beforeCost = Double.valueOf(beforeTotal.replace("$", "").replace(",",""));
			System.out.println("Before select Price = " + beforeCost);
		input(mainCart.getPromocode(), testData.get("VoucherID"), "Vocher Id");
		click(mainCart.getApply(), "Check Promocode");
		delay(2000);
		verifyPromoChargeCart(beforeCost);
		} else if (selectedCountry.contains("Canada")) {
			String beforeTotal = getText(mainCart.getEstimatedTotal());
			Double beforeCost = Double.valueOf(beforeTotal.replace("$", "").replace(",",""));
			System.out.println("Before select Price = " + beforeCost);
			input(mainCart.getPromocode(), testData.get("CAVoucherID"), "Vocher Id");
			click(mainCart.getApply(), "Check Promocode");
			verifyPromoChargeCart(beforeCost);
		} else {
			String beforeTotal = getText(mainCart.getEstimatedTotal());
			Double beforeCost = Double.valueOf(beforeTotal.substring(1).replace(",",""));
		
			System.out.println("Before select Price = " + beforeCost);
			
			input(mainCart.getPromocode(), testData.get("KRVoucherID"), "Vocher Id");
			click(mainCart.getApply(), "Check Promocode");
			verifyKrPromoChargecart(beforeCost);
			
			
			
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
	}
	public static void verifyPromoChargeCart(double data) {
		delay(2000);

		String afterTotal = getText(mainCart.getEstimatedTotal());
		Double afterCost = Double.valueOf(afterTotal.replace("$", "").replace(",",""));
		System.out.println("After applying Promocode, Total Price = " + afterCost);

		double verifyPromo = data - afterCost;

		String promo = getText(mainCart.getPromoCharge());
		Double promoDiscount = Double.valueOf(promo.replace("$", "").replace("-", "").replace(",",""));
		System.out.println("Promo Discount = "+promoDiscount);

		if (promoDiscount.equals(verifyPromo)) {
			logger.log(Status.INFO, "Promocode added successfully to Order summery");
		}else {
			Assert.fail("Promo Validation is failed");	
			}
	}
	public static void verifyKrPromoChargecart(double data) {
		String afterTotal = getText(mainCart.getEstimatedTotal());
		Double afterCost = Double.valueOf(afterTotal.substring(1).replace(",",""));
		System.out.println("After applying Promocode, Total Price = " + afterCost);

		double verifyPromo = data - afterCost;

		String promo = getText(mainCart.getPromoCharge());
		Double promoDiscount =Double.valueOf(promo.substring(2));
		System.out.println("Promo Discount = "+promoDiscount);

		if (promoDiscount.equals(verifyPromo)) {
			logger.log(Status.INFO, "Promocode added successfully to Order summery");
		}else {
			Assert.fail("Promo Validation is failed");	
			}
	}


	public static void addPromotionalCodeAtSinglePage(String sheet, String testCase) {
		
		String beforeTotal = getText(shipMethod.getBeforeTotal());
		Double beforeCost = 0.00D;
		Double beforeCostkr= 0.00D;
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
		beforeCost = Double.valueOf(beforeTotal.replace("$", "").replace(",",""));
		System.out.println("Before select Price = " + beforeCost);
		}
		
		else {
	    beforeCostkr = Double.valueOf(beforeTotal.substring(1).replace(",",""));
		System.out.println("Before select Price = " + beforeCostkr);
		}
		

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);
		if (selectedCountry.contains("US")) {
			input(singlePage.getPromocode(), testData.get("VoucherID"), "Vocher Id");
			click(singlePage.getApply(), "Check Promocode");
			delay(2000);
			verifyPromoCharge(beforeCost);

		} else if (selectedCountry.contains("Canada")) {

			input(singlePage.getPromocode(), testData.get("CAVoucherID"), "Vocher Id");
			click(singlePage.getApply(), "Check Promocode");

			verifyPromoCharge(beforeCost);
		} else {
			
			input(singlePage.getPromocode(), testData.get("KRVoucherID"), "Vocher Id");
			click(singlePage.getApply(), "Check Promocode");
			verifyPromoCharge(beforeCostkr);
		}
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

	public static void verifyPromoCharge(double data) {
		SoftAssert promoAsser = new SoftAssert();
		delay(2000);

		String afterTotal = getText(shipMethod.getBeforeTotal());
		Double afterCost = 0.00D;
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
		afterCost = Double.valueOf(afterTotal.replace("$", "").replace(",",""));
		}else {
		afterCost = Double.valueOf(afterTotal.substring(1).replace(",",""));
		}
		System.out.println("After applying Promocode, Total Price = " + afterCost);

		double verifyPromo =  data - afterCost ;

		String promo = getText(shipMethod.getPromoCharge());
		Double promoDiscount = 0.00D;
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
		promoDiscount = Double.valueOf(promo.replace("$", "").replace("-", "").replace(",",""));
		}else {
	    promoDiscount = Double.valueOf(promo.substring(2).replace("-", "").replace(",",""));	
		}
		System.out.println("Promo Discount ="+promoDiscount);

		if (promoDiscount.equals(verifyPromo)) {
			logger.log(Status.INFO, "Promocode added successfully to Order summery");
		}else {
			promoAsser.fail("Promo code validation is failed");
		}
		promoAsser.assertAll();
	}

	public static void addGiftMessage(String sheet, String testCase) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);

		domClick(gift.getCheckMessage(), "Check Message");
		input(gift.getRecipientName(), testData.get("RecipientName"), "Recipients name");
		input(gift.getSenderName(), testData.get("SenderName"), "Sender name");
		input(gift.getAddMessage(), testData.get("Message"), "Message");

	}

	public static void addGiftBox() {

		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			domClick(gift.getCheckPremiumGift(), "Premium GiftBox");

		} else {

			domClick(gift.getCheckStandardGift(), "Stanadard gift box");
		}

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
			home.getMatchingProduct().click();
		}
	}

	public static void addMultipleProducts(String sheet, String testCase) {
		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);
		for (int i = 0; i < 2; i++) {
			UIFunctions.searchProducts(i, testData.get("ProductName"));
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
		String value = getText(ele);
		System.out.println(value);
		Double dValue = Double.valueOf(value.replace("$", ""));
		if (dValue.intValue() >= 100) {
			click(paypal.getPayPalAnother(), "PayPal");
		} else {
			click(paypal.getPayPal(), "PayPal");
		}
		input(paypal.getPayPalEmail(), testData.get("EmailID"), "EmailID");
		//click(paypal.getNext(), "Next");
		input(paypal.getPayPalPassword(), testData.get("Password"), "Password");
		click(paypal.getLogin(), "Login");
		domClick(paypal.getCreditCard(), "Select Visa");
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
		// delay(2000);
		domClick(multiShip.getAddShippment0(), "add shipment 1");
		if (selectedCountry.contains("Canada")) {
			addMultishipGuestDeatils(testData.get("shipmentCA1"), testData.get("AddressLine1"));
		} else {
			addMultishipGuestDeatils(testData.get("shipment1"), testData.get("AddressLine1"));
		}
		click(multiShip.getNext(), "Continue next shipping");
		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(multiShip.getNextShipment(), "Continue next shipment");
		domClick(multiShip.getAddShippment0(), "add shipment 2");
		if (selectedCountry.contains("Canada")) {
			addMultishipGuestDeatils(testData.get("shipmentCA2"), testData.get("nextAddressLine1"));
		} else {
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
		if (selectedCountry.contains("Canada")) {
			addMultishipGuestDeatils(testData.get("shipmentCA1"), testData.get("AddressLine1"));
		} else {
			addMultishipGuestDeatils(testData.get("shipment1"), testData.get("AddressLine1"));
		}
		click(multiShip.getNext(), "Continue next shipping");
		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(multiShip.getNextShipment(), "Continue next shipment");
		delay(3000);
		domClick(multiShip.getAddShippment0(), "add shipment 2");
		domClick(signinBill.getAddNewAddress(), "Add new address");
		if (selectedCountry.contains("Canada")) {
			addMultishipGuestDeatils(testData.get("shipmentCA2"), testData.get("nextAddressLine1"));
		} else {
			addMultishipGuestDeatils(testData.get("shipment2"), testData.get("nextAddressLine1"));
		}
		click(multiShip.getNext(), "Continue next shipping");
		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
	}

	public static void addMultishipGuestDeatils(String data, String data1) {
		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), data1, "Address Line1");
		explicitWait(shipping.getSelectedAddressLine());// input[@name='line1']/following::div[3]
		if (selectedCountry.contains("Canada")) {
			for (WebElement ele : shipping.getListAddressLine1()) {
				if (getText(ele).contains("ABBOTSFORD, BC")) {
					delay(2000);
					click(ele, "AddressList");
					break;
				} else if (getText(ele).contains("HOPE, BC")) {
					delay(2000);
					click(ele, "AddressList");
					break;
				}
				/*
				 * for (int i = 1; i < shipping.getAddListCA().size(); i++) { WebElement add =
				 * driver.findElement(By.xpath("//input[@name='line1']/following::div[2]/div[" +
				 * i + "]")); if (add.getText().contains(data)) { click(add, "Address Line1");
				 * break; } }
				 */
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

		addPaymentDetails(sheet, testCaseName);
		
		addAnotherBillAddress(sheet, testCaseName);
		domClick(guestBillPage.getReviewOrder(), "Review your order");

	}

	public static void addTumiStudio() {
		click(tumiId.getTumiIdDesign(), "TumiID");
		delay(5000);

		for (WebElement ele : tumiId.getMainBodyList()) {
			if (getText(ele).contains("Shadow Grey")) {
				click(ele, "MainBody color");
				break;
			}
		}
		click(tumiId.getFrontPocket(), "Front Pocket");
		delay(2000);

		for (WebElement ele : tumiId.getFrontPocketList()) {
			if (getText(ele).contains("Black")) {

				webclick(ele, "Front Pocket color");
				break;
			}
		}
		click(tumiId.getSidePocket(), "Side Pocket");
		delay(2000);

		for (WebElement ele : tumiId.getSidePocketList()) {
			if (getText(ele).contains("Atlantic")) {

				webclick(ele, "Side Pocket color");
				break;
			}
		}

		click(tumiId.getPatchnTag(), "Patch & Tag");
		delay(2000);

		for (WebElement ele : tumiId.getPatchnTagList()) {
			if (getText(ele).contains("TUMI red")) {

				domClick(ele, "Patch n Tag color");
				break;
			}
		}

		click(tumiId.getWebbing(), "Webbing");
		delay(2000);

		for (WebElement ele : tumiId.getWebbingList()) {
			if (getText(ele).contains("Black")) {

				domClick(ele, "Webbing color");
				break;
			}
		}

		click(tumiId.getLeatherAccents(), "Leather Accents");
		delay(2000);

		for (WebElement ele : tumiId.getLeatherAccentsList()) {
			if (getText(ele).contains("Atlantic")) {

				click(ele, "Leather Accents color");
				break;
			}
		}

		click(tumiId.getHardWare(), "Hard Ware");
		delay(2000);

		for (WebElement ele : tumiId.getHardwareList()) {
			if (getText(ele).contains("Gold")) {

				click(ele, "Hardware color");
				break;
			}
		}

		click(tumiId.getExternalZipper(), "External Zipper");
		delay(2000);

		for (WebElement ele : tumiId.getExternalZipperList()) {
			if (getText(ele).contains("Atlantic")) {

				click(ele, "External Zipper color");
				break;
			}
		}

		click(tumiId.getAccentZipper(), "Accent Zipper");
		delay(2000);

		for (WebElement ele : tumiId.getAccentZipperList()) {
			if (getText(ele).contains("Gold")) {

				click(ele, "Accent Zipper color");
				break;
			}
		}

		click(tumiId.getInteriorLining(), "Interior Lining");
		delay(2000);

		for (WebElement ele : tumiId.getinteriorLiningList()) {
			if (getText(ele).contains("Light Fossil")) {

				click(ele, "Interior Lining color");
				break;
			}
		}
		click(tumiId.getMonogram(), "tumiIdgramming");
		delay(2000);

		for (int i = 1; i <= 3; i++) {
			for (WebElement ele : tumiId.getFirstStepIntials()) {
				if (getText(ele).contains("2")) {
					delay(2000);
					click(ele, "Heart");
					break;
				}
			}
		}

		click(tumiId.getFirstNext(), "Next");

		for (WebElement ele : tumiId.getChooseColor()) {
			if (getText(ele).contains("White")) {
				delay(2000);
				click(ele, "color");
				break;
			}
		}

		click(tumiId.getSecondNext(), "Next");
		click(tumiId.getCheckBox(), "Check for both apply");
		click(tumiId.getApply(), "Apply");
		click(tumiId.getSaveDesign(), "Save");

	}

	public static void GiftCard(String sheet, String testCase) {
		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCase);
		final String pdpURL = GlobalConstants.S2 + "/p/" + testData.get("SKUID");
		driver.get(pdpURL);
		// Gift card
		click(guestBillPage.getGiftcardButton(), "Gift Card Button");

		input(guestBillPage.getGiftcard(), testData.get("GiftCardNo"), "Gift Card number");
		input(guestBillPage.getGiftpin(), testData.get("GiftPinNo"), "Gift Pin number");
		click(guestBillPage.getaddGiftcardApply(), "Gift Card Apply Button");
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
		domClick(guestBillPage.getReviewOrder(), "Review your order");

	}
	public static void AlternativeaddCardDetails(String sheet, String testCaseName) {

		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCaseName);
		Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "CreditCardDetails");
		Map<String, String> testData2 = ReadTestData.getJsonData("TumiTestData","AlternateOptions");
		// billing page
		input(guestBillPage.getNameOnCard(), testData.get("NameOnCard"), "Name on Card");

		// invalid card number
		input(guestBillPage.getCardNumber(), testData.get("CardNumber"), "Card Number");
		if (browserName.equals("firefox")) {
			selectMonthInFF();
			selectYearInFF();
		} else {
			selectByVisibleText(guestBillPage.getExpiryMonth(), testData.get("ExipryMonth"), "Expiry Month");
			selectByVisibleText(guestBillPage.getExpiryYear(), testData.get("ExpiryYear"), "Expiry Year");
		}
		input(guestBillPage.getCvvNumber(), testData.get("CVV"), "Cvv Number");
		input(guestBillPage.getemail(), testData.get("EmailID"), "Email ID");
		input(shipping.getPhoneNumber(), testData2.get("AlternatePh"), "Phone Number");
		domClick(guestBillPage.getReviewOrder(), "Review your order");
	}
	
	public static void addMonogram(WebElement edit, WebElement remove) {
		SoftAssert monoAsser = new SoftAssert();
		if (mono.getStep1().isDisplayed()) {
			if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
				if (mono.getAddPatch().isEnabled()) {
					domClick(mono.getAddTag(), "Tag");
					click(mono.getOptionsNext(), "Next..");
				} else {
					click(mono.getOptionsNext(), "Next..");
				}
			} else {
				click(mono.getOptionsNext(), "Next");
			}
		}

		click(mono.getFirstMonoInput(), "First option..");
		domClick(mainCart.getAddHeart(), "Heart Symbol");
		domClick(mainCart.getSmiley(), "Smiley Symbol");
		domClick(mainCart.getStar(), "Star Symbol");

		click(mono.getNext(), "Next");
		click(mono.getTextStyleBold(), "Serif as Bold");
		click(mono.getCafeColor(), "Color");
		click(mono.getApply(), "Apply");
		delay(3000);
		try {
			if (edit.isDisplayed()) {
				logger.log(Status.INFO, "Monogram added Successfully");
			}
		} catch (Exception e) {
			monoAsser.fail("Monogram couldn't added");
		}
		delay(3000);

		click(edit, "Edit Monogram");
		try {
			if (mono.getStep1().isDisplayed()) {
				click(mono.getOptionsNext(), "Next");
			}
		} catch (Exception e) {
		}
		click(mono.getSecondNext(), "Next");
		click(mono.getBlueColor(), "Color");
		click(mono.getApply(), "Apply");
		delay(3000);

		try {
			if (edit.isDisplayed()) {
				logger.log(Status.INFO, "Verification of Edit Monogram is Successfull");
		} 
		}catch (Exception e) {
			monoAsser.fail("Monogram couldn't be edited");
		}
		delay(2000);
		click(remove, "Remove");
		delay(2000);
		try {
			if (mainCart.getAddclassicMono().isDisplayed()) {
				logger.log(Status.INFO, "Verification of Remove Monogram is successfull");
			} 
		} catch (Exception e) {
			monoAsser.fail("Monogram couldn't be removed");
		}
		monoAsser.assertAll();

	}
	
	public static void addAnotherBillAddress(String sheet, String testCaseName) {
		Map<String, String> testData = ReadTestData.getJsonData(sheet, testCaseName);
		
		
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address line1");
		input(shipping.getTown(), testData.get("TownCity"), "Town");
		if (browserName.equals("firefox")) {
			selectStateInFF();
		} else if (selectedCountry.contains("Canada")) {
			Select dropdown = new Select(driver.findElement(By.name("regionIso")));
			dropdown.selectByVisibleText("British Columbia");
			click(shipping.getRegionIso(), "Region");
			input(shipping.getPostcode(), testData.get("CAPostCode"), "postal code");
		} else {

			Select dropdown = new Select(driver.findElement(By.name("regionIso")));
			dropdown.selectByVisibleText("New Jersey");
			click(shipping.getRegionIso(), "Region");
			input(shipping.getPostcode(), testData.get("PostCode"), "postal code");
		}
	}
  public static void addPaymentDetails(String sheet, String testCaseName) {
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
  }

}
