package com.vTiger.crm.contactsTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import baseTest.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import objectRepository.ContactsPage;
import objectRepository.CreateContact;
import objectRepository.CreateOrganization;
import objectRepository.HomePage;
import objectRepository.OrganizationsPage;
import threadLocalClass.ThreadLocalClass;

/*
 *  NOTE : 
 *  1.Change the Browser Setting in Base Class to change to normal launch or Cross Browser testing using @Parameters
 */

@Listeners(listenerUtil.ListenerImplementation.class)
public class CreateContactTest extends BaseClass{

	@Test(groups = "Smoke")
	public void createContactTest() throws Exception {
		// Java Utility
		JavaUtility j = new JavaUtility();

		// Read Excel Data
		ExcelFileUtility e = new ExcelFileUtility();
		String contactName = e.readDataFromExcelFile("Contacts", 1, 0) + j.posRandomNumber();
		ThreadLocalClass.getTest().log(Status.INFO, "Read Data from Excel");

		// 4. Create Contact
		HomePage hp = new HomePage(driver);
		hp.getContactsLnk().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Navigated to Contacts Page");
		
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactBtn().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Navigated to Create Contacts Page");
		
		CreateContact cc = new CreateContact(driver);
		cc.getContNameTF().sendKeys(contactName);
		cc.getSaveBtn().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Created Contact");

		// verify Contact name
		String actName = cc.getVerifyContName().getText();
		Assert.assertEquals(actName, contactName);
		ThreadLocalClass.getTest().log(Status.INFO, "Contact Name Verified");
	}

	@Test(groups="Regression")
	public void createContactWithEndDateTest() throws Exception {
		// Java Utility
		JavaUtility j = new JavaUtility();
		String reqDate = j.getReqData(30);

		// Read Excel Data
		ExcelFileUtility e = new ExcelFileUtility();
		String contactName = e.readDataFromExcelFile("Contacts", 1, 0) + j.posRandomNumber();

		// 4. Create Contact
		HomePage hp = new HomePage(driver);
		hp.getContactsLnk().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Navigated to Contacts Page");
		
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactBtn().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Navigated to Create Contacts Page");

		CreateContact cc = new CreateContact(driver);
		cc.getContNameTF().sendKeys(contactName);
		cc.getEndDate().clear();
		cc.getEndDate().sendKeys(reqDate);
	
		cc.getSaveBtn().click();

		// verify Contact name
		String actName = cc.getVerifyContName().getText();
		String actDate = cc.getVerifyEndDate().getText();
		ThreadLocalClass.getTest().log(Status.INFO, "Created Contact with End Date "+ actDate);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actName, contactName);
		sa.assertEquals(actDate, reqDate);
		sa.assertAll();
		ThreadLocalClass.getTest().log(Status.INFO, "Contact Name with End Date Verified");
		
	}

	@Test(groups="Regression")
	public void createContactWithOrgTest() throws Exception {
		// Java Utility
		JavaUtility j = new JavaUtility();

		// Read Excel Data
		ExcelFileUtility e = new ExcelFileUtility();
		String contactName = e.readDataFromExcelFile("Contacts", 1, 0) + j.posRandomNumber();
		String orgName = e.readDataFromExcelFile("Contacts", 1, 1) + j.posRandomNumber();
		ThreadLocalClass.getTest().log(Status.INFO, "Read Data from Excel");

		// 4. Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Navigated to Organizations Page");
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgBtn().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Navigated to Create Organizations Page");
		CreateOrganization co = new CreateOrganization(driver);
		co.getOrgNameTF().sendKeys(orgName);
		co.getSaveBtn().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Created Organization");
		

		// 5. Create Contact
		wu.waitTillVisibilityOfElement(driver, co.getVerifyOrgname(), 10);

		hp.getContactsLnk().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Navigated to Contacts Page");
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContactBtn().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Navigated to Create Contacts Page");
		
		CreateContact cc = new CreateContact(driver);
		cc.getContNameTF().sendKeys(contactName);
		cc.orgNameselect(orgName);
		cc.getSaveBtn().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Created Contact with Organization");

		// verify Contact name		
		String actName = cc.getVerifyContName().getText();
		String actOrgName = cc.getVerifyOrgName().getText().trim();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actName, contactName);
		sa.assertEquals(actOrgName, orgName);
		sa.assertAll("All Verifications are Passed");
		ThreadLocalClass.getTest().log(Status.INFO, "Contact Name with Organization verified");
		
	}

}
