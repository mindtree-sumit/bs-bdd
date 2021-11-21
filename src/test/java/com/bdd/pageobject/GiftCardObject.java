package com.bdd.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCardObject {

	WebDriver driver;
	public GiftCardObject(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath = "//i[@class='fa fa-gift']") WebElement giftCardLink;
	@FindBy(xpath = "//*[@id=\"quantity\"]/../span") WebElement addQuantity;
	@FindBy(xpath = "//*[@name='add']/span") WebElement addToCart;
	@FindBy(xpath = "(//*[@class='cart__detail-info'])[2]/span/span") WebElement priceOfCart;
	
	public void ClickGiftCardLink() {
		giftCardLink.click();
	}
	
	public void AddingQuantity(int i) {
		for (int j = 1; j < i; j++) {
			addQuantity.click();
		}
	}
	public void AddToCart() {
		addToCart.click();
	}
	
	public String TotalPriceOfCart() {
		return priceOfCart.getText();
	}
	
}
