
//sprint-4
//TA-49 Verify OrderReview page 
package com.tumi.testcases;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class OrderReviewPageVerification extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
	Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "AlternateOptions");
	Map<String, String> shipCharge = ReadTestData.getJsonData("TumiTestData", "ShippingCharges");

	@Test(priority = 0, description = " Verify Product Link ")
	public void VerifySelectProduct() {
		OrderReviewPage();
		domClick(review.getProductSelect(), "Product Link");
		if (pdp.getProductLink().isDisplayed()) {
			logger.log(Status.INFO, "Successfully verified");
		}

	}

	@Test(priority = 1, description = "Verfiy the labels")
	public void VerifyLabels() {

		OrderReviewPage();
		if (selectedCountry.contains("US")) {
			VerifyUSlabel();
		} else if (selectedCountry.contains("Canada")) {
			VerifyCAlabel();
		}
	}

	public void VerifyUSlabel() {
		click(review.getLabel1(), "Label 1");
		if (review.getLabeldata1().isDisplayed())
			;
		logger.log(Status.INFO, "Verified First label");
		click(review.getLabel2(), "Label 2");
		if (review.getLabeldata2().isDisplayed())
			;
		logger.log(Status.INFO, "Verified second label");
		click(review.getLabel3(), "Label 3");
		if (review.getLabeldata3().isDisplayed())
			;
		logger.log(Status.INFO, "Verified third label");

	}

	public void VerifyCAlabel() {
		click(review.getCalabel1(), "Label 1");
		if (review.getCaLabeldata1().isDisplayed())
			;
		logger.log(Status.INFO, "Verified First label");
		click(review.getCalabel2(), "Label 2");
		if (review.getLabeldata2().isDisplayed())
			;
		logger.log(Status.INFO, "Verified second label");
		click(review.getCalabel3(), "Label 3");
		if (review.getCaLabeldata3().isDisplayed())
			;
		logger.log(Status.INFO, "Verified third label");

	}

	@Test(priority = 2, description = "Verify Shipping Method data")
	public void VerifyShippingMethod() {
		OrderReviewPage();
		if (selectedCountry.contains("US")) {
			VerifyUSShippingmethod();
		} else if (selectedCountry.contains("Canada")) {
			VerifyCAShippingMethod();

		}
	}

	public void VerifyUSShippingmethod() {
		domClick(review.getEditShippingMethod(), "Edit shipping Address");
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");

		domClick(shipMethod.getPriorityShippingMethod(), "change shipping method");

		delay(3000);
		String StandardGround = getText(shipMethod.getStandardGround());
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		String ShippingMethod = getText(review.getShippingMethod());
		delay(3000);
		if (StandardGround.equals(ShippingMethod)) {
			logger.log(Status.INFO, "Verified Shipping methods");
		} else {
			Assert.fail("Shipping method  is not verified");
		}
	}

	public void VerifyCAShippingMethod() {
		domClick(review.getEditShippingMethod(), "Edit shipping Address");
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		domClick(shipMethod.getCaStandardShippingMethod(), "change shipping method");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");

		String StandardGround = getText(shipMethod.getCaShippingmethod());
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");

		String ShippingMethod = getText(review.getShippingMethod());
		if (StandardGround.equals(ShippingMethod)) {
			logger.log(Status.INFO, "Verified Shipping methods");
		} else {
			Assert.fail("Shipping method  is not verified");
		}
	}

	@Test(priority = 4, description = "Verify Shipping address")
	public void VerifyShippingAddress() {
		OrderReviewPage();
		domClick(review.getEditShippingAddress(), "Edit shipping Address");
		input(shipping.getPhoneNumber(), testData1.get("AlternatePh"), "Phone Number");
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		delay(3000);

		String address = getText((review.getShippingAddress()));
		if (getText(review.getShippingAddress()).contains((testData1.get("AlternatePh")))) {

			logger.log(Status.INFO, "Verified Payment Details");
		} else {
			Assert.fail("Payment details is not verified");
		}
		delay(2000);

	}

	@Test(priority = 3)
	public void VerifyPaymentDetails() {
		OrderReviewPage();
		domClick(review.getEditPayment(), "Edit shipping Address");
		UIFunctions.AlternativeaddCardDetails("TumiTestData", "CreditCardDetails");
		delay(3000);
		String phone = getText((review.getPaymentDetails()));
		if (getText(review.getPaymentDetails()).contains((testData1.get("AlternatePh")))) {
			logger.log(Status.INFO, "Verified Payment Details");
		} else {
			Assert.fail("Payment details is not verified");
		}
	}

	@Test(priority = 5, description = "Verify Order summary")
	public void VerifyOrderSummary() {

		if (selectedCountry.contains("US")) {
			usShipmethodChargers();
		} else if (selectedCountry.contains("Canada")) {
			caShipmethodChargers();
		}
	}

	public void usShipmethodChargers() {
		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");

		delay(3000);
		String ShippingCharges = getText(shipMethod.getShippingFree());
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		delay(3000);
		String ShippingMethod = getText(review.getShippingCharges());
		delay(3000);
		if (ShippingCharges.equals(ShippingMethod)) {
			logger.log(Status.INFO, "Verified Shipping methods");
		} else {
			Assert.fail("Shipping method  is not verified");
		}
	}

	public void caShipmethodChargers() {
		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");

		delay(3000);
		String ShippingCharges = getText(shipMethod.getCaShippingFree());
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		String ShippingMethod = getText(review.getShippingCharges());
		delay(3000);
		if (ShippingCharges.equals(ShippingMethod)) {
			logger.log(Status.INFO, "Verified Shipping methods");
		} else {
			Assert.fail("Shipping method  is not verified");
		}
	}

	public void OrderReviewPage() {
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
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		delay(3000);
	}
}
