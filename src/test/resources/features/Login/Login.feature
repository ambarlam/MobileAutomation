@login
Feature: Login
	Validate the login feature for SwagLabs mobile application

	Background:
		Given that I am in the application landing page

	@validCredentials
  Scenario: Valid Login to the Application
    When I login as a standard user
    Then I am successfully logged in to the application
  
  @requiredFields
  Scenario: Login attempt with blank Username
  	When I login without a username
  	Then a login error is displayed that Username is required
  	
  @requiredFields
  Scenario: Login attempt with blank Password
  	When I login without a password
  	Then a login error is displayed that Password is required
    
  @invalidCredentials
  Scenario: Login attempt with invalid username
  	When I login with invalid username
  	Then a login error is displayed that credentials are invalid
  	
  @invalidCredentials
  Scenario: Login attempt with invalid password
  	When I login with invalid password
  	Then a login error is displayed that credentials are invalid