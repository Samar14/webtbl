package Windows;

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

import reviewclasses.Page;

public class TabsAndWindows {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
		 		 "/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		driver.get("https://www.w3schools.com/html/html_links.asp");
//saving all the Try it Yourself links in the links list		
		List<WebElement> links=driver.findElements(By.partialLinkText("Try it Yourself"));
		System.out.println(links.size());
		  for(WebElement link: links){
			  System.out.println(link.getText());
		  }
//click on the first element		  
		links.get(0).click();
		
		String originalPage=driver.getWindowHandle();
		System.out.println(originalPage);
		
		System.out.println(driver.getTitle());
//switch tabs
//switchWindow takes a title and a webdriver as parameter and switches to the given title 		
		Page.switchWindow("Tryit Editor v3.3", driver);
		System.out.println(driver.getTitle());
		
		String expected=driver.findElement(By.xpath("//span[@class='cm-m-xml'][3]")).getText();
		System.out.println(expected);

//switch to iFrame
		driver.switchTo().frame("iframeResult");
		String actual=driver.findElement(By.linkText("Visit our HTML tutorial")).getText();
		assertEquals(expected, actual);
//if 2 pages with the same title, close first one and go back to originalPage
		driver.close();
		
		driver.switchTo().window(originalPage);
		links.get(1).click();
	}

}
