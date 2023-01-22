package zara;

import static org.junit.jupiter.api.Assertions.*;

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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

class FiltersTest {
	
	private static WebDriver webDriver;
	private static String baseUrl;
	private static WebDriverWait wait;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\niimi\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		baseUrl="https://www.zara.com/ba/en/";
		webDriver = new ChromeDriver(options);
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
	}

	@Test
	void testPriceFilter() throws InterruptedException{
		webDriver.get(baseUrl);
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[1]/button")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[1]/button")).click();
		//zara's nav button doesnt work properly, must be clicked at least two times to open the menu
		//some of these need wait cuz zara is crusty
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/aside/div/div/nav/div/ul/li[1]/ul/li[7]/a")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div[2]/div/div/div[2]/button")).click();
		Thread.sleep(1000);
		
		WebElement slider = webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/section/form/div/div[8]/div/div/fieldset/div/div[2]/div/button[2]"));

	    for (int i = 1; i <= 2 ; i++) {
	            slider.sendKeys(Keys.ARROW_LEFT);
	        }
	    
	    webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/section/section/button[1]")).click();
	    Thread.sleep(2000);
	    
	   List<WebElement> results = webDriver.findElements(By.cssSelector(".money-amount__main"));
		
		 for (int i = 0; i < results.size(); i++) {
			 //gets string from element
			 String priceS = results.get(i).getText();
			 //gets rid of BAM from string
			 priceS = priceS.replaceAll("\\s.*", "");
			 //Converts to double
			 double price = Double.parseDouble(priceS);
		        assertTrue(price > 29 && price <90);
		        assertFalse(price < 29 || price > 90); 
		    }
		 
		 Thread.sleep(3000);
	}
}
