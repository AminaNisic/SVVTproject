package Testovi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class ContactUs {

	private static WebDriver webDriver;
	private static String baseUrl;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); 

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
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/aside/div/div/nav/div/ul/li[1]/ul/li[29]/a/span")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/aside/div/div/nav/div/ul/li[1]/ul/li[29]/ul/li[2]/a/span")).click();
		
		//access
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div[2]/div/div/ul/li[1]/div[3]/button/div")).click();
		
		//general queries
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/section/div/div/div/div[2]/div/div/ul/li[5]/button/div/div/div")).click();
		
		Thread.sleep(3000);
		String message = webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/section/div/div/div/div[2]/div/div[1]/ul/li[3]/div/div/span")).getText();
		assertTrue(message.contains("How can we help you?"));
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/section/div/div/div/div[1]/button[1]")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/section/div/div/div/div[4]/div/div/button[2]/div")).click();
		
		Thread.sleep(2000);
		
	}

}
