package com.bdd.stepdefinition;

import static org.testng.Assert.assertTrue;

import com.bdd.pageobject.PinCodeObject;

import io.cucumber.java.en.*;

public class PinCodeSteps extends BaseClass{

	private PinCodeObject pc;

	@Given("Intitiate Imp Steps for pincode Validation functionality")
	public void intitiate_imp_steps_for_pincode_validation_functionality() {
		driver = setup();
		pc = new PinCodeObject(driver);
	}
	@When("Go to the product decription page")
	public void go_to_the_product_decription_page() {
		pc.SelectProductOnHP();
	}
	@When("Enter the {int} pincode")
	public void enter_the_pincode(int int1) {
		pc.PinCheck(int1);
	}
	@Then("Evaluate the valid pin validation")
	public void evaluate_the_valid_pin_validation() {
		assertTrue(driver.getPageSource().contains("Expected delivery"), "Pin code validated");
	}
	
	@Then("Evaluate the invalid pin validation")
	public void evaluate_the_invalid_pin_validation() {
		assertTrue(driver.getPageSource().contains("not available"), "Pin code validated");
		
	}

}
