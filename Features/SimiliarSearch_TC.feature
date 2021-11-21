
Feature: Search the item and check relevant product is display

  Scenario: Is search page show similar product
    Given Intitiate Imp Steps for RelevantSearch functionality
    When Item "Chain" search in SearchBox
    Then Search Result show similar item searched
    And Evaluate the items show and close the browser
