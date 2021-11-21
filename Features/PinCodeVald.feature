
Feature: PinCode Validate for valid and invalid test case

  Scenario Outline: Validate pin code for valid test data
    Given Intitiate Imp Steps for pincode Validation functionality
    When Go to the product decription page
    And Enter the <valid> pincode 
    Then Evaluate the valid pin validation
    And close the browser
    
    Examples:
			|valid |
			|121001|
			|110066|
    
    Scenario Outline: Validate pin code for invalid test data
    Given Intitiate Imp Steps for pincode Validation functionality
    When Go to the product decription page
    And Enter the <invalid> pincode 
    Then Evaluate the invalid pin validation
    And close the browser
    
    Examples:
    	| invalid |
    	|000000|
    	|999990|

