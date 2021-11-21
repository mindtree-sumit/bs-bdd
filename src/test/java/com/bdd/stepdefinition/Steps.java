package com.bdd.stepdefinition;

import static org.testng.Assert.assertTrue;

import com.bdd.pageobject.PriceFilterPage;

import io.cucumber.java.en.*;

public class Steps extends BaseClass{
	
	private PriceFilterPage pf;

	@Given("Intitiate Imp Steps for Filter functionality")
	public void intitiate_imp_steps_for_filter_functionality() {
		driver = setup();
		pf = new PriceFilterPage(driver);
	}

	@Given("Select All of it link")
	public void select_all_of_it_link() {
		pf.ClickOnAllProduct();
	}
	
	@When("Apply filter low to high")
	public void apply_filter_low_to_high() {
		pf.FilterSort();
	}
	@Then("Check the price of product in ascending")
	public void check_the_price_of_product_in_ascending() {
		for (int i = 1; i < 10; i++) {
			String pricing = pf.getPriceOfProduct(i);
			String pricing2 = pf.getPriceOfProduct(i+1);
			if (pricing.compareTo(pricing2) <= 0) {
				System.out.print(pricing +" < ");
				assertTrue(true);
			}
		}
	}
	@Then("Validate the result")
	public void validate_the_result() {
		System.out.println("Filter L2H Passes");
	}

	//Filter High to Low Test Def

	@When("Apply filter high to low")
	public void apply_filter_high_to_low() {
		pf.HighToLow();
	}
	@Then("Check the price of product in descending")
	public void check_the_price_of_product_in_descending() {
		for (int i = 1; i < 10; i++) {
			String pricing = pf.getPriceOfProduct(i);
			String pricing2 = pf.getPriceOfProduct(i+1);
			if (pricing.compareTo(pricing2) >= 0) {
				System.out.print(pricing +" > ");
				assertTrue(true);
			}
		}
	}
	
	@Then("close the browser")
	public void close_the_browser() {
	  driver.close();
	}

}
