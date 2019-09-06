package com.ericsson.NDOrnd.dopuatautomation.testcases;
import org.testng.annotations.Test;
import org.apache.commons.collections.FastArrayList;
import org.testng.Assert;

import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import com.ericsson.NDOrnd.dopuatautomation.base.TestBase;
import com.ericsson.NDOrnd.dopuatautomation.pages.MainPortal_Landingpage;
import com.ericsson.NDOrnd.dopuatautomation.pages.MainPortal_Loginpage;
public class MainPortal_LandingpageTest extends  TestBase{
	
	
	MainPortal_Landingpage landingpage;
	MainPortal_Loginpage loginpage;
	
	public MainPortal_LandingpageTest() {
		super();
	}
	
	

	@BeforeTest(alwaysRun = true)
	public void setUp() throws InterruptedException
	{
		//initialisation();
		landingpage=new MainPortal_Landingpage();
	}
	
	
	/*TestMethod to Validate Title of Landing Page*/
	@Test(priority=1)
	public void LandingPageTitleTest() throws InterruptedException 
	{
		String title=landingpage.ValidateLandingPageTitle();
		Thread.sleep(2000);
		System.out.println("Page Title name is : "+ title);
	    Assert.assertEquals(title,"Design and Optimization Platform" );
	}
	
	
	/*TestMethod to Check LegalNoticeLogo of Landing Page is Displaying*/
	@Test(priority=2)
	public void LegalNoticeLogoTest() throws InterruptedException 
	{
		boolean LegalNoticeLogo=landingpage.ValidateLegalNoticeLogo();
		Thread.sleep(2000);
		System.out.println("Page Logo is validated successfully");
		Assert.assertTrue(LegalNoticeLogo);
	}
	
	/*TestMethod to Check LicenseContentLogo of Landing Page is Displaying*/
	/*@Test(priority=3)
	public void LicenseContentLogoTest() throws InterruptedException 
	{
		boolean LicenseContentLogo=landingpage.ValidateLicenseContentLogo();
		Thread.sleep(2000);
		System.out.println("Page LicenseContent is validated successfully");
		Assert.assertTrue(LicenseContentLogo);
	}*/
	
	/*TestMethod to Check Text of LegalNoticeLogo of Landing Page is Correct*/
	@Test(priority=4,enabled=false)
	public void LegalNoticeLogoTextTest() throws InterruptedException 
	{
		String LegalNoticeLogo=landingpage.GetLegalNoticeLogo();
		Thread.sleep(2000);
		System.out.println("Page Legal Notice Text is "+LegalNoticeLogo);
		Assert.assertEquals(LegalNoticeLogo,"IMPORTANT LEGAL NOTICE");
	}
	
	
	/*TestMethod to Check Text of LicenseContentLogo of Landing Page is Correct*/
	@Test(priority=5,enabled=false)
	public void LicenseContentLogoTextTest() throws InterruptedException 
	{
		String LicenseContentLogo=landingpage.GetLicenseContentLogo();
		Thread.sleep(2000);
		System.out.println("Page LicenseContent page is validated successfully");
		Assert.assertEquals(LicenseContentLogo,"IF YOU ARE NOT AN AUTHORIZED USER PLEASE EXIT IMMEDIATELY".toLowerCase());
	}
	
	/*TestMethod to Click on ProceedButton of Landing Page*/
	@Test(priority=6)
	public void ProceedButtonTest() throws InterruptedException
	{
		landingpage.ClickProceedButton();
		Thread.sleep(2000);
		System.out.println("The application is proceeded to the Login Page");
		Reporter.log("The application is proceeded to the Login Page");
		
	}
	


}

