//sprint-5 
	//TA_67 Verify Promo code

	package com.tumi.testcases;

		import static org.testng.Assert.assertEquals;

		import java.util.Map;

	import org.testng.Assert;
	import org.testng.annotations.Test;

		import com.aventstack.extentreports.Status;
		import com.tumi.dataProvider.ReadTestData;
		import com.tumi.utilities.GenericMethods;
		import com.tumi.utilities.UIFunctions;


		public class PromoCodeVerification extends GenericMethods{
			Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
			Map<String, String> testData1 = ReadTestData.getJsonData("TumiTestData", "VoucherCodeDetails");
					
			//@Test(priority = 0, description="TA-67 Verify Promo Code")
			public void VerifyPromoCodeCart() {

				UIFunctions.addProductToCart("TumiTestData","Products");
				click(pdp.getAddToCart(),"Add to cart");
				click(minicart.getProceedCheckOut(), "Proceed to Cart");
				click(mainCart.getApply(), "Check Promocode");
				if(mainCart.getErrorPromoMsg().isDisplayed()){
				logger.log(Status.INFO,"Promo code is not Entered");
		     UIFunctions.addPromotionalCodeAtCart("TumiTestData", "VoucherCodeDetails");
				if(mainCart.getPromoMsg().isDisplayed())
						logger.log(Status.INFO,"Promo Code is applied Successfully ");
				}else {
					Assert.fail("Promo code is not applied");
					delay(2000);
					input(mainCart.getPromocode(), testData1.get("VoucherID"), "Vocher Id");
					click(mainCart.getApply(), "Check Promocode");
					delay(2000);
					if(mainCart.getErrorPromoMsg().isDisplayed()) {
						logger.log(Status.INFO,"A COUPON OF THE SAME CAMPAIGN HAS ALREADY BEEN APPLIED TO THE CART");
						click(mainCart.getRemovePromo(),"Remove Promo Code");
						logger.log(Status.INFO,"Promo code is Successfully Removed");
					}else {
						Assert.fail("Promo Code is not Removed");
					}
				}
			}
				@Test(priority=1)	
				public void VerifyPromoCodeCheckout() {
					UIFunctions.addProductToCart("TumiTestData","Products");
					click(pdp.getAddToCart(),"Add to cart");
					click(minicart.getProceedCheckOut(), "Proceed to Cart");
					click(mainCart.getProceedCart(), "Proceed to Checkout");
					  UIFunctions.addPromotionalCodeAtSinglePage("TumiTestData", "VoucherCodeDetails");
					  if(singlePage.getPromocodeMessage().isDisplayed()){
						  logger.log(Status.INFO,"Promo Code is applied Successfully ");
					  }else {
						  Assert.fail("Promo Code is not applied");
						  click(mainCart.getRemovePromo(),"Remove Promo Code");
						  if(singlePage.getPromocodeMessage().isDisplayed()){
							logger.log(Status.INFO,"Promo code is Successfully Removed");
						}else {
							Assert.fail("Promo Code is not Removed");
						}
				}

				}
		}
			
		
		
		
		







