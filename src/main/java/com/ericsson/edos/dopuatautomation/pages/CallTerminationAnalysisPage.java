package com.ericsson.edos.dopuatautomation.pages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	@FindBy (xpath = "//span[contains(text(),'Termination')]")
	WebElement CTADashboardHeaderText;
	
	//TC - Start and End Date
	
	/*Inspecting WebElement for Start Date Calendar Textbox*/	
	@FindBy (xpath = "//label[text()='Start']//parent::div//input[@class='calendar__datePickerInput___1fwAZ']")
	WebElement CTAStartDateCalTextbox;
	
	
	/*Inspecting WebElement for End Date Calendar Textbox*/	
	@FindBy (xpath = "//label[text()='End']//parent::div//input[@class='calendar__datePickerInput___1fwAZ']")
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

	@FindBy (xpath="(//span[@class='Select-arrow'])[2]")
	WebElement ArrowClick;

	@FindBy (xpath="//div[@class='Select-menu-outer']/div/div[1]")
	//@FindBy (xpath="//label[text()='Cells']/../div/div[@class='Select-menu-outer']/div/div[1]")
	WebElement FirstCellDropdown;

	@FindBy (xpath="//span[@class='Select-value-label']")
	WebElement cellvalue;

	@FindBy (xpath="//button[text()='Filter']")
	WebElement Filter;

	@FindBy (xpath="(//div[@accesskey='0-4'])[3]")
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

	@FindBy (xpath="(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[4]/div[@accesskey='0-3']")
	WebElement TerminationStatusValue;

	@FindBy (xpath="(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[4]/div[@accesskey='0-4']")
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
	
	
	/*Methods to Act on the WebDriver Webelements*/

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
		StrforDateTxb.append("//label[text()='"+XpathId+"']//parent::div//input[@class='calendar__datePickerInput___1fwAZ']");
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
	 CTAAct.sendKeys(Keys.ESCAPE).build().perform();
	// CTAAct.sendKeys(Keys.ESCAPE).build().perform();
	 Thread.sleep(1000);
	 for(String PHours:CTAEndHoursProcessed)
	 {
		 System.out.println("The EndHoursprocessd  are::::"+PHours);
		 
		
	 }
	 
	
}

	//TC-06 Cell Filter: Data is filtered

	public void ClickOnArrow() {
		ArrowClick.click();
	}

	public String GetDropdownValue() throws InterruptedException  {

		String firstCellName = FirstCellDropdown.getText();
		System.out.println(firstCellName);
		return firstCellName;
	}



	public void ClickFirstCellvalue() throws InterruptedException{
		FirstCellDropdown.click();
	}

	public String GetCellValue() throws InterruptedException  {

		String SelectedCellName = cellvalue.getText();
		System.out.println(SelectedCellName);
		return SelectedCellName;
	}

	public void ClickFiltier() throws InterruptedException{
		Filter.click();
	}

	public void ScrollDown() throws InterruptedException{

		CTAAct.moveToElement(CTADashboardHeaderText).click();

		for(int i=1;i<=27;i++){
			CTAAct.sendKeys(Keys.ARROW_DOWN);
			CTAAct.build().perform();
		}

	}

	public String ValidateOriginatingCell() throws InterruptedException{

		ScrollDown();
		Thread.sleep(2000);
		OriginatingCell.click();
		Thread.sleep(1000);
		String OCellValue = OriginatingCell.getText();
		return OCellValue;
	}

	//TC-07 Cell Filter: Search

	public void ScrollUp() throws InterruptedException{

		CTAAct.moveToElement(CallsDatagrid).click();

		for(int i=1;i<=27;i++){
			CTAAct.sendKeys(Keys.ARROW_UP);
			CTAAct.build().perform();
		}

	}

	public void ClickClearAllButton() throws InterruptedException{
		ClearAll.click();
	}

	public void SearchCellValue() {
		ClickSelectCell.click();
	}

	public void SpiltTheCellValue() throws InterruptedException {
		String splitValue = GetDropdownValue();
		String[] defaultCellValue = new String[1];
		//defaultCellValue[0] = splitValue.split("\\-")[2];
		defaultCellValue[0] = splitValue.substring(splitValue.length()-2);
		System.out.println("The partial text which we enter in the search box is "+defaultCellValue[0]);
		Reporter.log("The partial text which we enter in the search box is "+defaultCellValue[0]);
		Thread.sleep(2000);
		SelectCell.sendKeys(defaultCellValue[0]);
		Thread.sleep(2000);
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

		Thread.sleep(2000);
		TerminationStatusValue.click();
		Thread.sleep(1000);
		String TStatusValue = TerminationStatusValue.getText();
		return TStatusValue;
	}

	public String ValidateTerminationReason() throws InterruptedException{

		Thread.sleep(2000);
		TerminationReasonValue.click();
		Thread.sleep(1000);
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

	//TC - 06 Call Events	
	public String validateServingcell() throws InterruptedException{
		Thread.sleep(2000);
		ServingCellValue.click();

		Thread.sleep(2000);
		return ServingCellValue.getText();
	}

	public String validateEventname() throws InterruptedException{
		Thread.sleep(2000);
		Eventname.click();

		Thread.sleep(2000);
		return Eventname.getText();
	}

	public void ValidateBackgroundColor() throws InterruptedException{
		
		Eventname.click();

		Thread.sleep(2000);
		
		int eventsize = driver.findElements(By.xpath("(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[3]//div[contains(@style,'left: 550px')]")).size();
		System.out.println("The total number of event present is "+eventsize);

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
			
			if((ColorasHex.equalsIgnoreCase("#99ddee")) | (ColorasHex.equalsIgnoreCase("#fff599")) | (ColorasHex.equalsIgnoreCase("#d0e3a2"))) 
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
}




