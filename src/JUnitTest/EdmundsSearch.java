package JUnitTest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EdmundsSearch {
	    WebDriver driver;
	    
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", 
				"/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://www.edmunds.com/");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//driver.findElement(By.xpath("//a[@href='/used-cars-for-sale/']")).click();
		//Step 2. Click on Used Cars
		WebElement usedCars=driver.findElement(By.xpath("//a[@href='/used-cars-for-sale/']"));
		usedCars.click();
	     
	   //Step 3. Enter zipcode
		WebElement zipcode=driver.findElement(By.name("zipcode"));
		zipcode.clear();
		zipcode.sendKeys("60018");
		
		//Step 4. Select car make
		Select make=new Select(driver.findElement(By.name("make")));
		make.selectByVisibleText("Acura");
		
		String strMake=make.getFirstSelectedOption().getText();
		System.out.println(strMake);
		
		int count=make.getOptions().size();
		System.out.println("Car Make count:"+count);
		// Step 5. Select car model
		Select model=new Select(driver.findElement(By.name("model")));
		//model.selectByIndex(6);
		model.selectByValue("MDX");
		//Verify selected value
		String strModel=model.getFirstSelectedOption().getText();
		System.out.println(strModel);
		//Step 6. Click on Start Shoppinh
  WebElement startShopping=driver.findElement(By.xpath("//span[contains(text(), 'Start Shopping')]"));
		startShopping.click();
		
		WebElement cpo=driver.findElement(By.id("inv-type-cpo"));
		cpo.click();
		
		if(!cpo.isSelected()){
			cpo.click();
		}
		
		WebElement tenK=driver.findElement(By.id("under-10k"));
		if(tenK.isSelected()){
		    tenK.click();
		}
		
	}  

}
