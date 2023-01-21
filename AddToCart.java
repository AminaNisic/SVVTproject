package Testovi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class AddToCart {

	private static WebDriver webDriver;
	private static String baseUrl;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); 
		options.addArguments("--disable-blink-features=AutomationControlled");
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);

		webDriver = new ChromeDriver(options);
		baseUrl = "https://www.zara.com/ba/en/";
		}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@Test
	void test() throws InterruptedException {
		webDriver.get(baseUrl);	
		Thread.sleep(1000);
		
		//click on login
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[2]/div/a[1]")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.name("logonId")).sendKeys("ema2kd@gmail.com");
		webDriver.findElement(By.name("password")).sendKeys("Password123");
		//login button
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div[2]/div[1]/section/form/div[2]/button")).click();
		Thread.sleep(2000);
		//menu
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[1]/button")).click();
		Thread.sleep(1000);
		
		webDriver.findElement(By.linkText("BAGS")).click();
		Thread.sleep(1000);
		//product view
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div[2]/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		//choose type of product
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div[1]/div[2]/section/nav/div/div/ul/li[3]/a")).click();
		Thread.sleep(1000);
		//select product
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div[2]/section[1]/ul/li[4]/div/div/div/div[1]/a")).click();
		Thread.sleep(1000);
		//add to bag
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div[2]/div/div[2]/div[1]/div[5]/button")).click();
		Thread.sleep(5000);
		
		webDriver.get(baseUrl);
		Thread.sleep(1000);
		//bag
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[2]/div/a[3]")).click();
		Thread.sleep(2000);
		String total_price = 
				webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div[2]/div[3]/div[2]/section/div[2]/p/span[2]/div")).getText();
		assertEquals("75.95 BAM", total_price);
		Thread.sleep(2000);
		
		
	}

}
