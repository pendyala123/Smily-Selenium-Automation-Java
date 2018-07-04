package email_module_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MaropostEmailSegmentsPage {

	WebDriver driver;
    
    By useremail = By.id("user_email");

    By userpassword = By.id("user_password");

    By signin = By.name("commit");

    By signout = By.xpath("/html/body/header/div/nav/ul/li[7]/a");
    
    public MaropostEmailSegmentsPage(WebDriver driver) throws InterruptedException{

        this.driver = driver;
        
        Thread.sleep(3000);  
    }
    
    //Set user name in text box

    public void setUserEmail(String strUserName){

        driver.findElement(useremail).sendKeys(strUserName);;

    }

    //Set password in text box

    public void setUserPassword(String strPassword){

         driver.findElement(userpassword).sendKeys(strPassword);

    }

    //Click on login button

    public void clickLogin(){

            driver.findElement(signin).click();

    }
    
    //Click on logout button

    public void clickLogout(){

            driver.findElement(signout).click();

    }
    
    public void loginToMaropostWebApp(String strUserName,String strPasword) throws InterruptedException{

        //Fill user name

        this.setUserEmail(strUserName);
       
        //Fill password

        this.setUserPassword(strPasword);

        //Click Login button

        this.clickLogin(); 
        
        Thread.sleep(3000);
       
    }
    
    public void clickNewSegmentOption() throws InterruptedException{     
        
    	WebElement newSegment = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/i"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(newSegment).build().perform();
 
        WebElement menuOption = driver.findElement(By.linkText("New Segment"));
        
        menuOption.click();
        
        WebElement segmentName = driver.findElement(By.id("segment_name"));
        
        segmentName.sendKeys("Automation Segment 00");
        
        Thread.sleep(1000);
        
        WebElement addNewRule = driver.findElement(By.linkText("Add new rule"));
        
        addNewRule.click();
        
        Thread.sleep(1000);
        
        WebElement saveSegment = driver.findElement(By.name("commit"));
        
        saveSegment.click();
        
        Thread.sleep(1000);
    }
    
    public void clickEditSegmentOption() throws InterruptedException{     
        
    	WebElement segments = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[3]/a"));
        
    	segments.click();
    	
    	Thread.sleep(2000);
	
    	WebElement editSegment = driver.findElement(By.cssSelector("a[title=\"Edit segment\"]"));
    	
    	editSegment.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement editSegmentName = driver.findElement(By.id("segment_name"));
    	
    	editSegmentName.clear();
        
    	editSegmentName.sendKeys("Segment Edited");
        
        Thread.sleep(1000);
    	
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }
    
    public void clickDeleteSegmentOption() throws InterruptedException{     
        
    	WebElement segments = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[3]/a"));
        
    	segments.click();
    	
    	Thread.sleep(2000);
	
    	WebElement deleteSegment = driver.findElement(By.cssSelector("a[title=\"Delete segment permanently\"]"));
    	
    	deleteSegment.click();
    	
    	driver.switchTo().alert().accept();
    	
    	Thread.sleep(2000);	
    }
    
    public void clickDuplicateSegmentOption() throws InterruptedException{     
        
    	WebElement segments = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[3]/a"));
        
    	segments.click();
    	
    	Thread.sleep(2000);
	
    	WebElement duplicateSegment = driver.findElement(By.cssSelector("a[title=\"Create a duplicate segment\"]"));
    	
    	duplicateSegment.click();
    	
    	Thread.sleep(2000);
    	
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }
}
