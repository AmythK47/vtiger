package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;

/**
 * 
 * 1. This class is a Object Repository for Create Opportunities Page.
 * 2. This contains 2 business libraries selecting Sales Stage and entering close date for the opportunities 
 *  
 * @author Amit
 * 
 */

public class CreateOpportunityPage {
	
	public WebDriver driver;
	
	public CreateOpportunityPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='potentialname']")
	private WebElement oppNameTF;
	
	@FindBy(id = "related_to_type")
	private WebElement relatedToDD;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement relatedToSelectBtn;
	
	@FindBy(xpath = "//input[@name='closingdate']")
	private WebElement exptdCloseDate;

	@FindBy(xpath = "//select[@name='sales_stage']")
	private WebElement salesStageDD;
	
	@FindBy(xpath = "//input[contains(@title,'Save') and @type = 'submit']")
	private WebElement saveBtn;

	public WebElement getOppNameTF() {
		return oppNameTF;
	}

	public WebElement getRelatedToDD() {
		return relatedToDD;
	}

	public WebElement getRelatedToSelectBtn() {
		return relatedToSelectBtn;
	}

	public WebElement getExptdCloseDate() {
		return exptdCloseDate;
	}

	public WebElement getSalesStageDD() {
		return salesStageDD;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	@FindBy(id = "search_txt")
	private WebElement searchTF;

	@FindBy(xpath="//input[@type='button']")
	private WebElement searchBtn;
	
	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	@FindBy(xpath = "//a[@id='1']")
	private WebElement orgSelectLnk;
	
	
	
	//Business utilities
	
	public void createOpportunity(String oppName, String relatedTo, String relatedToName)
	{
		OpportunitiesPage op = new OpportunitiesPage(driver);
		op.getCreateOpportunityBtn().click();
		
		oppNameTF.sendKeys(oppName);
		
		WebDriverUtility w = new WebDriverUtility();
		w.selectDropdownByText(relatedToDD, relatedTo);
		
		relatedToSelectBtn.click();
		w.switchToWindow("action=Popup&html=Popup_picker", driver);
		
		searchTF.sendKeys(relatedToName);
		searchBtn.click();
		
		w.waitTillElementContainsText(15, orgSelectLnk, relatedToName);
		orgSelectLnk.click();
		
		w.switchToWindow(driver, "ACOE Fireflink - Contacts - vtiger CRM 5 - Commercial Open Source CRM");
	}
	
	// 1. enter close date
	public void enterCloseDate(int days)
	{
		JavaUtility j = new JavaUtility();
		String date = j.getReqData(days);
		exptdCloseDate.clear();
		exptdCloseDate.sendKeys(date);
	}
	
	// 2. select sales stage
	public void salesStage(String value)
	{
		WebDriverUtility w = new WebDriverUtility();
		w.selectDropdownByvalue(salesStageDD, value);
	}
	
}
