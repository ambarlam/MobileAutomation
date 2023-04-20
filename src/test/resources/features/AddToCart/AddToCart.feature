@AddToCart
Feature: Add to cart
	Validate the add-to-cart feature for SwagLabs mobile application

	Background:
		Given That I am succefully logged in the application

	@singleItem
  Scenario: Add a product to the cart, click view cart to navigate to the cart and verify the added product
	  When I click Add to cart button of the product Sauce Labs Backpack
    Then The Add to cart button text label change to Remove
    And The cart badge increased
    
    When I click on the View cart button
    Then I am redirect to the Cart page
    And the product name shows Sauce Labs Bike Light