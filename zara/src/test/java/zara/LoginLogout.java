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

class LoginLogout {

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
		
		Thread.sleep(3000);
		//click on login
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[2]/div/a[1]")).click();
		Thread.sleep(1000);
		
		webDriver.findElement(By.name("logonId")).sendKeys("ema2kd@gmail.com");
		webDriver.findElement(By.name("password")).sendKeys("Password123");
		//login button
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div[2]/div[1]/section/form/div[2]/button")).click();
		Thread.sleep(2000);
		
		String loggedIn = webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[2]/div/a[1]")).getText();
		assertEquals("EMA", loggedIn);
		Thread.sleep(2000);
		
		//click on profile
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[2]/div/a[1]")).click();
		Thread.sleep(1000);
		//click on account
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/nav/div/div/ul/li[2]/a")).click();
		Thread.sleep(1000);
		//signout
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/a")).click();
		
		String loggedOut = webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[2]/div/a[1]")).getText();
		assertEquals("LOG IN", loggedOut);
		
		Thread.sleep(2000);
	}

}
