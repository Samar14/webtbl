package reviewclasses;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class ReviewWebDriverTest {
	static WebDriver driver;
	static String url;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		url="http://toolsqa.com/automation-practice-form/";
		driver.get(url);
		driver.navigate().to(url);
	}


	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void VerifyCorrectPage() {
		//assert that you are on right page
		verifyThatCorrectPageDisplayed();
   }

	
	@Test
	public void AutomationFormTest(){
		WebElement firstName=driver.findElement(By.name("firstname"));
		//assertTrue(firstName.isEnabled());
//		 if(firstName.isEnabled()){
//			 firstName.sendKeys("Adam");
//		 }else{
//			 fail("firstName field is disable");
//		 }
		inputValue(firstName, "Adam");
		 
		WebElement lastName=driver.findElement(By.xpath("//input[@name='lastname']"));
		 if(lastName.isEnabled()){
			 lastName.clear();
			 lastName.sendKeys("Smith");
		 }else{
			 fail("lastname field is disabled");
		 }
		 
		//WebElement link1=driver.findElement(By.linkText("Link Test")); 
		 WebElement link1=driver.findElement(By.xpath("//a[.='Link Test']"));
		link1.click();
		driver.navigate().back();
		link1=driver.findElement(By.partialLinkText("Partial Link Test"));
		link1.click();
	
		WebElement male=driver.findElement(By.cssSelector("input#sex-0"));
		WebElement female=driver.findElement(By.xpath("//input[@id='sex-1']")); 
		 System.out.println(male.isSelected());
		 if(!male.isSelected()){
			 male.click();
		 assertFalse(female.isSelected());	 
		 }
		
		WebElement autoTester=driver.findElement(By.id("profession-1"));
		 if(!autoTester.isSelected()){
			 autoTester.click();
		 }
		
		 //drop down list
		Select continents=new Select(driver.findElement(By.name("continents")));
		continents.selectByVisibleText("North America");
		assertEquals("North America", continents.getFirstSelectedOption().getText());
	}
	
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
	
	public void inputValue(WebElement elem, String value){
		if(elem.isEnabled()){
			elem.clear();
			elem.sendKeys(value);
		 }else{
			 fail(elem+" field is disabled");
		 }
	}
	
	public void verifyThatCorrectPageDisplayed(){
		String title=driver.getTitle();
		assertEquals(title, "Demo Form for practicing Selenium Automation");
		
		//assertTrue(title.equals("Demo Form for practicing Selenium Automation"));
		//assertTrue(title.contains("Demo Form for practicing Selenium Automation"));
		
 assertEquals("URL is wrong","http://toolsqa.com/automation-practice-form/",driver.getCurrentUrl());
		
        assertTrue(driver.getPageSource().contains("navigation"));
        
        WebElement header=driver.findElement(By.className("h1-size"));
//        System.out.println(header.isDisplayed());
//        System.out.println(header.getText());
        assertTrue("Header message is missing", header.isDisplayed());
        assertEquals("Automation Practice Form", header.getText());
	}
}
