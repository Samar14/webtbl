package iFrame;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframeDemo {
	
	//@Test
	public void iFrameTest(){
		System.setProperty("webdriver.chrome.driver", 
				"/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/iframe");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
		//switch to iframe using a webelement
		WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("tinymce")).clear();
		//switch back to main content
		driver.switchTo().defaultContent();
		assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
	}
	
	
	//@Test
	public void iFrameTestUsingID(){
		System.setProperty("webdriver.chrome.driver", 
				"/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/iframe");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
		//switch to iframe using a webelement
		WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
		driver.switchTo().frame(iframe);
		driver.findElement(By.id("tinymce")).clear();
		//switch back to main content
		driver.switchTo().defaultContent();
		assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
	}
	
	
	@Test
	public void iFrameTestUsingIndex(){
		System.setProperty("webdriver.chrome.driver", 
				"/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/iframe");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
		//switch to iframe using index
		WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
		driver.switchTo().frame(0);
		driver.findElement(By.id("tinymce")).clear();
		//switch back to main content
		driver.switchTo().defaultContent();
		assertTrue(driver.findElement(By.linkText("Elemental Selenium")).isDisplayed());
	}

}
