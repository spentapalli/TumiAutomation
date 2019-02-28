//Sprint-3
package tumi.home;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;
import com.tumi.webPages.PGP;

public class HomepPageTumiLogo extends GenericMethods  {
	/* TA-348
	 * Verify Categories on Home page at Tumi Logo.
	 */
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestOrders");
	@Test(priority = 0, description = " Sprint 3- TA-348 Verify Categories on Home page at Tumi Logo")
	public void VerifyTumiLogoLuaggage(){
		
			mouseHover(home.getLuggageOption());
			click(pgp.getCarryOnLuggage(),"Carry on Luaggage");
			click(pgp.getSelectProduct(),"Select Product");
			click(pdp.getAddToCart(),"Add to cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			UIFunctions.waitForContinueToEnable();
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			UIFunctions.addGuestDetails();
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
			UIFunctions.completeOrder();
		}
	@Test(priority = 1, description = " Sprint 3- TA-348 Verify Categories on Home page at Tumi Logo")
	public void VerifyTumiLogoBackPack(){
		
			mouseHover(home.getBackPackOption());
			click(home.getBackPackTestBridgewater(),"TestBridgeWater");
			click(pgp.getSelectProduct(),"Select Product");
			mouseHover(pdp.getAddToCart());
			click(pdp.getAddToCart(), "Add to cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			UIFunctions.waitForContinueToEnable();
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			UIFunctions.addGuestDetails();
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
			UIFunctions.completeOrder();
		}	
	@Test(priority = 2, description = " Sprint 3- TA-348 Verify Categories on Home page at Tumi Logo")
	public void VerifyTumiLogoBag(){
		
			mouseHover(home.getBagOptions());
			click(home.getBagwheeledBriefCase(),"TestBridgeWater");
			click(pgp.getSelectProduct(),"Select Product");
			mouseHover(pdp.getAddToCart());
			click(pdp.getAddToCart(), "Add to cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			UIFunctions.waitForContinueToEnable();
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			UIFunctions.addGuestDetails();
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
			UIFunctions.completeOrder();
	}
	@Test(priority = 3, description = " Sprint 3- TA-348 Verify Categories on Home page at Tumi Logo")
	public void VerifyTumiLogoAccessories(){
		
			mouseHover(home.getAccessoriesOptions());
			click(home.getAccessoriesKeyFobs(),"key Fobs");
			click(pgp.getSelectProduct(),"Select Product");
			mouseHover(pdp.getAddToCart());
			click(pdp.getAddToCart(), "Add to cart");
			click(minicart.getProceedCheckOut(), "Proceed to Checkout");
			click(mainCart.getProceedCart(), "Proceed to Checkout");
			input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
			UIFunctions.waitForContinueToEnable();
			click(singlePage.getContinueAsGuest(), "Contiue as Guest");
			UIFunctions.addGuestDetails();
			click(shipping.getContinueShippingMethod(), "Contiue Shipping");
			click(shipMethod.getProceedToPayment(), "Proceed to Payment");
			UIFunctions.addCardDetails("TumiTestData", "GuestOrders");
			UIFunctions.completeOrder();
	}
}
	

