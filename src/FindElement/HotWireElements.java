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

public class HotWireElements {
	WebDriver driver;
	String url="https://www.hotwire.com/";
	

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
	
	@Test
	public void test() throws InterruptedException {
		
		//WebElement link=driver.findElement(By.id("findHotelButton"));
//		List<WebElement>elems=driver.findElements(By.id("findHotelButton"));
//		System.out.println(elems.size());
		
//		WebElement link=driver.findElement(By.name("destCity"));
//		link.sendKeys("test");
	
		//List<WebElement>radioButtons=driver.findElements(By.tagName("input"));
		List<WebElement>radioButtons=driver.findElements(By.cssSelector("input[type='radio']"));
	 
		System.out.println(radioButtons.size());
//		 for(WebElement radio: radioButtons){
//			 if(radio.isDisplayed()){
//				 radio.click();
				 //Thread.sleep(1000);
			 //System.out.println(radio.getAttribute("id"));
//		 }
//	}
		 
		 //go to the page and find all input fields that have tagname input and type text
		 List<WebElement> inputs=driver.findElements(By.xpath("//input[@type='text']"));
		 System.out.println("Number of input fields is "+inputs.size());
         //print out placeholders for each inpit field
		   for(WebElement input: inputs){
			   if(input.isDisplayed())
			     System.out.println(input.getAttribute("placeholder"));
		   }
		 
		
	}

	@After
	public void tearDown() throws Exception {
		
	}
}
