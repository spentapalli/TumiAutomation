package com.tumi.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tumi.reports.Reports;
import com.tumi.utilities.GenericMethods;

/**
 * @author Shwetha Capo
 *
 */
public class TumiStudio extends GenericMethods {
	
	public TumiStudio(WebDriver driver) {
		Reports.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'Design Your Own')]")
	private WebElement tumiIdDesign;
	
	public WebElement getTumiIdDesign() {
		return tumiIdDesign;
	}

	

	@FindBy(how=How.XPATH, using="//div[@id='opt_mb']")
	private WebElement mainBody;
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_fp']")
	private WebElement frontPocket;
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_sp']")
	private WebElement sidePockets;
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_pt']")
	private WebElement patchnTag;
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_wb']")
	private WebElement webbing;
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_la']")
	private WebElement leatherAccents;
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_hw']")
	private WebElement hardWare;
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_ez']")
	private WebElement externalZipper;
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_az']")
	private WebElement accentZipper;
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_ln']")
	private WebElement interiorLining;
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_undefined']")
	private WebElement monograming;
	
	//Main Body
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div")
	private WebElement blackColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div[2]")
	private WebElement shadowGrayColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div[3]")
	private WebElement redColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div[4]")
	private WebElement atlanticBlueColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div[5]")
	private WebElement sunriseOrangeColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div[6]")
	private WebElement summitYellowColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div[7]")
	private WebElement greenCamoColor;
	
	
	//Front Pocket
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div[2]")
	private WebElement goldColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div[3]")
	private WebElement metalSilver;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div[4]")
	private WebElement antiqueSilver;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div[2]")
	private WebElement silverBlack;
	
	public WebElement getSilverBlack() {
		return silverBlack;
	}

	public WebElement getFossilColor() {
		return fossilColor;
	}

	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div[3]")
	private WebElement fossilColor;
	
	@FindBy(how=How.XPATH, using="//div[@id='amplience_configurator']/div[7]/a")
	private WebElement saveDesign;
	
	public void setTumiIdDesign(WebElement tumiIdDesign) {
		this.tumiIdDesign = tumiIdDesign;
	}

	public WebElement getMainBody() {
		return mainBody;
	}

	public WebElement getFrontPocket() {
		return frontPocket;
	}

	public WebElement getSidePockets() {
		return sidePockets;
	}

	public WebElement getPatchnTag() {
		return patchnTag;
	}

	public WebElement getWebbing() {
		return webbing;
	}

	public WebElement getLeatherAccents() {
		return leatherAccents;
	}

	public WebElement getHardWare() {
		return hardWare;
	}

	public WebElement getExternalZipper() {
		return externalZipper;
	}

	public WebElement getAccentZipper() {
		return accentZipper;
	}

	public WebElement getInteriorLining() {
		return interiorLining;
	}

	public WebElement getMonograming() {
		return monograming;
	}

	public WebElement getBlackColor() {
		return blackColor;
	}

	public WebElement getShadowGrayColor() {
		return shadowGrayColor;
	}

	public WebElement getRedColor() {
		return redColor;
	}

	public WebElement getAtlanticBlueColor() {
		return atlanticBlueColor;
	}

	public WebElement getSunriseOrangeColor() {
		return sunriseOrangeColor;
	}

	public WebElement getSummitYellowColor() {
		return summitYellowColor;
	}

	public WebElement getGreenCamoColor() {
		return greenCamoColor;
	}

	public WebElement getGoldColor() {
		return goldColor;
	}

	public WebElement getMetalSilver() {
		return metalSilver;
	}

	public WebElement getAntiqueSilver() {
		return antiqueSilver;
	}

	public WebElement getSaveDesign() {
		return saveDesign;
	}
	
	//Monogram
	
	@FindBy(how=How.XPATH, using="//div[@class='symbols-container']/label")
	private WebElement ash; 
	
	public WebElement getAsh() {
		return ash;
	}

	
	@FindBy(how=How.XPATH, using="//div[@class='symbols-container']/label[2]")
	private WebElement heart;
	
	@FindBy(how=How.XPATH, using="//div[@class='symbols-container']/label[3]")
	private WebElement attherate;
	
	@FindBy(how=How.XPATH,using="//div[@class='symbols-container']/label[4]")
	private WebElement smiley;
	
	@FindBy(how=How.XPATH,using="//div[@class='symbols-container']/label[5]")
	private WebElement star;
	
	@FindBy(how=How.XPATH,using="//div[@class='symbols-container']/label[6]")
	private WebElement club;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatches-container']/div")
	private WebElement tumiWhiteColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatches-container']/div[2]")
	private WebElement tumiFuchsiaColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatches-container']/div[3]")
	private WebElement tumiRedColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatches-container']/div[4]")
	private WebElement tumiPinkColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatches-container']/div[5]")
	private WebElement tumiBlueColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatches-container']/div[6]")
	private WebElement tumiGreenColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatches-container']/div[7]")
	private WebElement tumiCafeColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatches-container']/div[8]")
	private WebElement tumiOrangeColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatches-container']/div[9]")
	private WebElement tumiYellowColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatches-container']/div[10]")
	private WebElement tumiBlindColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatches-container']/div[11]")
	private WebElement tumiSilverColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatches-container']/div[12]")
	private WebElement tumiGoldColor;
	
	@FindBy(how=How.XPATH, using="//div[@class='swatches-container']/div[13]")
	private WebElement tumiBlackColor;
	
	@FindBy(how=How.XPATH, using="//div[@id='monogram-step2']/div/label")
	private WebElement textStyleBold;
	
	@FindBy(how=How.XPATH, using="//div[@id='monogram-step2']/div/label[2]")
	private WebElement textStyleFutura;

	@FindBy(how=How.XPATH,using="(//div[@class='step-buttons']/button)[1]")
	private WebElement firstNext;
	
	@FindBy(how=How.XPATH, using="(//div[@class='step-buttons']/button)[3]")
	private WebElement secondNext;
	
	@FindBy(how=How.XPATH, using="//label[@class='use-all']/input")
	private WebElement checkBox;
	
	//(//div[@class='step-buttons']/button)[2]
	@FindBy(how=How.XPATH, using="(//button[contains(text(),'Previous')])[2]")
	private WebElement firstPrevious;
	
	@FindBy(how=How.XPATH, using="(//button[contains(text(),'Previous')])[3]")
	private WebElement secondPrevious;
	
	@FindBy(how=How.XPATH, using="(//button[contains(text(),'Apply')])")
	private WebElement apply;
	
	public WebElement getHeart() {
		return heart;
	}

	public WebElement getSmiley() {
		return smiley;
	}

	public WebElement getStar() {
		return star;
	}

	public WebElement getClub() {
		return club;
	}

	public WebElement getTumiWhiteColor() {
		return tumiWhiteColor;
	}

	public WebElement getTumiFuchsiaColor() {
		return tumiFuchsiaColor;
	}

	public WebElement getTumiRedColor() {
		return tumiRedColor;
	}

	public WebElement getTumiPinkColor() {
		return tumiPinkColor;
	}

	public WebElement getTumiBlueColor() {
		return tumiBlueColor;
	}

	public WebElement getTumiGreenColor() {
		return tumiGreenColor;
	}

	public WebElement getTumiCafeColor() {
		return tumiCafeColor;
	}

	public WebElement getTumiOrangeColor() {
		return tumiOrangeColor;
	}

	public WebElement getTumiYellowColor() {
		return tumiYellowColor;
	}

	public WebElement getTumiBlindColor() {
		return tumiBlindColor;
	}

	public WebElement getTumiSilverColor() {
		return tumiSilverColor;
	}

	public WebElement getTumiGoldColor() {
		return tumiGoldColor;
	}

	public WebElement getTumiBlackColor() {
		return tumiBlackColor;
	}

	public WebElement getTextStyleBold() {
		return textStyleBold;
	}

	public WebElement getTextStyleFutura() {
		return textStyleFutura;
	}

	public WebElement getFirstNext() {
		return firstNext;
	}

	public WebElement getSecondNext() {
		return secondNext;
	}

	public WebElement getFirstPrevious() {
		return firstPrevious;
	}

	public WebElement getSecondPrevious() {
		return secondPrevious;
	}

	public WebElement getApply() {
		return apply;
	}

	public WebElement getAttherate() {
		return attherate;
	}
	@FindBy(how=How.XPATH, using="//div[@class='box-container']/input")
	private WebElement firstInput;
	
	@FindBy(how=How.XPATH, using="//div[@class='box-container']/input[2]")
	private WebElement secondInput;
	
	@FindBy(how=How.XPATH, using="//div[@class='box-container']/input[3]")
	private WebElement thirdInput;

	public WebElement getFirstInput() {
		return firstInput;
	}

	public WebElement getSecondInput() {
		return secondInput;
	}

	public WebElement getThirdInput() {
		return thirdInput;
	}

	public WebElement getCheckBox() {
		// TODO Auto-generated method stub
		return checkBox;
	}
	

}
