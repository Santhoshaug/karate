package rahulShettyAcademy.stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulShettyAcademy.TestComponents.BaseTest;
import rahulShettyAcademy.pageobjects.CartPage;
import rahulShettyAcademy.pageobjects.CheckoutPage;
import rahulShettyAcademy.pageobjects.ConfirmationPage;
import rahulShettyAcademy.pageobjects.LandingPage;
import rahulShettyAcademy.pageobjects.ProductCatalogue;

public class StepDefination extends BaseTest {

	LandingPage landingPage;
	ProductCatalogue productCatalogue;
	CheckoutPage checkoutPage ;	
	ConfirmationPage confirmationPage;

	@Given("I landed on Ecommerce page")
	public void i_landed_on_ecommerce_page() throws IOException {
		landingPage = launchApplication();
	}

	@Given("^Logged in with (.+) and (.+)$")
	public void logged_in_with_and(String userName, String password) {
		productCatalogue = landingPage.loginApplication(userName, password);

	}

	@When("^I add product (.+) to cart$")
	public void i_add_product_to_cart(String productname) {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.getProductByName(productname);
		productCatalogue.addProductToCart(productname);
	}

	@And("^checkout (.+) and submit order$")
	public void checkout_and_submit_order(String productname) throws InterruptedException {
		CartPage cartPage = productCatalogue.goToCartPage();
		
		boolean match = cartPage.verifyProductDisplay(productname);
		Assert.assertTrue(match);
		checkoutPage = cartPage.goTOCheckout();
		checkoutPage.selectCountry("india");
		confirmationPage = checkoutPage.submitOrder();

	}

	@Then("^\"([^\"]*)\"message is displayed on confirmation page$")
	public void message_is_displayed_on_confirmation_page(String string) {
		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();

	}
	 @Then("^\"([^\"]*)\" message is displayed$")
	    public void something_message_is_displayed(String strArg1) throws Throwable {
		 Assert.assertEquals(strArg1, landingPage.getErrorMessage()); 
		 driver.close();
	    }

}
