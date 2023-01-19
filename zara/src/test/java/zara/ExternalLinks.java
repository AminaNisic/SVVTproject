package zara;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

class ExternalLinks {

	private static WebDriver webDriver;
	private static String baseUrl;
	private static WebDriverWait wait;
	JavascriptExecutor js = (JavascriptExecutor) webDriver;
	
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
	void linkTest() throws InterruptedException{
		webDriver.get(baseUrl);
		String home = webDriver.getWindowHandle();
		//tiktok
		js.executeScript("arguments[0].scrollIntoView(true)", webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div[2]/ul/li[3]/ul/li[9]/div[2]/div[1]/div[2]/div/div/ul")));
		Thread.sleep(3000);
		webDriver.findElement(By.linkText("TIKTOK")).click();
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(home)) {
				webDriver.switchTo().window(handle);
			}
		}
		Thread.sleep(3000);
		assertEquals("https://www.tiktok.com/@zara", webDriver.getCurrentUrl());
		webDriver.close();
		webDriver.switchTo().window(home);
		Thread.sleep(3000);
		
		//instagram
		webDriver.findElement(By.linkText("INSTAGRAM")).click();
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(home)) {
				webDriver.switchTo().window(handle);
			}
		}
		Thread.sleep(3000);
		assertEquals("https://www.instagram.com/zara/", webDriver.getCurrentUrl());
		webDriver.close();
		webDriver.switchTo().window(home);
		Thread.sleep(3000);
		
		//facebook
		webDriver.findElement(By.linkText("FACEBOOK")).click();
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(home)) {
				webDriver.switchTo().window(handle);
			}
		}
		Thread.sleep(3000);
		assertEquals("https://www.facebook.com/Zara", webDriver.getCurrentUrl());
		webDriver.close();
		webDriver.switchTo().window(home);
		Thread.sleep(3000);
		
		//twitter
		webDriver.findElement(By.linkText("TWITTER")).click();
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(home)) {
				webDriver.switchTo().window(handle);
			}
		}
		Thread.sleep(3000);
		assertEquals("https://twitter.com/ZARA", webDriver.getCurrentUrl());
		webDriver.close();
		webDriver.switchTo().window(home);
		Thread.sleep(3000);
		
		//pinterest
		webDriver.findElement(By.linkText("PINTEREST")).click();
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(home)) {
				webDriver.switchTo().window(handle);
			}
		}
		Thread.sleep(3000);
		assertEquals("https://www.pinterest.es/zaraofficial/", webDriver.getCurrentUrl());
		webDriver.close();
		webDriver.switchTo().window(home);
		Thread.sleep(3000);
		
		//Youtut
		webDriver.findElement(By.linkText("YOUTUBE")).click();
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(home)) {
				webDriver.switchTo().window(handle);
			}
		}
		Thread.sleep(3000);
		assertEquals("https://www.youtube.com/user/zara", webDriver.getCurrentUrl());
		webDriver.close();
		webDriver.switchTo().window(home);
		Thread.sleep(3000);
		
		//Spotify
		webDriver.findElement(By.linkText("SPOTIFY")).click();
		for(String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(home)) {
				webDriver.switchTo().window(handle);
			}
		}
		Thread.sleep(3000);
		assertEquals("https://open.spotify.com/user/r6ivwuv0ebk346hhxo446pbfv", webDriver.getCurrentUrl());
		webDriver.close();
		webDriver.switchTo().window(home);
		Thread.sleep(3000);
		
		//write them as separate tests?
	}
	

}
