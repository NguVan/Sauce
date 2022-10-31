package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ElementUtil {
	private static WebDriver driver;
	public static void waitUntilClickable(By element) {
		WebDriverWait wait = new WebDriverWait(driver,Constants.Time);
				wait.until(ExpectedConditions.elementToBeClickable(element));
	}	
	public static void waitUntilInvisible(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.Time);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}	
	public static boolean isInvisibilityOfElementLocated(By element){
    	try{
    		WebDriverWait wait = new WebDriverWait(driver, Constants.Time);
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    	    return true;
    	}catch(Exception e){
    	    return false;
    	}
	}
	public static void waitAndClick(By element) {
		waitUntilClickable(element);
		driver.findElement(element).click();;
	}
	public static void waitAndSendkey(By element) {
		waitUntilClickable(element);
		driver.findElement(element).click();;
	}
}
