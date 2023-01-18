package zara;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class SearchTest {

	private static WebDriver webDriver;
	private static String baseUrl;
	private static WebDriverWait wait;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\niimi\\chromedriver.exe");
		webDriver = new ChromeDriver();
		baseUrl = "https://www.zara.com/ba/en/";
		wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
		webDriver.quit();
	}

	@Test
	void testSearch() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		//Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[2]/div/div/a/span[1]/span")).click();
		//Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div/section/div[1]/div[1]/div/form/div/div/div/input")).sendKeys("Dress", Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div/section/div[2]/section[1]/ul")));
		
		List<WebElement> results = webDriver.findElements(By.cssSelector(".product-link _item product-grid-product-info__name link"));
		
		 for (int i = 0; i < results.size(); i++) {
		        assertTrue(results.get(i).getText().contains("dress"), "Search result validation failed.");
		    }
		Thread.sleep(2000);
	}

}
