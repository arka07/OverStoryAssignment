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



public class RANTS_RCAReport extends TestBase {
	
	
 	
	/*Inspecting WebElement for GNP Performance Portal*/	

	
	@FindBy (xpath = "//a[contains(text(),'FILTERS')]")
    WebElement FilterOption;
	
	@FindBy (xpath = "//input[contains(@title,'Refresh')]")
    WebElement clickRefresh;
	
	@FindBy (xpath = "//div[@class='k-grid-content-locked']//table//tbody//tr")
	List<WebElement> tablerowRCAReport;
	
	
	@FindBy (xpath = "//input[@name='cboRuleFamily']")
	WebElement RuleFamily;
	
	@FindBy (xpath = "//a[@id='cboTNE_Arrow']")
	WebElement clickNEarrow;
	
	
	public List<String> TableContent;
	public String ObjectID;
		
	/*Initializing all the WebElements*/
	public RANTS_RCAReport() 
	{
	PageFactory.initElements(driver , this);
	}
	
	/*Method to get the Title of Bouygues Page*/
	public String VisibleOfRCAReport() throws InterruptedException 
	{   
		Thread.sleep(10000);
		return driver.getTitle();
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
    
    public void selectNE() throws InterruptedException {
    	
    	System.out.println(driver.findElement(By.xpath("//div//ul//li/label[contains(text(),'"+ObjectID.toString()+"')]")).getText());
    	Thread.sleep(2000);
    	driver.findElement(By.xpath("//div//ul//li/label[contains(text(),'"+ObjectID.toString()+"')]")).click();
    	
    }
	

    public void ClickeFilterOption() 
    
    {
    	FilterOption.click();
    	
    }
    
    public void ClickNEarrow() 
    
    {
    	clickNEarrow.click();
    	
    }
    
 
	public void clickRefresh() throws InterruptedException 
    {
    	clickRefresh.click();
    }
    
	
	public String rulefamily() {
		
		return RuleFamily.getText();
		
	}
    
	public int tablesize() {
		return tablerowRCAReport.size();
	}

    
    
  
    

    
      
       
       
    
	
	  
	 
	 
	 
	
      
      

      

  	
      


  	 
  	
	   
    }
    
    

	

