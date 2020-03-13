package com.OvenStory.Assignment.pages;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OvenStory.Assignment.base.TestBase;



public class OvenStoryMainPage extends TestBase {
    
	
	/*TestCase-1*/
	/*Inspecting WebElement for Alert Button*/	
	@FindBy (xpath = "//button[contains(text(),'No offers needed')]")
	WebElement AlertButton;	

	/*TestCase-1*/
	/*Inspecting WebElement for Location Textbox*/	
	@FindBy (xpath = "//input[contains(@placeholder,'location') or contains(@id,'locationSearchInput')]")
	WebElement LocationTextBox;	
	
	/*TestCase-1*/
	/*Inspecting WebElement for Main Page TopHeader*/	
	@FindBy (xpath = "//div[contains(@class,'headerGridContainer')]")
	WebElement TopHeader;
	
	/*TestCase-1*/
	/*Inspecting WebElement for CollectionPage Addbutton*/	
	@FindBy (xpath = "//a[@id='addProductCombo'][text()='ADD']")
	List<WebElement> AddButton;
	
	/*TestCase-1*/
	/*Inspecting WebElement for CollectionPage Addbutton*/	
	@FindBy (xpath = "//a[text()='NEXT']")
	WebElement NextButton;
	
	/*TestCase-1*/
	/*Inspecting WebElement for CollectionPage savebutton*/	
	@FindBy (xpath = "//a[text()='SAVE']")
	WebElement SaveButton;
	
	/*TestCase-1*/
	/*Inspecting WebElement for CollectionPage SeletedItem*/	
	@FindBy (xpath = "//div[contains(@class,'comboProductDetail')]//h2")
	WebElement ItemSelected;
	
	/*TestCase-1*/
	/*Inspecting WebElement for CollectionPage CartItem*/	
	@FindBy (xpath = "//div[@class='box cartWrapper']//div[@class='cartProductName']//span")
	WebElement CartItems;
	
	/*TestCase-1*/
	/*Inspecting WebElement for CollectionPage CartItem*/	
	@FindBy (xpath = "//div//h1[contains(@class,'cartMessage')]")
	WebElement CartMessage;
	
	/*TestCase-1*/
	/*Inspecting WebElement for CollectionPage CartItem*/	
	@FindBy (xpath = "//a[@id='checkoutBtn']")
	WebElement Checkoutbutton;
	
	/*TestCase-1*/
	/*Inspecting WebElement for PayableAmoutBeforeselection*/	
	@FindBy (xpath = "//span[@class='selectedProductPrice']")
	WebElement PayableAmoutBeforeselection;
	
	/*TestCase-1*/
	/*Inspecting WebElement for PayableAmoutafterselection*/	
	@FindBy (xpath = "//span[@class='payableAmount']")
	WebElement PayableAmoutafterselection;
	
	/*TestCase-1*/
	/*Inspecting WebElement for PayableAmoutafterselection*/	
	@FindBy (xpath = "(//a[@id='addProductCombo'][text()='ADD'])")
	WebElement SingleAddButton;
	
	/*TestCase-2*/
	/*Inspecting WebElement for SideMenu*/	
	@FindBy (xpath = "//a[@class='headerIcon']")
	WebElement SideMenulink;
	
	
	/*TestCase-3*/
	/*Inspecting WebElement for LocationBox*/	
	@FindBy (xpath = "//span[@class='locationNameHeader']")
	WebElement Gettextlocation;
	
	
	/*Declaring part */
	Actions MainAct = new Actions(driver);
    public List<String> SlectedItems = new ArrayList<String>();
	public List<String> CartItemsSelected = new ArrayList<String>();
	public List<String> titlename =new ArrayList<String>();
	public boolean locationtext;
	Actions action = new Actions(driver);
	
	
	/*Initializing all the WebElements*/
	public OvenStoryMainPage() {
		PageFactory.initElements(driver , this);
	}
	

	

	/*Generic Methods for Scroll Down*/
	public void GetScroll(String KeyDownorUP,int Howmanytimes) {
	       
	      switch (KeyDownorUP) {
	      case "DOWN":
	             
	             
	             for(int ky=1;ky<=Howmanytimes;ky++)
	             {
	               MainAct.sendKeys(Keys.DOWN);
	             }
	             MainAct.build().perform();
	             break;
	             
	      case "UP":
	             
	             
	             for(int ky=1;ky<=Howmanytimes;ky++)
	             {
	           MainAct.sendKeys(Keys.UP);
	             }
	             break;
	       case "RIGHT":
	              
	             
	             for(int ky=1;ky<=Howmanytimes;ky++)
	             {
	              MainAct.sendKeys(Keys.RIGHT);
	             }
	               MainAct.build().perform();
	             break;
	       case "LEFT":
	              
	             
	             for(int ky=1;ky<=Howmanytimes;ky++)
	             {
	            MainAct.sendKeys(Keys.LEFT);
	             }
	               MainAct.build().perform();
	             break;
	      default:
	             break;
	      }
	}

	
	
	
	
	

	/*Method to discard the alertpopup for TC-1*/
	
	public void	 DiscardAlert() throws InterruptedException {
		try{
		Thread.sleep(2000);
		AlertButton.click();
		}
		catch(Exception e) {
			
		System.out.println(e);
		}
	}
   
	/*Method to enter the address for TC-1*/
    public void GetLocationTextBox(String Address) throws InterruptedException {
    	try
    	{
    	/*TestStep-Click on Type Delivery Location */
    	LocationTextBox.click();
    	/*TestStep-Enter Bhandup West Location  */
    	LocationTextBox.sendKeys(Address);
    	Thread.sleep(4000);
    	LocationTextBox.sendKeys(Keys.ENTER);
    	Thread.sleep(4000);
    	}
    	catch(Exception e){
    	System.out.println(e);
    	}
    	}
	
    /*Method to add the item  for TC-1*/
	public boolean GetAddButton() throws InterruptedException {
		
		
		/*TestStep- AddButton  */
		
		action.sendKeys(Keys.ESCAPE);
		Thread.sleep(2000);
		action.sendKeys(Keys.ESCAPE);
		//TopHeader.click();
	    Thread.sleep(2000);
		GetScroll("DOWN", 15);
		boolean Isaddeditemvalid=false;
	    Thread.sleep(3000);
		System.out.println("Before Adding the item The Cart message is::"+CartMessage.getText());
		SingleAddButton.click();
		Thread.sleep(3000);
		String ItemSelectedUponAdd=ItemSelected.getText();
		SlectedItems.add(ItemSelectedUponAdd);
		System.out.println("Item Selected Upon clicking Add Btn is::"+ItemSelectedUponAdd);
		Thread.sleep(2000);
		String  ItemValueBeforeSelction=PayableAmoutBeforeselection.getText();
		System.out.println("Item value before selection::"+ItemValueBeforeSelction);
		Thread.sleep(2000);
		
		
		
		/*TestStep-NextButton*/
		
		NextButton.click();
		Thread.sleep(2000);
		
		
		/*TestStep-SaveButton*/
		
		
		SaveButton.click();
		System.out.println("After Adding the item The Cart message is::"+CartMessage.getText());
		Thread.sleep(2000);
		String ItemAddedtoCartis=CartItems.getText();
		System.out.println("The Item added to the cart is ::"+ItemAddedtoCartis);
		Thread.sleep(3000);
		String  ItemValueAfterSelction=PayableAmoutafterselection.getText();
		System.out.println("Item value after selection::"+ItemValueAfterSelction);
		
		
		
		/*Validating the Cart Before Adding and After Adding*/
			if(ItemSelectedUponAdd.trim().equals(ItemAddedtoCartis.trim()))
			{
				Isaddeditemvalid=true;
				System.out.println("The Selected item  and cart items are matching");
			}
			else{
				Isaddeditemvalid=false;
				System.out.println("The Selected item  and cart items are  not matching");
			}
			return Isaddeditemvalid;
			
		}
		

			
			
	
	
	
	 /*Method to checkout the item  for TC-1 and getting the Urls before and after */
	
	 public void ClickOnCheckoutButton() throws InterruptedException {
		 try
		 {
		System.out.println("The URL before click is :: "+driver.getCurrentUrl());
		Thread.sleep(3000);
		Checkoutbutton.click();
		System.out.println("The URL after click is :: "+driver.getCurrentUrl());
		Thread.sleep(3000);
		}
		catch(Exception e) {
	    System.out.println(e);
		 }
	}
	
	
	
	 /*Method to click on SideMenu and click on each links and store it in an ArrayList*/ 
	 
	public void clicksidemenu() throws InterruptedException {
		
		try{
			SideMenulink.click();
		
		List<WebElement> sidemenuclick = driver.findElements(By.xpath("//ul[@class='innerSidebarMenu']//li//a"));
		int linkcount = driver.findElements(By.xpath("//ul[@class='innerSidebarMenu']//li//a")).size();
		
		
		/* To Click on each side links and get the headers */
		    for(int i =1;i<linkcount;i++) {
			String clickonlinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			sidemenuclick.get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000);
		     }
			Set<String> allwindows = driver.getWindowHandles();
			
			java.util.Iterator<String> it = allwindows.iterator();
			
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
				titlename.add(driver.getTitle());
				}
			System.out.println("All the Titles" + titlename);
			
			
			}
	
	catch(Exception e) {
		System.out.println(e);
	}
	}
	
	
	
	 /*Method to click on Location Powai and click on First Available Link*/
	
	 public void clickfirstlocation(String Address) throws InterruptedException {
		 try {
		    locationtext= false;
		    Gettextlocation.click();
		    String Beforelocation= Gettextlocation.getText();
		    System.out.println("Before Location" +Beforelocation);
	    	LocationTextBox.sendKeys(Address);
	    	Thread.sleep(4000);
	    	LocationTextBox.sendKeys(Keys.ARROW_DOWN);
	    	LocationTextBox.sendKeys(Keys.ENTER);
	    	Thread.sleep(15000);
	    	String Afterlocation= Gettextlocation.getText();
	    	System.out.println("After Location"+ Afterlocation);
	    	Thread.sleep(3000);
	    	
	    	/*If Else Condition to check Location is changing */
	    	if(Beforelocation.equalsIgnoreCase(Afterlocation))
			{
	    		locationtext=false;
				System.out.println("The Before location and after location are same");
			}
			else{
				locationtext=true;
				System.out.println("The Before location and after location are different");
			}
	    	
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
	    	
	    	
	 }
	
	



	
	
	
}
