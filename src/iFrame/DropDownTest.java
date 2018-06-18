package iFrame;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownTest {
	
	@Test
	public void dropTest(){
		System.setProperty("webdriver.chrome.driver", 
				"/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("http://the-internet.herokuapp.com/dropdown");
		
		Select dropdown=new Select(driver.findElement(By.id("dropdown")));
//getFirstSelectedOption() return the selected web element from the drop down list	
		String defaultSelection=dropdown.getFirstSelectedOption().getText();
		String expectedDefault="Please select an option";
		assertEquals(expectedDefault, defaultSelection);
		
		String selectThis="Option 1";
		dropdown.selectByVisibleText(selectThis);
		//verify again
		String newSelected=dropdown.getFirstSelectedOption().getText();
		assertEquals(selectThis, newSelected);
		
//print all available options
//we can get the available options using the getOptions()		
		List<WebElement> optionsEl=dropdown.getOptions();
	//got through the list and print the value of each web element	
		  for(WebElement option: optionsEl){
			  System.out.println(option.getText());
		  }
		
	}
	

}
