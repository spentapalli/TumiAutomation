//Sprint-3
package com.tumi.home;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.UIFunctions;
import com.tumi.webPages.PGP;

public class HomepPageTumiLogo extends GenericMethods  {
	/* TA-348
	 * Verify Categories on Home page at Tumi Logo.
	 */
	Map<String, String> testData = ReadTestData.getJsonData("TumiTestData", "GuestDetails");
	@Test(priority = 0, description = " Sprint 3- TA-348 Verify Categories on Home page at Tumi Logo")
	public void VerifyTumicategories(){
		if (selectedCountry.equals("US")) {
					mouseHover(home.getLuggageOption());
					click(pgp.getCarryOnLuggage(),"Carry on Luaggage");
					if (getText(pgp.getCategoryTitle()).contains("Title Category")) {
						logger.log(Status.INFO, "Selection of product successfull");
					
					}
					
			/*
			 * mouseHover(home.getBackPackOption());
			 * click(home.getBackPackTestBridgewater(),"TestBridgeWater"); if
			 * (getText(pgp.getCategoryTitle()).contains("Title Category")) {
			 * logger.log(Status.INFO, "Selection of product successfull"); }
			 * mouseHover(home.getBagOptions());
			 * click(home.getBagwheeledBriefCase(),"BagWheeledBriefCase"); if
			 * (getText(pgp.getCategoryTitle()).contains("Title Category")) {
			 * logger.log(Status.INFO, "Selection of product successfull"); }
			 * mouseHover(home.getAccessoriesOptions());
			 * click(home.getAccessoriesKeyFobs(),"key Fobs"); if
			 * (getText(pgp.getCategoryTitle()).contains("Title Category")) {
			 * logger.log(Status.INFO, "Selection of product successfull"); }
			 * mouseHover(home.getSalesOptions());
			 * click(home.getSalesVoyageurCollection(),"Voyageur collection"); if
			 * (getText(pgp.getCategoryTitle()).contains("Title Category")) {
			 * logger.log(Status.INFO, "Selection of product successfull");
			 * 
			 * }
			 */
			}
	}
	
@Test(priority = 1, description = " Sprint 3- TA-348 Verify Categories on Home page at Tumi Logo")
public void VerifyTumiLogo(){
	if (selectedCountry.contains("Canada")) {
	
	}
}
}
			




