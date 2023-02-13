package rahulShettyAcademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulShettyAcademy.abstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='form-group']/input")
	WebElement enterCountry;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	By results=By.className("ta-results");
	
	By submit1=By.cssSelector(".action__submit");   //for scrolling
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	
	
	public void selectCountry(String countryName) throws InterruptedException
	{
        Actions a=new Actions(driver);
		a.sendKeys(enterCountry, countryName).build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");
		waitForElementToAppear(results);
		selectCountry.click();
	
	}
	
	public ConfirmationPage submitOrder()
	{
		waitForElementToAppear(submit1);
		submit.click();
		return new ConfirmationPage(driver);
	}

}
