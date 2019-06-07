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

public class LoginPageTest extends  TestBase{
	
	
	Edoslandingpage landingpage;
	Edosloginpage loginpage;
	EdosApplicationPage applicationpage;
	
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeTest(alwaysRun = true)
	public void setUp() throws InterruptedException
	
	{
		Thread.sleep(3000);
		//initialisation();
		//landingpage=new Edoslandingpage();
		loginpage=new Edosloginpage();
		
		//landingpage.ClickProceedButton();
	
	}
	
	/*TestMethod to Check EDOS-DP Logo of Login Page is Displaying*/
    @Test(priority=1)
	public void EdosLogo1Test() throws InterruptedException 
    {
    	
		boolean Logo1=loginpage.ValidateEDOSLOGO1();
		Thread.sleep(2000);
		Assert.assertTrue(Logo1);
	}
	
    /*TestMethod to Check Main Portal Logo of Login Page is Displaying*/
	@Test(priority=2)
	public void EdosLogo2Test() throws InterruptedException 
	{
		boolean Logo2=loginpage.ValidateEDOSLOGO2();
		Thread.sleep(2000);
		Assert.assertTrue(Logo2);
	}
	
	

	
	/*TestMethod to Check Text of Main Portal of Login Page is Correct*/
	@Test(priority=3)
	public void EdosLogoText1Test() throws InterruptedException 
	{
		String Logotext1=loginpage.GetEDOSLOGO1();
		Thread.sleep(2000);
		Assert.assertEquals(Logotext1,"DESIGN AND OPTIMIZATION PLATFORM");
	}
	
	/*TestMethod to Get the UserName of Login Page*/
	@Test(priority=4)
	public void SetusernameTest() throws Exception 
	{
		loginpage.SetUserName();
		Thread.sleep(2000);
	}
	
	/*TestMethod to Get the Password of Login Page*/
	@Test(priority=5)
	public void SetUserPasswordTest() throws Exception 
	{
	     loginpage.SetPassword();
	     Thread.sleep(2000);
	}
	
	/*TestMethod to Click Enter of Login Page*/
	@Test(priority=6)
	public void ClickEnterButtonTest() throws InterruptedException 
	{
		 loginpage.ClickLogin();
		 Thread.sleep(2000);
		 Reporter.log("The username and password is entered successfully and proceeded to the application page");
		 
	}
	
}
