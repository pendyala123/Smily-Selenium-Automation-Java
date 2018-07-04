package email_module_test_cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import email_module_pages.MaropostEmailSegmentsPage;

public class MaropostEmailSegmentsTestCases {

	WebDriver driver;

    MaropostEmailSegmentsPage objLogin;
    
    ExtentReports extentreports = new ExtentReports(System.getProperty("user.dir") +"/test-output/MaropostSegmentsTestReport.html", true);
    
    ExtentTest maroposttest;

    @BeforeSuite

    public void setup(){

    	System.setProperty("webdriver.gecko.driver","/Users/maropost/Downloads/geckodriver");
    	
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://app-sandbox.maropost.com/accounts/4/segments");

    }
   
    // Test Case - 1 : Verifying the Sign In Section with valid Email & Password
    
	@Test
 
    public void test_verify_signin_section() throws InterruptedException {
        
        maroposttest = extentreports.startTest("test_verify_signin_section");
    	
    	//Create Login Page object

    	objLogin = new MaropostEmailSegmentsPage(driver);
    	
    	driver.manage().window().maximize();  
    	
    	maroposttest.log(LogStatus.INFO, "Opening new browser with maropost segments url");

    	//login to application

    	objLogin.loginToMaropostWebApp("jatin@maropost.com", "Maro123#");
    	
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
	
	// Test Case - 2 : To Create Segment
	
    @Test (dependsOnMethods = "test_verify_signin_section")
        
    public void test_to_create_on_new_segment() throws InterruptedException{
            
        maroposttest = extentreports.startTest("test_to_create_on_new_segment");
        	
        objLogin.clickNewSegmentOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on new segment option under segments");
            
        maroposttest.log(LogStatus.INFO, "Enter Segment Name");
            
        maroposttest.log(LogStatus.INFO, "Add Rule & Click On Save Segment Button");
           
        WebElement msg = driver.findElement(By.cssSelector(".flash"));
            
        String actualresult = msg.getText();
            
        String expectedresult = "Segment was successfully created.";
            
        if(actualresult.equalsIgnoreCase(expectedresult)){
            
            maroposttest.log(LogStatus.PASS, "Actual Result ::  " + actualresult );
        }
     }
    
     // Test Case - 3 : To Edit Segment
        
     @Test (dependsOnMethods = "test_to_create_on_new_segment")
            
     public void test_to_edit_segment() throws InterruptedException{
                
        maroposttest = extentreports.startTest("test_to_edit_segment");
            	
        objLogin.clickEditSegmentOption();
            	
        maroposttest.log(LogStatus.INFO, "Click on edit option under segment");
        
        maroposttest.log(LogStatus.INFO, "Enter update details");
              
        maroposttest.log(LogStatus.INFO, "Segment was updated successfully");
           
        WebElement msg = driver.findElement(By.cssSelector(".flash"));
        
        String actualresult = msg.getText();
        
        String expectedresult = "Segment was successfully updated.";
        
        if(actualresult.equalsIgnoreCase(expectedresult)){
        
        	maroposttest.log(LogStatus.PASS, "Actual Result ::  " + actualresult );
        }
     }	
      
     // Test Case - 4 : To Delete Segment
     
     @Test (dependsOnMethods = "test_to_edit_segment")
            
     public void test_to_delete_segment() throws InterruptedException{
                
        maroposttest = extentreports.startTest("test_to_delete_segment");
            	
        objLogin.clickDeleteSegmentOption();
            	
        maroposttest.log(LogStatus.INFO, "Click on delete option under segment");
        
        maroposttest.log(LogStatus.INFO, "Click on confirm delete option ");
              
        maroposttest.log(LogStatus.INFO, "Segment was deleted successfully");
     }	
     
     // Test Case - 5 : To Duplicate Segment
     
     @Test (dependsOnMethods = "test_to_delete_segment")
            
     public void test_to_duplicate_segment() throws InterruptedException{
                
        maroposttest = extentreports.startTest("test_to_duplicate_segment");
            	
        objLogin.clickDuplicateSegmentOption();
            	
        maroposttest.log(LogStatus.INFO, "Click on duplicate segment option under segment");
             
        maroposttest.log(LogStatus.INFO, "Segment was created successfully");
        
        WebElement msg = driver.findElement(By.cssSelector(".flash"));
            
        String actualresult = msg.getText();
            
        String expectedresult = "Segment was successfully created.";
            
        if(actualresult.equalsIgnoreCase(expectedresult)){
            
            maroposttest.log(LogStatus.PASS, "Actual Result ::  " + actualresult );
        }
     }	
     
     @AfterSuite (alwaysRun = true)
     public void tearDown() throws Exception {
	 
	   extentreports.endTest(maroposttest);
	 
	   extentreports.flush();
	  	
	   //extent.close();
	   
	   driver.quit();
	  
	} 

}
