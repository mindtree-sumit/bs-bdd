package com.bdd.stepdefinition;

import static org.testng.Assert.assertTrue;

import com.bdd.pageobject.SearchProductObject;

import io.cucumber.java.en.*;

public class RelevantSearch extends BaseClass {

	private SearchProductObject sp;
	String searched;
	boolean flag;

	@Given("Intitiate Imp Steps for RelevantSearch functionality")
	public void intitiate_imp_steps_for_relevant_search_functionality() {
		driver = setup();
		sp = new SearchProductObject(driver);
	}

	@When("Item {string} search in SearchBox")
	public void item_search_in_search_box(String string) {
		sp.SearchProduct(string);
		searched = string;
	}

	@Then("Search Result show similar item searched")
	public void search_result_show_similar_item_searched() {
		for (int i = 1; i < 10; i++) {
			if (sp.ProductListName(i).contains(searched))
				flag = true;
			else if (!(sp.ProductListName(i).contains(searched)))
				flag = false;
		}
	}

	@Then("Evaluate the items show and close the browser")
	public void evaluate_the_items_show_and_close_the_browser() {
		assertTrue(flag, "All matching item");
//		assertTrue(flag, "Item irrelevant found");
		driver.close();
	}

}
