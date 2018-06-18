package iFrame;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpDemo {
	//there are 2 types of pop ups
	//1. browser based-> can be handled by Selenium
	//also known as java script alerts or simply alerts
	//2. os based pop up-> can not be handled by Selenium
	
	WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", 
				"/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	//@Test
	public void acceptPopUp(){
		driver.findElement(By.tagName("button")).click();
		//take control of the popup
		//this line will fail if no alerts available on the page at this moment
		Alert alert=driver.switchTo().alert();
		alert.accept();
		//after handling alerts, there is not need to call switchto.defaultContent()
  assertTrue(driver.findElement(By.xpath("//*[.='You successfuly clicked an alert']")).isDisplayed());
	}
	
	//@Test
	public void cancelPopUp(){
		driver.findElement(By.xpath("(//button)[2]")).click();
		Alert alert2=driver.switchTo().alert();
		alert2.dismiss();
		assertTrue(driver.findElement(By.xpath("//*[.='You clicked: Cancel']")).isDisplayed());
	}
	
	@Test
	public void sendKeysToPopUp(){
		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		Alert alert3=driver.switchTo().alert();
		alert3.sendKeys("Hello");
		alert3.accept();
		assertTrue(driver.findElement(By.xpath("//*[.='You entered: Hello']")).isDisplayed());
		
		driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
		alert3=driver.switchTo().alert();
		alert3.sendKeys("Hello");
		System.out.println(alert3.getText());
		alert3.dismiss();
		assertTrue(driver.findElement(By.xpath("//*[.='You entered: null']")).isDisplayed());
	}
	
}
