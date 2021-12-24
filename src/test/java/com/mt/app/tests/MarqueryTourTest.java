package com.mt.app.tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.mt.app.pages.RegistrationPage;
import com.mt.app.pages.loginPage;
import com.mt.app.utility.Config;

public class MarqueryTourTest {

	Properties p = new Properties();
	public static WebDriver driver;
	static Logger log = Logger.getLogger(MarqueryTourTest.class.getName());

	static XSSFWorkbook book;
	static XSSFSheet sheet;

	@BeforeSuite
	public void openBrowser() {
		log.info("Execution Before Suite -Opening Browser");
		driver = Config.getDriver();
	}

	@BeforeTest
	public void openUrl() throws IOException {
		log.info("Execution Before Test- Opening URL");

		FileInputStream fis = new FileInputStream("E:\\HybridDriven\\hybrideDriven.xlsx");
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet("Sheet1");
		book.getNumberOfSheets();


		String url = sheet.getRow(2).getCell(4).getStringCellValue();

		FileInputStream fis2 = new FileInputStream("E:\\HybridDriven\\MtRegister.properties");
		p.load(fis2);
		driver.get(p.getProperty(url));
	}

	@BeforeClass
	public void maximizeWindow() {
		log.info("Executiog Before Class-Maximize Browser");
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {

		Set<Cookie> coo = driver.manage().getCookies();

		for (Cookie cookie : coo) {

			log.info("Cookie Name : " + cookie.getName());
		}
		log.info("Before method get cookies");
	}

	@Test
	public void Registarion() throws IOException {
		log.info("Executing Registration Test");

		String fname1 = sheet.getRow(3).getCell(4).getStringCellValue();
		String lname1 = sheet.getRow(4).getCell(4).getStringCellValue();
		String phone1 = sheet.getRow(5).getCell(4).getStringCellValue();
		String email1 = sheet.getRow(6).getCell(4).getStringCellValue();
		String add11 = sheet.getRow(7).getCell(4).getStringCellValue();
		String city1 = sheet.getRow(8).getCell(4).getStringCellValue();
		String state1 = sheet.getRow(9).getCell(4).getStringCellValue();
		String pin1 = sheet.getRow(10).getCell(4).getStringCellValue();
		String country1 = sheet.getRow(11).getCell(4).getStringCellValue();
		String uname1 = sheet.getRow(12).getCell(4).getStringCellValue();
		String pass1 = sheet.getRow(13).getCell(4).getStringCellValue();
		String cpass1 = sheet.getRow(14).getCell(4).getStringCellValue();
		// System.out.println(fname + lname + phone + email + add1 + city + state + pin
		// + country + uname + pass + cpass);

		RegistrationPage rp = PageFactory.initElements(driver, RegistrationPage.class);
		rp.Register(p.getProperty(fname1), p.getProperty(lname1), p.getProperty(phone1), p.getProperty(email1),
				p.getProperty(add11), p.getProperty(city1), p.getProperty(state1), p.getProperty(pin1),
				p.getProperty(country1), p.getProperty(uname1), p.getProperty(pass1), p.getProperty(cpass1));
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://demo.guru99.com/test/newtours/register_sucess.php");
		FileOutputStream fos = new FileOutputStream("E:\\HybridDriven\\hybrideDriven.xlsx");

		sheet.getRow(3).createCell(5).setCellValue("Pass");
		book.write(fos);
		rp.register_signoff();
	}

	@Test(priority = 1)
	public void loginDemo() throws IOException {
		log.info("Executing Login Test");

		String uname = sheet.getRow(17).getCell(4).getStringCellValue();
		String pass = sheet.getRow(18).getCell(4).getStringCellValue();
		log.info(uname + pass);
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.login(p.getProperty(uname), p.getProperty(pass));

		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, "http://demo.guru99.com/test/newtours/login_sucess.php");
		FileOutputStream fos = new FileOutputStream("E:\\HybridDriven\\hybrideDriven.xlsx");

		sheet.getRow(17).createCell(5).setCellValue("Pass");
		book.write(fos);
		lp.signoff();

	}

	@AfterMethod
	public void afterMethod() throws IOException {

		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyToDirectory(sourceFile, new File("E:\\CucumberDemoLogs\\screnshots"));
		log.info("After method Screenshot taken");
	}

	@AfterClass
	public void m1() {
		log.info("Excecution After Class");
	}

	@AfterTest
	public void m2() {
		log.info("Execution After Test");
	}

	@AfterSuite
	public void afterSuite() {

		driver.close();
		log.info("Execution After suite -Driver close");

	}
}
