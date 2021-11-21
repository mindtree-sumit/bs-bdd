package com.bdd.stepdefinition;

import static org.testng.Assert.assertEquals;

import com.bdd.pageobject.WishListObject;

import io.cucumber.java.en.*;

public class WishListSteps extends BaseClass{

	private WishListObject wl;
	
	@Given("Intitiate Imp Steps for WishList functionality")
	public void intitiate_imp_steps_for_wish_list_functionality() {
		driver = setup();
		wl= new WishListObject(driver);
	}
	
	@Given("Select Top50 ShopCat link")
	public void select_top50_shop_cat_link() {
		wl.TopProduct();
	}

	@When("Add {int} product in wishlist")
	public void add_product_in_wishlist(int int1) {
		for (int i = 1; i <= int1; i++) {
			wl.wishListingItem(i);
			wl.ClickHeart();
			if(i<int1)
				driver.navigate().back();
		}
	}
	
	@When("Click on WishList cart")
	public void Click_on_wish_list_cart() {
	   wl.ClickOnWishList();
	}
	
	@Then("Validate the number of product in wishlist")
	public void validate_the_number_of_product_in_wishlist() {
		int actual = wl.NumWishListItems();
		assertEquals(actual, 2);
	}

}
