package com.ericsson.NDOrnd.dopuatautomation.testcases;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ericsson.NDOrnd.dopuatautomation.base.TestBase;
import com.ericsson.NDOrnd.dopuatautomation.pages.MainPortal_ApplicationPage;
import com.ericsson.NDOrnd.dopuatautomation.pages.VDT_Rasterpage;
import com.ericsson.NDOrnd.dopuatautomation.pages.MainPortal_Landingpage;
import com.ericsson.NDOrnd.dopuatautomation.pages.MainPortal_Loginpage;


public class VDT_RasterTest extends TestBase{


	MainPortal_Landingpage landingpage;
	MainPortal_Loginpage loginpage;
	MainPortal_ApplicationPage applicationpage;
	VDT_Rasterpage rasterpage;



	public VDT_RasterTest() {
		super();

	}


	@BeforeTest(alwaysRun = true)
	public void setUp() throws InterruptedException
	{

		landingpage=new MainPortal_Landingpage();
		loginpage= new MainPortal_Loginpage();
		applicationpage= new MainPortal_ApplicationPage();
		rasterpage = new VDT_Rasterpage();

	}

	
	@Test(priority=1)
	public void VerifyRastersMultiTenancy() throws InterruptedException
	{
		boolean isCustomerValMatching=false;
		boolean isCustomerCountMatching=false;
		Thread.sleep(3000);
		String[] LibCusCount=TestBase.getCustomerName();
		//
		List<String> CusNameFromRastersPAge = new ArrayList<>();
		
		CusNameFromRastersPAge=rasterpage.GetRastersCustomerNames();
		//
		System.out.println("No Of Customers available in TIV are::::"+CusNameFromRastersPAge.size());
		System.out.println("No Of Customers available in Prop Files are::::"+LibCusCount.length);
		int RasterCusCount=CusNameFromRastersPAge.size();
		int LIbCusCount=LibCusCount.length;
		
		if(RasterCusCount>0){
			
			List<String> CusNameFromLibFile = new ArrayList<>();
			Collections.addAll(CusNameFromLibFile, LibCusCount);
		
		if(RasterCusCount==LIbCusCount)
		{
			isCustomerCountMatching=true;
		}
		else
		{
			isCustomerCountMatching=false;
		}
		
		System.out.println("CusNameFromLibFile "+CusNameFromLibFile);
		System.out.println("CusNameFromRastersPAge "+CusNameFromRastersPAge);
		
		if(CusNameFromLibFile.equals(CusNameFromRastersPAge))
		{
			isCustomerValMatching=true;
			System.out.println("Rasters Dashbaord Customer values are matching with :: Constant Values stored in Prop File");
			Reporter.log("<span style='color:white;background-color:green;font-size:14px;'>"+"<b>"+"Rasters Dashbaord Customer values are matching with :: Constant Values stored in Prop File"+"</b>"+"<span>"+"<br/>");
		}
		else{
			isCustomerValMatching=false;
			System.out.println("Rasters Dashbaord Customer values are Not matching with :: Constant Values stored in Prop File");
			Reporter.log("<span style='color:white;background-color:green;font-size:14px;'>"+"<b>"+"Rasters Dashbaord Customer values are Not matching with :: Constant Values stored in Prop File"+"</b>"+"<span>"+"<br/>");
		}
		
		Assert.assertTrue(isCustomerValMatching && isCustomerCountMatching);
		}
		
		else{
			Assert.assertFalse(true);	
			}
		
	}	
	
	
	
	
	
	//Access GNP Raster Visualization
	@Test(priority=2)
	public void ValidtionofRasterPortal() throws InterruptedException {
		Thread.sleep(2000);
		String HomePageTitle = rasterpage.ValidateRasterHomePage();
		Reporter.log("The HomePage name is "+HomePageTitle);
		System.out.println("The HomePage name is "+HomePageTitle);
		Assert.assertEquals("DOP Rasters", HomePageTitle,"HomePage is matching");
		Reporter.log("Navigated to the correct Raster page");

		Thread.sleep(2000);
		String Pagename = rasterpage.ValidateRasterTitle();
		System.out.println("The Pagename name is "+Pagename);

		Thread.sleep(2000);
		String Layername = rasterpage.ValidateLayerPanelText();
		Reporter.log("The LayerPanel name is "+Layername);
		System.out.println("The LayerPanel name is "+Layername);
		Assert.assertEquals("Layers", Layername,"LayerPanel name is present");
		Reporter.log("Layer Panel is present in the Raster Page");

		Thread.sleep(2000);
		String Topologyname = rasterpage.ValidateTopologyText();
		Reporter.log("The default Layer name is "+Topologyname);
		System.out.println("The default layer name is "+Topologyname);
		Assert.assertEquals("Topology", Topologyname,"Topology name is present");
		Reporter.log("Topology Panel is present in the Raster Page");

		Thread.sleep(2000);
		String Startdate = rasterpage.ValidateStartDatePanelText();
		Reporter.log("The firt date panel name is "+Startdate);
		System.out.println("The firt date panel name is "+Startdate);
		Assert.assertEquals("Start", Startdate,"Start date pannel is present");
		Reporter.log("Start Date Panel is present in the Raster Page");

		Thread.sleep(2000);
		String Enddate = rasterpage.ValidateEndDatePanelText();
		Reporter.log("The last date panel name is "+Enddate);
		System.out.println("The last date panel name is "+Enddate);
		Assert.assertEquals("End", Enddate,"End date pannel is present");
		Reporter.log("End Date Panel is present in the Raster Page");

		Thread.sleep(2000);
		String SearchPanel = rasterpage.ValidateSearchPanelText();
		Reporter.log("The search panel is "+SearchPanel);
		System.out.println("The search panel is "+SearchPanel);
		Assert.assertEquals("Select topology element", SearchPanel,"Search pannel is present");
		Reporter.log("Search Panel is present in the Raster Page");

		Thread.sleep(2000);
		String DistanceTool = rasterpage.ValidateDistanceMeasurementText();
		Reporter.log("The measurement auxilary tool is "+DistanceTool);
		System.out.println("The measurement auxilary tool is "+DistanceTool);
		Assert.assertEquals("Show/Hide Ruler", DistanceTool,"Measurement Ruler is present");
		Reporter.log("Measurement Ruler is present in the Raster Page");

		Thread.sleep(2000);
		String LegendTool = rasterpage.ValidateRasterLegendText();
		Reporter.log("The Legend auxilary tool is "+LegendTool);
		System.out.println("The Legend auxilary tool is "+LegendTool);
		Assert.assertEquals("Show/Hide Legend", LegendTool,"Raster Legend is present");
		Reporter.log("Raster Legend is present in the Raster Page");

		Thread.sleep(2000);
		String ZoomInButton = rasterpage.ValidateZoomInButton();
		String[] defaultZoomInValue = new String[1];
		defaultZoomInValue[0] = ZoomInButton.substring(ZoomInButton.length()-7);
		Reporter.log("The zooming button is "+defaultZoomInValue[0]);
		System.out.println("The zooming button is "+defaultZoomInValue[0]);
		Assert.assertEquals("zoom-in", defaultZoomInValue[0],"Zoom In Button is present");
		Reporter.log("Zoom In Button is present in the Raster Page");

		Thread.sleep(2000);
		String ZoomOutButton = rasterpage.ValidateZoomOutButton();
		String[] defaultZoomOutValue = new String[1];
		defaultZoomOutValue[0] = ZoomOutButton.substring(ZoomOutButton.length()-8);
		Reporter.log("The zooming button is "+defaultZoomOutValue[0]);
		System.out.println("The zooming button is "+defaultZoomOutValue[0]);
		Assert.assertEquals("zoom-out", defaultZoomOutValue[0],"Zoom Out Button is present");
		Reporter.log("Zoom Out Button is present in the Raster Page");
		Thread.sleep(2000);

		Thread.sleep(2000);
		String MapPanel = rasterpage.ValidateMapViewPanel();
		Reporter.log("The tag name for Map View Panel is "+MapPanel);
		System.out.println("The tag name for Map View Panel is "+MapPanel);
		Assert.assertEquals("canvas", MapPanel,"Map View Panel is present in the Raster Page");
		Reporter.log("Map View Panel is present in the Raster Page");

	}

	//Customer-Projects are available
	//@test(priority=2)
	//Yet to create the method

	//Date panel is available
	@Test(priority=3)
	public void ValidtionofDatePanel() throws InterruptedException {

		Thread.sleep(15000);


		String StartDateData = rasterpage.GetStartDateData();	
		System.out.println("Default Start date is "+StartDateData);

		Thread.sleep(2000);
		String EndDateData = rasterpage.GetEndDateData();
		System.out.println("Default End date is "+EndDateData);

		Thread.sleep(2000);
		if(!(StartDateData.equalsIgnoreCase("Invalid data") && (EndDateData.equalsIgnoreCase("Invalid data")))) {
			Thread.sleep(2000);
			System.out.println("Start/End date/time do not say Invalid data");
		}
		else {
			Thread.sleep(2000);
			System.out.println("Start/End date/time have Invalid data");
		}
		
		rasterpage.selectDate();
		Thread.sleep(2000);
		String RasterStartTimeText = rasterpage.GetStartDateData();
		System.out.println("Start date is "+RasterStartTimeText);

		Thread.sleep(2000);
		String RasterEndTimeText = rasterpage.GetEndDateData();
		System.out.println("End date is "+RasterEndTimeText);

		Thread.sleep(2000);
		rasterpage.ClickOnRefreshButton();
		System.out.println("Clicked on the refresh button");
		Reporter.log("Clicked on the refresh button");

	}


	//Topology layer is plotted on GIS
	@Test(priority=4)
	public void ValidtionofTopologyLayer() throws InterruptedException {	 

		Thread.sleep(2000);
		rasterpage.ClickOnArrowButton();
		Thread.sleep(1000);
		Reporter.log("Clicked on the arrowicon to expand the Topology Layer");
		System.out.println("Clicked on the arrowicon to expand the Topology Layer");

		Thread.sleep(2000);
		String EyeDisable = rasterpage.ValidationOfEyeIconNotVisible();
		System.out.println(EyeDisable);
		Thread.sleep(1000);
		if(EyeDisable.contains("eds__icon-eye___")) {
			//equalsIgnoreCase("eButton__icon___1Gb-y styles__icon___3eFpL styles__icon-eye___TmGum")) {
			System.out.println("Eye Icon is disabled");
			Reporter.log("Eye Icon is disabled");
		}
		else {
			System.out.println("Eye Icon is still enabled");
			Reporter.log("Eye Icon is still enabled");
			Assert.fail("Eye Icon is still enabled");
		}

		Thread.sleep(2000);
		String EyeEnable = rasterpage.ValidationOfEyeIconVisible();
		System.out.println(EyeEnable);
		Thread.sleep(1000);
		if(EyeEnable.contains("eds__icon-eye-solid___")) {
			//equalsIgnoreCase("eButton__icon___1Gb-y styles__icon___3eFpL styles__icon-eye___TmGum")) {
			System.out.println("Eye Icon is Enabled");
			Reporter.log("Eye Icon is Enabled");
		}
		else {
			System.out.println("Eye ICon is still not enabled");
			Assert.fail("Eye Icon is still not enabled");
		}

		Thread.sleep(2000);
		int LayerType = rasterpage.ValidationOfLayerType();
		Thread.sleep(1000);
		Reporter.log("Total number of Topology Layer present is  "+LayerType);
		System.out.println("Total number of Topology Layer present is  "+LayerType);
		Thread.sleep(1000);
		if(LayerType==1) {
			System.out.println("Topology as a unique option to select is present in the Layer Type");
			Reporter.log("Topology as a unique option to select is present in the Layer Type");
		}
		else {
			System.out.println("Topology is not a unique option to select is present in the Layer Type");
			Reporter.log("Topology is not a unique option to select is present in the Layer Type");
			Assert.fail("Topology is not a unique option to select is present in the Layer Type");
		}

		/*Thread.sleep(2000);
		rasterpage.ValidateOnTopologyLayer();*/

		Thread.sleep(2000);
		boolean ApplyDeactivated = rasterpage.ValidateOnApplyButtonDeactivated();
		Thread.sleep(1000);
		if(ApplyDeactivated==true) {
			System.out.println("Apply Button is disabled");
			Reporter.log("Apply Button is disabled");
		}
		else {
			System.out.println("Apply Button is enabled");
			Reporter.log("Apply Button is enabled");
			Assert.fail("Apply Button is enabled");
		}


		Thread.sleep(2000);	  
		System.out.println("Size of the web element is "+ rasterpage.getRowXCount());
		String str1[]=new String[rasterpage.getRowXCount()];
		String str2[]=new String[rasterpage.getRowYCount()];

		str1=rasterpage.RangeSlideValue();
		Thread.sleep(1000);
		str2=rasterpage.RangeSlidePointer();
		Thread.sleep(1000);

		for(int i=0;i<rasterpage.getRowXCount();i++) {
			if(!(str1[i]==str2[i])) {
				System.out.println("Slider is moved from "+str1[i]+" to "+str2[i]);
				Reporter.log("Slider is moved from "+str1[i]+" to "+str2[i]);
			}else {
				System.out.println("Slider is not moved");
				Reporter.log("Slider is not moved");
				Assert.fail("Slider is not moved");
			}
		}

		Thread.sleep(2000);
		rasterpage.ClickOnArrowButton();
		Thread.sleep(2000);
		System.out.println("Clicked on arrow icon and the layer is compacted");
		Reporter.log("Clicked on arrow icon and the layer is compacted");

		Thread.sleep(2000);
		boolean actualBasicText = rasterpage.ValidateBasicText();
		Thread.sleep(1000);
		if(actualBasicText==false) {
			System.out.println("Layer is compacted successfully");
			Reporter.log("Layer is compacted successfully");
		}
		else {
			System.out.println("Layer is not compacted");
			Reporter.log("Layer is not compacted");
			Assert.fail("Layer is not compacted");
		}
	} 


	//Adding a layer in Raster Visualization
	@Test(priority=5)
	public void ValidtionofAddingRasterLayer() throws InterruptedException {	

		Thread.sleep(2000);
		rasterpage.ClickPlusIcon();

		Thread.sleep(2000);
		String defaultLayer  = rasterpage.ValidateDefaultLayerName();
		Reporter.log("The defalut layer name is "+defaultLayer);
		System.out.println("The defalut layer name is "+defaultLayer);
		Assert.assertEquals("Layer 2", defaultLayer,"The default layer name Layer 2 is present in the Raster Page");
		Reporter.log("The default layer name Layer 2 is present in the Raster Page");

		Thread.sleep(2000);
		String changedLayer  = rasterpage.ChangeDefaultLayerName();
		Reporter.log("The new layer name is "+changedLayer);
		System.out.println("The new layer name is "+changedLayer);
		Assert.assertEquals("Test Layer", changedLayer,"The new layer name Test Layer is present in the Raster Page");
		Reporter.log("The new layer name Test Layer is present in the Raster Page");

		Thread.sleep(2000);
		rasterpage.ClickRasterLayerArrow();
		System.out.println("Clicked on the Raster Layer");

		Thread.sleep(2000);
		int LayerType = rasterpage.ValidationOfRasterLayerType();
		Thread.sleep(1000);
		Reporter.log("Total number of Raster Layer Type present is  "+LayerType);
		System.out.println("Total number of Raster Layer Type present is  "+LayerType);
		Thread.sleep(1000);

		Thread.sleep(2000);
		rasterpage.ClickRasterLayerFromDropdown();

		Thread.sleep(2000);
		boolean ApplyDeactivated = rasterpage.ValidateOnApplyButtonDeactivated();
		Thread.sleep(1000);
		if(ApplyDeactivated==true) {
			System.out.println("Apply Button is disabled");
			Reporter.log("Apply Button is disabled");
		}
		else {
			System.out.println("Apply Button is enabled");
			Reporter.log("Apply Button is enabled");
			Assert.fail("Apply Button is enabled");
		}

		Thread.sleep(2000);
		rasterpage.SelectTheRasterOption();


		Thread.sleep(2000);
		rasterpage.ClickOnLayer2BinIcon();
		Thread.sleep(2000);
		System.out.println("Clicked on Layer 2 bin icon and the layer is deleted");
		Reporter.log("Clicked on Layer 2 bin icon and the layer is deleted");

		Thread.sleep(2000);
		boolean actualBasicText = rasterpage.ValidateBasicText();
		Thread.sleep(1000);
		if(actualBasicText==false) {
			System.out.println("Test Layer is deleted successfully");
			Reporter.log("Test Layer is deleted successfully");
		}
		else {
			System.out.println("Test Layer is not deleted");
			Reporter.log("Test Layer is not deleted");
			Assert.fail("Test Layer is not deleted");
		}

		Thread.sleep(2000);
		rasterpage.ClickOnThePlusIcon();
		int LayerCount = rasterpage.ValidatingTheLayerCount();
		Thread.sleep(1000);
		Reporter.log("Total number of Layer present is  "+LayerCount);
		System.out.println("Total number of Layer present is  "+LayerCount);
		Thread.sleep(1000);
		if(LayerCount==6) {
			System.out.println("5 layers along with the default Topology layer is persent in Layers");
			Reporter.log("5 layers along with the default Topology layer is persent in Layers");
		}
		else {
			System.out.println("Incorrect count of layers are added");
			Reporter.log("Incorrect count of layers are added");
			Assert.fail("Incorrect count of layers are added");
		}

		Thread.sleep(2000);
		int EyeIconCount = rasterpage.ValidatingTheEyeIconCount();
		Thread.sleep(1000);
		Reporter.log("Total number of Layer visible is  "+EyeIconCount);
		System.out.println("Total number of Layer visible is  "+EyeIconCount);
		if(EyeIconCount==4) {
			System.out.println("The maximum number of visible raster layers is 3 and default Topology layer");
			Reporter.log("The maximum number of visible raster layers is 3 and default Topology layer");
		}
		else {
			System.out.println("Incorrect icons are visible");
			Reporter.log("Incorrect icons are visible");
			Assert.fail("Incorrect icons are visible");
		}

		Thread.sleep(2000);
		rasterpage.DeletingTheAddedLayers();
		Reporter.log("All the Raster Layers are deleted successfully");


	}
	
	//Add a Timing Advance layer + OSF
	//@Test(priority=6)
	public void ValidtionofOvershootingFactor() throws InterruptedException {
		Thread.sleep(2000);
		rasterpage.ClickOnArrowButton();
		Thread.sleep(2000);
		if(!rasterpage.CheckOvershootFactorReport()) {
			System.out.println("Overshoot Factor Report Button Not visible");
		}
		
		Thread.sleep(2000);
		rasterpage.overshootFactor();
		Thread.sleep(2000);
		
	}

	//Search panel is available
	//@test(priority=7)
	//Not automated as we need to manually check the sectors in the map
}


