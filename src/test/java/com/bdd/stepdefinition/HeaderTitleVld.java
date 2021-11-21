package com.bdd.stepdefinition;

import static org.testng.Assert.assertEquals;

import com.bdd.pageobject.HomePage;

import io.cucumber.java.en.*;

public class HeaderTitleVld extends BaseClass{

	private HomePage hp;
	String title;
	
	@Given("Intitiate Imp Steps for Title Validation functionality")
	public void intitiate_imp_steps_for_title_validation_functionality() {
		driver = setup();
		hp = new HomePage(driver);
	}
	@When("Hover ShopByCat and click socks")
	public void hover_shop_by_cat_and_click_socks() {
		hp.ClickOnSocks();
	}
	
	@When("Select the first Product")
	public void select_the_first_product() {
		hp.ClickOnFirstProduct();
	}

	@Then("Compare the title with select category")
	public void compare_the_title_with_select_category() {
		title = hp.ShopTitleHeader();
	}

	@Then("Evaluate section title and close the browser")
	public void evaluate_section_title_and_close_the_browser() {
		assertEquals(title, "Socks");
		driver.quit();
	}



}
