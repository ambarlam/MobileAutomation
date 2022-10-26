Feature: Login

  @login
  Scenario: Valid Login to the Application
    Given that I am in the application landing page
    When I login as a standard user
    	| standard_user |
    	| secret_sauce	|
    Then I am successfully logged in to the application