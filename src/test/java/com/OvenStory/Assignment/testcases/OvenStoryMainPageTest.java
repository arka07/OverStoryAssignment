package com.OvenStory.Assignment.testcases;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;


import org.testng.annotations.BeforeTest;

import com.OvenStory.Assignment.base.TestBase;
import com.OvenStory.Assignment.pages.OvenStoryMainPage;



public class OvenStoryMainPageTest extends  TestBase{


	OvenStoryMainPage OvenStoryPage;
	

	public OvenStoryMainPageTest() {
		super();

	}


	@BeforeTest(alwaysRun = true)
	public void setUp() throws InterruptedException
	{

		OvenStoryPage= new OvenStoryMainPage();
		
	}


	/*Test to CheckProduct is added*/
	@Test(priority=1)
	public void VerifyAddProducttoCart() throws InterruptedException 
	{
		boolean IsvaliditemAdded;
		
		Thread.sleep(1000);	
		//OvenStoryPage.DiscardAlert();
		Thread.sleep(1000);
		//OvenStoryPage.GetScroll("DOWN", 29);
		Thread.sleep(3000);
		OvenStoryPage.GetLocationTextBox("Bhandup West");
		Thread.sleep(3000);
		IsvaliditemAdded=OvenStoryPage.GetAddButton();
		if(IsvaliditemAdded)
		{
		OvenStoryPage.ClickOnCheckoutButton();
		Assert.assertTrue(IsvaliditemAdded,"Items failed to match");
		}else{
		Assert.assertFalse(true);
		}
		Thread.sleep(15000);
	}
	
	/*Test to CheckSide Menu Links are working*/
	@Test(priority=2)
	public void VerifySideMenuLinks() throws InterruptedException 
	{  
		
		driver.navigate().back();
	    Thread.sleep(3000);
	    OvenStoryPage.clicksidemenu();
	    List<String> expectedtitles = new ArrayList<String>();
	    expectedtitles.add("Pizza Near Me from Oven Story Pizza in Bhandup RK, Mumbai");
	    expectedtitles.add("Ovenstory- Privacy Policy");
	    expectedtitles.add("Ovenstory- Terms And Conditions");
	    expectedtitles.add("Oven Story- Order Pizza Online- Party Order");
	   
	    
	    Assert.assertEquals(OvenStoryPage.titlename, expectedtitles,"The Titles name are not same");
	    Thread.sleep(3000);
	   
	   
	    
	    
	}
	
	/*Test to CheckSide PowaiFirst location is Added*/
	@Test(priority=3)
	public void VerifyChangeLocation() throws InterruptedException
	{
		
		
		driver.navigate().to(url);
		Thread.sleep(5000);
		OvenStoryPage.clickfirstlocation("powai");
		Thread.sleep(3000);
		Assert.assertTrue(OvenStoryPage.locationtext,"Location Text are not Different");
		}
	

	
}
