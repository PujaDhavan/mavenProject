package com.mt.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {
	
	@FindBy(name = "firstName")
	WebElement firstName;
	
	@FindBy(name = "lastName")
	WebElement lastName;
	
	@FindBy(name = "phone")
	WebElement phone;
	
	@FindBy(name = "userName")
	WebElement userName;
	
	@FindBy(name = "address1")
	WebElement address1;
	
	@FindBy(name = "city")
	WebElement city;
	
	@FindBy(name = "state")
	WebElement statee;
	
	@FindBy(name = "postalCode")
	WebElement postalCode;
	
	@FindBy(name = "country")
	WebElement country;
	
	@FindBy(name = "email")
	WebElement emaill;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "confirmPassword")
	WebElement confirmPassword;
	
	@FindBy(name = "submit")
	WebElement submit_button;
	
	@FindBy(partialLinkText = "REGISTER")
	WebElement registerbutton;
	
	public void Register(String fname,String lname,String phonne,String email,String add1,String citty,String state,String pin,String countryy,String uname,String pass,String cpass)
	{
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		phone.sendKeys(phonne);
		userName.sendKeys(email);
		address1.sendKeys(add1);
		city.sendKeys(citty);
		statee.sendKeys(state);
		postalCode.sendKeys(pin);
		Select s=new Select(country);
		s.selectByVisibleText(countryy);
		emaill.sendKeys(uname);
		password.sendKeys(pass);
		confirmPassword.sendKeys(cpass);
		submit_button.click();
		
	}
	
	public void register_signoff()
	{
		registerbutton.click();
	}
}
