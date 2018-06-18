package FindElement;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTests {
	WebDriver driver;
	String url="https://the-internet.herokuapp.com/tables";
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		List<WebElement>tables=driver.findElements(By.tagName("table"));
		System.out.println(tables.size());
		
		WebElement table1=tables.get(0);
		
		List<WebElement>rows=table1.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		
	}

}
