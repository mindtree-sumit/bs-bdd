package com.bdd.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListObject{
	
	WebDriver driver;
	
	public WishListObject(WebDriver ldriver) {
		this.driver = ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//*[@data-dropdown-rel='top-50']") WebElement top50;
	@FindBy(xpath="(//*[@class='grid-product__title'])") WebElement prlink1;
	@FindBy(xpath="(//*[@class='grid-product__title'])[2]") WebElement prlink2;
	@FindBy(className = "swym-wishlist-cta") WebElement Wishlisting; //add to wishlist
	@FindBy(xpath = "//span[text()='wish list']") WebElement WishLink;  // wishlist heart icon
	By wishListItems =  By.xpath( "//*[@class='swym-price swym-text-color']") ; //wishlist cart item content
	@FindBy(xpath = "//*[text()='Access My Wishlist']") WebElement accessWishlist;
	
	public void TopProduct() {
		top50.click();
	}
	
	String plink = "(//div[@class='grid-product__title'])[";
	
	public void ClickonProduct1() {
		prlink1.click();
	}
	
	public void ClickonProduct2() {
		prlink2.click();
	}
	
	public void ClickHeart() {
		try {
			Thread.sleep(3000);
			Wishlisting.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int NumWishListItems() {
		return driver.findElements(wishListItems).size();
	}

	public void wishListingItem(int i) {
		driver.findElement(By.xpath(plink+i+"]")).click();
	}

	public void ClickOnWishList() {
		WishLink.click();
		accessWishlist.click();
	}

}
