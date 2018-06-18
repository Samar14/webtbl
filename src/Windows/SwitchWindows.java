package Windows;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindows {
	WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
		 		 "/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		driver=new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/windows");
		
	}

	@After
	public void tearDown() {
	}

	@Test
	public void test() {
		
		driver.findElement(By.linkText("Click Here")).click();
		System.out.println(driver.getTitle());
		
		String childWindow="New Window";
		switchToWindows(driver, childWindow);
		System.out.println(driver.getTitle());
		
		 
		
	}
	
	public boolean switchToWindows(WebDriver driver, String title){
		String main=driver.getWindowHandle();
		Set<String> set=driver.getWindowHandles();
		  for(String windows: set){
			 driver.switchTo().window(windows);
			 if(driver.getTitle().equals(title)){
				 
			 }
			 return true;
		  }
		  driver.switchTo().window(main);
			 return false;
		  

	}
}
