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

	@Test
	public void compareProducts() {

		login("TumiTestData", "RegisteredOrders");
		mouseHover(driver.findElement(By.xpath("//a[text()='Bags']")));
		click(driver.findElement(By.xpath("//a[text()='Wheeled Briefcases']")), "Wheeled Briefcases");
		Assert.assertEquals(pdp.getCompareLabelSize().size(), 3);

		for (int i = 1; i < pdp.getCompareProductsList().size(); i++) {

			WebElement ele = driver
					.findElement(By.xpath("//div[@lmzone='subCategoryPage']/div[2]/div[" + i + "]/div[4]/a"));
				ele.click();
			if (i == 4) {
				if (getText(pdp.getGlobalMessage()).equals(getProperty("compareproducts.error"))) {
					logger.log(Status.PASS, "You Cannot Compare Morethan 3 Products");
					break;
				}else {
					Assert.fail("You Cannot Compare Morethan 3 Products");
				}
			}
		}
		String parent = driver.getWindowHandle();
		webclick(pdp.getCompareNow(), "Compare Products");
		Set<String> childs = driver.getWindowHandles();
		Iterator<String> ite = childs.iterator();
		while(ite.hasNext()) {
			String child = ite.next();
			driver.switchTo().window(child);
			driver.close();
		}
		driver.switchTo().window(parent);
		System.out.println("");

	}

}
