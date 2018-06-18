package WebTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Quiz {

	public static void main(String[] args) {
		// set properties
  System.setProperty("webdriver.chrome.driver",
 		 "/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
         //open the browser
       WebDriver driver=new ChromeDriver();
         //go to website
       driver.get("http://www.cybertekusa.com/contact");
         //get the text of email
       String text=driver.findElement(By.linkText("training@cybertekusa.com")).getText();
       System.out.println(text);
         //get index of @ sign
       int atIndex=text.indexOf("@");
         //getting the substring name
       String name=text.substring(0, atIndex);
       System.out.println(name);
       
       //get the index of .
       int doIndex=text.indexOf(".");
       String company=text.substring(atIndex+1, doIndex);
       System.out.println(company);
       
       //get the domain
       String domain=text.substring(doIndex+1);
       System.out.println(domain);
       driver.close();
       
       
	}

}
