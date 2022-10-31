package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	//1. By locators:
	private By userNameID = By.xpath("//input[@id='user-name']");
	private By password = By.xpath("//input[@id='password']");
	private By loginButton = By.xpath("//input[@id='login-button']");
	private By errorMessage = By.xpath("//h3[@data-test ='error']");	
	//2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	//3. page actions: Feature(behavior) of the page the form of method:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}	
	public void enterUserName (String userName) {
		driver.findElement(userNameID).sendKeys(userName);
	}
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void clickOnLogin() {
		driver.findElement(loginButton).click();
	}
	public String errorMessageText() {
		return driver.findElement(errorMessage).getText();
	}	
	public void login(String usn, String pwd) {
		System.out.println("login with userName: "+usn +" passWord: "+pwd);
		enterUserName(usn);
		enterPassword(pwd);
		clickOnLogin();
	}
}
