package orders.registered;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.utilities.GenericMethods;

public class CompareProducts extends GenericMethods {

	@Test(priority = 0, description = "TA- 70 : Verify Compare in PGP")
	public void compareProducts() {

		userLogin("TumiTestData", "RegisteredOrders");
		delay(2000);
		mouseHover(compare.getBagsCategory());
		click(compare.getCrossbodiesInBags(), "Crossbodies");
		Assert.assertEquals(pdp.getCompareLabelSize().size(), 3);
		System.out.println(pdp.getCompareLabelSize().size());
		// for (int i = 1; i < pdp.getCompareProductsList().size(); i++) {

		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {

			for (int i = 1; i < pdp.getCompareLabelSize().size(); i++) {

				WebElement ele = driver
						.findElement(By.xpath("//div[@lmzone='subCategoryPage']/div[2]/div[" + i + "]/div[4]/a"));
				ele.click();

				if (i == 4) {
					if (getText(pdp.getGlobalMessage()).equals(getProperty("compareproducts.error"))) {
						logger.log(Status.PASS, "You Cannot Compare Morethan 3 Products");
						break;
					} else {
						Assert.fail("You Cannot Compare Morethan 3 Products");
					}

				}
			}
		} else {

			for (int j = 2; j < pdp.getCompareLabelSize().size()+1; j++) {
				WebElement ele1 = driver
						.findElement(By.xpath("//div[@lmzone='subCategoryPage']/div[2]/div[" + j + "]/div[4]/a"));
				ele1.click();

				if (j == 5) {
					if (getText(pdp.getGlobalMessage()).equals(getProperty("compareproducts.error"))) {
						logger.log(Status.PASS, "You Cannot Compare Morethan 3 Products");
						break;
					} else {
						Assert.fail("You Cannot Compare Morethan 3 Products");
					}
				}
			}
		}

		logger.log(Status.INFO, "Intially added 2 products to Compare");

		String parent = driver.getWindowHandle();

		domClick(pdp.getCompareNow(), "Compare Products");
		logger.log(Status.INFO, "User is able to add products to compare and successfully navigated to Compare page.");

		try {
			if (compare.getProductInSuggestions().isDisplayed()) {
				click(compare.getProductInSuggestions(), "Compare");
				logger.log(Status.INFO, "Successfully added 3rd product to compare in Compare page");
			} 
		} catch (Exception e) {
			
				Assert.fail("Product suggestions not enabled to add one more product to compare");
		}
		/*
		 * try { for (int i = 1; i < compare.getProductSuggestionsList().size(); i++) {
		 * 
		 * click(compare.getProductInSuggestions(),"Compare"); logger.log(Status.INFO,
		 * "Successfully added 3rd product to compare in Compare page"); break;
		 * 
		 * } } catch (Exception e) { Assert.
		 * fail("Product suggestions not enabled to add one more product to compare"); }
		 */

	}
}
