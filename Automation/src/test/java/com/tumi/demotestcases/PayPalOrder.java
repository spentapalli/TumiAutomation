package com.tumi.demotestcases;

import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.TumiLibs;

/**
 * @author Shwetha Capo
 *
 */
public class PayPalOrder extends GenericMethods {
	
	public Map<String, String> testData = ReadTestData.retrieveData("Login", "PayPalOrder");
	
	@Test
	public void testPayPalOrder() throws InterruptedException{
		
		TumiLibs.closeSignUpForUS();
		final String pdpURL = GlobalConstants.url+"/p/"+testData.get("SKUID");
		driver.get(pdpURL);
		
		click(pdp.getAddToCart(),"Add to cart");
		click(cart.getProceedCheckOut(),"proceed to checkout");
		click(paypal.getPayPal(),"Click on PayPal");
		delay(6000);
		click(paypal.getPayPalLogin(),"Click on paypal login");
		delay(2000);
		input(paypal.getPayPalEmail(),testData.get("EmailID"), "EmailID");
		click(paypal.getNext(),"Next");
		delay(2000);
		input(paypal.getPayPalPassword(),testData.get("Password"),"Password");
		click(paypal.getLogin(),"Login");
		delay(10000);
		click(paypal.getVisax111(),"select Visa");
		click(paypal.getPaypalContinue(),"Continue");
		delay(5000);
		if(review.getPlaceOrder().isEnabled()) {
			click(review.getPlaceOrder(),"Place Order");
		}else {
			Assert.fail("Page is not enabled to proceed to place an order");
			System.out.println("Review page is not enabled to place order");
		}
		
		
		
	}
}
