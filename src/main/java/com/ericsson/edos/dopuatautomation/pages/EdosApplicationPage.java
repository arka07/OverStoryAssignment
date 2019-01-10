package com.ericsson.edos.dopuatautomation.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ericsson.edos.dopuatautomation.base.TestBase;

public class EdosApplicationPage extends TestBase {
	
/*Inspecting WebElement for HomePage*/	
@FindBy (xpath = "//a[text()='Home']")
WebElement HomePage;	

/*Inspecting WebElement for EdosDpFullForm*/	
@FindBy (xpath ="//h1[contains(text(),'Ericsson')]")
WebElement EdosDpFullForm;

/*Inspecting WebElement for RulesEngineClick*/	
@FindBy(xpath="//a[text()='Rules Engine']")
WebElement ClickRulesEngine;	

/*Inspecting WebElement for Logout*/	
@FindBy(xpath="//td[text()='Logout']")
WebElement ClickLogout;

/*Inspecting WebElement for LogoutOK*/	
@FindBy(xpath="//td[text()='OK']")
WebElement ClickLogoutOK;



/*Initializing all the WebElements*/
public EdosApplicationPage() {
PageFactory.initElements(driver , this);
	}


/*Method to get the Title of Application Page*/
public String VisibleOfHomePage() throws InterruptedException 
{
	Thread.sleep(7000);
	return driver.getTitle();
}


/*Method to get the text of EDOS-DP fullform of Application Page*/
public String VisibleOfEDOSDPtitle() 
{
	return EdosDpFullForm.getText();
	
}




public void ClickOnLogoutButton() {
	ClickLogout.click();
}

public void ClickOnLogoutOkButton() {
	ClickLogoutOK.click();
}
}
	



