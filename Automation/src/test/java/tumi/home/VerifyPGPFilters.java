package tumi.home;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.utilities.GenericMethods;



/**
 * @author Shwetha  Capo
 *
 */
public class VerifyPGPFilters extends GenericMethods {

	/*
	 * TA- 68 Verify PGP Filters.
	 */

	@Test(priority = 0, description = " Sprint 3- TA-68 Verify Colors")
	public void verifyColors() {
		goToPGP();
	//	System.out.println(pgp.getColorsList().size());
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
	//	System.out.println(attList);

		if (attList.size() == colorsList.size()) {
			logger.log(Status.INFO, "Verification of Color Filter is successfull");
		} else {
			Assert.fail("Verification of Color Filter is failed");
		}
	}
	
	
	@Test(priority = 0, description = " Sprint 3- TA-68 Verify Colors")
	public void countProductInProductType() {
		
	}
	

	public void goToPGP() {
		mouseHover(pgp.getluggage());
		click(pgp.getCarryOnLuggage(), "Carry on Luggage");
	}

}
