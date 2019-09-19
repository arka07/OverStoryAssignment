package com.ericsson.NDOrnd.dopuatautomation.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ericsson.NDOrnd.dopuatautomation.base.TestBase;


public class RANTS_DOPPerformancePortalPage extends TestBase {
	
	
	/*Inspecting WebElement for GNP Performance Portal*/	
	@FindBy (xpath = "//a[contains(@href,'Customer=bouygues')]")
	WebElement ClickOnBouygueslink;
    
	/*@FindBy (xpath = "//a[contains(@href,'Customer=dtathapoc')]")
	WebElement ClickOnBouygueslink;*/
	
	
	public RANTS_DOPPerformancePortalPage() {
		PageFactory.initElements(driver , this);
			}

	
	/*Method to get the Title of GNP Performance Portal*/
	public String VisibleOfGNPPerfPortal() 
	{
		return driver.getTitle();
	}

	
	public RANTS_BouyguesCustomerPage ClickBouyguesLink() throws InterruptedException
	{
	    Thread.sleep(2000);
		ClickOnBouygueslink.click();
		return new RANTS_BouyguesCustomerPage();
	}
}
