package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {
	
	public WebDriver driver;
	
	public LeadsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//img[contains(@title,'Create Lead')]")
	private WebElement createLeadBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Search in Leads')]")
	private WebElement searchInLeadsBtn;
	
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
	
	@FindBy(xpath = "//img[contains(@title,'Import Leads')]")
	private WebElement importLeadsBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Export Leads')]")
	private WebElement exportLeadsBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Find Duplicates')]")
	private WebElement findDuplicateBtn;
	
	@FindBy(xpath = "//img[contains(@title,'Leads Settings')]")
	private WebElement leadsSettingsBtn;
	
	@FindBy(xpath = "//input[@class='txtBox']")
	private WebElement searchForTF;
	
	@FindBy(id= "bas_searchfield")
	private WebElement searchInDD;
	
	@FindBy(xpath = "//div[@id='searchAcc']/descendant::input[@name='submit']")
	private WebElement searchNowBtn;

	public WebElement getCreateLeadBtn() {
		return createLeadBtn;
	}

	public WebElement getSearchInLeadsBtn() {
		return searchInLeadsBtn;
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

	public WebElement getImportLeadsBtn() {
		return importLeadsBtn;
	}

	public WebElement getExportLeadsBtn() {
		return exportLeadsBtn;
	}

	public WebElement getFindDuplicateBtn() {
		return findDuplicateBtn;
	}

	public WebElement getLeadsSettingsBtn() {
		return leadsSettingsBtn;
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
