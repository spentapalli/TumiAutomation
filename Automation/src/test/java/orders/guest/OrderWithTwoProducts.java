package orders.guest;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	 * TA-14
	 * Verify Order with 'Ready to Ship' SKU + 'Pre Order' SKU-Guest user
	 */
	@Test(priority=0,description = "Verify Order with 'Ready to Ship' SKU + 'Pre Order' SKU-Guest user")
	public void verifyOrderNormalAndPreOrder() {
		addTwoProducts("NoramlSKUID","PreOrderSKUID");
	}
	/*TA-13
	 * Verify Order with 'Ready to Ship' SKU + 'Back Order' SKU-Guest user
	 */
	@Test(priority=1,description = "Verify Order with 'Ready to Ship' SKU + 'Back Order' SKU-Guest user")
	public void verifyOrderNormalAndBackOrder() {
		addTwoProducts("NoramlSKUID","BackOrderSKUID");
	}
	/*TA-4
	 * Verify Order with 'Back Order + 'Pre Order' SKU-Guest user
	 */
	@Test(priority=2,description = "Verify Order with 'Ready to Ship' SKU + 'Back Order' SKU-Guest user")
	public void verifyOrderPreOrderAndBackOrder() {
		addTwoProducts("PreOrderSKUID","BackOrderSKUID");
	}
	
	
	public void addTwoProducts(String productName1,String productName2 ) {


		driver.get(GlobalConstants.url + "/p/" + testData.get(productName1));
		/*
		 * input(home.getSearchProduct(), testData.get("NoramlSKUID"),
		 * "ReadyToShipOrderProduct"); keyEnter(home.getSearchProduct());
		 */
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getContinueShopping(), "Continue Shopping");

		driver.get(GlobalConstants.url + "/p/" + testData.get(productName2));
		/*
		 * input(home.getSearchProduct(), testData.get("PreOrderSKUID"),
		 * "PreOrderProduct"); keyEnter(home.getSearchProduct());
		 */
		click(pdp.getAddToCart(), "Add To Cart");
		click(minicart.getProceedCheckOut(), "Proceed to Checkout");
		click(mainCart.getProceedToCheckout(), "Proceed to Checkout");
		input(singlePage.getEmailAddress(), testData.get("EmailID"), "Email ID");
		click(singlePage.getContinueAsGuest(), "Contiue as Guest");
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address Line1");
		explicitWait(shipping.getSelectedAddressLine());
		for (int i = 1; i < shipping.getAddList().size(); i++) {
			WebElement add = driver.findElement(By.xpath("//div[@class='address-picklist']/div[" + i + "]"));
			if (add.getText().contains("Fairport NY 14450")) {
				click(add, "Address Line1");
				break;
			}

		}
		input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
		click(shipping.getContinueShippingMethod(), "Contiue Shipping");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");
		UIFunctions.addCardDetails("PlaceOrder", "OrderWithPreorderVochercode");
		click(review.getPlaceOrder(), "Place Order");
	
	}

}
