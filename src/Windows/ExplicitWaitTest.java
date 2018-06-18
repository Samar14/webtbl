package Windows;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTest {
	WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver",
		 		 "/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	
	//@Test
	public void waitUntilVisible(){
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.tagName("button")).click();
		
		WebElement text=driver.findElement(By.id("finish"));

//explicitWait wait until a certain condition is met
		WebDriverWait wait=new WebDriverWait(driver,13);
	//1.what is the wait condition
	//2.what is the element we are waiting for	
//ExpectedConditions is the class that holds the wait conditions		
		wait.until(ExpectedConditions.visibilityOf(text));
		assertTrue(text.isDisplayed());
	}
	
	
	@Test
	public void waitUntilDisappears(){
		driver.get("http://the-internet.herokuapp.com/dynamic_controls");
		String b="btn";
		driver.findElement(By.id(b)).click();
		
		By id=By.id("checkbox");
		//WebElement checkbox=driver.findElement(id);
		
		WebDriverWait wait=new WebDriverWait(driver, 12);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(id));
// verifying element does not exist using findElements method		
		List<WebElement> list=driver.findElements(id);
		assertEquals(0, list.size());

// verifying element does not exist using findElement method and try catch
		try {
			assertFalse(driver.findElement(id).isDisplayed());
		} catch (NoSuchElementException e) {
			assertTrue(true);
		}
		
	}
}
