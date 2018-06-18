package WebTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BasicMercurytest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
		 		 "/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		  //enter first name and need to find the first name element,type
		String fName="Jonh";
		driver.findElement(By.name("firstName")).sendKeys(fName);
		
		String lName="Smith";
		driver.findElement(By.name("lastName")).sendKeys(lName);

		int phoneNumber=123456789;
		  //converting from int to String
		driver.findElement(By.name("phone")).sendKeys(Integer.toString(phoneNumber));
		//driver.findElement(By.name("phone")).sendKeys(phoneNumber+"");
		
		String email="jonhsmith@email.com";
		driver.findElement(By.name("userName")).sendKeys(email);
		
		  //verify first name
		  //get the actual
		String actualfName=driver.findElement(By.name("firstName")).getAttribute("value");
	    
		//String size=driver.findElement(By.name("firstName")).getAttribute("sizes");
		//System.out.println(size);
		 //verify
		 /*if(fName.equals(actualfName)){
			 System.out.println("PASS");
		 }else{
			 System.out.println("FAIL");
			 System.out.println("Expected: "+fName);
			 System.out.println("Actual: "+actualfName);
		 }*/
		 compareStrings(fName,actualfName);
		 
		 String actuallName=driver.findElement(By.name("lastName")).getAttribute("value");
		  /*if(lName.equals(actuallName)){
			  System.out.println("PASS");
		  }else{
			  System.out.println("FAIL");
			  System.out.println("Expected: "+lName);
			  System.out.println("Actual: "+actuallName);
		  }*/
		  compareStrings(lName,actuallName);
		   //verify the phone number
		  String actualphoneNumber=driver.findElement(By.name("phone")).getAttribute("value");
		  compareStrings(Integer.toString(phoneNumber),actualphoneNumber);
		   //verify email
		  String actualEmail=driver.findElement(By.name("userName")).getAttribute("value");
		  compareStrings(email,actualEmail);
		  
		  //enter user name
		  String userName="test1";
		  driver.findElement(By.name("email")).sendKeys(userName);
		  //enter password
		  String password="test2";
		  driver.findElement(By.name("password")).sendKeys(password);
		  //confirm password
		  driver.findElement(By.name("confirmPassword")).sendKeys(password);
		  //sumbit
		  driver.findElement(By.name("register")).click();
		  
		  //compare first and last name
		 String fullName=fName+" "+lName;
		 String message=driver.findElement(By.xpath("//b")).getText();
		 int i1=message.indexOf(" ");
		 int i2=message.indexOf(",");
		 String actualFullName=message.substring(i1+1, i2);
		 //System.out.println(message);
		 compareStrings(fullName, actualFullName);
		 
		 //compare user name
		 String message2=driver.findElement(By.xpath("(//b)[2]")).getText();
		 //System.out.println(message2);
		 //int i3=message2.indexOf(userName);
		 int i3=message2.lastIndexOf(" ");
		 int i4=message2.indexOf(".");
		 String actualUserName=message2.substring(i3+1, i4);
		 //System.out.println(actualUserName);
		 compareStrings(userName, actualUserName);
		  
		  
		  
		}
       public static void compareStrings(String expected, String actual){
    	   if(expected.equals(actual)){
    		   System.out.println("PASS");
    	   }else{
    		   System.out.println("FAIL");
    		   System.out.println("Expected: "+expected);
 			  System.out.println("Actual: "+actual);
    	   }

       }
}
