package Vaccination.UMANG;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Set;

import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.inject.spi.Message;


public class Basic {
	static WebDriver driver = null;
	 String to = "sonoojaiswal1988@gmail.com";//change accordingly  
     String from = "sonoojaiswal1987@gmail.com"; 
     String host = "localhost";//or IP address  
	
	public static Properties Repository = new Properties();
	
	public WebElement getWebElement(String locator) {
		WebElement wb=null;
		try {
			
	
			
		//	System.out.print(Repository.getProperty(locator));
			
			/* FileReader reader=new FileReader("db.properties");  
		      
			    Properties p=new Properties();  
			    p.load(reader);  */
			      
			wb= getLocator(Repository.getProperty(locator));
		
			//wb= getLocator(locator);
			
		//	Reporter.log(Timestamp+" Fetcing locator value "+locator+"  from Property file");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wb;
	}
	
	public static WebElement getLocator(String locator) throws Exception {
		String[] split = locator.split(":");
		String locatorType = split[0];
		
	
		String locatorValue = split[1];	
		
		if (locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname")) || (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname")) || (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext")) || (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector")) || (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}

	public void WinHandle(String win) {
		Set<String> handles = driver.getWindowHandles(); 
		java.util.Iterator<String> windows = handles.iterator(); 
		String parent = windows.next(); 
		String child = windows.next();
		
		if (win=="child") {
		driver.switchTo().window(child);
		}
		else if(win=="parent") {
			driver.switchTo().window(parent);
		}
		
		
		}

/*
	public void Mail() {
		
		Properties properties=new Properties();  
		//fill all the information like host name etc.  
		Session session=Session.getInstance(properties,null);  
		MimeMessage message=new MimeMessage(session);  
		message.setFrom(new InternetAddress("sonoojaiswal@sssit.org"));  
		message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
        message.setSubject("Ping");  
        message.setText("Hello, this is example of sending email  ");  		
		}*/

	
}
