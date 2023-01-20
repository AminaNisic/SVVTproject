package zara;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

class DiscountTest {

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
	void testDiscount() throws InterruptedException{
		webDriver.get(baseUrl);
		Thread.sleep(3000);
		//clicking two times cuz zara is crusty
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[1]/button")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/header/div/div[1]/button")).click();
		
		js.executeScript("arguments[0].scrollIntoView(true)", webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/aside/div/div/nav/div/ul/li[1]/ul/li[23]")));
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/aside/div/div/nav/div/ul/li[1]/ul/li[23]/a")).click();
		Thread.sleep(1000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/aside/div/div/nav/div/ul/li[1]/ul/li[23]/ul/li[1]/a")).click();
		Thread.sleep(3000);
		
		 List<WebElement> results = webDriver.findElements(By.cssSelector(".product-grid__product-list"));
			
		 for (int i = 0; i < results.size(); i++) {
			 //parsing original price to double by omitting the text after the first blank space which is BAM
			 String ogpriceS = webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div[2]/section[1]/ul/li[1]/ul[3]/li[1]/div/div/div[2]/span/span/div/span")).getText();
			 ogpriceS = ogpriceS.replaceAll("\\s.*", "");
			 double ogprice = Double.parseDouble(ogpriceS);
			 
			 //help
			 String ns =webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div[2]/section[1]/ul/li[1]/ul[3]/li[1]/div/div/div[3]/span/span[1]")).getText();
			 ns = ns.replaceAll("[^0-9]", "");
			 double n = Double.parseDouble(ns);
			 
			 String newpriceS = webDriver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div[2]/main/article/div[2]/section[1]/ul/li[1]/ul[3]/li[1]/div/div/div[3]/span/span[2]/div/span")).getText();
			 newpriceS = newpriceS.replaceAll("\\s.*", "");
			 double newprice = Double.parseDouble(newpriceS);
			 
		        assertEquals(newprice, (ogprice - ( ogprice * ( n / 100) )) );
		        
		      //oh?? zara ??  
		        
		    }
		 
		
		 Thread.sleep(5000);
		 
		
	}

}
