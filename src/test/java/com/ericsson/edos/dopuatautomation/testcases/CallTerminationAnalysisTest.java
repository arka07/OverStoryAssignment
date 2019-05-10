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
		String DashboardHeaderText;
		Thread.sleep(3000);
		DashboardHeaderText=CTAPage.VerifyCTADashbaordHeaderTetxt();
		Assert.assertEquals(DashboardHeaderText, "Call Termination Analysis", "Dashboard Text is not matching");

	}
	
	@Test(priority=3)
	public void VerifyCTACalendars() throws InterruptedException
	{
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

	//TC-03 Cell Filter: Data is filtered
	@Test(priority=4)
	public void VerifyCellFilterData() throws InterruptedException{
		Thread.sleep(3000);
		CTAPage.ClickOnArrow();

		Thread.sleep(2000);
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
		Thread.sleep(2000);
		CTAPage.ClickFirstCellvalue();


		Thread.sleep(2000);
		String CellValueinField = CTAPage.GetCellValue();

		Thread.sleep(2000);
		if(selectedCellValue.trim().equalsIgnoreCase(CellValueinField.trim())) {
			System.out.println("The selected cell from the dropdown is properly added in the cell box");
			Reporter.log("The selected cell from the dropdown is properly added in the cell box");
		}

		else {
			System.out.println("The selected cell from the dropdown is not properly added in the cell box");
			Reporter.log("The selected cell from the dropdown is not properly added in the cell box");
			Assert.fail("The selected cell from the dropdown is not properly added in the cell box");
		}

		Thread.sleep(2000);
		CTAPage.ClickFiltier();
		System.out.println("Clicked on filter");

		Thread.sleep(9000);
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
	
	@Test(priority=6)
	public void VerifyOpenCallDetails() throws InterruptedException{
		
		Thread.sleep(8000);
		OrigCellVAlue = CTAPage.ValidateOriginatingCell();
		System.out.println("The value present in the Table datagrid is "+OrigCellVAlue);
		
		Thread.sleep(2000);
		String TerStatValue = CTAPage.ValidateTerminationStatus();
		System.out.println("The value present in the Termination status is "+TerStatValue);
		
		Thread.sleep(2000);
		String TerReasonValue = CTAPage.ValidateTerminationReason();
		System.out.println("The value present in the Termination Reason is "+TerReasonValue);
		
		Thread.sleep(2000);
		CTAPage.ClickMagnifyingLens();
		
		Thread.sleep(2000);
		String CallDetailsText = CTAPage.CallDetailText();
		System.out.println("The Call Deatil Dashboard contains text = "+CallDetailsText);
		
		Thread.sleep(2000);
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
		
		Thread.sleep(2000);
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
		
		Thread.sleep(2000);
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
	@Test(priority=7)
	public void ValidateCallEvents() throws InterruptedException{
		
		Thread.sleep(5000);
		String ServingCellValue = CTAPage.validateServingcell();
		
		Thread.sleep(2000);
		if(!(ServingCellValue.equalsIgnoreCase(""))) {
		System.out.println("The Serving Cell value present in the Call Details page is "+ServingCellValue);
		}
		else {
			System.out.println("Call Event details is not available on top of the dashboard");
			Reporter.log("Call Event details is not available on top of the dashboard");
			Assert.fail("Call Event details is not available on top of the dashboard");
		}
		
		Thread.sleep(2000);
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
	
	/*//TC-07 Cell Filter: Search
	@Test(priority=7)
	public void VerifyCellFilterSearch() throws InterruptedException{

		Thread.sleep(2000);
		CTAPage.ScrollUp();

		Thread.sleep(2000);
		CTAPage.ClickClearAllButton();

		Thread.sleep(2000);
		CTAPage.ClickOnArrow();

		Thread.sleep(2000);
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

		Thread.sleep(2000);
		CTAPage.SearchCellValue();

		Thread.sleep(2000);
		CTAPage.SpiltTheCellValue();

		Thread.sleep(2000);
		CTAPage.ClickFiltier();
		System.out.println("Clicked on filter");

		Thread.sleep(2000);
		String OrigCellVAlue = CTAPage.ValidateOriginatingCell();
		System.out.println("The value present in the Table datagrid is "+OrigCellVAlue);

		if(selectedCellValue.trim().equalsIgnoreCase(OrigCellVAlue.trim())) {
			System.out.println("The selected cell from the dropdown and the Originating Cell in the Table Datagrid is matching");
			Reporter.log("The selected cell from the dropdown and the Originating Cell in the Table Datagrid is matching");
		}
		else {
			System.out.println("The selected cell from the dropdown and the Originating Cell in the Table Datagrid is not matching");
			Reporter.log("The selected cell from the dropdown and the Originating Cell in the Table Datagrid is not matching");
			Assert.fail("The selected cell from the dropdown and the Originating Cell in the Table Datagrid is not matching");
		}

	}
	 
	//TC-08 Cell Filter: Multiple selection
	@Test(priority=8)
	public void VerifyCellFilterMultipleSelection() throws InterruptedException{

		Thread.sleep(2000);
		CTAPage.ScrollUp();

		Thread.sleep(2000);
		CTAPage.ClickClearAllButton();

		Thread.sleep(5000);
		CTAPage.ClickOnArrow();

		Thread.sleep(2000);
		String FirstCellValue = CTAPage.GetDropdownValue();

		Thread.sleep(5000);
		CTAPage.SearchCellValue();

		Thread.sleep(4000);
		int defaultCount = CTAPage.GetCellValues();
		System.out.println("The total number of rows present is: "+defaultCount);

		Thread.sleep(2000);
		CTAPage.SpiltTheCellValue();

		Thread.sleep(5000);
		CTAPage.ClickOnArrow();

		Thread.sleep(4000);
		String SecondCellValue = CTAPage.GetDropdownValue();

		Thread.sleep(2000);
		CTAPage.SearchSecondCellValue();

		Thread.sleep(4000);
		int actualCount = CTAPage.GetCellValues();
		System.out.println("The total number of rows present is: "+actualCount);

		Thread.sleep(2000);
		CTAPage.SpiltTheCellValue();

		CTAPage.SearchCellCount();

		if(actualCount<defaultCount) {
			System.out.println("Multiple Cells filtered are applied in the search box");
		}
		else {
			System.out.println("Multiple Cells filtered are not applied in the search box");
		}

		Thread.sleep(2000);
		CTAPage.ValidateCellValue();

		Thread.sleep(2000);
		CTAPage.ClickFiltier();
		System.out.println("Clicked on filter");

		Thread.sleep(2000);
		CTAPage.ScrollDown();

		Thread.sleep(9000);
		CTAPage.OriginatingCellClick();

		Thread.sleep(3000);
		CTAPage.SendCellValueToOriginatingCell(0);

		Thread.sleep(4000);
		String OrigCellVAlue = CTAPage.ValidateOriginatingCell();
		System.out.println("The value present in the Table datagrid is "+OrigCellVAlue);

		if(FirstCellValue.trim().equalsIgnoreCase(OrigCellVAlue.trim())) {
			System.out.println("The first selected cell from the dropdown"+FirstCellValue+" and the Originating Cell in the Table Datagrid "+OrigCellVAlue+" is matching");
			Reporter.log("The first selected cell from the dropdown"+FirstCellValue+" and the Originating Cell in the Table Datagrid "+OrigCellVAlue+" is matching");
		}
		else {
			System.out.println("The first selected cell from the dropdown"+FirstCellValue+" and the Originating Cell in the Table Datagrid "+OrigCellVAlue+" is not matching");
			Reporter.log("The first selected cell from the dropdown"+FirstCellValue+" and the Originating Cell in the Table Datagrid "+OrigCellVAlue+" is not matching");
			//Assert.fail("The first selected cell from the dropdown"+FirstCellValue+" and the Originating Cell in the Table Datagrid "+OrigCellVAlue+" is not matching");
		}

		Thread.sleep(9000);
		CTAPage.OriginatingCellClick();

		Thread.sleep(2000);
		CTAPage.OriginatingCellClear();

		Thread.sleep(3000);
		CTAPage.SendCellValueToOriginatingCell(1);

		Thread.sleep(4000);
		String SecondOrigCellVAlue = CTAPage.ValidateOriginatingCell();
		System.out.println("The value present in the Table datagrid is "+SecondOrigCellVAlue);

		if(SecondCellValue.trim().equalsIgnoreCase(SecondOrigCellVAlue.trim())) {
			System.out.println("The second selected cell from the dropdown"+SecondCellValue+" and the Originating Cell in the Table Datagrid "+SecondOrigCellVAlue+" is matching");
			Reporter.log("The second selected cell from the dropdown"+SecondCellValue+" and the Originating Cell in the Table Datagrid "+SecondOrigCellVAlue+" is matching");
		}
		else {
			System.out.println("The second selected cell from the dropdown"+SecondCellValue+" and the Originating Cell in the Table Datagrid "+SecondOrigCellVAlue+" is not matching");
			Reporter.log("The second selected cell from the dropdown"+SecondCellValue+" and the Originating Cell in the Table Datagrid "+SecondOrigCellVAlue+" is not matching");
			Assert.fail("The second selected cell from the dropdown"+SecondCellValue+" and the Originating Cell in the Table Datagrid "+SecondOrigCellVAlue+" is not matching");
		}
	}
*/
}
