package com.mt.app.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Config {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Lenovo\\Desktop\\Testing\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
		
	}

}
