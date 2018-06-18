package iFrame;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleiFrame {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    String url="file:///Users/sunatulloabdullaev/Documents/iframes.html";
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//Assert.assertTrue(driver.findElement(By.linkText("Hotels")).isDisplayed());
//		List<WebElement>framesCollection=driver.findElements(By.tagName("iframe"));
//		System.out.println("Number of iframes: "+framesCollection.size());
//		
//		  for(WebElement e:framesCollection){
//			  driver.switchTo().frame(e);
//			  List<WebElement> framesInsideFrames=driver.findElements(By.tagName("iframe"));
//			  System.out.println("Number of frames inside frames is: "+framesInsideFrames.size());
//			  driver.switchTo().defaultContent();
//		  }
		  
		//switch to a frame using index
//		driver.switchTo().frame(1);
//		Assert.assertTrue(driver.findElement(By.linkText("Hotels")).isDisplayed());
//		driver.switchTo().defaultContent();
		
//		//switch to a frame using name
//		driver.switchTo().frame("iframe1");
//		driver.findElement(By.linkText("Hotels")).click();
//		driver.switchTo().defaultContent();
		
		//switch to a frame using id
//		driver.switchTo().frame("iF1");
//		driver.findElement(By.linkText("Cars")).click();
//		driver.switchTo().defaultContent();
		
		//switch to a frame using WebElement frame
		WebElement iframeElement=driver.findElement(By.id("IF2"));
		driver.switchTo().frame(iframeElement);
		driver.findElement(By.linkText("Flights")).click();
		driver.switchTo().defaultContent();
				
	}

}
