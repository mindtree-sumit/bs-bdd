package com.bdd.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="Features",
		glue="com.bdd.stepdefinition",
		dryRun=false, 
		plugin= {"pretty", "html:test-output2.html"},
		monochrome=true
		)

public class TestRun extends AbstractTestNGCucumberTests{

}
