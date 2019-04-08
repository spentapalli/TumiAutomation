package com.tumi.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;



/**
 * @author Shwetha  Capo
 *
 */
public class SinglePageCheckout extends GenericMethods{

	@Test(priority=0,description="TA- 414, Verify Sign In in Single page checkout page")
	public void verifySignIn() {
		goToSinglePage();
		BillingPage.loginAfterCart("TumiTestData", "RegisteredOrders");
		try {
			if(guestBillPage.getContinueInLogin().isDisplayed()) {
				click(guestBillPage.getContinueInLogin(),"Continue");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String url = driver.getCurrentUrl();
		if(url.contains("singlePageCheckout/shipping")) {
			logger.log(Status.PASS, "After sign in from single page, successfully  navigated to shipping page");
			if(shipping.getAddListFromSinglePage().size()>=2) {
				logger.log(Status.PASS, "In Shiiping page, Address list contain one default address");
			}else {
				logger.log(Status.INFO, "Shipping page doesn't contains any default address");
			}
		}else {
			Assert.fail("After Sign In, page couldn't navigated to Shipping Page");
		}
		
	}
	@Test(priority=1,description="TA- 437, Verify Sign In for Express checkout")
	public void verifyExpressCheckout() {
		goToSinglePage();
		
		expressLogin("TumiTestData", "ExpressCheckout");
		try {
			if(guestBillPage.getContinueInLogin().isDisplayed()) {
				click(guestBillPage.getContinueInLogin(),"Continue");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String url = driver.getCurrentUrl();
		if(url.contains("singlePageCheckout/shipping")) {
			logger.log(Status.PASS, "After sign in from Express checkout, successfully  navigated to shipping page");
			
		}else {
			Assert.fail("After Sign In from Express checkout, page couldn't navigated to Shipping Page");
		}
		
	}
	
	public static void goToSinglePage() {
		UIFunctions.addProductToCart("TumiTestData","Products");
		click(pdp.getAddToCart(),"Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		click(mainCart.getProceedCart(), "Proceed to Checkout");
	}
}
