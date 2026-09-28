package com.vTiger.crm.leadsTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseTest.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import objectRepository.CreateLeadsPage;
import objectRepository.HomePage;

@Listeners(listenerUtil.ListenerImplementation.class)
public class CreateLeadsTest  extends BaseClass{
	
	@Test(groups = "Smoke")
	public void createLead() throws Exception
	{
		JavaUtility j = new JavaUtility();
		ExcelFileUtility e = new ExcelFileUtility();
		
		String leadName = e.readDataFromExcelFile("Leads", 1, 0) +"_"+j.posRandomNumber();
		String companyName = e.readDataFromExcelFile("Leads", 1, 1);
		
		HomePage hp = new HomePage(driver);
		hp.getLeadsLnk().click();
		
		CreateLeadsPage cl = new CreateLeadsPage(driver);
		cl.createLead(leadName, companyName);
		cl.getSaveBtn();
	}
	
	
	
	@Test(groups = "Regression")
	public void createLeadWithMobile() throws Exception
	{
		JavaUtility j = new JavaUtility();
		ExcelFileUtility e = new ExcelFileUtility();
		
		String leadName = e.readDataFromExcelFile("Leads", 1, 0) +"_"+j.posRandomNumber();
		String companyName = e.readDataFromExcelFile("Leads", 1, 1);
		String mobile = e.readDataFromExcelFile("Leads", 1, 2);
		
		HomePage hp = new HomePage(driver);
		hp.getLeadsLnk().click();
		
		CreateLeadsPage cl = new CreateLeadsPage(driver);
		cl.createLead(leadName, companyName);
		cl.getMobileTF().sendKeys(mobile);
		cl.getSaveBtn();
	}

	@Test(groups = "Regression")
	public void createLeadWithIndustry() throws Exception
	{
		JavaUtility j = new JavaUtility();
		ExcelFileUtility e = new ExcelFileUtility();
		
		String leadName = e.readDataFromExcelFile("Leads", 1, 0) +"_"+j.posRandomNumber();
		String companyName = e.readDataFromExcelFile("Leads", 1, 1);
		String industry = e.readDataFromExcelFile("Leads", 1, 3);
		
		HomePage hp = new HomePage(driver);
		hp.getLeadsLnk().click();
		
		CreateLeadsPage cl = new CreateLeadsPage(driver);
		cl.createLead(leadName, companyName);
		cl.selectIndustry(industry);
		cl.getSaveBtn();
	}
	
}
