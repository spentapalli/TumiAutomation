package tumi.home;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.utilities.GenericMethods;

/**
 * @author Shwetha Capo
 *
 */
public class VerifyPGPFilters extends GenericMethods {

	/*
	 * TA- 68 Verify PGP Filters for US and CANADA.
	 */

	@Test
	public void verifyPGPFilters() {
		
		//TA-368: Verify Colors

		goToPGP();

		List<WebElement> colorsList = pgp.getColorsList();
		List<String> attList = new ArrayList<String>();
		String attr = null;
		for (WebElement webElement : colorsList) {
			attr = webElement.getAttribute("aria-label");
			if (attList.contains(attr)) {
				Assert.fail(webElement + "is duplicated");
				break;
			} else {
				attList.add(attr);
			}
		}

		if (attList.size() == colorsList.size()) {
			logger.log(Status.INFO, "Verification of Color Filter is successfull");
		} else {
			Assert.fail("Verification of Color Filter is failed");
		}

		//TA- 369: Verify Product type

		clickFilter("product_type");

		for (WebElement filter : pgp.getProductTypeList()) {
			String firstOpt = filter.getAttribute("value");
			if (firstOpt.contains("Carry-On Luggage")) {
				delay(2000);
				webclick(filter, "Carry On Bags");
				break;
			}
		}
		delay(2000);
		String count = getText(pgp.getCarryOnCountBagPT());
		int productCount = Integer.parseInt(count.replaceAll("\\D", ""));

		verifyWithResultcount(productCount, "product_type");
		logger.log(Status.INFO, "TA-369 : verification of Product type is successfull");
		clearFilter("product_type");

		// TA- 370:  Verify Price Filter

		clickFilter("prices");

		for (WebElement prices : pgp.getPricesList()) {
			String range = prices.getAttribute("value");
			if (range.contains("350:500")) {
				delay(2000);
				webclick(prices, "$350 to $500 option");
				break;
			}
		}
		delay(2000);
		String count1 = getText(pgp.getPriceRangeCount());
		int productCount1 = Integer.parseInt(count1.replaceAll("\\D", ""));

		verifyWithResultcount(productCount1, "Price");
		logger.log(Status.INFO, "TA-370 : Verification of Price filter is successfull");
		clearFilter("prices");
		

		// TA- 371:  Verify Genders Filter

		clickFilter("gender");
		for (WebElement gender : pgp.getGenderList()) {
			String range = gender.getAttribute("value");
			if (range.contains("Female")) {
				delay(2000);
				webclick(gender, "Female option");
				break;
			}
		}
		delay(2000);
		String count2 = getText(pgp.getFemaleCount());
		int productCount2 = Integer.parseInt(count2.replaceAll("\\D", ""));

		verifyWithResultcount(productCount2, "Gender");
		logger.log(Status.INFO, "TA-371 : verification of Gender filter is successfull");
		clearFilter("gender");

		// TA- 372 : Verify Collection

		clickFilter("Collection");
		for (WebElement collection : pgp.getCollectionList()) {
			String collName = collection.getAttribute("value");
			if (collName.contains("Alpha 2")) {
				delay(2000);
				webclick(collection, "Alpha 2 option");
				break;
			}
		}
		delay(2000);
		String count3 = getText(pgp.getAlphaCount());
		int productCount3 = Integer.parseInt(count3.replaceAll("\\D", ""));

		verifyWithResultcount(productCount3, "Collection");
		logger.log(Status.INFO, "TA-372 : Verification of Collection filter is successfull");
		clearFilter("Collection");

		// TA- 373: Verify Material Filter

		clickFilter("Material");
		for (WebElement material : pgp.getMaterialList()) {
			String type = material.getAttribute("value");
			if (type.contains("Leather")) {
				delay(2000);
				webclick(material, "Leather option");
				break;
			}
		}
		delay(2000);
		String count4 = getText(pgp.getLeatherCount());
		int productCount4 = Integer.parseInt(count4.replaceAll("\\D", ""));

		verifyWithResultcount(productCount4, "Material");
		logger.log(Status.INFO, "TA-373 : Verification of Material filter is successfull");
		clearFilter("Material");

		// TA- 374: Verify Laptop Size Filter

		clickFilter("laptop_size");
		for (WebElement lapiSize : pgp.getLaptopSizeList()) {
			String fourteenSize = lapiSize.getAttribute("value");
			if (fourteenSize.contains("Fits up to 14")) {
				delay(2000);
				webclick(lapiSize, "Size 14' option");
				break;
			}
		}
		delay(2000);
		String count5 = getText(pgp.getFitsUpto14laptopCount());
		int productCount5 = Integer.parseInt(count5.replaceAll("\\D", ""));
		verifyWithResultcount(productCount5, "Loptop Size");
		logger.log(Status.INFO, "TA-374 : Verification of Laptop Size filter is successfull");
		clearFilter("laptop_size");

		//TA- 375:  Verify Wheels Filter

		clickFilter("Wheels");
		for (WebElement wheelCount : pgp.getWheelsList()) {
			String type = wheelCount.getAttribute("value");
			if (type.contains("4.0")) {
				delay(2000);
				webclick(wheelCount, "4 wheels");
				break;
			}
		}
		delay(2000);
		String count6 = getText(pgp.getFourWheelsCount());
		int productCount6 = Integer.parseInt(count6.replaceAll("\\D", ""));
		verifyWithResultcount(productCount6, "Wheels");
		logger.log(Status.INFO, "TA-375 : Verification of Wheels filter is successfull");
		clearFilter("Wheels");

		//TA-376: Verify Exclusive Features

		clickFilter("FSM_ExclusiveFeatures");
		for (WebElement exclusive : pgp.getExclusiceFeatureList()) {
			String featureType = exclusive.getAttribute("value");
			if (featureType.contains("Monogramable")) {
				delay(2000);
				webclick(exclusive, "Monogrammable");
				break;
			}
		}
		delay(2000);

		String count7 = getText(pgp.getMonoCount());
		int productCount7 = Integer.parseInt(count7.replaceAll("\\D", ""));

		verifyWithResultcount(productCount7, "Exclusive Feature");
		logger.log(Status.INFO, "TA-376 : Verification of Exclsive Feature filter is successfull");
		clearFilter("FSM_ExclusiveFeatures");

	}
	
	public void goToPGP() {
		if(selectedCountry.contains("US")) {
		mouseHover(pgp.getluggage());
		click(pgp.getCarryOnLuggage(), "Carry on Luggage");
		}else if(selectedCountry.contains("Canada")) {
			mouseHover(pgp.getWomenCategory());
			click(pgp.getCarryOnLuggageInWomen(), "Carry on Luggage");
		}
		}

	public void clickFilter(String filterName) {
		for (WebElement ele : pgp.getFiltersList()) {
			String attr = ele.getAttribute("data");
			if (attr.contains(filterName)) {
				delay(2000);
				webclick(ele, filterName);
				break;
			}
		}
	}

	public void clearFilter(String filter) {
		for (WebElement clear : pgp.getClearList()) {
			String filterName = clear.getAttribute("data-field");
			if (filterName.contains(filter)) {
				delay(2000);
				webclick(clear, filterName);
				logger.log(Status.INFO, filterName + " filter cleared successfully");
				break;
			}
		}
		delay(2000);
	}

	public void verifyWithResultcount(int i, String type) {
		delay(2000);
		String result = getText(pgp.getResultCount());
		int resultCount = Integer.parseInt(result.replaceAll("\\D", ""));
		System.out.println(resultCount);

		if (i == resultCount) {
			logger.log(Status.INFO, type + " Filter product count matched with results count");
		} else {
			Assert.fail("Verification of " + type + " count is failed");
		}
	}

}
