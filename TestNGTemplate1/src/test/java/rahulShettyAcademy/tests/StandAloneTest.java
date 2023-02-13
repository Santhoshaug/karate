package rahulShettyAcademy.tests;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.id("userEmail")).sendKeys("santhoshaug@gmail.com");

		driver.findElement(By.id("userPassword")).sendKeys("Test@1234");

		driver.findElement(By.name("login")).submit();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		System.out.println(products.size());

		String productName = "ZARA COAT 3";

		// one by one
		WebElement prod = products.stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);

		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		// ng-animating
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#ng-animating")));
		// wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("#ng-animating"))));

		driver.findElement(By.xpath("//button[contains(.,'Cart ')]")).click();

		List<WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='cartSection']/h3"));

		boolean match = cartProducts.stream().anyMatch(cart -> cart.getText().equalsIgnoreCase(productName));

		Assert.assertTrue(match);

		driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group']/input")));

		Actions a = new Actions(driver);

		a.sendKeys(driver.findElement(By.xpath("//div[@class='form-group']/input")), "india").build().perform();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,500)");

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("ta-results")));

		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

		driver.findElement(By.cssSelector(".action__submit")).click();

		String confirmMessage = driver.findElement(By.className("hero-primary")).getText();

		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

		driver.quit();
	}

}
