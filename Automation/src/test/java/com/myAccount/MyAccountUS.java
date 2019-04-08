package com.myAccount;

import static org.testng.Assert.assertTrue;
import java.util.Map;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;

public class MyAccountUS extends GenericMethods {
	
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "CreateAccount");

	@Test(priority = 0, description = "TA-324 Verify View Your Profile")
	public void verifyViewYourProfile() {
		
		userLogin("TumiTestData", "RegisteredOrders");

		click(home.getCurrentUser(), "Current User");
		
		click(myacc.getViewProfile(), "View Your Profile");
		
		String firstName = getAttributeValue(myacc.getProfileFirstName());
				
		verifyAssertEquals(firstName, testData.get("FirstName"));
		
		String surName = getAttributeValue(myacc.getProfileSurName());
		
		verifyAssertEquals(surName, testData.get("LastName"));
		
	}

	@Test(priority = 1, description = "TA-325 Purchased Items")
	public void verifyPurchasedItems() {
	
		userLogin("TumiTestData", "RegisteredOrders");

		click(home.getCurrentUser(), "Current User");
		
		click(myacc.getPurchasedItems(), "Purchased Items");
		
		if (getText(myacc.getMyPurchases()).equalsIgnoreCase("MY PURCHASES")) {

			logger.log(Status.INFO, "Purchased Items redirection is succesful");
		}
	}
	
	@Test(priority = 2, description = "TA-326 View Your Order Status")
	public void verifyViewYourOrderStatus() {
		
		userLogin("TumiTestData", "RegisteredOrders");

		click(home.getCurrentUser(), "Current User");
		
		click(myacc.getViewOrderStatus(), "View Order Status");

		assertTrue(myacc.getOrderStatusMessege().isDisplayed(), "Order Status Messege");
		
	}
	
	@Test(priority = 3, description = "TA-327 Register Your Tumi")
	public void verifyRegisterYourTumi() {
		
		userLogin("TumiTestData", "RegisteredOrders");

		click(home.getCurrentUser(), "Current User");
		
		click(myacc.getRegisterYourTumi(), "Register Your Tumi");
		
		assertTrue(myacc.getTumiTracerNumber().isDisplayed(), "Tumi Tracer Number");
		
	}
	
	@Test(priority = 4, description = "TA-328 Repair Services")
	public void verifyRepairServices() {
		
		userLogin("TumiTestData", "RegisteredOrders");

		click(home.getCurrentUser(), "Current User");
		
		click(myacc.getRepairServices(), "Repair Services");
		
		assertTrue(myacc.getRequestRepair().isDisplayed(), "Request Repair");

		assertTrue(myacc.getCheckRepairStatus().isDisplayed(), "Check Repair Status");
	}
		
		
}
