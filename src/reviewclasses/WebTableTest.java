package reviewclasses;

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

public class WebTableTest {
	static WebDriver driver;
	static String url;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		url="http://toolsqa.com/automation-practice-table/";
		driver.get(url);
		driver.navigate().to(url);
	}

	
	@Test
	public void test() {
		WebElement table=driver.findElement(By.tagName("table"));
//it gets all table information
		//System.out.println(table.getText());
		List<WebElement> rows=table.findElements(By.tagName("tr"));
		 for(WebElement row: rows){
			 if(row.getText().equals("Burj Khalifa"));
			   System.out.println("Value found");
		 }
	}

}
