package stepdefinitions;

import org.testng.Assert;

import com.pageobjects.HeaderBanner;
import com.pageobjects.LoginPage;
import com.utils.Base;
import com.utils.Literals;
import com.utils.Loggers;
import com.utils.Waits;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	Base base;
	HeaderBanner headerBanner;
	Loggers logger;
	LoginPage loginPage;
	Waits waits;
	
	public LoginSteps(Base base) {
		this.base = base;
		headerBanner = base.getPageObjectManager().getHeaderBanner();
		logger = base.getLoggers(this.getClass().getSimpleName());
		loginPage = base.getPageObjectManager().getLoginPage();
		waits = base.getWaits();
	}
	
	@Given("^that I am in the application landing page$")
	public void that_I_am_in_the_application_landing_page() {
		waits.untilElementIsVisible(loginPage.txtUsername);
		Assert.assertTrue(loginPage.txtUsername.isDisplayed());
		logger.logInfo("Navigated to landing page.");
	}
	
	@When("^I login as a standard user$")
	public void I_login_as_a_standard_user() {
		loginPage.login(Literals.VALID_USERNAME, Literals.VALID_PASSWORD);
		logger.logInfo("Entered valid USERNAME: ", Literals.VALID_USERNAME, " and PASSWORD: ", Literals.VALID_PASSWORD);
	}
	
	@When("^I login without a username$")
	public void i_login_without_a_username() {
		loginPage.login("", Literals.VALID_PASSWORD);
		logger.logInfo("USERNAME is empty.");
	}
	
	@When("^I login without a password$")
	public void i_login_without_a_password() {
		loginPage.login(Literals.VALID_USERNAME, "");
		logger.logInfo("PASSWORD is empty.");
	}
	
	@When("^I login with invalid username$")
	public void I_login_with_invalid_username() {
		loginPage.login(Literals.INVALID_USERNAME, Literals.VALID_PASSWORD);
		logger.logInfo("Entered an invalid USERNAME: ", Literals.INVALID_USERNAME);
	}
	
	@When("^I login with invalid password$")
	public void I_login_with_invalid_assword() {
		loginPage.login(Literals.VALID_USERNAME, Literals.INVALID_PASSWORD);
		logger.logInfo("Entered an invalid PASSWORD: ", Literals.INVALID_PASSWORD);
	}
	
	@Then("^I am successfully logged in to the application$")
	public void I_am_successfully_logged_in_to_the_application() {
		waits.untilElementIsVisible(headerBanner.icnMenu);
		Assert.assertTrue(headerBanner.icnMenu.isDisplayed());
		logger.logInfo("Logged in successfully.");
	}
	
	@Then("^a login error is displayed that Password is required$")
	public void a_login_error_is_displayed_that_Password_is_required() {
		waits.untilElementIsVisible(loginPage.txtErrorMessage);
		Assert.assertEquals(loginPage.getErrorMessage(), Literals.ERR_PASSWORD_REQUIRED);
		logger.logInfo("PASSWORD is required.");
	}
	
	@Then("^a login error is displayed that Username is required$")
	public void a_login_error_is_displayed_that_Username_is_required() {
		waits.untilElementIsVisible(loginPage.txtErrorMessage);
		Assert.assertEquals(loginPage.getErrorMessage(), Literals.ERR_USERNAME_REQUIRED);
		logger.logInfo("USERNAME is required.");
	}
	
	@Then("^a login error is displayed that credentials are invalid$")
	public void a_login_error_is_displayed_that_credentials_are_invalid() {
		waits.untilElementIsVisible(loginPage.txtErrorMessage);
		Assert.assertEquals(loginPage.getErrorMessage(), Literals.ERR_CREDENTIALS_DONT_MATCH);
		logger.logInfo("Credentials are invalid.");
	}
}
