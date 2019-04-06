package com.tumi.registerOrders;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.utilities.GenericMethods;

/**
 * @author Suresh
 *
 */
public class ProductsSortingFunctionality extends GenericMethods {

	@Test(priority = 0)
	public void verifyProductAToZSorting() {
		navigateToPDP();
		webclick(pdp.getSortOptions(), "Sorting");
		webclick(pdp.getSortAToZ(), "A to Z");
		for (int i = 1; i < pdp.getListOfProductNames().size(); i++) {

			String product1 = getText(driver
					.findElement(By.xpath("//div[@lmzone='subCategoryPage']/div[2]/div[" + i + "]/div[2]/div/a/div")));
			String product2 = getText(driver.findElement(
					By.xpath("//div[@lmzone='subCategoryPage']/div[2]/div[" + (i + 1) + "]/div[2]/div/a/div")));
			int sortAToZ = product1.compareTo(product2);

			if (sortAToZ > 0) {

				logger.log(Status.ERROR, product1 + "And" + product2 + "are not in A to Z order");
			}
		}
	}

	@Test(priority = 1)
	public void verifyProductZToASorting() {
		navigateToPDP();
		webclick(pdp.getSortOptions(), "Sorting");
		webclick(pdp.getSortZToA(), "Z to A");
		for (int i = 1; i < pdp.getListOfProductNames().size(); i++) {

			String product1 = getText(driver
					.findElement(By.xpath("//div[@lmzone='subCategoryPage']/div[2]/div[" + i + "]/div[2]/div/a/div")));
			String product2 = getText(driver.findElement(
					By.xpath("//div[@lmzone='subCategoryPage']/div[2]/div[" + (i + 1) + "]/div[2]/div/a/div")));
			int sortZToA = product1.compareTo(product2);
			if (sortZToA < 0) {
				logger.log(Status.ERROR, product1 + " And " + product2 + " are not in Z to A order");
			}
		}
	}

	@Test(priority = 2)
	public void verifyProductPriceLowToHigh() {

		if (!decendingCheck(productsPrice(pdp.getSortLowToHigh(), "Price: Lowest to Highest"))) {
			logger.log(Status.ERROR, "Product Prices are Not is ascending order");
		}
	}

	@Test(priority = 3)
	public void verifyProductPriceHighToLow() {

		if (!ascendingCheck(productsPrice(pdp.getSortHighToLow(), "Price Highest to Lowest"))) {
			logger.log(Status.ERROR, "Product Prices are Not is ascending order");
		}
	}

	@Test(priority = 4)
	public void verifyFilterButton() {
		navigateToPDP();
		click(pdp.getHideFilters(), "Hide Filters");
		if (!pdp.getShowFilters().isDisplayed()) {
			Assert.fail("Hide Filter is not working");
		}
	}

	public ArrayList<Float> productsPrice(WebElement element, String msg) {

		ArrayList<Float> list = new ArrayList<Float>();
		navigateToPDP();
		webclick(pdp.getSortOptions(), "Sorting");
		webclick(element, msg);
		for (WebElement ele : pdp.getProductPrices()) {
			float price = Float.parseFloat(getText(ele).replace("$", "").replace(",", "").trim());
			list.add(price);
		}
		return list;
	}

	Boolean ascendingCheck(ArrayList<Float> data) {
		for (int i = 0; i < data.size() - 1; i++) {
			if (data.get(i) > data.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	Boolean decendingCheck(ArrayList<Float> data) {
		for (int i = 0; i < data.size() - 1; i++) {
			if (data.get(i) < data.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public void navigateToPDP() {
		login("TumiTestData", "TumiLogin");
		// mouseHover(pdp.getShopByBags());
		domClick(pdp.getShopByBriefcases(), "Briefcases");
		String count[] = getText(pdp.getTotalProductsCount()).split(" ");

	}
}
