package com.ericsson.NDOrnd.dopuatautomation.base;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.ericsson.NDOrnd.dopuatautomation.util.Testutil;



public class TestBase extends Lib {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;

	static{
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	    
	}
	 
	List<String> Customername = new ArrayList<>();
    List<String> Projectname = new ArrayList<>();
	
	@BeforeSuite
	public static void initialisation() throws InterruptedException
	{   
		
		/*ChromeOptions options =new ChromeOptions();
		//options.setExperimentalOption(name: "prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);*/
	
		String browserName = Lib.getProperty(CONFIG_PATH, "browserName");
		if (browserName.equals("chrome")) 
		{
			driver = new ChromeDriver();
		} 
		else if(browserName.equals("FireFox")){
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new InternetExplorerDriver();
		}
		
	    wait = new WebDriverWait(driver,150);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String url = Lib.getProperty(CONFIG_PATH, "URL");
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(Testutil.Page_load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.Implicit_wait, TimeUnit.SECONDS);
		
	}
	
	
	public void getScreenshot(String result) throws IOException 
    {
		    Date d = new Date();
		   String currentdate = d.toString().replaceAll(":", "_");
		
           File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           File dest = new File(".\\Screenshots\\"+currentdate+"\\"+result+"_screenshot.png");
           FileUtils.copyFile(src,dest); 
         
    }

     public List<String> VerifyCustomerName(WebElement ArwClk,List<WebElement> CNameSize,String CnameText) throws InterruptedException {
    	 Customername.removeAll(Customername);
    	 ArwClk.click();	
    	 Thread.sleep(2000);
    	 //System.out.println("obj::"+CNameSize.toString());
    	 int Customercount= (CNameSize).size();
    	 System.out.println("CustomerCount::"+Customercount );
    	 for(int i=1;i<= Customercount;i++) {
    		 
    		WebElement CusName=  driver.findElement(By.xpath(CnameText+"[" + i +"]"));
//    	    String Cname= CusName.getText();
    	    Customername.add(CusName.getText());
    	    Thread.sleep(2000);
    	    System.out.println(CusName.getText());
    	    
    	}

    //    	return  Customercount;
        	 
    	  return Customername;
     }
     
     public static String[] getCustomerName() {
    	   
    		String[] ar= Lib.getProperty(CONFIG_PATH, "CustomerName").split(",");
    		for(int i=0; i<ar.length;i++) {
    			System.out.println(ar[i]);
    			}
    		return ar;
     }
     
     
	/*
	 * public void VerifyCustomerName(WebElement ArwClk,WebElement
	 * CNameSize,WebElement CnameText) throws InterruptedException {
	 * 
	 * 
	 * clickProjectDD.click(); Thread.sleep(2000); int Customercount=
	 * driver.findElements(By.xpath(
	 * "//div[contains(@class,'tree__tree')]/ul/li/span")).size(); for(int i=1;i<=
	 * Customercount;i++) {
	 * 
	 * WebElement CusName= driver.findElement(By.xpath(
	 * "(//div[contains(@class,'tree__tree')]/ul/li/span)["+i+"]")); String Cname=
	 * CusName.getText(); Customername.add(Cname); System.out.println(Customername);
	 * 
	 * } }
	 */
     
	
	 @AfterSuite
		public void tearDown()
		{try{
		    driver.quit();
		   }catch (Exception e){
			   System.out.println(e.getMessage()+ "Nothing to do with it");
		      }
		}   
	
	
	
}
