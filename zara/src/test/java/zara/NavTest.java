package zara;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

class NavTest {

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
	void testNav() throws InterruptedException{
		webDriver.get(baseUrl);
		Thread.sleep(2000);
		//gotta click menu button a few times because it's crusty
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[1]/button")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[1]/button")).click();
		
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/aside/div/div/nav/div/ul/li[1]/ul/li[9]/a")).click();
		assertTrue(webDriver.getCurrentUrl().contains("shirts"));
		assertFalse(webDriver.getCurrentUrl().contains("dresses"));
		Thread.sleep(2000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div[1]/div[1]/button")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/aside/div/div/nav/div/ul/li[1]/ul/li[17]/a")).click();
		assertTrue(webDriver.getCurrentUrl().contains("shoes"));
		assertFalse(webDriver.getCurrentUrl().contains("bags"));
		Thread.sleep(2000); //zara is not very optimized so it's necessary to use sleep all the time, and using waits would be complicating the code too much
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div[1]/div[1]/button")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/aside/div/div/nav/div/ul/li[1]/ul/li[18]/a")).click();
		assertTrue(webDriver.getCurrentUrl().contains("bags"));
		assertFalse(webDriver.getCurrentUrl().contains("shirts"));
		Thread.sleep(2000);
		
	}

}
