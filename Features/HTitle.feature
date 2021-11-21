Feature: Validate the shop category header title Validation

  Scenario: Title Validation of Shop Page
    Given Intitiate Imp Steps for Title Validation functionality
    When Hover ShopByCat and click socks
    Then Compare the title with select category
    And Evaluate section title and close the browser
