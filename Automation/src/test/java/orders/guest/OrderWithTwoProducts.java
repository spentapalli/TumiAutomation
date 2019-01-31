package orders.guest;

import java.util.Map;

import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.UIFunctions;

/**
 * @author Suuresh
 *
 */
public class OrderWithTwoProducts extends GenericMethods {

	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "OrderWithTwoProducts");

	/*
	 * TA-14 Verify Order with 'Ready to Ship' SKU + 'Pre Order' SKU-Guest user
	 */
	@Test(priority = 0, description = "Verify Order with 'Ready to Ship' SKU + 'Pre Order' SKU-Guest user")
	public void verifyOrderNormalAndPreOrder() {
		addTwoProducts("NoramlSKUID", "PreOrderSKUID");
	}

	/*
	 * TA-13 Verify Order with 'Ready to Ship' SKU + 'Back Order' SKU-Guest user
	 */
	@Test(priority = 1, description = "Verify Order with 'Ready to Ship' SKU + 'Back Order' SKU-Guest user")
	public void verifyOrderNormalAndBackOrder() {
		addTwoProducts("NoramlSKUID", "BackOrderSKUID");
	}

	/*
	 * TA-4 Verify Order with 'Back Order + 'Pre Order' SKU-Guest user
	 */
	@Test(priority = 2, description = "Verify Order with 'Pre Order' SKU + 'Back Order' SKU-Guest user")
	public void verifyOrderPreOrderAndBackOrder() {
		addTwoProducts("PreOrderSKUID", "BackOrderSKUID");
	}

	public void addToCart(String product) {

		driver.get(GlobalConstants.url + "/p/" + testData.get(product));
		/*
		 * input(home.getSearchProduct(), testData.get("NoramlSKUID"),
		 * "ReadyToShipOrderProduct"); keyEnter(home.getSearchProduct());
		 */
		click(pdp.getAddToCart(), "Add To Cart");
	}

	public void addTwoProducts(String productName1, String productName2) {

		addToCart(productName1);
		click(minicart.getContinueShopping(), "Continue Shopping");
		addToCart(productName2);
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(minicart.getSinglePageCheckout(), "Proceed to Single Page Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		//UIFunctions.waitForContinueToEnable();
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		UIFunctions.addGuestDetails();
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("PlaceOrder", "OrderWithPreorderVochercode");
		UIFunctions.completeOrder();
	}

}
