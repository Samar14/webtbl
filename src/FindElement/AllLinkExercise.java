package FindElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllLinkExercise {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		ChromeDriver driver=new ChromeDriver();
	    driver.get("https://www.tutorialspoint.com/java/");
	    //get all the links
	    List<WebElement> links=driver.findElements(By.tagName("a"));
	    System.out.println("Number of link "+links.size());
	      for(WebElement link: links){
	    	  //if the link is visible
	    	  //is the link has text
//	    	   if(link.isDisplayed() && link.getText().isEmpty()){
	    	   if(link.isDisplayed() && link.getText().length()>0) {	   
	    		   System.out.println(link.getText());
	    		   
//	    		   <thead> holds the colomn names
//	    		   <tbody> actual is in the tbody
	    		   
	    	   }
	      }
	    //.=means exact text
	    //find Tim in the table
		  //table[@id='table1']//td[.='Tim']  
	      
	    
	}

}
