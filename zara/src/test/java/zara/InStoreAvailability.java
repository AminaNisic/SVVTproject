package Testovi;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class InStoreAvailability {

	private static WebDriver webDriver;
	private static String baseUrl;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); 
		options.addArguments("--user-data-dir=/Users/User/OneDrive/Desktop/chrome_profile");

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
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[1]/button")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.linkText("ACCESSORIES")).click();
		Thread.sleep(1000);
		//product view
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div[2]/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		//select a product
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div[2]/section[1]/ul/li[13]/div/div/div/div[1]/a/h3")).click();
		Thread.sleep(1000);
		//check in-store availability
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div[2]/div/div[2]/div[2]/ul/li[2]/button")).click();
		Thread.sleep(3000);
		//select a size
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div/div/div/div")).click();
		Thread.sleep(1000);
		//check availability
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div/div[2]/div/form/div/button")).click();
		Thread.sleep(2000);
		//search store
		webDriver.findElement(By.name("search")).sendKeys("Mostar");
		//search button
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div/div[2]/form/div[1]/button")).click();
		Thread.sleep(2000);
		String mostar = 
				webDriver.findElement(By.xpath
						("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/fieldset/ul/li/div/div[1]/div/div/label/div[2]/div[1]")).getText();
		assertEquals("MOSTAR", mostar);
		
		Thread.sleep(2000);
	}

}
