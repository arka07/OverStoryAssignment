package com.ericsson.NDOrnd.dopuatautomation.pages;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import com.ericsson.NDOrnd.dopuatautomation.base.TestBase;



public class RANTS_RCANationalRollup extends TestBase {
	
	
 	
	/*Inspecting WebElement for GNP Performance Portal*/	

	@FindBy (xpath = "//div[@class='k-grid-content']//table//tbody//tr")
	List<WebElement> tablerowRCAReport;
	
	
	@FindBy (xpath = "//a[@id='cboWeek_Arrow']")
	WebElement RecordDateArrow;
	
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
	
	
	public List<String> TableContent;
	public String ObjectID;
		
	/*Initializing all the WebElements*/
	public RANTS_RCANationalRollup() 
	{
	PageFactory.initElements(driver , this);
	}
	
	/*Method to get the Title of Bouygues Page*/

	
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
    
    public void clickRefresh() throws InterruptedException 
    {
    	clickRefresh.click();
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

    
    
  
    

    
      
       
       
    
	
	  
	 
	 
	 
	
      
      

      

  	
      


  	 
  	
	   
    }
    
    

	

