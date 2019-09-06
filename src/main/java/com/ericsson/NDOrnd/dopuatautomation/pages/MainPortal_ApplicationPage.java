package com.ericsson.NDOrnd.dopuatautomation.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ericsson.NDOrnd.dopuatautomation.base.TestBase;

public class MainPortal_ApplicationPage extends TestBase {
	
/*Inspecting WebElement for HomePage*/	
@FindBy (xpath = "//a[text()='Home']")
WebElement HomePage;	

/*Inspecting WebElement for EdosDpFullForm*/	
@FindBy (xpath ="//h1[contains(text(),'Ericsson')]")
WebElement EdosDpFullForm;

/*Inspecting WebElement for TIV Anchor Link*/
@FindBy(xpath="//li//a[contains(text(),'Traces Input Validation') or contains(@href,'https://gnp-prepro.edosdp.ericsson.se/tiv/')]")
WebElement TIVAnchorLink;

/*Inspecting WebElement for Logout*/	
@FindBy(xpath="//td[text()='Logout']")
WebElement ClickLogout;

/*Inspecting WebElement for LogoutOK*/	
@FindBy(xpath="//td[text()='OK']")
WebElement ClickLogoutOK;

/*Inspecting WebElement for LogoutOK*/
@FindBy(xpath="//a[contains(text(),'Rasters')]")
WebElement RasterLink;

/*Inspecting WebElement for RulesEngineClick*/	
/*@FindBy(xpath="//a[text()='GNP PM-based Troubleshooting']")
WebElement ClickCMPMDashboard;	*/

/*Inspecting WebElement for CMPM DashBoard*/	
@FindBy(xpath="//a[contains(text(),'Call Termination Analysis')]")
WebElement CTALink;


/*Inspecting WebElement for CMPM DashBoard*/	
@FindBy(xpath="//a[contains(text(),'DOP PM-based')]")
WebElement ClickCMPMDashboard;


/*Initializing all the WebElements*/
public MainPortal_ApplicationPage() {
PageFactory.initElements(driver , this);
	}
//Actions action = new Actions(driver);

/*Method to get the Title of Application Page*/
public String VisibleOfHomePage() throws InterruptedException 
{
	Thread.sleep(15000);
	return driver.getTitle();
}


/*Method to get the text of EDOS-DP fullform of Application Page*/
public String VisibleOfEDOSDPtitle() 
{
	return EdosDpFullForm.getText();
	
}


/*Method to click on RulesEngine link of Application Page*/
public MainPortal_Landingpage TIVLinkClick() throws InterruptedException
{
	Thread.sleep(2000);
	TIVAnchorLink.click();
	return new MainPortal_Landingpage();
}


public VDT_CallTerminationAnalysisPage ClickOnCTA() throws InterruptedException {
	Thread.sleep(2000);
	CTALink.click();
	Thread.sleep(5000);
	return new VDT_CallTerminationAnalysisPage();
}

/*Method to click on the Rasters link of Application page*/
public MainPortal_Landingpage ClickonRasterLink() throws InterruptedException

{   
    
	/*JavascriptExecutor js = (JavascriptExecutor) driver; 
	js.executeScript("window.open('https://gnp-prepro.edosdp.ericsson.se/login.html#/rastersView','_blank');");*/
	RasterLink.click();
	return new MainPortal_Landingpage();
	
	
	
}

/*Method to click on GNP PM-based Troubleshooting*/
public MainPortal_Landingpage clickonCMPMDashboard() 
{
   ClickCMPMDashboard.click();
   return new MainPortal_Landingpage();
	}



/*public void ClickOnLogoutButton() {
	ClickLogout.click();
}

public void ClickOnLogoutOkButton() {
	ClickLogoutOK.click();
}*/
}
	



