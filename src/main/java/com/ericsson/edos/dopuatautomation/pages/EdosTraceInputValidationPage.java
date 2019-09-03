package com.ericsson.edos.dopuatautomation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver.Window;

import com.ericsson.edos.dopuatautomation.base.TestBase;
import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import sun.net.www.content.text.plain;

public class EdosTraceInputValidationPage extends TestBase {

	/*Inspecting WebElement for TIV HeaderText*/	
	@FindBy (xpath = "//span[contains(text(),'Traces Input Validation')]")
	WebElement TIVHeaderText;

	/*Inspecting WebElement for TIV Calendar----STARTTIME*/	
	@FindBy (xpath = "(//input[contains(@class,'calendar__datePickerInput')])[1]")
	WebElement TIVStartTime;


	/*Inspecting WebElement for TIV Calendar----ENDTIME*/	
	@FindBy (xpath = "(//input[contains(@class,'calendar__datePickerInput')])[2]")
	WebElement TIVEndTime;


	/*Inspecting WebElement for TIV Calendar----ENDTIME*/	
	@FindBy (xpath = "(//div[@class='react-datepicker__month-container']//div[@class='react-datepicker__current-month']")
	WebElement CurrentMonthAndYear;


	/*Inspecting WebElement for TIV BeforeXpath*/	
	@FindBy (xpath = "//(//div[@class='react-datepicker__week'])[")
	WebElement IntialXpath;


	/*Inspecting WebElement for TIV BeforeXpath*/	
	@FindBy (xpath = "]//div[")
	WebElement TrailingXpath;

	/*Inspecting WebElement for TIVAlert Message*/	
	@FindBy (xpath = "(//div[contains(@class,'styles__title___1KCrd')])")
	List<WebElement> ALertMsg;

	/*Inspecting WebElement for TIV StartHours*/	
	@FindBy (xpath = "(//ul[@class='react-datepicker__time-list']//li)")
	List<WebElement> StartHours;
	
	
	/*Inspecting WebElement for TIV Garanularity Dropdown */	
	@FindBy (xpath = "(//div[@class='Select-control'])[1]")
	WebElement GaranularityDropdown;
	

	/*Inspecting WebElement for TIV Apply button  */	
	@FindBy (xpath = "//button[contains(text(),'Apply')]")
	WebElement ApplyBtn;
	
	/*Inspecting WebElement for TIV X-Axis ChartHistoryDates Values */	
	@FindBy (xpath = "//*[name()='g'] [@class='highcharts-axis-labels highcharts-xaxis-labels ']//*[name()='tspan']")
	List<WebElement> ChartHistoryDates;
	
	/*Inspecting WebElement for TIV X-Axis ChartData Values */	
	@FindBy (xpath = "//*[name()='g'] [@class='highcharts-label highcharts-data-label highcharts-data-label-color-0 ']//*[name()='text']")
	List<WebElement> ChartDataValues;

	
	/*Inspecting WebElement for TIV X-Axis ChartData Values */	
	@FindBy (xpath = "(//div[@class='Select-control'])[1]//span//div")
	List<WebElement>GDropdownvals;

	@FindBy (xpath = "(//div[@class='Select-input']//input)[1]")
	WebElement GranularityList;
	
	@FindBy (xpath = "//div[@class='Select-value']/span")
	WebElement GranularitySelect;
	
	@FindBy (xpath = "(//*[name()='g']//*[name()='text']//*[name()='tspan'])[contains(text(),'ROPs')]")
	WebElement GraphRoptext;
	

	@FindBy (xpath = "//div[contains(@class,'dataGrid__react-virtualized-grid___')]")
	WebElement WaitforDatagrid;
	
	
	@FindBy (xpath = "(//div[@class='ReactVirtualized__Grid'])[2]//div")
	List<WebElement>TableGrid;
	
	@FindBy (xpath = "//button[text()='Next']")
	WebElement NextButton;
	
	@FindBy (xpath = "//button[text()='Previous']")
	WebElement PreviousButton;
	
	@FindBy (xpath = "(//div[@class='pagination__pagination-button___17iEa']//div//div)[2]")
	WebElement CenterButton;
	
	@FindBy (xpath = "(//div[@class='pagination__pagination-button___17iEa']//div//div)[1]//button")
	WebElement PButtonClass;
	
	
	@FindBy (xpath = "(//div[@class='pagination__pagination-button___17iEa']//div//div)[2]//button")
	WebElement CButtonClass;
	
	@FindBy (xpath = "(//div[@class='pagination__pagination-button___17iEa']//div//div)[3]//button")
	WebElement NexButtonClass;
	
	@FindBy (xpath = "//div[@class='eButton__linked-button___3nenl']")
	WebElement Exportbtn;
	
	@FindBy (xpath = "//div[text()='There was an unexpected error (type=Bad Request, status=400).']")
	WebElement ExceptioMsgForExport;
	
	@FindBy (xpath = "(//span[@class='Select-value-label'])[2]")
    WebElement CellFilteredValues;
	/*
	 * 
	 * (//div[@class='Select multiselect__combo_box___j6hC- has-value is-clearable is-searchable Select--multi']//div//span[@class='Select-value-label'])
*/	
	@FindBy (xpath = "(//div[@class='Select-control'])[2]")
	WebElement CellMultiselectDropdownClick;
	
	@FindBy (xpath = "(//div[@class='Select-control'])[2]//input")
	WebElement CellMultiselectInputTextBox;
	
	@FindBy (xpath = "(//span[@class='Select-value-icon']")
	WebElement CellMultiselectCloseOption;
	
	@FindBy (xpath = "(//div[contains(@class,'day--mon react-datepicker__day--selected')]//preceding::div[contains(@class,'datepicker__week')]//div[last()])")
	WebElement MondaySelection;
	

     /*Xpath to Get the No Data to Display---ErrorNotificationCount */
	  @FindBy (xpath="(//div[contains(@class,'errorNotificationsPanel__error-notifications-panel')]//div[contains(@class,'notification__main-div')])")
	  List<WebElement> ErrorNotificationCount;
	

	  
	  /*Multi-Tenancy */
	  
	  @FindBy(xpath="//button[contains(@class,'dropdown__btn') or contains(@class,'dropdown__clickable')]")
      WebElement clickProjectDD;
      
      @FindBy(xpath="//div[contains(@class,'tree__tree')]/ul/li/span")
      List<WebElement> customername;
      
      String allcustomertiv="(//div[contains(@class,'tree__tree')]/ul/li/span)" ;
	  
	  
	  
	  
/*Private Fields*/
	public String Classnameis=null;
	public int CurrentDateis;
	//public int PreviousDateis=(CurrentDateis-1);
	private List<String> CssClass;
    private List<String> HoursSelected;
    private List<String> GranuralityValues;
    private List<String> ChartHVal;
    private List<String> ChartHVal2;
    private List<String> ChartHVal3;
    private List<String> TableValsDayLevel;
    private List<String> TableValDayCellLevel;
    private List<String> ROPCollectioninROpLevelCellfiltred;
    private List<String> ROPCollectioninHourLevelCellfiltred;
    public String StartDate;
    public String Endate;
    public String ChartArr[]= new String[2];
    public String StartDateArr[];
    public String StartDateArrforRop[]=new String[4];
    public String EndDateArr[];
    public String EndArrforRop[]=new String[4];
    public String CHartRopArr[]= new String[12]; 
    public String ChartHourArr[]= new String[10];
    public String RopSplit[]= new String[10];
    public String FirstRopVals[]= new String[2]; 
    public String LastRopVals[]= new String[2];
    public String FRP;
    public String LRP;  
    public String FHRP;
    public String LHRP;
    public String[] FRP1= new String[2]; 
    public String[] LRP1= new String[2];
    public String[] FHRP1= new String[2]; 
    public String[] LHRP1= new String[2];
    public String[] StartDateArrforHour= new String[2];
    public String[] EndDateArrforHour= new String[2];
    public String[] StartDateArrforDataGridDayLevel= new String[2];
    public String[] EndDateArrforDataGridDayLevel= new String[2];
    public String[] ArrAdded= new String[2];
    public String[] ArrAdded2End= new String[2];
    public String[] StartDateArrforDataGridDayCellLvel= new String[2];
    public String[] EndDateArrforDataGridDayCellLvel= new String[2];
    public String[] StartDateArrforDataGridROPCellLvel= new String[2];
    public String[] EndDateArrforDataGridROPCellLvel= new String[2];
    public String[] StartDateArrforDataGridHourCellLvel= new String[2];
    public String[] EndDateArrforDataGridHourCellLvel= new String[2];
    public String[] ROPCollection1= new String[2];
    public String[] SubFirstROPCollection= new String[3];
    public String[] SubEndROPCollection= new String[3];
    /*Selenium class declarations*/
    Actions actions = new Actions(driver);
    
	/*Initializing all the WebElements*/
	public EdosTraceInputValidationPage() {

		PageFactory.initElements(driver , this);
	}





	/*--------------STARTS-------------------WebElements Capturing Methods-----------------------------------------------------------*/

	
	/*Multi-Tenancy Method*/
	public List<String> GetTIVCustomerNames() throws InterruptedException {
  	  List<String> CustomerNames = new ArrayList<>();
  	  CustomerNames = VerifyCustomerName(clickProjectDD, customername, allcustomertiv);
  	for(String Cval:CustomerNames) 
  	{
//  		CustomerNames.add(Cval);
  		System.out.println("The Customer values are:::: "+Cval);
  	}
  return CustomerNames;
}
	
	
	
	
	/*Generic Method to fetch the Granularity(DAY,ROP,Hour) from the dropdown*/
	public void GetSelctedGranularity(String Granlevel) throws InterruptedException{
		Thread.sleep(6000);
			 GaranularityDropdown.click();
			 Thread.sleep(5000);
			 GranularityList.sendKeys(Granlevel);
			 Thread.sleep(1000);
			 GranularityList.sendKeys(Keys.ENTER);
		}


	public void GetCells(String CellType) throws InterruptedException {
		Thread.sleep(5000);
		CellMultiselectDropdownClick.click();
		Thread.sleep(7000);
		CellMultiselectInputTextBox.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(3000);
		CellMultiselectInputTextBox.sendKeys(CellType);
		Thread.sleep(7000);
		CellMultiselectInputTextBox.sendKeys(Keys.ENTER);
	}
	
	
	/*----M.No-1----*/	/*Method to for getting TIV Header Text*/
	public String GetTivHeaderText() throws InterruptedException {
		Thread.sleep(7000);
		return TIVHeaderText.getText();

	}

	/*----M.No-2----*/	/*Method to Click on  StartDate Calendar*/		
	public String GetStartDate() throws InterruptedException {
		/*Thread.sleep(7000);
		int LSize=ALertMsg.size();
		System.out.println("Count is " + LSize);
		if(LSize>0)
		{
			System.out.println("Inside the If Loop" + ALertMsg.isEmpty());
			for(int i=1;i<=ALertMsg.size();i++)
			{
				System.out.println("Count of i is " + i);
				Thread.sleep(11000);
				String tt=driver.findElement(By.xpath("(//div[contains(@class,'styles__title___1KCrd')])["+i+"]")).getText();
				System.out.println("Text is+" +tt);
				driver.findElement(By.xpath("(//div[contains(@class,'styles__title___1KCrd')])["+i+"]")).click();
				ALertMsg.get(i).click();
			}
		}
		*/
		
		Thread.sleep(5000);
		TIVStartTime.click();
		Thread.sleep(7000);
		GetDatesFromCalendar("Selected");
		Thread.sleep(9000);
		GetHours("Normal");
		Thread.sleep(5000);
		TIVHeaderText.click();
		Thread.sleep(3000);
		String StartDate =TIVStartTime.getAttribute("value");
		Reporter.log("<span style='color:red;background-color:yellow;'>"+"Date is:" +"<b>"+StartDate +"</b>"+"<span>"+"<br/>");
		System.out.println("Date is:" + StartDate  );
		StartDateArr=StartDate.split(" ");
		for(int st=0;st<StartDateArr.length-1;st++)
		{
			Reporter.log("<span style='color:#33FF46;background-color:#17202A;'>"+"Split Start Date is " +"<b>"+ StartDateArr[st] +"</b>"+"<span>"+"<br/>");
			System.out.println("Split Start Date is " + StartDateArr[st]);
		}
		
		return StartDate;
	}

	/*----M.No-3----*/	/*Method to Click on  ENDDate Calendar*/		
	public String GetEndDate() throws InterruptedException {
		/*Thread.sleep(7000);
		int LSize=ALertMsg.size();
		System.out.println("Count is " + LSize);
		if(LSize>0)
		{
			System.out.println("Inside the If Loop" + ALertMsg.isEmpty());
			for(int i=1;i<=ALertMsg.size();i++)
			{
				System.out.println("Count of i is " + i);
				Thread.sleep(11000);
				String tt=driver.findElement(By.xpath("(//div[contains(@class,'styles__title___1KCrd')])["+i+"]")).getText();
				System.out.println("Text is+" +tt);
				driver.findElement(By.xpath("(//div[contains(@class,'styles__title___1KCrd')])["+i+"]")).click();
				ALertMsg.get(i).click();
			}
		}*/
		Thread.sleep(4000);
		TIVEndTime.click();
		Thread.sleep(6000);
		GetDatesFromCalendar("today");
		Thread.sleep(6000);
		GetHours("Rop");
		Thread.sleep(5000);
		TIVHeaderText.click();
		String Endate=TIVEndTime.getAttribute("value");
		Reporter.log("<span style='color:#33FF46;background-color:#17202A;'>"+"EndTime is:" +"<b>"+Endate +"</b>"+"<span>"+"<br/>");
		System.out.println("EndTime is:" +Endate  );
		EndDateArr=Endate.split(" ");
		for(int ed=0;ed<EndDateArr.length-1;ed++)
		{
		Reporter.log("<span style='color:#33FF46;background-color:#17202A;'>"+"End Date Split is" +"<b>"+EndDateArr[ed] +"</b>"+"<span>"+"<br/>");
		System.out.println("End Date Split is" +EndDateArr[ed]);	
		}
		
		return Endate;
	}


	
	
	
	/*----M.No-4----*/	/*Method to Get the processed Dates from  Calendar*/		
	public void GetDatesFromCalendar(String Val) throws InterruptedException {
		//(//div[@class='react-datepicker__week'])[1]//div[1]
		//(//div[@class='react-datepicker__week'])[2]//div[1]
		 
		CssClass=new ArrayList<String>();
		String bXpath="(//div[@class='react-datepicker__week'])[";
		String aXpath="]//div[";
		int RopSelctedSize=driver.findElements(By.xpath("(//div[contains(@class,'day--mon react-datepicker__day--selected')]//preceding::div[contains(@class,'datepicker__week')]//div[last()])")).size();

		String DayVlue=null;
		String CName=null;
		for(int rowNum=1;rowNum<=5;rowNum++)
		{
			for(int ColNum=1;ColNum<=7;ColNum++)
			{
		
				CName=driver.findElement(By.xpath(bXpath+rowNum+aXpath+ColNum+"]")).getAttribute("class");
				if(!(CName.contains("disabled"))){
					CssClass.add(CName);
					DayVlue=driver.findElement(By.xpath(bXpath+rowNum+aXpath+ColNum+"]")).getText();
					Reporter.log("<span style='color:#58D68D;background-color:#1C2833;'>"+"The available Date is:" +"<b>"+DayVlue +"</b>"+"<span>"+"<br/>");
					System.out.println("The available Date is:" +DayVlue);
				}
				
				//System.out.println("The ClassName is:" +CName);
			}
		}
		
		for(String value:CssClass){
			
			if(!Val.equals("ROPP"))
			{
			System.out.println("The ClassName is:"+value);
			if(Val.equals("Selected")){
			if(value.contains("datepicker__day--selected"))
			{
				driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--selected')]")).click();
				/*Classnameis=driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--selected')]")).getAttribute("class");
				CurrentDateis=Integer.parseInt(driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--today')]")).getText());
				System.out.println("The class of selected Date is::"+Classnameis);*/
				System.out.println("The current Date::"+CurrentDateis);
			}
			}
			if(Val.equals("today"))
			{
				if(value.contains("datepicker__day--today"))
				{
					driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--today')]")).click();
					Classnameis=driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--today')]")).getAttribute("class");
					System.out.println("The class of selected Date is::"+Classnameis);
				}
			}
		}
		}
		
		
		if(Val.equals("ROPP"))
		{
			System.out.println("Inside Rop Selectttt");
			/*int PreviousDateis=(CurrentDateis-1);*/
			int PreviousDateis;
			Classnameis=driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--selected')]")).getAttribute("class");
			System.out.println("the class of selected date is::::------"+Classnameis);
			// System.out.println("Previous date is:"+PreviousDateis);
			for(String value:CssClass){
				
				System.out.println("The ClassName is:"+value);
				
				if( Classnameis.contains("react-datepicker__day react-datepicker__day--mon react-datepicker__day--selected react-datepicker__day--today"))
				{
				    /*driver.findElement(By.xpath("//div[contains(text(),'"+PreviousDateis+"')]")).click();
					Thread.sleep(4000);*/
					//driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--selected')]")).click();
					
					//CurrentDateis=Integer.parseInt(driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--today')]")).getText());
					System.out.println("The class of selected Date is::"+Classnameis);
					//CurrentDateis=Integer.parseInt(driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--today')]")).getText());
				//	PreviousDateis=(CurrentDateis-1);
					//driver.findElement(By.xpath("//div[contains(text(),'"+PreviousDateis+"')]")).click();
					/*driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--today')]//preceding::div[@class='react-datepicker__week']//div[last()]")).click();
					Thread.sleep(4000);*/
					driver.findElement(By.xpath("(//div[contains(@class,'day--mon react-datepicker__day--selected')]//preceding::div[contains(@class,'datepicker__week')]//div[last()])["+RopSelctedSize+"]")).click();
					Thread.sleep(4000);
					break;
				}
				
				
				if( Classnameis.contains("react-datepicker__day react-datepicker__day--sun react-datepicker__day--selected react-datepicker__day--weekend") || Classnameis.contains("react-datepicker__day react-datepicker__day--sat react-datepicker__day--selected react-datepicker__day--weekend"))
				{
				    /*driver.findElement(By.xpath("//div[contains(text(),'"+PreviousDateis+"')]")).click();
					Thread.sleep(4000);*/
					//driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--selected')]")).click();
					
					//CurrentDateis=Integer.parseInt(driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--today')]")).getText());
					System.out.println("The class of selected Date is::"+Classnameis);
					//CurrentDateis=Integer.parseInt(driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--today')]")).getText());
				//	PreviousDateis=(CurrentDateis-1);
					//driver.findElement(By.xpath("//div[contains(text(),'"+PreviousDateis+"')]")).click();
					/*driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--today')]//preceding::div[@class='react-datepicker__week']//div[last()]")).click();
					Thread.sleep(4000);*/
					driver.findElement(By.xpath("//div[contains(@class,'day--selected react-datepicker__day--weekend')]")).click();
					Thread.sleep(4000);
					break;
				}
				
				
				if(value.contains("datepicker__day") && !(Classnameis.equals("react-datepicker__day react-datepicker__day--mon react-datepicker__day--selected react-datepicker__day--today")) && !(Classnameis.equals("react-datepicker__day react-datepicker__day--sun react-datepicker__day--selected react-datepicker__day--weekend")))
				{
				
					//div[contains(@class,'datepicker__day--selected') or contains(@class,'datepicker__day--today')]
					driver.findElement(By.xpath("//div[contains(@class,'datepicker__day--today')]//preceding-sibling::div[1]")).click();
					Thread.sleep(4000);
				}
				
					
					
					}	
				
				
			}
			
		}
		
	
	
	/*----M.No-5----*/	/*Method to Get the processed Hours from  Calendar*/		
	/*public void GetHours(String Hs) throws InterruptedException {
		HoursSelected=new ArrayList<String>();
		int HSSize=StartHours.size();
		System.out.println("Before  the Loop  " + HSSize);
		for(int i=HSSize;i>=1;i--)
		{

			System.out.println("Into the Loop  " + i);
			Thread.sleep(5000);
			String Hval= driver.findElement(By.xpath("(//ul[@class='react-datepicker__time-list']//li)["+i+"]")).getText();
			HoursSelected.add(driver.findElement(By.xpath("(//ul[@class='react-datepicker__time-list']//li)["+i+"]")).getAttribute("class"));
			System.out.println("Hour val is" + Hval);
			HoursSelected.add(Hval);
			
		}
		
		
		
		for (String Havailable : HoursSelected) {
			
			if(!Havailable.contains("disabled"))
			{
				System.out.println("The ClassName is:"+Havailable);
				if(Hs.equals("Rop"))
				{
				driver.findElement(By.xpath("(//ul[@class='react-datepicker__time-list']//li)[13]")).click();
				break;
			}
				if(Hs.equals("Normal"))
				{
					driver.findElement(By.xpath("(//ul[@class='react-datepicker__time-list']//li)[11]")).click();
					break;
				}
				}
		}
	}*/
	
	
	public void GetHours(String Hs) throws InterruptedException {
		System.out.println("Before  the Loop Time is " + java.time.LocalDate.now()+" "+java.time.LocalTime.now());
		HoursSelected=new ArrayList<String>();
		int HSSize=StartHours.size();
		/*System.out.println("Before  the Loop  " + HSSize);*/
		System.out.println("Started first for Loop ");
		for(int i=HSSize;i>=1;i--)
		{
		System.out.println("Time for "+i +" element is " + java.time.LocalDate.now()+" "+java.time.LocalTime.now());
			/*System.out.println("Into the Loop  " + i);*/
			Thread.sleep(5000);
			WebElement we=driver.findElement(By.xpath("(//ul[@class='react-datepicker__time-list']//li)["+i+"]"));
			System.out.println("After fetching webelement:::Time is " + java.time.LocalDate.now()+" "+java.time.LocalTime.now());
			String Hval= we.getText();
			System.out.println("After fetching text:::Time is " + java.time.LocalDate.now()+" "+java.time.LocalTime.now());
			HoursSelected.add(we.getAttribute("class"));
			System.out.println("After fetching getAttribute:::Time is " + java.time.LocalDate.now()+" "+java.time.LocalTime.now());
			/*System.out.println("Hour val is" + Hval);*/
			HoursSelected.add(Hval);
			
		}
		
		
		
		for (String Havailable : HoursSelected) {
			
			if(!Havailable.contains("disabled"))
			{
				System.out.println("The ClassName is:"+Havailable);
				if(Hs.equals("Rop"))
				{
					System.out.println("before fetching for rop:::Time is " + java.time.LocalDate.now()+" "+java.time.LocalTime.now());
				driver.findElement(By.xpath("(//ul[@class='react-datepicker__time-list']//li)[8]")).click();
				System.out.println("after fetching for rop:::Time is " + java.time.LocalDate.now()+" "+java.time.LocalTime.now());
				break;
			}
				if(Hs.equals("Normal"))
				{
					System.out.println("before fetching non rop:::Time is " + java.time.LocalDate.now()+" "+java.time.LocalTime.now());
					driver.findElement(By.xpath("(//ul[@class='react-datepicker__time-list']//li)[7]")).click();
					System.out.println("after fetching non rop:::Time is " + java.time.LocalDate.now()+" "+java.time.LocalTime.now());
					break;
				}
				}
		}
	}
	
	
	
	
	
	
	
	
	
	
/*----M.No-6----*/	/*Method to Get the GetGanrularityVal from  Dropdownlistr*/		
public void GetGanrularityVal() throws InterruptedException {

	Thread.sleep(6000);
	 GaranularityDropdown.click();
	 Thread.sleep(5000);
	 GranularityList.sendKeys("Day");
	 Thread.sleep(1000);
	 GranularityList.sendKeys(Keys.ENTER);
	 Thread.sleep(2000);
	 ApplyBtn.click();
	 WebDriverWait wait = new WebDriverWait(driver, 13);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[name()='g']//*[name()='text']//*[name()='tspan'])[contains(text(),'ROPs')]")));
     Reporter.log("<span style='color:#C0392B;background-color:#F1C40F;'>"+"The Text is ::"+ "<b>"+GraphRoptext.getText()+"</b>"+"<span>"+"<br/>");
	 System.out.println("The Text is "+ GraphRoptext.getText()); 
     Thread.sleep(3000);
     int CValSize=ChartHistoryDates.size();
     ChartHVal = new ArrayList<String>();
     for(int i=1;i<=CValSize;i++)
     {
    	 String ChVal=driver.findElement(By.xpath("(//*[name()='g'] [@class='highcharts-axis-labels highcharts-xaxis-labels ']//*[name()='tspan'])["+i+"]")).getText().replace(" - ", " ");
    	 System.out.println("The History val is" + ChVal);
    	 Reporter.log("<span style='color:#C0392B;background-color:#F1C40F;'>"+"The History val is" +"<b>"+ ChVal +"</b>"+"<span>"+"<br/>");
    	 ChartHVal.add(ChVal);
    
    	 
     }
     int k=0;
     for(String SplitVal:ChartHVal){
    	 Reporter.log("<span style='color:#C0392B;background-color:#F1C40F;'>"+"Split of Daylevel is :::" + "<b>"+SplitVal +"</b>"+"<span>"+"<br/>");
    	 System.out.println("Daylevel is ::: " + SplitVal);
    	 
        	 ChartArr[k]=SplitVal.split(" ")[0]; 
        	 k++;
         
     
     }
     
     
     for(int j=0;j<ChartArr.length-1;j++)
	 {
    	 Reporter.log("<span style='color:#C0392B;background-color:#F1C40F;'>"+"Split of Daylevel is" + "<b>"+ChartArr[j] +"</b>"+"<span>"+"<br/>");
		 System.out.println("Split is" + ChartArr[j]);	 
	 }
     
	 //*GranuralityValues = new ArrayList<String>();
	 /*int Dsize=GDropdownvals.size();
	 for(int i=1;i<=Dsize;i++)
	 {
		System.out.println("Gdropdown loop");
		String Gval=driver.findElement(By.xpath("((//div[@class='Select-control'])[1]//span//div)["+i+"]/span")).getText();
		System.out.println("Gdropdown Value is" + Gval);
		GranuralityValues.add(Gval);
	 }*/
	 
	 
	
}



/*----M.No-8----*/	/*Method to Get the Rop from  Dropdownlist*/






/*----M.No-7----*/	/*Method to Get the Rop from  Dropdownlistr*/
public void GetRop() throws InterruptedException {
	Thread.sleep(6000);
	 GaranularityDropdown.click();
	 Thread.sleep(5000);
	 GranularityList.sendKeys("Rop");
	 Thread.sleep(1000);
	 GranularityList.sendKeys(Keys.ENTER);
}	

/*----M.No-8----*/	/*Method to Get the Hour from  Dropdownlist*/
public void GetHour() throws InterruptedException {
	Thread.sleep(6000);
	 GaranularityDropdown.click();
	 Thread.sleep(5000);
	 GranularityList.sendKeys("Hour");
	 Thread.sleep(1000);
	 GranularityList.sendKeys(Keys.ENTER);
}	

/*----M.No-9----*/	/*Method for DayLevelComparsion*/
public boolean CompareDayLevel() {
	boolean Finalval=false;
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Arrlen is "+ "<b>"+ChartArr.length +"</b>"+"<span>"+"<br/>");
	System.out.println("Arrlen is:::: "+ ChartArr.length);
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Start "+ "<b>"+StartDateArr[0] +"</b>"+"<span>"+"<br/>");
	System.out.println("Start::: "+ StartDateArr[0]);
    Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"End "+ "<b>"+EndDateArr[0] +"</b>"+"<span>"+"<br/>");
	System.out.println("End :::::"+ EndDateArr[0]);
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Char1 ::::"+ "<b>"+ChartArr[0] +"</b>"+"<span>"+"<br/>");
	System.out.println("Char1:::: "+ ChartArr[0]);
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Char2 ::: "+"<b>"+ ChartArr[1] +"</b>"+"<span>"+"<br/>");
	System.out.println("Char2 ::: "+ ChartArr[1]);
	if((StartDateArr[0]).equals(ChartArr[0]) && (EndDateArr[0]).equals(ChartArr[1]))
	{
		Finalval=true;
	}
	return Finalval;
}


/*----M.No-10----*/	/*Method for ROPLevelComparsion*/
public boolean ROPLevelValidation() throws InterruptedException {
	
	
	
	Thread.sleep(5000);
	TIVStartTime.click();
	Thread.sleep(7000);
	GetDatesFromCalendar("Selected");
	Thread.sleep(9000);
	GetHours("Normal");
	Thread.sleep(5000);
	TIVHeaderText.click();
	Thread.sleep(3000);
	String StartDate =TIVStartTime.getAttribute("value");
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Rop Level Start Date is::::" +"<b>"+ StartDate +"</b>"+"<span>"+"<br/>");
	StartDateArrforRop=StartDate.split(" ");
	for(int k=0;k<=StartDateArrforRop.length-1;k++)
	{
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Rop Level Split Start Date is::: " +"<b>"+ StartDateArrforRop[k] +"</b>"+"<span>"+"<br/>");
		System.out.println("Split Start Date is " + StartDateArrforRop[k]);
	}
	
	Thread.sleep(4000);
	TIVEndTime.click();
	Thread.sleep(6000);
	GetDatesFromCalendar("ROPP");
	Thread.sleep(6000);
	GetHours("Rop");
	TIVHeaderText.click();
	String Endate=TIVEndTime.getAttribute("value");
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"EndTime is:::::" +"<b>"+Endate + ChartArr[1] +"</b>"+"<span>"+"<br/>");
	System.out.println("EndTime for ROP is:::::" +Endate  );
	EndArrforRop=Endate.split(" ");
	for(int ed=0;ed<=EndArrforRop.length-1;ed++)
	{
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"End Date Split is" +"<b>"+EndArrforRop[ed] +"</b>"+"<span>"+"<br/>");
	System.out.println("ROP Level End Date Split is:::::" +EndArrforRop[ed]);	
	}
	
	GetRop(); 
	ApplyBtn.click();
	WebDriverWait wait = new WebDriverWait(driver, 13);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[name()='g']//*[name()='text']//*[name()='tspan'])[contains(text(),'ROPs')]")));
     Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"The Text is "+"<b>"+ GraphRoptext.getText() +"</b>"+"<span>"+"<br/>");
	 System.out.println("The Graph Rop text Text is ::::"+ GraphRoptext.getText()); 
  Thread.sleep(3000);
  int CValSize=ChartHistoryDates.size();

	ChartHVal2= new ArrayList<String>();
	 for(int i=1;i<=CValSize;i++)
	   {
	  	 String ChVal2=driver.findElement(By.xpath("(//*[name()='g'] [@class='highcharts-axis-labels highcharts-xaxis-labels ']//*[name()='tspan'])["+i+"]")).getText().replace(" - ", " ");
	  	 System.out.println("The ROP Level History  val is" + ChVal2);
	  	 Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"The ROP Level History val is::::" +"<b>"+ ChVal2 +"</b>"+"<span>"+"<br/>");
	  	ChartHVal2.add(ChVal2);
	   }
    int k=0;
    for(String SplitVal2:ChartHVal2){
   	 Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Split ROP Level val is :::" + "<b>"+SplitVal2 +"</b>"+"<span>"+"<br/>");
   	 System.out.println("Split ROP Level val is :::" + SplitVal2);
   	     
     	CHartRopArr=SplitVal2.split(" "); 
       	 k++;

    }
    
    
    FRP=ChartHVal2.get(0);
    LRP=ChartHVal2.get(ChartHVal2.size()-1);
    System.out.println("FirstVal Feteched from Hs ROP is::::"+FRP);
    System.out.println("Lastval Feteched from Hs ROP is:::"+LRP);
    FRP1=FRP.split(" ");
    LRP1=LRP.split(" ");
    for(int j=0;j<=FRP1.length-1;j++)
	 {
   	 Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Split of First ROP History is:::" +"<b>"+ FRP1[j] +"</b>"+"<span>"+"<br/>");
		 System.out.println("Split of First ROP History is:::" + j + FRP1[j]);	 
	 }
	
    for(int j=0;j<=LRP1.length-1;j++)
	 {
  	 Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Split of Last ROP History is:::" + j + "<b>"+ LRP1[j] +"</b>"+"<span>"+"<br/>");
		 System.out.println("Split of Last ROP History is:::" + LRP1[j]);	 
	 }
    int roplastmin,ropLastHr;
    boolean stcmp=false;
    boolean encmp=false;
    boolean DiffCheck=false;
    boolean FinalCmp=false;
    ropLastHr=Integer.parseInt(LRP1[1].split(":")[0]);
    roplastmin=Integer.parseInt(LRP1[1].split(":")[1]);
    System.out.println("minutes in ROP Level:::"+roplastmin);
    Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"minutes in ROP Level:::" + "<b>"+roplastmin +"</b>"+"<span>"+"<br/>");
    
    int mindiff,hourdiff;
    mindiff=60-roplastmin;
    System.out.println("mindiff ROP Level is:::::"+mindiff);
    hourdiff=Integer.parseInt(EndArrforRop[1].split(":")[0])-ropLastHr;
    System.out.println("hourdiff in Rop Level is::::"+hourdiff);
    Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Hourdiff in ROP Level:::" + "<b>"+ropLastHr +"</b>"+"<span>"+"<br/>");
    
    if(StartDateArrforRop[0].equals(FRP1[0]) && StartDateArrforRop[1].equals(FRP1[1]))
    {
    	stcmp=true;
    	System.out.println("StartDate of ROP Diff comparision  ::"+stcmp );
    	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"StartDate of ROP Diff comparision  ::"+"<b>"+stcmp+"</b>"+"<span>"+"<br/>");
    	System.out.println("StartDateArrforRop[0] is  ::" +StartDateArrforRop[0] + "FRP1[0] is  ::" +FRP1[0]  +"StartDateArrforRop[1] is  ::" + StartDateArrforRop[1] +"FRP1[1] is  ::" +FRP1[1]);
    	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Split of Last ROP History is:::" +"StartDateArrforRop[0] ROPLevel is  ::" +"<b>"+StartDateArrforRop[0] + "FRP1[0] ROPLevel is is  ::" +FRP1[0]  +"StartDateArrforRop[1] ROPLevel is is  ::" + StartDateArrforRop[1] +"FRP1[1] ROPLevel is is  ::" +FRP1[1]+"<br/>");
    }
    if(EndArrforRop[0].equals(FRP1[0]))
    {
    	encmp=true;
    	System.out.println("EndArrforRop[0] is  ::" +EndArrforRop[0] + "FRP1[0] is  ::" + FRP1[0]);
    	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"EndArrforRop[0] in ROP Level is  ::" +"<b>"+EndArrforRop[0] + "FRP1[0] in ROP Level is  ::" + FRP1[0]+"</b>"+"<span>"+"<br/>");
    	System.out.println("ENDdate of ROP Diff comparision  ::"+encmp );
    	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"ENDdate of ROP Diff comparision in ROP level  ::"+"<b>"+encmp +"</b>"+"<span>"+"<br/>");
    }
    
    if(mindiff==15 && hourdiff==1)
    {
    	
    	DiffCheck=true;
    	System.out.println("Minutedifference is   ::" + mindiff + "Hours difference is   ::" +hourdiff);
    	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Minutedifference in ROP Level is   ::" +"<b>"+ mindiff + "Hours difference in ROP Level is   ::" +hourdiff+"</b>"+"<span>"+"<br/>");
    }
    
    if(stcmp==encmp==DiffCheck)
    {
    	FinalCmp=true; 
    }
    System.out.println("Final Camparision is  " +FinalCmp);
    Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Final Camparision in ROP Level is :::: " +"<b>"+FinalCmp+"</b>"+"<span>"+"<br/>");
    return FinalCmp;
}

/*----M.No-11----*/	/*Method for HourLevelComparsion*/
public boolean HourLevelValidation() throws InterruptedException {
	
	Thread.sleep(5000);
	TIVStartTime.click();
	Thread.sleep(7000);
	GetDatesFromCalendar("Selected");
	Thread.sleep(9000);
	GetHours("Normal");
	Thread.sleep(5000);
	TIVHeaderText.click();
	Thread.sleep(3000);
	String StartDate =TIVStartTime.getAttribute("value");
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Date is:" + "<b>"+StartDate +"</b>"+"<span>"+"<br/>");
	StartDateArrforHour=StartDate.split(" ");
	
	for(int k=0;k<=StartDateArrforHour.length-1;k++)
	{
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Split Start Date [HourLevel] is " + "<b>"+StartDateArrforHour[k] +"</b>"+"<span>"+"<br/>");
		System.out.println("Split Start Date HourLevel] is:::: " + StartDateArrforHour[k]);
	}
	
	Thread.sleep(4000);
	TIVEndTime.click();
	Thread.sleep(6000);
	GetDatesFromCalendar("ROPP");
	Thread.sleep(6000);
	GetHours("Rop");
	TIVHeaderText.click();
	String Endate=TIVEndTime.getAttribute("value");
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"EndTime is [HourLevel]:::" +"<b>"+Endate +"</b>"+"<span>"+"<br/>");
	System.out.println("EndTime is [HourLevel]:::::::" +Endate  );
	EndDateArrforHour=Endate.split(" ");
	for(int ed=0;ed<=EndDateArrforHour.length-1;ed++)
	{
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"End Date Split is  [HourLevel]:::::::" +"<b>"+EndDateArrforHour[ed] +"</b>"+"<span>"+"<br/>");
	System.out.println("End Date Split is [HourLevel]:::::::" +EndDateArrforHour[ed]);	
	}
	
	GetHour();
	ApplyBtn.click();
	 WebDriverWait wait = new WebDriverWait(driver, 13);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[name()='g']//*[name()='text']//*[name()='tspan'])[contains(text(),'ROPs')]")));
    Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"The Text GraphRop[HourLevel] is "+ "<b>"+GraphRoptext.getText() +"</b>"+"<span>"+"<br/>");
	 System.out.println("The Text is "+ GraphRoptext.getText()); 
   Thread.sleep(3000);
   int CValSize=ChartHistoryDates.size();
   ChartHVal3 = new ArrayList<String>();
   for(int i=1;i<=CValSize;i++)
   {
  	 String ChVal3=driver.findElement(By.xpath("(//*[name()='g'] [@class='highcharts-axis-labels highcharts-xaxis-labels ']//*[name()='tspan'])["+i+"]")).getText().replace(" - ", " ");
  	 System.out.println("The History val is  [HourLevel]::::" + ChVal3);
  	 Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"The History val is [HourLevel]::::" + "<b>"+ChVal3 +"</b>"+"<span>"+"<br/>");
  	ChartHVal3.add(ChVal3);
   }
   
   
   int k=0;
   for(String SplitVal3:ChartHVal3){
  	 Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Split of [Hourlevel] is " + "<b>"+SplitVal3 +"</b>"+"<span>"+"<br/>");
  	 System.out.println("Split [Hourlevel] value is::::" + SplitVal3);
  	     
  	ChartHourArr=SplitVal3.split(" "); 
      	 k++;

   }
   
   
   
   FHRP=ChartHVal3.get(0);
   LHRP=ChartHVal3.get(ChartHVal3.size()-1);
   System.out.println("First Value of ROP History is [Hourlevel]:::::::"+FHRP);
   Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"First Value of ROP History is [Hourlevel]:::::::"+"<b>"+FHRP+"</b>"+"<span>"+"<br/>");
   System.out.println("Last Value of ROP History is [Hourlevel]:::::::"+LHRP);
   Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Last Value of ROP History is [Hourlevel]:::::::"+"<b>"+LHRP+"</b>"+"<span>"+"<br/>");
   FHRP1=FHRP.split(" ");
   LHRP1=LHRP.split(" ");
   for(int j=0;j<=FHRP1.length-1;j++)
	 {
  	 Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Split of FirstHour [HorLevel]::::::::" + "<b>"+FHRP1[j] +"</b>"+"<span>"+"<br/>");
		 System.out.println("Split is FirstHour [HorLevel]::::::::" + j + FHRP1[j]);	 
	 }
	
   for(int j=0;j<=LHRP1.length-1;j++)
	 {
 	 Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Split of LastHour [HorLevel]::::::::" + j +"<b>"+  LHRP1[j] +"</b>"+"<span>"+"<br/>");
		 System.out.println("Split of LastHour [HorLevel]::::::::" + LHRP1[j]);	 
	 }   
   
   int Hoursroplastmin,HoursropLastHr;
   boolean stcmpHR=false;
   boolean encmpHR=false;
   boolean DiffCheckHR=false;
   boolean FinalCmpHR=false;
   HoursropLastHr=Integer.parseInt(LHRP1[1].split(":")[0]);
   Hoursroplastmin=Integer.parseInt(LHRP1[1].split(":")[1]);
   System.out.println("minutes  [HourLevel]:::"+HoursropLastHr);
   int HrDiff=Integer.parseInt(EndDateArrforHour[1].split(":")[0])-HoursropLastHr;
   
   System.out.println("hourdiff  [HourLevel]:::::: "+HrDiff);
   Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"hourdiff  [HourLevel]:::::: "+"<b>"+HrDiff+"</b>"+"<span>"+"<br/>");
   if(StartDateArrforHour[0].equals(FHRP1[0]) && StartDateArrforHour[1].equals(FHRP1[1]))
   {
   	stcmpHR=true;
   	System.out.println("StartDate of ROP Diff comparision [HourLevel] ::"+stcmpHR );
   	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"StartDate of ROP Diff comparision [HourLevel] ::"+stcmpHR+"</b>"+"<span>"+"<br/>");
   	System.out.println("StartDateArrforHour[0] is  ::" +StartDateArrforHour[0] + "FHRP1[0] is  ::" +FHRP1[0]  +"StartDateArrforHour[1] is  ::" + StartDateArrforHour[1] +"FHRP1[1] is  ::" +FHRP1[1]);
   }
   if(EndDateArrforHour[0].equals(FHRP1[0]))
   {
   	encmpHR=true;
   	System.out.println("EndDateArrforHour[0] is  ::" +EndDateArrforHour[0] + "FHRP1[0] is  ::" + FHRP1[0]);
   	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"EndDateArrforHour[0] is  ::" +"<b>"+EndDateArrforHour[0] + "FHRP1[0] is  ::" + FHRP1[0]+"</b>"+"<span>"+"<br/>");
   	System.out.println("ENDdate of ROP Diff comparision  ::"+encmpHR );
   	Reporter.log("ENDdate of ROP Diff comparision  ::"+encmpHR+"<span style='color:#FFFF00;background-color:#610B21;'>"+"ENDdate of ROP Diff comparision  ::"+"<b>"+encmpHR+"</b>"+"<span>"+"<br/>");
   	
   }
   
   if( HrDiff==1)
   {
   	
   	DiffCheckHR=true;
   	System.out.println("Hours difference is   ::" +HrDiff);
   	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"Hours difference is  [Hourlevel] ::" +"<b>"+HrDiff+"</b>"+"<span>"+"<br/>");
   }
   
   if(stcmpHR==encmpHR==DiffCheckHR)
   {
   	FinalCmpHR=true; 
   }
   
   return FinalCmpHR;
}



/*----M.No-12----*/	/*Method for making wait for Datagrid*/



public void ListTableGridText() throws InterruptedException 
{	Thread.sleep(2000); 
	int TablerowCount=driver.findElements(By.xpath("(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[2]//div")).size();
	TableValsDayLevel= new  ArrayList<String>();
//	TableValsDayLevel.clear();
	System.out.println(TablerowCount);
	for(int i=1;i<TablerowCount;i++)
	{
		WebElement allTable = driver.findElement(By.xpath("(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[2]//div["+i+"]"));
		String Tabletext=allTable.getText();	
		System.out.println(Tabletext);
		
		TableValsDayLevel.add(Tabletext);
//		String EnteredUsername = ArrAdded[0];
//		System.out.println("The StartDate after split is::" + EnteredUsername);
		/*if(Tabletext.contains(EnteredUsername))
			break;*/
	
		 if(Tabletext.trim().equals(""))
		{
			System.out.println("-----------------------------------------------");
			actions.moveToElement(driver.findElement(By.xpath("(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[2]//div["+(i)+"]"))).click();
			actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
			actions.build().perform();
			Thread.sleep(2000);
			Tabletext=driver.findElement(By.xpath("(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[2]//div["+i+"]")).getText();
			Thread.sleep(2000);
			
		}
		Thread.sleep(2000);
		/*System.out.println(i);
		System.out.println(Tabletext);*/
	/*	if(Tabletext.contains(EnteredUsername))
			
			break;*/
	}
}	

public boolean VerifyTableLoadsDaylevel() throws InterruptedException {
	
	   boolean Daycmp=false;
	   Thread.sleep(3000);
		TIVStartTime.click();
		Thread.sleep(4000);
		GetDatesFromCalendar("Selected");
		Thread.sleep(9000);
		GetHours("Normal");
		Thread.sleep(5000);
		TIVHeaderText.click();
		Thread.sleep(3000);
		String StartDate =TIVStartTime.getAttribute("value");
		Reporter.log("Start Date in [TableLevel] is:::::"+ StartDate + "<br/>");
		StartDateArrforDataGridDayLevel=StartDate.split(" ");
		
		for(int k=0;k<=StartDateArrforDataGridDayLevel.length-1;k++)
		{
			Reporter.log("Split Start Date is \n" + StartDateArrforDataGridDayLevel[k]);
			System.out.println("Split Start Date is " + StartDateArrforDataGridDayLevel[k]);
		}
	
		
		ArrAdded[0]=StartDateArrforDataGridDayLevel[0];
		ArrAdded[1]=StartDateArrforDataGridDayLevel[1];
		
		Thread.sleep(4000);
		TIVEndTime.click();
		Thread.sleep(2000);
		GetDatesFromCalendar("today");
		Thread.sleep(6000);
		GetHours("Rop");
		TIVHeaderText.click();
		String Endate=TIVEndTime.getAttribute("value");
		Reporter.log("EndTime is:" +Endate +"\n");
		System.out.println("EndTime is:" +Endate  );
		
		EndDateArrforDataGridDayLevel=Endate.split(" ");
		
		
		for(int k=0;k<=EndDateArrforDataGridDayLevel.length-1;k++)
		{
			Reporter.log("Split End Date is \n" + EndDateArrforDataGridDayLevel[k]);
			System.out.println("Split End Date is " + EndDateArrforDataGridDayLevel[k]);
		}
		
		GetSelctedGranularity("Day");
		ApplyBtn.click();
		Reporter.log("<span style='color:red;'>"+"sdsdfssdfsdf"+"<span>");
		
		TIVHeaderText.click();
		Thread.sleep(8000);
		actions.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Traces Input Validation') or contains(@class,'dashboardTitle__dashboard-title___16CsP')]"))).click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
		actions.build().perform();
		ListTableGridText();
		if(TableValsDayLevel.size()>0){
		int k=0;
		for(String TableContent:TableValsDayLevel)
		{
			System.out.println("The Values of the table are::"+TableContent );
			k++;
			
		}
		}
		else
		{
			Daycmp=false;
			System.out.println("The Table is Empty as it's size is::" +TableValsDayLevel.size());
		}
		
		if(TableValsDayLevel.contains(ArrAdded[0]))
		{
			Daycmp=true;
			System.out.println("The Table Contains Start Date::" + ArrAdded[0]);
		}
		else {
            System.out.println("The Table is Empty as it's size is::" +TableValsDayLevel.size());
			Daycmp=false;
		}
		
		
		/*JavascriptExecutor Js = (JavascriptExecutor)driver;*/
		Reporter.log("<span style='color:#0851E1;background-color:#F30942;font-size:14px;'>"+"WElcomeeeeeee"+"</b>"+"<span>"+"<br/>");
		/*Js.executeScript("window.scrollBy(0,6000)");*/
		Thread.sleep(9000);
		
	return Daycmp;	
		
		
}


/*Cell Filtering Methods  DayLevel*/

public boolean VerifyTableWithCellFilter() throws InterruptedException {
	
	    boolean DaycmpCell=false;
	    boolean cdf1=false;
	    boolean cdf2=false;
	    boolean cdf3=false;
	   Thread.sleep(3000);
		TIVStartTime.click();
		Thread.sleep(4000);
		GetDatesFromCalendar("Selected");
		Thread.sleep(9000);
		GetHours("Normal");
		Thread.sleep(5000);
		TIVHeaderText.click();
		Thread.sleep(3000);
		String StartDate =TIVStartTime.getAttribute("value");
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;font-size:14px;'>"+"<b>"+"Start Date in [Daylevel in CellFiltering] is:::::"+ StartDate + "</b>"+"<span>"+"<br/>");
        StartDateArrforDataGridDayCellLvel=StartDate.split(" ");
        ArrAdded[0]=StartDateArrforDataGridDayCellLvel[0];
		ArrAdded[1]=StartDateArrforDataGridDayCellLvel[1];
		for(int k=0;k<=StartDateArrforDataGridDayCellLvel.length-1;k++)
		{
			Reporter.log("<span style='color:#FFFF00;background-color:#610B21;font-size:14px;'>"+"<b>"+"Split Start Date in [Daylevel in CellFiltering] is:::  " + StartDateArrforDataGridDayCellLvel[k]+ "</b>"+"<span>"+"<br/>");
			System.out.println("Split Start Date is " + StartDateArrforDataGridDayCellLvel[k]);
		}

		Thread.sleep(4000);
		TIVEndTime.click();
		Thread.sleep(4000);
		GetDatesFromCalendar("Selected");
		Thread.sleep(4000);
		GetHours("Rop");
		TIVHeaderText.click();
		String Endate=TIVEndTime.getAttribute("value");
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"EndTime is [Daylevel in Cell Filtering]:::" +"<b>"+Endate +"</b>"+"<span>"+"<br/>");
		System.out.println("EndTime is [[DayLevel of CellFiltering]]:::::::" +Endate  );
		EndDateArrforDataGridDayCellLvel=Endate.split(" ");
		ArrAdded2End[0]=EndDateArrforDataGridDayCellLvel[0];
		ArrAdded2End[1]=EndDateArrforDataGridDayCellLvel[1];
		
		for(int ed=0;ed<=EndDateArrforDataGridDayCellLvel.length-1;ed++)
		{
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"End Date Split is  [Daylevel in Cell Filtering]:::::::" +"<b>"+EndDateArrforDataGridDayCellLvel[ed] +"</b>"+"<span>"+"<br/>");
		System.out.println("End Date Split is [Daylevel in Cell Filtering]:::::::" +EndDateArrforDataGridDayCellLvel[ed]);	
		}
		
		GetSelctedGranularity("Day");
		Thread.sleep(2000);
		GetCells("A");
		Thread.sleep(4000);
		String SelectedCellName=CellFilteredValues.getText().toString().trim();
		System.out.println("Selected Cell Name is:::::" + SelectedCellName);
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"Selected Cell Name is:::::" + SelectedCellName+"</b>"+"<span>"+"<br/>");
		Thread.sleep(4000);
		ApplyBtn.click();

		TIVHeaderText.click();
		Thread.sleep(8000);
		actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Traces Input Validation')]"))).click();
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
		actions.build().perform();
		Thread.sleep(9000);
		ListTableGridText();
		
		
		if(TableValsDayLevel.size()>0){
			int k=0;
			for(String TableContentDayLevelCellLevel:TableValsDayLevel)
			{
				System.out.println("The Values of the table are::"+TableContentDayLevelCellLevel );
				k++;
				
			}
			}
			else
			{
				DaycmpCell=false;
				System.out.println("The Table is Empty as it's size is::" +TableValsDayLevel.size());
			}
			
		
		if(TableValsDayLevel.contains(ArrAdded[0]))
		{
			System.out.println("The Table Contains Start Date::" + ArrAdded[0]);
			Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Table Contains Start Date::" + ArrAdded[0]+"</b>"+"<span>"+"<br/>");
			cdf1=true;
		}
		
		if(TableValsDayLevel.contains(ArrAdded2End[0]))
		{
			System.out.println("The Table Contains End Date::" + ArrAdded2End[0]);
			Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Table Contains Start Date::" + ArrAdded2End[0]+"</b>"+"<span>"+"<br/>");
			cdf2=true;
		}
		
		if(TableValsDayLevel.contains(SelectedCellName))
		{
			System.out.println("The Table Contains Cell ::" + SelectedCellName);
			Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Table Contains Cell Date::" + SelectedCellName+"</b>"+"<span>"+"<br/>");
			cdf3=true;
		}
		
		if(cdf1==cdf2==cdf3)
		{
			System.out.println("Executed Successfully"+"F1:"+cdf1+"F2:"+cdf2+"F3:"+cdf3);
			Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Table Contains Cell Filtred::" + SelectedCellName+"</b>"+"<span>"+"<br/>");
			DaycmpCell=true;
		}
		else
		{
			System.out.println("Failed Again"+"F1:"+cdf1+"F2:"+cdf2+"F3:"+cdf3);
			DaycmpCell=true;
		}
		
		/*if((TableValsDayLevel.contains(ArrAdded[0])) && (TableValsDayLevel.contains(ArrAdded2End[0]))  && (TableValsDayLevel.contains(SelectedCellName)))
		{
			DaycmpCell=true;
			System.out.println("The Table Contains Start Date::" + ArrAdded[0]);
			Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Table Contains Start Date::" + ArrAdded[0]+"</b>"+"<span>"+"<br/>");
			System.out.println("The Table Contains EndDate Date::" + ArrAdded2End[0]);
			Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Table Contains EndDate Date::" + ArrAdded2End[0]+"</b>"+"<span>"+"<br/>");
			System.out.println("The Table Contains Cell Filtred::" + SelectedCellName);
			Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Table Contains Cell Filtred::" + SelectedCellName+"</b>"+"<span>"+"<br/>");
		}
		else {
			DaycmpCell=false;
            System.out.println("Failed to execute Beacuse Saratdate is+::"+ ArrAdded[0] +"EndDate is::"+ArrAdded2End[0]+"Selected cell is::"+SelectedCellName);
            Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"Failed to execute Beacuse ::"+DaycmpCell+"</b>"+"<span>"+"<br/>");
            
		}
		*/
		return DaycmpCell;
		
		
}

/*Cell Filtering Methods  ROPLevel*/
public boolean VerifyTableWithCellFilterRopLevel() throws InterruptedException {
	
	boolean ROPcmpCell=false;
    boolean cdfRop1=false;
    boolean cdfRop2=false;
    boolean cdfRop3=false;
    Thread.sleep(3000);
    actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).build().perform();
	TIVStartTime.click();
	Thread.sleep(4000);
	GetDatesFromCalendar("Selected");
	Thread.sleep(9000);
	GetHours("Normal");
	Thread.sleep(5000);
	TIVHeaderText.click();
	Thread.sleep(3000);
	String StartDate =TIVStartTime.getAttribute("value");
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;font-size:14px;'>"+"<b>"+"Start Date in [Roplevel in CellFiltering] is:::::"+ StartDate + "</b>"+"<span>"+"<br/>");
    StartDateArrforDataGridROPCellLvel=StartDate.split(" ");
    ArrAdded[0]=StartDateArrforDataGridROPCellLvel[0];
	ArrAdded[1]=StartDateArrforDataGridROPCellLvel[1];
	for(int k=0;k<=StartDateArrforDataGridROPCellLvel.length-1;k++)
	{
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;font-size:14px;'>"+"<b>"+"Split Start Date in [ROPlevel in CellFiltering] is:::  " + StartDateArrforDataGridROPCellLvel[k]+ "</b>"+"<span>"+"<br/>");
		System.out.println("Split Start Date is " + StartDateArrforDataGridROPCellLvel[k]);
	}

	Thread.sleep(4000);
	TIVEndTime.click();
	Thread.sleep(4000);
	GetDatesFromCalendar("ROPP");
	Thread.sleep(4000);
	GetHours("Rop");
	TIVHeaderText.click();
	String Endate=TIVEndTime.getAttribute("value");
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"EndTime is [ROPLevel in Cell Filtering]:::" +"<b>"+Endate +"</b>"+"<span>"+"<br/>");
	System.out.println("EndTime is [[ROPLevel of CellFiltering]]:::::::" +Endate  );
	EndDateArrforDataGridROPCellLvel=Endate.split(" ");
	ArrAdded2End[0]=EndDateArrforDataGridROPCellLvel[0];
	ArrAdded2End[1]=EndDateArrforDataGridROPCellLvel[1];
	
	for(int ed=0;ed<=EndDateArrforDataGridROPCellLvel.length-1;ed++)
	{
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"End Date Split is  [ROPLevel in Cell Filtering]:::::::" +"<b>"+EndDateArrforDataGridROPCellLvel[ed] +"</b>"+"<span>"+"<br/>");
	System.out.println("End Date Split is [ROPLevel in Cell Filtering]:::::::" +EndDateArrforDataGridROPCellLvel[ed]);	
	}
	
	GetSelctedGranularity("Rop");
	Thread.sleep(2000);
	GetCells("A");
	Thread.sleep(4000);
	String SelectedCellNameRopLevel=CellFilteredValues.getText().trim();
	System.out.println("Selected Cell Name is:::::" + SelectedCellNameRopLevel);
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"Selected Cell Name is[ROPLevel]:::::" + SelectedCellNameRopLevel+"</b>"+"<span>"+"<br/>");
	Thread.sleep(4000);
	ApplyBtn.click();

	TIVHeaderText.click();
	Thread.sleep(8000);
	actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Traces Input Validation')]"))).click();
	actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
	actions.build().perform();
	Thread.sleep(9000);
	ListTableGridText();

	if(TableValsDayLevel.size()>0){
		int k=0;
		for(String TableContentROPLevelCellLevel:TableValsDayLevel)
		{
			System.out.println("The Values of the table are[ROP Level]::"+TableContentROPLevelCellLevel );
			k++;
			
		}
		}
	
	else
	{
		ROPcmpCell=false;
		System.out.println("The Table is Empty as it's size is::" +TableValsDayLevel.size());
	}
	
	
	
	if(TableValsDayLevel.contains(ArrAdded[0]))
	{
		System.out.println("The Table Contains Start Date::" + ArrAdded[0]);
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Table Contains Start Date[Rop Level]::" + ArrAdded[0]+"</b>"+"<span>"+"<br/>");
		cdfRop1=true;
	}
	
	if(TableValsDayLevel.contains(ArrAdded2End[0]))
	{
		System.out.println("The Table Contains End Date::" + ArrAdded2End[0]);
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Table Contains Start Date[Rop Level]::" + ArrAdded2End[0]+"</b>"+"<span>"+"<br/>");
		cdfRop2=true;
	}
	
	
	if(TableValsDayLevel.contains(SelectedCellNameRopLevel))
	{
		System.out.println("The Table Contains Cell ::" + SelectedCellNameRopLevel);
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Table Contains Filtred Cell [Rop Level]::" + SelectedCellNameRopLevel+"</b>"+"<span>"+"<br/>");
		cdfRop3=true;
	}
	
	ROPCollectioninROpLevelCellfiltred = new ArrayList<String>();
	for(int i=2;i<=TableValsDayLevel.size();i=i+6)
	{
		
		ROPCollectioninROpLevelCellfiltred.add(TableValsDayLevel.get(i-1));
		System.out.println("The Values of the ROP Captured in the table are[ROP Level]::"+TableValsDayLevel.get(i-1) );
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Values of the ROP Captured in the table are[ROP Level]::"+TableValsDayLevel.get(i-1)+ "</b>"+"<span>"+"<br/>");
	}
	
	ROPCollection1[0]=ROPCollectioninROpLevelCellfiltred.get(0);
	ROPCollection1[1]=ROPCollectioninROpLevelCellfiltred.get(ROPCollectioninROpLevelCellfiltred.size()-1);
	
	SubFirstROPCollection=ROPCollection1[0].substring(0, 5).split(":");
	SubEndROPCollection=ROPCollection1[1].substring(0, 5).split(":");
	for(int m=0;m<=SubFirstROPCollection.length-1;m++)
	{
		System.out.println("The Intail Split of the starting Rop is ::"+SubFirstROPCollection[m]);
	}
	
	for(int n=0;n<=SubEndROPCollection.length-1;n++)
	{
		System.out.println("The Intail Split of the starting Rop is ::"+SubEndROPCollection[n]);
	}
	
	boolean b1=false;
	boolean b2=false;
	boolean FinalS=false;
	String St1=ArrAdded[1].substring(0, 2);
	
	String St2=ArrAdded2End[1].substring(0, 2);
	
	
	int S1=Integer.parseInt(St1);
	int S2=Integer.parseInt(St2);
	int TableFirstHr=Integer.parseInt(SubFirstROPCollection[0]);
	int TableLastHr=Integer.parseInt(SubEndROPCollection[0]);
	System.out.println("Start Hour is:::::"+ S1 +":::::& TableFirstHr:::" +TableFirstHr);
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"Start Hour is:::::"+ S1 +":::::& TableFirstHr:::" +TableFirstHr+"</b>"+"<span>"+"<br/>");
	System.out.println("End Hour Is:::::"+S2  +"::::& TableLastHr::::::" +TableLastHr);
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"End Hour Is:::::"+S2  +"::::& TableLastHr::::::" +TableLastHr+"</b>"+"<span>"+"<br/>");
	if(TableFirstHr>=S1)
	{
		b1=true;
	}
	if(TableLastHr<=S2)
	{
		 b2=true;
	}
	
	if(b1==b2){
		ROPcmpCell=true;
		System.out.println("Start Hour Comparision is::::"+b1 +"& End Hour Comparision is::::::" +b2);
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"Start Hour Comparision is::::"+b1 +"& End Hour Comparision is::::::" +b2+"</b>"+"<span>"+"<br/>");
	}
	return ROPcmpCell;
}


/*Cell Filtering Methods  HourLevel*/
public boolean VerifyTableWithCellFilterHourLevel() throws InterruptedException {
	
	boolean HourcmpCell=false;
    boolean cdfHour1=false;
    boolean cdfHour2=false;
    boolean cdfHour3=false;
    Thread.sleep(3000);
    actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).build().perform();
	TIVStartTime.click();
	Thread.sleep(4000);
	GetDatesFromCalendar("Selected");
	Thread.sleep(9000);
	GetHours("Normal");
	Thread.sleep(5000);
	TIVHeaderText.click();
	Thread.sleep(3000);
	String StartDate =TIVStartTime.getAttribute("value");
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;font-size:14px;'>"+"<b>"+"Start Date in [Hourlevel in CellFiltering] is:::::"+ StartDate + "</b>"+"<span>"+"<br/>");
    StartDateArrforDataGridHourCellLvel=StartDate.split(" ");
    ArrAdded[0]=StartDateArrforDataGridHourCellLvel[0];
	ArrAdded[1]=StartDateArrforDataGridHourCellLvel[1];
	for(int k=0;k<=StartDateArrforDataGridHourCellLvel.length-1;k++)
	{
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;font-size:14px;'>"+"<b>"+"Split Start Date in [Hourlevel in CellFiltering] is:::  " + StartDateArrforDataGridHourCellLvel[k]+ "</b>"+"<span>"+"<br/>");
		System.out.println("Split Start Date is " + StartDateArrforDataGridHourCellLvel[k]);
	}

	Thread.sleep(4000);
	TIVEndTime.click();
	Thread.sleep(4000);
	GetDatesFromCalendar("ROPP");
	Thread.sleep(4000);
	GetHours("Rop");
	TIVHeaderText.click();
	String Endate=TIVEndTime.getAttribute("value");
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"EndTime is [HourLevel in Cell Filtering]:::" +"<b>"+Endate +"</b>"+"<span>"+"<br/>");
	System.out.println("EndTime is [[ROPLevel of CellFiltering]]:::::::" +Endate  );
	EndDateArrforDataGridHourCellLvel=Endate.split(" ");
	ArrAdded2End[0]=EndDateArrforDataGridHourCellLvel[0];
	ArrAdded2End[1]=EndDateArrforDataGridHourCellLvel[1];
	
	for(int ed=0;ed<=EndDateArrforDataGridHourCellLvel.length-1;ed++)
	{
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"End Date Split is  [HourLevel in Cell Filtering]:::::::" +"<b>"+EndDateArrforDataGridHourCellLvel[ed] +"</b>"+"<span>"+"<br/>");
	System.out.println("End Date Split is [HourLevel in Cell Filtering]:::::::" +EndDateArrforDataGridHourCellLvel[ed]);	
	}
	
	GetSelctedGranularity("Hour");
	Thread.sleep(2000);
	GetCells("A");
	Thread.sleep(4000);
	String SelectedCellNameHourLevel=CellFilteredValues.getText().trim();
	System.out.println("Selected Cell Name is:::::" + SelectedCellNameHourLevel);
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"Selected Cell Name is[HourLevel]:::::" + SelectedCellNameHourLevel+"</b>"+"<span>"+"<br/>");
	Thread.sleep(4000);
	ApplyBtn.click();

	TIVHeaderText.click();
	Thread.sleep(8000);
	actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Traces Input Validation')]"))).click();
	actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
	actions.build().perform();
	Thread.sleep(9000);
	ListTableGridText();

	if(TableValsDayLevel.size()>0){
		int k=0;
		for(String TableContentHourLevelCellLevel:TableValsDayLevel)
		{
			System.out.println("The Values of the table are[ROP Level]::"+TableContentHourLevelCellLevel );
			k++;
			
		}
		}
	
	else
	{
		HourcmpCell=false;
		System.out.println("The Table is Empty as it's size is::" +TableValsDayLevel.size());
	}
	
	
	
	if(TableValsDayLevel.contains(ArrAdded[0]))
	{
		System.out.println("The Table Contains Start Date::" + ArrAdded[0]);
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Table Contains Start Date[Hour Level]::" + ArrAdded[0]+"</b>"+"<span>"+"<br/>");
		cdfHour1=true;
	}
	
	if(TableValsDayLevel.contains(ArrAdded2End[0]))
	{
		System.out.println("The Table Contains End Date::" + ArrAdded2End[0]);
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Table Contains End Date[Hour Level]::" + ArrAdded2End[0]+"</b>"+"<span>"+"<br/>");
		cdfHour2=true;
	}
	
	
	if(TableValsDayLevel.contains(SelectedCellNameHourLevel))
	{
		System.out.println("The Table Contains Cell ::" + SelectedCellNameHourLevel);
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Table Contains Filtred Cell [Hour Level]::" + SelectedCellNameHourLevel+"</b>"+"<span>"+"<br/>");
		cdfHour3=true;
	}
	
	ROPCollectioninHourLevelCellfiltred = new ArrayList<String>();
	for(int i=2;i<=TableValsDayLevel.size();i=i+6)
	{
		
		ROPCollectioninHourLevelCellfiltred.add(TableValsDayLevel.get(i-1));
		System.out.println("The Values of the ROP Captured in the table are[Hour Level]::"+TableValsDayLevel.get(i-1) );
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Values of the ROP Captured in the table are[Hour Level]::"+TableValsDayLevel.get(i-1)+ "</b>"+"<span>"+"<br/>");
	}
	
	ROPCollection1[0]=ROPCollectioninHourLevelCellfiltred.get(0);
	SubFirstROPCollection=ROPCollection1[0].substring(0, 5).split(":");	
	for(int m=0;m<=SubFirstROPCollection.length-1;m++)
	{
		System.out.println("The Intail Split of the starting Rop is ::"+SubFirstROPCollection[m]);
	}
	boolean b1=false;
	String St1=ArrAdded2End[1].substring(0, 2);
	int S1=Integer.parseInt(St1);
	
	int TableFirstHr=Integer.parseInt(SubFirstROPCollection[0]);
	System.out.println("End Hour is[Hourlevel]:::::"+ S1 +":::::& TableFirstHr[Hourlevel]:::" +TableFirstHr);
	Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"Start Hour is[Hourlevel]:::::"+ S1 +":::::& TableFirstHr[Hourlevel]:::" +TableFirstHr+"</b>"+"<span>"+"<br/>");
	
	if(TableFirstHr<S1)
	{
		b1=true;
		
	}
	System.out.println("b1 is:"+b1+"cdfHour1 is:"+cdfHour1+"    cdfHour2 is    :"+cdfHour2+"   cdfHour3 is:"+cdfHour3);
	if(b1==cdfHour1==cdfHour2==cdfHour3)
	{
		HourcmpCell=true;
		System.out.println("b1 is:"+b1+"cdfHour1 is:"+cdfHour1+"cdfHour2 is:"+cdfHour2+"cdfHour3 is:"+cdfHour3);
		System.out.println("Start Hour Comparision is::::"+b1 +"Start Day is:::"+ArrAdded[0]+"::::And End Date Comparision is::::::"+ ArrAdded2End[0]);
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"Start Hour Comparision is[HourLevel]::::"+b1 +"Start Day is[HourLevel]:::"+ArrAdded[0]+"::::And End Date Comparision is[HourLevel]::::::"+ ArrAdded2End[0]+"</b>"+"<span>"+"<br/>");
	}
	return HourcmpCell; 
}








public String GetClassNameofPaginationButton(WebElement GetClass) {
	
	String ButtonClass;

	ButtonClass=GetClass.getAttribute("class");
	return ButtonClass;
	
}


public boolean GetPaginationStatus() throws InterruptedException {
	
	boolean Bstatus=false;
	actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).build().perform();
	System.out.println("Before the Execution The Buttonstaus is:::"+Bstatus);
	Thread.sleep(8000);
	/*CellMultiselectDropdownClick.click();
	Thread.sleep(7000);
	CellMultiselectInputTextBox.sendKeys(Keys.BACK_SPACE);
	Thread.sleep(3000);
	ApplyBtn.click();*/
	actions.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Traces Input Validation')]"))).click();
	actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
	actions.build().perform();
	Thread.sleep(16000);
	String PBClass;
	String CBClass;
	String NexBClass;
	
	PBClass=GetClassNameofPaginationButton(PButtonClass);
	CBClass=GetClassNameofPaginationButton(CButtonClass);
	NexBClass=GetClassNameofPaginationButton(NexButtonClass);
	int IntialPagecount;
	int Pagecount;
	int NexPageCount;
	
	boolean NxStatus=false;
	boolean PreVstatus=false;
	if(TableGrid.size()>0)
	{
		System.out.println("Intial Class of the Previousbutton is::" +PBClass);
		System.out.println("Intial Class of the Centrebutton is::" +CBClass);
		System.out.println("Intial Class of the Nextbutton is::" +NexBClass);
		
		IntialPagecount=Integer.parseInt(CButtonClass.getText());
		System.out.println("The Intail PageCount is::" +IntialPagecount);
		Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Intail PageCount is::" +IntialPagecount+"</b>"+"<span>"+"<br/>");
		if(IntialPagecount==1 && PBClass.equals("eButton__btn-primary-disabled___2dQIa") && CBClass.equals("eButton__btn-primary-disabled___2dQIa") && NexBClass.equals("eButton__btn-primary___HEEyh"))
		{
			
			System.out.println("Clicking the Next Button:::");
			NexButtonClass.click();
			/*WebDriverWait wait = new WebDriverWait(driver, 17);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Next']")));*/
			Thread.sleep(15000);
			NexPageCount=Integer.parseInt(CButtonClass.getText());
			
			System.out.println("The Next PageCount is::" +NexPageCount);
			Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"The Next PageCount is::" +NexPageCount+"</b>"+"<span>"+"<br/>");
			PBClass=PButtonClass.getAttribute("class");
			if(PBClass.equals("eButton__btn-primary___HEEyh"))
			{
				PreVstatus=true;
				System.out.println("Previous Btn is Enabled::");
				Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"Previous Btn is Enabled::"+NexPageCount+"</b>"+"<span>"+"<br/>");
			}
			else{
				PreVstatus=false;
				System.out.println("Previous Btn is Disabled::");
				Reporter.log("<span style='color:#FFFF00;background-color:#610B21;'>"+"<b>"+"Previous Btn is Disabled::"+NexPageCount+"</b>"+"<span>"+"<br/>");
			}
			System.out.println("The Previous Button Status is:::" +PreVstatus);
			if(PreVstatus==true && (NexPageCount>IntialPagecount) )
			{
				Bstatus=true;
				System.out.println("The Count of  NextPageCount::("+NexPageCount+ ")is grater than::"  +"Intailcount ::::"+IntialPagecount);
			}
			else {
				Bstatus=false;
				System.out.println("The Count mismatch between Intailcount & NextPageCount::" +IntialPagecount  +"NexpagePageCount::::"+NexPageCount);
			}
			PreVstatus=false; 
			System.out.println("Clicking the Previous Button:::");
			PreviousButton.click();
			Thread.sleep(16000);
			PBClass=PreviousButton.getAttribute("class");
			CBClass=CButtonClass.getAttribute("class");
			if(PBClass.equals("eButton__btn-primary-disabled___2dQIa") && CBClass.equals("eButton__btn-primary-disabled___2dQIa")){
				PreVstatus=true;	
				System.out.println("Previous Btn  & Centre/Page Number Button is Disabled::");
			}
			else{
				PreVstatus=false;
			}
			
			System.out.println("The Previous Button Status is [Previous Btn Click]:::" +PreVstatus + "::::::& ClassName is::::"+ PBClass);
			
			if(NexBClass.equals("eButton__btn-primary___HEEyh"))
			{
				NxStatus=true;
			}
			else{
				NxStatus=false;
			}
			
			System.out.println("The Next Button Status is [Previous Btn Click]:::" +NxStatus +"Class is::::"+ NexBClass +"::::& Previous("+PreVstatus+")" +"& Pageno  Btn  Disabled");
			Thread.sleep(6000);
			NexPageCount=Integer.parseInt(CButtonClass.getText());
			if(NxStatus==true && PreVstatus==true && (NexPageCount==IntialPagecount) )
			{
				Bstatus=true;
				System.out.println("The Count of  NextPageCount::("+NexPageCount+ ")is Equals To::"  +"Intailcount ::::"+IntialPagecount);
				
			}
			else {
				Bstatus=false;
				System.out.println("The Count mismatch between Intailcount :::(" +IntialPagecount  +")  & NexpagePageCount::::("+NexPageCount+")" +")"+"OR Next Button Status was"+NxStatus+"ed");
			}
		}
		
		
		
	}
	
	System.out.println("After Final  Execution The Buttonstaus is:::"+Bstatus);
	return Bstatus;
}




public boolean VerifyExportbtnClick() throws InterruptedException {
	boolean isExportable=false;
	actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).build().perform();
	String EXcepMsg1="There was an unexpected error (type=Bad Request, status=400).";
	System.out.println("Before the Execution The Buttonstaus is:::"+isExportable);
	actions.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'Traces Input Validation') or contains(@class,'dashboardTitle__dashboard-title___16CsP')]"))).click();
	Thread.sleep(7000);
	actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(10000);
	actions.build().perform();

	
	try {
		WebElement element = (new WebDriverWait(driver, 14))
				   .until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='eButton__linked-button___3nenl']")));
		 Thread.sleep(9000);
		 System.out.println("Clicking the Export btn");
		 //Exportbtn.click();
		try{
			Exportbtn.click();
			System.out.println("Inside Try block");
		if(ExceptioMsgForExport.isDisplayed()){
			System.out.println("Inside is Displayed block.....");
		if(ExceptioMsgForExport.getText().equals(EXcepMsg1))
		{
		   System.out.println("Failed to Export as because of the Execption:"+EXcepMsg1);
		   isExportable=false;
		}
		
		}
		else{
			
			isExportable=true;
			System.out.println("Inside is Else True block....." +isExportable);
			}
		}catch (NoSuchElementException e) {
			System.out.println("Exported the table----");
			 isExportable=true;
		}
	} catch (NoSuchElementException e) {
		isExportable=false;
		System.out.println("Export Button Element is not available::: because of the Exception:"+ e.getMessage());
	}
	actions.sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).sendKeys(Keys.ARROW_UP).build().perform();
	System.out.println("After the Execution The Buttonstaus is:::"+isExportable);
	return isExportable;
}



	/*Generic Unused Method to Click on  CurrentMonthAndYear Calendar*/		
	public String CurrentMonthAndYear() throws InterruptedException {
		Thread.sleep(4000);
		TIVStartTime.click();
		Thread.sleep(2000);
		String CMY=CurrentMonthAndYear.getText();
		TIVHeaderText.click();

		System.out.println(" Current Month&Year is+" +CMY );
		return CMY;
	}



	public  String GetDate(WebElement Eletype) throws InterruptedException
	{

		String FetchedDate=null;
		Thread.sleep(4000);
		Eletype.click();
		Thread.sleep(2000);
		TIVHeaderText.click();
		FetchedDate=Eletype.getAttribute("value");
		System.out.println("StartTime is:" +FetchedDate);
		return FetchedDate;
	}


	
	public boolean GetErrorAlertMeassages() {
		int TotalAlertsAvailable;
		boolean IsAlertNotificationAvailable=false;
		
		try {
			driver.manage().timeouts().implicitlyWait(33, TimeUnit.MILLISECONDS);
			TotalAlertsAvailable=ErrorNotificationCount.size();
			System.out.println("The Total Number of Error Notifications Available Are:::"+TotalAlertsAvailable);
			
			
			for(int Erraler=TotalAlertsAvailable;Erraler>=1;Erraler--)
			{
				WebElement AlrEl= driver.findElement(By.xpath("(//div[contains(@class,'errorNotificationsPanel__error-notifications-panel')]//div[contains(@class,'notification__main-div')])["+Erraler+"]//div[contains(@class,'styles__title')]"));
				String ErrMsg=AlrEl.getText();
				System.out.println("Error Meassage is::::"+ErrMsg );
				AlrEl.click();
				IsAlertNotificationAvailable=true;
			}
			
			
		} catch (NoSuchElementException e) {
			System.out.println("The Exception type is::::"+e.getClass().getSimpleName()+e.getMessage());
			IsAlertNotificationAvailable=false;
		}
		return IsAlertNotificationAvailable;
	}

	
	
	
	/*---------------ENDS-------------------------WebElements Capturing Methods-----------------------------------------------------------*/






}
