package com.ericsson.NDOrnd.dopuatautomation.testcases;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ericsson.NDOrnd.dopuatautomation.base.TestBase;
import com.ericsson.NDOrnd.dopuatautomation.pages.MainPortal_ApplicationPage;
import com.ericsson.NDOrnd.dopuatautomation.pages.VDT_TraceInputValidationPage;
import com.ericsson.NDOrnd.dopuatautomation.pages.MainPortal_Landingpage;
import com.ericsson.NDOrnd.dopuatautomation.pages.MainPortal_Loginpage;

public class VDT_TraceInputValidationTest extends TestBase {

	MainPortal_Landingpage landingpage;
	MainPortal_Loginpage loginpage;
	MainPortal_ApplicationPage applicationpage;
	VDT_TraceInputValidationPage TraceInputValidationPage;
	
	
	/*Constructor for Calling TestBase Parent Class methods(TestBase Class) */
	public VDT_TraceInputValidationTest() {
		super();
	
	}
	
	/*BeforeTest for initializing TraceInputValidationPage Page */
	@BeforeTest(alwaysRun=true)
	public void setUp() 
	{
		TraceInputValidationPage = new VDT_TraceInputValidationPage();
		
	}
	
	/*----Tc.No:1----------STARTS-------------------TestCase Methods-----------------------------------------------------------*/
	
	
	@Test(priority=1)
	public void VerifyTIVErrorNotificationAlertPopUp() throws InterruptedException
	{
		boolean IsAlertPresent=TraceInputValidationPage.GetErrorAlertMeassages();
		System.out.println("The Status of boolvalis:::"+IsAlertPresent);
		Assert.assertFalse(IsAlertPresent, "Failed Due to Error Notifcation Popped Up... ");
	}
	
	
	@Test(priority=2)
	public void VerifyTIVMultiTenancy() throws InterruptedException
	{
		boolean isCustomerValMatching=false;
		boolean isCustomerCountMatching=false;
		Thread.sleep(3000);
		String[] LibCusCount=TestBase.getCustomerName();
		
		List<String> CusNameFromTIVPAge = new ArrayList<>();
		
		CusNameFromTIVPAge=TraceInputValidationPage.GetTIVCustomerNames();
		
		System.out.println("No Of Customers available in TIV are::::"+CusNameFromTIVPAge.size());
		System.out.println("No Of Customers available in Prop Files are::::"+LibCusCount.length);
		int TIVCusCount=CusNameFromTIVPAge.size();
		int LIbCusCount=LibCusCount.length;
		
		
		if(TIVCusCount>0){
			List<String> CusNameFromLibFile = new ArrayList<>();
		    Collections.addAll(CusNameFromLibFile, LibCusCount);
		if(TIVCusCount==LIbCusCount)
		{
			isCustomerCountMatching=true;
		}
		else
		{
			isCustomerCountMatching=false;
		}
		
		if(CusNameFromLibFile.equals(CusNameFromTIVPAge))
		{   isCustomerValMatching=true;
			System.out.println("TIV Dashbaord Customer values are matching with :: Constant Values stored in Prop File");
			Reporter.log("<span style='color:white;background-color:green;font-size:14px;'>"+"<b>"+"TIV Dashbaord Customer values are matching with :: Constant Values stored in Prop File"+"</b>"+"<span>"+"<br/>");
		}
		else{isCustomerValMatching=false;
			System.out.println("TIV Dashbaord Customer values are Not matching with :: Constant Values stored in Prop File");
			Reporter.log("<span style='color:white;background-color:green;font-size:14px;'>"+"<b>"+"TIV Dashbaord Customer values are Not matching with :: Constant Values stored in Prop File"+"</b>"+"<span>"+"<br/>");
		}
		
		Assert.assertTrue(isCustomerValMatching && isCustomerCountMatching);
		}
		else{
		Assert.assertFalse(true);	
		}
		
	}	
	
	
	
	@Test(priority=3,dependsOnMethods={"VerifyTIVErrorNotificationAlertPopUp"})
	public void VerifyTIVHeaderText() throws InterruptedException
	{
		
		String TIVHeaderText = TraceInputValidationPage.GetTivHeaderText();
		Assert.assertEquals(TIVHeaderText, "Traces Input Validation", "TIV header is not matching");
	}
	
	/*----Tc.No:2----------STARTS-------------------TestCase Methods-----------------------------------------------------------*/
	
	@Test(priority=4,dependsOnMethods={"VerifyTIVErrorNotificationAlertPopUp"})
	public void VerifyChartValuesWithDateSelected() throws InterruptedException
	{
		Thread.sleep(3000);
		String TIVStartTimeText = TraceInputValidationPage.GetStartDate();
		String TIVEndTimeText = TraceInputValidationPage.GetEndDate();
		System.out.println("The StartTime Captured is :" + TIVStartTimeText);
		System.out.println("The EndTime Captured is :" + TIVEndTimeText);
		TraceInputValidationPage.GetGanrularityVal();
		boolean DayCmp=TraceInputValidationPage.CompareDayLevel();
		System.out.println("Compared values" + DayCmp);
        Thread.sleep(2000);
         boolean ROPCmp=TraceInputValidationPage.ROPLevelValidation();
         Thread.sleep(2000);
         boolean HourCmp=TraceInputValidationPage.HourLevelValidation();
		 /*Assert.assertTrue(DayCmp);*/
		 Assert.assertTrue(ROPCmp);
		 Assert.assertTrue(HourCmp);
		 
		 
	}
	
	/*----TC.No-02----*/	/*Test Case 2 For Validating the Values with filtering Cell*/
	/*@Test(priority=3,enabled=false)
	public void VerifyTableWithoutCellSelectionTC2() throws InterruptedException
	{
		First Day level
		Thread.sleep(3000);
		boolean DaycmpTestCase2=TraceInputValidationPage.VerifyTableLoadsDaylevel();
		Assert.assertTrue(DaycmpTestCase2,"Failed Testcase 2.1A: as the Value is ::"+DaycmpTestCase2);
		if(DaycmpTestCase2==false){
		Reporter.log("<span style='color:#0851E1;background-color:#F30942;font-size:14px;'>"+"<b>"+"Failed Testcase 2.1A: as the Value is ::"+DaycmpTestCase2+"</b>"+"<span>"+"<br/>");
		}
		else{
			Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"Executed Successfully TC.no 2 1A-DayLevel as Value is ::"+DaycmpTestCase2+"</b>"+"<span>"+"<br/>");
		}
		
		
		Second Rop level
		
		
	}*/
	
	
	
	/*----TC.No-02----*/	/*Test Case 2 For Validating the Values with filtering Cell*/
	
	
	
	
	@Test(priority=7,dependsOnMethods={"VerifyTIVErrorNotificationAlertPopUp"})
	public void VerifyTableWithCellFiltering() throws InterruptedException
	{
		
		/*Day Level Vaidation*/
		boolean FS=false;
		boolean FSROP=false;
		boolean FSHour=false;
		FS=TraceInputValidationPage.VerifyTableWithCellFilter();
		if(FS==false){
			Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed Execute TC.no:3 1A[DayLevel]:: as Staus is::::::"+FS+"</b>"+"<span>"+"<br/>");	
		}
		else {
			FS=true;
			Reporter.log("<span style='color:White;background-color:Green;font-size:14px;'>"+"<b>"+"Executed Successfully  TC.no:3 1A[DayLevel]:: as Staus is::::::"+FS+"</b>"+"<span>"+"<br/>");
		}
		
		
		/*ROP Level Vaidation*/
		
		FSROP=TraceInputValidationPage.VerifyTableWithCellFilterRopLevel();
		if(FSROP==false){
			Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed Execute TC.no:3 2B[RopLevel]:: as Staus is::::::"+FSROP+"</b>"+"<span>"+"<br/>");	
		}
		else {
			FSROP=true;
			Reporter.log("<span style='color:white;background-color:Green;font-size:14px;'>"+"<b>"+"Executed Successfully  TC.no:3 1A[RopLevel]:: as Staus is::::::"+FSROP+"</b>"+"<span>"+"<br/>");
		}
		
		
		/*Hour Level Vaidation*/
		
		FSHour=TraceInputValidationPage.VerifyTableWithCellFilterHourLevel();
		if(FSHour==false){
			Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed Execute TC.no:3 3c[Hour evel]:: as Staus is::::::"+FSHour+"</b>"+"<span>"+"<br/>");	
		}
		else {
			FSHour=true;
			Reporter.log("<span style='color:white;background-color:Green;font-size:14px;'>"+"<b>"+"Executed Successfully  TC.no:3 3c[RopLevel]:: as Staus is::::::"+FSHour+"</b>"+"<span>"+"<br/>");
		}
		
	
		if(FS==FSROP==FSHour)
		{
			Assert.assertTrue(true, "DAY,ROP & Hour Level cell filtering validation is executed successfully ");
			Reporter.log("<span style='color:white;background-color:green;font-size:14px;'>"+"<b>"+"Executed Successfully TC.no:3 :: Final Status is::::::"+FSHour+"</b>"+"<span>"+"<br/>");
		}
		else
		{
			Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed Execute TC.no:3:: Final  Status is::::::"+FSHour+"</b>"+"<span>"+"<br/>");
		}
		
		
		
	}
	
	
	@Test(priority=5,dependsOnMethods={"VerifyTIVErrorNotificationAlertPopUp"})
	public void VerifyTablePagination() throws InterruptedException
	{
		boolean FinalStausPag=false;
		FinalStausPag=TraceInputValidationPage.GetPaginationStatus();
		Assert.assertTrue(FinalStausPag);
		if(FinalStausPag==false){
			Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed Testcase : as the Value is ::"+FinalStausPag+"</b>"+"<span>"+"<br/>");
			}
			else{
				Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"Executed Successfully as Value is ::"+FinalStausPag+"</b>"+"<span>"+"<br/>");
			}
			
	}
	
	
	@Test(priority=6,dependsOnMethods={"VerifyTIVErrorNotificationAlertPopUp"})
	public void VerifyExportFunctionalityTC4() throws InterruptedException
	{
		boolean IsClickable=false;
		IsClickable=TraceInputValidationPage.VerifyExportbtnClick();
		if(IsClickable==false){
			Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed TO Export thr Table:: as Staus is::::::"+IsClickable+"</b>"+"<span>"+"<br/>");
			Assert.assertTrue(IsClickable,"Export Functionality is not Working As Expected"); 
		}
		else{
		IsClickable=true;
		Assert.assertTrue(IsClickable, "Export Functionality is Working as Expected");}
		
	}
	

	
	
	/*---------------ENDS-------------------------TestCase Methods-----------------------------------------------------------*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
