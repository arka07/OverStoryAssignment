package com.ericsson.edos.dopuatautomation.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.ericsson.edos.dopuatautomation.base.TestBase;

public class CallTerminationAnalysisPage extends TestBase {

	/*Inspecting WebElement for CTA HeaderText*/	
	@FindBy (xpath = "//span[contains(text(),'Termination')]")
	WebElement CTADashboardHeaderText;

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

	public  CallTerminationAnalysisPage() {

		PageFactory.initElements(driver , this);
	}

	Actions actions = new Actions(driver);
	List<String> CellValue = new ArrayList();

	/*Methods to Act on the WebDriver Webelements*/

	public String getCTAtitle() {

		return	driver.getTitle();
	}

	public String VerifyCTADashbaordHeaderTetxt() throws InterruptedException {
		Thread.sleep(2000);
		return CTADashboardHeaderText.getText();

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

		actions.moveToElement(CTADashboardHeaderText).click();

		for(int i=1;i<=27;i++){
			actions.sendKeys(Keys.ARROW_DOWN);
			actions.build().perform();
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

		actions.moveToElement(CallsDatagrid).click();

		for(int i=1;i<=27;i++){
			actions.sendKeys(Keys.ARROW_UP);
			actions.build().perform();
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
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();
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
		actions.sendKeys(Keys.ENTER);
		actions.build().perform();
	}
	
	public void OriginatingCellClear() {
	OriginatingCellSearch.clear();
}
	
	
}




