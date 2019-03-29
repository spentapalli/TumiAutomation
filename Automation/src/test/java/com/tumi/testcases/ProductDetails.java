package com.tumi.testcases;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.UIFunctions;



/**
 * @author Shwetha Capo
 *
 */
public class ProductDetails extends GenericMethods {
	/*
	 * TA-5, Verify PDP page.
	 */
	
	static Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "Products");
	static Map<String, String> personalization = ReadTestData.getJsonData("TumiTestData", "MonoGramDetails");

	@Test(priority = 0, description = "TA-420, Verify bread crumbs above Product" )
	public void verifyBreadScrumbs() {
		SoftAssert breadcrumbs = new SoftAssert();
		addProductForPDPtest(testData.get("BreadCrumbsTest"));
		click(pdp.getBreadCrumbHome(), "Home");
		delay(2000);
		if (home.getHeaderFindStore().isDisplayed()) {
			logger.log(Status.INFO, "Naviagting to Home page is successfull..");
		} else {
			breadcrumbs.fail("Navigating to Home page Failed");
		}

		addProductForPDPtest(testData.get("BreadCrumbsTest"));
		delay(2000);
		click(pdp.getBreadCrumbCategory(), "Category");
		String url = driver.getCurrentUrl();
		if (url.contains("luggage")) {
			logger.log(Status.INFO, "Naviagting to Luggage category is successfull");
		} else {
			breadcrumbs.fail("Naviagting to Luggage category is successfull");
		}

		addProductForPDPtest(testData.get("BreadCrumbsTest"));
		click(pdp.getBreadCrumbSubCategory(), "Sub Category");
		delay(2000);
		String url1 = driver.getCurrentUrl();
		if (url1.contains("carryon-luggage")) {
			logger.log(Status.INFO, "Naviagting to Carryon Luggage category is successfull");
		} else {
			breadcrumbs.fail("Naviagting to Carryon Luggage category is successfull");
		}

		logger.log(Status.INFO, "Verification of BreadCrumbs are Successfull");
		breadcrumbs.assertAll();
	}

	@Test(priority = 1, description = "TA-422, Verify Enire Collection link")
	public void verifyCollectionLink() {

		addProductForPDPtest(testData.get("BreadCrumbsTest"));
		String collName = getText(pdp.getCollectionName());

		click(pdp.getCollectionLink(), "View Entire Collection");

		WebElement items = driver.findElement(By.xpath("//span[@id='numberItemsSelectBoxItText']"));
		String products = getText(items);
		int productsCount = Integer.parseInt(products.replaceAll("\\D", ""));

		for (int i = 1; i <= productsCount; i++) {

			WebElement ele = driver.findElement(
					By.xpath("//div[contains(@class,'ctnr-prod-items ctnr')]/div[" + i + "]/div[2]/div/div[2]"));
			delay(2000);

			if (!collName.contains(getText(ele))) {
				logger.log(Status.INFO, i + " no. Product doesnot contain Same collection name");

			}
		}
		logger.log(Status.INFO, "Verification of all Product Collection Name are Successfull");

	}

	@Test(priority = 2, description = "TA-424, Verify Color Swatches")
	public void verifyColorSwatches() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			addProductForPDPtest(testData.get("ColorSwatches"));
		} else {
			addProductForPDPtest(testData.get("ColorSwatchesKr"));
		}
		String parentSKU = getText(pdp.getStyleSKUID());
		for (int i = 2; i <= 3; i++) {
			WebElement ele = driver.findElement(By.xpath("//ul[@class='no-list choose-colors']/li[" + i + "]/a"));
			click(ele, "Color Swatch");
			String childSKU = getText(pdp.getStyleSKUID());

			if (!parentSKU.equals(childSKU)) {
				logger.log(Status.INFO, "Verification of " + i + " Color Swatch is Successfull ");
			} else {
				Assert.fail("Verification of " + i + " Color Swatch is Failed");
			}

		}

	}

	@Test(priority = 3, description = "TA-425, Verify Add a Classic Monogram")
	public static void verifyMonogram() {
		addProductForPDPtest(testData.get("BreadCrumbsTest"));
		click(mono.getAddClassic(), "Classic Monogram");
		UIFunctions.addMonogram(mono.getEditMono());

	}

	@Test(priority = 4, description = "TA-421, Verify Images")
	public void verifyImages() {
		addProductForPDPtest(testData.get("BreadCrumbsTest"));
		int imagesCount = pdp.getAltItemsList().size();
		if (imagesCount > 0) {
			logger.log(Status.INFO,
					"Verification of Alternates Images Count is successfull and The Count is " + imagesCount);
		} else {
			Assert.fail("Verification of Alternate images count is Failed");
		}

	}

	@Test(priority = 5, description = "TA-426: Verify Add to Cart," + "TA-435: Verify Airline Carry on guide and "
			+ "TA-428 : Accordians/labels")
	public void verifyPDP() {
		SoftAssert verifypdpAsser = new SoftAssert();

		/*
		 * Verify Airline Carry-On-Guide is opening window and displaying guide or not"
		 */

		addProductForPDPtest(testData.get("AirlineProduct"));
		click(pdp.getAirLine(), "AirLine Carry-On-Guide");
		WebElement ele = driver.findElement(By.xpath("//table[@class='airline-carry-on-guide-table']"));
		if (ele.isEnabled()) {
			logger.log(Status.INFO, "Airline Carry on Guide Content is Displyed");
			logger.log(Status.INFO, "Verification of Airline Carry on Guide is Successfull");
		} else {
			verifypdpAsser.fail("Airline Carry on Guide Content is not Displyed");
		}
		click(pdp.getAirLineClose(), "Close Airline Window");

		/*
		 * Verify Add to Cart : Verifying that product is in out of stock or in stock
		 */
		try {
			if (pdp.getAddToCart().isDisplayed()) {
				click(pdp.getAddToCart(), "Add to cart");
				try {
					if (minicart.getProceedCheckOut().isDisplayed()) {
						logger.log(Status.INFO, "Verification of Add to Cart is Successfull");
					}
				} catch (Exception e) {
					verifypdpAsser.fail("Mini Cart is not opened when click on Add to Cart");
				}
			} else if (pdp.getOutOfStock().isDisplayed()) {
				verifypdpAsser.fail("Product is Out of Stock, Unable to verify Add to Cart");
			}
		} catch (Exception e) {
			click(pdp.getPageNotFoundPopup(), "Popup Close");
			if (pdp.getPageNotFound().isDisplayed()) {
				verifypdpAsser.fail("Sorry,Page Not Found is Displayed , Unable to verify Add to Cart");
			}
		}

		/*
		 * Verify Accordions: Verifying accordions are enabled or not , if enabled
		 * verifying each accordion has content or not.
		 */

		addProductForPDPtest(testData.get("BreadCrumbsTest"));
		if (!pdp.getAccordionsList().isEmpty()) {
			logger.log(Status.INFO, "Accordions are enabled");
			for (int i = 1; i <= pdp.getAccordionsList().size(); i++) {
				WebElement accordian = driver
						.findElement(By.xpath("//div[contains(@class,'accordion')]/div[" + i + "]/h2/a"));
				if (i != 1) {
					click(accordian, i + "-accordian");
				}
				WebElement content = driver.findElement(By.xpath("//div[@id='accordion-" + i + "']"));
				try {
					if (content.isDisplayed()) {
						logger.log(Status.INFO, i + " Accordions content is visible");
					}
				} catch (Exception e) {
					verifypdpAsser.fail("Either Content is not Visible or accordian-" + i + "is not clickable");
				}
			}
			logger.log(Status.INFO, "All Accordions are clickable, Verification of Accordions is successfull");
		} else {
			verifypdpAsser.fail("Accordions are disabled");
		}

		verifypdpAsser.assertAll();

	}

	@Test(priority = 6, description = "TA-429: Verify Product Warranty test,"
			+ "Setting your Tumi Lock and Free returns.")
	public void verifyAccordionFeatures() {
		SoftAssert accordion = new SoftAssert();
		addProductForPDPtest(testData.get("BreadCrumbsTest"));

		/*
		 * Verify Product Warranty : verifying if click on Product Warranty, displaying
		 * content or not
		 */
		click(pdp.getProductWarranty(), "Product Warranty");

		if (pdp.getProductWarrantyContent().isDisplayed()) {
			logger.log(Status.INFO, "Product Warranty content is enabled");
			logger.log(Status.INFO, "Verification of Product Warranty is Successfull");
		} else {
			accordion.fail("Product Warranty content is not enabled or not there");
		}
		click(pdp.getProductWarrantyPopupClose(), "Popup Close");

		/*
		 * Verify Setting Your Tumi Lock: Verifying if click on Setting Your Tumi Lock
		 * will open tumi lock page with specific buttons or not
		 * 
		 */
		if(selectedCountry.contains("US")) {
		click(pdp.getTumiLock(), "Setting Your TumiLock");
		if (!pdp.getTumiLockList().isEmpty()) {
			logger.log(Status.INFO, "Verification of Tumi Lock page is successfull");
		} else {
			accordion.fail("No Tumi Lock settings displayed, Verification of Tumi Lock page is Failed");
		}
		}
		
		/*
		 * Verify Free Returns : verifying if click on Free Returns, displaying
		 * content or not
		 */
		

		addProductForPDPtest(testData.get("BreadCrumbsTest"));
		click(pdp.getFreeReturns(), "Free Returns");
		if (pdp.getFreeReturnsContent().isDisplayed()) {
			logger.log(Status.INFO, "Verification of Free Returns is successfull");
		} else {
			accordion.fail("No Free Returns content displayed, Verification of Free Returns is Failed");
		}
		accordion.assertAll();

	}

	public static void addProductForPDPtest(String data) {

		if (selectedCountry.contains("US")) {

			final String pdpURL = GlobalConstants.S2 + "/p/" + data;
			driver.get(pdpURL);
		} else if (selectedCountry.contains("Canada")) {

			final String pdpURL = GlobalConstants.urlca + "/p/" + data;
			driver.get(pdpURL);

		} else {

			final String pdpURL = GlobalConstants.urlkr + "/p/" + data;
			driver.get(pdpURL);
		}
		UIFunctions.verifyVPN();
	}

	

}
