package com.ericsson.NDOrnd.dopuatautomation.testcases;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ericsson.NDOrnd.dopuatautomation.base.TestBase;
import com.ericsson.NDOrnd.dopuatautomation.pages.VDT_CallTerminationAnalysisPage;
import com.ericsson.NDOrnd.dopuatautomation.pages.MainPortal_ApplicationPage;
import com.ericsson.NDOrnd.dopuatautomation.pages.MainPortal_Landingpage;
import com.ericsson.NDOrnd.dopuatautomation.pages.MainPortal_Loginpage;

public class MainPortal_ApplicationTest extends  TestBase{
	
	
	MainPortal_Landingpage landingpage;
	MainPortal_Loginpage loginpage;
	MainPortal_ApplicationPage applicationpage;
    VDT_CallTerminationAnalysisPage CTAPage;
	

	
	public MainPortal_ApplicationTest() {
		super();
		
	}
	
	
	@BeforeTest(alwaysRun = true)
	public void setUp() throws InterruptedException
	{
		
		applicationpage= new MainPortal_ApplicationPage();
		landingpage = new MainPortal_Landingpage();
		loginpage = new MainPortal_Loginpage();
		CTAPage= new VDT_CallTerminationAnalysisPage();
	}
    
	
	/*TestMethod to Check title of Application Page is Correct*/
    @Test(priority=1)
	public void VerifyApplicationPage() throws InterruptedException 
    {
    Thread.sleep(10000);	
    String homepagetitle= applicationpage.VisibleOfHomePage();
    System.out.println("Title:"+ homepagetitle);
    Assert.assertEquals(homepagetitle, "Home");
	}
    
    /*TestMethod to Check text of EDOS-DP fullform of Application Page is Correct*/
    @Test(priority=2)
   	public void VerifyEdosDpLogo() throws InterruptedException 
    {
    Thread.sleep(2000);
   	String edostitle= applicationpage.VisibleOfEDOSDPtitle();
    Assert.assertEquals(edostitle, "Ericsson Operations Engine","EdosDp title not present");
   	}
	
    /*TestMethod to Click on Raster*/
    @Test(priority=3)
   	public void RasterClick() throws InterruptedException 
    {
    Thread.sleep(5000);
    applicationpage.ClickonRasterLink();
    Thread.sleep(1000);
    /*landingpage.ClickProceedButton();
    loginpage.SetUserName();
	Thread.sleep(2000);
	loginpage.SetPassword();
    Thread.sleep(2000);
    loginpage.ClickLogin();*/
	 Thread.sleep(2000);
   	}
    
    /*TestMethod to Click on TIV*/
    @Test(priority=4)
   	public void VerifyTIVLink() throws InterruptedException 
    {
    Thread.sleep(9000);
   	applicationpage.TIVLinkClick();
    Thread.sleep(5000);
   /*landingpage.ClickProceedButton();
  	loginpage.SetUserName();
	Thread.sleep(2000);
	loginpage.SetPassword();
    Thread.sleep(2000);
    loginpage.ClickLoginForTIV();*/
	 Thread.sleep(2000);
   	}
    
    /*TestMethod to Click on CTA*/
    @Test(priority=5)
   	public void VerifyCTALink() throws InterruptedException 
    {
    Thread.sleep(9000);
   	applicationpage.ClickOnCTA();
    Thread.sleep(5000);
   	/*landingpage.ClickProceedButton();
    loginpage.SetUserName();
	Thread.sleep(2000);
	loginpage.SetPassword();
    Thread.sleep(2000);
    loginpage.ClickLoginForCTA();*/
	 Thread.sleep(2000);
   	}
	
    /*TestMethod to Click on CM/PM*/
	 @Test(priority=6)
   	public void VerifyCMPMDashboard() throws InterruptedException 
    {
    Thread.sleep(9000);
    applicationpage.clickonCMPMDashboard();
    Thread.sleep(5000);
    /*landingpage.ClickProceedButton();
    Thread.sleep(2000);
    loginpage.LoginInOne();*/
    Thread.sleep(1000);
 
   	}
    
}
