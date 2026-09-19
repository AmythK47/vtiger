package com.vTiger.crm.organizationTest;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import baseTest.BaseClass;
import genericUtility.ExcelFileUtility;
import genericUtility.JavaUtility;
import objectRepository.CreateOrganization;
import objectRepository.HomePage;
import objectRepository.OrganizationsPage;
import threadLocalClass.ThreadLocalClass;

/*
 *  NOTE : 
 *  1.Change the Browser Setting in Base Class to change to normal launch or Cross Browser testing using @Parameters
 */
@Listeners(listenerUtil.ListenerImplementation.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "Smoke")
	public void createOrgTest() throws Exception {
		// Java Utility
		JavaUtility j = new JavaUtility();

		// Read Excel Data
		ExcelFileUtility e = new ExcelFileUtility();
		String orgName = e.readDataFromExcelFile("Organization", 1, 0) + j.posRandomNumber();
		ThreadLocalClass.getTest().log(Status.INFO, "Read Data from Excel");

		// 4. Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Navigated to Organization Page");

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgBtn().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Navigated to Create Organization Page");

		CreateOrganization co = new CreateOrganization(driver);
		co.getOrgNameTF().sendKeys(orgName);
		co.getSaveBtn().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Created Organization");

		// verify Organization name
		WebElement headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
		wu.waitTillVisibilityOfElement(driver, headerInfo, 15);
		String actOrgName = co.getVerifyOrgname().getText();
		Assert.assertEquals(actOrgName, orgName);
		ThreadLocalClass.getTest().log(Status.INFO, "Organization Name verified");

	}

	@Test(groups = "Regression")
	public void createOrgWithIndustryTest() throws Exception {
		// Java Utility
		JavaUtility j = new JavaUtility();

		// Read Excel Data
		ExcelFileUtility e = new ExcelFileUtility();
		String orgName = e.readDataFromExcelFile("Organization", 2, 0) + j.posRandomNumber();
		String orgIndustry = e.readDataFromExcelFile("Organization", 2, 1);
		ThreadLocalClass.getTest().log(Status.INFO, "Read Data from Excel");

		// 4. Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Navigated to Organization Page");
		

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgBtn().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Navigated to Create Organization Page");

		CreateOrganization co = new CreateOrganization(driver);
		co.getOrgNameTF().sendKeys(orgName);
		wu.selectDropdownByvalue(co.getIndustryDD(), orgIndustry);
		co.getSaveBtn().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Created Organization with "+orgIndustry);
		
		//Verify Org and Industry Name
		String actOrgName = co.getVerifyOrgname().getText();
		String actIndName = co.getVerifyIndustry().getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actOrgName, orgName);
		sa.assertEquals(actIndName, orgIndustry);
		
		sa.assertAll("All Verifications are Passed");
		ThreadLocalClass.getTest().log(Status.INFO, "Organization Name and Industry verified");

	}

	@Test(groups = "Regression")
	public void createOrgWithPhoneTest() throws Exception {
		// Java Utility
		JavaUtility j = new JavaUtility();

		// Read Excel Data
		ExcelFileUtility e = new ExcelFileUtility();
		String orgName = e.readDataFromExcelFile("Organization", 2, 0) + j.posRandomNumber();
		String orgPhone = e.readDataFromExcelFile("Organization", 2, 2);
		ThreadLocalClass.getTest().log(Status.INFO, "Read Data from Excel");

		// 4. Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLnk().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Navigated to Organization Page");

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgBtn().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Navigated to Create Organization Page");

		CreateOrganization co = new CreateOrganization(driver);
		co.getOrgNameTF().sendKeys(orgName);
		co.getPhoneNumberTF().sendKeys(orgPhone);
		co.getSaveBtn().click();
		ThreadLocalClass.getTest().log(Status.INFO, "Created Organization with "+ orgPhone);
		
		//verify Org name and Phone nNumber
		String actOrgName = co.getVerifyOrgname().getText();
		String actPhone = co.getVerifyPhone().getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actOrgName, orgName);
		sa.assertEquals(actPhone, orgPhone);
		
		sa.assertAll();
		ThreadLocalClass.getTest().log(Status.INFO, "Organization Name and Phone Number verified");
	}

}
