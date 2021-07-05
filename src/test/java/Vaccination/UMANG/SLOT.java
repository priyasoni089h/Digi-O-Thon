package Vaccination.UMANG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class SLOT extends Basic{
	static WebDriver driver = null;
	int size,ycord;
	String vac_count;
	WebElement vacc_cnt;
	
	 @BeforeTest
	  public void beforeTest() {
		
		  System.setProperty("webdriver.chrome.driver","C:\\Automation\\drivers\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		//  driver.manage().deleteAllCookies();
		
	  }
	 
      @Test
      public void Check_Slot() throws Throwable
    {  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://web.umang.gov.in/web_new/home");
	  driver.findElement(By.xpath("//input[@id='mat-input-0']")).click();
	  driver.findElement(By.xpath("//input[@id='mat-input-0']")).sendKeys("7567860609");
	  driver.findElement(By.xpath("//input[@id='mat-input-1']")).click();
	  driver.findElement(By.xpath("//input[@id='mat-input-1']")).sendKeys("9729");
	
	WebElement C1 = driver.findElement(By.xpath("/html/body/app-root/my-login-form/mat-card/mat-card-content/div/form/div[2]/div/div[1]/span[1]"));

	System.out.println("1st character is " + C1.getText() );
	
	WebElement C2 = driver.findElement(By.xpath("/html/body/app-root/my-login-form/mat-card/mat-card-content/div/form/div[2]/div/div[1]/span[2]"));

	System.out.println("2nd character is " + C2.getText() );
	
	WebElement C3 = driver.findElement(By.xpath("/html/body/app-root/my-login-form/mat-card/mat-card-content/div/form/div[2]/div/div[1]/span[3]"));

	System.out.println("3rd character is " + C3.getText() );
	
	WebElement C4 = driver.findElement(By.xpath("/html/body/app-root/my-login-form/mat-card/mat-card-content/div/form/div[2]/div/div[1]/span[4]"));

	System.out.println("4th character is " + C4.getText() );
	
	WebElement C5 = driver.findElement(By.xpath("/html/body/app-root/my-login-form/mat-card/mat-card-content/div/form/div[2]/div/div[1]/span[5]"));

	System.out.println("5th character is " + C5.getText() );
	
	WebElement C6 = driver.findElement(By.xpath("/html/body/app-root/my-login-form/mat-card/mat-card-content/div/form/div[2]/div/div[1]/span[6]"));

	System.out.println("6th character is " + C6.getText() );
	
	String s= C1.getText();
	s+= C2.getText();
	s+= C3.getText();
	s+= C4.getText();
	s+= C5.getText();
	s+= C6.getText();
 	System.out.println("Captcha is ="+s);
 
 	driver.findElement(By.xpath("//*[@id=\"mat-input-2\"]")).sendKeys(s);
 
 	driver.findElement(By.xpath("//button[text()='LOGIN']")).click();

 	Thread.sleep(3000);

 	driver.findElement(By.xpath("/html/body/app-root/app-appcontainer/div/mat-drawer-container/mat-drawer-content/app-home/div[1]/div/div[1]/div/app-home-data/div[3]/div[2]/ngx-slick-carousel/div/div/div/div/div[1]/div/div[2]/p\n")).click();

 	size = driver.findElements(By.tagName("iframe")).size();
 	System.out.println("iframe size="+size);

 	driver.switchTo().frame(0);

 	driver.findElement(By.xpath("//h4[contains(text(),'Nearest Vaccination Centre')]")).click();

 	driver.findElement(By.xpath("//*[@id='mat-tab-label-0-1']/div")).click();
 	System.out.println("iframe size="+size);

 	Thread.sleep(5000);
 	driver.findElement(By.xpath("//*[@id='state']/div/span")).click();

 	WebElement selectMyElement = driver.findElement((By.xpath("//*[@id='state']/div/div/div[3]/input")));
 	Thread.sleep(5000);

 	selectMyElement.sendKeys("Maharashtra");
 	driver.findElement((By.xpath("//*[@id='state']/div/div/div[3]/input"))).sendKeys(Keys.TAB);

 	driver.findElement(By.xpath("//*[@id='district']/div/span")).click();

 	WebElement selectdist = driver.findElement((By.xpath("//*[@id='district']/div/div/div[2]/input")));
 	Thread.sleep(5000);

 	selectdist.sendKeys("Pune");
 	driver.findElement((By.xpath("//*[@id='district']/div/div/div[2]/input"))).sendKeys(Keys.TAB);
 	driver.findElement(By.xpath("//button[@class='btn']")).click();

 	System.out.println("iframe size="+size);

 	driver.findElement(By.xpath("//*[@id='mat-dialog-0']/app-book-instructions-popup/div/mat-dialog-actions/div/button/span")).click();

 	System.out.println("iframe size="+size);

 	JavascriptExecutor js = (JavascriptExecutor)driver;
//This will scroll the page till the element is found		
 	String command1 = "window.scrollBy(0,1000)";
// First scroll vertically
 	js.executeScript(command1);
 	Thread.sleep(2000);
// Second scroll vertically
 	js.executeScript(command1);
 	Thread.sleep(2000);
// Third scroll vertically
 	js.executeScript(command1);

 	WebDriverWait wait = new WebDriverWait(driver, 80);
 	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Filter']"))); 
 	((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);

//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//driver.findElement(By.xpath("/html/body/app-root/app-app-root/app-app-tile-view-container/div[2]/div/div[2]/app-view-slot/div[3]/div[2]/div/ul/li[3]/button")).click();


 	driver.findElement(By.xpath("//*[@id='mat-dialog-1']/app-book-appointment-filter/mat-dialog-content/div/div[1]/ul/li[2]")).click();
 	Thread.sleep(500);
 	driver.findElement(By.xpath("//*[@id=\"mat-dialog-1\"]/app-book-appointment-filter/mat-dialog-content/div/div[2]/ul/li[2]")).click();
 	Thread.sleep(500);
 	driver.findElement(By.xpath("//*[@id='mat-dialog-1']/app-book-appointment-filter/mat-dialog-actions/div/button[2]")).click();
//driver.findElement(By.xpath("//*[@id='mat-dialog-3']/app-book-appointment-filter/mat-dialog-content/div/div[2]/ul/li[2]")).click();
			//Thread.sleep(3000);
	
	//System.out.println(driver.getPageSource());
 	Thread.sleep(5000);
 	WebElement Count = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-app-root[1]/app-app-tile-view-container[1]/div[2]/div[1]/div[2]/app-view-slot[1]/div[3]/div[2]/h5[1]"));

//System.out.println("1st character is " + Count.getText());
 	String centre= Count.getText();
//centre.substring(8,-1);
 	System.out.println("after substring: " + centre.substring(8,centre.length()-1));
 	String str=centre.substring(8,centre.length()-1);
 	int hospital_cnt = Integer.parseInt(str);

 //	WebElement vacc_cnt = driver.findElement(By.xpath("/html/body/app-root/app-app-root/app-app-tile-view-container/div[2]/div/div[2]/app-view-slot/div[3]/div[4]/cdk-virtual-scroll-viewport/div[1]/div[1]/div[2]/div/div[1]/div/div/div"));
 //	String vac_count=vacc_cnt.getText();
//int vac_count= Integer.parseInt(v);
//System.out.println("1st character is " + vacc_cnt);

//WebElement add = driver.findElement(By.xpath("/html/body/app-root/app-app-root/app-app-tile-view-container/div[2]/div/div[2]/app-view-slot/div[3]/div[4]/cdk-virtual-scroll-viewport/div[1]/div[1]/div[1]/div/div"));
//String address=add.getText();
 //	WebElement add = driver.findElement(By.xpath("/html/body/app-root/app-app-root/app-app-tile-view-container/div[2]/div/div[2]/app-view-slot/div[3]/div[4]/cdk-virtual-scroll-viewport/div[1]/div[j]/div[1]/div/h3"));
 //	String address=add.getText();
 	
	

 	for(int i=1;i<=7;i++)
  {	
 		
	for(int j=1;j<=hospital_cnt;j++)
	{	
		//WebElement vacc_cnt = driver.findElement(By.xpath("/html/body/app-root/app-app-root/app-app-tile-view-container/div[2]/div/div[2]/app-view-slot/div[3]/div[4]/cdk-virtual-scroll-viewport/div[1]/div[1]/div[2]/div/div[1]/div/div/div"));
		//vac_count=vacc_cnt.getText();
		
		try {
			
			 vacc_cnt = driver.findElement(By.xpath("/html/body/app-root/app-app-root/app-app-tile-view-container/div[2]/div/div[2]/app-view-slot/div[3]/div[4]/cdk-virtual-scroll-viewport/div[1]/div["+j+"]/div[2]/div/div[1]/div/div/div"));
			
		}
			catch(Exception e) {
				vacc_cnt = driver.findElement(By.xpath("/html/body/app-root/app-app-root/app-app-tile-view-container/div[2]/div/div[2]/app-view-slot/div[3]/div[4]/cdk-virtual-scroll-viewport/div[1]/div["+j+"]/div[2]/div/div[1]/div/div/div/div[1]"));
				
			}
		
		vac_count=vacc_cnt.getText();
		
		if(!((vac_count.equals("NA")	|| vac_count.equals("0"))))
		{	
			WebElement add = driver.findElement(By.xpath("/html/body/app-root/app-app-root/app-app-tile-view-container/div[2]/div/div[2]/app-view-slot/div[3]/div[4]/cdk-virtual-scroll-viewport/div[1]/div["+j+"]/div[1]/div/div"));
			 String address=add.getText();
			 	
			 	WebElement date = driver.findElement(By.xpath("/html[1]/body[1]/app-root[1]/app-app-root[1]/app-app-tile-view-container[1]/div[2]/div[1]/div[2]/app-view-slot[1]/div[3]/div[4]/div[1]/div[2]/div[2]/div["+i+"]/div[1]"));
			 	String day=date.getText();
			 	
			 	WebElement name = driver.findElement(By.xpath("/html/body/app-root/app-app-root/app-app-tile-view-container/div[2]/div/div[2]/app-view-slot/div[3]/div[4]/cdk-virtual-scroll-viewport/div[1]/div["+j+"]/div[1]/div/h3"));
				 String Centre_name=name.getText();
				 
				 		 
			System.out.println("You Got available slot!!!!!!!!!!!!!!!!!!!");
			System.out.println("On Date "+day);
			System.out.println("centre Name is  "+Centre_name);
			System.out.println("centre Location is  "+address);		
			System.out.println("Available vaccine detail with Count"+vac_count);
			break;			
		}
		
	//j++;
		
	}
	if(!((vac_count.equals("NA")	|| vac_count.equals("0"))))
	{
		break;
	}
	
}

  	}
      
  
}
