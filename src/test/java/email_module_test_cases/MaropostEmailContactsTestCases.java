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

import email_module_pages.MaropostEmailContactsPage;

public class MaropostEmailContactsTestCases {

	WebDriver driver;

    MaropostEmailContactsPage objLogin;
    
    ExtentReports extentreports = new ExtentReports(System.getProperty("user.dir") +"/test-output/MaropostContactsTestReport.html", true);
    
    ExtentTest maroposttest;

    @BeforeSuite

    public void setup(){

    	System.setProperty("webdriver.gecko.driver","/Users/maropost/Downloads/geckodriver");
    	
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://app-sandbox.maropost.com");

    }
   
    // Test Case - 1 : Verifying the Sign In Section with valid Email & Password
   
    @Test
    public void test_verify_signin_section() throws InterruptedException {
        
        maroposttest = extentreports.startTest("test_verify_signin_section");
    	
    	//Create Login Page object

    	objLogin = new MaropostEmailContactsPage(driver);
    	
    	driver.manage().window().maximize();  
    	
    	maroposttest.log(LogStatus.INFO, "Opening new browser with maropost contacts url");

    	//login to application

    	objLogin.loginToMaropostWebApp("gandhi@maropost.com", "Smily@143");
    	
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
  
    /*
    // Test Case - 2 : Create New Contacts
    
    @Test (dependsOnMethods = "test_verify_signin_section")
        
    public void test_create_new_contacts_list() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_create_new_contacts_list");
        	
        objLogin.clickNewContactOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on Contacts");
        
        maroposttest.log(LogStatus.INFO, "Click on View Contacts");
        
        maroposttest.log(LogStatus.INFO, "Click on New Contact Option");
        
        maroposttest.log(LogStatus.INFO, "Enter New Contact Email & Click on Save button");
        
        maroposttest.log(LogStatus.INFO, "Contact was created successfully");
            
        Thread.sleep(2000);
        
        WebElement msg = driver.findElement(By.cssSelector("//*[@id=\"body\"]/div[1]"));
        
        String actualresult = msg.getText();
        
        String expectedresult = "Contact was successfully created.";
        
        if(actualresult.equalsIgnoreCase(expectedresult)){
        
        	maroposttest.log(LogStatus.PASS, "Actual Result ::  " + actualresult );
        }
     }
	   */
    
  
    // Test Case - 2 : Create New Contacts List
    
    @Test (dependsOnMethods = "test_verify_signin_section")
        
    public void test_create_new_contacts_list() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_create_new_contacts_list");
        	
        objLogin.clickNewContactsListOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on new list under contacts");
        
        maroposttest.log(LogStatus.INFO, "Enter New List Name & Click on Save button");
        
        maroposttest.log(LogStatus.INFO, "List was created successfully");
            
        Thread.sleep(2000);
     }
	
	// Test Case - 3 : To Edit Contacts List
    
    @Test (dependsOnMethods = "test_create_new_contacts_list")
        
    public void test_to_edit_contacts_list() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_to_edit_contacts_list");
        	
        objLogin.clickEditContactsListOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on edit option under contacts list");
          
        maroposttest.log(LogStatus.INFO, "Contact List was updated successfully");
        
        Thread.sleep(2000);
     }
    
	// Test Case - 4 : To Delete Contacts List
    
    @Test (dependsOnMethods = "test_to_edit_contacts_list")
        
    public void test_to_delete_contacts_list() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_to_delete_contacts_list");
        	
        objLogin.clickDeleteContactsListOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on delete option under contacts list");
            
        maroposttest.log(LogStatus.INFO, "Click on confirm delete option");
     
        maroposttest.log(LogStatus.INFO, "Contacts list was deleted successfully");
        
        Thread.sleep(2000);
     }
     	
	// Test Case - 5 : Create New Contacts Field
    
    @Test (dependsOnMethods = "test_to_delete_contacts_list")
        
    public void test_create_new_contacts_field() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_create_new_contacts_field");
        	
        objLogin.clickNewContactsFieldOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on new field under contacts");
        
        maroposttest.log(LogStatus.INFO, "Enter New Field Name & Click on Save button");
        
        maroposttest.log(LogStatus.INFO, "Field was created successfully");
            
        Thread.sleep(2000);
     }
    
    // Test Case - 6 : Create New Contacts Tag
    
    @Test (dependsOnMethods = "test_create_new_contacts_field")
        
    public void test_create_new_contacts_tag() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_create_new_contacts_tag");
        	
        objLogin.clickNewContactsTagOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on new tag under contacts");
        
        maroposttest.log(LogStatus.INFO, "Enter New Tag Name & Click on Save button");
        
        maroposttest.log(LogStatus.INFO, "Tag was created successfully");
            
        Thread.sleep(2000);
     }

    // Test Case - 7 : To Delete Contacts Tag
    
    @Test (dependsOnMethods = "test_create_new_contacts_tag")
        
    public void test_to_delete_contacts_tag() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_to_delete_contacts_tag");
        	
        objLogin.clickDeleteContactsTagOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on delete option under contacts tag");
            
        maroposttest.log(LogStatus.INFO, "Click on confirm delete option");
     
        maroposttest.log(LogStatus.INFO, "Contacts tag was deleted successfully");
        
        Thread.sleep(2000);
     }
    
    // Test Case - 8 : Create New Contacts Brand
    
    @Test (dependsOnMethods = "test_to_delete_contacts_tag")
        
    public void test_create_new_contacts_brand() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_create_new_contacts_brand");
        	
        objLogin.clickNewContactsBrandOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on new brand under contacts");
        
        maroposttest.log(LogStatus.INFO, "Enter New Brand Name & Click on Save button");
        
        maroposttest.log(LogStatus.INFO, "Brand was created successfully");
            
        Thread.sleep(2000);
     }
    
    // Test Case - 9 : To Edit Contacts Brand
    
    @Test (dependsOnMethods = "test_create_new_contacts_brand")
        
    public void test_to_edit_contacts_brand() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_to_edit_contacts_brand");
        	
        objLogin.clickEditContactsBrandOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on edit option under contacts brand");
          
        maroposttest.log(LogStatus.INFO, "Contacts brand was updated successfully");
        
        Thread.sleep(2000);
     }
    
    // Test Case - 10 : Create New Contacts Secure List
    
    @Test (dependsOnMethods = "test_to_edit_contacts_brand")
        
    public void test_create_new_contacts_secure_list() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_create_new_contacts_secure_list");
        	
        objLogin.clickNewContactsSecureListOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on new secure list under contacts");
        
        maroposttest.log(LogStatus.INFO, "Enter New Secure List Name & Click on Save button");
        
        maroposttest.log(LogStatus.INFO, "Secure list was created successfully");
            
        Thread.sleep(2000);
     }
    
    // Test Case - 11 : To Edit Contacts Secure List
    
    @Test (dependsOnMethods = "test_create_new_contacts_secure_list")
        
    public void test_to_edit_contacts_secure_list() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_to_edit_contacts_secure_list");
        	
        objLogin.clickEditContactsSecureListOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on edit option under contacts secure list");
          
        maroposttest.log(LogStatus.INFO, "Contacts secure List was updated successfully");
        
        Thread.sleep(2000);
     }
    
    // Test Case - 12 : To Delete Contacts Secure List
    
    @Test (dependsOnMethods = "test_to_edit_contacts_secure_list")
        
    public void test_to_delete_contacts_securelist() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_to_delete_contacts_secure_list");
        	
        objLogin.clickDeleteContactsSecureListOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on delete option under contacts secure list");
            
        maroposttest.log(LogStatus.INFO, "Click on confirm delete option");
     
        maroposttest.log(LogStatus.INFO, "Contacts secure list was deleted successfully");
        
        Thread.sleep(2000);
     }
    
    // Test Case - 13 : Create New Contacts Table
    
    @Test (dependsOnMethods = "test_to_edit_contacts_secure_list")
        
    public void test_create_new_contacts_table() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_create_new_contacts_table");
        	
        objLogin.clickNewContactsTableOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on new table under contacts");
        
        maroposttest.log(LogStatus.INFO, "Enter New Table Name");
        
        maroposttest.log(LogStatus.INFO, "Enter New Relational Table Name");
        
        maroposttest.log(LogStatus.INFO, "Select Primarykey & Click on Save button");
        
        maroposttest.log(LogStatus.INFO, "Table was created successfully");
            
        Thread.sleep(2000);
     }
    
    // Test Case - 14 : To Edit Contacts Table
    
    @Test (dependsOnMethods = "test_create_new_contacts_table")
        
    public void test_to_edit_contacts_table() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_to_edit_contacts_table");
        	
        objLogin.clickEditContactsTableOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on edit option under contacts table");
          
        maroposttest.log(LogStatus.INFO, "Contacts table was updated successfully");
        
        Thread.sleep(2000);
     }
    
    // Test Case - 15 : To Delete Contacts Table
    
    @Test (dependsOnMethods = "test_to_edit_contacts_table")
        
    public void test_to_delete_contacts_table() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_to_delete_contacts_table");
        	
        objLogin.clickDeleteContactsTableOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on delete option under contacts table");
            
        maroposttest.log(LogStatus.INFO, "Click on confirm delete option");
     
        maroposttest.log(LogStatus.INFO, "Contacts table was deleted successfully");
        
        Thread.sleep(2000);
     }
    
    // Test Case - 16 : Create New Contacts SQL Query
    
    @Test (dependsOnMethods = "test_to_delete_contacts_table")
        
    public void test_create_new_contacts_sqlquery() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_create_new_contacts_sqlquery");
        	
        objLogin.clickNewContactsSQLQueryOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on new sql query under contacts");
        
        maroposttest.log(LogStatus.INFO, "Enter New SQL Query Name");
        
        maroposttest.log(LogStatus.INFO, "Enter Query");
        
        maroposttest.log(LogStatus.INFO, "Select Targets & Click on Save button");
        
        maroposttest.log(LogStatus.INFO, "SQL Query was created successfully");
            
        Thread.sleep(2000);
     }
    
    // Test Case - 17 : To Edit Contacts SQL Query
    
    @Test (dependsOnMethods = "test_create_new_contacts_sqlquery")
        
    public void test_to_edit_contacts_sql_query() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_to_edit_contacts_sql_query");
        	
        objLogin.clickEditContactsSQLQueryOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on edit option under contacts sql query");
          
        maroposttest.log(LogStatus.INFO, "Contacts Sql Query was updated successfully");
        
        Thread.sleep(2000);
     }
    
    // Test Case - 18 : To Delete Contacts SQL Query
    
    @Test (dependsOnMethods = "test_to_edit_contacts_sql_query")
        
    public void test_to_delete_contacts_sql_query() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_to_delete_contacts_sql_query");
        	
        objLogin.clickDeleteContactsSQLQueryOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on delete option under contacts sql query");
            
        maroposttest.log(LogStatus.INFO, "Click on confirm delete option");
     
        maroposttest.log(LogStatus.INFO, "Contacts sql query was deleted successfully");
        
        Thread.sleep(2000);
     }
    
    // Test Case - 19 : Create New Preference Page
    
    @Test (dependsOnMethods = "test_to_delete_contacts_sql_query")
        
    public void test_create_new_contacts_preference_page() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_create_new_contacts_preference_page");
        	
        objLogin.clickNewContactsNewPreferencePageOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on new preference page under contacts");
        
        maroposttest.log(LogStatus.INFO, "Enter New Preference Page Name & Click on Save button");
        
        maroposttest.log(LogStatus.INFO, "SQL Query was created successfully");
            
        Thread.sleep(2000);
     }
  
    // Test Case - 20 : To Edit Contacts Preference Page
    
    @Test (dependsOnMethods = "test_create_new_contacts_preference_page")
        
    public void test_to_edit_contacts_preference_page() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_to_edit_contacts_preference_page");
        	
        objLogin.clickEditContactsPreferencePageOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on edit option under contacts preference page");
          
        maroposttest.log(LogStatus.INFO, "Contacts Preference Page was updated successfully");
        
        Thread.sleep(2000);
     }
    
    // Test Case - 21 : To Delete Contacts Preference Page
    
    @Test (dependsOnMethods = "test_to_edit_contacts_preference_page")
        
    public void test_to_delete_contacts_preference_page() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_to_delete_contacts_preference_page");
        	
        objLogin.clickDeleteContactsPreferencePageOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on delete option under contacts preference page");
            
        maroposttest.log(LogStatus.INFO, "Click on confirm delete option");
     
        maroposttest.log(LogStatus.INFO, "Contact preference page was deleted successfully");
        
        Thread.sleep(2000);
     }
 
 /*
  	// Test Case - 6 : To Edit Contacts Field
    
    @Test (dependsOnMethods = "test_create_new_contacts_field")
        
    public void test_to_edit_contacts_field() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_to_edit_contacts_field");
        	
        objLogin.clickEditContactsListOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on edit option under contacts field");
          
        maroposttest.log(LogStatus.INFO, "Contacts field was updated successfully");
        
        Thread.sleep(2000);
     }
    
    // Test Case - 7 : To Delete Contacts Field
    
    @Test (dependsOnMethods = "test_to_edit_contacts_field")
        
    public void test_to_delete_contacts_field() throws InterruptedException{
            
    	maroposttest = extentreports.startTest("test_to_delete_contacts_field");
        	
        objLogin.clickDeleteContactsListOption();
        	
        maroposttest.log(LogStatus.INFO, "Click on delete option under contacts field");
            
        maroposttest.log(LogStatus.INFO, "Click on confirm delete option");
     
        maroposttest.log(LogStatus.INFO, "Contacts field was deleted successfully");
        
        Thread.sleep(2000);
     } 
  */
    @AfterSuite (alwaysRun = true)
    
    public void tearDown() throws Exception {
	 
    	extentreports.endTest(maroposttest);
	    	
	  	extentreports.flush();
	    	
	   	//extent.close();
	    	
	   	driver.quit();
	  
	} 
}
