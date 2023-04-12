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
	
	public AddToCartSteps(Base base)
	{
		this.base = base;
		loginPage = base.getPageObjectManager().getLoginPage();
		headerBanner = base.getPageObjectManager().getHeaderBanner();
		inventoryPage = base.getPageObjectManager().getInventoryPage();
		cartPage = base.getPageObjectManager().getCartPage();
		waits = base.getWaits();
	}
	
	@Given("^That I am succefully logged in the application$")
	public void That_I_am_successfully_logged_in_the_application()
	{
		waits.untilElementIsVisible(loginPage.txtUsername);
		loginPage.login(Literals.VALID_USERNAME, Literals.VALID_PASSWORD);
		waits.untilElementIsVisible(headerBanner.icnMenu);
	}
	
	@When("^I click Add to cart button of the product Sauce Labs Backpack$")
	public void I_click_Add_to_cart_button_of_the_product_Sauce_Labs_Backpack()
	{
		inventoryPage.AddItemToCart();
		//inventoryPage.AddItem(Literals.SINGLE_PRODUCT_NAME);
	}
	
	@When("^I click on the View cart button$")
	public void I_click_on_the_View_cart_button()
	{
		headerBanner.ViewCart();
	}
	
	@Then("^The Add to cart button text label change to Remove$")
	public void The_Add_to_cart_button_text_label_change_to_Remove()
	{
		waits.untilElementIsVisible(inventoryPage.btnRemove);
		Assert.assertTrue(inventoryPage.btnRemove.isDisplayed());
	}
	
	@And("^The cart badge increased$")
	public void The_cart_badge_increased()
	{
		waits.untilElementIsVisible(headerBanner.cartBadge);
		Assert.assertTrue(headerBanner.cartBadge.isDisplayed());
	}
	
	@Then("^I am redirect to the Cart page$")
	public void I_am_redirect_to_the_Cart_page()
	{
		waits.untilElementIsVisible(headerBanner.btnCheckout);
		Assert.assertTrue(headerBanner.btnCheckout.isDisplayed());
	}
	
	@And("^the product name shows Sauce Labs Backpack$")
	public void the_product_name_is_Sauce_Labs_Backpacks()
	{
		String actualItem = cartPage.ValidateItemIsAdded(Literals.SINGLE_PRODUCT_NAME);
		Assert.assertEquals(actualItem, Literals.SINGLE_PRODUCT_NAME);
	}
}
