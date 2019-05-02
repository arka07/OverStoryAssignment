package com.ericsson.edos.dopuatautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ericsson.edos.dopuatautomation.base.TestBase;

public class Edoslandingpage extends TestBase
   {
	/*  Inspecting WebElement for Important Legal Notice*/
	@FindBy(xpath="//p[@class='eaLogin-licenceHeader']")
	private WebElement LegalNotice;
	
	/*  Inspecting WebElement for Authorized User*/
	@FindBy(xpath="(//p[@class='eaLogin-licenceContent'])[2]")
	private WebElement LicenseContent;
	
	/*  Inspecting WebElement for Proceed Button*/
	@FindBy(id="showLicence")
	WebElement Proceed;
	
	
	/*Initializing all the WebElements*/
	public Edoslandingpage() 
	{
		PageFactory.initElements(driver , this);
	}
	
	/*Method to Get Title of Landing Page*/
	public String ValidateLandingPageTitle() 
	{
		 return driver.getTitle();
			
    }
	 
	/*Method to Check LegalNoticeLogo is Displayed of Landing Page*/
	 public boolean ValidateLegalNoticeLogo()
	 {
		 return LegalNotice.isDisplayed();
		  
	 }
	 
	 /*Method to Check AuthorisedUserLogo is Displayed of Landing Page*/
	 public boolean ValidateLicenseContentLogo()
	 {
		 return LicenseContent.isDisplayed();
		 
	 }
	 
	 /*Method to Get the text of LegalNoticeLogo of Landing Page*/
	 public String GetLegalNoticeLogo() 
	 {
		 return LegalNotice.getText();
	 }
	 
	 
	 /*Method to Get the text of AuthorisedUser of Landing Page*/
	 public String GetLicenseContentLogo() 
	 {
		 return LicenseContent.getText();
	 }
	 
	
	 /*Method to Click Proceed Button of Landing Page and it goes into EDOSLoginPage*/
	 public Edosloginpage ClickProceedButton() throws InterruptedException 
	 {
		 Thread.sleep(3000);
		 Proceed.click();
		 return new Edosloginpage();
		 
	 }
	 
}