package com.vTiger.crm.opportunitiesTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import genericUtility.WebDriverUtility;
import objectRepository.CreateContact;
import objectRepository.CreateOpportunityPage;
import objectRepository.CreateOrganization;
import objectRepository.HomePage;


@Listeners(listenerUtil.ListenerImplementation.class)
public class createOpportunitiesTest extends BaseClass{
	
	@Test(groups = "Smoke")
	public void createOpportunityRelatedToOrg() throws Exception
	{
		
		JavaUtility j = new JavaUtility();
		ExcelFileUtility e = new ExcelFileUtility();
		
		//Data from Excel
		String orgName = e.readDataFromExcelFile("Organization", 1, 0) + j.posRandomNumber();
		String oppName = e.readDataFromExcelFile("Opportunities", 1, 0) +j.posRandomNumber();
		String relatedTo = e.readDataFromExcelFile("Opportunities", 1, 1);
		
		//create Organization
		CreateOrganization co = new CreateOrganization(driver);
		co.createOrg(orgName);
		
		WebDriverUtility w = new WebDriverUtility();
		w.waitTillVisibilityOfElement(driver, co.getVerifyOrgname(), 10);
		//Create Opportunity
		HomePage h = new HomePage(driver);
		h.getOpportunitiesLnk().click();
		
		CreateOpportunityPage cop = new CreateOpportunityPage(driver);
		cop.createOpportunity(oppName, relatedTo, orgName);
		cop.getSaveBtn().click();
		
	}
	
	@Test(groups = "Smoke")
	public void createOpportunityRelatedToCont() throws Exception
	{
		
		JavaUtility j = new JavaUtility();
		ExcelFileUtility e = new ExcelFileUtility();
		
		//Data from Excel
		String contName = e.readDataFromExcelFile("Contacts", 1, 0) + j.posRandomNumber();
		String oppName = e.readDataFromExcelFile("Opportunities", 2, 0) +j.posRandomNumber();
		String relatedTo = e.readDataFromExcelFile("Opportunities", 2, 1);
		
		//create Contact
		CreateContact cc = new CreateContact(driver);
		cc.createContact(contName);
		
		WebDriverUtility w = new WebDriverUtility();
		w.waitTillVisibilityOfElement(driver, cc.getVerifyContName(), 10);
		//Create Opportunity
		HomePage h = new HomePage(driver);
		h.getOpportunitiesLnk().click();
		
		CreateOpportunityPage cop = new CreateOpportunityPage(driver);
		cop.createOpportunity(oppName, relatedTo, contName);
		cop.getSaveBtn().click();
		
	}
	
	@Test(groups = "Regression")
	public void createOpportunityWithCloseDate() throws Exception
	{
		
		JavaUtility j = new JavaUtility();
		ExcelFileUtility e = new ExcelFileUtility();
		
		//Data from Excel
		String orgName = e.readDataFromExcelFile("Organization", 1, 0) + j.posRandomNumber();
		String oppName = e.readDataFromExcelFile("Opportunities", 1, 0) +j.posRandomNumber();
		String relatedTo = e.readDataFromExcelFile("Opportunities", 1, 1);
		int closeDate = Integer.parseInt(e.readDataFromExcelFile("Opportunities", 1, 2));
		
		//create Organization
		CreateOrganization co = new CreateOrganization(driver);
		co.createOrg(orgName);
		
		WebDriverUtility w = new WebDriverUtility();
		w.waitTillVisibilityOfElement(driver, co.getVerifyOrgname(), 10);
		//Create Opportunity
		HomePage h = new HomePage(driver);
		h.getOpportunitiesLnk().click();
		
		//create opportunity
		CreateOpportunityPage cop = new CreateOpportunityPage(driver);
		cop.createOpportunity(oppName, relatedTo, orgName);
		
		//enter close date
		String date = j.getReqData(closeDate);
		cop.getExptdCloseDate().clear();
		cop.getExptdCloseDate().sendKeys(date);
		
		cop.getSaveBtn().click();	
	}
	
	@Test(groups = "Regression")
	public void createOpportunityWithSalesStage() throws Exception
	{
		
		JavaUtility j = new JavaUtility();
		ExcelFileUtility e = new ExcelFileUtility();
		
		//Data from Excel
		String orgName = e.readDataFromExcelFile("Organization", 2, 0) + j.posRandomNumber();
		String oppName = e.readDataFromExcelFile("Opportunities", 3, 0) +j.posRandomNumber();
		String relatedTo = e.readDataFromExcelFile("Opportunities", 3, 1);
		String salesStage = e.readDataFromExcelFile("Opportunities", 3, 3);
		
		//create Organization
		CreateOrganization co = new CreateOrganization(driver);
		co.createOrg(orgName);
		
		WebDriverUtility w = new WebDriverUtility();
		w.waitTillVisibilityOfElement(driver, co.getVerifyOrgname(), 10);
		//Create Opportunity
		HomePage h = new HomePage(driver);
		h.getOpportunitiesLnk().click();
		
		CreateOpportunityPage cop = new CreateOpportunityPage(driver);
		cop.createOpportunity(oppName, relatedTo, orgName);
		cop.salesStage(salesStage);
		cop.getSaveBtn().click();
		
	}
	
	
	@Test(groups = "Regression")
	public void createOpportunityMandFields() throws Exception
	{
		
		JavaUtility j = new JavaUtility();
		ExcelFileUtility e = new ExcelFileUtility();
		
		//Data from Excel
		String orgName = e.readDataFromExcelFile("Organization", 2, 0) + j.posRandomNumber();
		String oppName = e.readDataFromExcelFile("Opportunities", 3, 0) +j.posRandomNumber();
		String relatedTo = e.readDataFromExcelFile("Opportunities", 3, 1);
		String salesStage = e.readDataFromExcelFile("Opportunities", 3, 3);
		int closeDate = Integer.parseInt(e.readDataFromExcelFile("Opportunities", 3, 2));
		
		//create Organization
		CreateOrganization co = new CreateOrganization(driver);
		co.createOrg(orgName);
		
		WebDriverUtility w = new WebDriverUtility();
		w.waitTillVisibilityOfElement(driver, co.getVerifyOrgname(), 10);
		
		//Create Opportunity
		HomePage h = new HomePage(driver);
		h.getOpportunitiesLnk().click();
		
		CreateOpportunityPage cop = new CreateOpportunityPage(driver); 
		cop.createOpportunity(oppName, relatedTo, orgName);
		
		//enter close date
		String date = j.getReqData(closeDate);
		cop.getExptdCloseDate().clear();
		cop.getExptdCloseDate().sendKeys(date);
		
		//select Sales Stage
		cop.salesStage(salesStage);
		cop.getSaveBtn().click();
		
	}
	
}
