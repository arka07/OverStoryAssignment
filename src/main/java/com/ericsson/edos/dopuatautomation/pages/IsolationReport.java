package com.ericsson.edos.dopuatautomation.pages;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;
import com.ericsson.edos.dopuatautomation.base.TestBase;



public class IsolationReport extends TestBase {
	
	 String sdate;
	 String edate;
	 String fsdate;
	 String fedate;
     
 	
	/*Inspecting WebElement for GNP Performance Portal*/	
	@FindBy (xpath = "//a[text()='REPORTS']")
	WebElement ReportsTab;
	
	 
	@FindBy (xpath = "//input[@id='rdpSDate_dateInput']")
	WebElement StartTime;

	
	@FindBy (xpath = "//input[@id='rdpEDate_dateInput']")
	WebElement EndTime;
	
	@FindBy (xpath = "//a[contains(text(),'FILTERS')]")
    WebElement FilterOption;
	
	@FindBy (xpath = "//a[@id='cboTNE_Arrow']")
    WebElement isolationarrowdowncell;
	
	@FindBy (xpath = "(//input[@class='rcbCheckBox'])[1]")
    WebElement isolationselectNE;
	
	@FindBy (xpath = "//a[@id='cboSubNetwork1_Arrow']")
    WebElement isolationarrowdowncell2;
	
	@FindBy (xpath = "(//input[@class='rcbCheckBox'])[1]")
    WebElement isolationselectsubnetwork1;
	
	@FindBy (xpath = "//tr//td//input[@id='cboTNE_Input']")
    WebElement NEtext;
	
	@FindBy (xpath = "//a[@id='cboTNE_Arrow']")
    WebElement NEarrow;
	
	@FindBy (xpath = "//input[contains(@title,'Refresh')]")
    WebElement clickRefresh;
	
	@FindBy (xpath = "//div[@class='k-grid-content-locked']//table//tbody//tr")
	List<WebElement> tablerowIsolationReport;
	
	@FindBy (xpath = "//input[@id='cboReport_Input']")
	List<WebElement> enodeBReportName ;
	
	public List<String> TableContent;
		
	/*Initializing all the WebElements*/
	public IsolationReport() 
	{
	PageFactory.initElements(driver , this);
	}
	
	/*Method to get the Title of Bouygues Page*/
	public String VisibleOfIsolationKPIs() throws InterruptedException 
	{   
		Thread.sleep(10000);
		return driver.getTitle();
	}
	

    public void ClickeFilterOption() 
    
    {
    	FilterOption.click();
    }
    
 
	public void clickRefresh() throws InterruptedException 
    {
    	clickRefresh.click();
    }
    
    
    public void PerfTableValidation() {
    	TableContent = new ArrayList<>();
    
    		int trCountt=driver.findElements(By.xpath("//div[@class='k-grid-content-locked']//table//tbody//tr")).size();
    		
    		for(int tr=1;tr<=trCountt;tr++) {
    		
    			List<WebElement> tdelem = driver.findElements(By.xpath("//div[@class='k-grid-content-locked']//table//tbody//tr["+tr+"]//td"));
                int tdcount= tdelem.size();
                for(int td=1;td<=tdcount;td++) {
                	String TdVal=driver.findElement(By.xpath("//div[@class='k-grid-content-locked']//table//tbody//tr["+tr+"]//td["+td+"]")).getText();
                	System.out.println("The Table value of  "+tr+"/st/nd/rd/th Row is::::"+TdVal);
                	TableContent.add(TdVal);
                	
                }
    		}
    		for(String tableitems:TableContent) {
    			System.out.println("tablecontent:::::::::::::::::: "+ tableitems);
    		}
    		
 	}
    
    
  
    
	public String GetStarttime() {
		sdate= StartTime.getAttribute("value").split(" ")[0].toString();
		return StartTime.getAttribute("value").split(" ")[0].toString();
	}
	
	
	

	public String GetEndtime()
	
	{
	edate=EndTime.getAttribute("value").split(" ")[0].toString();
	return EndTime.getAttribute("value").split(" ")[0].toString();
	}
    
      
       
       
    
	  public String  FormatDate(String FormatDate) {
		Date dt = new Date(FormatDate);
		String patternD="yyyy/MM/dd";
		SimpleDateFormat sdf= new SimpleDateFormat(patternD);
		System.out.println("Formatted Date is::::"+sdf.format(dt));
		return sdf.format(dt);
		}
	  
	 
	 
	 
	  public boolean checkdate() {
    	  boolean b= false;
    	  fsdate = FormatDate(sdate);
    	  fedate = FormatDate(edate);
    	  if(TableContent.contains(fsdate) && TableContent.contains(fedate)) {
    		  System.out.println("Table contains"+ fsdate + fedate);
    		  b= true;
    	  }
    	  else {
    		  System.out.println("Table doesnot contains"+ fsdate + fedate);
    		  b=false;
    	  }
    	  return b;
      }
      
      

      
  	
  	 public boolean checkNE() {
   	  boolean b= false;
   	  if(TableContent.contains(NEtext())) {
   		  System.out.println("Table contains"+ NEtext());
   		  b= true;
   	  }
   	  else {
   		  System.out.println("Table doesnot contains"+ NEtext());
   		  b=false;
   	  }
   	  return b;
     }
  	 
  	
      
	  public void selectNE() throws InterruptedException {
		  
		  isolationarrowdowncell.click();
		  Thread.sleep(2000);
		  isolationselectNE.click();
		  
	  }
	  
	  public void SubNE1() throws InterruptedException {
		  isolationarrowdowncell2.click();
		  Thread.sleep(2000);
		  isolationselectsubnetwork1.click();
		  
	  }
	  
	  	public String NEtext() {
			return NEtext.getAttribute("value");
			}
	
  	 
  	
	   
    }
    
    

	

