package com.ericsson.edos.dopuatautomation.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ericsson.edos.dopuatautomation.base.TestBase;
import com.ericsson.edos.dopuatautomation.pages.EdosApplicationPage;
import com.ericsson.edos.dopuatautomation.pages.Edoslandingpage;
import com.ericsson.edos.dopuatautomation.pages.Edosloginpage;
import com.ericsson.edos.dopuatautomation.pages.CallTerminationAnalysisPage;

public class CallTerminationAnalysisTest extends TestBase {

	Edoslandingpage landingpage;
	Edosloginpage loginpage;
	EdosApplicationPage applicationpage;
	CallTerminationAnalysisPage CTAPage;
	String OrigCellVAlue;
	boolean IsDataavailableinLeftTable; 
	boolean IsDataavailableinRightTable;

	public  CallTerminationAnalysisTest() {
		super();
	}



	@BeforeTest(alwaysRun = true)
	public void setUp() throws InterruptedException
	{  

		CTAPage = new CallTerminationAnalysisPage();  
	}



	@Test(priority=1)
	public void VerifyCTATitle() throws InterruptedException
	{

		Thread.sleep(3000);
		String CTAtitle=CTAPage.getCTAtitle();
		Assert.assertEquals(CTAtitle, "GNP CTA", "CTA title is not correct");
	}


	@Test(priority=2)
	public void VerifyCTAHeaderText() throws InterruptedException
	{   
        Thread.sleep(10000);
		String DashboardHeaderText;
		Thread.sleep(3000);
		DashboardHeaderText=CTAPage.VerifyCTADashbaordHeaderTetxt();
		Assert.assertEquals(DashboardHeaderText, "Call Termination Analysis", "Dashboard Text is not matching");

	}
	
	@Test(priority=3)
	public void VerifyCTACalendars() throws InterruptedException
	{   
        Thread.sleep(10000);
		boolean isTSavailable=false;
		boolean isTRavailable=false;
		String C1;
		String C2;
		Thread.sleep(9000);
		C1=CTAPage.GetDateFromTextBox("Start","Start");
		C2=CTAPage.GetDateFromTextBox("End","End");
		System.out.println("The Start date Captured is::::"+C1);
		System.out.println("The End date Captured is::::"+C2);
		//CTAPage.ClickFiltier();
				
		}

	
	
	

	/*---------------------------Test Case Methods for UAT TC ID--2----------------------START-------------*/
	
	
	@Test(priority=4)
	public void VerifyCTACallsDataGridTable() throws InterruptedException
	{
		Thread.sleep(10000);
	    
	   IsDataavailableinLeftTable=CTAPage.GetFullTableData();
	   Thread.sleep(5000);
	   IsDataavailableinRightTable=CTAPage.GetFullRightTableData();
	   if(IsDataavailableinLeftTable && IsDataavailableinRightTable){
		   System.out.println("The Data is available in the both the tables");
	   }
	   else{
		   System.out.println("Data is not available in both the tables");
	   }
	  Assert.assertTrue(IsDataavailableinLeftTable && IsDataavailableinRightTable, "Data is not available in both the tables"); 
	}


	@Test(priority=5)
	public void VerifyNonTableComponents() throws InterruptedException{
		Thread.sleep(10000);
		boolean isTerminationStatusvAvailable=false;
		boolean isTerminationReasonvAvailable=false;
		boolean isHeatMapAvilable=false;
		boolean isScatterChartAvsilsble=false;
		boolean isRSRPChartAvsilsble=false;
		boolean isRSRQChartAvsilsble=false;
		boolean IsLeftTableDataAvailable=false;
		boolean IsRightTableDataAvailable=false;
		Thread.sleep(5000);
		CTAPage.GetProjectCount();
		Thread.sleep(5000);
		
		isTerminationStatusvAvailable=CTAPage.GetTerminationNodataXpath("terminationStatusPieChart","Termination_Status");
		System.out.println("The Termination Status val is:::"+isTerminationStatusvAvailable);
		if(isTerminationStatusvAvailable){
			System.out.println("[From TEST{Termination Status}]There is no data available for the Termination Status");
			Reporter.log("<span style='color:#fffff0;background-color:#c90016;font-size:14px;'>"+"<b>"+"[From TEST{Termination Status}]There is no data available for the Termination Status"+"</b>"+"<span>"+"<br/>");
		}
		else{
			System.out.println("[From TEST{Termination Status}]The data is available for the Termination Status");
			Reporter.log("<span style='color:#fffff0;background-color:#006d5b;font-size:14px;'>"+"<b>"+"[From TEST{Termination Status}]The data is available for the Termination Status"+"</b>"+"<span>"+"<br/>");
		}
		Thread.sleep(5000);
		
		isTerminationReasonvAvailable=CTAPage.GetTerminationNodataXpath("termination-reason-container","Termination_Reason");
		if(isTerminationReasonvAvailable){
			System.out.println("[From TEST{Termination Reason}]There is no data available for the Termination Reason");	
			Reporter.log("<span style='color:#fffff0;background-color:#c90016;font-size:14px;'>"+"<b>"+"[From TEST{Termination Reason}]There is no data available for the Termination Reason"+"</b>"+"<span>"+"<br/>");
		}
		else{
			System.out.println("[From TEST{Termination Reason}]The data is available for the Termination Reason");
			Reporter.log("<span style='color:#fffff0;background-color:#006d5b;font-size:14px;'>"+"<b>"+"[From TEST{Termination Status}]The data is available for the Termination Status"+"</b>"+"<span>"+"<br/>");
		}
		
		System.out.println("[From TEST]The Termination reason val is:::"+isTerminationReasonvAvailable);
		
		isHeatMapAvilable=CTAPage.GetTerminationNodataXpath("qualityHeatmap","HeatMap");
		if(isHeatMapAvilable){
			System.out.println("[From TEST{HeatMap}]There is no data available for the HeatMap");	
			Reporter.log("<span style='color:#fffff0;background-color:#c90016;font-size:14px;'>"+"<b>"+"[From TEST{HeatMap}]There is no data available for the HeatMap"+"</b>"+"<span>"+"<br/>");
		}
		else{
			System.out.println("[From TEST{HeatMap}]The data is available for the HeatMap");
			Reporter.log("<span style='color:#fffff0;background-color:#006d5b;font-size:14px;'>"+"<b>"+"[From TEST{HeatMap}]The data is available for the HeatMap"+"</b>"+"<span>"+"<br/>");
		}
		CTAPage.GetHeatorScatterStatus();
		Thread.sleep(5000);
		isScatterChartAvsilsble=CTAPage.GetTerminationNodataXpath("qualityScatterChart","ScatterChart");
		if(isScatterChartAvsilsble){
			System.out.println("[From TEST{ScatterChart}]There is no data available for the ScatterChart");	
			Reporter.log("<span style='color:#fffff0;background-color:#c90016;font-size:14px;'>"+"<b>"+"[From TEST{ScatterChart}]There is no data available for the ScatterChart"+"</b>"+"<span>"+"<br/>");
		}
		else{
			System.out.println("[From TEST{ScatterChart}]The data is available for the ScatterChart");
			Reporter.log("<span style='color:#fffff0;background-color:#006d5b;font-size:14px;'>"+"<b>"+"[From TEST{ScatterChart}]The data is available for the ScatterChart"+"</b>"+"<span>"+"<br/>");
		}
		Thread.sleep(5000);
		CTAPage.GetScrolled("DOWN",14);
		isRSRPChartAvsilsble=CTAPage.GetTerminationNodataXpath("RSRP-chart-container","RSRP-chart");
		if(isRSRPChartAvsilsble){
			System.out.println("[From TEST{1..RSRP-chart}]There is no data available for the RSRP-chart");
			Reporter.log("<span style='color:#fffff0;background-color:#c90016;font-size:14px;'>"+"<b>"+"[From TEST{1..RSRP-chart}]There is no data available for the RSRP-chart"+"</b>"+"<span>"+"<br/>");
		}
		else{
			System.out.println("[From TEST{1..RSRP-chart}]The data is available for the RSRP-chart");
			Reporter.log("<span style='color:#fffff0;background-color:#006d5b;font-size:14px;'>"+"<b>"+"[From TEST{1..RSRP-chart}]The data is available for the RSRP-chart"+"</b>"+"<span>"+"<br/>");
		}
		isRSRQChartAvsilsble=CTAPage.GetTerminationNodataXpath("RSRQ-chart-container","RSRQ-chart");
		if(isRSRQChartAvsilsble){
			System.out.println("[From TEST{2..RSRQ-chart}]There is no data available for the RSRQ-chart");	
			Reporter.log("<span style='color:#fffff0;background-color:#c90016;font-size:14px;'>"+"<b>"+"[From TEST{2..RSRQ-chart}]There is no data available for the RSRQ-chart"+"</b>"+"<span>"+"<br/>");
		}
		else{
			System.out.println("[From TEST{2..RSRQ-chart}]The data is available for the RSRQ-chart");
			Reporter.log("<span style='color:#fffff0;background-color:#006d5b;font-size:14px;'>"+"<b>"+"[From TEST{2..RSRQ-chart}]The data is available for the RSRQ-chart"+"</b>"+"<span>"+"<br/>");
		}
		
	Assert.assertFalse(isTerminationStatusvAvailable || isTerminationReasonvAvailable	|| isHeatMapAvilable  ||	isScatterChartAvsilsble	|| isRSRPChartAvsilsble	|| isRSRQChartAvsilsble	|| IsLeftTableDataAvailable ||	IsRightTableDataAvailable, "Test Failed");
	}

	
	
	/*---------------------------Test Case Methods Ends for UAT TC ID--2----------------------END-------------*/

	
	
	
	
	//TC-03 Cell Filter: Data is filtered
	@Test(priority=8)
	public void VerifyCellFilterData() throws InterruptedException{
		Thread.sleep(10000);
		CTAPage.GetScrolled("UP",17);
        CTAPage.GetDateFromTextBox("Start","Start");
       
        Thread.sleep(8000);
        CTAPage.GetDateFromTextBox("End","End");
		CTAPage.ClickOnArrow();

		Thread.sleep(5000);
		String selectedCellValue = CTAPage.GetDropdownValue();

		if(selectedCellValue.contains("No results found")) {
			System.out.println("There are no cells present in the cell box");
			Reporter.log("There are no cells present in the cell box");
			Assert.fail("There are no cells present in the cell box");
		}
		else {
			System.out.println("The first cell value selected from the dropdown is : "+selectedCellValue);
			Reporter.log("The first cell value selected from the dropdown is : "+selectedCellValue);
		}
		Thread.sleep(5000);
		CTAPage.ClickFirstCellvalue();


		Thread.sleep(5000);
		String CellValueinField = CTAPage.GetCellValue();

		Thread.sleep(5000);
		if(selectedCellValue.trim().equalsIgnoreCase(CellValueinField.trim())) {
			System.out.println("The selected cell from the dropdown is properly added in the cell box");
			Reporter.log("The selected cell from the dropdown is properly added in the cell box");
		}

		else {
			System.out.println("The selected cell from the dropdown is not properly added in the cell box");
			Reporter.log("The selected cell from the dropdown is not properly added in the cell box");
			Assert.fail("The selected cell from the dropdown is not properly added in the cell box");
		}

		Thread.sleep(5000);
		CTAPage.ClickFiltier();
		System.out.println("Clicked on filter");

		Thread.sleep(15000);
		String OrigCellVAlue = CTAPage.ValidateOriginatingCell();
		System.out.println("The value present in the Table datagrid is "+OrigCellVAlue);

		if(CellValueinField.trim().equalsIgnoreCase(OrigCellVAlue.trim())) {
			System.out.println("The selected cell from the dropdown and the Originating Cell in the Table Datagrid is matching");
			Reporter.log("The selected cell from the dropdown and the Originating Cell in the Table Datagrid is matching");
		}
		else {
			System.out.println("The selected cell from the dropdown and the Originating Cell in the Table Datagrid is not matching");
			Reporter.log("The selected cell from the dropdown and the Originating Cell in the Table Datagrid is not matching");
			Assert.fail("The selected cell from the dropdown and the Originating Cell in the Table Datagrid is not matching");
		}
	}

	
	
		
	
	
	
	//TC - 06 Open call details from table
	
	@Test(priority=9)
	public void VerifyOpenCallDetails() throws InterruptedException{
		Thread.sleep(12000);
		OrigCellVAlue = CTAPage.ValidateOriginatingCell();
		System.out.println("The value present in the Table datagrid is "+OrigCellVAlue);
		
		Thread.sleep(8000);
		CTAPage.GetScroll("LEFT",33);
		String TerStatValue = CTAPage.ValidateTerminationStatus();
		System.out.println("The value present in the Termination status is "+TerStatValue);
		
		Thread.sleep(8000);
		String TerReasonValue = CTAPage.ValidateTerminationReason();
		System.out.println("The value present in the Termination Reason is "+TerReasonValue);
		
		Thread.sleep(8000);
		CTAPage.ClickMagnifyingLens();
		
		Thread.sleep(8000);
		String CallDetailsText = CTAPage.CallDetailText();
		System.out.println("The Call Deatil Dashboard contains text = "+CallDetailsText);
		
		Thread.sleep(8000);
		if(CallDetailsText.contains("Call Details Analysis")) {
		System.out.println("Call Details Dashboard is open for the selected call");
		Reporter.log("Call Details Dashboard is open for the selected call");
		}
		else
		{
			System.out.println("Call Details Dashboard is not open");
			Reporter.log("Call Details Dashboard is not open");
			Assert.fail("Call Details Dashboard is not open");
		}
		
		Thread.sleep(8000);
		if(CallDetailsText.contains(TerStatValue)) {
			System.out.println("Call Termination Status is available on top of the dashboard  - "+TerStatValue);
			Reporter.log("Call Termination Status is available on top of the dashboard  - "+TerStatValue);
			}
			else
			{
				System.out.println("Call Termination Status is not available on top of the dashboard");
				Reporter.log("Call Termination Status is not available on top of the dashboard");
				Assert.fail("Call Termination Status is not available on top of the dashboard");
			}
		
		Thread.sleep(8000);
		if(CallDetailsText.contains(TerReasonValue)) {
			System.out.println("Call Termination Reason is available on top of the dashboard  - "+TerReasonValue);
			Reporter.log("Call Termination Reason is available on top of the dashboard  - "+TerReasonValue);
			}
			else
			{
				System.out.println("Call Termination Reason is not available on top of the dashboard");
				Reporter.log("Call Termination Reason is not available on top of the dashboard");
				Assert.fail("Call Termination Reason is not available on top of the dashboard");
			}
	}
	
	//TC - 07 Call Events
	@Test(priority=10)
	public void ValidateCallEvents() throws InterruptedException{
		
		Thread.sleep(10000);
		String ServingCellValue = CTAPage.validateServingcell();
		
		Thread.sleep(8000);
		if(!(ServingCellValue.equalsIgnoreCase(""))) {
		System.out.println("The Serving Cell value present in the Call Details page is "+ServingCellValue);
		}
		else {
			System.out.println("Call Event details is not available on top of the dashboard");
			Reporter.log("Call Event details is not available on top of the dashboard");
			Assert.fail("Call Event details is not available on top of the dashboard");
		}
		
		Thread.sleep(8000);
		String EventNameValue = CTAPage.validateEventname();
		System.out.println("The Serving Cell value present in the Call Details page is "+EventNameValue);
		
		if(!(EventNameValue.equalsIgnoreCase("")) && (ServingCellValue.equalsIgnoreCase(OrigCellVAlue))) {
			System.out.println("Call Events are availabe in the table along with Serving Cell - "+ ServingCellValue+ " the Event Name  - "+EventNameValue);
			Reporter.log("Call Events are availabe in the table along with Serving Cell - "+ ServingCellValue+ " the Event Name  - "+EventNameValue);
		}
		
		else {
			System.out.println("Call Events are not availabe for the Originatining Cell :"+OrigCellVAlue);
			Reporter.log("Call Events are not availabe for the Originatining Cell :"+OrigCellVAlue);
			Assert.fail("Call Events are not availabe for the Originatining Cell :"+OrigCellVAlue);
		}
		
		CTAPage.ValidateBackgroundColor();
		
		
	}
	

	@Test(priority=6)
	public void VerifyCallsPlottedonMap() throws InterruptedException
	{
		 /* Thread.sleep(10000);
		  CTAPage.GetScrolled("UP",17);*/
	       CTAPage.GetScroll("DOWN",28);
	       Thread.sleep(15000);
	       CTAPage.GetScroll("RIGHT",33);
	       Thread.sleep(20000);
	       CTAPage.Gettextboxclick("Latitude");
	       Thread.sleep(15000);
	       CTAPage.Gettextboxclick("Longitude");
	       CTAPage.clickoncheckbox();
	       Thread.sleep(10000);
	       CTAPage.getsectornametable();
	       Thread.sleep(10000);
	       CTAPage.GetScroll("DOWN",47);
	       Thread.sleep(12000);
	       Assert.assertEquals(5, CTAPage.checkcountcallsinmap());
	       Thread.sleep(15000);
	}


	@Test(priority=7)
	public void VerifyCallsDetailsfrommap() throws InterruptedException
	{      Thread.sleep(10000);
	       CTAPage.clickcallsfrommap();
	       Assert.assertTrue(CTAPage.comparesectors(), "The sectors present in Table and Maps are not matching");

	}

	
	
	
	
	
	
	
	
	
	
	
}
