package com.ericsson.NDOrnd.dopuatautomation.pages;

//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ericsson.NDOrnd.dopuatautomation.base.Lib;
import com.ericsson.NDOrnd.dopuatautomation.base.TestBase;


public class RANTS_DynamicGraphicalReportsPage extends TestBase {
	
	//TC - 15 DynamicGraphicalReport: 
	
	
	
	
		//private static final String TableContent = null;
		public String sdate;
		String edate;
		String fsdate;
		String fedate;
		public List<String> TableContent;
		public String EnodeNameforQB=Lib.getProperty(CONFIG_PATH, "EnodeNameQB");

		@FindBy(xpath=("//span[contains(text(),'Dynamic Graphical Reports')]"))
		WebElement DynamicGraphicalReports;
		
		
		@FindBy(xpath=("//a[@id='filtersSlidein']"))
		WebElement FilterOptions;
		

		@FindBy(xpath=("//input[@name='cboExistingReports']"))
		WebElement ExistingReport;
		
		@FindBy(xpath=("//input[@id='txtReportName']"))
		WebElement ReportName;
		
		@FindBy(xpath=("//li[contains(text(),'DGR Sample Template LTE Cell Level')]"))
		WebElement SelectExistingReportSelection;
		
		@FindBy (xpath = "//textarea[@id='txtCells']")
	    WebElement TextAreatextDGR;
		
	    @FindBy (xpath = "//textarea[contains(text(),'ENTER COMA DELIMITED LIST OF CELLS')]")
		WebElement ClusterNEDGR;
		
		//To select Start Date
		@FindBy(xpath=("//a[contains(@id,'rdpSDate_popupButton')]"))
		WebElement StratDateDGR;
		
		@FindBy (xpath = "//a[@id='rdpSDate_popupButton']")
		WebElement StartDateCalenderbtn;
		  
		@FindBy (xpath = "//a[@id='rdpEDate_popupButton']")
		WebElement EndDateCalenderbtn;
		   
		@FindBy (xpath = "//table//tr//td[@class='rcSelected']/preceding-sibling::td[1]")
	    WebElement StartDateselected;
		  
		@FindBy (xpath = "//table//tr//td[@class='rcSelected']")
		WebElement DateSelected;
		
		@FindBy (xpath = "//input[@id='rdpSDate_dateInput']")
		WebElement startDateText;
		
		@FindBy (xpath = "//input[@id='rdpEDate_dateInput']")
		WebElement endDateText;
		
		@FindBy (xpath = "//a[@id='cboLevel_Arrow']")
		WebElement cluster_Arrow;
		
		@FindBy (xpath = "//li[contains(text(),'Cluster Level')]")
		WebElement cluster_Selection;
		
		@FindBy (xpath = "//a[@id='cboTimeAggr_Arrow']")
		WebElement daily_Arrow;
		
		@FindBy (xpath = "//li[contains(text(),'Daily')]")
		WebElement daily_Selection;		
		 
		@FindBy (xpath = "//input[@id='Button1']")
		WebElement RefreshButtonDGR;
		
		@FindBy (xpath = "//span[contains(text(),'Table')]")
		WebElement tableValidation;
		
		@FindBy (xpath = "//span[contains(text(),'All KPIs')]")
		WebElement tableValidation_KPI;
		
		@FindBy (xpath = "//span[contains(text(),'Charts')]")
		WebElement tableValidation_Charts;
		
		@FindBy (xpath = "//td[contains(text(),'Cluster')]")
		WebElement table_row;
		
	

		@FindBy (xpath = "//button[contains(text(),'Options')]")
		WebElement DGR_Option;
		
		@FindBy (xpath = "//input[@id='btnExportDataToExcel']")
		WebElement DGR_Excel;
		
		@FindBy (xpath = "//input[@id='btnExportDataToCSV']")
		WebElement DGR_CSV;
		
		Actions Act = new Actions(driver);
		//JavascriptExecutor jse = (JavascriptExecutor) driver;
	
		
		
		//Constructor
		public RANTS_DynamicGraphicalReportsPage(){
			PageFactory.initElements(driver , this);
		}
		
		
		

		
		//utilization

		//TC-15
		
		//Click on the DynamicGraphicalReprot
		
		
		public String gettitleDGR() {
			return driver.getTitle();
		}
		
		public void clickonDynamicGraphicalReports() throws InterruptedException
		{
			DynamicGraphicalReports.click();
			Thread.sleep(5000);
		}
		
		//Validation for DynamicGraphicalReprot
		public String DynamicGraphicalReports()
		{
			return FilterOptions.getText();
		}
		
		//Click on Filter/Options
		public void clickonFilterOptions() throws InterruptedException
		{   
			Thread.sleep(2000);
			FilterOptions.click();
			Thread.sleep(1000);
		}
		
		//Click on ExistingReport
		public void clickonExistingReport() throws InterruptedException 
		{
			ExistingReport.click();
			Thread.sleep(2000);
			/*ExistingReport.sendKeys(Keys.ENTER);
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER);*/
			//ExistingReport.sendKeys(Keys.ENTER);
			SelectExistingReportSelection.click();
			Thread.sleep(1000);
			TextAreatextDGR.click();
			ClusterNEDGR.sendKeys(EnodeNameforQB);
			Thread.sleep(1000);
			System.out.println("Clicked on the dynamicgraphicalreportspage sendnodename ");
			FilterOptions.click();
			Thread.sleep(1000);
			cluster_Arrow.click();
			Thread.sleep(2000);
			cluster_Selection.click();
			System.out.println("Clicked on the dynamicgraphicalreportspage Cluster Selection ");
			Thread.sleep(2000);
			daily_Arrow.click();
			Thread.sleep(2000);
			daily_Selection.click();
			Thread.sleep(2000);
			System.out.println("Clicked on the dynamicgraphicalreportspage Daily Selection ");
			
				
		}
		
		//Date selection for 2 days
		public void  SetDateSelection() throws InterruptedException {
			Thread.sleep(2000);
		    StartDateCalenderbtn.click();
		    Thread.sleep(2000);
		    DateSelected.click();
		    Thread.sleep(2000);
		    EndDateCalenderbtn.click();
		    Thread.sleep(2000);
		    DateSelected.click();
		    RefreshButtonDGR.click();
		    //tableValidation.getText();
			
		}
		
		//Validation for ExistingReprot
				public String ExistingReport()
				{
					return ReportName.getText();
				}
		
		//Table header tab validation
		public String TableValidation() throws InterruptedException {
			tableValidation_KPI.getText();
			return tableValidation_KPI.getText();
			
		}
		
		
		//Table row text capturing for validation
		public String TableRow() throws InterruptedException {
		    Thread.sleep(2000);
			table_row.getText();
			return table_row.getText();				
			
		}
		
		//Table row count
		public int DGR_NumberofRowsValidation() throws InterruptedException {
			Thread.sleep(1000);
			int rowcount = driver.findElements(By.xpath("//div[contains(@class,'k-grid-content')]//table//tbody//tr")).size();
			return rowcount;	
				 
		}
		
		//Table cloumn text capturing
		public void DGR_TableRowtext() throws InterruptedException {
			Thread.sleep(1000);	
			TableContent = new ArrayList<>();
			int r = driver.findElements(By.xpath("//div[contains(@class,'k-grid-content')]//table//tbody//tr")).size();
			 for (int tr=1 ; tr<=r; tr++) {
                 List<WebElement> tdelem = driver.findElements(By.xpath("//div[contains(@class,'k-grid-content')]//table//tbody//tr["+tr+"]//td"));
             int tdcount= tdelem.size();
             for(int td=1;td<=tdcount;td++) {
                 String TdVal=driver.findElement(By.xpath("//div[contains(@class,'k-grid-content')]//table//tbody//tr["+tr+"]//td["+td+"]")).getText();
                 System.out.println("The Table value of  "+tr+"/st/nd/rd/th Row is::::"+TdVal);
                 TableContent.add(TdVal);
 
				 
		}
             for(Object tableitems:TableContent) {
                 System.out.println("tablecontent:::::::::::::::::: "+ tableitems);
             }
	 }
 
 }
		//Date capturing from column and date box, changing the format for validation purpose
		public String GetStarttime() {
            //sdate=startDateText.getAttribute("value").split(" ")[0].toString();
            return startDateText.getAttribute("value").split(" ")[0].toString();
     }
		
		public String GetEndtime() {
            //edate=endDateText.getAttribute("value").split(" ")[0].toString();
            return endDateText.getAttribute("value").split(" ")[0].toString();
     }
		
		  public String  FormatDate(String FormatDate) {
				Date dt= new Date(FormatDate);
				String patternD="yyyy/MM/dd";
				SimpleDateFormat sdf= new SimpleDateFormat(patternD);
				System.out.println("Formatted Date is::::"+sdf.format(dt));
				return sdf.format(dt);
				}
			  

       public boolean checkdate() {
          boolean b= false;
          sdate= GetStarttime();
          edate=GetEndtime();
          fsdate = FormatDate(sdate);
          fedate = FormatDate(edate);
          System.out.println("fsdate" + fsdate);
          System.out.println("fedate" + fedate );
          boolean cc=TableContent.contains(fsdate);
          System.out.println("cc::"+cc );
          boolean cc2=TableContent.contains(fedate);
          System.out.println("cc2::"+cc2);
          
          if(TableContent.contains(fsdate) && TableContent.contains(fedate)) {
              System.out.println("Table contains"+ fsdate +" "+ fedate);
              b= true;
       }
       else {
              System.out.println("Table doesnot contains"+ fsdate + fedate);
              b=false;
       }
       return b;
    }
	

		
		//Excel and CSV download

	/*	public void  DGR_Excel() throws InterruptedException  {
			DGR_Option.click();
			DGR_Excel.click();
			Thread.sleep(1000);
			DGR_Option.click();
			DGR_CSV.click();
		}
		*/
	
}





