package com.ericsson.edos.dopuatautomation.testcases;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ericsson.edos.dopuatautomation.base.TestBase;
import com.ericsson.edos.dopuatautomation.pages.EdosApplicationPage;
import com.ericsson.edos.dopuatautomation.pages.Edoslandingpage;
import com.ericsson.edos.dopuatautomation.pages.Edosloginpage;

public class applicationTest extends  TestBase{
	
	
	Edoslandingpage landingpage;
	Edosloginpage loginpage;
	EdosApplicationPage applicationpage;

	

	
	public applicationTest() {
		super();
		
		
	}
	
	@BeforeMethod
	@BeforeTest(alwaysRun = true)
	public void setUp() throws InterruptedException
	{
		
		//initialisation();
		//landingpage=new Edoslandingpage();
		//loginpage=landingpage.ClickProceedButton();
		//loginpage.LoginInOne();
		applicationpage= new EdosApplicationPage();
	
		
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
    Assert.assertEquals(edostitle, "Ericsson Design & Optimization Services Delivery Platform","EdosDp title not present");
   	}
	
   


	
}