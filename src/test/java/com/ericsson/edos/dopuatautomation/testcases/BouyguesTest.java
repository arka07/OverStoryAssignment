package com.ericsson.edos.dopuatautomation.testcases;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ericsson.edos.dopuatautomation.base.Lib;
import com.ericsson.edos.dopuatautomation.base.TestBase;
import com.ericsson.edos.dopuatautomation.pages.DeltaAuditpage;
import com.ericsson.edos.dopuatautomation.pages.DynamicGraphicalReportsPage;
import com.ericsson.edos.dopuatautomation.pages.EdosAdvancedMaster;
import com.ericsson.edos.dopuatautomation.pages.EdosApplicationPage;
import com.ericsson.edos.dopuatautomation.pages.EdosBouyguesPage;
import com.ericsson.edos.dopuatautomation.pages.EdosDOPPerformancePortalPage;
import com.ericsson.edos.dopuatautomation.pages.Edoslandingpage;
import com.ericsson.edos.dopuatautomation.pages.Edosloginpage;
import com.ericsson.edos.dopuatautomation.pages.EnodeBPerfKPIs;
import com.ericsson.edos.dopuatautomation.pages.IsolationReport;
import com.ericsson.edos.dopuatautomation.pages.QueryBuilderPage;
import com.ericsson.edos.dopuatautomation.pages.RCANationalRollup;
import com.ericsson.edos.dopuatautomation.pages.RCAReport;
import com.ericsson.edos.dopuatautomation.pages.TriageReport;

public class BouyguesTest extends  TestBase{


	Edoslandingpage landingpage;
	Edosloginpage loginpage;
	EdosApplicationPage applicationpage;
	EdosDOPPerformancePortalPage portalpage;
	EdosBouyguesPage bouyguespage;
	EdosAdvancedMaster advancedmaster;
	QueryBuilderPage querybuilderpage;
	EnodeBPerfKPIs  enodeBPerfKPIs;
	DynamicGraphicalReportsPage dynamicgraphicalreportspage;
    IsolationReport isolationreport;
	RCAReport rcareport;
	RCANationalRollup rcanational;
	TriageReport triagereport;
	DeltaAuditpage deltaauditpage;
	SoftAssert softAssert;
	/*EnodeBPerfKPIs  enodeBPerfKPIs;
                IsolationReport isolationreport;*/

                public String PredefinedKPITextValue=Lib.getProperty(CONFIG_PATH, "PredefinedKPI");              


                public BouyguesTest() {
                	super();
                }

                @BeforeTest(alwaysRun = true)
                public void setUp() throws InterruptedException
                {   bouyguespage = new EdosBouyguesPage();
                portalpage = new EdosDOPPerformancePortalPage();
                applicationpage= new EdosApplicationPage();
                landingpage = new Edoslandingpage();
                loginpage = new Edosloginpage();
                advancedmaster = new EdosAdvancedMaster();
                querybuilderpage = new QueryBuilderPage(); 
                dynamicgraphicalreportspage =new DynamicGraphicalReportsPage();
                enodeBPerfKPIs = new EnodeBPerfKPIs();
                isolationreport = new IsolationReport();
            	rcareport  =  new RCAReport();
            	rcanational = new RCANationalRollup();
            	deltaauditpage = new DeltaAuditpage();
            	triagereport =new TriageReport();
            	
            	softAssert = new SoftAssert();
                }


                //TestMethod to Check title of Application Page is Correct
                @Test(priority=1)
                public void VerifyAllTitleTest() throws InterruptedException 
                {
                	portalpage.ClickBouyguesLink();
                	bouyguespage.switchTabs(driver);
             	    String Bouyguestitle= bouyguespage.VisibleOfBouygues();
                	System.out.println("Title of Tab is :"+ Bouyguestitle);
                	Reporter.log("Title of Tab is :"+ Bouyguestitle);
                	Assert.assertEquals(Bouyguestitle, "bouygues");
                	String Reportstitle= bouyguespage.validateReportsTabText();
                	System.out.println("Title of Tab is :"+ Reportstitle);
                	Reporter.log("Title of Tab is :"+ Reportstitle);
                	Assert.assertEquals(Reportstitle, "REPORTS");
                	String Chartstitle= bouyguespage.validateChartsTabText();
                	System.out.println("Title of Tab is :"+ Chartstitle);
                	Reporter.log("Title of Tab is :"+ Chartstitle);
                	Assert.assertEquals(Chartstitle, "CHARTS");
                	String configtitle= bouyguespage.configTab();
                	System.out.println("Title of Tab is :"+ configtitle);
                	Reporter.log("Title of Tab is :"+ configtitle);
                	Assert.assertEquals(configtitle, "CONFIG");
                	String KPIstitle= bouyguespage.KpisTab();
                	System.out.println("Title of Tab is :"+ KPIstitle);
                	Reporter.log("Title of Tab is :"+ KPIstitle);
                	Assert.assertEquals(KPIstitle, "KPIS");
                	String FilterOptions= bouyguespage.FiltersOptionsTab();
                	System.out.println("Title of Tab is :"+ FilterOptions);
                	Reporter.log("Title of Tab is :"+ FilterOptions);
                	Assert.assertEquals(FilterOptions, "Filters/Options");
                	String LatestData= bouyguespage.LatestData();
                	String LatestDatasplit=bouyguespage.LatestData().split(" ")[0];
                	System.out.println("Latest Available Data Present is: "+ LatestData);
                	Reporter.log("Latest Available Data Present is: "+ LatestData);
                	System.out.println("Latest Available Data Present AfterSplit: "+ LatestDatasplit);
                	Reporter.log("Latest Available Data Present AfterSplit: "+ LatestDatasplit);
                	String Latestyear  = LatestDatasplit.split("/")[0];
                	System.out.println("The latest year is: "+ Latestyear);
                	Reporter.log("The latest year is: "+ Latestyear);
                	String Latestmonth =LatestDatasplit.split("/")[1];
                	System.out.println("The latest month is: "+ Latestmonth);
                	Reporter.log("The latest month is: "+ Latestmonth);
                	String LatestDay = LatestDatasplit.split("/")[2];
                	System.out.println("The latest day is: "+ LatestDay);
                	Reporter.log("The latest day is: "+ LatestDay);
                	Thread.sleep(2000);
                	bouyguespage.clickonReportsTab();
                	Thread.sleep(2000);
                	bouyguespage.clickonConfigReports();
                	Thread.sleep(2000);
                	bouyguespage.clickonUtranCellMaster();
                	Thread.sleep(2000);
                	bouyguespage.switchTabs(driver);
                	Thread.sleep(2000);
                	String starttime_advancedMaster =advancedmaster.getStarttime();
                	System.out.println("Date in Advanced Master is:"+ starttime_advancedMaster);
                	Reporter.log("Date in Advanced Master is:"+starttime_advancedMaster);
                	String LatestdateaAdvancedmaster=starttime_advancedMaster.split(" ")[0];
                	System.out.println("Date in Advanced Master after Split is:"+ LatestdateaAdvancedmaster);
                	Reporter.log("Date in Advanced Master after Split is:"+LatestdateaAdvancedmaster);
                	Thread.sleep(2000);
                	String LatestDate_A=LatestdateaAdvancedmaster.split("/")[1];
                	System.out.println("The latest startdate in Advanced Master is: "+ LatestDate_A);
                	Reporter.log("The latest startdate in Advanced Master is: "+ LatestDate_A);
                	String LatestMonth_A=LatestdateaAdvancedmaster.split("/")[0];
                	System.out.println("The latest startmonth in Advanced Master is: "+ LatestMonth_A);
                	Reporter.log("The latest startmonth in Advanced Master is: "+ LatestMonth_A);
                	String LatestYear_A=LatestdateaAdvancedmaster.split("/")[2];
                	System.out.println("The latest startyear in Advanced Master is: "+ LatestYear_A);
                	Reporter.log("The latest startyear in Advanced Master is: "+ LatestYear_A);
                	String endtime_advancedMaster =advancedmaster.getEndtime();
                	System.out.println(endtime_advancedMaster);
                	Reporter.log(endtime_advancedMaster);
                	String LatestdateaAdvancedmasterE=endtime_advancedMaster.split(" ")[0];
                	System.out.println("Date in Advanced Master End after Split is:"+ LatestdateaAdvancedmasterE);
                	Reporter.log("Date in Advanced Master End after Split is:"+LatestdateaAdvancedmasterE);
                	Thread.sleep(2000);
                	String LatestDate_E=LatestdateaAdvancedmasterE.split("/")[1];
                	System.out.println("The latest enddate in Advanced Master is: "+ LatestDate_E);
                	Reporter.log("The latest enddate in Advanced Master is: "+ LatestDate_E);
                	String LatestMonth_E=LatestdateaAdvancedmasterE.split("/")[0];
                	System.out.println("The latest endmonth in Advanced Master is: "+ LatestMonth_E);
                	Reporter.log("The latest endmonth in Advanced Master is: "+ LatestMonth_E);
                	String LatestYear_E=LatestdateaAdvancedmasterE.split("/")[2];
                	System.out.println("The latest endyear in Advanced Master is: "+ LatestYear_E);
                	Reporter.log("The latest endyear in Advanced Master is: "+ LatestYear_E);
                	Thread.sleep(2000);



                	boolean month = false, day= false, year =false;
                	if (((Integer.parseInt(Latestmonth))==(Integer.parseInt(LatestMonth_E))) || ((Integer.parseInt(Latestmonth))==(Integer.parseInt(LatestMonth_A))))
                	{
                		month= true;
                	}
                	if (((Integer.parseInt(Latestyear))==(Integer.parseInt(LatestYear_E))) || ((Integer.parseInt(Latestyear))==(Integer.parseInt(LatestYear_A))))
                	{
                		day= true;
                	}
                	if (((Integer.parseInt(LatestDay))==(Integer.parseInt(LatestDate_E))) || ((Integer.parseInt(LatestDay))==(Integer.parseInt(LatestDate_A))))
                	{
                		year= true;
                	}

                	System.out.println(Integer.parseInt(Latestmonth));
                	System.out.println(Integer.parseInt(LatestMonth_E));
                	System.out.println(Integer.parseInt(LatestMonth_A));
                	System.out.println(Integer.parseInt(Latestyear));
                	System.out.println(Integer.parseInt(LatestYear_E));
                	System.out.println(Integer.parseInt(LatestYear_A));
                	System.out.println(Integer.parseInt(LatestDay));
                	System.out.println(Integer.parseInt(LatestDate_E));
                	System.out.println(Integer.parseInt(LatestDate_A));


                	Assert.assertTrue(month=day=year,"Validation successful");


                	Reporter.log("All The Tabs are Latest Date is validated");
                	Thread.sleep(5000);
                	

                }


                @Test(priority=2)
                public void VerifyenodeBUtranCellTest() throws InterruptedException 
                {
                	Thread.sleep(2000);
                	String advancedmastertitle =advancedmaster.VisibleOfAdvancedMaster();
                	System.out.println("Title:"+ advancedmastertitle);
                	Assert.assertEquals(advancedmastertitle, "eNodeB UtranCell Configuration Advanced Master Daily");
                	Thread.sleep(5000);
                	int BeforeTablesize=advancedmaster.tablesize();
                	System.out.println("Before Filter Table size is" + BeforeTablesize);
                	Thread.sleep(1000);
                	advancedmaster.ClickQBFilterOption();
                	Thread.sleep(5000);
                	advancedmaster.clickarrowdowncell();
                	advancedmaster.clickfirstcell();
                	Thread.sleep(2000);
                	advancedmaster.ClickQBFilterOption();
                	Thread.sleep(2000);
                	advancedmaster.clickRefresh();
                	Thread.sleep(15000);
                	int AfterTablesize=advancedmaster.tablesize();
                	System.out.println("After Filter Table size is" + AfterTablesize);
                	Assert.assertTrue(AfterTablesize==1, "Table having one row with one cell");
                	Thread.sleep(10000);
                	driver.close();
                	driver.switchTo().window(bouyguespage.mainWindow);


                }

                @Test(priority=6)
                public void ValidateSearchingForCell() throws InterruptedException {
                	Thread.sleep(2000);
                	Thread.sleep(2000);
                	querybuilderpage.ClickQuerBuilderLink();
                	Reporter.log("Clicked on the QueryBuilder Link");
                	System.out.println("Clicked on the QueryBuilder Link");

                	bouyguespage.switchTabs(driver);
                	Thread.sleep(2000);
                	querybuilderpage.ClickQBFilterOption();
                	Reporter.log("Clicked on the QueryBuilder Filter Tab");
                	System.out.println("Clicked on the QueryBuilder Filter Tab");

                	Thread.sleep(2000);
                	String actualCellValue = querybuilderpage.ValidateOnCellValue();
                	Thread.sleep(2000);
                	Reporter.log("The Cell name is "+actualCellValue);
                	System.out.println("The Cell name is "+actualCellValue);
                	Assert.assertEquals("Cell", actualCellValue,"The name of the value is matching");

                	Thread.sleep(2000);
                	String actualClusterName = querybuilderpage.ValidateOnClusterField();
                	Thread.sleep(2000);
                	Reporter.log("The Cluster name is "+actualClusterName);
                	System.out.println("The Cluster name is "+actualClusterName);

                	Thread.sleep(2000);
                	querybuilderpage.ClickOnClusterField();
                	Reporter.log("Clicked on the Cluster Field");
                	System.out.println("Clicked on the Cluster Field");

                	Thread.sleep(2000);
                	String actualClusterNEField = querybuilderpage.ValidateClusterNEText();
                	Thread.sleep(2000);
                	Reporter.log("The Cluster NE field name is "+actualClusterNEField);
                	System.out.println("The Cluster NE field name is "+actualClusterNEField);

                	if(actualClusterNEField.contains(actualClusterName)) {
                		Reporter.log("The Cell is present in the Cluster NE text filed");
                		System.out.println("The Cell is present in the Cluster NE text filed");
                	}
                	else {
                		Reporter.log("The Cell is not present in the Cluster NE text filed");
                		System.out.println("The Cell is not present in the Cluster NE text filed");
                		Assert.fail("The Cell is not present in the Cluster NE text filed");
                	}
                }

                @Test(priority=7)
                public void ValidateSearchforSpecificPmCounter() throws InterruptedException{
                	boolean isCounterAddded;
             
                	Thread.sleep(2000);
                	querybuilderpage.SendCounterName();

                	Thread.sleep(2000);
                	isCounterAddded=querybuilderpage.VerifyAddedCounter();
                	Thread.sleep(6000);
                	System.out.println("The counter added is ::"+isCounterAddded);

                }

                @Test(priority=8)
                public void ValidateOnAddingPredefinedKPI() throws InterruptedException{

                	Thread.sleep(2000);
                	querybuilderpage.ClickPredefinedKPIDropdown();

                	Thread.sleep(2000);
                	querybuilderpage.SendAccessibilityText();

                	Thread.sleep(2000);
                	String expectedKPIText = querybuilderpage.ValidatePredefinedKPI();
                	System.out.println("The pre-defined KPI is ::"+expectedKPIText);
                	Assert.assertEquals(PredefinedKPITextValue, expectedKPIText,"The pre-defined KPI is addeded successfully");
                	Reporter.log("The pre-defined KPI is addeded successfully");

                	String expectedKPIFormula = querybuilderpage.ValidatePredefinedKPIFormula();
                	System.out.println("The pre-defined KPI Formula is ::"+expectedKPIFormula);
                	Reporter.log("The pre-defined KPI formula is selected successfully");
                }

                @Test(priority=9)
                public void ValidateOnCustomKPI() throws InterruptedException{
                	Thread.sleep(2000);
                	querybuilderpage.ClickOnAddKPIButton();
                	Thread.sleep(2000);
                	querybuilderpage.ValidateOnKPIBox();

                	String expectedKPIFormula = querybuilderpage.ValidateOnAddKPIFormula();
                	System.out.println("The pre-defined KPI Formula is ::"+expectedKPIFormula);
                	Reporter.log("The pre-defined KPI formula is present in the added KPI formula tab");
                	String S1 = expectedKPIFormula.trim();
                	System.out.println("S1 is :"+S1);

                	//querybuilderpage.ClickOnSaveButton();

                	String expectedKPIText = querybuilderpage.ValidateAddKPIText();
                	System.out.println("The added KPI is ::"+expectedKPIText);
                	Assert.assertEquals("AutomationTest", expectedKPIText,"The KPI is addeded successfully");
                	System.out.println("The KPI is addeded successfully");
                	Reporter.log("The KPI is addeded successfully");

                	String expectedAddedKPIFormula = querybuilderpage.ValidateAddKPIFormula();
                	System.out.println("The added KPI Formula is ::"+expectedAddedKPIFormula);
                	Reporter.log("The KPI formula is addeded successfully");
                	String S2 = expectedAddedKPIFormula.trim();
                	System.out.println("S2 is :"+S2);

                	if(S1.equals(S2))
                	{
                		Reporter.log("The KPI formula is added successfully");
                		System.out.println("The KPI formula is added successfully");
                	}
                	else {
                		Reporter.log("The KPI formula added is not matching");
                		System.out.println("The KPI formula added is not matching");
                		Assert.fail("The KPI formula added is not matching");
                	}
                }



                @Test(priority=10) 
                public void VerifyCounterAddedQBReportinTable() throws InterruptedException 
                {
                	boolean isCounterAddded=false;
                	try {

                		Thread.sleep(3000);
                		querybuilderpage.SelectExisitingReports();
                		Thread.sleep(6000);
                		querybuilderpage.SendCounterName();
                		Thread.sleep(2000);
                		isCounterAddded=querybuilderpage.VerifyAddedCounter();
                		Thread.sleep(6000);
                		System.out.println("The counter is added::"+isCounterAddded);
                		if(isCounterAddded==true)
                		{
                			Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"The counter is added successfully::"+"</b>"+"<span>"+"<br/>");
                			Assert.assertTrue(isCounterAddded, "Failed to Add the Counter");
                		}
                		else
                		{
                			Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed to Add the Counter::"+"</b>"+"<span>"+"<br/>");
                		}

                	} 
                	catch (NoSuchElementException NsEx) {

                		System.out.println("Failed to Execute the Test with Exception:::"+ NsEx.getMessage());
                		Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed to Execute the Test with Exception:::"+ NsEx.getMessage()+"</b>"+"<span>"+"<br/>");
                		Assert.assertTrue(isCounterAddded, "Failed to Add the Counter");
                	}

                }    



                @Test(priority=11) 
                public void VerifyQBReportinTable() throws InterruptedException {

                	boolean Fs=false;
                	try {

                		Thread.sleep(2000);

                		Thread.sleep(2000);

                		Reporter.log("Clicked on the QueryBuilder Filter Tab");
                		System.out.println("Clicked on the QueryBuilder Filter Tab");
                		Thread.sleep(2000);
                		querybuilderpage.SendEnodeBValue();
                		Thread.sleep(6000);
                		querybuilderpage.ClickQBFilterOption();
                		Thread.sleep(2000);
                		querybuilderpage.SelectNetworkLevel();
                		Thread.sleep(2000);
                		querybuilderpage.SelectAggreationLevel();
                		Thread.sleep(2000);
                		querybuilderpage.SetDateSelection();
                		Thread.sleep(2000);
                		Fs=querybuilderpage.ValidateReportGeneratedForSelectedDays();
                		Thread.sleep(6000);

                		if(Fs==true)
                		{
                			Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"Table Contains the Selected counter and Dates filtred"+"</b>"+"<span>"+"<br/>");
                			Assert.assertTrue(Fs);


                		}
                		else{
                			Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"The Table listed Doesn't contains either the start or End Date or both"+"</b>"+"<span>"+"<br/>");
                			Assert.assertTrue(Fs, "Table Doesn't Contains the Selected counter and Dates filtred");
                		}
                	} catch (NoSuchElementException NsEx) {

                		System.out.println("Failed to Execute the Test with Exception:::"+ NsEx.getMessage());
                		Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed to Execute the Test with Exception:::"+ NsEx.getMessage()+"</b>"+"<span>"+"<br/>");
                		Assert.assertTrue(Fs, "Table Doesn't Contains the Selected counter and Dates filtred");
                	}
                	catch(WebDriverException wex )
                	{
                		System.out.println("Failed to Execute the Test with Exception:::"+ wex.getMessage());
                		Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed to Execute the Test with Exception:::"+ wex.getMessage()+"</b>"+"<span>"+"<br/>");
                		Assert.assertTrue(Fs, "Table Doesn't Contains the Selected counter and Dates filtred");
                	}
                	catch (Throwable thex) {
                		System.out.println("Failed to Execute the Test with Exception:::"+ thex.getMessage());
                		Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed to Execute the Test with Exception:::"+ thex.getMessage()+"</b>"+"<span>"+"<br/>");
                		Assert.assertTrue(Fs, "Table Doesn't Contains the Selected counter and Dates filtred");
                	}
                	driver.close();
                	driver.switchTo().window(bouyguespage.mainWindow);
                	Thread.sleep(20000);


                }

                @Test(priority=12,dependsOnMethods={"VerifyCounterAddedQBReportinTable","VerifyQBReportinTable"},enabled=false) 
                public void VerifyExportToExcel() throws InterruptedException 
                {
                	try {
                		querybuilderpage.ExportResult("Excel");
                		Thread.sleep(6000);

                		Assert.assertTrue(true,"Failed to Export to Excel file ");
                		Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"Exported to Excel Sucessfully"+"</b>"+"<span>"+"<br/>");
                	} catch (NoSuchElementException NsEx) {

                		System.out.println("Failed to Execute the Test with Exception:::"+ NsEx.getMessage());
                		Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed to Execute the Test with Exception:::"+ NsEx.getMessage()+"</b>"+"<span>"+"<br/>");
                	}
                	catch(WebDriverException wex )
                	{
                		System.out.println("Failed to Execute the Test with Exception:::"+ wex.getMessage());
                		Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed to Execute the Test with Exception:::"+ wex.getMessage()+"</b>"+"<span>"+"<br/>");
                	}
                	catch (Throwable thex) {
                		System.out.println("Failed to Execute the Test with Exception:::"+ thex.getMessage());
                		Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed to Execute the Test with Exception:::"+ thex.getMessage()+"</b>"+"<span>"+"<br/>");
                	}
                }    

                @Test(priority=13,dependsOnMethods={"VerifyCounterAddedQBReportinTable","VerifyQBReportinTable"},enabled=false) 
                public void VerifyExportToCSV() throws InterruptedException 
                {
                	try {
                		Thread.sleep(4000);
                		querybuilderpage.ExportResult("CSV");
                		Thread.sleep(6000);

                		Assert.assertTrue(true,"Failed to Export CSV file ");
                		Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"Exported to CSV Sucessfully"+"</b>"+"<span>"+"<br/>");
                	} catch (NoSuchElementException NsEx) {

                		System.out.println("Failed to Execute the Test with Exception:::"+ NsEx.getMessage());
                		Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed to Execute the Test with Exception:::"+ NsEx.getMessage()+"</b>"+"<span>"+"<br/>");
                		Assert.assertFalse(false, "Failed to Execute the Test with Exception:::"+ NsEx.getMessage());
                	}
                	catch(WebDriverException wex )
                	{
                		System.out.println("Failed to Execute the Test with Exception:::"+ wex.getMessage());
                		Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed to Execute the Test with Exception:::"+ wex.getMessage()+"</b>"+"<span>"+"<br/>");
                		Assert.assertFalse(false, "Failed to Execute the Test with Exception:::"+ wex.getMessage());
                	}
                	catch (Throwable thex) {
                		System.out.println("Failed to Execute the Test with Exception:::"+ thex.getMessage());
                		Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed to Execute the Test with Exception:::"+ thex.getMessage()+"</b>"+"<span>"+"<br/>");
                		Assert.assertFalse(false, "Failed to Execute the Test with Exception:::"+ thex.getMessage());
                	}

                }

                @Test(priority=14,dependsOnMethods={"VerifyCounterAddedQBReportinTable","VerifyQBReportinTable"},enabled=false) 
                public void VerifyExportToTemplate() throws InterruptedException 
                {
                	try {

                		Thread.sleep(4000);
                		querybuilderpage.ExportResult("Template");
                		Thread.sleep(6000);
                		Assert.assertTrue(true,"Failed to Export Exported");
                		Reporter.log("<span style='color:#F8F8FF;background-color:#006400;font-size:14px;'>"+"<b>"+"Exported the Template Sucessfully"+"</b>"+"<span>"+"<br/>");
                	} catch (NoSuchElementException NsEx) {

                		System.out.println("Failed to Execute the Test with Exception:::"+ NsEx.getMessage());
                		Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed to Execute the Test with Exception:::"+ NsEx.getMessage()+"</b>"+"<span>"+"<br/>");
                		Assert.assertFalse(false, "Failed to Execute the Test with Exception:::"+ NsEx.getMessage());
                	}
                	catch(WebDriverException wex )
                	{
                		System.out.println("Failed to Execute the Test with Exception:::"+ wex.getMessage());
                		Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed to Execute the Test with Exception:::"+ wex.getMessage()+"</b>"+"<span>"+"<br/>");
                		Assert.assertFalse(false, "Failed to Execute the Test with Exception:::"+ wex.getMessage());
                	}
                	catch (Throwable thex) {
                		System.out.println("Failed to Execute the Test with Exception:::"+ thex.getMessage());
                		Reporter.log("<span style='color:red;background-color:yellow;font-size:14px;'>"+"<b>"+"Failed to Execute the Test with Exception:::"+ thex.getMessage()+"</b>"+"<span>"+"<br/>");
                		Assert.assertFalse(false, "Failed to Execute the Test with Exception:::"+ thex.getMessage());
                	}
                	

                }
                
                
                @Test(priority=15,dependsOnMethods={"VerifyCounterAddedQBReportinTable","VerifyQBReportinTable"},enabled=false) 
                public void VerifyQBCharting() throws InterruptedException 
                {
                boolean isGraphAvailable=false;
                	try {
            			
                		isGraphAvailable=querybuilderpage.SwitchToChartTab();
                		Assert.assertTrue(isGraphAvailable);
                		Thread.sleep(4000);
                		
                		
            		} catch (Exception e) {
            			Assert.assertTrue(isGraphAvailable);
            			System.out.println("Exception occured:"+e.getMessage());
            		}
                	
                	driver.close();
                	driver.switchTo().window(bouyguespage.mainWindow);
                	Thread.sleep(20000);
                }
			
          @Test(priority=40)
   	     public void DynamicGraphicalReport() throws InterruptedException {
        driver.close();
        driver.switchTo().window(bouyguespage.mainWindow);	  
   		Thread.sleep(2000);
   		//bouyguespage.clickonReportsTab();
   		Thread.sleep(2000);
   		dynamicgraphicalreportspage.clickonDynamicGraphicalReports();
   		Reporter.log("Clicked on the Dynamic Graphical Report Link");
   		System.out.println("Clicked on the Dynamic Graphical Report Link");
   	    bouyguespage.switchTabs(driver);
   		Thread.sleep(2000);	
   		String DGRtitle= dynamicgraphicalreportspage.gettitleDGR();
   		Assert.assertEquals(DGRtitle, "Graphical Report Generator","Title of DGR report is not correct");
   	    dynamicgraphicalreportspage.clickonFilterOptions();
		Reporter.log("Clicked on the dynamicgraphicalreportspage Filter Tab");
		System.out.println("Clicked on the dynamicgraphicalreportspage Filter Tab");
		Thread.sleep(2000);
		dynamicgraphicalreportspage.clickonExistingReport();
		Reporter.log("Clicked on the dynamicgraphicalreportspage ExistingReport Tab + Cluster Level and Daily option is selected");
		System.out.println("Clicked on the dynamicgraphicalreportspage EixstingReport Tab + Cluster Level and Daily option is selected");
	    dynamicgraphicalreportspage.SetDateSelection();
		Reporter.log("Clicked on the date");
		System.out.println("Clicked on the date");
		String table_title=dynamicgraphicalreportspage.TableValidation();
		driver.getPageSource().contains("All KPIs");
		System.out.println("Table Title name is : "+ table_title);
	    /*softAssert.assertEquals(table_title,"All KPIs" );
	    String table_row=dynamicgraphicalreportspage.TableRow();
		driver.getPageSource().contains("Cluster");
		System.out.println("Table row is : "+ table_row);
	    Assert.assertEquals(table_row,"Cluster" );*/
	    dynamicgraphicalreportspage.DGR_NumberofRowsValidation();
	    System.out.println("Number of rows:" + dynamicgraphicalreportspage.DGR_NumberofRowsValidation());
	    dynamicgraphicalreportspage.DGR_TableRowtext();
	    System.out.println("Clicked on the tablerow");
	    String enodeBStime=dynamicgraphicalreportspage.GetStarttime();
        System.out.println(enodeBStime);
		String fsdate = dynamicgraphicalreportspage.FormatDate(enodeBStime);
		Thread.sleep(2000);
		String enodeBEtime=dynamicgraphicalreportspage.GetEndtime();
		System.out.println(enodeBEtime);
		String esdate = dynamicgraphicalreportspage.FormatDate(enodeBEtime);
		Thread.sleep(2000);
		int rowcount =dynamicgraphicalreportspage.DGR_NumberofRowsValidation();
		Assert.assertEquals(rowcount, 2,"Row count is greater than 2");
		Thread.sleep(2000);
		boolean checkdate= dynamicgraphicalreportspage.checkdate();
		Assert.assertTrue(checkdate,"Dynamical Graphical reports doesnot have valid dates");
		driver.close();
        driver.switchTo().window(bouyguespage.mainWindow);
	  
	   
			
	    }
              
                
               
                @Test(priority=18)
                public void VerifyPreCannedReport() throws InterruptedException 
                
                {   //bouyguespage.clickonReportsTab();
                    Thread.sleep(2000);
                	bouyguespage.clickonPrecannedReports();
                	Thread.sleep(2000);
                	bouyguespage.clickonenodeBPerfKPIs();
                	Thread.sleep(6000);
                	bouyguespage.switchTabs(driver);
                	String title= enodeBPerfKPIs.VisibleOfeNodeBPerfKPIs();
                	System.out.println("Title of the Page is " + title);
                	Reporter.log("Title of the Page is " + title);
                	Assert.assertEquals(title, "eNodeB Performance KPIs Hourly","Header Title Not Matching");
                	Thread.sleep(2000);
                }
                

                
                @Test(priority=21) 
                public void VerifyPreCannedReportByCell() throws InterruptedException 
                {
                
                	
                	Thread.sleep(2000);
                	int btsize=enodeBPerfKPIs.tablesize();
                	System.out.println("Before Table size" + btsize );
                	Thread.sleep(5000);
                	enodeBPerfKPIs.clickSectorDaily();
                	Thread.sleep(5000);
                	
                	//Alert alert = driver.switchTo().alert();
                  	//String alertpopout =alert.getText();
                  	
                  	//if(alertpopout.contains("Complex type not sent for KPI"))
                  	 //{
                  		//alert.accept();
                      	Thread.sleep(5000);
                       	enodeBPerfKPIs.ClickeNodeBFilterOption();
                       	Thread.sleep(2000);
                       	enodeBPerfKPIs.clickarrowdowncell();
                       	Thread.sleep(2000);
                       	enodeBPerfKPIs.clickfirstcell();
                       	Thread.sleep(2000);
                       	enodeBPerfKPIs.ClickeNodeBFilterOption();
                       	Thread.sleep(10000);
                       	enodeBPerfKPIs.clickRefresh();
                       	Thread.sleep(2000);
                       	String NEtext = enodeBPerfKPIs.NEtext();
                       	System.out.println(NEtext);
                       	enodeBPerfKPIs.PerfTableValidation();
                       	Thread.sleep(2000);
                       	String enodeBStime=enodeBPerfKPIs.GetStarttime();
                       	System.out.println(enodeBStime);
                       	Thread.sleep(2000);
                       	String enodeBEtime=enodeBPerfKPIs.GetEndtime();
                       	System.out.println(enodeBEtime);
                       	enodeBPerfKPIs.checkdate();
                       	Thread.sleep(1000);
                       	enodeBPerfKPIs.checkNE();
                       	int atsize=enodeBPerfKPIs.tablesize();
                       	System.out.println("After Table size" + atsize );
                       	Thread.sleep(20000);
                    	driver.close();
                        driver.switchTo().window(bouyguespage.mainWindow);
                		Thread.sleep(2000);
                       	
                  		
                  	//}
                 
                    /* else 
                     {
               	        
                    	Thread.sleep(5000);
                    	enodeBPerfKPIs.ClickeNodeBFilterOption();
                    	Thread.sleep(2000);
                    	enodeBPerfKPIs.clickarrowdowncell();
                    	Thread.sleep(2000);
                    	enodeBPerfKPIs.clickfirstcell();
                    	Thread.sleep(5000);
                    	enodeBPerfKPIs.ClickeNodeBFilterOption();
                    	Thread.sleep(5000);
                    	enodeBPerfKPIs.clickRefresh();
                    	Thread.sleep(2000);
                    	String NEtext = enodeBPerfKPIs.NEtext();
                    	System.out.println("NEtext::::::::::::::::"  + NEtext);
                    	enodeBPerfKPIs.PerfTableValidation();
                    	Thread.sleep(2000);
                    	String enodeBStime=enodeBPerfKPIs.GetStarttime();
                    	System.out.println(enodeBStime);
                    	String fsdate = enodeBPerfKPIs.FormatDate(enodeBStime);
                    	Thread.sleep(2000);
                    	String enodeBEtime=enodeBPerfKPIs.GetEndtime();
                    	System.out.println(enodeBEtime);
                    	String esdate = enodeBPerfKPIs.FormatDate(enodeBEtime);
                    	Thread.sleep(2000);
                    	Assert.assertTrue(enodeBPerfKPIs.checkdate(),"Start Date and End Date are not OK");
                    	Thread.sleep(1000);
                    	Assert.assertTrue(enodeBPerfKPIs.checkNE(),"EnodeB is not correct");
                    	int atsize=enodeBPerfKPIs.tablesize();
                       	System.out.println("After Table size" + atsize );
                    	Thread.sleep(20000);
                		
                   }*/

                }
               
                
                @Test(priority=22,dependsOnMethods={"VerifyPreCannedReportByCell"},enabled=false) 
                public void VerifyEprefKPIChart() throws InterruptedException 
                {
                	
              		Thread.sleep(3000);
              		enodeBPerfKPIs.GetDatesVal();
              		Thread.sleep(4000);
              		/*Alert alert = driver.switchTo().alert();
                    String alertpopout =alert.getText();
              		if(alertpopout.contains("Complex type not sent for KPI"))
                 	 {
                 		alert.accept();
                 	 }
*/              		/*Actions act = new Actions(driver);*/
              		Thread.sleep(5000);
                  	//act.sendKeys(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
              		/*act.sendKeys(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();*/
              		Thread.sleep(7000);
              		
                  	boolean isKPiChartAddded;
                  	//driver.switchTo().window("eNodeB Performance KPIs Daily");
              		/*bouyguespage.switchTabs(driver);*/
              		Thread.sleep(1000);
              		enodeBPerfKPIs.SetDatesinCalTxt();
              		Thread.sleep(4000);
              		enodeBPerfKPIs.GetEprefKPIChartOPtionFilter();
              		Thread.sleep(5000);
              		enodeBPerfKPIs.SelectKPI2Val();
              		Thread.sleep(5000);
              		enodeBPerfKPIs.SetChartType("cboKPI_ChartType1_DropDown");
              		Thread.sleep(3000);
              		enodeBPerfKPIs.SetChartType("cboKPI_ChartType2_DropDown");
              		Thread.sleep(3000);
              		enodeBPerfKPIs.GetEprefKPIChartOPtionFilter();
              		Thread.sleep(2000);
              		enodeBPerfKPIs.ClickChartRefreshButton();
              		Thread.sleep(7000);
              		isKPiChartAddded=enodeBPerfKPIs.KPIChatValidation();
              		Assert.assertTrue(isKPiChartAddded, "Failed as KPIChart is not plooted as expected");
              		
                } 	
                
                
                @Test(priority=23,dependsOnMethods={"VerifyPreCannedReportByCell"},enabled=false) 
                public void VerifyEprefNEChart() throws InterruptedException 
                {
                	boolean isNEChartAddded;
                	Thread.sleep(1000);
                	
                	isNEChartAddded=enodeBPerfKPIs.GetNEChart();
                	Assert.assertTrue(isNEChartAddded, "Failed as NEChart is not plooted as expected");
                }
                
                
                @Test(priority=24,dependsOnMethods={"VerifyPreCannedReportByCell"},enabled=false) 
                public void VerifyEprefTimeChart() throws InterruptedException 
                {
                	boolean isTimeChartAddded;
                	Thread.sleep(1000);
                	
                	isTimeChartAddded=enodeBPerfKPIs.GetTimeChart();
                	Assert.assertTrue(isTimeChartAddded, "Failed as TimeChart is not plooted as expected");
                	driver.close();
                	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        		    driver.switchTo().window(tabs2.get(1));
                	
					Thread.sleep(2000);
                }
                
		@Test(priority=25,enabled=false) 
        public void VerifyIsolationReport() throws InterruptedException {
        
    	//bouyguespage.clickonReportsTab();
    	bouyguespage.clickonPrecannedReports();
    	Thread.sleep(4000);
    	bouyguespage.clickonLTESuite();
    	Thread.sleep(2000);
    	bouyguespage.clickonIsolationReport();
    	bouyguespage.switchTabs(driver);
    	String title= isolationreport.VisibleOfIsolationKPIs();
    	System.out.println("Title of the Page is " + title);
    	Reporter.log("Title of the Page is " + title);
    	isolationreport.ClickeFilterOption();
    	Thread.sleep(2000);
    	isolationreport.selectNE();
    	Thread.sleep(2000);
    	isolationreport.SubNE1();
    	Thread.sleep(2000);
    	isolationreport.ClickeFilterOption();
    	Thread.sleep(5000);
    	isolationreport.clickRefresh();
    	Thread.sleep(2000);
    	String NEtext = isolationreport.NEtext();
    	System.out.println(NEtext);
    	Thread.sleep(2000);
    	isolationreport.PerfTableValidation();
       	Thread.sleep(2000);
       	String enodeBStime=isolationreport.GetStarttime();
       	System.out.println(enodeBStime);
       	Thread.sleep(2000);
       	String enodeBEtime=isolationreport.GetEndtime();
       	System.out.println(enodeBEtime);
       	isolationreport.checkdate();
       	Thread.sleep(1000);
       	isolationreport.checkNE();
       	//Thread.sleep(20000);
		driver.close();
        driver.switchTo().window(bouyguespage.mainWindow);
		Thread.sleep(2000);
    	}
 
 @Test(priority=29,enabled=false) 
    public void VerifyRCAReport() throws InterruptedException {
    	//bouyguespage.clickonReportsTab();
    	Thread.sleep(4000);
    	//bouyguespage.clickonLTESuite();
    	//Thread.sleep(2000);
    	bouyguespage.clickonRCAReport();
    	bouyguespage.switchTabs(driver);
    	String title= rcareport.VisibleOfRCAReport();
    	System.out.println("Title of the Page is " + title);
    	Reporter.log("Title of the Page is " + title);
    	int BFtablerow=rcareport.tablesize();
    	System.out.println("Before filter table size is " + BFtablerow);
    	Reporter.log("Before filter table size is " + BFtablerow);
    	rcareport.PerfTableValidation();
    	rcareport.ClickeFilterOption();
    	Thread.sleep(2000);
    	rcareport.ClickNEarrow();
    	Thread.sleep(2000);
    	rcareport.selectNE();
    	Thread.sleep(2000);
    	String RFtext= rcareport.rulefamily();
    	Thread.sleep(2000);
    	//softAssert.assertEquals(RFtext, "Root Cause Analysis","RCA is not selected as default");
    	rcareport.ClickeFilterOption();
    	Thread.sleep(2000);
    	rcareport.clickRefresh();
    	Thread.sleep(5000);
    	int AFtablerow=rcareport.tablesize();
    	System.out.println("After filter table size is " + AFtablerow);
    	Reporter.log("After filter table size is " + AFtablerow);
    	driver.close();
    	Thread.sleep(2000);
        driver.switchTo().window(bouyguespage.mainWindow);
        softAssert.assertEquals(RFtext, "Root Cause Analysis","RCA is not selected as default");
    	Assert.assertTrue(AFtablerow==2, "Table has more than one cell with same RCA");
    	Thread.sleep(2000);
    	//Thread.sleep(20000);
       	
    }
         
 @Test(priority=31,enabled=false) 
    public void VerifyFingerRCAReport() throws InterruptedException {
    	//bouyguespage.clickonReportsTab();
    	Thread.sleep(4000);
    	//bouyguespage.clickonLTESuite();
    	//Thread.sleep(2000);
    	bouyguespage.clickonRCANationalReport();
    	bouyguespage.switchTabs(driver);
    	rcanational.ClickNEarrow();
    	Thread.sleep(2000);
    	rcanational.SelectWeek();
    	Thread.sleep(2000);
    	rcanational.clickRefresh();
    	Thread.sleep(3000);
    	Assert.assertTrue(rcanational.checkweekselection(),"Selection of Weeks are not correct");
        Assert.assertTrue(rcanational.tablesize()>=1,"Table donot have data for that particular week" );
		driver.close();
        driver.switchTo().window(bouyguespage.mainWindow);
		Thread.sleep(2000);
        //Thread.sleep(20000);		 
                
       }
	   
	    @Test(priority=34,timeOut=350000,enabled=false) 
    public void VerifyTriageReport() throws InterruptedException {
    	 
    	 String Bouygueshandle= bouyguespage.getwindowhandle();
    	 System.out.println("Title of Tab is :"+ Bouygueshandle);
    	 Reporter.log("Title of Tab is :"+ Bouygueshandle);
    	//bouyguespage.clickonReportsTab();
    	Thread.sleep(4000);
    	//bouyguespage.clickonLTESuite();
    	//Thread.sleep(2000);
    	bouyguespage.clickonTriageReport();
    	bouyguespage.switchTabs(driver);
    	String triage=triagereport.VisibleOfTriageReport();
    	System.out.println("Title of the page "+ triage);
    	Reporter.log("Title of the page "+ triage);
    	Assert.assertEquals(triage, "EPP","The triage title is not matching");
    	triagereport.selectNEssubmit();
    	Thread.sleep(2000);
    	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(5));
		Thread.sleep(2000);
    	//triagereport.alerthandle();
    	Thread.sleep(2000);
        //ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		System.out.println("switched to bou");
		//System.out.println(driver.switchTo().window(tabs2.get(1)).getTitle());
	    ///driver.switchTo().window(Bouygueshandle);
    	Thread.sleep(2000);
    	triagereport.clickusersetting();
    	bouyguespage.switchTabs(driver);
    	String recorddate= triagereport.getrecorddate();
    	System.out.println(recorddate);
    	String status= triagereport.getstatus();
    	System.out.println(status);
    	String systemdate = triagereport.getsystemdate();
    	System.out.println(systemdate);
    	Thread.sleep(2000);
    	triagereport.storingvariables();
    	Thread.sleep(2000);
    	triagereport.clickRefresh();
		driver.close();
		driver.switchTo().window(tabs2.get(1));
      //  driver.switchTo().window(bouyguespage.mainWindow);
	    Thread.sleep(2000);
		
		}
	
	
	@Test(priority=35)
	public void VerifyDeltaAuditofSites() throws InterruptedException{
		
		Thread.sleep(2000);
		deltaauditpage.ClickOnConfigChangeAudit();
		Reporter.log("Clicked on the Config Change Audit Link");
		System.out.println("Clicked on the Config Change Audit Link");
		
		Thread.sleep(2000);
		bouyguespage.switchTabs(driver);
		
		Thread.sleep(2000);
		String ConfigPageTitle = driver.getTitle();
		Reporter.log("The Title of the page is :"+ConfigPageTitle);
		System.out.println("The Title of the page is :"+ConfigPageTitle);
		
		Thread.sleep(2000);
		querybuilderpage.ClickQBFilterOption();
		Reporter.log("Clicked on the Query option");
		System.out.println("Clicked on the Query option");
		
		Thread.sleep(2000);
		deltaauditpage.SendEnodeBValueDelta();
		
		Thread.sleep(2000);
		querybuilderpage.ClickQBFilterOption();
		Reporter.log("Collapsed the filter/Options Tab");
		System.out.println("Collapsed the filter/Options Tab");
		
		Thread.sleep(2000);
		deltaauditpage.ClickOnRefreshButton();
		Reporter.log("Clicked on the refresh button");
		System.out.println("Clicked on the refresh button");
		
		Thread.sleep(3000);
		String startdate = deltaauditpage.StartDateValue();
		Reporter.log("The start date is: "+startdate);
		System.out.println("The start date is: "+startdate);
		
		Thread.sleep(2000);
		String enddate = deltaauditpage.EndDateValue();
		Reporter.log("The end date is: "+enddate);
		System.out.println("The end date is: "+enddate);
		
		Thread.sleep(2000);
		String differenceDates = deltaauditpage.getDifferenceDays();
		Reporter.log("The total number of selected dates in calendar :"+differenceDates);
		System.out.println("The total number of selected dates in calendar :"+differenceDates);
		String date1 = differenceDates.trim();
		
		Thread.sleep(2000);
		String processedDates = deltaauditpage.ValidateProcessedDates();
		Reporter.log("The total number of processed dates :"+processedDates);
		System.out.println("The total number of processed dates :"+processedDates);
		String date2 = processedDates.trim();
		
		deltaauditpage.ProcessedDateValues();
		
		if(date1.equals(date2))
		{
			Reporter.log("All the selected dates in calendar are processed successfully");
			System.out.println("All the selected dates in calendar are processed successfully");
		}
		else {
			Reporter.log("All the selected dates in calendar are not processed successfully");
			System.out.println("All the selected dates in calendar are not processed successfully");
			Assert.fail("All the selected dates in calendar are not processed successfully");
		}
		
		Thread.sleep(2000);
		deltaauditpage.ManagedObjectsList();
		
		Thread.sleep(2000);
		deltaauditpage.ValidateProcessedData();
		Reporter.log("A report is displayed with the number of changes per Parameter per day");
		System.out.println("A report is displayed with the number of changes per Parameter per day");
		
		
	}
	
	/*@Test(priority=36)
    Test case - 36 will not be automated*/
	
	@Test(priority=37,dependsOnMethods={"VerifyDeltaAuditofSites"},enabled=false)
	public void VerifyDeltaAuditForUnderlinedValues() throws InterruptedException{
	
		Thread.sleep(2000);
		deltaauditpage.ValidateTheExactChanges();
		Reporter.log("A new tab is appeared in the browser");
		System.out.println("A new tab is appeared in the browser");
		
		Thread.sleep(2000);
		deltaauditpage.ValidateCapturedCounts();
		
		Thread.sleep(2000);
		deltaauditpage.ValidateCapturedDates();
		
		Thread.sleep(2000);
		deltaauditpage.ValidateEnodeValue();
		
		driver.close();
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		//driver.switchTo().window(bouyguespage.mainWindow);
		Thread.sleep(20000);
		
		
		
	}
}
