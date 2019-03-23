package com.tumi.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class ShippingMethodPage extends GenericMethods {
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
	Map<String, String> voucher = ReadTestData.getJsonData("TumiTestData", "VoucherCodeDetails");
	Map<String, String> shipCharge = ReadTestData.getJsonData("TumiTestData", "ShippingCharges");
	Map<String, String> alternate = ReadTestData.getJsonData("TumiTestData", "AlternateOptions");

	@Test(priority = 0, description = "TA-62 Verify Shipping Method Page, "+" Update address deatils and verify Shipping charges")
	public void verifyShippingMethodPage() {
		SoftAssert shipPageAssertions = new SoftAssert();
		goToShipMethodPage();

		// Verify update the address details
		verifyEdit();

		// Verify Shipping Charges
		domClick(shipMethod.getStandardShippingMethod(), "Stanadard Shipping");
		if (selectedCountry.contains("US")) {
			usShippingVerification();
		} else if (selectedCountry.contains("Canada")) {
			caShippingVerification();
		} else {
			krShippingVerification();
		}
		shipPageAssertions.assertAll();
	}

	@Test(priority = 1, description = "TA-62 Verify Promo Code in Shipping Method Page")
	public  void verifyPromoCode() {

		goToShipMethodPage();
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "VoucherCodeDetails");
		if (singlePage.getPromocodeRemove().isDisplayed()) {
			logger.log(Status.INFO, "Promocode applied successfully");
		} else if (getText(mainCart.getPromoSuccessMsg()).equals(getProperty("voucher.successmsg"))) {
			logger.log(Status.INFO, "Promocode applied successfully");
		} else if ((mainCart.getPromoSuccessMsg()).equals(getProperty("voucher.alreadyapplied"))) {
			logger.log(Status.INFO, "Voucher already been applied successfully");
		} else {
			Assert.fail("Promocode couldn't be applied");
		}

		if (mainCart.getDiscountSummery().isDisplayed()) {
			logger.log(Status.INFO, "Promocode Discount has been added to Order Summery");
		} else {
			Assert.fail("Promocode has not added to Order Summery");
		}

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
		delay(2000);
	}

	public void usShippingVerification() {
		SoftAssert shipPageAssertions = new SoftAssert();

		String beforeTotal = getText(shipMethod.getBeforeTotal());
		Double beforeCost = Double.valueOf(beforeTotal.replace("$", ""));
		System.out.println("Before select Price = " + beforeCost);

		if (getText(shipMethod.getEstimatedShipFree()).contains("FREE")
				|| (getText(shipMethod.getEstimatedShipping()).equals(shipCharge.get("UsStandardShippingCharge")))) {

			String afterTotal = getText(shipMethod.getBeforeTotal());
			Double afterCost = Double.valueOf(afterTotal.replace("$", ""));
			System.out.println("After selecting Standard, Price = " + afterCost);

			if (beforeCost.equals(afterCost)) {

				logger.log(Status.INFO, "Verification of Standard Shipping charge is Successfull");

			} else {
				shipPageAssertions.fail("Verification of Standard Shipping charge is failed due to ");
			}
		}

		System.out.println("Before select Price = " + beforeCost);

		domClick(shipMethod.getPriorityShippingMethod(), "Priority Shipping");
		delay(2000);

		if (getText(shipMethod.getEstimatedShipping()).equals(shipCharge.get("PriorityShippingCharge"))) {

			String afterTotal = getText(shipMethod.getBeforeTotal());
			Double afterCost = Double.valueOf(afterTotal.replace("$", ""));
			System.out.println("After selecting Priority, Price = " + afterCost);

			String priority = getText(shipMethod.getPrioritycharge());
			Double priCharge = Double.valueOf(priority.replace("$", ""));
			System.out.println("Priority charge = " + priCharge);

			Double verifiyCharge = afterCost - beforeCost;
			System.out.println("Verifictaion Cost = " + verifiyCharge);

			if (priCharge.equals(verifiyCharge)) {

				logger.log(Status.INFO, "Verification of Standard Shipping charge is Successfull");
			} else {
				shipPageAssertions.fail("Standard Shipping Charge not added or verification of Order summery values failed after applying Satndard charge");
			}
			
		}

		System.out.println("Before select Price = " + beforeCost);

		domClick(shipMethod.getSecondDayShippingMethod(), "Second day Shipping");
		delay(2000);
		if (getText(shipMethod.getEstimatedShipping()).equals(shipCharge.get("SecondDayShippingCahrge"))) {

			String afterTotal = getText(shipMethod.getBeforeTotal());
			Double afterCost = Double.valueOf(afterTotal.replace("$", ""));
			System.out.println("After selecting Second day, Price = " + afterCost);

			String second = getText(shipMethod.getSecondShippingCharge());
			Double secondCharge = Double.valueOf(second.replace("$", ""));
			System.out.println("Seconda day charge = " + secondCharge);

			Double verifiyCharge = afterCost - beforeCost;
			System.out.println("Verifictaion Cost = " + verifiyCharge);

			if (secondCharge.equals(verifiyCharge)) {

				logger.log(Status.INFO, "Verification of Second Day Shipping charge is Successfull");
			} else {
				shipPageAssertions.fail("Second Day Shipping Charge not added or verification of Order summery values failed after applying SecondDay charge");
			}
		}
		shipPageAssertions.assertAll();

	}

	public void caShippingVerification() {
		SoftAssert shipPageAssertions = new SoftAssert();
		String subTotal = getText(shipMethod.getCaSubTotal());
		Double subCost = Double.valueOf(subTotal.replace("$", ""));
		System.out.println("Before select Price = " + subCost);

		if (getText(shipMethod.getEstimatedShipFree()).contains(getText(shipMethod.getCAStandardShippingCharge()))) {
			
			String estimatedTotal = getText(shipMethod.getBeforeTotal());
			Double total = Double.valueOf(estimatedTotal.replace("$", ""));
			System.out.println("After selecting Standard, Price = " + total);

			String standard = getText(shipMethod.getCAStandardShippingCharge());
			Double standardCharge = Double.valueOf(standard.replace("$", ""));
			System.out.println("Standard charge = " + standardCharge);

			Double verifiyCharge = Math.round((total - subCost) * 100D) / 100D;
			System.out.println("Verifictaion Cost = " + verifiyCharge);

			if (standardCharge.equals(verifiyCharge)) {

				logger.log(Status.INFO, "Verification of Standard Shipping charge is Successfull");
			} else {
				shipPageAssertions.fail("Standard Shipping Charge not added or verification of Order summery values failed after applying Standard charge");
			}
		}
		shipPageAssertions.assertAll();
	}

	public void krShippingVerification() {
		SoftAssert shipPageAssertions = new SoftAssert();
		String subTotal = getText(shipMethod.getCaSubTotal());
		if(subTotal.contains(",")) {
			subTotal=subTotal.replace(",", "");
		}
		Double subCost = Double.valueOf(subTotal.replace("₩", ""));
		System.out.println("Before select Price = " + subCost);
		
			String estimatedTotal = getText(shipMethod.getBeforeTotal());
			if(estimatedTotal.contains(",")) {
				estimatedTotal=estimatedTotal.replace(",", "");
			}
			Double total = Double.valueOf(estimatedTotal.replace("₩", ""));
			System.out.println("After selecting Standard, Price = " + total);

			String standard = getText(shipMethod.getKrStandardShippingCharge());
			if(standard.contains(",")) {
				standard=standard.replace(",", "");
			}
			Double standardCharge = Double.valueOf(standard.replace("₩", ""));
			System.out.println("Standard charge = " + standardCharge);
			
			Double verifiyCharge =  total - subCost;
			System.out.println("Verifictaion Cost = " + verifiyCharge);

			if (standardCharge.equals(verifiyCharge)) {

				logger.log(Status.INFO, "Verification of Standard Shipping charge is Successfull");
			} else {
				shipPageAssertions.fail("Standard Shipping Charge not added or verification of Order summery values failed after applying Standard charge");
			}
			shipPageAssertions.assertAll();
			
		}
	

	public void verifyEdit() {
		SoftAssert shipPageAssertions = new SoftAssert();

		click(shipMethod.getEditAddress(), "Edit Address");

		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			input(shipping.getPhoneNumber(), alternate.get("AlternatePh"), "Phone Number");
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			if (getText(shipMethod.getAddInfo()).contains(alternate.get("AlternatePh"))) {
				logger.log(Status.INFO, "Phone number successfully updated");
			} else {
				shipPageAssertions.fail("Update of Address details is failed");
			}

		} else {
			input(shipping.getPhoneNumber(), alternate.get("AlternatePhKr"), "Phone Number");

			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			if (getText(shipMethod.getAddInfo()).contains(alternate.get("AlternatePhKr"))) {
				logger.log(Status.INFO, "Phone number successfully updated");
			} else {
				shipPageAssertions.fail("Update of Address details is failed");
			}
		}
		shipPageAssertions.assertAll();

	}

}
