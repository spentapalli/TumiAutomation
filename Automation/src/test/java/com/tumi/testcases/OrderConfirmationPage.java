
	//sprint-4
		//TA-45 Verify Order Confirmation page 
	package com.tumi.testcases;

		import static org.testng.Assert.assertEquals;

		import java.util.List;
		import java.util.Map;

		import org.openqa.selenium.WebElement;
		import org.testng.Assert;
		import org.testng.annotations.Test;

		import com.aventstack.extentreports.Status;
		import com.tumi.dataProvider.ReadTestData;
		import com.tumi.utilities.GenericMethods;
		import com.tumi.utilities.UIFunctions;

		public class OrderConfirmationPage extends GenericMethods {
			
			Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "CreateAccount");
			Map<String, String> testData = ReadTestData.getJsonData("TumiTestData","GuestDetails");
			private String email;
			private String string;
			
			
		
		@Test(priority = 1,description = " Verify Order Confirmation page")
			public void VerifyCreateAccount() {
				
				Placeorder();
				delay(3000);
				orderNumber = getText(confirmation.getOrderNumber());
				logger.log(Status.INFO, "Thank you for Your Order, here is your Order Number " + orderNumber);
				click(confirmation.getCreateAccount(),"Create Account");
				 email= testData1.get("EmailID")+randomNumber()+ "@gmail.com";
					userAccount(email);
					}

		@Test(priority = 0,description ="Verify the product Link")
		public void VerifyProductLink() {
			Placeorder();
			delay(4000);
			domClick(confirmation.getProductLink(),"Select link");
			
			if(pdp.getProductLink().isDisplayed()){
			logger.log(Status.INFO,"Successfully verified");
			}
		}
		@Test(priority = 2,description = "Verify the Shipping method")
		public void VerifyShippingMethod() {
		if (selectedCountry.contains("US")) {
			VerifyUSShippingMethod();
		} else if (selectedCountry.contains("Canada")) {
			VerifyCaShippingMethod();
		}
		}
		public void VerifyUSShippingMethod() {
			UIFunctions.addProductToCart("TumiTestData","Products");
			click(pdp.getAddToCart(),"Add to cart");
			click(minicart.getProceedCheckOut(), "Proceed to Cart");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			UIFunctions.waitForContinueToEnable();
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			UIFunctions.addGuestDetails();
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getPriorityShippingMethod(),"Shipping  method");
			String Shipmethod= getText(shipMethod.getStandardGround());
			 delay(4000);
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData","CreditCardDetails");
			domClick(review.getPlaceOrder(), "Place Order");
			delay(5000);
			  String ShippingMethod= getText(confirmation.getShippingMethods());
			
	           if(Shipmethod.equals(ShippingMethod)) {
				 logger.log(Status.INFO,"Verified Shipping methods");
			 }else {
				 Assert.fail("Shipping method  is not verified");
			 }
			
		}
	         public void VerifyCaShippingMethod() {
	       		UIFunctions.addProductToCart("TumiTestData","Products");
	    		click(pdp.getAddToCart(),"Add to cart");
	    		click(minicart.getProceedCheckOut(), "Proceed to Cart");
	    		click(mainCart.getProceedCart(), "Proceed to Checkout");
	    		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
	    		UIFunctions.waitForContinueToEnable();
	    		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
	    		UIFunctions.addGuestDetails();
	    		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
	    		click(shipMethod.getCaStandardShippingMethod(),"Shipping  method");
	    		
	    		 String CaShipMethod= getText(shipMethod.getCaShippingmethod());
	    		
	    		 delay(4000);
	    		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
	    		UIFunctions.addCardDetails("TumiTestData","CreditCardDetails");
	    		domClick(review.getPlaceOrder(), "Place Order");
	    		delay(4000);
	    		 String CaShippingMethod= getText(confirmation.getShippingMethods());
	    		
	               if(CaShipMethod.equals(CaShippingMethod)) {
	    			 logger.log(Status.INFO,"Verified Shipping methods");
	    		 }else {
	    			 Assert.fail("Shipping method  is not verified");
	    			}
	       	
	       	}
		
			
		
			
		@Test(priority = 3,description = "Verify the Shipping Address and Payment details")
		public void VerifyShippingDetails() {
			Placeorder() ;	
			 delay(6000);
			
			 if(getText(confirmation.getProductPaymentDetails()).contains((testData.get( "Phone")))){ 
				 logger.log(Status.INFO,"Verified Payment Details"); 
				 }else {
			  Assert.fail("Payment details is not verified"); 

				 if(getText(confirmation.getShipppingAddress()).contains((testData.get( "Phone")))){ 
					 logger.log(Status.INFO,"Verified Shipping address Details"); 
					 }else {
				  Assert.fail("Shipping address is not verified"); 
			  }
		}
		
		}
	public void userAccount(String Data) {

			input(register.getRegisterEmail(), Data, "Email ID");
			input(register.getRegisterPassword(), testData1.get("Password"), "Password");
			input(register.getRegisterCheckPassword(), testData1.get("ConfirmPassword"), "Confirm Password");
			input(register.getRegisterFName(), testData1.get("FirstName"), "First Name");
			input(register.getRegisterLName(), testData1.get("LastName"), "Last Name");
			domClick(register.getRegisterSubscribe(), "Activate Promotions");
				click(register.getSubmitAccount(), "Submit Account Details");
				logger.log(Status.INFO, "Successfully Order Is placed");
				delay(3000);
				driver.close();
			}






		public void Placeorder() {
			UIFunctions.addProductToCart("TumiTestData","Products");
			click(pdp.getAddToCart(),"Add to cart");
			click(minicart.getProceedCheckOut(), "Proceed to Cart");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			UIFunctions.waitForContinueToEnable();
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			UIFunctions.addGuestDetails();
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData","CreditCardDetails");
			domClick(review.getPlaceOrder(), "Place Order");
			delay(4000);
			}
			}







