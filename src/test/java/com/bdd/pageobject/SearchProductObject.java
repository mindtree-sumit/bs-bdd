package com.bdd.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProductObject {

	WebDriver driver;

	public SearchProductObject(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//input[@type='search']") WebElement searchBox;
	
	String productList = "(//*[@class='snize-title'])[";
	
	public void SearchProduct(String pname) {
		searchBox.sendKeys(pname, Keys.RETURN);
	}
	
	public String ProductListName(int i) {
		return driver.findElement(By.xpath(productList +i+ "]")).getText();
	}
	
}
