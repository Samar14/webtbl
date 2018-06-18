package reviewclasses;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Page {
	static WebDriver driver;
	
	public static void verifyElementDisplayed(By by){
		try{
		assertTrue(driver.findElement(by).isDisplayed());
		} catch (NoSuchElementException e){
			fail("Element not found");
		}
	}
	
	public static void verifyTextDisplayed(String text){
		String xpath="//*[.='" + text + "']";
		 try{
			 assertTrue("text was not displayed", driver.findElement(By.xpath(xpath)).isDisplayed());
		 }catch (NoSuchElementException e){
			 fail(text + " not found");
		 }
	}
	
//switch method to reuse	
	public static void switchWindow(String title, WebDriver driver){
		String original=driver.getWindowHandle();		
	      for (String handle: driver.getWindowHandles()) {
		  driver.switchTo().window(handle);
		if(title.equals(driver.getTitle())){
			return;
		}
		
	}
	  
	  driver.switchTo().window(original);

   }

}
