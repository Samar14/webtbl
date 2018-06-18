package iFrame;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarDemo {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-handle-calendar-in-selenium.html");
		
		driver.findElement(By.id("datepicker")).click();
  List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
  
        for(WebElement ele: allDates){      //table[@class='table-condensed']//td
        	String date=ele.getText();
        	
        	if(date.equalsIgnoreCase("28")){
        		ele.click();
        		break;
        	}
        }
        
//	    String selectDate="05/10/2017";
//	    Date d=new Date(selectDate);
//	    SimpleDateFormat dateFormat=new SimpleDateFormat("MMMM/dd/yyyy");
			
//		int total=dates.size();
//		 for(int i=0; i<total; i++){
//			 String date=dates.get(i).getText();
//			  if(date.equals("10")){
//				  dates.get(i).click();
//				  break;
//			  }
//		 }
	}

} 
