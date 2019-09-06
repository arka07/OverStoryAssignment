package com.ericsson.NDOrnd.dopuatautomation.pages;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.ericsson.NDOrnd.dopuatautomation.base.TestBase;


public class RANTS_AdvancedMasterReportPage extends TestBase {
	
	
	/*Inspecting WebElement for GNP Performance Portal*/	
	@FindBy (xpath = "//a[text()='REPORTS']")
	WebElement ReportsTab;
	
	
	@FindBy (xpath = "//input[@id='rdpSDate_dateInput']")
	WebElement StartTime;

	
	@FindBy (xpath = "//input[@id='rdpEDate_dateInput']")
	WebElement EndTime;
	
	@FindBy (xpath = "//a[contains(text(),'FILTERS')]")
    WebElement QBFilterOption;
	
	@FindBy (xpath = "//a[@id='cboCell_Arrow']")
    WebElement eNOdeBAdvancedarrowdowncell;
	
	@FindBy (xpath = "//a[@id='cboCell_MoreResultsBoxImage']")
    WebElement eNOdeBAdvancedarrowdowncellmore;
	
	@FindBy (xpath = "//div[@id='cboCell_DropDown']//div[contains(@class,'rcbScroll')]//ul//li[1]")
    WebElement selectfirstcell;
	
	@FindBy (xpath = "//input[contains(@title,'Refresh')]")
    WebElement clickRefresh;
	
	@FindBy (xpath = "//div[@class='k-grid-content']//table//tbody//tr")
	List<WebElement> tablerowenodeBadvanced;
	
	//div[@class='k-grid-content']//table//tbody//tr
	
	
	/*Initializing all the WebElements*/
	public RANTS_AdvancedMasterReportPage() 
	{
	PageFactory.initElements(driver , this);
	}
	
	/*Method to get the Title of Bouygues Page*/
	public String VisibleOfAdvancedMaster() throws InterruptedException 
	{   
		Thread.sleep(10000);
		return driver.getTitle();
	}
	
	public String getStarttime() {
		return StartTime.getAttribute("value");
		
	}
	
	public String getEndtime()
	
	{
	return EndTime.getAttribute("value");
	}
    
    public void ClickQBFilterOption() 
    
    {
        QBFilterOption.click();
    }
    
    public void clickarrowdowncell() throws InterruptedException 
    {
    	eNOdeBAdvancedarrowdowncell.click();
    	Thread.sleep(5000);
    	eNOdeBAdvancedarrowdowncellmore.click();
    	Thread.sleep(5000);
    }
	
    public void clickfirstcell() throws InterruptedException 
    {
    	selectfirstcell.click();
    }
    
    public void clickRefresh() throws InterruptedException 
    {
    	clickRefresh.click();
    }
    
    
    public int  tablesize() throws InterruptedException 
    {
    	return tablerowenodeBadvanced.size();
    }
    
    

	
}
