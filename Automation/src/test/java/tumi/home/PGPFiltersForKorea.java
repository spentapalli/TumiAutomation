package tumi.home;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.utilities.GenericMethods;

public class PGPFiltersForKorea extends GenericMethods {

	@Test(description = "TA-68 and TA -378 : Verify PGP Filters for Korea and subtasks TA-368 to TA-376 ")
	public void verifyPGPFiltersForKorea() {

		goToPGP();

		// TA- 369 : Verify Product Type

		/*for (WebElement filter : pgp.getProductTypeList()) {
			String firstOpt = filter.getAttribute("value");
			if (firstOpt.contains("카드 케이스")) {
				delay(2000);
				webclick(filter, "Card Cases");
				break;
			}
		}*/
		
		webclick(pgp.getKrCardCases(),"Card Cases");
		delay(2000);
		String count = getText(pgp.getCardCasesCountForKR());
		int productCount = Integer.parseInt(count.replaceAll("\\D", ""));

		verifyWithResultcount(productCount, "product_type");
		logger.log(Status.INFO, "TA-369 : verification of Product type is successfull");
		clearFilter("product_type");

		// TA- 371 : Verify Gender Filter

		clickFilter("FSM_Gender");
		/*for (WebElement gender : pgp.getGenderList()) {
			String range = gender.getAttribute("value");
			if (range.contains("남성")) {
				delay(2000);
				webclick(gender, "Female option");
				break;
			}
		}*/
		
		webclick(pgp.getKrFemale(),"Female Option");
		delay(2000);
		String count2 = getText(pgp.getFemaleCountForKR());
		int productCount2 = Integer.parseInt(count2.replaceAll("\\D", ""));

		verifyWithResultcount(productCount2, "Gender");
		logger.log(Status.INFO, "TA-371 : verification of Gender filter is successfull");
		clearFilter("FSM_Gender");

		// TA- 370 : Verify Price Range

		clickFilter("prices");

		for (WebElement prices : pgp.getPricesList()) {
			String range = prices.getAttribute("value");
			if (range.contains("0:200000")) {
				delay(2000);
				webclick(prices, "$0 to $200000 option");
				break;
			}
		}
		delay(2000);
		String count1 = getText(pgp.getPriceRangeCount());
		int productCount1 = Integer.parseInt(count1.replaceAll("\\D", ""));

		verifyWithResultcount(productCount1, "Price");
		logger.log(Status.INFO, "TA-370 : Verification of Price filter is successfull");
		clearFilter("prices");

		// TA-372 : Verify Collection

		clickFilter("Collection");
		for (WebElement collection : pgp.getCollectionList()) {
			String collName = collection.getAttribute("value");
			if (collName.contains("Alpha Bravo")) {
				delay(2000);
				webclick(collection, "Alpha Bravo option");
				break;
			}
		}
		delay(2000);
		String count3 = getText(pgp.getKrAlphaBravoCount());
		int productCount3 = Integer.parseInt(count3.replaceAll("\\D", ""));

		verifyWithResultcount(productCount3, "Collection");
		logger.log(Status.INFO, "TA-372 : Verification of Collection filter is successfull");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,-250)", "");
		clearFilter("Collection");

		// TA- 373: Verify Material Filter

		clickFilter("Material");
		/*for (WebElement material : pgp.getMaterialList()) {
			String type = material.getAttribute("value");
			if (type.contains("가죽")) {
				delay(2000);
				webclick(material, "Leather option");
				break;
			}
		}*/
		webclick(pgp.getKrLeather(),"Leather Option");
		delay(2000);
		String count4 = getText(pgp.getLeatherCountForKR());
		int productCount4 = Integer.parseInt(count4.replaceAll("\\D", ""));

		verifyWithResultcount(productCount4, "Material");
		logger.log(Status.INFO, "TA-373 : Verification of Material filter is successfull");
		clearFilter("Material");

		// Verify Size

		clickFilter("size_KR");
		for (WebElement material : pgp.getKrSizeList()) {
			String type = material.getAttribute("value");
			if (type.contains("L")) {
				delay(2000);
				webclick(material, "Size L option");
				break;
			}
		}
		delay(2000);
		String countS = getText(pgp.getKrLSizeCount());
		int productCountS = Integer.parseInt(countS.replaceAll("\\D", ""));

		verifyWithResultcount(productCountS, "Size");
		logger.log(Status.INFO, "TA-373 : Verification of Size filter is successfull");
		clearFilter("size_KR"); 


		// TA- 374: Verify Laptop Size Filter

		clickFilter("laptop_size");
		for (WebElement lapiSize : pgp.getLaptopSizeList()) {
			String fifteenSize = lapiSize.getAttribute("value");
			if (fifteenSize.contains("15")) {
				delay(2000);
				webclick(lapiSize, "Size 15' option");
				break;
			}
		}
		delay(2000);
		String count5 = getText(pgp.getFifteenlapiCountForKR());
		int productCount5 = Integer.parseInt(count5.replaceAll("\\D", ""));
		verifyWithResultcount(productCount5, "Loptop Size");
		logger.log(Status.INFO, "TA-374 : Verification of Laptop Size filter is successfull");
		clearFilter("laptop_size");

		// TA- 375: Verify Wheels Filter

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

		// TA-376: Verify Exclusive Features

		clickFilter("FSM_ExclusiveFeatures");
		/*for (WebElement exclusive : pgp.getExclusiceFeatureList()) {
			String featureType = exclusive.getAttribute("value");
			if (featureType.contains("모노그램")) {
				delay(2000);
				webclick(exclusive, "Monogrammable");
				break;
			}
		}*/
		
		webclick(pgp.getKrMonogram(),"Monogram");
		delay(2000);

		String count7 = getText(pgp.getMonoCountForKR());
		int productCount7 = Integer.parseInt(count7.replaceAll("\\D", ""));

		verifyWithResultcount(productCount7, "Exclusive Feature");
		logger.log(Status.INFO, "TA-376 : Verification of Exclsive Feature filter is successfull");
		clearFilter("FSM_ExclusiveFeatures");

	}

	public void goToPGP() {
		delay(2000);
		if (!selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			mouseHover(pgp.getCarrierNtravel());
			click(pgp.getCarryOnLuggage(), "Carry on Luggage");
		}
	}

	public void clickFilter(String filterName) {
		delay(2000);
		for (WebElement ele : pgp.getFiltersList()) {
			String attr = ele.getAttribute("data");
			if (attr.contains(filterName)) {
				delay(2000);
				click(ele, filterName);
				break;
			}
		}
	}

	public void clearFilter(String filter) {
		for (WebElement clear : pgp.getClearList()) {
			String filterName = clear.getAttribute("data-field");
			if (filterName.contains(filter)) {
				delay(3000);
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
