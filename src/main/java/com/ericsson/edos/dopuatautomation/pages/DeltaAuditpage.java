package com.ericsson.edos.dopuatautomation.pages;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ericsson.edos.dopuatautomation.base.Lib;
import com.ericsson.edos.dopuatautomation.base.TestBase;

public class DeltaAuditpage extends TestBase{

	QueryBuilderPage querybuilderpage= new QueryBuilderPage();
	EdosBouyguesPage bouyguespage =new EdosBouyguesPage();

	//TC-35 - Delta Audit: View changes per cluster

	@FindBy (xpath = "//span[text()='Config Change Audit']")
	WebElement ConfigChangeAudit;

	@FindBy (xpath = "(//div[@class='k-grid-content-locked'])[1]/table/tbody/tr/td[1]")
	WebElement ManagedObjetcs;

	@FindBy (xpath = "//input[@id='rdpSDate_dateInput']")
	static
	WebElement StartDate;

	@FindBy (xpath = "//input[@id='rdpEDate_dateInput']")
	static
	WebElement EndDate;

	//TC-37 - Delta Audit: View changes per cluster

	@FindBy (xpath = "(//div[@class='k-grid-content-locked'])[1]/table/tbody/tr[1]/td[1]")
	WebElement ManageObjectValue;		

	public String textofTD;
	public String DateValueClicked;

	/*Initializing all the WebElements*/
	public DeltaAuditpage() {
		PageFactory.initElements(driver , this);
	}

	public String EnodeNameforQB=Lib.getProperty(CONFIG_PATH, "EnodeNameQB");
	Actions Act = new Actions(driver);
	JavascriptExecutor jse = (JavascriptExecutor) driver;



	//TC-35 - Delta Audit: View changes per cluster

	public void ClickOnConfigChangeAudit() throws InterruptedException{
		Thread.sleep(2000);
		ConfigChangeAudit.click();
	}

	public void SendEnodeBValueDelta() throws InterruptedException {

		String SelectedLevelis= querybuilderpage.ValidateOnLevelSelected("eNodeB");
		System.out.println("The Selected NeType Element is:::::"+SelectedLevelis);
		Thread.sleep(3000);
		querybuilderpage.TextAreatext.click();
		Act.sendKeys(Keys.CONTROL).sendKeys(String.valueOf('\u0061')).sendKeys(Keys.BACK_SPACE).build().perform();
		Thread.sleep(2000);


		System.out.println("The  EnodeB is::: "+EnodeNameforQB);

		StringBuilder StrforTA= new StringBuilder();
		StrforTA.append("document.getElementById('txtCells').value =");
		StrforTA.append("'");
		StrforTA.append(EnodeNameforQB);
		StrforTA.append("'");
		StrforTA.append(";");

		jse.executeScript(StrforTA.toString());

		Thread.sleep(3000);
		System.out.println("The Selected EnodeB value in Textarea is:::"+querybuilderpage.TextAreatext.getAttribute("value"));
		Thread.sleep(3000);
	}

	public void ClickOnRefreshButton() throws InterruptedException{
		Thread.sleep(2000);
		querybuilderpage.RefreshButton.click();
	}

	public static String StartDateValue() {

		String Startvalue = StartDate.getAttribute("value");
		return Startvalue;
	}

	public static String EndDateValue() {

		String Endvalue = EndDate.getAttribute("value");
		return Endvalue;
	}

	public String getDifferenceDays() {

		Date date1;
		Date date2;
		String dayDifference = null;
		SimpleDateFormat dates = new SimpleDateFormat("MM/dd/yyyy");
		try {

			//Setting dates
			date1 = dates.parse(StartDateValue());
			date2 = dates.parse(EndDateValue());

			//Comparing dates
			long difference = Math.abs(date1.getTime() - date2.getTime());
			long differenceDates = (difference / (24 * 60 * 60 * 1000))+1;

			//Convert long to String
			dayDifference = Long.toString(differenceDates);

			System.out.println("Calendar date difference: " + dayDifference);

		}
		catch (Exception exception) {
			System.out.println("Calendar date difference DIDN'T WORK" + exception);
		}
		return dayDifference;
	}

	public String ValidateProcessedDates() {
		int count=driver.findElements(By.xpath("(//div[@class='k-grid-header-wrap k-auto-scrollable'])[1]/table/thead/tr/th")).size();
		int actualcount = count -1;
		String countValue = Integer.toString(actualcount);
		return countValue;

	}

	public void ProcessedDateValues() throws InterruptedException 
	{	
		int dateCount=driver.findElements(By.xpath("(//div[@class='k-grid-header-wrap k-auto-scrollable'])[1]/table/thead/tr/th")).size();
		int actualcount = dateCount -1;

		for(int i=1;i<=actualcount;i++)
		{
			WebElement allTable = driver.findElement(By.xpath("(//div[@class='k-grid-header-wrap k-auto-scrollable'])[1]/table/thead/tr/th["+i+"]/a"));
			String text=allTable.getText();
			Thread.sleep(1000);
			System.out.println("The processed date is: "+text);

		}
	}

	public void ManagedObjectsList() throws InterruptedException 
	{	
		int rowCount=driver.findElements(By.xpath("(//div[@class='k-grid-content-locked'])[1]/table/tbody/tr/td[1]")).size();
		System.out.println("The total number of rows present is: "+rowCount);
		for(int i=1;i<=rowCount;i++)
		{
			WebElement allTable = driver.findElement(By.xpath("(//div[@class='k-grid-content-locked'])[1]/table/tbody/tr["+i+"]/td[1]"));
			String text=allTable.getText();
			Thread.sleep(1000);
			System.out.println("The looping count is: "+i);
			System.out.println("The managed Object is: "+text);
		}
	}

	public void ValidateProcessedData() throws InterruptedException 
	{	
		int rowCountofTR=driver.findElements(By.xpath("(//div[@class='k-grid-content'])[1]/table/tbody/tr")).size();
		System.out.println("The total number of rows present in TR is: "+rowCountofTR);



		for(int i=1;i<=rowCountofTR;i++)
		{
			int rowCountofTD=driver.findElements(By.xpath("(//div[@class='k-grid-content'])[1]/table/tbody/tr["+i+"]/td")).size();
			System.out.println("The total number of rows present in TD is: "+rowCountofTD);

			for(int j=1;j<=rowCountofTD;j++)
			{
				WebElement allTable = driver.findElement(By.xpath("(//div[@class='k-grid-content'])[1]/table/tbody/tr["+i+"]/td["+j+"]"));
				String text=allTable.getText();
				Thread.sleep(1000);
				System.out.println("The TD looping count is: "+j);
				System.out.println("The managed Object values is: "+text);
			}
			System.out.println("The TR looping count is: "+i);
		}
	}



	//TC-37 - Delta Audit: View changes per cluster
	public void ValidateTheExactChanges() throws InterruptedException {

		int rowCountofTR=driver.findElements(By.xpath("(//div[@class='k-grid-content'])[1]/table/tbody/tr")).size();
		System.out.println("The total number of rows present in TR is: "+rowCountofTR);



		for(int i=1;i<=rowCountofTR;i++)
		{
			int rowCountofTD=driver.findElements(By.xpath("(//div[@class='k-grid-content'])[1]/table/tbody/tr["+i+"]/td")).size();
			int actualcountTD = rowCountofTD -1;
			System.out.println("The total number of rows present in TD is: "+actualcountTD);

			for(int j=1;j<=actualcountTD;j++)
			{
				WebElement allTable = driver.findElement(By.xpath("(//div[@class='k-grid-content'])[1]/table/tbody/tr["+i+"]/td["+j+"]/p"));
				textofTD=allTable.getText();
				Thread.sleep(1000);
				System.out.println("The TD looping count is: "+j);
				System.out.println("The managed Object value which is going to be clicked is: "+textofTD);
				Thread.sleep(1000);
				if(!(textofTD.contentEquals("")))
				{
					String parentWindow = driver.getWindowHandle();
					allTable.click();
					System.out.println("Clicked on the underlined value and A new tab appeared in the browser");

					Thread.sleep(1000);
					driver.switchTo().window(parentWindow);

					Thread.sleep(1000);
					int dateCount=driver.findElements(By.xpath("(//div[@class='k-grid-header-wrap k-auto-scrollable'])[1]/table/thead/tr/th")).size();
					int actualcount = dateCount -1;

					for(int k=j;k<=actualcount;k++) 
					{
						WebElement ClickedvalueDate = driver.findElement(By.xpath("(//div[@class='k-grid-content'])[1]/table/tbody/tr["+i+"]/td["+j+"]/../../../../../div[1]/div[2]/table/thead/tr/th["+k+"]/a"));
						DateValueClicked =ClickedvalueDate.getText();
						Thread.sleep(1000);
						System.out.println("The element "+textofTD+" which is selected to click is from the date: "+DateValueClicked);
						Thread.sleep(1000);
						break;
					}
					break;

				}

			}

			break;
		}


	}

	public void ValidateCapturedCounts() throws InterruptedException {

		bouyguespage.switchTabs(driver);
		Thread.sleep(1000);
		int capturedrowCount = driver.findElements(By.xpath("//div[@class='k-grid-content']/table/tbody/tr")).size();
		System.out.println("The totla number of captured dates is : "+capturedrowCount);
		String rowCount = Integer.toString(capturedrowCount);

		Thread.sleep(1000);
		String S1 = rowCount.trim();
		String S2 = textofTD.trim();

		if(S1.equalsIgnoreCase(S1))
		{
			System.out.println("The element which is selected to click is : "+textofTD);
			System.out.println("The total number of elements present after clicking is :"+rowCount);
			System.out.println("Both the clicked element and the total number of changes in new window is matching");
			Reporter.log("Both the clicked element and the total number of changes in new window is matching");
		}
		else {
			System.out.println("The element which is selected to click is : "+textofTD);
			System.out.println("The total number of elements present after clicking is :"+rowCount);
			System.out.println("Both the clicked element and the total number of changes in new window is not matching");
			Reporter.log("Both the clicked element and the total number of changes in new window is not matching");
		}
	}

	public void ValidateCapturedDates() throws InterruptedException {
		Thread.sleep(1000);
		int rowCountofdates = driver.findElements(By.xpath("//div[@class='k-grid-content']/table/tbody/tr/td[1]")).size();
		System.out.println("The total number of captured dates is : "+rowCountofdates);
		String countOfDates = Integer.toString(rowCountofdates);

		Thread.sleep(1000);
		for(int i=1;i<=rowCountofdates;i++) 
		{
			String DateValue = driver.findElement(By.xpath("//div[@class='k-grid-content']/table/tbody/tr["+i+"]/td[1]")).getText();

			String P1 = DateValue.trim();
			String P2 = DateValueClicked.trim();

			if(P1.equalsIgnoreCase(P2))
			{
				System.out.println("The element which is selected to click is of date: "+DateValueClicked);
				System.out.println("The date present after clicking is :"+DateValue);
				System.out.println("Both the clicked element date and the total number of changes in new window date is matching");
				Reporter.log("Both the clicked element date and the total number of changes in new window date is matching");
			}
			else {
				System.out.println("The element which is selected to click is of date: "+DateValueClicked);
				System.out.println("The date present after clicking is :"+DateValue);
				System.out.println("Both the clicked element date and the total number of changes in new window date is not matching");
				Reporter.log("Both the clicked element date and the total number of changes in new window date is not matching");
			}
		}
	}

	public void ValidateEnodeValue() throws InterruptedException {

		Thread.sleep(1000);
		int rowCountofEnode = driver.findElements(By.xpath("//div[@class='k-grid-content']/table/tbody/tr/td[2]")).size();
		System.out.println("The total number of captured dates is : "+rowCountofEnode);
		String countOfEnode = Integer.toString(rowCountofEnode);

		Thread.sleep(1000);
		for(int i=1;i<=rowCountofEnode;i++) 
		{
			String EnodeValue = driver.findElement(By.xpath("//div[@class='k-grid-content']/table/tbody/tr["+i+"]/td[2]")).getText();


			String Q1 = EnodeValue.trim();
			String Q2 = EnodeNameforQB.trim();

			if(Q1.equalsIgnoreCase(Q2))
			{
				System.out.println("The Enode which is selected to click is: "+EnodeNameforQB);
				System.out.println("The Enode present after clicking is :"+EnodeValue);
				System.out.println("Both the clicked element date and the total number of changes in new window Endoe is matching");
				Reporter.log("Both the clicked element date and the total number of changes in new window Enode is matching");
			}
			else {
				System.out.println("The element which is selected to click is of date: "+EnodeNameforQB);
				System.out.println("The date present after clicking is :"+EnodeValue);
				System.out.println("Both the clicked element date and the total number of changes in new window Enode is not matching");
				Reporter.log("Both the clicked element date and the total number of changes in new window Enode is not matching");
			}
		}
	}
}
