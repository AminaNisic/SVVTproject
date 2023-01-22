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
		
		 List<WebElement> oldprice = webDriver.findElements(By.cssSelector(".money-amount__main"));
		 List<WebElement> newP = webDriver.findElements(By.cssSelector(".price-current__amount"));
		 List<WebElement> percentage = webDriver.findElements(By.cssSelector(".price-current__discount-percentage"));
			
		 for (int i = 0; i < oldprice.size(); i++) {
			 
			 try {
			 String ogpriceS = oldprice.get(i).getText();
			 ogpriceS = ogpriceS.replaceAll("\\s.*", "");
			 double ogprice = Double.parseDouble(ogpriceS);
			 
			 String ns = percentage.get(i).getText();
			 ns = ns.replaceAll("[^0-9]", "");
			 double n = Double.parseDouble(ns);
			 
			 String newpriceS = newP.get(i).getText();
			 newpriceS = newpriceS.replaceAll("\\s.*", "");
			 double newprice = Double.parseDouble(newpriceS);
			 
			 double expected = ogprice - (ogprice*(n/100)); 
			 Math.round(expected);
			 assertEquals(expected,newprice);
			 //assertNotEquals(expected,newprice); 
			 
			 }		 
			 catch(IndexOutOfBoundsException e) {				 
			 }		        
		    }		
		 Thread.sleep(5000);	 
	}

}
