package rahulShettyAcademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulShettyAcademy.TestComponents.BaseTest;
import rahulShettyAcademy.TestComponents.Retry;
import rahulShettyAcademy.pageobjects.CartPage;
import rahulShettyAcademy.pageobjects.CheckoutPage;
import rahulShettyAcademy.pageobjects.ConfirmationPage;
import rahulShettyAcademy.pageobjects.LandingPage;
import rahulShettyAcademy.pageobjects.ProductCatalogue;

public class LoginErrorValidationTest extends BaseTest{
	
	@Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
	public void submitOrder() throws Exception
	{
		String productName = "ZARA COAT 3";
		
		ProductCatalogue productCatalogue=landingPage.loginApplication("santaug@gmail.com", "Test@1234");
		Assert.assertEquals("Incorrect email or password1.", landingPage.getErrorMessage()); 
		
	}

	@Test
	public void productErroValidation() throws Exception
	{
		String productName = "ZARA COAT 3";
		
		ProductCatalogue productCatalogue=landingPage.loginApplication("rachayya@gmail.com", "Test@1234");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.getProductByName(productName);
		productCatalogue.addProductToCart(productName);
		CartPage cartPage=productCatalogue.goToCartPage();  //this can be taken from any page since it is from AbstractComponent class
		boolean match = cartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	}
}
