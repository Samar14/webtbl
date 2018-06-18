package WebTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearch {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver",
	   "/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
	     
		WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   String url="http://google.com";
		   
		   driver.get(url);
		   String expectedTitle="Google";
           String actualTitle=driver.getTitle();
           System.out.println(actualTitle);
           
           if(expectedTitle.equals(actualTitle)){
        	   System.out.println("Step passed. Title is as expected");
           }else{
        	   System.out.println("Step failed. Title is not as expected");
           }
              String expectedUrl="www.google.com";
		      String actualUrl=driver.getCurrentUrl();
		      System.out.println(actualUrl);
	           
		      if(actualUrl.contains(expectedUrl)){
		    	  System.out.println("Step passed. Url is as expected");
		      }else{
		    	  System.out.println("Step failed. Url is not as expected");
		      }
		         driver.navigate().refresh();
		      
		         String searchItem="Selenium WebDriver";
		     
		      System.out.println("------START Page source code-----");
		       String source=driver.getPageSource();
		       System.out.println(source.length());
		      System.out.println(driver.getPageSource().substring(0,11));
		      System.out.println("------END Page source code-----");
		      
     driver.findElement(By.name("q")).sendKeys("Selenium WebDriver"+Keys.ENTER);
		      driver.findElement(By.name("btnG")).click();
		      
		      if(driver.getTitle().startsWith("searchItem")){
		    	  System.out.println("Step passed");
		      }else{
		    	  System.out.println("Step failed");
		      }   System.out.println(driver.getTitle());
		      
		      WebElement searchResults=driver.findElement(By.id("resultStats"));
		      System.out.println(searchResults.getText());
		      
		  //System.out.println(driver.findElement(By.id("resultStats")).getText());
		      //driver.quit();	 
		            
	}

}
