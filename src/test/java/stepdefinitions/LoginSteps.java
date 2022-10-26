package stepdefinitions;

import java.util.List;

import org.testng.Assert;

import com.pageobjects.HeaderBanner;
import com.pageobjects.LoginPage;
import com.utils.Base;
import com.utils.Waits;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	Base base;
	LoginPage loginPage;
	HeaderBanner headerBanner;
	Waits waits;
	
	public LoginSteps(Base base) {
		this.base = base;
		loginPage = base.getPageObjectManager().getLoginPage();
		headerBanner = base.getPageObjectManager().getHeaderBanner();
		waits = base.getWaits();
	}
	
	@Given("that I am in the application landing page")
	public void that_I_am_in_the_application_landing_page() {
		waits.untilElementIsVisible(10, loginPage.imgSwagLabs);
		Assert.assertTrue(loginPage.imgSwagLabs.isDisplayed());
	}
	
	@When("I login as a standard user")
	public void I_login_as_a_standard_user(DataTable userDetails) {
		List<String> details = userDetails.asList(String.class); 
		loginPage.login(details.get(0), details.get(1));
	}
	
	@Then("I am successfully logged in to the application")
	public void I_am_successfully_logged_in_to_the_application() throws InterruptedException {
		waits.untilElementIsVisible(10, headerBanner.icnMenu);
		Assert.assertTrue(headerBanner.icnMenu.isDisplayed());
	}
}
