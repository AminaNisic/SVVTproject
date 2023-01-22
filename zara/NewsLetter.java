package svvt.lab;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class NewsLetter {

	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver","/Users/nox/Downloads/chromedriver_mac_arm64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
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
			Thread.sleep(3000); //cookies
			webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[1]/button")).click();
			Thread.sleep(3000); // menu
			webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/aside/div/div/nav/div/ul/li[1]/ul/li[29]/a")).click();
			Thread.sleep(3000); // info
			webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/aside/div/div/nav/div/ul/li[1]/ul/li[29]/ul/li[1]/a")).click();
			Thread.sleep(3000); //newsletter
			webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div[2]/form/div/div[1]/div/div/div[1]/input")).sendKeys("kenan.piljevic@stu.ibu.edu.ba");
			Thread.sleep(3000); //email
			webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div[2]/form/div/div[2]/div/div/div/label/div")).click();
			Thread.sleep(3000); //privacy check
			webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div[2]/form/div/fieldset/ul/li[2]/div/div/div/label/div")).click();
			Thread.sleep(3000); // man selection
			webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div[2]/form/div[2]/label/div")).click();
			Thread.sleep(3000); //save
			
			
			
			
	}

}
