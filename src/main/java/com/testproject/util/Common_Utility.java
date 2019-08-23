package com.testproject.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver.Timeouts;

import com.testproject.base.BaseTest;


public class Common_Utility extends BaseTest{
	
	public Timeouts wait = driver.manage().timeouts().implicitlyWait(10000,TimeUnit.SECONDS);

}
