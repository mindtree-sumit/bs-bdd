package com.bdd.stepdefinition;

import static org.testng.Assert.assertTrue;

import com.bdd.pageobject.GiftCardObject;

import io.cucumber.java.en.*;

public class GiftCardSteps extends BaseClass{
	
	public GiftCardObject gc;
	String value;

	@Given("Intitiate Imp Steps for Gift Card functionality")
	public void Intitiate_Imp_Steps_for_Gift_Card_functionality() {
//		InitiateDriver();
		driver = setup();
		gc = new GiftCardObject(driver);
	}
	@When("Click the GiftCard link")
	public void click_the_gift_card_link() {
		gc.ClickGiftCardLink();
	}

	@When("Add {int} gift card quantity")
	public void add_gift_card_quantity(int int1) {
		gc.AddingQuantity(int1);
		value = String.format("%,d", 500 *int1);
		System.out.println(value);
	}

	@Then("Click on Add to Cart")
	public void click_on_add_to_cart() {
		gc.AddToCart();
	}
	
	@Then("Check the final cart value")
	public void check_the_final_cart_value() {
		System.out.println(gc.TotalPriceOfCart());
		assertTrue(value.contains(gc.TotalPriceOfCart()), "Passed");
		driver.quit();
	}
	
	
}
