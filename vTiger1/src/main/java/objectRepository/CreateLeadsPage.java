package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.WebDriverUtility;

public class CreateLeadsPage {
	
	public WebDriver driver;
	
	public CreateLeadsPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameTF;
	
	@FindBy(xpath = "//input[@name='company']")
	private WebElement companyNameTF;
	
	@FindBy(xpath = "//input[contains(@title,'Save')]")
	private WebElement saveBtn;
	
	@FindBy(id = "mobile")
	private WebElement mobileTF;
	
	@FindBy(xpath= "//select[@name='industry']")
	private WebElement industryDD;
	
	
	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getCompanyNameTF() {
		return companyNameTF;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getMobileTF() {
		return mobileTF;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	// business utilities
	public void createLead(String leadName, String companyName)
	{
		LeadsPage lp = new LeadsPage(driver);
		lp.getCreateLeadBtn().click();
		
		lastNameTF.sendKeys(leadName);
		companyNameTF.sendKeys(companyName);
	}
	
	public void selectIndustry(String industry)
	{
		WebDriverUtility w = new WebDriverUtility();
		w.selectDropdownByText(industryDD, industry);
	}
	
}
