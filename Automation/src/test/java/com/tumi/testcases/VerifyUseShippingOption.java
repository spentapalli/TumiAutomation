package com.tumi.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class VerifyUseShippingOption extends GenericMethods{
	
	@Test(priority=0 , description= "TA- 404, Verify that Billing address and Shipping address are same, if ‘Use Shipping address as Billing’ is checked")
	public void verifyUseShipWhenCheck() {
		BillingPage.goToBillingPage();
		UIFunctions.addCardDetails("TumiTestData","CreditCardDetails");
		delay(3000);
		String shipAddr = getText(review.getShipAddress());
		String billAddr = getText(review.getBillAddress());
		
		if(billAddr.equalsIgnoreCase(shipAddr)){
			logger.log(Status.PASS, "Billing address and shipping address are same when 'Use ship as bill' selected");
		}else {
			Assert.fail("Billing address and shipping address are different when 'Use ship as bill' selected");
		}
	}
		
		@Test(priority=1 , description= "TA- 404, Verify that Billing address and Shipping address are same, if ‘Use Shipping address as Billing’ is un checked")
		public void verifyUseShipWhenUnCheck() {
			BillingPage.goToBillingPage();
			
			UIFunctions.addPaymentDetails("TumiTestData","CreditCardDetailsMultishipmnet");
			domClick(guestBillPage.getShippingAddressAsBilling(),"Use Ship address as Bill address");
			UIFunctions.addAnotherBillAddress("TumiTestData","CreditCardDetailsMultishipmnet");
			domClick(guestBillPage.getReviewOrder(), "Review your order");
			
			delay(3000);
			String shipAddr = getText(review.getShipAddress());
			String billAddr = getText(review.getBillAddress());
			
			if(!billAddr.equalsIgnoreCase(shipAddr)){
				logger.log(Status.PASS, "Billing address and shipping address are different when 'Use ship as bill' not selected");
			}else {
				Assert.fail("Billing address and shipping address are same when 'Use ship as bill' not selected");
			}
			
		}

		
	
	
}
