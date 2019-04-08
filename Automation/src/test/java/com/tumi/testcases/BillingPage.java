package com.tumi.testcases;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

 
/**
 * @author Shwetha  Capo
 *
 */
public class BillingPage extends GenericMethods {
	
	/*
	 * TA -52, Verify Billing Page.
	 */

	@Test(priority = 0, description = "TA-52,TA- 415: Verify Sign-in functionality")
	public static void verifySignIn() {
		goToBillingPage();
		delay(3000);
		loginAfterCart("TumiTestData", "RegisteredOrders");
		

	}

	@Test(priority = 1, description = "TA-416, Verify that Redeem Tumi gift card can apply\r\n"+ "Verify Check balance in Tumi Gift cad, " + "TA- 418: Verify labels below Review your Order")
	
	public void verifyGiftCard() {
		Map<String, String> giftCard = ReadTestData.getJsonData("TumiTestData", "VoucherCodeDetails");
		SoftAssert giftcardAsser = new SoftAssert();

		goToBillingPage();
		verifyAccordions();
		if(selectedCountry.contains("US")) {
		click(guestBillPage.getGiftcardButton(), "Gift Card Button");

		input(guestBillPage.getGiftcard(), giftCard.get("AltGiftCardnumber"), "Gift Card number");
		input(guestBillPage.getGiftpin(), giftCard.get("AltPinNumber"), "Gift Pin number");
		click(guestBillPage.getCheckBal(), "Check Balance");
		delay(2000);
		if (guestBillPage.getAvailBalMsg().isDisplayed()) {
			logger.log(Status.INFO,
					"Checking Balance Message displayed, Verification of Checking balance is successfull");
		} else {
			giftcardAsser.fail("Checking Balance Message is not displayed, Verification of Check Balance is Failed");
		}
		click(guestBillPage.getaddGiftcardApply(), "Gift Card Apply Button");
		delay(2000);
		if(guestBillPage.getRemoveGift().isDisplayed()) {
			logger.log(Status.INFO, "Gift Card Applied Successfully");
		}else if(getText(guestBillPage.getLowBalMsg()).equals(getProperty("giftcard.lowbalmsg"))) {
			logger.log(Status.INFO, "Applied Gift Card balance is low, Please Recharge");
		}else if(getText(guestBillPage.getInvalidGift()).equals(getProperty("giftcard.invalid"))){
			logger.log(Status.INFO, "Invalid Card number or Pin Number");
		}else {
			giftcardAsser.fail("Verification of Gift card Failed or Gift card functionality not working");
		}
		click(guestBillPage.getRemoveGift(),"Remove Gift Card");
		}
		giftcardAsser.assertAll();
		
	}
	
	@Test(priority = 2, description = "TA-417, verify Use shipping address as billing address link")
	public void verifyBilingAddressLink() {
		try {
			goToBillingPage();
			delay(3000);
			domClick(guestBillPage.getShippingAddressAsBilling(),"Shipping address as Billing address");
			if(guestBillPage.getCountrySelector().isDisplayed()){
				logger.log(Status.INFO, "When click on Use ship address as bill addres, displaying all fields to enter details");
			}
		} catch (Exception e) {
				Assert.fail("When click on Use ship address as bill addres, not displaying all fields to enter details");
		}
	}
	
	@Test(priority = 3, description = "TA-419, verify PayPal link")
	public void verifyPayPalLik() {
		goToBillingPage();
		delay(2000);
		webclick(guestBillPage.getPayPal(),"PayPal button");
		try {
			if(guestBillPage.getBuyWithPayPal().isDisplayed()) {
				click(guestBillPage.getBuyWithPayPal(),"PayPal");
			if(paypal.getPayPalEmail().isDisplayed()) {
				logger.log(Status.INFO, "Clicking on PayPal, page is navigated to PayPal Window..");
			}
			}
		} catch (Exception e) {
				Assert.fail("Clicking on PayPal, page couldn't navigated to PayPal Window,Fail to Login due to " + e.getMessage());
		}
		
	}

	public static void goToBillingPage() {
		Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");

	}
	public static void loginAfterCart(String sheetname, String testcase) {
		try {
			Map<String, String> testData = ReadTestData.getJsonData(sheetname, testcase);

			click(home.getHeaderSignIn(), "Sign In");
			delay(2000);
			input(home.getUserName(), testData.get("EmailID"), "Email Address");
			input(home.getPassWord(), testData.get("Password"), "Password");
			click(home.getLogOn(), "Login");
			//delay(10000);
			elementToBeClickable(myacc.getSignout());
			try {
				if (guestBillPage.getItemsInCart().isDisplayed()||myacc.getSignout().isDisplayed()) {
					logger.log(Status.INFO, "Successfully logged with Regular user valid credentials");
				}

			} catch (Exception e) {
				Assert.fail("user signin is failed");
			}

		} catch (Exception e) {
			Assert.fail("Fail to Login due to " + e.getMessage());
		}
	}

	public static void verifyAccordions() {
		SoftAssert giftcardAsser = new SoftAssert();
		delay(3000);
		int accordionSize = guestBillPage.getAccordionBillList().size();
		if (!guestBillPage.getAccordionBillList().isEmpty()) {
			for (int i = 1; i <= accordionSize; i++) {
				WebElement ele = driver
						.findElement(By.xpath("//div[contains(@class,'checkoutAccordion')]/div[" + i + "]"));
				click(ele, i + "-Accordion");
				WebElement content = driver
						.findElement(By.xpath("//div[contains(@class,'checkoutAccordion')]/div[" + i + "]/div[2]"));
				if (content.isDisplayed()) {
					logger.log(Status.INFO, i + "-Accordion is enabled");
				} else {
					giftcardAsser.fail(i + "-Accordion is not enabled");
				}
			}
			logger.log(Status.INFO, "Verification of Billing page Accordions are successfull");
		} else {
			giftcardAsser.fail("Verification of Billing page Accordions is Failed");
		}
		giftcardAsser.assertAll();
	}
	
}
