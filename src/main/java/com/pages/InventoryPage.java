package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
	private WebDriver driver;
	
	//1. By locators:
	public By getInventoryItem(String itemName){
		By itm = By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_name' and contains(text(),'"+itemName+"')]");
		return itm;
	}
	public By getInventoryItemAction(String itemName, String action){// action include: Remove, Add to cart
		By itm = By.xpath("//div[contains(text(),'"+itemName+"')]/ancestor::div[@class ='inventory_item_label']/following-sibling::div/button[contains(text(),'"+action+"')]");
		return itm;
	}
	public By getInventoryItemPrice(String itemName){
		By itm = By.xpath("//div[contains(text(),'"+itemName+"')]/ancestor::div[@class ='inventory_item_label']/following-sibling::div/div[@class ='inventory_item_price']");
		return itm;
	}	
	public By getProductDetailAction(String action){//action include: Remove, Add to cart
		By itm = By.xpath("//div[@class ='inventory_details']//button[contains(text(),'"+action+"')]");
		return itm;
	}		
	private By getInventoryCartLink = By.xpath("//a[@class ='shopping_cart_link']");
	public static By getCartBadge = By.xpath("//span[@class ='shopping_cart_badge']");
	
	//2. Constructor of the page class:
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
	}
	//3. page actions: Feature(behavior) of the page the form of method:
	
	// Go to inventory item detail
	public void gotoInventoryDetail(String itemName) {
		driver.findElement(getInventoryItem(itemName)).click();
	}
	
	// Action on inventory item: Remove or Add to cart
	public void InventoryItemAction(String itemName, String action) {
		System.out.println(action +" product Item: "+itemName);
		driver.findElement(getInventoryItemAction(itemName, action)).click();
	}
	// Action on inventory item: Remove or Add to cart
	public void InventoryItemAction(String action) {
		System.out.println(action +" product Item");
		driver.findElement(getProductDetailAction(action)).click();
	}	
	// Go to Cart
	public void gotoCart() {
		driver.findElement(getInventoryCartLink).click();
	}
	// get badge number
	public String CartBadge() {
		return driver.findElement(getCartBadge).getText();
	}

}
