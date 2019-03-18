package webpages;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class ShippingMethodPage extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
	Map<String, String> voucher = ReadTestData.getJsonData("TumiTestData", "VoucherCodeDetails");
	Map<String, String> shipCharge = ReadTestData.getJsonData("TumiTestData", "ShippingCharges");
	Map<String, String> alternate = ReadTestData.getJsonData("TumiTestData", "AlternateOptions");

	@Test(description = "TA-62 Verify Shipping Method Page ")
	public void verifyShippingMethodPage() {

		goToShipMethodPage();
		verifyEdit();
		domClick(shipMethod.getStandardShippingMethod(), "Stanadard Shipping");
		if (selectedCountry.contains("US")) {
			usShippingVerification();
		} else if (selectedCountry.contains("Canada")) {
			caShippingVerification();
		} else {
			krShippingVerification();
		}

		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "VoucherCodeDetails");

		if (!getText(mainCart.getPromoSuccessMsg()).equals(getProperty("voucher.successmsg"))) {
			Assert.fail("Promocode couldn't be applied");
		}

		if (mainCart.getDiscountSummery().isDisplayed()) {
			logger.log(Status.INFO, "Promocode Discount has been added to Order Summery");
		} else {
			Assert.fail("Promocode has not added to Order Summery");
		}

		/*
		 * input(mainCart.getPromocode(),voucher.get("VoucherID"),"Promo Code");
		 * click(mainCart.getApply(),"Apply");
		 */

	}

	public void goToShipMethodPage() {
		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
	}

	public void usShippingVerification() {

		if (getText(shipMethod.getEstimatedShipFree()).contains("FREE")) {
			logger.log(Status.INFO, "Verification of Standard Shipping charge is Successfull");
		} else if (getText(shipMethod.getEstimatedShipping()).equals(shipCharge.get("UsStandardShippingCharge"))) {
			logger.log(Status.INFO, "Verification of Standard Shipping charge is Successfull");
		} else {
			Assert.fail("Verification of Standard Shipping charge is failed");
		}

		domClick(shipMethod.getPriorityShippingMethod(), "Priority Shipping");
		if (getText(shipMethod.getEstimatedShipping()).equals(shipCharge.get("PriorityShippingCharge"))) {
			logger.log(Status.INFO, "Verification of Priority Shipping charge is Successfull");
		} else {
			Assert.fail("Verification of Priority Shipping charge is failed");
		}

		domClick(shipMethod.getSecondDayShippingMethod(), "Second day Shipping");
		if (getText(shipMethod.getEstimatedShipping()).equals(shipCharge.get("SecondDayShippingCahrge"))) {
			logger.log(Status.INFO, "Verification of Second Day Shipping charge is Successfull");
		} else {
			Assert.fail("Verification of Second Day Shipping charge is failed");
		}

	}

	public void caShippingVerification() {

		if (getText(shipMethod.getEstimatedShipFree()).contains(shipCharge.get("CaStandardShippingCharge"))) {
			logger.log(Status.INFO, "Verification of Standard Shipping charge is Successfull");
		} else {
			Assert.fail("Verification of Standard Shipping charge is failed");
		}
	}

	public void krShippingVerification() {
		if (getText(shipMethod.getEstimatedShipFree()).contains(shipCharge.get("KrStandardShippingCharge"))) {
			logger.log(Status.INFO, "Verification of Standard Shipping charge is Successfull");
		} else {
			Assert.fail("Verification of Standard Shipping charge is failed");
		}
	}

	public void verifyEdit() {

		click(shipMethod.getEditAddress(), "Edit Address");

		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			input(shipping.getPhoneNumber(), alternate.get("AlternatePh"), "Phone Number");
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			if (getText(shipMethod.getAddInfo()).contains(alternate.get("AlternatePh"))) {
				logger.log(Status.INFO, "Phone number successfully updated");
			} else {
				Assert.fail("Update of Address details is failed");
			}

		} else {
			input(shipping.getPhoneNumber(), alternate.get("AlternatePhKr"), "Phone Number");

			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			if (getText(shipMethod.getAddInfo()).contains(alternate.get("AlternatePhKr"))) {
				logger.log(Status.INFO, "Phone number successfully updated");
			} else {
				Assert.fail("Update of Address details is failed");
			}
		}

	}

}
