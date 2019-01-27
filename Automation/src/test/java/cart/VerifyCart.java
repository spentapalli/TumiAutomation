package cart;

import java.util.ArrayList;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class VerifyCart extends GenericMethods {

	/*
	 * Can we have Available stock as filter if the user searchs for the product vie
	 * search keyword or category search Issue - edit Quantity with ex: 3, In mini
	 * cart 3 items in cart is displayed -> again edit quantity with 5, now total
	 * quantity is 5, but 8 items in cart is displayed which is wrong --> Can we
	 * have remove all products in mini cart
	 */

	public Map<String, String> testData = ReadTestData.retrieveData("Cart", "VerifyCart");

	/*
	 * Confirm cart shows correct count of products added in cart [ex: SHOPPING CART
	 * (1)]
	 */
	@Test(priority = 0)
	public void verifyCartCount() {

		login("PlaceOrder", "TumiLogin");
		click(myacc.getMyAccountClose(), "My Account Close");
		//to get PDP
		input(home.getSearchProduct(), testData.get("SKUID"), "Search Product");
		keyEnter(home.getSearchProduct());
		try {
			if (getText(home.getNoProducts()).contains("SORRY")) {
				Assert.fail("Sorry, no search results");
			}
		} catch (Exception e) {

		}
		click(pdp.getAddToCart(), "Add to Cart");
		click(minicart.getProceedCheckOut(), "Continue Shopping");
		verifyAssertInt(UIFunctions.shoppingCartCount(), pdp.getCartRows().size()-1);
	}

	/*Confirm you can edit in the cart
	 * Editing/Updating cart adds a new line item for the product
	 */
	@Test(priority = 1, dependsOnMethods = "verifyCartCount")
	public void verifyCartEdit() {
		click(pdp.getFEditQuantity(), "Edit First Product");
		input(pdp.getEnterQuantity(), testData.get("ProductQ"), "Input Quantity");
		click(pdp.getUpdateQuantity(), "Update Quantity");
		verifyAssertInt(UIFunctions.shoppingCartCount(), parseInt(testData.get("ProductQ")));
		// click(cart.getContinueShopping(), "Continue Shopping");
	}

	@Test(priority = 2)
	public void removeCartProduct() {
		click(pdp.getCartRemove(), "Remove Product");
		verifyAssertInt(UIFunctions.shoppingCartCount(), pdp.getCartRows().size()-1);
	}

	@Test(priority = 3)
	public void applyMonogrammingInTheCart() {

		click(mainCart.getAddClassicMonogram(), "Classic(Free)");
		click(mainCart.getClickNext(), "Next");
		click(mainCart.getClickApply(), "Apply");
		if (mainCart.getMonogramMessege().isDisplayed()) {
			logger.log(Status.INFO, getText(mainCart.getMonogramMessege()));
		} else {
			Assert.fail("Monogram Not Added");
		}
	}

	@Test(priority = 4)
	public void addGiftingIntheCart() {

		click(mainCart.getMakeGiftBox(), "Make This a Gift");
		click(mainCart.getIncludeGiftMessege(), "Include Giftbox Messege");
		input(mainCart.getRecipientName(), "John", "Recipient Name");
		input(mainCart.getSenderName(), "Jonny", "SenderName");
		input(mainCart.getAddMessege(), "Hey John", "Add a Messege");
		click(mainCart.getStandardGiftBoxing(), "Standard Gift Boxing");
		click(mainCart.getContinueButton(), "Continue Button");
		verifyAssertEquals(getText(mainCart.getGiftBoxAdded()), prop.getProperty("cart.giftCart"));
	}

}
