package email_module_test_cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import email_module_pages.MaropostEmailCampaignsPage;


public class MaropostEmailCampaignsTestCases {

    WebDriver driver;

    MaropostEmailCampaignsPage objLogin;
    
    ExtentReports extentreports = new ExtentReports(System.getProperty("user.dir") +"/test-output/MaropostCampaignsTestReport.html", true);
    
    ExtentTest maroposttest;

    @BeforeSuite

    public void setup(){

    	System.setProperty("webdriver.gecko.driver","/Users/maropost/Downloads/geckodriver");
    	
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://app-sandbox.maropost.com/accounts/200000/campaigns");

    }
   
    // Test Case - 1 : Verifying the Sign In Section with valid Email & Password
    
	@Test
 
    public void test_verify_signin_section() throws InterruptedException {
        
        maroposttest = extentreports.startTest("test_verify_signin_section");
    	
    	//Create Login Page object

    	objLogin = new MaropostEmailCampaignsPage(driver);
    	
    	driver.manage().window().maximize();  
    	
    	maroposttest.log(LogStatus.INFO, "Opening new browser with maropost campagains url");

    	//login to application

    	objLogin.loginToMaropostWebApp("gandhi@maropsot.com", "Smily@143");
    	
    	maroposttest.log(LogStatus.INFO, "Entering user email");
    	
    	maroposttest.log(LogStatus.INFO, "Entering user password");
    	
    	maroposttest.log(LogStatus.INFO, "Clicking on login button");
    	
        WebElement msg = driver.findElement(By.cssSelector(".flash"));
        
        String actualresult = msg.getText();
        
        String expectedresult = "Signed in successfully.";
        
        if(actualresult.equalsIgnoreCase(expectedresult)){
        
        	maroposttest.log(LogStatus.PASS, "Actual Result ::  " + actualresult );
        }
    }
	
	// Test Case - 2 : Create new campaign with schedule recurring
	
    @Test (dependsOnMethods = "test_verify_signin_section")
    
    public void test_click_on_new_campaign_schedule_recurring() throws InterruptedException{
        
    	maroposttest = extentreports.startTest("test_click_on_new_campaign_schedule_recurring");
    	
        objLogin.clickNewCampaignOption();
    	
        maroposttest.log(LogStatus.INFO, "Click on new campaign");
        
        objLogin.enterNewCampaignDetails("Selenium", "Automation", "", "gcp", "gcpdsp@gmail.com", "gcpdsp@gmail.com", "abc pendyala", " space 1 (2)");
 
        maroposttest.log(LogStatus.INFO, "Entering New Campaign Details");
        
        JavascriptExecutor jse = (JavascriptExecutor) driver;
    	
        jse.executeScript("window.scrollBy(0,500)", "");
        
        objLogin.newCampaignNextButton();
        
        maroposttest.log(LogStatus.INFO, "Click on next button");
        
        jse.executeScript("window.scrollBy(0,300)", "");
        
        objLogin.newCampaignScheduleRecurring();
        
        maroposttest.log(LogStatus.INFO, "Click on Schedule button");
        
        maroposttest.log(LogStatus.INFO, "Click on confirm schedule option button");
        
        Thread.sleep(5000);
        
        WebElement successmsg = driver.findElement(By.xpath("//*[@id=\"body\"]/div[1]"));
        
        String actualresult = successmsg.getText();
        
        String expectedresult = "Campaign was successfully updated.";
        
        if(actualresult.equalsIgnoreCase(expectedresult)){
        
        	maroposttest.log(LogStatus.PASS, "Result ::  " + actualresult );
        }
        Thread.sleep(3000);
    }
    
    // Test Case 3 : Edit the Campaign
    
	@Test (dependsOnMethods = "test_click_on_new_campaign_schedule_recurring")
    
    public void test_to_edit_campaign() throws InterruptedException{
        
    	maroposttest = extentreports.startTest("test_to_edit_campaign");
    	
    	maroposttest.log(LogStatus.INFO, "Click on edit button");
        
        objLogin.editCampaign();
        
        JavascriptExecutor jse = (JavascriptExecutor) driver;
    	
        jse.executeScript("window.scrollBy(0,500)", "");
        
        objLogin.newCampaignNextButton();
        
        maroposttest.log(LogStatus.INFO, "Click on next button");
        
        jse.executeScript("window.scrollBy(0,300)", "");
        
        objLogin.newCampaignSchedulePriority();
        
        maroposttest.log(LogStatus.INFO, "Click on Schedule button");
        
        maroposttest.log(LogStatus.INFO, "Click on confirm schedule option button");
        
        Thread.sleep(5000);
        
        maroposttest.log(LogStatus.INFO, "Campaign was updated successfully");
        
        Thread.sleep(3000);
        
        WebElement successmsg = driver.findElement(By.xpath("//*[@id=\"body\"]/div[1]"));
        
        String actualresult = successmsg.getText();
        
        String expectedresult = "Campaign was successfully updated.";
        
        if(actualresult.equalsIgnoreCase(expectedresult)){
        
        	maroposttest.log(LogStatus.PASS, "Result ::  " + actualresult );
        }
        Thread.sleep(5000);
    }
    
	 // Test Case 4 : Delete the Campaign
	
	@Test (dependsOnMethods = "test_to_edit_campaign")
    
    public void test_to_delete_campaign() throws InterruptedException{
        
    	maroposttest = extentreports.startTest("test_to_delete_campaign");
    	
    	maroposttest.log(LogStatus.INFO, "Click on delete button");
        
        objLogin.deleteCampaign();
        
        maroposttest.log(LogStatus.INFO, "Click on confirmation delete pop button");
        
        maroposttest.log(LogStatus.INFO, "Campaign was deleted successfully");
        
        Thread.sleep(3000);
    }	
  
    // Test Case - 5 : Create new campaign with schedule priority
    
    @Test (dependsOnMethods = "test_to_delete_campaign")
    
    public void test_click_on_new_campaign_schedule_priority() throws InterruptedException{
        
    	maroposttest = extentreports.startTest("test_click_on_new_campaign_schedule_priority");
    	
        objLogin.clickNewCampaignOption();
    	
        maroposttest.log(LogStatus.INFO, "Click on new campaign");
       
        maroposttest.log(LogStatus.INFO, "Entering New Campaign Details");
        
        objLogin.enterNewCampaignDetails("Selenium", "Automation", "", "gcp", "gcpdsp@gmail.com", "gcpdsp@gmail.com", "abc pendyala", " space 1 (2)");
        
        JavascriptExecutor jse = (JavascriptExecutor) driver;
    	
        jse.executeScript("window.scrollBy(0,500)", "");
       
        objLogin.newCampaignNextButton();
        
        maroposttest.log(LogStatus.INFO, "Click on next button");
        
        jse.executeScript("window.scrollBy(0,300)", "");
        
        objLogin.newCampaignSchedulePriority();
        
        maroposttest.log(LogStatus.INFO, "Click on Schedule button");
        
        maroposttest.log(LogStatus.INFO, "Click on confirm schedule option button");
        
        Thread.sleep(5000);

        WebElement successmsg = driver.findElement(By.xpath("//*[@id=\"body\"]/div[1]"));
        
        String actualresult = successmsg.getText();
        
        String expectedresult = "Campaign was successfully updated.";
        
        if(actualresult.equalsIgnoreCase(expectedresult)){
        
        	maroposttest.log(LogStatus.PASS, "Result ::  " + actualresult );
        }
        
        Thread.sleep(5000);
    }
    
    // Test Case - 6 : Create new campaign with schedule priority without date
    
    @Test (dependsOnMethods = "test_click_on_new_campaign_schedule_priority")
    
    public void test_click_on_new_campaign_schedule_priority_without_Date() throws InterruptedException{
        
    	maroposttest = extentreports.startTest("test_click_on_new_campaign_schedule_priority_without_Date");
    	
        objLogin.clickNewCampaignOption();
    	
        maroposttest.log(LogStatus.INFO, "Click on new campaign");
      
        objLogin.enterNewCampaignDetails("Selenium", "Automation", "", "gcp", "gcpdsp@gmail.com", "gcpdsp@gmail.com", "abc pendyala", " space 1 (2)");
      
        maroposttest.log(LogStatus.INFO, "Entering New Campaign Details");
        
        JavascriptExecutor jse = (JavascriptExecutor) driver;
    	
        jse.executeScript("window.scrollBy(0,500)", "");
       
        objLogin.newCampaignNextButton();
        
        maroposttest.log(LogStatus.INFO, "Click on next button");
        
        jse.executeScript("window.scrollBy(0,300)", "");
        
        objLogin.newCampaignSchedulePriorityWithoutDate();
        
        maroposttest.log(LogStatus.INFO, "Click on Schedule button");
        
        maroposttest.log(LogStatus.INFO, "Click on confirm schedule option button");
        
        Thread.sleep(5000);
        
        WebElement successmsg = driver.findElement(By.xpath("//*[@id=\"error_explanation\"]/ul/li"));
        
        String actualresult = successmsg.getText();
        
        String expectedresult = "Send at can't be blank.";
        
        if(actualresult.equalsIgnoreCase(expectedresult)){
        
        	maroposttest.log(LogStatus.FAIL, "Result ::  " + actualresult );
        }
        Thread.sleep(5000);
    }
    
    // Test Case - 7 : Create new AB campaign
    
    @Test (dependsOnMethods = "test_click_on_new_campaign_schedule_priority_without_Date")
    
    public void test_create_new_AB_campaign() throws InterruptedException{
        
    	maroposttest = extentreports.startTest("test_create_new_AB_campaign");
    	
        objLogin.clickNewABCampaignOption();
    	
        maroposttest.log(LogStatus.INFO, "Click on new AB campaign");
 
        objLogin.enterNewABCampaignDetails("Selenium", "gcpdsp@gmail.com", "gcpdsp@gmail.com");
       
        maroposttest.log(LogStatus.INFO, "Entering New AB Campaign Details");
        
        JavascriptExecutor jse = (JavascriptExecutor) driver;
    	
        jse.executeScript("window.scrollBy(0,500)", "");
      
        objLogin.newABCampaignNextButton(); 
        
        Thread.sleep(3000);
        
        objLogin.newABCampaignGroupSelection("HELLO", "HELLO", "Hi Group A", "Hi Group B", "GCP", "DSP", "50", "50");
        
        objLogin.newGroupACampaignSchedulePriority();
        
        Thread.sleep(2000);
        
        objLogin.newGroupBCampaignSchedulePriority();
        
        Thread.sleep(2000);
        
        objLogin.newABCampaignSchedulePriority();
        
        maroposttest.log(LogStatus.INFO, "AB Campaign was updated successfully");
        
        Thread.sleep(3000);
        
        WebElement successmsg = driver.findElement(By.xpath("//*[@id=\"body\"]/div[1]"));
        
        String actualresult = successmsg.getText();
        
        String expectedresult = "Campaign was successfully updated.";
        
        if(actualresult.equalsIgnoreCase(expectedresult)){
        
        	maroposttest.log(LogStatus.PASS, "Result ::  " + actualresult );
        }
        Thread.sleep(5000);
        
    }
    
    // Test Case - 8 : Create new campaign tag
	
    @Test (dependsOnMethods = "test_create_new_AB_campaign")
    
    public void test_click_on_new_campaign_tag() throws InterruptedException{
        
    	maroposttest = extentreports.startTest("test_click_on_new_campaign_tag");
    	
        objLogin.clickNewCampaignTag();
    	
        maroposttest.log(LogStatus.INFO, "Click on new campaign tag");
        
        maroposttest.log(LogStatus.INFO, "Enter new campaign tag name");
        
    }
    
    // Test Case - 9 : Create new campaign tag
	
    @Test (dependsOnMethods = "test_create_new_AB_campaign")
    
    public void test_click_on_new_campaign_tag_without_name() throws InterruptedException{
        
    	maroposttest = extentreports.startTest("test_click_on_new_campaign_tag_without_name");
    	
        objLogin.clickNewCampaignTagWithoutName();
    	
        maroposttest.log(LogStatus.INFO, "Click on new campaign tag");
        
        maroposttest.log(LogStatus.INFO, "Without campaign tag name");
        
        driver.switchTo().activeElement();
    	
    	Thread.sleep(2000);
    	
    	driver.findElement(By.id("ctag_name")).sendKeys("");
    	
    	Thread.sleep(2000);
    	
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    	
    	WebElement warningmsg = driver.findElement(By.xpath("//*[@id=\"body\"]/div[1]"));
        
        String actualresult = warningmsg.getText();
        
        String expectedresult = "Name can't be blank";
        
        if(actualresult.equalsIgnoreCase(expectedresult)){
        
        	maroposttest.log(LogStatus.FAIL, "Result ::  " + actualresult );
        }
        Thread.sleep(5000); 
    }
    
    @AfterSuite (alwaysRun = true)
	public void tearDown() throws Exception {
 
    	extentreports.endTest(maroposttest);
    	extentreports.flush();
    	//extent.close();
    	driver.quit();
  
	}
}