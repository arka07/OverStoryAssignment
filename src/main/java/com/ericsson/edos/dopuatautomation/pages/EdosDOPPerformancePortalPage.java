package com.ericsson.edos.dopuatautomation.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ericsson.edos.dopuatautomation.base.TestBase;


public class EdosDOPPerformancePortalPage extends TestBase {
	
	
	/*Inspecting WebElement for GNP Performance Portal*/	
	@FindBy (xpath = "//a[contains(@href,'Customer=Bouygues')]")
	WebElement ClickOnBouygueslink;
    
	/*@FindBy (xpath = "//a[contains(@href,'Customer=dtathapoc')]")
	WebElement ClickOnBouygueslink;*/
	
	
	public EdosDOPPerformancePortalPage() {
		PageFactory.initElements(driver , this);
			}

	
	/*Method to get the Title of GNP Performance Portal*/
	public String VisibleOfGNPPerfPortal() 
	{
		return driver.getTitle();
	}

	
	public EdosBouyguesPage ClickBouyguesLink() throws InterruptedException
	{
	    Thread.sleep(2000);
		ClickOnBouygueslink.click();
		return new EdosBouyguesPage();
	}
}
