package com.tumi.guestOrders;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

/**
 * @author Shwetha Capo
 *
 */
public class OrderWithGiftBox extends GenericMethods {

	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");

	@Test(priority = 1, description = " TA-99 Verify Order with merchandise Back Order + Gift Boxing for Guest User")
	public void backOrderWithGiftBox() {

		UIFunctions.addProduct("TumiTestData", "BackOrderProduct", "BackSKUID");
		click(pdp.getAddToCart(), "Add to cart");

		if (browserName.equals("mobile")) {
			driver.findElement(By.xpath("//span[@id='cart_content']")).click();
			scrollDown(500);
			mainCart.getProceedCart().click();
		} else {
			click(minicart.getProceedCheckOut(), "Proceed to Cart");
			click(gift.getMakeThisGift(), "Make this Gift");
			UIFunctions.addGiftBox();
			click(gift.getContinueGiftService(), "Continue");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
		}
		if (!(selectedCountry.equals("US") && !(selectedCountry.contains("United States")) && !(selectedCountry.contains("Canada")))) {
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		}
		UIFunctions.addGuestDetails();
		if (!shipping.getContinueShippingMethod().isEnabled()) {
			UIFunctions.addGuestDetails();
		} else {
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		}
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();

	}

	@Test(priority = 2, description = "TA-109 Verify Order with merchandise Back Order for Guest ")
	public void backOrderAsGuest() {
		UIFunctions.addProduct("TumiTestData", "BackOrderProduct", "BackSKUID");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedCart(), "Proceed to Checkout");

		UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "VoucherCodeDetails");
		if (!(selectedCountry.equals("US") && !(selectedCountry.contains("United States")) && !(selectedCountry.contains("Canada")))) {
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		}
		UIFunctions.addGuestDetails();
		if (!shipping.getContinueShippingMethod().isEnabled()) {
			UIFunctions.addGuestDetails();
		} else {
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		}
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
	}

	@Test(priority = 3, description = " TA- 47 Verify Order with merchandise Ready to ship "
			+ "+ Gift Boxing for Guest User")
	public void orderWithGiftBoxAsGuest() throws Exception {
		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "continue");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		if (!(selectedCountry.equals("US") && !(selectedCountry.contains("United States")) && !(selectedCountry.contains("Canada")))) {
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		}
		UIFunctions.addGuestDetails();
		if (!shipping.getContinueShippingMethod().isEnabled()) {
			UIFunctions.addGuestDetails();
		} else {
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		}
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
	}

	@Test(priority = 4, description = " TA - 53 Verify Order with merchandise Ready to ship + Gift Boxing "
			+ "+ Gift Message for Guest User")
	public void orderWithGiftBoxnMsgAsGuest() throws Exception {
		UIFunctions.addProductToCart("TumiTestData", "Products");
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "VoucherCodeDetails");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		if (!(selectedCountry.equals("US") && !(selectedCountry.contains("United States")) && !(selectedCountry.contains("Canada")))) {
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		}
		UIFunctions.addGuestDetails();
		if (!shipping.getContinueShippingMethod().isEnabled()) {
			UIFunctions.addGuestDetails();
		} else {
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		}
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
	}

	@Test(priority = 5, description = " TA- 107 Verify Order with merchandise Pre Order + Gift Boxing for Guest user")
	public void preOrderWithGiftBoxAsGuest() throws Exception {

		if (applicationUrl.equals("prod")) {
			logger.log(Status.WARNING, "Pre Order Products are not available in production");
		} else {

			UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(gift.getMakeThisGift(), "Make this Gift");
			UIFunctions.addGiftBox();
			click(gift.getContinueGiftService(), "Continue");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			if (!(selectedCountry.equals("US") && !(selectedCountry.contains("United States")) && !(selectedCountry.contains("Canada")))) {
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			UIFunctions.waitForContinueToEnable();
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			}
			UIFunctions.addGuestDetails();
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
			UIFunctions.completeOrder();
		}

	}

	@Test(priority = 6, description = " TA-3 Verify Order with merchandise Pre Order + Gift Boxing + Gift Message-Guest user")
	public void preOrderWithGiftBoxnMsgAsGuest() throws Exception {
		if (applicationUrl.equals("prod")) {
			logger.log(Status.WARNING, "Pre Order Products are not available in production");
		} else {
			UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getProceedCheckOut(), "Proceed to Cart");
			click(gift.getMakeThisGift(), "Make this Gift");
			UIFunctions.addGiftMessage("TumiTestData", "VoucherCodeDetails");
			UIFunctions.addGiftBox();
			click(gift.getContinueGiftService(), "Continue");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			if (!(selectedCountry.equals("US") && !(selectedCountry.contains("United States")) && !(selectedCountry.contains("Canada")))) {
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			UIFunctions.waitForContinueToEnable();
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			}
			UIFunctions.addGuestDetails();
			if (!shipping.getContinueShippingMethod().isEnabled()) {
				UIFunctions.addGuestDetails();
			} else {
				click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			}
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
			UIFunctions.completeOrder();
		}
	}

	@Test(priority = 7, description = " TA- 12 Verify Order with merchandise Pre Order + Gift Boxing "
			+ "+ Gift Message + Voucher/Promos-Guest User")
	public void preOrderWithGiftBoxnMsgVocher() {

		if (applicationUrl.equals("prod")) {
			logger.log(Status.WARNING, "Pre Order Products are not available in production");
		} else {

			UIFunctions.addProductToCart("TumiTestData", "PreOrderProduct");
			click(pdp.getAddToCart(), "Add To Cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(gift.getMakeThisGift(), "Make this Gift");
			UIFunctions.addGiftMessage("TumiTestData", "VoucherCodeDetails");
			UIFunctions.addGiftBox();
			click(gift.getContinueGiftService(), "Continue");
			// UIFunctions.addPromotionalCodeAtCart("TumiTestData", "PreOrderProduct");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			if (!(selectedCountry.equals("US") && !(selectedCountry.contains("United States")) && !(selectedCountry.contains("Canada")))) {
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "VoucherCodeDetails");
			UIFunctions.waitForContinueToEnable();
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			}
			UIFunctions.addGuestDetails();
			if (!shipping.getContinueShippingMethod().isEnabled()) {
				UIFunctions.addGuestDetails();
			} else {
				click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			}
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
			UIFunctions.completeOrder();
		}
	}

	@Test(priority = 8, description = "TA-96 Verify Order with merchandise Back Order + Gift Boxing + Gift Message ")
	public void backOrderWithGiftBoxNMsgAsGuest() {
		UIFunctions.addProduct("TumiTestData", "BackOrderProduct", "BackSKUID");
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(gift.getMakeThisGift(), "Make this Gift");
		UIFunctions.addGiftMessage("TumiTestData", "VoucherCodeDetails");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
		if (!(selectedCountry.equals("US") && !(selectedCountry.contains("United States")) && !(selectedCountry.contains("Canada")))) {
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		}
		UIFunctions.addGuestDetails();
		if (!shipping.getContinueShippingMethod().isEnabled()) {
			UIFunctions.addGuestDetails();
		} else {
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		}
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("TumiTestData", "CreditCardDetails");
		UIFunctions.completeOrder();
	}

}
