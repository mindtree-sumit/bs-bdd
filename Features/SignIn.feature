Feature: Sign in to the bigsmall account

    Scenario: Validate Sign in with valid test data
    Given Intitiate Imp Steps for SignIn Validation functionality
    When Open the Sign in Page
    And Enter the username as "satox63548@idrct.com" and password as "Selenium"
    Then Evaluate the valid SignIn validation
    And close the browser
    
    Scenario Outline: Validate Signin with invalid test data
    Given Intitiate Imp Steps for SignIn Validation functionality
    When Open the Sign in Page
    And Enter the username as <uname> and password as <pw>
    Then Evaluate the invalid SignIn validation
    And close the browser
    
    Examples:
    	| uname 								|  pw 			 |							
    	|"satox63548@idrct.com"	| "pass@123" |
    	|"sumit@mail.com"				|	"Selenium" |
