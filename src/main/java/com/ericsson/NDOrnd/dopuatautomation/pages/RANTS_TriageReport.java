package com.ericsson.NDOrnd.dopuatautomation.pages;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.ericsson.NDOrnd.dopuatautomation.base.TestBase;



public class RANTS_TriageReport extends TestBase {
	
	
 	
	/*Inspecting WebElement for GNP Performance Portal*/	
	
	@FindBy (xpath = "(//tr//td[contains(@class,'rcbArrowCell rcbArrowCellRight')]//a)[2]")
	WebElement clickclusterNEs;
	
	@FindBy (xpath = "//ul[@class='rcbList']//li//label//input")
	WebElement selectclustercheckbox;
	
	@FindBy (xpath = "//input[@type='submit']")
	WebElement clicksubmit;
	
	@FindBy (xpath = "//div[@class='k-grid-content']//table//tbody//tr")
	List<WebElement> tablerowRCAReport;
	
	@FindBy (xpath = "(//div[contains(@class,'rcbScroll')]//ul//li)[2]")
	WebElement selectweek;
	
	@FindBy (xpath = "//input[contains(@title,'Refresh')]")
    WebElement clickRefresh;
	
	@FindBy (xpath = "//a[@id='cboWeek_Arrow']")
	WebElement clickNEarrow;
	
	@FindBy (xpath = "//a[@class='k-link']")
	WebElement gettextweekandcustomer;
	
	@FindBy (xpath = "//input[@name='cboWeek']")
	WebElement gettextweekandcustomerdrpdwn;
	
	
	@FindBy(xpath="//a[@id='infoSlidein']//span[contains(@class,'glyphicon-user')]")
	WebElement usersetting;
	
	@FindBy(xpath="//a[text()='My User Reports']")
	WebElement userreport;
	
	
	@FindBy(xpath="(//div[@class='k-grid-content']//table//tbody//tr//td)[2]")
	WebElement recorddate;
	
	@FindBy(xpath="(//div[@class='k-grid-content']//table//tbody//tr//td)[3]")
	WebElement status;
	
	
	
	public List<String> TableContent;
	public String ObjectID;
	public String rdate;
	public String sdate; 
	public String statusreport;
	
	
		
	/*Initializing all the WebElements*/
	public RANTS_TriageReport() 
	{
	PageFactory.initElements(driver , this);
	}
	
	/*Method to get the Title of Bouygues Page*/
	
	
	public String VisibleOfTriageReport() throws InterruptedException 
	{   
		Thread.sleep(10000);
		return driver.getTitle();
	}
	
	public void selectNEssubmit() throws InterruptedException 
	{
		clickclusterNEs.click();
		Thread.sleep(2000);
		selectclustercheckbox.click();
		Thread.sleep(2000);
		clicksubmit.click();
	}
	
	public String alerthandle() {
  		
      	Alert alert = driver.switchTo().alert();
      	String alertpopout =alert.getText();
      	if(alertpopout.contains("When the report is ready")) {
      		alert.accept();
      	}
      	else {
      		System.out.println("No popout is available");
      		}
      	return alertpopout;
      	}
		
    public void PerfTableValidation() {
    	TableContent = new ArrayList<>();
    
    		int trCountt=driver.findElements(By.xpath("//div[@class='k-grid-content-locked']//table//tbody//tr")).size();
    		
    		for(int tr=1;tr<2;tr++) {
    		
    			List<WebElement> tdelem = driver.findElements(By.xpath("//div[@class='k-grid-content-locked']//table//tbody//tr["+tr+"]//td"));
                int tdcount= tdelem.size();
                for(int td=1;td<=tdcount;td++) {
                	String TdVal=driver.findElement(By.xpath("//div[@class='k-grid-content-locked']//table//tbody//tr["+tr+"]//td["+td+"]")).getText();
                	System.out.println("The Table value of  "+tr+"/st/nd/rd/th Row is::::"+TdVal);
                	TableContent.add(TdVal);
                	ObjectID= TableContent.get(0);
                	System.out.println("ObjectId is  " +  ObjectID);
                	
                }
    		}
       }
    
    public void ClickNEarrow() 
    
    {
    	clickNEarrow.click();
    }
    
    public void SelectWeek() 
    
    {
    	selectweek.click();
    }
    
   
	
	
	public String gettextindropdown() {
		return gettextweekandcustomer.getText().split(",")[1].trim();
		
		
	}
	
    public String gettextintable() {
		return gettextweekandcustomerdrpdwn.getAttribute("value");
		
	}
    
    public boolean checkweekselection() {
    	boolean wselect =false;
    	
    	if(gettextindropdown().equals(gettextintable())) {
    		System.out.println("Week selection in table and dropdown is correct");
    		wselect = true;
    	}
    	else {
    		System.out.println("Week selection in table and dropdown is not correct");
    		wselect =false;  	
    	}  
    	return wselect;
    }
     
	public int tablesize() {
		return tablerowRCAReport.size();
	}

    public void clickusersetting() throws InterruptedException {
    	usersetting.click();
    	Thread.sleep(3000);
    	userreport.click();
    }
    
    
    public String getrecorddate() {
    	return recorddate.getText().split(" ")[0].toString();
    	
    }
    
    
    
    public String getstatus() {
    	return status.getText().split(" ")[0].toString();
    	
    }
      
    
    public String getsystemdate() {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    	Date date = new Date();
    	return dateFormat.format(date); 
    	
    }
    
   public void storingvariables() {
	   rdate=getrecorddate();
	   statusreport=getstatus();
	   sdate=getsystemdate();
	   
	   
   }
    
       
    public void clickRefresh() {
    	boolean arka=false;
    	while(!arka) {
    		if(!(sdate.equalsIgnoreCase(rdate) && statusreport.contains("Completed"))) {
    		clickRefresh.click();
    		arka= false;
    		}
    		else {
    			arka=true;
    			System.out.println("Triage Report is already present for "+sdate) ;
    		}
    			
  
    		
    	}
    }
       
    
	
	  
	 
	 
	 
	
      
      

      

  	
      


  	 
  	
	   
    }
    
    

	

