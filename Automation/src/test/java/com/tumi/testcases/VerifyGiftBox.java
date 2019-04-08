package com.tumi.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;


/**
 * @author Shwetha Capo
 *
 */
public class VerifyGiftBox extends GenericMethods{
	/*
	 * TA-36, Verify Gift Box services.
	 */
	
	static Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "Products");
	
	@Test(description="TA-36: TA-444 Verify Premium Gift Box Charges applied to Order Summery")
	public void verifyPremiumGiftCharge() {
		SoftAssert premiumAsser = new SoftAssert();
		ProductDetails.addProductForPDPtest(testData.get("GiftBoxSKU"));
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart..");
		
		Double beforeTotal = Double.valueOf(getText(mainCart.getTotal()).replace("$", "").replace(",", ""));
		System.out.println("Before product cost = "+beforeTotal);
		click(gift.getMakeThisGift(),"Make this a gift");
		UIFunctions.addGiftBox();
		click(gift.getContinueGiftService(), "Continue");
		Double premiumCost = Double.valueOf(getText(mainCart.getPremiumCharge()).replace("$", "").replace(",", ""));
		System.out.println("Premium Cost ="+premiumCost);
		
		Double afterTotal = Double.valueOf(getText(mainCart.getTotal()).replace("$", "").replace(",", ""));
		System.out.println("After Premium gift box applied, product cost = "+afterTotal);

		if(premiumCost==(afterTotal-beforeTotal)) {
			logger.log(Status.PASS, "Verification of Premium charges is successfull");
		}else {
			premiumAsser.fail("Before Estimated total cost and after applying Premium charges,total cost are not matched");
		}
		click(gift.getGiftRemove(),"Remove");
		Double afterRemove = Double.valueOf(getText(mainCart.getTotal()).replace("$", "").replace(",", ""));
		System.out.println("After Premium gift box removed, product cost = "+afterRemove);
		if(beforeTotal.equals(afterRemove)) {
			logger.log(Status.PASS, "After remove Premium gift box, the price is updated successfully");
		}else {
			premiumAsser.fail("After remove Premium gift box, the price is not updated successfully");
		}
		
		premiumAsser.assertAll();
		
	}
	
	@Test(description="TA-36 : TA- 442 ,Verify GiftMessage"+"TA-441, Verify Standard gift box"+"TA-445, Verify Edit gift"+"TA-446, verify remove gift")
	public void verifyGiftMessage() {
		SoftAssert giftAsser = new SoftAssert();
		ProductDetails.addProductForPDPtest(testData.get("GiftBoxSKU"));
		click(pdp.getAddToCart(), "Add to cart");
		click(minicart.getProceedCheckOut(), "Proceed to Cart");
		String beforeTotal = getText(mainCart.getEstimatedTotal());
		click(gift.getMakeThisGift(),"Make this a gift");
		
		if(selectedCountry.contains("US")||selectedCountry.contains("Canada")) {
		UIFunctions.addGiftMessage("TumiTestData", "VoucherCodeDetails");
		click(gift.getContinueGiftService(), "Continue");
		try {
			if(gift.getGiftEdit().isDisplayed()||gift.getGiftMsgAdded().isDisplayed()) {
				logger.log(Status.PASS, "Gift Message added Successfully");
				click(gift.getGiftEdit(),"Gift Edit");
				domClick(gift.getCheckStandardGift(), "Stanadard gift box");
				click(gift.getContinueGiftService(), "Continue");
				String AfterTotal = getText(mainCart.getEstimatedTotal());
				try {
					if(gift.getGiftBoxAdded().isDisplayed()) {
						logger.log(Status.PASS, "Gift Box Edited/Updated and added Standard gift box Successfully");
						if(beforeTotal.equals(AfterTotal)) {
							logger.log(Status.INFO, "Standard gift box charges applied as Free");
						}else {
							logger.log(Status.INFO, "Standard gift box charges not applied as Free");
						}
						
						click(gift.getGiftRemove(),"Remove");
						try {
							if(gift.getMakeThisGift().isDisplayed()) {
								logger.log(Status.PASS, "Gift Box removed Successfully");
															
							}
						} catch (Exception e) {
							giftAsser.fail("Gift Box not removed");
						}
						
					}
				} catch (Exception e) {
					giftAsser.fail("Gift Box not Edited/Updated");
				}
			}
		} catch (Exception e) {
			giftAsser.fail("Gift Message not added, Please Check");
		}
		}else {
			domClick(gift.getCheckStandardGift(), "Stanadard gift box");
			click(gift.getContinueGiftService(), "Continue");
			try {
				if(gift.getGiftBoxAdded().isDisplayed()) {
					logger.log(Status.PASS, "Standard gift box added Successfully");
					click(gift.getGiftRemove(),"Remove");
					try {
						if(gift.getMakeThisGift().isDisplayed()) {
							logger.log(Status.PASS, "Gift Box removed Successfully");
														
						}
					} catch (Exception e) {
						giftAsser.fail("Gift Box not removed, Please Check");
					}
					
				}
			} catch (Exception e) {
				giftAsser.fail("Standard gift box added Successfully");
			}
			
		}
		giftAsser.assertAll();
	}

}


