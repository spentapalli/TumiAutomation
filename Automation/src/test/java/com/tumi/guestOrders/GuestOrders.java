package com.tumi.guestOrders;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Suresh , Shwetha Capo
 *
 */
public class GuestOrders extends GenericMethods {
	
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
	Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "FailedOrder");
	/*
	 * TA-57 Verify Order with merchandise Ready to ship for Guest User
	 */

	@Test(priority = 0, description = " TA- 57 Verify Order with merchandise Ready to ship for Guest User")
	public void tumiOrderAsGuest() throws InterruptedException {
		logger.log(Status.INFO, "Test(s) are running in "+URL);
		UIFunctions.addProductToCart("TumiTestData","Products");
		UIFunctions.closeSignUp();
		click(pdp.getAddToCart(), "Add to cart");
		
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		if (applicationUrl.equals("prod")) {
			driver.findElement(By.xpath("//button[contains(text(),'Proceed to Checkout')]")).click();
		}else {
			webclick(mainCart.getProceedCart(), "Proceed to Checkout");
		}
		
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Continue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Continue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
	}

	//@Test(priority = 1, description = " TA-16 Verify Order with merchandise Back Order + "
	//+ "Gift Boxing + Gift Message + Voucher/Promos for Guest User")
	public void backOrderAsGuest() throws Exception {

		UIFunctions.addProduct("TumiTestData", "Products","BackOrderProduct");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData","VoucherCodeDetails");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Continue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Continue  Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
	}

//	@Test(priority = 2, description = "TA- 112,Verify Order with merchandise Pre Order for Guest User")
	public void preOrderAsGuest() throws InterruptedException {

		UIFunctions.addProduct("TumiTestData", "Products","PreOrderProduct");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Continue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Continue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
	}

	//@Test(priority = 3, description = "TA_11 Verify Order with Donation purchase")
	public void donationPurchaseOrderAsGuest() {

		UIFunctions.addProductToCart("TumiTestData","DonationPurchase");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Continue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Continue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
	}
}
