Feature: Adding multiple Gift Card and checking the total
  
  Scenario: Adding Rs 500 of 2 Card
    Given Intitiate Imp Steps for Gift Card functionality
    When Click the GiftCard link
    And Add 2 gift card quantity
    Then Click on Add to Cart
    And Check the final cart value
