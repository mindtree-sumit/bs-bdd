package com.bdd.stepdefinition;

import static org.testng.Assert.assertTrue;

import com.bdd.pageobject.SignInPage;

import io.cucumber.java.en.*;

public class SignInSteps extends BaseClass{

	private SignInPage sp;
	
	@Given("Intitiate Imp Steps for SignIn Validation functionality")
	public void intitiate_imp_steps_for_sign_in_validation_functionality() {
		driver = setup();
	   sp = new SignInPage(driver);
	}
	@When("Open the Sign in Page")
	public void open_the_sign_in_page() {
		sp.OpenSignLink();
	}
	@When("Enter the username as {string} and password as {string}")
	public void enter_the_username_as_and_password_as(String string, String string2) {
		sp.SignInToStore(string, string2);
	}
	@Then("Evaluate the valid SignIn validation")
	public void evaluate_the_valid_sign_in_validation() {
		if(driver.getPageSource().contains("iframe"))
			System.out.println("------ Captcha required ------");
		else
			assertTrue(driver.getPageSource().contains("Log Out"), "Sign in Success");
	}

	@Then("Evaluate the invalid SignIn validation")
	public void evaluate_the_invalid_sign_in_validation() {
		if(driver.getPageSource().contains("iframe")) 
			System.out.println("------ Captcha required ------");
		else
			assertTrue(driver.getPageSource().contains("Incorrect email or password"), "Sign expected behaviour");
	}


}
