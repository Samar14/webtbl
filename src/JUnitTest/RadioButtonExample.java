package JUnitTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RadioButtonExample {
	   WebDriver driver;
	   WebElement hotels, cars, flights;
	   
	   @BeforeClass
	   public static void beforeClass(){
		   System.setProperty("webdriver.chrome.driver", 
		           "/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		    }
	   
       @Before
	public void setUp(){
//	1. go to hotwire.com
//	set driver
//	open browser
    driver=new ChromeDriver();
//go to url
    driver.get("https://www.hotwire.com/");
    hotels=driver.findElement(By.cssSelector("input[id*='hotelRadio']"));
    cars=driver.findElement(By.cssSelector("input[id*='carRadio']"));
    flights=driver.findElement(By.cssSelector("input[id*='flightRadio']"));
		}
	
	   @Test
	   public void carRadioTest(){   
//check the cars checkbox
		   cars.click();
//verify Hotels not checked
		   Assert.assertFalse(hotels.isSelected());
//verify Cars checked
		   Assert.assertTrue(cars.isSelected());
//verify Flights not checked
		   Assert.assertFalse(flights.isSelected());
//verify find a car button is displayed	
		   WebElement findACarBtn=driver.findElement(By.cssSelector("#findCarButton"));
		   Assert.assertTrue(findACarBtn.isDisplayed());
	 }
	
	    @Test
	    public void flightRadioTest(){
//check the flight checkbox
	    	flights.click();
//verify Hotels not checked
	    	Assert.assertFalse(hotels.isSelected());
//verify Cars not checked
	    	Assert.assertFalse(cars.isSelected());
//verify Flights checked
	    	Assert.assertTrue(flights.isSelected());
//verify find a flights button is displayed	   
	    	WebElement findAFlightBtn=driver.findElement(By.cssSelector("#ffAirRoundTripButton"));
			   Assert.assertTrue(findAFlightBtn.isDisplayed());
	    }
	
	@Test
	public void verifyDefaultTest(){
 //2. verify Hotels checked
		//WebElement hotels=driver.findElement(By.cssSelector("input[id*='hotelRadio']"));
		Assert.assertTrue(hotels.isSelected());
//3. verify Cars not checked
		//WebElement cars=driver.findElement(By.cssSelector("input[id*='carRadio']"));
		Assert.assertFalse(cars.isSelected());
//4. verify Flights not checked
		//WebElement flights=driver.findElement(By.cssSelector("input[id*='flightRadio']"));
		Assert.assertFalse(flights.isSelected());
// 5. verify 1 is selected in Rooms dropdown list
		WebElement roomsEl=driver.findElement(By.cssSelector("select#hotelRooms"));
		Select rooms=new Select(roomsEl);
		String actuallySelected=rooms.getFirstSelectedOption().getAttribute("value");
		String expected="1";
//compares two arguments and fails if they are not equal
		Assert.assertEquals(expected, actuallySelected);
		
// 6. verify find a hotel button is displayed
		WebElement findAHotelBtn=driver.findElement(By.cssSelector("#findHotelButton"));
		Assert.assertTrue(findAHotelBtn.isDisplayed());
		}
	
	
	
//	@Ignore
	@Test 
	public void homePageTest(){
//2. verify title starts with "Cheap"
        String actualTitle=driver.getTitle();
        String expected="Cheap";
        Assert.assertTrue(actualTitle.startsWith(expected));

//3. verify url is "https://www/hotwire.com/"
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.hotwire.com/";
		
//actualUrl.equals(expectedUrl);
        Assert.assertTrue(actualUrl.equals(expectedUrl));
        
		
	}
	
	
	
	@Ignore
    @Test
	public void test(){
		String expected ="one";
		String actual="one";
		//boolean equals=expected.equals(actual);
		
		//Assert.assertTrue(equals);
		Assert.assertTrue(expected.equals(actual));;
		
//		Assert.assertTrue(2!=2);
//		Assert.assertTrue(2==2);
	}
	
	
	

}
