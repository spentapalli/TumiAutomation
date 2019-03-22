package webpages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;
import com.tumi.webPages.PayPalPage;

public class BillingPage extends GenericMethods {

	@Test(priority = 0, description = "TA-52, Verify Sign-in functionality")
	public void verifySignIn() {
		goToBillingPage();

		userLogin("TumiTestData", "RegisteredOrders");

	}

	@Test(priority = 1, description = "TA-52, Verify that Redeem Tumi gift card can apply\r\n"
			+ "Verify Check balance in Tumi Gift cad, " + " Verify labels below Review your Order")
	public void verifyGiftCard() {
		Map<String, String> giftCard = ReadTestData.getJsonData("TumiTestData", "VoucherCodeDetails");
		SoftAssert giftcardAsser = new SoftAssert();

		goToBillingPage();
		verifyAccordions();

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
		
		//Verify Paypal Link
		
		webclick(guestBillPage.getPayPal(),"PayPal ");
		if(paypal.getLogin().isDisplayed()) {
			logger.log(Status.INFO, "Clicking on PayPal, page is navigated to PayPal Window");
		}else {
			giftcardAsser.fail("Clicking on PayPal, page couldn't navigated to PayPal Window");
		}
		
		
		
		giftcardAsser.assertAll();
		
	}

	public void goToBillingPage() {
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

	public void verifyAccordions() {
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
	}

}
