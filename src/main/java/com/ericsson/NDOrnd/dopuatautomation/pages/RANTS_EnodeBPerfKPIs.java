package com.ericsson.NDOrnd.dopuatautomation.pages;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ericsson.NDOrnd.dopuatautomation.base.TestBase;


public class RANTS_EnodeBPerfKPIs extends TestBase {
	
	  public String sdate;
      String edate;
	  String fsdate;
      String fedate;
     public String FinalStartDate;
     public String FinalEndDate;
     public String SelectedStartDateis;
     public String SelectedEndDateis;
     public String  SelectedStartDtTitle;
     public String  SelectedEndDtTitle;
     Actions actepref = new Actions(driver);
	/*Inspecting WebElement for GNP Performance Portal*/	
	@FindBy (xpath = "//a[text()='REPORTS']")
	WebElement ReportsTab;
	
	//WebElement for fetching Start Date Calendar 
	@FindBy (xpath = "//input[@id='rdpSDate_dateInput']")
	WebElement StartTime;

	//WebElement for fetching End Date Calendar 
	@FindBy (xpath = "//input[@id='rdpEDate_dateInput']")
	WebElement EndTime;
	
	//WebElement for Filters Tab 
	@FindBy (xpath = "//a[contains(text(),'FILTERS')]")
    WebElement eNodeBFilterOption;
	
	//WebElement for EnodeB Dropdown Arrowdown
	@FindBy (xpath = "//a[@id='cboCell_Arrow']")
    WebElement eNOdeBPerfarrowdowncell;
	
	//WebElement for EnodeB More Results Dropdown Arrowdown
	@FindBy (xpath = "//a[@id='cboCell_MoreResultsBoxImage']")
    WebElement eNOdeBPerfdarrowdowncellmore;
	
	//WebElement for selecting first cell 
	@FindBy (xpath = "//div[@id='cboCell_DropDown']//div[contains(@class,'rcbScroll')]//ul//li[1]")
    WebElement selectfirstcell;
	
	//WebElement for EnodeKpiPerformanceKPI page refresh button
	@FindBy (xpath = "//input[contains(@title,'Refresh')]")
    WebElement clickRefresh;
	
	//WebElement for EnodeKpiPerformanceKPIpage First table
	@FindBy (xpath = "//div[@class='k-grid-content-locked']//table//tbody//tr")
	List<WebElement> tablerowenodeBadvanced;
	
	//WebElement for EnodeKpiPerformanceKPIpage Time Aggr dropdown
	@FindBy (xpath = "//a[@id='cboTimeAggr_Arrow']")
	WebElement clickarrowdownSectorcarrier;
	
	//WebElement for EnodeKpiPerformanceKPIpage Time(Daily) Aggr selection
	@FindBy (xpath = "//div//ul//li[1]")
	WebElement selectSectorDaily;
	
	//WebElement for EnodeKpiPerformanceKPI page NE Textarea Selection
	@FindBy (xpath = "//textarea[@id='txtCells']")
	WebElement NEtext;
	
	//WebElement for EnodeKpiPerformanceKPIpage fetching Report Name 
	@FindBy (xpath = "//input[@id='cboReport_Input']")
	List<WebElement> enodeBReportName ;
	
	//WebElement for EnodeKpiPerformanceKPIpage StartDate Selection required for Graph 
	@FindBy (xpath = "//input[@id='rdpSDate_dateInput']")
	WebElement FStartDate;
	
	//WebElement for EnodeKpiPerformanceKPIpage EndDate Selection required for Graph
	@FindBy (xpath = "//input[@id='rdpEDate_dateInput']")
	WebElement FEndDate;
	
	//WebElement for EnodeKpiPerformanceKPI page Graph Button 
	@FindBy (xpath = "//input[@id='btnGraph_input']")
	WebElement GraphButton;
	
	//WebElement for  Chart Options tab/slider  
	@FindBy (xpath = "//a[@id='filtersSlidein' or text()='CHART OPTIONS']")
	WebElement ChartOptionSlider;
	
	//WebElement for clicking Arrow(triangle) button in the KPI2 Selection  in Chart Option Tab for KPI Chart  
	@FindBy (xpath = "//a[@id='cboKPI_KPI2_Arrow']")
	WebElement KPI2DropDownArrow;
	
	//WebElement for getting count of KPI2 Dropdown elements  the KPI2 Selection in Chart Option Tab for KPI Chart  
	@FindBy (xpath = "//div[@id='cboKPI_KPI2_DropDown']//ul//li")
	List<WebElement> KPI2DropDownlistsize; 
	
	//WebElement for clicking Chart Type selection for KPI1 in Chart Option Tab for KPI Chart  
	@FindBy (xpath = "//a[@id='cboKPI_ChartType1_Arrow']")
	WebElement CharttypeDr1;
	
	//WebElement for clicking Chart Type selection for KPI2 in Chart Option Tab for KPI Chart
	@FindBy (xpath = "//a[@id='cboKPI_ChartType2_Arrow']")
	WebElement CharttypeDr2;
	
	//WebElement for selecting the Chart type as Line in the Charttype  dropdown of KPI1 
	@FindBy (xpath = "//div[@id='cboKPI_ChartType1_DropDown']//ul//li[text()='Line']")
	WebElement Chr1LineSel;
	
	//WebElement for selecting the Chart type as Line in the Charttype  dropdown of KPI2
	@FindBy (xpath = "//div[@id='cboKPI_ChartType2_DropDown']//ul//li[text()='Line']")
	WebElement Chr2LineSel;
	
	//WebElement for Charting page refresh button
	@FindBy (xpath = "//input[@id='Button1' or @value='Refresh']")
	WebElement ChartRefreshButton;
	
	//WebElement for clicking Arrow(triangle) button in the Chart Type in  Chart Option Tab for KPI1 Chart
	@FindBy (xpath = "//a[@id='cboKPI_ChartType1_Arrow']")
	WebElement ChartType1;
	
	//WebElement for clicking Arrow(triangle) button in the Chart Type in  Chart Option Tab for KPI2 Chart
	@FindBy (xpath = "//a[@id='cboKPI_ChartType2_Arrow']")
	WebElement ChartType2;
	
	//WebElement for fetching the Accessibility (%) title in the graph plotted 
	@FindBy (xpath = "//div[@id='kpiChart1']//*[name()='svg']//*[name()='g']//*[name()='text'][contains(text(),'Accessibility (%)')]")
	List<WebElement> ChartTitleKPI1;
	
	//WebElement for fetching the ERAB Attempts title in the graph plotted for KPI Chart 
	@FindBy (xpath = "//div[@id='kpiChart1']//*[name()='svg']//*[name()='g']//*[name()='text'][contains(text(),'ERAB Attempts')]")
	List<WebElement> ChartTitleKPI2;
	
	
	//WebElement for capturing the circle counts that are mapped in the graph method-SwitchToChartTab()
    @FindBy (xpath = "//*[name()='svg']//*[name()='g']//*[name()='circle']")
    List<WebElement> ChartYseriesCircleCounts;
    
    //WebElement for clicking on StartDate Calendar icon 
    @FindBy (xpath = "//a[@id='rdpSDate_popupButton']")
    WebElement StartDtCalicon;
  
    //WebElement for clicking on EndDate Calendar icon 
    @FindBy (xpath = "//a[@id='rdpEDate_popupButton']")
    WebElement EndDtCalicon;
    
    //WebElement for clicking on NE Chart Tab Option in the Char Options slider
    @FindBy (xpath = "//div[@id='tabstrip']//ul//li//span[contains(text(),'NE Chart')]")
    WebElement NEchartTab;
    
    //WebElement for clicking on Time Chart Tab Option in the Char Options slider
    @FindBy (xpath = "//div[@id='tabstrip']//ul//li//span[contains(text(),'Time Chart')]")
    WebElement TimechartTab;
    
    //WebElement for clicking on  clicking Arrow(triangle) button in the Chart Type in  Chart Option Tab for NE Chart for selecting 2 Network Elements
    @FindBy (xpath = " //a[@id='cboNE_NE1_Arrow']")
    WebElement NEchartNEdrArrrow;
    
    //WebElement for getting count of Network Elements available in the dropdown of Network Elements 
    @FindBy (xpath = "//div[@id='cboNE_NE1_DropDown']//ul//li//label")
    List<WebElement> NEdrchrsize;
  
    //WebElement for clicking on  clicking Arrow(triangle) button in the Time Chart of 	Starting Dates multiselect dropodown
    @FindBy (xpath = "//a[@id='cboTIME_Dates_Arrow']")
    WebElement TimechartDtdrArrrow;
  
    //WebElement for getting count of Dates available in the  Starting Dates multiselect dropodown
    @FindBy (xpath = "(//div[@id='cboTIME_Dates_DropDown']//ul/li//label)")
    List<WebElement> DtDrinTimeChart;
    
    
     /*List for storing the data */
	public List<String> TableContent;
	
	
	//Creating the JavascriptExecutor instance globally 
    JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	
	/*Initializing all the WebElements*/
	public RANTS_EnodeBPerfKPIs() 
	{
	PageFactory.initElements(driver , this);
	}
	
	/*Method to get the Title of Bouygues Page*/
	public String VisibleOfeNodeBPerfKPIs() throws InterruptedException 
	{   
		Thread.sleep(10000);
		return driver.getTitle();
	}
	
	/*Method to Click the Filter Option*/
    public void ClickeNodeBFilterOption() 
    
    {
    	eNodeBFilterOption.click();
    }
    
    /*Method to Clicking the Cellselection dropdown */
    public void clickarrowdowncell() throws InterruptedException 
    {
    	eNOdeBPerfarrowdowncell.click();
    	Thread.sleep(5000);
    	eNOdeBPerfdarrowdowncellmore.click();
    	Thread.sleep(5000);
    }
	
    /*Method to selecting the first cell listed from the Cell Dropdown*/
    public void clickfirstcell() throws InterruptedException 
    {
    	selectfirstcell.click();
    }
    
    /*Method for clicking refresh button of the EnodeBperformance KPI Page */
    public void clickRefresh() throws InterruptedException 
    {
    	clickRefresh.click();
    }
    
    /*Method for getting the Table size*/
    public int  tablesize() throws InterruptedException 
    {
    	return tablerowenodeBadvanced.size();
    }
    
    /*Method for selecting the Daily option from the TIme Aggr dropdown  */
    public void clickSectorDaily() throws InterruptedException 
    {
    	
    	clickarrowdownSectorcarrier.click();
    	Thread.sleep(5000);
    	selectSectorDaily.click();
    }
    
    /*Method to validating the table */
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
    
    
  
    /*Method to getting Start Date from the EnodeBperformance KPI page*/
	public String GetStarttime() {
		sdate= StartTime.getAttribute("value").split(" ")[0].toString();
		return StartTime.getAttribute("value").split(" ")[0].toString();
	}
	
	
	
	/*Method to getting End Date from the EnodeBperformance KPI page*/
	public String GetEndtime()
	
	{
	edate=EndTime.getAttribute("value").split(" ")[0].toString();
	return EndTime.getAttribute("value").split(" ")[0].toString();
	}
    
      
       
       
	/*Method to format the date similar to format that of the tables date's*/
	  public String  FormatDate(String FormatDate) {
		Date dt = new Date(FormatDate);
		String patternD="yyyy/MM/dd";
		SimpleDateFormat sdf= new SimpleDateFormat(patternD);
		System.out.println("Formatted Date is::::"+sdf.format(dt));
		return sdf.format(dt);
		}
	  
	 
	 
	  /*Method to validate the start & End date availability in the table filtered */
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
      
	 /*Method to fetch the NE Element/Cell  Selected*/ 
  	public String NEtext() {
		return NEtext.getAttribute("value");
		}
      
  	
  	/*Method to validate the NE Element/Cell  Selected availability in the filtered Table */
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
  	 
  
  	 
 
  	 /*Generic Method to fetch startdate & enddate of the EnideB preformance KPI page required the same in Graph selection page*/
  	 public String GetDateBeforeClick(String IdOfEle) {
		
  		 String StrVal;
  	        StringBuilder StrFrDates = new StringBuilder();
  	
         	StrFrDates.append("//input[@id='");
         	  StrFrDates.append("rdp");
  	          StrFrDates.append(IdOfEle);
  	          StrFrDates.append("Date_dateInput");
        	  StrFrDates.append("']");
        	  
        
        	  	StrVal=driver.findElement(By.xpath(StrFrDates.toString())).getAttribute("value");
        	  	return StrVal;
 
	}
  	
  	 
  /*Getting only date from the fetched dateval */
  	public void GetDatesVal() throws InterruptedException {
  		
  	 	FinalStartDate=GetDateBeforeClick("S"); 
  	 	System.out.println("The Captured Calendar StartDate is:::::"+FinalStartDate);
  	 	FinalEndDate=GetDateBeforeClick("E");
  	 	System.out.println("The Captured Calendar is EndDate  is:::::"+FinalEndDate);
		Thread.sleep(3000);
		SelectedStartDateis=FinalStartDate.split("/")[1];
		SelectedEndDateis=FinalEndDate.split("/")[1];
		System.out.println("The Selected date is:::"+SelectedStartDateis);
		System.out.println("The Selected date is:::"+SelectedEndDateis);
		Thread.sleep(4000);
		GraphButton.click();
		Thread.sleep(5000);
		 ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		    driver.switchTo().window(tabs2.get(4));
	}
  	
  	
  	/*Method to De-selecting Accessibility QCI 1 (%) and Selecting ERAB Attempts from tHe Y2 Axis in the KPI Chart Section */
  	public void SelectKPI2Val() throws InterruptedException {
  		KPI2DropDownArrow.click();
  		Thread.sleep(3000);
  		List<String> KPI2Vals = new ArrayList<>();
  		int DrSize=KPI2DropDownlistsize.size();
  		for(int kp=1;kp<=DrSize;kp++)
  		{
  			WebElement Ele=driver.findElement(By.xpath("(//div[@id='cboKPI_KPI2_DropDown']//ul//li//label)["+kp+"]"));
  		    String DrTxt=Ele.getText();
  		  KPI2Vals.add(DrTxt);
  		  if(DrTxt.trim().equals("Accessibility QCI 1 (%)") || DrTxt.trim().equals("ERAB Attempts") )
  		  {
  			Ele.click();
  			System.out.println("The Dropdown element selected is:::::"+Ele.getText());
  			Reporter.log("The Dropdown element selected is:::::"+Ele.getText());
  		  }	
  		}
  		

  		for(String DrpVals:KPI2Vals)
  		{
  			Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"The DropDown List values are:::" +DrpVals+"</b>"+"<span>"+"<br/>");
  			System.out.println("The DropDown List values are:::" +DrpVals);
  			
  		}
  		
	}
  	
  	/*Method to Select the Chart Options slider */
  	public void GetEprefKPIChartOPtionFilter() throws InterruptedException {
	
  		ChartOptionSlider.click();
  		Thread.sleep(3000);
  		
	}
  	 
  	/*Generic Method to Select the Date from the Calendar in Graph page using javasccripexecutor(not best practice) */
	 public void SetCalDates(String TxtId,String SorEdate) {
	  		
    	 StringBuilder StrforTA = new StringBuilder();
    	 StrforTA.append("document.getElementById('");
    	 StrforTA.append(TxtId);
          StrforTA.append("').value =");
          StrforTA.append("'");
          StrforTA.append(SorEdate);
          StrforTA.append("'");
          StrforTA.append(";");
         
          jse.executeScript(StrforTA.toString());
	   
	}
  	 
	 /*Method to Selecting the Date from the calendar by using */
	 public void SetDatesinCalTxt() throws InterruptedException {
		 
		 StartDtCalicon.click();
		 Thread.sleep(2000);
		 SelectedStartDtTitle=SetDate("rdpSDate_calendar_Top",SelectedStartDateis );
		 System.out.println("The Title of the start date is:::"+SelectedStartDtTitle);
		 Thread.sleep(2000);
		 EndDtCalicon.click();
		 SelectedEndDtTitle=SetDate("rdpEDate_calendar_Top", SelectedEndDateis);
		 System.out.println("The Title of the End date is:::"+SelectedEndDtTitle);
		 Thread.sleep(4000);
	}
	 
	 /*Generic Method to Set the Chart type*/
	 public void SetChartType(String ArrId) throws InterruptedException {
		 if(ArrId.equals("cboKPI_ChartType1_DropDown")){
			 ChartType1.click();
			 }
		 else{
			 ChartType2.click();
		 }
		     Thread.sleep(2000);
		    StringBuilder strbdr = new StringBuilder();
		    strbdr.append("//div[@id='");
		    strbdr.append(ArrId);
		    strbdr.append("']");
		    strbdr.append("//ul//li");
	    	int drsize=driver.findElements(By.xpath(strbdr.toString())).size();
	    	List<String> DrvaluesofChrtyp = new ArrayList<>();
	    	
	    	for(int arl=1;arl<=drsize;arl++)
	    	{
	    		WebElement Ele2=driver.findElement(By.xpath("(//div[@id='"+ArrId+"']//ul//li)["+arl+"]"));
	    		 String DrTxt=Ele2.getText();
	    		 DrvaluesofChrtyp.add(DrTxt);
	    		 if(DrTxt.trim().equals("Line")){
	    			 Ele2.click();
	    			 System.out.println("The Selected ChartType is::"+Ele2.getText());
	    		 }
	    	}
	    	
	    	for(String Chrtype:DrvaluesofChrtyp){
	    		System.out.println("The Chart Type values are::::"+Chrtype);
	    		
	    	}
	    	
		}
	 
	 /*Generic method to select the date on opening the calendar for both start and end Date selection*/
	 public String SetDate(String Xid,String Dt) throws InterruptedException {
		StringBuilder strfrdat= new StringBuilder();
		strfrdat.append("//table[@id='");
		strfrdat.append(Xid);
		strfrdat.append("']//tbody//tr//td[not(contains(@class,'rcOtherMonth'))  and  contains(@title,'");
		strfrdat.append(Dt.trim());
		strfrdat.append("')]//a[text()='");
		strfrdat.append(Dt.trim());
		strfrdat.append("']");
		///table[@id='rdpEDate_calendar_Top']//tbody//tr//td[not(contains(@class,'rcOtherMonth'))  and  contains(@title,'25')]//a[text()='25']
		Thread.sleep(5000);
		String dttitle=driver.findElement(By.xpath("//table[@id='"+Xid+"']//tbody//tr//td[not(contains(@class,'rcOtherMonth'))  and  contains(@title,'"+Dt+"')]")).getAttribute("title");
		Thread.sleep(2000);
		driver.findElement(By.xpath(strfrdat.toString())).click();
		return dttitle;
	}
	 
	 
public String FormattTitleDate(String TitleDate) {
		
    String s1=TitleDate.split(",")[0].substring(0, 3);
    System.out.println(s1);
	String s2=TitleDate.split(" ")[1].substring(0, 3);
	System.out.println(s2);
	String s3=TitleDate.split(" ")[2].split(",")[0];
	System.out.println(s3);
	String s4=TitleDate.split(" ")[3];
	System.out.println(s4);
	System.out.println("the Final Val is "+s1 +" "+s3 + " "+s2+" "+s4);		
	return 	 s1 +" "+s3 + " "+s2+" "+s4;
	}
	 
	 
	 
	 /*Method to Click Refresh button in the Charting page*/
	 public void ClickChartRefreshButton() {
		 
		 ChartRefreshButton.click();
		
	}
	 
	 /*Method to Validate the Chart displayed for KPI Chart tab */
	 public boolean KPIChatValidation() throws InterruptedException {
		 
		 
		     boolean isKPIGrapPlotted=false;
			int YseriesHeaderKPI1=ChartTitleKPI1.size();
			int YseriesHeaderKPI2=ChartTitleKPI1.size();
			int YseriesCircleCount=ChartYseriesCircleCounts.size();
			System.out.println("The Count of Titles of  the Selected KPI1 is :::"+YseriesHeaderKPI1);
			System.out.println("The Count of Titles of the Selected KPI2  is:::"+YseriesHeaderKPI2);
			System.out.println("The Count of the dot's mapped in the graph are:::"+YseriesCircleCount);
			Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"The Count of Titles of  the Selected KPI1 is:::"+YseriesHeaderKPI1+"</b>"+"<span>"+"<br/>");
			Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"The Count of Titles of  the Selected KPI2 is:::"+YseriesHeaderKPI2+"</b>"+"<span>"+"<br/>");
			Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"The Count of the dot's mapped in the graph are:::"+YseriesCircleCount+"</b>"+"<span>"+"<br/>");
			if((YseriesHeaderKPI1>0) && (YseriesHeaderKPI2>0) && (YseriesCircleCount>0))
			{
				isKPIGrapPlotted=true;
				System.out.println("The Graph is plotted with the selected KPI's both Y-Axis's are available number of Dot's/circle are:::: "+YseriesCircleCount);
				Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"The Graph is plotted with the selected KPI'sin both Y-Axis's are available number of Dot's/circle are:::: "+YseriesCircleCount+"</b>"+"<span>"+"<br/>");
			}
			else{
				isKPIGrapPlotted=false;
				System.out.println("The Graph is not getting plotted with the selected KPI's  & number of Dot's/Circle are available  . :::"+YseriesCircleCount);
				Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"The Graph is not getting plotted with the selected KPI's  & number of Dot's/Circle are available  . "+"</b>"+"<span>"+"<br/>");
			}
			
			return isKPIGrapPlotted;
	}
	 
 
	 /*Method to Validate the Chart displayed for NEChart */
	 public boolean GetNEChart() throws InterruptedException {
		 GetEprefKPIChartOPtionFilter();
		 
		 Thread.sleep(2000);
		 NEchartTab.click();
		 System.out.println("The Tabname is:::"+NEchartTab.getText());
		 Thread.sleep(2000);
		 NEchartNEdrArrrow.click();
		 int drSize=NEdrchrsize.size();
		 
		 for(int nedr=2;nedr<=2;nedr++)
		 {
			WebElement NEele =driver.findElement(By.xpath("(//div[@id='cboNE_NE1_DropDown']//ul//li//label)["+nedr+"]"));
		    System.out.println("The Selected Network Element is::"+NEele.getText());
			NEele.click();
		 }
		 GetEprefKPIChartOPtionFilter();
		 Thread.sleep(2000);
		 ClickChartRefreshButton();

		    boolean isNEGrapPlotted=false;
					int YseriesHeaderKPI=ChartTitleKPI1.size();
					int YseriesCircleCount=ChartYseriesCircleCounts.size();
					System.out.println("The Count of Titles of  the Selected KPI1 is :::"+YseriesHeaderKPI);
					System.out.println("The Count of the dot's mapped in the graph are:::"+YseriesCircleCount);
					Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"The Count of Titles of  the Selected KPI is:::"+YseriesHeaderKPI+"</b>"+"<span>"+"<br/>");
					Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"The Count of the dot's mapped in the graph are:::"+YseriesCircleCount+"</b>"+"<span>"+"<br/>");
					if((YseriesHeaderKPI>0) && (YseriesCircleCount>0))
					{
						isNEGrapPlotted=true;
						System.out.println("The Graph is plotted with the selected KPI in both  Y-Axis's & number of Dot's/circle are:::: "+YseriesCircleCount);
						Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"The Graph is plotted with the selected KPI'sin both Y-Axis's are available number of Dot's/circle are:::: "+YseriesCircleCount+"</b>"+"<span>"+"<br/>");
					}
					else{
						isNEGrapPlotted=false;
						System.out.println("The Graph is not getting plotted with the selected  & number of Dot's/Circle are available  . :::"+YseriesCircleCount);
						Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"The Graph is not getting plotted with the selected KPI's  & number of Dot's/Circle are available  . "+"</b>"+"<span>"+"<br/>");
					}
					Thread.sleep(3000);
					return isNEGrapPlotted;
	}
	 

	 /*Method to Validate the Chart displayed for Time Chart tab */
	 public boolean  GetTimeChart() throws InterruptedException {
         GetEprefKPIChartOPtionFilter();
		 Thread.sleep(2000);
		 TimechartTab.click();
		 System.out.println("The Tabname is:::"+TimechartTab.getText());
		 Thread.sleep(2000);
		 TimechartDtdrArrrow.click();
		 Thread.sleep(2000);
		 String TitleStFrDt=FormattTitleDate(SelectedStartDtTitle);
		 System.out.println("Fr Date is::::"+TitleStFrDt);
		 String TitleEdFrDt=FormattTitleDate(SelectedEndDtTitle);
		 System.out.println("Fr Date is::::"+TitleEdFrDt);
		 int Dtdrsize=DtDrinTimeChart.size();
		 System.out.println("The size of the NE Dropdown :::"+Dtdrsize);
		 
		 driver.findElement(By.xpath("//div[@id='cboTIME_Dates_DropDown']//ul/li//label[contains(text(),'"+TitleStFrDt+"')]")).click();
		 System.out.println("The Selected 	Starting Dates is:::"+driver.findElement(By.xpath("//div[@id='cboTIME_Dates_DropDown']//ul/li//label[contains(text(),'"+TitleStFrDt+"')]")).getText());
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[@id='cboTIME_Dates_DropDown']//ul/li//label[contains(text(),'"+TitleEdFrDt+"')]")).click();
		 System.out.println("The Selected 	Starting Dates is:::"+driver.findElement(By.xpath("//div[@id='cboTIME_Dates_DropDown']//ul/li//label[contains(text(),'"+TitleEdFrDt+"')]")).getText());
		 /*for(int dtdr=3;dtdr<=4;dtdr++){//div[@id='cboTIME_Dates_DropDown']//ul/li//label[contains(text(),'25 Mar 2019')]
			 driver.findElement(By.xpath("(//div[@id='cboTIME_Dates_DropDown']//ul/li//label)["+(Dtdrsize-dtdr)+"]")).click();
			 System.out.println("The Selected 	Starting Dates is:::"+driver.findElement(By.xpath("(//div[@id='cboTIME_Dates_DropDown']//ul/li//label)["+(Dtdrsize-dtdr)+"]")).getText());
		 } */
		 
		 GetEprefKPIChartOPtionFilter();
		 Thread.sleep(2000);
		 ClickChartRefreshButton();
		 Thread.sleep(2000);
		 
		 boolean isTimeGrapPlotted=false;
			int TimeYseriesHeaderKPI=ChartTitleKPI1.size();
			int TimeYseriesCircleCount=ChartYseriesCircleCounts.size();
			String crtattr;
			System.out.println("The Count of Titles of  the Selected KPI is :::"+TimeYseriesHeaderKPI);
			System.out.println("The Count of the dot's mapped in the graph are:::"+TimeYseriesCircleCount);
			crtattr=driver.findElement(By.xpath("//*[name()='svg']//*[name()='g']//*[name()='circle'][1]")).getAttribute("cx");
			System.out.println("The Attribute value selection::::"+crtattr);
			
			Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"The Count of Titles of  the Selected KPI is:::"+TimeYseriesHeaderKPI+"</b>"+"<span>"+"<br/>");
			Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"The Count of the dot's mapped in the graph are:::"+TimeYseriesCircleCount+"</b>"+"<span>"+"<br/>");
			if((TimeYseriesHeaderKPI>0) && (TimeYseriesCircleCount>0))
			{
				isTimeGrapPlotted=true;
				System.out.println("The Graph is plotted with the selected KPI in both  Y-Axis's & number of Dot's/circle are:::: "+TimeYseriesCircleCount);
				Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"The Graph is plotted with the selected KPI'sin both Y-Axis's are available number of Dot's/circle are:::: "+TimeYseriesCircleCount+"</b>"+"<span>"+"<br/>");
			}
			else{
				isTimeGrapPlotted=false;
				System.out.println("The Graph is not getting plotted with the selected  & number of Dot's/Circle are available  . :::"+TimeYseriesCircleCount);
				Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"The Graph is not getting plotted with the selected KPI's  & number of Dot's/Circle are available  . "+"</b>"+"<span>"+"<br/>");
			}
			Thread.sleep(3000);
			return isTimeGrapPlotted;
		 
		 
	}
	 
 
	 
    }
    
    



