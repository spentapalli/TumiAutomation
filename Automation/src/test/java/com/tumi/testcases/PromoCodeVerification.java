//sprint-5 
//TA_67 Verify Promo code
//
package com.tumi.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class PromoCodeVerification extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
	Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "VoucherCodeDetails");

	@Test(priority = 0, description = "TA-67 Verify Promo Code")
	public void VerifyPromoCodeCartPage() {
		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		UIFunctions.addPromotionalCodeAtCart("TumiTestData", "VoucherCodeDetails");

		if (mainCart.getPromoMsg().isDisplayed()) {
			logger.log(Status.INFO, "promo code applied succesfully");
		} else if (mainCart.getPromoMsg().isDisplayed()
				&& (getText(mainCart.getVoucherMsg()).equals(getProperty("voucher.alreadyapplied")))) {
			logger.log(Status.INFO, "Voucher already been applied successfully");

		} else if (getText(mainCart.getVoucherMsg()).equals(getProperty("voucher.error"))) {
		Assert.fail((getText(mainCart.getVoucherMsg())));

		} else if (getText(mainCart.getVoucherMsg()).equals(getProperty("voucher.wrong"))) {
			Assert.fail((getText(mainCart.getVoucherMsg())));

		} else {
			Assert.fail("Failed to add Voucher code");
	}
	}
	// @Test(priority=2)
	public void VerifyPromoCodeSinglePageCheckout() {
		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "VoucherCodeDetails");

		try {

			if (getText(mainCart.getPromoSuccessMsg()).equals(getProperty("voucher.successmsg"))) {
				logger.log(Status.INFO, "Promocode applied successfully");

			} else if (getText(mainCart.getPromoSuccessMsg()).equals(getProperty("voucher.alreadyapplied"))) {
				logger.log(Status.INFO, "Voucher already been applied successfully");
			} else if (getText(mainCart.getPromoSuccessMsg()).equals(getProperty("voucher.wrong"))) {
				logger.log(Status.INFO, "Voucher could not be Applied");
			}
		} catch (Exception e) {
			Assert.fail("Promocode couldn't be applied");
		}
		click(singlePage.getPromocodeRemove(), "Remove Promo Code");
		if (singlePage.getPromocodeMessage().isDisplayed()) {
			logger.log(Status.INFO, "Promo code is Successfully Removed");
		}
	}

	// @Test(priority=3)
	public void VerifyPromocodeShippingAddress() {

		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");

		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "VoucherCodeDetails");
		try {

			if (getText(mainCart.getPromoSuccessMsg()).equals(getProperty("voucher.successmsg"))) {
				logger.log(Status.INFO, "Promocode applied successfully");

			} else if (getText(mainCart.getPromoSuccessMsg()).equals(getProperty("voucher.alreadyapplied"))) {
				logger.log(Status.INFO, "Voucher already been applied successfully");
			} else if (getText(mainCart.getPromoSuccessMsg()).equals(getProperty("voucher.wrong"))) {
				logger.log(Status.INFO, "Voucher could not be Applied");
			}
		} catch (Exception e) {
			Assert.fail("Promocode couldn't be applied");
		}
		click(singlePage.getPromocodeRemove(), "Remove Promo Code");
		if (singlePage.getPromocodeMessage().isDisplayed()) {
			logger.log(Status.INFO, "Promo code is Successfully Removed");
		}

	}

}
