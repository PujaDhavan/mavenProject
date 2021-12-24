package com.mt.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
	
	@FindBy(partialLinkText = "SIGN-ON")
	WebElement signon;
	
	@FindBy(name = "userName")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "submit")
	WebElement submit_btn;
	
	@FindBy(partialLinkText = "SIGN-OFF")
	WebElement SIGN_OFF;
	
	public void login(String uname,String pass)
	{
		
		signon.click();
		userName.sendKeys(uname);
		password.sendKeys(pass);
		submit_btn.click();
		System.out.println("hi");
	}
	public void signoff()
	{
		SIGN_OFF.click();
	}
	
	
	

}
