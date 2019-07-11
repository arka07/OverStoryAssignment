package com.ericsson.edos.dopuatautomation.testcases;
import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import com.ericsson.edos.dopuatautomation.base.TestBase;
import com.ericsson.edos.dopuatautomation.pages.EdosApplicationPage;
import com.ericsson.edos.dopuatautomation.pages.EdosBouyguesPage;
import com.ericsson.edos.dopuatautomation.pages.EdosDOPPerformancePortalPage;
import com.ericsson.edos.dopuatautomation.pages.Edoslandingpage;
import com.ericsson.edos.dopuatautomation.pages.Edosloginpage;

public class PerformancePortalTest extends  TestBase{
	
	
	Edoslandingpage landingpage;
	Edosloginpage loginpage;
	EdosApplicationPage applicationpage;
	EdosDOPPerformancePortalPage portalpage;
	EdosBouyguesPage bouyguespage;
	

	

	
	public PerformancePortalTest() {
		super();
		}
	
	@BeforeTest(alwaysRun = true)
	public void setUp() throws InterruptedException
	{   
		portalpage = new EdosDOPPerformancePortalPage();
     	applicationpage= new EdosApplicationPage();
     	landingpage = new Edoslandingpage();
     	loginpage = new Edosloginpage();
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