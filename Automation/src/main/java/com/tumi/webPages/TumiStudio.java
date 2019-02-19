package com.tumi.webPages;

import java.util.List;

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
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div/label")
	private List<WebElement> mainBodyList;
	
	public List<WebElement> getMainBodyList() {
		return mainBodyList;
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_fp']")
	private WebElement frontPocket;
	
	public WebElement getFrontPocket() {
		return explicitWait(frontPocket);
	}
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div/label")
	private List<WebElement> frontPocketList;
	
	public List<WebElement> getFrontPocketList() {
		return frontPocketList;
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_sp']")
	private WebElement sidePockets;
	
	public WebElement getSidePocket() {
		return explicitWait(sidePockets);
	}
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div/label")
	private List<WebElement> sidePocketList;
	
	public List<WebElement> getSidePocketList() {
		return sidePocketList;
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_pt']")
	private WebElement patchnTag;
	
	public WebElement getPatchnTag() {
		return patchnTag;
	}
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div/label")
	private List<WebElement> patchnTagList;
	
	public List<WebElement> getPatchnTagList() {
		return patchnTagList;
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_wb']")
	private WebElement webbing;
	
	public WebElement getWebbing() {
		return webbing;
	}
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div/label")
	private List<WebElement> webbingList;
	
	public List<WebElement> getWebbingList() {
		return webbingList;
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_la']")
	private WebElement leatherAccents;

	public WebElement getLeatherAccents() {
		return leatherAccents;
	}
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div/label")
	private List<WebElement> leatherAccentsList;
	
	public List<WebElement> getLeatherAccentsList() {
		return leatherAccentsList;
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_hw']")
	private WebElement hardWare;

	public WebElement getHardWare() {
		return hardWare;
	}
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div/label")
	private List<WebElement> hardwareList;

	public List<WebElement> getHardwareList() {
		return hardwareList;
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_ez']")
	private WebElement externalZipper;

	public WebElement getExternalZipper() {
		return externalZipper;
	}
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div/label")
	private List<WebElement> externalZipperList;

	public List<WebElement> getExternalZipperList() {
		return externalZipperList;
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_az']")
	private WebElement accentZipper;

	public WebElement getAccentZipper() {
		return accentZipper;
	}
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div/label")
	private List<WebElement> accentZipperList;

	public List<WebElement> getAccentZipperList() {
		return accentZipperList;
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='opt_ln']")
	private WebElement interiorLining;

	public WebElement getInteriorLining() {
		return interiorLining;
	}
	
	@FindBy(how=How.XPATH, using="//div[@class='swatch-block-wrapper active']/div/div/label")
	private List<WebElement> interiorLiningList;

	public List<WebElement> getinteriorLiningList() {
		return interiorLiningList;
	}

	
	@FindBy(how=How.XPATH, using="//div[@id='opt_undefined']")
	private WebElement monograming;
	
	public WebElement getMonogram() {
		return monograming;
	}
	
	
	
	@FindBy(how=How.XPATH, using="//div[@class='btn-block']/a")
	private WebElement saveDesign;
	
	public void setTumiIdDesign(WebElement tumiIdDesign) {
		this.tumiIdDesign = tumiIdDesign;
	}

	

	public WebElement getSaveDesign() {
		return saveDesign;
	}
	
	//Monogram
	
	@FindBy(how=How.XPATH, using="//div[@class='symbols-container static']/label")
	private List<WebElement> firstStepIntials;
	
	public List<WebElement> getFirstStepIntials() {
		return firstStepIntials;
	}
	@FindBy(how=How.XPATH,using="(//div[@class='step-buttons']/button)[1]")
	private WebElement firstNext;
	
	public WebElement getFirstNext() {
		return firstNext;
	}

	@FindBy(how=How.XPATH, using="//div[@class='swatches-container ']/div/label")
	private List<WebElement> chooseColor;
	
	public List<WebElement> getChooseColor() {
		return chooseColor;
	}
	
	
	@FindBy(how=How.XPATH, using="(//div[@class='step-buttons']/button)[3]")
	private WebElement secondNext;
	
	public WebElement getSecondNext() {
		return secondNext;
	}
	
	@FindBy(how=How.XPATH, using="//label[@class='use-all ']/input")
	private WebElement checkBox;
	
	public WebElement getCheckBox() {
		return checkBox;
	}
	
	@FindBy(how=How.XPATH, using="(//button[contains(text(),'Apply')])")
	private WebElement apply;
	
	public WebElement getApply() {
		return apply;
	}

	
	@FindBy(how=How.XPATH, using="//div[@id='monogram-step2']/div/label")
	private WebElement textStyleBold;
	
	public WebElement getTextStyleBold() {
		return textStyleBold;
	}
	
	@FindBy(how=How.XPATH, using="//div[@id='monogram-step2']/div/label[2]")
	private WebElement textStyleFutura;
	
	public WebElement getTextStyleFutura() {
		return textStyleFutura;
	}

	
	//(//div[@class='step-buttons']/button)[2]
	@FindBy(how=How.XPATH, using="(//button[contains(text(),'Previous')])[2]")
	private WebElement firstPrevious;
	
	public WebElement getFirstPrevious() {
		return firstPrevious;
	}
	
	@FindBy(how=How.XPATH, using="(//button[contains(text(),'Previous')])[3]")
	private WebElement secondPrevious;
	
	public WebElement getSecondPrevious() {
		return secondPrevious;
	}
	
	
	
}
