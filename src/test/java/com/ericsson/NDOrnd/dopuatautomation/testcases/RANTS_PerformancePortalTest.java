package com.ericsson.NDOrnd.dopuatautomation.testcases;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import com.ericsson.NDOrnd.dopuatautomation.base.TestBase;
import com.ericsson.NDOrnd.dopuatautomation.pages.MainPortal_ApplicationPage;
import com.ericsson.NDOrnd.dopuatautomation.pages.RANTS_BouyguesCustomerPage;
import com.ericsson.NDOrnd.dopuatautomation.pages.RANTS_DOPPerformancePortalPage;
import com.ericsson.NDOrnd.dopuatautomation.pages.MainPortal_Landingpage;
import com.ericsson.NDOrnd.dopuatautomation.pages.MainPortal_Loginpage;

public class RANTS_PerformancePortalTest extends  TestBase{
	
	
	MainPortal_Landingpage landingpage;
	MainPortal_Loginpage loginpage;
	MainPortal_ApplicationPage applicationpage;
	RANTS_DOPPerformancePortalPage portalpage;
	RANTS_BouyguesCustomerPage bouyguespage;
	

	

	
	public RANTS_PerformancePortalTest() {
		super();
		}
	
	@BeforeTest(alwaysRun = true)
	public void setUp() throws InterruptedException
	{   
		portalpage = new RANTS_DOPPerformancePortalPage();
     	applicationpage= new MainPortal_ApplicationPage();
     	landingpage = new MainPortal_Landingpage();
     	loginpage = new MainPortal_Loginpage();
     }
    
	
	/*TestMethod to Check title of Performance Page is Correct*/
    @Test(priority=1)
	public void VerifyPerformancePortalTest() throws InterruptedException 
    {
    Thread.sleep(5000);
    String PerfPortalpagetitle= portalpage.VisibleOfGNPPerfPortal();
    System.out.println("Title:"+ PerfPortalpagetitle);
    Assert.assertEquals(PerfPortalpagetitle, "DOP Performance Portal");
	}
    
}