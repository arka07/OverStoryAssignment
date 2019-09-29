package com.OvenStory.Assignment.base;
import java.io.File;
import java.io.IOException;

import java.util.Date;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;

import org.testng.annotations.BeforeSuite;

import com.OvenStory.Assignment.util.Testutil;



public class TestBase extends Lib {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;

	static{
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	    
	}
	 
	
	public static String url;
	@BeforeSuite
	public static void initialisation() throws InterruptedException
	{   
		
		
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
		url = Lib.getProperty(CONFIG_PATH, "URL");
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
	
	 @AfterSuite
		public void tearDown()
		{try{
		    driver.quit();
		   }catch (Exception e){
			   System.out.println(e.getMessage()+ "Nothing to do with it");
		      }
		}   
	
	
	
}
