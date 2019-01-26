package orders.guest;

import java.util.Map;


import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.tumi.dataProvider.ReadTestData;
import com.tumi.utilities.GenericMethods;
import com.tumi.utilities.GlobalConstants;
import com.tumi.utilities.TumiLibs;

/**
 * @author Shwetha  Capo
 *
 */
public class TumiStudioOrder extends GenericMethods{
	
	Map<String, String> testData= ReadTestData.retrieveData("Login", "TumiStudioOrder");
	
	@Test
	public void testTumiIdOrder() throws InterruptedException{
		
		TumiLibs.closeSignUpForUS();
		final String pdpURL = GlobalConstants.url+"/p/"+testData.get("SKUID");
		driver.get(pdpURL);
		
		click(tumiId.getTumiIdDesign(),"click on TumiID");
		
		delay(2000);
		//click(tumiId.getMainBody(),"Main Body");
		click(tumiId.getShadowGrayColor(),"Main Body in Shadow gray Color");
		delay(2000);
		click(tumiId.getFrontPocket(),"Front Pocket");
		click(tumiId.getBlackColor(),"Front Pocket Red Color");
		click(tumiId.getSidePockets(), "Side Pockets");
		click(tumiId.getAtlanticBlueColor(), "Side Pocket Blue Color");
		click(tumiId.getPatchnTag(), "Patch & Tag");
		click(tumiId.getRedColor(),"Patch n Tag in Red color");
		click(tumiId.getWebbing(), "Webbing");
		click(tumiId.getBlackColor(), "Webbing Color");
		click(tumiId.getLeatherAccents(),"Leather Accents");
		click(tumiId.getAtlanticBlueColor(),"Leather in Blue color");
		click(tumiId.getHardWare(), "Hard Ware");
		click(tumiId.getGoldColor(), "Hardware in Gold Color");
		click(tumiId.getExternalZipper(), "External Zipper");
		click(tumiId.getAtlanticBlueColor(), "External Zipper in blue color");
		click(tumiId.getAccentZipper(), "Accent Zipper");
		click(tumiId.getGoldColor(),"Accent in gold color");
		click(tumiId.getInteriorLining(), "Interior Lining");
		click(tumiId.getFossilColor(),"Interior in Fossil color");
		//monogram
		click(tumiId.getMonograming(),"tumiIdgramming");
		delay(2000);
		click(tumiId.getHeart(),"Heart symbol");
		click(tumiId.getHeart(),"Heart symbol");
		click(tumiId.getHeart(),"Heart Symbol");
		/*input(tumiId.getFirstInput(), tumiId.getHeart(), "First tumiId Input");
		input(tumiId.getSecondInput(), tumiId.getHeart(), "Second tumiId Input");
		input(tumiId.getThirdInput(), tumiId.getHeart(), "Third tumiId Input");*/
		click(tumiId.getFirstNext(),"Next");
		click(tumiId.getTumiWhiteColor(),"White color");
		click(tumiId.getSecondNext(), "Next");
		click(tumiId.getCheckBox(), "Check for both apply");
		click(tumiId.getApply(),"Apply");
		click(tumiId.getSaveDesign(),"Save");
		
	}

	
}
