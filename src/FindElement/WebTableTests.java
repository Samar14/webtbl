package FindElement;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableTests {
	  WebDriver driver;
	  WebElement table;
	  

	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", 
				"/Users/sunatulloabdullaev/Documents/Libraries/drivers/chromedriver");
	    driver=new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/tables");
		table=driver.findElement(By.id("table1"));
	}
	

	@After
	public void tearDown(){
		//driver.quit();
		//css# id name table1 =#table1
	}

	//@Test
	public void printTableText() {
		System.out.println(table.getText());
		//get the number of columns
		//#table1>thead td
		List<WebElement> columnNames=driver.findElements(By.cssSelector("#table1>thead th"));
		System.out.println("Number of columns "+columnNames.size());
		   for(WebElement columnName: columnNames){
			   System.out.println(columnName.getText());
		   }
		//only count the rows except headers
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println("Number of rows "+rows.size());
		   for(WebElement row:rows){
			   System.out.println(row.getText());
		   }	
	}
	
	//@Test
	public void printByCoordinates(){
		int row=3, col=2;
		String xpath=getCellData(row, col);
		WebElement cell=driver.findElement(By.xpath(xpath));
		System.out.println(cell.getText());
		
		row=4;
		col=4;
		xpath=getCellData(row, col);
		cell=driver.findElement(By.xpath(xpath));
		System.out.println(cell.getText());
	}		
	
   	public String getCellData(int row, int col){
		return "//table[@id='table1']/tbody/tr[" + row + "]/td[" + col + "]";
	}
	
	//@Test
	public void printCoordinates(){
		String str="Smith";
		//get all rows 
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
		System.out.println(rows.size());
    	//and text of all rows
		//see what row contains expected string
		//get the index of that row
		int rowNumber=0;
		  for(int i=0; i<rows.size(); i++){
			  if (rows.get(i).getText().contains(str)){
				  rowNumber=i+1;
				  break;
			  }
		  }
		System.out.println(rowNumber);
		
		String xpath="//table[@id='table1]/tbody/tr[" + rowNumber + "]/td";
		
		List<WebElement> cells=driver.findElements(By.xpath(xpath));
		  int colNumber=0;
		   for(int i=0; i<cells.size(); i++){
			  if (cells.get(i).getText().equals(str)){
				  colNumber=i+1;
				  break;
			  }
		   }
		System.out.println(colNumber);
	}
	
	//@Test
	public void printCoordinates2(){
		//find the table
		table=driver.findElement(By.id("table1"));
		//get the number of rows
		int totalRows=getTotalRows(table);
		System.out.println(totalRows);
		//get the number of columns
        int totalCols=getTotalCols(table);
        System.out.println(totalCols);
		//call getCellData() to build the xpath
		//do it for all cells
          for(int i=1; i<totalRows; i++){
        	  for(int j=1; j<totalCols; j++){
        		  String xpath=getCellData(i, j);
        		  System.out.print(driver.findElement(By.xpath(xpath)).getText() + "\t");
        	  }
          }
		}
	
	private int getTotalCols(WebElement table){
		return table.findElements(By.tagName("th")).size();
	}
	
	private int getTotalRows(WebElement table){
		//find out if the table has header
		  if(table.findElements(By.tagName("thead")).size()>0){
		      return table.findElements(By.tagName("tr")).size()-1;
		  }else{
			  return table.findElements(By.tagName("tr")).size();
		  }
		}	
}
