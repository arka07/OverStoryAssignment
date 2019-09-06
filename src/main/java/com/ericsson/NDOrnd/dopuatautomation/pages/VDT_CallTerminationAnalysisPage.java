package com.ericsson.edos.dopuatautomation.pages;



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.ericsson.edos.dopuatautomation.base.TestBase;

public class CallTerminationAnalysisPage extends TestBase {
	
	
	

	/*Inspecting WebElement for CTA HeaderText*/	
	@FindBy (xpath = "//div//span[contains(text(),'Call Termination Analysis')]")
	WebElement CTADashboardHeaderText;
	
	//TC - Start and End Date
	
	/*Inspecting WebElement for Start Date Calendar Textbox*/	
	@FindBy (xpath = "(//label[text()='Start']//parent::div//input[contains(@class,'calendar__datePickerInput')])[1]")
	WebElement CTAStartDateCalTextbox;
	
	
	/*Inspecting WebElement for End Date Calendar Textbox*/	
	@FindBy (xpath = "(//label[text()='End']//parent::div//input[contains(@class,'calendar__datePickerInput')])[2]")
	WebElement CTAEndDateCalTextbox;
	
	/*Inspecting WebElement for StartWeek Date Calendar Textbox*/	
	@FindBy (xpath = "(//div[@class='react-datepicker__month']//div[@class='react-datepicker__week'])")
	List<WebElement> WeekRowSize;
	
	/*Inspecting WebElement for EndDate week sizeCalendar Textbox*/	
	@FindBy (xpath = "(//div[@class='react-datepicker__month']//div[@class='react-datepicker__week'])")
	List<WebElement> EndWeekRowSize;
	
	/*Inspecting WebElement for Processedhours*/	
	@FindBy (xpath = "(//div[@class='react-datepicker__time']//ul//li[not(contains(@class,'react-datepicker__time-list-item--disabled'))])")
	List<WebElement> ProcessedHoursSize;
	
	/*Inspecting WebElement for End Date Calendar Textbox*/	
	@FindBy (xpath = "//button[text()='Filter']")
	WebElement CTAFilterButton;
	
	
	/*Inspecting WebElement for End Date Calendar Textbox*/	
	@FindBy (xpath = "((//div[@id='terminationStatusPieChart']//*[name()='g']//*[name()='g'][contains(@class,'highcharts-data-label') or contains(@class,'highcharts-data-labels highcharts-series-0 highcharts-pie-series highcharts-tracker ')])//*[name()='text'])")
	List<WebElement> TerminationStatusPercentageOverallSize;
	
	
	/*Inspecting WebElement for TerminationPie Chart Legend */	
	@FindBy (xpath = "(//div[@id='terminationStatusPieChart']//*[name()='g']//*[name()='g'][contains(@class,'highcharts-legend')])")
	List<WebElement> TerminationStatusLegendsSize;
	
	/*Inspecting WebElement for Start Date PreviousMonth Button*/	
	@FindBy (xpath = "//div[@class='react-datepicker']//button[@class='react-datepicker__navigation react-datepicker__navigation--previous']")
	WebElement CTACalndaerPreviousMonthbutton;
	
	/*Inspecting WebElement for Start Date PreviousMonth Button*/	
	@FindBy (xpath = "//div[@class='react-datepicker']//button[@class='react-datepicker__navigation react-datepicker__navigation--next react-datepicker__navigation--next--with-time']")
	WebElement CTACalndaerNextMonthbutton;
	
	/*Inspecting WebElement for Start Date PreviousMonth Button*/	
	@FindBy (xpath = "//div[@id='termination-reason-container']//*[name()='svg']//*[name()='text'][contains(@class,'highcharts-title')]//*[name()='tspan']")
	WebElement CTATerminationReasonHeaderTitletext;

	//TC-06 Cell Filter: Data is filtered

	@FindBy (xpath="//div[text()='Select cell(s)']")
	WebElement ArrowClick;

	@FindBy (xpath="//label[text()='Cells']//parent::div//div[contains(@class,'placeholder')]")
    // (xpath="//div[@class='Select-menu-outer']/div/div[1]")
	//@FindBy (xpath="//label[text()='Cells']/../div/div[@class='Select-menu-outer']/div/div[1]")
	WebElement FirstCellDropdown;

	@FindBy (xpath="//label[text()='Cells']//parent::div//div[contains(@class,'placeholder')]")
	//span[@class='Select-value-label']
	WebElement cellvalue;

	@FindBy (xpath="//button[text()='Filter']")
	WebElement Filter;

	@FindBy (xpath="(//div[contains(@class,'left-side-grid')]//div)//div[@accesskey='0-4']")
	//(//div[@accesskey='0-4'])[2]
	
	WebElement OriginatingCell;


	//TC-07 Cell Filter: Search

	@FindBy (xpath="(//div[@class='Select-placeholder'])[2]")
	WebElement ClickSelectCell;

	@FindBy (xpath="(//div[@class='Select-input']/input)[2]")
	WebElement SelectCell;

	@FindBy (xpath="//div[text()='Calls Datagrid']")
	WebElement CallsDatagrid;

	@FindBy (xpath="//span[@class='Select-clear']")
	WebElement ClearAll;

	//TC-08 Cell Filter: Multiple selection

	@FindBy (xpath="//div[@class='Select-menu-outer']/div/div")
	WebElement CellDropdownlist;

	@FindBy (xpath="(//div[@class='Select-input']/input)[2]")
	WebElement SecondSearchCellValue;

	//@FindBy (xpath="//div[@title='Originating Cell']//span[@class='styles__tooltip___2kDzo']/input")
	@FindBy (xpath="//div[@title='Originating Cell']/div/div/div[2]/span/input")
	WebElement OriginatingCellSearch;


	//TC-06 Open call details from table

	@FindBy (xpath="//div[contains(@class,'dataGrid__bottom-right-side-grid')]//div[@accesskey='0-3']")
	WebElement TerminationStatusValue;

	@FindBy (xpath="//div[contains(@class,'dataGrid__bottom-right-side-grid')]//div[@accesskey='0-4']")
	WebElement TerminationReasonValue;

	@FindBy (xpath="(//i[@title='Open Call Details'])[1]")
	WebElement ClickOnMagnifyingLens;

	@FindBy (xpath="//span[contains(text(),'Call Details Analysis')]")
	WebElement CallDetailAnalysisText;

	//TC - 06 Call Events
	@FindBy (xpath="(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[3]//div[@accesskey='0-2']")
	WebElement ServingCellValue;

	@FindBy (xpath="(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[3]//div[@accesskey='0-5']")
	WebElement Eventname;


	/*WebElements for the TestCase IS---------1*/
	   
	
	   /*Xpath to collect the Count of the rows available in the LeftTable of the Calls Datagrid */
		@FindBy (xpath = "//div[contains(@class,'ReactVirtualized__Grid dataGrid')]//div[contains(@class,'ReactVirtualized__Grid__innerScrollContainer')]//div")
		List<WebElement> CTATLeftGridTable;
		
		/*Xpath to collect the Count of the rows available in the RightTable of the Calls Datagrid */
		@FindBy (xpath = "(//div[contains(@class,'ReactVirtualized__Grid dataGrid')])[2]//div[contains(@class,'ReactVirtualized__Grid__innerScrollContainer')]//div")
		List<WebElement> CTATRightGridTable;
		
		/*Xpath to collect the Selected Customer Project */
		@FindBy (xpath="//button[contains(@class,'dropdown__btn___LbWtm dropdown__clickable')]//span")
		WebElement DefaultCustomerProjectSelected;

		/*Xpath to collect the Selected Customer Project */
		@FindBy (xpath="//div[contains(@class,'dropdown__dropdown')]//div[contains(@class,'tree__tree')]/ul")
		List<WebElement> AvilablCustomers;
		
		/*Xpath to collect the Selected Customer Project */
		@FindBy (xpath="//div//span[contains(@class,'__username')]")
		WebElement UserLoggedIn;
		
		/*Xpath to Get the No Data to Display---Termination Status */
		@FindBy (xpath="//div[@id='terminationStatusPieChart']//*[name()='g'][contains(@class,'highcharts-label highcharts-no-data')]//*[name()='text']//*[name()='tspan']")
		WebElement NoDataDisplayMsg;
		
		/*Xpath to Get the No Data to Display---HeatmaporScatterchart toggle button */
		@FindBy (xpath="//div[contains(@class,'scatterChart__coverateAndQualityScatterChart')]//label[contains(@class,'styles__switch')]")
		WebElement HeatMaporScatterToggleBtn;
	
		
		
	
	/**
	 * 
	 * Xpath for the Test Case- 4 & 5-------Start----------------------- 
	 * 
	 */
		
		@FindBy (xpath = "//div[contains(@class,'is-clearable')]")
	       WebElement Clickcells;
	       
	       @FindBy (xpath = "//div[contains(@class,'is-open')]//div[@class=Select-menu-outer]//span//div")
	       WebElement Clickarrow;
	       
	       @FindBy (xpath ="(//*[name()='g'][contains(@class,'highcharts-series ')]//*[name()='path'])")
	       List<WebElement> piechartclickingsize;
	       
	       
	       @FindBy (xpath ="(//div[contains(@class,'bottom-left-side-grid')]//div)")
	       List<WebElement> getsectorfromtable;   

	      @FindBy (xpath="//div[contains(@class,'right-side-grid')]")
	       WebElement Selectingsecondtablecallsdatagrid;
	       
	       @FindBy (xpath="//div[contains(@class,'left-side-grid')]")
	       WebElement Selectingfirsttablecallsdatagrid;
	       
	       @FindBy (xpath="//div[@title='Latitude']//input")
	       WebElement LatitudeTextBox;
	       
	       @FindBy (xpath ="(//*[name()='svg']//*[name()='g']//*[name()='path'][contains(@class,'leaflet-interactive')])")
	       List<WebElement> callscountinmap;
	       
	       
	       @FindBy (xpath="//div[contains(@class,'leaflet-popup  leaflet-zoom-animated') ]//b[contains(text(),'Sector')]")
	       WebElement maptooltipsectortext;
	       
	       @FindBy (xpath="//a[contains(@class,'zoom-out')]")
	       WebElement zoomoutbutton;

 	      /*Xpath to Get the No Data to Display---ErrorNotificationCount */
		  @FindBy (xpath="(//div[contains(@class,'errorNotificationsPanel__error-notifications-panel')]//div[contains(@class,'notification__main-div')])")
		  List<WebElement> ErrorNotificationCount;
  
          @FindBy (xpath="(//span[contains(@class,'dataGrid__column-header-title')])")
	      List<WebElement> checkheader;
  
          @FindBy (xpath=" (//div[contains(@class,'eButton__linked')])[8]")
	       WebElement clickarrowheader;
		   
   /*
    
    Multi-tenancy 
    */
          
          @FindBy(xpath="//button[contains(@class,'dropdown__btn') or contains(@class,'dropdown__clickable')]")
          WebElement clickProjectDD;
          
          @FindBy(xpath="//div[contains(@class,'tree__tree')]/ul/li/span")
          List<WebElement> customername;
          
          String allcustomercta="(//div[contains(@class,'tree__tree')]/ul/li/span)" ;
          
          
		
    /**
     * 
     * Xpath for the Test Case- 4 & 5-------End----------------------- 
     */
	
	public  CallTerminationAnalysisPage() {
        
		
		PageFactory.initElements(driver , this);
	}

	
	Actions CTAAct = new Actions(driver);
	
	/*Global List Declarations*/
	List<String> CTAStartDateProcessed = new ArrayList<>();
	List<String> CTAListofClassNames = new ArrayList<>();
	List<String> CTAProcesseddHours = new ArrayList<>();
	List<String> CTAEndHoursProcessed = new ArrayList<>();
	List<String> CellValue = new ArrayList();
	
	/*----List Declarations for the Testcase id 1------*/
	List<String> CTALeftTable = new  ArrayList<>();
	List<String> listsectortext= new ArrayList<String>(); 
	List<String> listsectortexttable= new ArrayList<String>();
    List<String> Tableheaders = new ArrayList<>();
    
    List<String> Cname = new ArrayList<>();
    List<String> Pname = new ArrayList<>();
    
  

    
    public List<String> CTACustomername() throws InterruptedException {
    	  List<String> CustomerNames = new ArrayList<>();
    	  CustomerNames = VerifyCustomerName(clickProjectDD, customername, allcustomercta);
    	for(String Cval:CustomerNames) 
    	{
          System.out.println("The Customer values are:::: "+Cval);
    	}
    return CustomerNames;
  }

	public String getCTAtitle() {

		return	driver.getTitle();
	}

	public String VerifyCTADashbaordHeaderTetxt() throws InterruptedException {
		Thread.sleep(2000);
		return CTADashboardHeaderText.getText();

	}
	
	/*Generic Method for to Get Start Date and End Date Selection---------------M1()*/
	public String GetDateFromTextBox(String XpathId,String DateType) throws InterruptedException {
		StringBuilder StrforDateTxb = new StringBuilder();
		if(DateType.equals("Start")){
			StrforDateTxb.append("(//label[text()='"+XpathId+"']//parent::div//input[contains(@class,'datePickerInput')])[1]");
		}
		else{
			StrforDateTxb.append("(//label[text()='"+XpathId+"']//parent::div//input[contains(@class,'datePickerInput')])[2]");
		}
		System.out.println(StrforDateTxb);
		driver.findElement(By.xpath(StrforDateTxb.toString())).click();
		Thread.sleep(2000);
		if(DateType.equals("Start")){
		GetStartDateProcessed();
		Thread.sleep(5000);
		SetStartDateProcessedHours();
		}
		else if(DateType.equals("End")){
			System.out.println("in else");
			GetEndateProcessed();
			Thread.sleep(5000);
			SetEndDateProcessedHours();
		}
		Thread.sleep(2000);
		Thread.sleep(2000);
		String DtCaptured=driver.findElement(By.xpath(StrforDateTxb.toString())).getAttribute("value");
		return DtCaptured;
	}
	
	
	/*Method to Get the Processed Dates from the End Date Calendar---------------M2()*/
	public void GetStartDateProcessed() {
    	int wrsize=WeekRowSize.size();
    	System.out.println(wrsize);
		String Classnamesare;
		for(int wr=1;wr<=wrsize;wr++)
		{
			System.out.println("The wr val is::::" +wr);
			int wdsize=driver.findElements(By.xpath("(//div[@class='react-datepicker__month']//div[@class='react-datepicker__week'])["+wr+"]//div[not(contains(@class,'react-datepicker__day--disabled'))]")).size();
			System.out.println("wdsize" + wdsize);
			int tdsize=driver.findElements(By.xpath("((//div[@class='react-datepicker__month']//div[@class='react-datepicker__week'])["+wr+"]//div[not(contains(@class,'react-datepicker__day--disabled'))])")).size();
			System.out.println("tdsize" + tdsize );
			if(tdsize>0){
                    for(int wd=1;wd<=tdsize;wd++){
						WebElement Prdate=driver.findElement(By.xpath("(//div[@class='react-datepicker__month']//div[@class='react-datepicker__week'])["+wr+"]//div[not(contains(@class,'react-datepicker__day--disabled'))]["+wd+"]"));
					    String ProcessedDateis=Prdate.getText();
					    Classnamesare=Prdate.getAttribute("class");
					    CTAListofClassNames.add(Classnamesare);
					    System.out.println(CTAListofClassNames);
					    CTAStartDateProcessed.add(ProcessedDateis);
					    System.out.println(CTAStartDateProcessed);
					    
                    }
				}
			else{
				break;
			}
		}
				
	 for(String PrDtText:CTAStartDateProcessed)
	 {
		 System.out.println("The Processed Date are:::"+PrDtText);
	 }
	 
	 
	 for(String Cname:CTAListofClassNames)
	 {
		 System.out.println("The Processed Date classnames are:::"+Cname);
		 String cs = CTAListofClassNames.get(0);
		 StringBuilder strb = new StringBuilder();
		 strb.append("(//div[@class='react-datepicker__month']//div[@class='react-datepicker__week'])//div[contains(@class,'");
		 strb.append(cs);
		 strb.append("')]");
		 
		 WebElement ele= driver.findElement(By.xpath(strb.toString()));
		 ele.click();
		 break;
		 /*if(Cname.contains("react-datepicker__day--selected")){
			WebElement ele= driver.findElement(By.xpath("(//div[@class='react-datepicker__month']//div[@class='react-datepicker__week'])//div[contains(@class,'react-datepicker__day--selected')]"));
			System.out.println("The Date with classname:::react-datepicker__day--selected is:::::"+ele.getText());
			ele.click();
		 }		 */
	 }	
	}

/*Method to Get the Processed Dates from the End Date Calendar---------------M3()*/
 public void GetEndateProcessed() {
	 CTAStartDateProcessed.removeAll(CTAStartDateProcessed);
	 int wrsize=EndWeekRowSize.size();
	 String EndClassnamesare;
		for(int wr=1;wr<=wrsize;wr++)
		{
			int wdsize=driver.findElements(By.xpath("((//div[@class='react-datepicker__month']//div[@class='react-datepicker__week'])["+wr+"]//div[contains(@class,'react-datepicker__day--disabled')])")).size();
			int tdsize=driver.findElements(By.xpath("((//div[@class='react-datepicker__month']//div[@class='react-datepicker__week'])["+wr+"]//div[contains(@class,'react-datepicker__day--disabled')])")).size();
			if(tdsize>0){
                 for(int wd=1;wd<=wdsize;wd++){
						WebElement Prdate=driver.findElement(By.xpath("((//div[@class='react-datepicker__month']//div[@class='react-datepicker__week'])["+wr+"]//div[contains(@class,'react-datepicker__day--disabled')])["+wd+"]"));
					    String ProcessedDateis=Prdate.getText();
					    EndClassnamesare=Prdate.getAttribute("class");
					    CTAListofClassNames.add(EndClassnamesare);
					    CTAStartDateProcessed.add(ProcessedDateis);
                 }					
				}
			else{
				break;
			}
							
		}
		for(String PrDtText:CTAStartDateProcessed)
		 {
			 System.out.println("The EndDate  which are disabled are:::"+PrDtText);
			 String ce = CTAListofClassNames.get(0);
			 StringBuilder strb = new StringBuilder();
			 strb.append("(//div[@class='react-datepicker__month']//div[@class='react-datepicker__week'])//div[contains(@class,'");
			 strb.append(ce);
			 strb.append("')]");
			 
			 WebElement ele= driver.findElement(By.xpath(strb.toString()));
			 ele.click();
			 break;
		 }
		/*WebElement ele= driver.findElement(By.xpath("(//div[@class='react-datepicker__month']//div[@class='react-datepicker__week'])//div[contains(@class,'react-datepicker__day--selected')]"));
		String Elename=ele.getAttribute("class");
		if(Elename.contains("react-datepicker__day--selected")){
			
			System.out.println("The Date with classname:::react-datepicker__day--selected is:::::"+ele.getText());
			ele.click();
		 }*/

}   
 
 /*Method to Set the 1st Processed Hour in Start Date from the calendar---------------M4()*/
 public void SetStartDateProcessedHours() throws InterruptedException {
	 StringBuilder StrPHr = new StringBuilder();
	 int PHsize=ProcessedHoursSize.size();
	 for(int ph=1;ph<=PHsize;ph++)
	 {
		 WebElement PhEle=driver.findElement(By.xpath("(//div[@class='react-datepicker__time']//ul//li[not(contains(@class,'react-datepicker__time-list-item--disabled'))])["+ph+"]"));
		 CTAProcesseddHours.add(PhEle.getText());
	 }
	/* boolean isbutnEnabled= IsPreviousMonthButtonAvaileable("react-datepicker__navigation react-datepicker__navigation--previous");
		System.out.println("The btn Status is:::"+isbutnEnabled);*/
	 Thread.sleep(2000);
	 String FirstHourProcessedis=CTAProcesseddHours.get(0).trim();
	 System.out.println("The First Hour clicking is:::::"+FirstHourProcessedis);
	 Thread.sleep(2000);
	 StrPHr.append("//div[@class='react-datepicker__time']//ul//li[contains(text(),'");
	 StrPHr.append(FirstHourProcessedis);
	 StrPHr.append("')]");
	 System.out.println("Stringva:::"+StrPHr);
	 System.out.println(StrPHr);
	 Thread.sleep(2000);
   	 driver.findElement(By.xpath(StrPHr.toString())).click();
   	 CTAAct.sendKeys(Keys.ESCAPE).build().perform();
	 //CTAAct.sendKeys(Keys.ESCAPE).perform();
	 Thread.sleep(2000);
	 for(String PHours:CTAProcesseddHours)
	 {
		 System.out.println("The processd hours are::::"+PHours);

	 }
	 
	
}
 

 
 /*Method to Set the 1st Processed Hour in End  Date from the calendar---------------M5()*/
public void SetEndDateProcessedHours() throws InterruptedException {
	StringBuilder StrEnPHr = new StringBuilder();
	 int PHsize=ProcessedHoursSize.size();
	 for(int ph=1;ph<=PHsize;ph++)
	 {
		 WebElement PhEle=driver.findElement(By.xpath("(//div[@class='react-datepicker__time']//ul//li[not(contains(@class,'react-datepicker__time-list-item--disabled'))])["+ph+"]"));
		 CTAEndHoursProcessed.add(PhEle.getText());
	 }
	 
	
	 Thread.sleep(2000);
	 String FirstEndHourProcessedis=CTAEndHoursProcessed.get(CTAEndHoursProcessed.size()-3).trim();
	 System.out.println("The First Hour clicking is:::::"+FirstEndHourProcessedis);
	 Thread.sleep(2000);
	 StrEnPHr.append("//div[@class='react-datepicker__time']//ul//li[contains(text(),'");
	 StrEnPHr.append(FirstEndHourProcessedis);
	 StrEnPHr.append("')]");
	 Thread.sleep(2000);
	 System.out.println("End hr:::"+StrEnPHr);
	 driver.findElement(By.xpath(StrEnPHr.toString())).click();
	 Thread.sleep(2000);
	 CTADashboardHeaderText.click();
	// CTAAct.sendKeys(Keys.ESCAPE).build().perform();
	// CTAAct.sendKeys(Keys.ESCAPE).build().perform();
	 Thread.sleep(1000);
	 for(String PHours:CTAEndHoursProcessed)
	 {
		 System.out.println("The EndHoursprocessd  are::::"+PHours);
		 
		
	 }
	 
	
}

	//TC-06 Cell Filter: Data is filtered

	public void ClickOnArrow() throws InterruptedException  {
        Thread.sleep(5000);
		ArrowClick.click();
	
	}

	public String GetDropdownValue() throws InterruptedException  {
       /* CTAAct.sendKeys(Keys.ARROW_DOWN).perform();*/
        WebElement elecell = driver.findElement(By.xpath("(((//label[text()='Cells']//parent::div//div)[1]//div[contains(@class,'menu')]//div)//div//div)[1]"));
        System.out.println("Celllllllll:::::"+elecell.getText());
        System.out.println("Tagnames::::"+elecell.getTagName());
		String firstCellName = elecell.getText();
		System.out.println("intail Cell combobox value:::"+ firstCellName);
		return firstCellName;
	}



	public void ClickFirstCellvalue() throws InterruptedException{
        Thread.sleep(5000);
        CTAAct.sendKeys(Keys.ENTER).sendKeys(Keys.ESCAPE).build().perform();
        Thread.sleep(3000);
		//FirstCellDropdown.click();
	}

	public String GetCellValue() throws InterruptedException  {
        Thread.sleep(5000);
		String SelectedCellName = cellvalue.getText();
		System.out.println("Selected Cell is:::"+SelectedCellName);
		return SelectedCellName;
	}

	public void ClickFiltier() throws InterruptedException{
      Thread.sleep(5000);
		Filter.click();
	}

	public void ScrollDown() throws InterruptedException{
        Thread.sleep(5000);
		CTAAct.moveToElement(CTADashboardHeaderText).click();

		for(int i=1;i<=31;i++){
            Thread.sleep(5000);
			CTAAct.sendKeys(Keys.ARROW_DOWN);
			CTAAct.build().perform();
		}

	}

	public String ValidateOriginatingCell() throws InterruptedException{

		ScrollDown();
		Thread.sleep(7000);
		OriginatingCell.click();
		Thread.sleep(10000);
		String OCellValue = OriginatingCell.getText();
		return OCellValue;
	}

	//TC-07 Cell Filter: Search

	public void ScrollUp() throws InterruptedException{

		CTAAct.moveToElement(CallsDatagrid).click();

		for(int i=1;i<=27;i++){
            Thread.sleep(10000); 
			CTAAct.sendKeys(Keys.ARROW_UP);
			CTAAct.build().perform();
		}

	}

	public void ClickClearAllButton() throws InterruptedException{
		Thread.sleep(10000);
      ClearAll.click();
	}

	public void SearchCellValue() throws InterruptedException {
      Thread.sleep(10000);
		ClickSelectCell.click();
	}

	public void SpiltTheCellValue() throws InterruptedException {
		String splitValue = GetDropdownValue();
		String[] defaultCellValue = new String[1];
		//defaultCellValue[0] = splitValue.split("\\-")[2];
		defaultCellValue[0] = splitValue.substring(splitValue.length()-2);
		System.out.println("The partial text which we enter in the search box is "+defaultCellValue[0]);
		Reporter.log("The partial text which we enter in the search box is "+defaultCellValue[0]);
		Thread.sleep(6000);
		SelectCell.sendKeys(defaultCellValue[0]);
		Thread.sleep(6000);
		CTAAct.sendKeys(Keys.ENTER);
		CTAAct.build().perform();
	}


	//TC-08 Cell Filter: Multiple selection

	public int GetCellValues() throws InterruptedException {
		int rowCount=driver.findElements(By.xpath("//div[@class='Select-menu-outer']/div/div")).size();
		System.out.println("The total number of row: "+rowCount);

		return rowCount;
	}

	public void ValidateCellValue() {
		int rowCount=driver.findElements(By.xpath("//span[@id='react-select-5--value']/div/span[2]")).size();
		System.out.println("The total number of rows present: "+rowCount);
		for(int i=1;i<=rowCount;i++) {
			String CellValues = driver.findElement(By.xpath("(//span[@id='react-select-5--value']/div/span[2])["+i+"]")).getText();
			CellValue.add(CellValues);
		}
	}


	public void SearchSecondCellValue() {
		SecondSearchCellValue.click();
	}

	public int SearchCellCount() {
		int SearchrowCount=driver.findElements(By.xpath("//span[@id='react-select-5--value']/div/span[2]")).size();
		System.out.println("The total number of rows present in Search Cell box is: "+SearchrowCount);
		return SearchrowCount;
	}



	public void OriginatingCellClick() {
		OriginatingCellSearch.click();
	}

	public void SendCellValueToOriginatingCell(int val) throws InterruptedException {
		String S1= CellValue.get(val);
		System.out.println("The cell to be entered is "+S1);
		OriginatingCellSearch.sendKeys(S1);
		Thread.sleep(2000);
		CTAAct.sendKeys(Keys.ENTER);
		CTAAct.build().perform();
	}

	public void OriginatingCellClear() {
		OriginatingCellSearch.clear();
	}

	//TC-06 Open call details from table

	public String ValidateTerminationStatus() throws InterruptedException{

		Thread.sleep(5000);
		//TerminationStatusValue.click();
		
		String TStatusValue = TerminationStatusValue.getText();
		return TStatusValue;
	}

	public String ValidateTerminationReason() throws InterruptedException{

		Thread.sleep(5000);
	//	TerminationReasonValue.click();
		
		String TReasonValue = TerminationReasonValue.getText();
		return TReasonValue;
	}

	public void ClickMagnifyingLens() throws InterruptedException{

		Thread.sleep(2000);
		// Store the current window handle
		String winHandleBefore = driver.getWindowHandle();

		Thread.sleep(2000);
		// Perform the click operation that opens new window
		ClickOnMagnifyingLens.click();
		System.out.println("Clicked on the magnifying lens");

		Thread.sleep(2000);
		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
	}

	public String CallDetailText() throws InterruptedException{
		Thread.sleep(2000);
		CallDetailAnalysisText.click();

		Thread.sleep(2000);
		return CallDetailAnalysisText.getText();
	}
  
  public void ClickCallDetailText() throws InterruptedException{
    CallDetailAnalysisText.click();
  }
  
	//TC - 06 Call Events	
	public String validateServingcell() throws InterruptedException{
		Thread.sleep(2000);
		ServingCellValue.click();

		Thread.sleep(2000);
		return ServingCellValue.getText();
	}

	public String validateEventname() throws InterruptedException{
		Thread.sleep(4000);
		//Eventname.click();

		Thread.sleep(2000);
		return Eventname.getText();
	}

	public void ValidateBackgroundColor() throws InterruptedException{
		
		Eventname.click();

		Thread.sleep(2000);
		
		int eventsize = driver.findElements(By.xpath("(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[3]//div[contains(@style,'left: 550px')]")).size();
		System.out.println("The total number of event present is "+eventsize);
      
        Thread.sleep(2000);
        ClickCallDetailText();
          
		Thread.sleep(5000);
		for(int i=1;i<=eventsize;i++) {
			WebElement EventValue = driver.findElement(By.xpath("(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[3]//div[contains(@style,'left: 550px')]["+i+"]"));
			String EventvalueText = EventValue.getText();
			System.out.println(i + "  The event name is "+EventvalueText);
			

			Thread.sleep(2000);
			CTAAct.moveToElement(EventValue);
			
			
			Thread.sleep(2000);
			//get the value of color and store  in a variable
			String c = EventValue.getCssValue("background-color");
			
			Thread.sleep(2000);
			//convert the color from string type to hexa form
			String ColorasHex = Color.fromString(c).asHex();
			
			Thread.sleep(2000);
			System.out.println("Hexadecimal format : "+ColorasHex);
			System.out.println("The background color for the event "+EventvalueText+" is "+ColorasHex);
			
			Thread.sleep(2000);
			//#28a0ff - Dark Blue
			//#99ddee - Light Blue
			//#fff599 - Yellow
			//#d0e3a2 - Green
			
			if((ColorasHex.equalsIgnoreCase("#99ddee")) || (ColorasHex.equalsIgnoreCase("#fff599")) || (ColorasHex.equalsIgnoreCase("#d0e3a2"))) 
			{
				Thread.sleep(2000);
				System.out.println("The background color of the event is based on the event protocol");
			}
			else
			{
				Thread.sleep(2000);
				System.out.println("The background color of the event is not based on the event protocol");
				Assert.fail("The background color of the event is not based on the event protocol");

			}
			
		}
	}
	
	
	
	/*Methods to Act on the web elements captured-----------------------------------TC.No 1*/
/*	public void GetScroll(String KeyDownorUP,int Howmanytimes) {

		switch (KeyDownorUP) {
		case "DOWN":
			for(int ky=1;ky<=Howmanytimes;ky++)
			{
		
				CTAAct.sendKeys(Keys.DOWN);
			}
			CTAAct.build().perform();
			break;
		case "UP":
			for(int ky=1;ky<=Howmanytimes;ky++)
			{
		
				CTAAct.sendKeys(Keys.UP);
			}
			CTAAct.build().perform();
			break;
		default:
			break;
		}
	}*/

	public void GetScroll(String KeyDownorUP,int Howmanytimes) {
	       
	       switch (KeyDownorUP) {
	      case "DOWN":
	             CTADashboardHeaderText.click();
	             //actions.moveToElement(CTADashboardHeaderText).click();
	             for(int ky=1;ky<=Howmanytimes;ky++)
	             {
	               CTAAct.sendKeys(Keys.DOWN);
	             }
	             CTAAct.build().perform();
	             break;
	      case "UP":
	             CTADashboardHeaderText.click();
	             //actions.moveToElement(CallsDatagrid).click();
	             for(int ky=1;ky<=Howmanytimes;ky++)
	             {
	           CTAAct.sendKeys(Keys.UP);
	             }
	             break;
	       case "RIGHT":
	              Selectingsecondtablecallsdatagrid.click();
	             //actions.moveToElement(CallsDatagrid).click();
	             for(int ky=1;ky<=Howmanytimes;ky++)
	             {
	              CTAAct.sendKeys(Keys.RIGHT);
	             }
	               CTAAct.build().perform();
	             break;
	       case "LEFT":
	              Selectingsecondtablecallsdatagrid.click();
	             //actions.moveToElement(CallsDatagrid).click();
	             for(int ky=1;ky<=Howmanytimes;ky++)
	             {
	            CTAAct.sendKeys(Keys.LEFT);
	             }
	               CTAAct.build().perform();
	             break;
	      default:
	             break;
	      }
	}

public boolean GetFullTableData() throws InterruptedException {
	
	boolean isTableHasData=false;
	Thread.sleep(10000);
	CTADashboardHeaderText.click();
	GetScroll("DOWN",34);
	Thread.sleep(10000);
	int size=CTATLeftGridTable.size();
	System.out.println("The Table Size is::"+size);
	
	if(size>0){
		isTableHasData=true;
		for(int ctatblL=1;ctatblL<=size;ctatblL++){
			
			WebElement TblElmval=driver.findElement(By.xpath("(//div[contains(@class,'ReactVirtualized__Grid dataGrid')]//div[contains(@class,'ReactVirtualized__Grid__innerScrollContainer')]//div)["+ctatblL+"]"));
			String CellValis=TblElmval.getText();
			if(!CellValis.equals("")){
				CTALeftTable.add(CellValis);	
			}
		}
		
		for(String LeftTableList:CTALeftTable){
			System.out.println("The CallDataGrid LeftTable Value is:::"+LeftTableList);
		}
		
	}
	else{
	}
	
	
	
	
	return isTableHasData;
}



public boolean GetFullRightTableData() throws InterruptedException {
	
	boolean isRightTableHasData=false;
	/*CTADashboardHeaderText.click();
	GetScroll("DOWN",34);*/
	Thread.sleep(10000);
	int size=CTATRightGridTable.size();
	System.out.println("The Right Table Size is::"+size);
	
	if(size>0){
		isRightTableHasData=true;
		CTALeftTable.removeAll(CTALeftTable);
		for(int ctatblL=1;ctatblL<=size;ctatblL++){
			
			WebElement TblElmval=driver.findElement(By.xpath("(//div[contains(@class,'ReactVirtualized__Grid dataGrid')])[2]//div[contains(@class,'ReactVirtualized__Grid__innerScrollContainer')]//div["+ctatblL+"]"));
			String CellValis=TblElmval.getText();
			if(!CellValis.equals("")){
				CTALeftTable.add(CellValis);	
			}
		}
		
		for(String LeftTableList:CTALeftTable){
			System.out.println("The CallDataGrid RightTable Value is:::"+LeftTableList);
		}
		
	}
	else{
		System.out.println("No Data Available in the Right Table");
	}
	
	
	
	
	return isRightTableHasData;
}

public void GetProjectCount() {
	
	/*StringBuilder STRBforProject = new StringBuilder();
	STRBforProject.append("(//div[contains(@class,'dropdown__dropdown')]//div[contains(@class,'tree__tree')]/ul)");*/
	GetScroll("UP",34);
	int noofprojectsAvailable;
	String UserLoggedInIs=UserLoggedIn.getText();
	String DefaultcustomerIs=DefaultCustomerProjectSelected.getText();
	if(!DefaultcustomerIs.equals("")){
		DefaultcustomerIs=DefaultcustomerIs.split("::")[0].trim();
	}
	String DefaultProjectIs=DefaultCustomerProjectSelected.getText();
	if(!DefaultProjectIs.equals("")){
		DefaultProjectIs=DefaultProjectIs.split("::")[1].trim();
	}
	DefaultCustomerProjectSelected.click();
	noofprojectsAvailable=AvilablCustomers.size();
	
	System.out.println("The Number of the Customers Avilable are for logged in user::["+UserLoggedInIs+"] is:::"+noofprojectsAvailable);
	System.out.println("The Selected default Customer is::"+DefaultcustomerIs+"  & Selected Default Project under it is :::"+DefaultProjectIs);
}	
	
	public boolean GetTerminationNodataXpath(String IdType,String Type) {
		boolean isDataAvailable=false;
		boolean isElepresent=false;
		StringBuilder StrBforND = new StringBuilder();
		StrBforND.append("//div[@id='");
		StrBforND.append(IdType);
		StrBforND.append("']//*[name()='g'][contains(@class,'highcharts-label highcharts-no-data')]//*[name()='text']//*[name()='tspan']");
	try {
		/*WebDriverWait wait = new WebDriverWait(driver, 1000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(StrBforND.toString())));*/
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.MILLISECONDS);
		WebElement NdEle=driver.findElement(By.xpath(StrBforND.toString()));
		//isElepresent=NdEle.isDisplayed();
		
		isElepresent=NdEle.isDisplayed();
		int Ndsize=driver.findElements(By.xpath(StrBforND.toString())).size();
		//System.out.println("[In the DOM?????]is the element is avaialble in the DOM????:::"+isElepresent);
		//Reporter.log("<span style='color:#fffff0;background-color:#ff0038;font-size:14px;'>"+"<b>"+"[In the DOM?????]is the element is avaialble in the DOM????:::"+isElepresent+"</b>"+"<span>"+"<br/>");
		System.out.println("The Size of the component is:::"+Ndsize);
		System.out.println("The message Displayed is:::"+NdEle.getText());
		String Msg=NdEle.getText();
		if(Ndsize>0 && Msg.equals("No data to display"))
		{
			isDataAvailable=true;
			System.out.println("[No Data::"+Type+"]There is No Data Available for the " +Type);
			Reporter.log("<span style='color:#fffff0;background-color:#c90016;font-size:14px;'>"+"<b>"+"[No Data::"+Type+"]There is No Data Available for the " +Type+"</b>"+"<span>"+"<br/>");
		}
		else
		{
			System.out.println("[Data Available::"+Type+"]There is  Data available for the ::" +Type );
			Reporter.log("<span style='color:#fffff0;background-color:#18453b;font-size:14px;'>"+"<b>"+"[Data Available::"+Type+"]There is  Data available for the ::" +Type+"</b>"+"<span>"+"<br/>");
		}
	
		
	} catch (NoSuchElementException e) {
		System.out.println("[Exception::::::"+Type+"]]There is  Data available for the ::" +Type );
		System.out.println("[Exception::::::"+Type+"]]Exception type is::"+e.getClass().getSimpleName());
		Reporter.log("<span style='color:#fffff0;background-color:#228b22;font-size:14px;'>"+"<b>"+"[Exception::::::"+Type+"]]There is  Data available for the ::" +Type+"</b>"+"<span>"+"<br/>");
		Reporter.log("<span style='color:#fffff0;background-color:#228b22;font-size:14px;'>"+"<b>"+"[Exception::::::"+Type+"]]Exception type is::"+e.getClass().getSimpleName()+"</b>"+"<span>"+"<br/>");
		isDataAvailable=false;
	}
			
		return isDataAvailable;
		
	}

	public void GetHeatorScatterStatus() throws InterruptedException {
		GetScroll("DOWN",7);
		Thread.sleep(10000);
		HeatMaporScatterToggleBtn.click();
		
	}
	
public void GetScrolled(String ScrollType,int noOfTimes) throws InterruptedException {
	Thread.sleep(8000);
	GetScroll(ScrollType,noOfTimes);
	Thread.sleep(8000);
}	
	
	
/*Methods to act on Test Cases 4 & 5-----------Start---------------------*/	
  
  


  
public void getheaderstextfromtableloop() throws InterruptedException{
  Tableheaders.removeAll(Tableheaders);
  int headerssize = checkheader.size();
  System.out.println("Headers Size" + headerssize);
  for(int i=1;i<=headerssize;i++)
  {
   WebElement header=driver.findElement(By.xpath("(//span[contains(@class,'dataGrid__column-header-title')])["+i+"]"));
   Tableheaders.add(header.getText());
   }
  System.out.println(Tableheaders);
}


public void Gettextboxclick(String texttype) throws InterruptedException {
       
       StringBuilder textbox= new StringBuilder();
       textbox.append("//div[@title='");
       textbox.append(texttype);
       textbox.append("']//input");
       WebElement textbx=driver.findElement(By.xpath(textbox.toString()));
       System.out.println("Xpath"+texttype+"::"+ textbx);
       Thread.sleep(9000);
       //textbx.click();
      // Thread.sleep(9000);
       textbx.sendKeys(">=0");
       Thread.sleep(5000);
       CTAAct.sendKeys(Keys.ENTER).build().perform();
       System.out.println(texttype+" is Done");
       Thread.sleep(8000);
       
       
}

public void clickoncheckbox() throws InterruptedException {
       for(int i=1;i<=5;i++) {
       //driver.findElement(By.xpath(("((//div[contains(@class,'left-side-grid')]//div)//img)["+i+"]"))).click();
       WebElement callsclick =driver.findElement(By.xpath("((//div[contains(@class,'left-side-grid')]//div)//img//parent::span)["+i+"]"));
       callsclick.click();
       Thread.sleep(8000);
          }
       }

public int checkcountcallsinmap() throws InterruptedException 
{
       int totalsize = callscountinmap.size();
       Thread.sleep(4000);
       System.out.println("The total call selected on map are:"+ totalsize);
       return totalsize;
       
}



public void clickcallsfrommap() throws InterruptedException
{
zoomoutbutton.click();
Thread.sleep(10000);
zoomoutbutton.click();
Thread.sleep(10000);
//ArrayList<String> sectortext= new ArrayList<String>();   
int totalsize = callscountinmap.size();
for(int i=1;i<=totalsize;i++)
       {
              WebElement calls= driver.findElement(By.xpath("(//*[name()='svg']//*[name()='g']//*[name()='path'][contains(@class,'leaflet-interactive')])["+i+"]"));
              Thread.sleep(12000);
              //System.out.println("Xpath for calls "+ calls);
              calls.click();
              //Thread.sleep(8000);
              //System.out.println(maptooltipsectortext.getText().split(":")[1].trim());
              Thread.sleep(12000);
              String sectortext = maptooltipsectortext.getText().split(":")[1].trim();
              listsectortext.add(sectortext);
              Thread.sleep(4000);
              CTAAct.sendKeys(Keys.ESCAPE).build().perform();
              //System.out.println(listsectortext);
              Thread.sleep(10000);
         }
    System.out.println("List of Sectors from Map: "+ listsectortext);
}

public void getsectornametable() throws InterruptedException {
       
       for(int i=8;i<=40;i=i+7) {
              
              WebElement getsector=driver.findElement(By.xpath("(//div[contains(@class,'bottom-left-side-grid')]//div)["+i+"]"));
              Thread.sleep(5000);
              System.out.println(getsector.getText());
              listsectortexttable.add(getsector.getText());
              Thread.sleep(5000);
              }
       System.out.println("List of Sectors from Table: "+ listsectortexttable);
}

public boolean comparesectors() {
       boolean isEqual= listsectortext.equals(listsectortexttable);
       System.out.println(isEqual);
       return isEqual;
}


	/*
	 * public void getCustomerName() {
	 * 
	 * int Customercount= driver.findElements(By.xpath(
	 * "//div[contains(@class,'tree__tree')]/ul/li/span")).size();
	 * 
	 * for(int i=0;i<= Customercount;i++) {
	 * 
	 * WebElement CusName= driver.findElement(By.xpath(
	 * "(//div[contains(@class,'tree__tree')]/ul/li/span)["+i+"]")); String Cname=
	 * CusName.getText(); Customername.add(Cname);
	 * 
	 * 
	 * } }
	 */

/*Methods to act on Test Cases 4 & 5-----------End---------------------*/	


public boolean GetErrorAlertMeassages() {
	int TotalAlertsAvailable;
	boolean IsAlertNotificationAvailable=false;
	
	try {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		TotalAlertsAvailable=ErrorNotificationCount.size();
		System.out.println("The Total Number of Error Notifications Available Are:::"+TotalAlertsAvailable);
		IsAlertNotificationAvailable=true;
		
		for(int Erraler=1;Erraler<=TotalAlertsAvailable;Erraler++)
		{
			WebElement AlrEl= driver.findElement(By.xpath("(//div[contains(@class,'errorNotificationsPanel__error-notifications-panel')]//div[contains(@class,'notification__main-div')])["+Erraler+"]//div[contains(@class,'styles__title')]"));
			String ErrMsg=AlrEl.getText();
			System.out.println("Error Meassage is::::"+ErrMsg);
			AlrEl.click();
		}
		
		
	} catch (NoSuchElementException e) {
		IsAlertNotificationAvailable=false;
	}
	return IsAlertNotificationAvailable;
}

}




