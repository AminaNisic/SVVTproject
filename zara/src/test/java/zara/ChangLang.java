package svvt.lab;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;

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
import org.openqa.selenium.support.ui.Select;

class ChangLang {

	private static WebDriver webDriver;
	private static String baseUrl;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver","/Users/nox/Downloads/chromedriver_mac_arm64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-blink-features=AutomationControleld");
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);
		baseUrl="https://www.zara.com/ba/en/";
		webDriver = new ChromeDriver(options);
		
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	@Test
	void test() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div[2]/button")).click();
		Thread.sleep(3000); // cookies
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[2]/div/a[1]")).click();
		Thread.sleep(3000); //log-in
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div[2]/div[1]/section/form/div[1]/div[1]/div/div/div[1]/input")).sendKeys("kenan.p996@gmail.com");
		Thread.sleep(2000); //unos mejla
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div[2]/div[1]/section/form/div[1]/div[2]/div/div/div[1]/div/input")).sendKeys("5VyRtFejkZzuKQG");
		Thread.sleep(2000); // unos passworda
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div[2]/div[1]/section/form/div[2]/button")).click();
		Thread.sleep(3000); // sign-in
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[2]/div/a[1]")).click();
		Thread.sleep(3000); // my profile
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/nav[1]/div/div/ul/li[3]/a")).click();
		Thread.sleep(3000); // settings
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/nav[2]/ul/li[2]/button/div/div/div[1]")).click();
		Thread.sleep(3000); // lang set
		Select cl = new Select(webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div[2]/form/div/div/div/div/div/div/select")));
		cl.selectByValue("180");
		Thread.sleep(1000); 
		WebElement BHS = webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div/div[2]/form/div/div/div/div/div/div/select/option[1]"));
		assertTrue(BHS.isSelected());
		
		
		
	}

	

}
