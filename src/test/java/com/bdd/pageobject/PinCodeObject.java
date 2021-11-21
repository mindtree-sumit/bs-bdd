package com.bdd.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinCodeObject {
	
	WebDriver driver;

	public PinCodeObject(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//div[@class='grid-product__title']") WebElement itemOnHomepage;
	@FindBy(id = "PostalCode") WebElement postCodeBox;
	@FindBy(xpath = "//*[@id=\"cod-cheker\"]/button") WebElement checkPinBtn;
	By pinBox = By.id("PostalCode");
	
	public void SelectProductOnHP() {
		itemOnHomepage.click();
	}

	public void PinCheck(int int1) {
		postCodeBox.sendKeys(String.valueOf(int1));
		checkPinBtn.click();
	}

}
