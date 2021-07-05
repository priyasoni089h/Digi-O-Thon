package RedBus.Booking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Bus {
	String str;
	static WebDriver driver = null;
	 int i;
  @Test
  public void f() throws Throwable {
	  
	  driver.get("https://www.redbus.in/");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@data-message='Please enter a source city']")).click();
	  driver.findElement(By.xpath("//*[@data-message='Please enter a source city']")).sendKeys("Pune");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@data-message='Please enter a source city']")).sendKeys(Keys.ENTER);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//*[@data-message='Please enter a destination city']")).sendKeys("Bengaluru");
	  Thread.sleep(2000);
	  driver.findElement((By.xpath("//*[@id='onward_cal']"))).click();
	 
	  DateFormat dateFormat2 = new SimpleDateFormat("dd"); 
      Date date2 = new Date();
      String today = dateFormat2.format(date2); 
    //  System.out.println("today is	"+today);
      
      int start =Integer.parseInt(today);
    //find the calendar
      WebElement dateWidget = driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr[4]/td[1]"));
      int add=start+8;
      driver.findElement(By.xpath("//td[contains(text(),"+add+")]")).click();
      driver.findElement(By.xpath("//button[@id='search_btn']")).click();
	  Thread.sleep(2000);

	  WebElement Count = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div[2]/div[2]/div[1]/span[1]/span"));

	  System.out.println("count is of total buses available is " + Count.getText());
	  String total= Count.getText();
	
	 // System.out.println("after substring: " + total.substring(0,total.length()-5));
	  String str=total.substring(0,total.length()-5);
	 
	    
	  WebElement Detail= 	driver.findElement(By.xpath("/html/body/section/div[2]/div[1]/div/div[2]/div[2]/div[3]/div/ul/div[1]/li/div"));
	  String info= Detail.getText();
	  System.out.println("Bus Details (Name,AC or non AC,Departure time and place,Duration,Arrival time and date,Ratings,Fare,Seats Available) are : " + info);
	 	
	/*	
	  Email email = new SimpleEmail();
	  email.setHostName("smtp.gmail.com");
	//  email.setHostName("corp.amdocs.com");
	  
	  email.setSmtpPort(997);
	  email.setAuthenticator(new DefaultAuthenticator("sampadasonawane86@gmail.com", "Pinkal@3022"));
	  email.setSSLOnConnect(true);
	  email.setFrom("sampadasonawane86@gmail.com");
	  email.setSubject("TestMail");
	  email.setMsg("This is a test mail ... :-)");
	  email.addTo("sampadasonawane86@gmail.com");
	  email.send(); */

	  
  }
  @BeforeTest
  public void beforeClass() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Automation\\drivers\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  
	
  }

}
