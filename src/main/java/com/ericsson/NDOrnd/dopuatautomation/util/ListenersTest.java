package com.ericsson.NDOrnd.dopuatautomation.util;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.ericsson.NDOrnd.dopuatautomation.base.TestBase;

public class ListenersTest implements ITestListener{
	
	TestBase tb = new TestBase();
	
   
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("END Of Execution(TEST)->"+arg0.getName());
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
		 System.out.println("Start Of Execution(TEST)->"+arg0.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		//screenshot
		
		System.out.println("\033[31;1m"+"Test Failed->"+"\033[0m" +"\033[31;1m"+result.getName()+"\033[0m");
		
		
		try {
			tb.getScreenshot(result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("\033[34m"+"Test Started->"+"\033[34m" +"\033[34m"+arg0.getName()+"\033[34m");
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		 System.out.println("\033[32;1;2m"+"Test Pass->"+"\033[0m" +"\033[32;1;2m"+arg0.getName()+"\033[0m");
	}

}
