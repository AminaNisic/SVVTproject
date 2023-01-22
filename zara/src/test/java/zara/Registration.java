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
import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

class Registration {

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
		
		//cookies
		//webDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/button")).click();
		
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[2]/div/a[1]")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div[2]/div[2]/section/button")).click();
		Thread.sleep(3000);
		
		//accept privacy
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/form/div[1]/div[8]/div/div/label/div")).click();
		
		webDriver.findElement(By.name("email")).sendKeys("ema10kd@gmail.com");
		webDriver.findElement(By.name("password")).sendKeys("Password123");
		webDriver.findElement(By.name("passwordConfirm")).sendKeys("Password123");
		webDriver.findElement(By.name("firstName")).sendKeys("Ema");
		webDriver.findElement(By.name("lastName")).sendKeys("Kavazovic");	
		
		//create account
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/form/div[2]/button/div/span")).click();
		Thread.sleep(3000);	
		
		assertEquals("https://www.zara.com/ba/en/", webDriver.getCurrentUrl());
	}

}
