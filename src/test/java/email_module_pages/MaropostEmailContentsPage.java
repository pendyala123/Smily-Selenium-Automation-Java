package email_module_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MaropostEmailContentsPage {

	WebDriver driver;
    
    By useremail = By.id("user_email");

    By userpassword = By.id("user_password");

    By signin = By.name("commit");

    By signout = By.xpath("/html/body/header/div/nav/ul/li[7]/a");
    
    public MaropostEmailContentsPage(WebDriver driver) throws InterruptedException{

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
        
        Thread.sleep(3000);
        
        //Fill password

        this.setUserPassword(strPasword);

        Thread.sleep(3000);
        
        //Click Login button

        this.clickLogin(); 
        
        Thread.sleep(10000);
       
    }
    
    public void clickNewContentOption() throws InterruptedException{     
        
    	WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/i"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
 
        WebElement newContent = driver.findElement(By.linkText("New Content"));
        
        newContent.click();
        
        driver.switchTo().activeElement();
    	
    	Thread.sleep(2000);
    	
    	WebElement contentName = driver.findElement(By.id("content_name"));
        
    	contentName.sendKeys("Automation Content");
    	
    	WebElement create = driver.findElement(By.name("commit"));
        
        create.click();
        
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/iframe")).sendKeys("Hi");
        
        JavascriptExecutor jse = (JavascriptExecutor) driver;
    	
        jse.executeScript("window.scrollBy(0,500)", "");
        
        driver.findElement(By.name("commit")).click(); 
        
        Thread.sleep(2000);
    }
}
