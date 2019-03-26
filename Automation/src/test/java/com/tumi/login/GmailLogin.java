package com.tumi.login;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;

public class GmailLogin extends GenericMethods {
	public Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "ExistingAccount");

	@Test
	public void verifyLogin() throws InterruptedException {

		UIFunctions.closeSignUp();
		click(home.getHeaderSignIn(), "SignIn");
		click(google.getGoogleLogin(), "Google login");

		String pwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		System.out.println(allwindows.size());
		Iterator<String> itr = allwindows.iterator();
		while (itr.hasNext()) {
			String cwindow = itr.next();
			System.out.println(cwindow);
			if (!pwindow.equals(cwindow)) {
				driver.switchTo().window(cwindow);
				driver.switchTo().window(cwindow).getTitle();
				System.out.println(driver.getTitle());
				delay(2000);
				input(google.getEmail(), testData.get("EmailID"), "gmail id");
				click(google.getFirstNext(), "Next");
				delay(2000);
				input(google.getPassword(), testData.get("Password"), "Password");
				click(google.getPasswordNext(), "password next");
				delay(3000);

			}
		}
		driver.switchTo().window(pwindow);

		click(home.getCloseMyAccount(), "Close my account window");
		input(home.getSearchProduct(), testData.get("PrdouctName"), "Product search"); ////////////////
		WebElement dropdown = driver.findElement(By.id("matching_products"));
		List<WebElement> allSearchResults = dropdown.findElements(By.tagName("li"));
		if (allSearchResults.isEmpty()) {
			final String emptyViewText = driver
					.findElement(By.xpath("//div[contains(text(),'Sorry, no search results for')]")).getText();
			if (!emptyViewText.contains("no results")) {
				throw new RuntimeException(emptyViewText);
			}
		} else {
			allSearchResults.get(0).click();
		}
		click(pdp.getAddToCart(), "Add To Cart");
		// delay(2000);

		click(minicart.getProceedCheckOut(), "Proceed to Checkout");

		click(mainCart.getProceedCart(), "Cart");
		input(shipping.getFirstName(), testData.get("FirstName"), "First Name");
		input(shipping.getLastName(), testData.get("LastName"), "Last Name");
		input(shipping.getAddressLine1(), testData.get("AddressLine1"), "Address line1");
		delay(2000);

		for (WebElement ele : shipping.getListAddressLine1()) {
			if (getText(ele).equals("1001 6Th Ave Ph 1, New York NY 10018")) {
				click(ele, "AddressList");
				break;
			}
		}
		input(shipping.getPostcode(), testData.get("PostCode"), "Post code");

		input(shipping.getPhoneNumber(), testData.get("Phone"), "Phone Number");
		click(shipping.getContinueShippingMethod(), "Continue shipping Method");

		webclick(shipMethod.getStandardShippingMethod(), "Standard Shipping Method");
		click(shipMethod.getProceedToPayment(), "Proceed to Payment");

		click(signinBill.getAddNewPay(), "Add new Payment");
		input(guestBillPage.getNameOnCard(), testData.get("NameOnCard"), "Name on Card");
		input(guestBillPage.getCardNumber(), testData.get("CardNumber"), "Card Number");
		selectByVisibleText(guestBillPage.getExpiryMonth(), "05", "Expiry Month");
		selectByVisibleText(guestBillPage.getExpiryYear(), "2020", "Expiry Year");
		input(guestBillPage.getCvvNumber(), testData.get("CVV"), "Cvv Number");
		click(guestBillPage.getReviewOrder(), "Review your order");
		delay(2000);

		click(review.getPlaceOrder(), "place order");
		delay(5000);
		captureOrderConfScreen("OrderConfirmation");
		delay(20000);

	}

}
