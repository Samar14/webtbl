package WebTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumTests {

	public static void main(String[] args) {
		//System.out.println(System.getProperty("os.name"));
     System.setProperty("webdriver.chrome.driver",
    		 "/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
     
     WebDriver driver=new ChromeDriver();
     //driver.get("http://amazon.com");
     //driver.navigate().to("http://amazon.com");
		//driver.quit();
     //driver.close();
     //driver.get("http://google.com");
     //driver.navigate().back();
    // String url=driver.getCurrentUrl();
     //System.out.println(url);
     //String actualTitle=driver.getTitle();
     //System.out.println(actualTitle);
     
     //String expectedTitle="Amazon online shopping";
     
     // if(actualTitle.equals(expectedTitle)){
    	//  System.out.println("PASS");
      //}else {
    	  //System.out.println("FAIL");
    	  //System.out.println("Expected: "+expectedTitle);
    	  //System.out.println("Actual: "+actualTitle);
     
     //String actualUrl=driver.getCurrentUrl();
      // System.out.println(actualUrl);
       
       //String expectedUrl="http://jcrew.com";
       
       //if(actualUrl.equals(expectedUrl)){
    	  // System.out.println("PASS");
       //}else{
    	   //System.out.println("FAIL");
    	   //System.out.println("expected: "+expectedUrl);
    	  // System.out.println("actual: "+actualUrl);
          driver.get("http://www.seleniumhq.org/");
          String text=driver.findElement(By.id("menu_about")).getText();
          System.out.println(text);
       }
      }
	//}

//}
