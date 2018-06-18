package FindElement;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteUserFromTable {

	@Before
	public void setUp() {
	
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void deleteUserTest() {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
	    WebDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/tables");
		//.=means exact text
		//find Tim in the table
		  //table[@id='table1']//td[.='Tim']
		//go up to common tag Tim and delete link has
		  //table[@id='table1']//td.='Tim']/..
		//from the common tag, locate the delete link
		  //table[@id='table1']//td[.='Tim']/..//a[2]
		
		String xp="//table[@id='table1']//td[.='Jason']/..//a[2]";
		driver.findElement(By.xpath(xp)).click();
		
		
		
	}

}
