package Windows;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.jboss.netty.util.internal.SystemPropertyUtil;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MultipeTabsWindowsTest {
	WebDriver driver;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver",
		 		 "/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		driver=new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/windows");
	}
	
	
	//@Test
	public void multiTabTest(){
		System.out.println(driver.getTitle());
//Selenium does not change tabs or windows automatically
   //we need to call the driver.switchto.window method		 
		driver.findElement(By.linkText("Click Here")).click();
		//System.out.println(driver.getTitle());
		
//getWindowHandle methods returns the unique id of the current window/tab selenium is controlling		
		String originalWindow=driver.getWindowHandle();
		//System.out.println(originalWindow);
//getWindowHandles() return the list of all window/tabs handles 		
		List<String> handles=new ArrayList<> (driver.getWindowHandles());
		System.out.println(handles);
//switch to the second window handle from the handles list		
		driver.switchTo().window(handles.get(0));
		System.out.println(driver.getTitle());
	
	}
	
	
	@Test
	public void changeWindowUsingMethod(){
		driver.findElement(By.linkText("Click Here")).click();
		System.out.println(driver.getTitle());
		switchWindow("New Window");
		//System.out.println(driver.getTitle());
	
		
	}
	
	public void switchWindow(String title){
		String original=driver.getWindowHandle();
//get all available window handles and iterate		
	  for (String handle: driver.getWindowHandles()) {
	//switch to handle
		driver.switchTo().window(handle);
		System.out.println(driver.getTitle());
		
	//get title
	//verify if it's the expected title
//		if(title.equals(driver.getTitle())){
//			//break the loop and get out of the method
//			return;
//		}
		  //if not go to the next handle	
		
	}
	  driver.close();
	//switch back to original tab  
	  driver.switchTo().window(original);
  }
	
	
	//@Test
	public void switchToSeparateWindow(){
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		System.out.println(driver.getTitle());
		driver.findElement(By.id("button1")).click();
		switchWindow("QA Automation Tools Tutorial");
		System.out.println(driver.getTitle());
	}

}

