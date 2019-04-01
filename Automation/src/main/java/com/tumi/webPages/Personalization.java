package com.tumi.webPages;

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
public class Personalization extends GenericMethods {

	public Personalization(WebDriver driver) {
		Reports.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'add-a-mono-layer')]")
	private WebElement addClassic;

	public WebElement getAddClassic() {
		return addClassic;
	}// div[@id='monogram-step1']//h3/span[2]

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step1']//h3/span[2]")
	private WebElement step1;

	public WebElement getStep1() {
		return step1;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='classicPatch']")
	private WebElement addPatch;

	public WebElement getAddPatch() {
		return addPatch;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='classicLuggageTag']")
	private WebElement addTag;

	public WebElement getAddTag() {
		return addTag;
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'monogram-btn-cntr metal')]/a")
	private WebElement optionsNext;

	public WebElement getOptionsNext() {
		return optionsNext;
	}

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'monogram-added-text')]")
	private WebElement successMsg;

	public WebElement getSuccessMsg() {
		return successMsg;
	}

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'monogram-btn-cntr metal-btn')]/a")
	private WebElement koreaFirstStep;

	public WebElement getKoreaFirstStep() {
		return koreaFirstStep;
	}

	@FindBy(how = How.XPATH, using = "(//a[@id='monogramming-popup-link'])[1]/span")
	private WebElement addPersonalization;

	public WebElement getAddPersonalization() {
		return addPersonalization;
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Complimentary of Premium Options')]")
	private WebElement complimentaryMono;

	public WebElement getComplimentaryMono() {
		return complimentaryMono;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step1']/div[2]/label")
	private WebElement addHash;

	public WebElement getAddHash() {
		return addHash;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step1']/div[2]/label[2]")
	private WebElement addHeart;

	public WebElement getAddHeart() {
		return addHeart;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step1']/div[2]/label[3]")
	private WebElement addAtTheRate;

	public WebElement getAddAtTheRate() {
		return addAtTheRate;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step1']/div[2]/label[4]")
	private WebElement addSmiley;

	public WebElement getAddSmiley() {
		return addSmiley;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step1']/div[2]/label[5]")
	private WebElement addStar;

	public WebElement getAddStar() {
		return addStar;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step1']/div[2]/label[6]")
	private WebElement addClub;

	public WebElement getAddClub() {
		return addClub;
	}

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Next')])[2]")
	private WebElement next;

	@FindBy(how = How.XPATH, using = "(//div[contains(@class,'monogram-btn-cntr')]/a[2])[1]")
	
	private WebElement krnext;

	public WebElement getNext() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return explicitWait(next);

		} else {
			return explicitWait(krnext);

		}
	}

	@FindBy(how = How.XPATH, using = "//input[@name='monogram_initial_1']")
	private WebElement firstMonoInput;

	public WebElement getFirstMonoInput() {
		return firstMonoInput;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='monogram_initial_2']")
	private WebElement secondMonoInput;

	public WebElement getSecondMonoInput() {
		return secondMonoInput;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='monogram_initial_3']")
	private WebElement thirdMonoInput;

	public WebElement getThirdMonoInput() {
		return thirdMonoInput;
	}

	@FindBy(how = How.XPATH, using = "(//a[@id='monogramming-popup-link'])[3]")
	private WebElement editMono;

	public WebElement getEditMono() {
		return editMono;
	}

	@FindBy(how = How.XPATH, using = "//span[@class='addMono']")
	private WebElement addMonoMsg;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'addMono')]")
	private WebElement kraddMonoMsg;

	public WebElement getAddMonoMsg() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {

			return addMonoMsg;

		} else {
			return kraddMonoMsg;
		}
	}

	@FindBy(how = How.XPATH, using = "//a[contains(@class,'monogram remove')]")
	private WebElement remove;

	/*@FindBy(how = How.XPATH, using = "")
	private WebElement kRremove;*/

	public WebElement getRemove() {
		//if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {

			return remove;

		/*} else {
			return kRremove;
		}*/
	}

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Classic Monogram Added')]")
	private WebElement monoAdded;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Classic Monogram Added')]")
	private WebElement krMonoAdded;

	public WebElement getMonoAdded() {
		if (selectedCountry.contains("US") || selectedCountry.contains("Canada")) {
			return monoAdded;

		} else {
			return krMonoAdded;

		}
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div[2]/div/label")
	private WebElement whiteColor;

	public WebElement getWhiteColor() {
		return whiteColor;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div[2]/div/label[2]")
	private WebElement fuchsiaColor;

	public WebElement getFuchsiaColor() {
		return fuchsiaColor;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div[2]/div/label[3]")
	private WebElement redColor;

	public WebElement getRedColor() {
		return redColor;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div[2]/div/label[4]")
	private WebElement pinkColor;

	public WebElement getPinkColor() {
		return pinkColor;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div[2]/div/label[5]")
	private WebElement blueColor;

	public WebElement getBlueColor() {
		return blueColor;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div[2]/div/label[6]")
	private WebElement greenColor;

	public WebElement getGreenColor() {
		return greenColor;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div[2]/div/label[7]")
	private WebElement cafeColor;

	public WebElement getCafeColor() {
		return cafeColor;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div[2]/div/label[8]")
	private WebElement orangeColor;

	public WebElement getOrangeColor() {
		return orangeColor;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div[2]/div/label[9]")
	private WebElement yellowColor;

	public WebElement getYellowColor() {
		return yellowColor;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div[2]/div/label[10]")
	private WebElement blindColor;

	public WebElement getBlindColor() {
		return blindColor;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div[2]/div/label[11]")
	private WebElement silverColor;

	public WebElement getSilverColor() {
		return silverColor;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div[2]/div/label[12]")
	private WebElement goldColor;

	public WebElement getGoldColor() {
		return goldColor;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div[2]/div/label[13]")
	private WebElement blackColor;

	public WebElement getBlackColor() {
		return blackColor;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div/label")
	private WebElement textStyleBold;

	public WebElement getTextStyleBold() {
		return textStyleBold;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div/label[2]")
	private WebElement textStyleFutura;

	public WebElement getTextStyleFutura() {
		return textStyleFutura;
	}

	@FindBy(how = How.XPATH, using = "(//input[@type='checkbox'])[5]")
	private WebElement checkBox;

	public WebElement getCheckBox() {
		return checkBox;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step2']/div[3]/a[2]")
	private WebElement secondNext;

	public WebElement getSecondNext() {
		return secondNext;
	}

	@FindBy(how = How.XPATH, using = "(//a[contains(text(),'Previous')])[1]")
	private WebElement previous;

	public WebElement getPrevious() {
		return previous;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='monogram-step3']/div[3]/a[2]")
	private WebElement apply;

	public WebElement getApply() {
		return explicitWait(apply);

	}
	@FindBy(how = How.XPATH, using = "//div[@id='globalMessages']/div")
	private WebElement monoErrorMsgatCart;

	public WebElement getMonoErrorMsgAtCart() {
		return monoErrorMsgatCart;
	}
	@FindBy(how = How.XPATH, using = "//div[@id='popup_monogramming_form_3']/div[2]/div")
	private WebElement monoErrorMsg;

	public WebElement getMonoErrorMsg() {
		return monoErrorMsg;
	}

}
