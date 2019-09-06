package com.ericsson.NDOrnd.dopuatautomation.pages;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ericsson.NDOrnd.dopuatautomation.base.Lib;
import com.ericsson.NDOrnd.dopuatautomation.base.TestBase;

public class MainPortal_Loginpage extends TestBase{
	
	
	
	/*Inspecting WebElement for Username*/
	@FindBy(name="username")
	WebElement Username;
	
	/*Inspecting WebElement for Password*/
	@FindBy(name="password")
	WebElement Password;
	
	/*Inspecting WebElement for LoginButton*/
	@FindBy(id="logicon")
	WebElement Loginbutton;
	
	/*Inspecting WebElement for RequestAccessButton*/
	@FindBy(id="showUarLdap")
	WebElement RequestAccess;
	
	/*Inspecting WebElement for DOPLOGO*/
	@FindBy(xpath="//*[@class='eaLogin-title1']")
	WebElement Logo1;
	
	/*Inspecting WebElement for EricssonLOGO*/
    @FindBy(xpath="//div[@class='eaLogin-ericssonLogo']")
	WebElement Logo2;
	
    /*Initializing all the WebElements*/
	public MainPortal_Loginpage() {
		PageFactory.initElements(driver , this);
		
	}
	
	
	/*Method to Check EDOS-DP Logo is Displayed of Login Page*/
    public boolean ValidateEDOSLOGO1() 
     {
		 return Logo1.isDisplayed();
	 }
	 
    /*Method to Check  Main Portal Logo is Displayed of Login Page*/
    public boolean ValidateEDOSLOGO2() 
     {
		 return Logo2.isDisplayed();
	 }
	 
    /*Method to Get the text of EDOS-DP Logo of Login Page*/ 
	 public String GetEDOSLOGO1() 
	 {
		 return Logo1.getText();
	 }

	
	 /*Method to get the username from excelsheet of Login Page*/ 
	 public void SetUserName()
	  {
		 String un = Lib.getCellValue(EXCEL_PATH, "Login", 1, 0);	
		 Username.sendKeys(un);
      }
     
	 /*Method to get the password from excelsheet of Login Page(encrypted password)*/ 
     public void SetPassword()
     {
    	 String pw = Lib.getCellValue(EXCEL_PATH, "Login", 1, 1);
 		 byte[] decodedBytes = Base64.decodeBase64(pw);
 		 String s = new String(decodedBytes);
 		 Password.sendKeys(s);
	 }
     
     
    /* Method to click on LoginButton of Login Page 
     public EdosApplicationPage ClickLogin() {
        Loginbutton.click(); 
        return new EdosApplicationPage();
        }*/
     
     
     /*Method to click on LoginButton of Login Page*/ 
     public VDT_Rasterpage  ClickLogin() {
        Loginbutton.click(); 
        return new VDT_Rasterpage();
        }

     /*Method to click on LoginButton of Login Page to navigate to TIV page*/ 
     public VDT_TraceInputValidationPage ClickLoginForTIV() {
        Loginbutton.click(); 
        return new VDT_TraceInputValidationPage();
        }
       /*Method to click on LoginButton of Login Page to navigate to CTA page*/ 
     public VDT_CallTerminationAnalysisPage ClickLoginForCTA() {
        Loginbutton.click(); 
        return new VDT_CallTerminationAnalysisPage();
        }
     
     /*Method to click on LoginButton at once of Login Page*/ 
     public void LoginInOne() throws InterruptedException {
    	 SetUserName();
    	 Thread.sleep(2000);
    	 SetPassword();
    	 Thread.sleep(2000);
    	 ClickLogin();
     }
 

	
	}
