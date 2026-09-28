package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage {
	
	public WebDriver driver;
	
	public OpportunitiesPage(WebDriver driver)
	{	
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[contains(@title,'Create Opportunity')]")
	private WebElement createOpportunityBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Search in Opportunities')]")
	private WebElement searchInOpportunitiesBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Open Calendar')]")
	private WebElement openCalBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Show World Clock')]")
	private WebElement shwWrldClckBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Open Calculator')]")
	private WebElement openCalciBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Chat')]")
	private WebElement chatBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Last Viewed')]")
	private WebElement lastViewdBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Import Opportunities')]")
	private WebElement importOpportunitiesBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Export Opportunities')]")
	private WebElement exportOpportunitiesBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Find Duplicates')]")
	private WebElement findDuplicateBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Opportunities Settings')]")
	private WebElement opportunitiesSettingsBtn;
	
	@FindBy(xpath = "//input[@class='txtBox's]")
	private WebElement searchForTF;
	
	@FindBy(id= "bas_searchfield")
	private WebElement searchInDD;
	
	@FindBy(xpath = "//div[@id='searchAcc']/descendant::input[@name='submit']")
	private WebElement searchNowBtn;

	public WebElement getCreateOpportunityBtn() {
		return createOpportunityBtn;
	}

	public WebElement getSearchInOpportunitiesBtn() {
		return searchInOpportunitiesBtn;
	}

	public WebElement getOpenCalBtn() {
		return openCalBtn;
	}

	public WebElement getShwWrldClckBtn() {
		return shwWrldClckBtn;
	}

	public WebElement getOpenCalciBtn() {
		return openCalciBtn;
	}

	public WebElement getChatBtn() {
		return chatBtn;
	}

	public WebElement getLastViewdBtn() {
		return lastViewdBtn;
	}

	public WebElement getImportOpportunitiesBtn() {
		return importOpportunitiesBtn;
	}

	public WebElement getExportOpportunitiesBtn() {
		return exportOpportunitiesBtn;
	}

	public WebElement getFindDuplicateBtn() {
		return findDuplicateBtn;
	}

	public WebElement getOpportunitiesSettingsBtn() {
		return opportunitiesSettingsBtn;
	}

	public WebElement getSearchForTF() {
		return searchForTF;
	}

	public WebElement getSearchInDD() {
		return searchInDD;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	
	
	
}
