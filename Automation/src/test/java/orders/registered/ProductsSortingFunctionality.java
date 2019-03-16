package orders.registered;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.tumi.utilities.GenericMethods;

/**
 * @author Suresh
 *
 */
public class ProductsSortingFunctionality extends GenericMethods {

	@Test(priority = 0)
	public void verifyProductAToZSorting() {

		login("TumiTestData", "RegisteredOrders");
		mouseHover(pdp.getShopByBags());
		click(pdp.getShopByBriefcases(), "Wheeled Briefcases");
		webclick(pdp.getSortOptions(), "Sorting");
		webclick(pdp.getSortAToZ(), "A to Z");
		// webclick(driver.findElement(By.xpath("//span[text()='Compare']")), "");
		for (int i = 1; i < pdp.getListOfProductNames().size(); i++) {

			String product1 = getText(driver
					.findElement(By.xpath("//div[@lmzone='subCategoryPage']/div[2]/div[" + i + "]/div[2]/div/a/div")));
			String product2 = getText(driver.findElement(
					By.xpath("//div[@lmzone='subCategoryPage']/div[2]/div[" + (i + 1) + "]/div[2]/div/a/div")));
			int sortAToZ = product1.compareTo(product2);

			if (sortAToZ > 0) {

				Assert.fail(product1 + "And" + product2 + "are not in A to Z order");
			}
		}
	}

	@Test(priority = 1)
	public void verifyProductZToASorting() {

		login("TumiTestData", "RegisteredOrders");
		mouseHover(pdp.getShopByBags());
		click(pdp.getShopByBriefcases(), "Wheeled Briefcases");
		webclick(pdp.getSortOptions(), "Sorting");
		webclick(pdp.getSortZToA(), "Z to A");
		for (int i = 1; i < pdp.getListOfProductNames().size(); i++) {

			String product1 = getText(driver
					.findElement(By.xpath("//div[@lmzone='subCategoryPage']/div[2]/div[" + i + "]/div[2]/div/a/div")));
			String product2 = getText(driver.findElement(
					By.xpath("//div[@lmzone='subCategoryPage']/div[2]/div[" + (i + 1) + "]/div[2]/div/a/div")));
			int sortZToA = product1.compareTo(product2);

			if (sortZToA < 0) {

				Assert.fail(product1 + " And " + product2 + " are not in Z to A order");
			}
		}
	}
}
