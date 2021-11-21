#Background: Given Open the HomePage
Feature: Filter Validate

  Scenario: Validate Filter Low to High
    Given Intitiate Imp Steps for Filter functionality
    And Select All of it link
    When Apply filter low to high
    Then Check the price of product in ascending
    And close the browser

  Scenario: Validate Filter High to Low
    Given Intitiate Imp Steps for Filter functionality
    And Select All of it link
    When Apply filter high to low
    Then Check the price of product in descending
    And close the browser
