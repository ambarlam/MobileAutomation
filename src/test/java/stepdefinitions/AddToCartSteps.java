package stepdefinitions;

import com.pageobjects.InventoryPage;

import org.testng.Assert;

import com.pageobjects.HeaderBanner;
import com.pageobjects.CartPage;
import com.pageobjects.LoginPage;
import com.utils.Base;
import com.utils.Literals;
import com.utils.Waits;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class AddToCartSteps{
	
	Base base;
	Waits waits;
	LoginPage loginPage;
	InventoryPage inventoryPage;
	HeaderBanner headerBanner;
	CartPage cartPage;
	
	public AddToCartSteps(Base base) {
		this.base = base;
		loginPage = base.getPageObjectManager().getLoginPage();
		headerBanner = base.getPageObjectManager().getHeaderBanner();
		inventoryPage = base.getPageObjectManager().getInventoryPage();
		cartPage = base.getPageObjectManager().getCartPage();
		waits = base.getWaits();
	}
	
	@Given("^That the user succefully logged in the application$")
	public void that_the_user_successfully_logged_in_the_application() {
		waits.untilElementIsVisible(loginPage.txtUsername);
		loginPage.login(Literals.VALID_USERNAME, Literals.VALID_PASSWORD);
		waits.untilElementIsVisible(headerBanner.icnMenu);
	}
	
	@When("^The user click Add to cart button of the product Sauce Labs Backpack")
	public void the_user_click_Add_to_cart_button_of_the_product_Sauce_Labs_Backpack() {
		inventoryPage.AddItem(Literals.SINGLE_PRODUCT_NAME);
	}
	
	@When("^The user click on the View cart button$")
	public void the_user_click_on_the_View_cart_button() {
		headerBanner.ViewCart();
	}
	
	@Then("^The Add to cart button text label change to Remove$")
	public void the_Add_to_cart_button_text_label_change_to_Remove() {
		waits.untilElementIsVisible(inventoryPage.btnRemove);
		Assert.assertTrue(inventoryPage.btnRemove.isDisplayed());
	}
	
	@And("^The cart badge increased$")
	public void the_cart_badge_increased() {
		waits.untilElementIsVisible(headerBanner.cartBadge);
		Assert.assertTrue(headerBanner.cartBadge.isDisplayed());
	}
	
	@Then("^The user redirects to the Cart page$")
	public void the_user_redirects_to_the_Cart_page() {
		waits.untilElementIsVisible(headerBanner.btnCheckout);
		Assert.assertTrue(headerBanner.btnCheckout.isDisplayed());
	}
	
	@And("^the product name shows Sauce Labs Bike Light")
	public void the_product_name_is_Sauce_Labs_Backpacks() {
		String actualItem = cartPage.ValidateItemIsAdded(Literals.SINGLE_PRODUCT_NAME);
		Assert.assertEquals(actualItem, Literals.SINGLE_PRODUCT_NAME);
	}
}
