package com.ericsson.NDOrnd.dopuatautomation.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ericsson.NDOrnd.dopuatautomation.base.TestBase;

import java.util.Set;


public class RANTS_BouyguesCustomerPage extends TestBase {
	
	
	
	
	/*Inspecting WebElement for GNP Performance Portal*/	
	@FindBy (xpath = "//a[text()='REPORTS']")
	WebElement ReportsTab;
	
	@FindBy (xpath = "//a[text()='CHARTS']")
	WebElement ChartsTab;
	
	@FindBy (xpath = "//a[text()='CONFIG']")
	WebElement ConfigTab;
	
	@FindBy (xpath = "//a[text()='KPIS']")
	WebElement KpisTab;
	
	@FindBy (xpath = "//a[@id='filtersSlidein']//table//tbody//tr//td[contains(text(),'Filters/Options')]")
	WebElement FiltersOptionsTab;
	
	@FindBy (xpath = "//a[@id='filtersSlidein']//table//tbody//tr//td//label[@id='lblDateTime']")
	WebElement LatestData;
	
	@FindBy (xpath = "//span[text()='Config Reports']")
	WebElement clickConfigReports;
	
	
	@FindBy (xpath = "//span[text()='eNodeB UtranCell Configuration Advanced Master']")
	WebElement clickenodeBAdvancedMaster;
	
	@FindBy (xpath = "//span[text()='Precanned Reports']")
	WebElement clickPrecannedReports;
	
	@FindBy (xpath = "//span[text()='eNodeB Performance KPIs']")
	WebElement clickenodeBPerfKPIs; 
	
	@FindBy (xpath = "//span[text()='LTE Performance Suite']")
	WebElement clickLTEPerfSuiteReports;
	
	@FindBy (xpath = "//span[text()='Isolation Report']")
	WebElement clickIsolationReport;
	
	@FindBy (xpath = "//span[text()='RCA Report']")
	WebElement RCAReport;
	
	@FindBy (xpath = "//span[text()='Fingerprint RCA National Rollup']")
	WebElement RCANationalRollup;
	
	@FindBy (xpath = "//span[text()='Triage Report']")
	WebElement TriageReport;
	

	/*Initializing all the WebElements*/
	public RANTS_BouyguesCustomerPage() {
	PageFactory.initElements(driver , this);
		}
	
    public static String mainWindow;
	
	public static void switchTabs(WebDriver driver) throws InterruptedException {
		mainWindow = driver.getWindowHandle();
		Thread.sleep(3000);
		Set<String> handles =driver.getWindowHandles();
		  for(String handle : handles) {
			  if(!handle.equals(mainWindow)) {
				  driver.switchTo().window(handle);
				  System.out.println(driver.getCurrentUrl().toString());
			  }
			  Thread.sleep(4000);
			  //driver.switchTo().window(mainWindow);
		  }
	}
	
	
	
	/*Method to get the Title of Bouygues Page*/
	public String VisibleOfBouygues() throws InterruptedException 
	{   
		Thread.sleep(10000);
		return driver.getTitle();
	}


	public String validateReportsTabText()
	{
		return ReportsTab.getText();
	}
	
	
	public String validateChartsTabText()
	{
		return ChartsTab.getText();
	}
	
	public String configTab()
	{
		return ConfigTab.getText();
	}
	
	public String KpisTab()
	{
		return KpisTab.getText();
	}
	
	
	public String FiltersOptionsTab()
	{
		return FiltersOptionsTab.getText();
	}
	
	public String LatestData()
	{
		
		return LatestData.getText();
	}
	
	public void clickonReportsTab()
	{
		ReportsTab.click();
	}
	
	public void clickonConfigReports()
	{
		clickConfigReports.click();
	}
	
	public void clickonUtranCellMaster()
	{
		clickenodeBAdvancedMaster.click();
	}
	
	public void clickonPrecannedReports()
	{
		clickPrecannedReports.click();
	}
	
	public void clickonenodeBPerfKPIs()
	{
		clickenodeBPerfKPIs.click();
	} 
	
	public void clickonLTESuite()
	{
		clickLTEPerfSuiteReports.click();
	}
	

	public void clickonIsolationReport()
	{
		clickIsolationReport.click();
	}
	
	
	public void clickonRCAReport()
	{
		RCAReport.click();
	}
	
	public void clickonRCANationalReport()
	{
		RCANationalRollup.click();
	}
	
	public void clickonTriageReport()
	{
		TriageReport.click();
	}
	
	public String getwindowhandle() {
		return driver.getWindowHandle();
	}

	
	
}
