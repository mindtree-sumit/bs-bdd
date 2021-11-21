Feature: Add mulitple product and checking the item in wishlist

  Scenario: Adding product in wishlist and check final wishlisted
    Given Intitiate Imp Steps for WishList functionality
    And Select Top50 ShopCat link
    When Add 2 product in wishlist
    And Click on WishList cart
    Then Validate the number of product in wishlist
    And close the browser
