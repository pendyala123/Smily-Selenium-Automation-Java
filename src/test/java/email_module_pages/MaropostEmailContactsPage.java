package email_module_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@SuppressWarnings("unused")
public class MaropostEmailContactsPage {

	WebDriver driver;
    
    By useremail = By.id("user_email");

    By userpassword = By.id("user_password");

    By signin = By.name("commit");

    By signout = By.xpath("/html/body/header/div/nav/ul/li[7]/a");
    
    public MaropostEmailContactsPage(WebDriver driver) throws InterruptedException{

        this.driver = driver;
        
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
        
    }
    
    public void clickNewContactsListOption() throws InterruptedException{     
        
    	WebElement newList = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div[2]/div/a"));
       
        newList.click();
    
        Thread.sleep(2000);
		
    	driver.switchTo().activeElement();
    	
    	Thread.sleep(2000);
    	
    	WebElement listName = driver.findElement(By.id("list_name"));
        
        listName.sendKeys("Automation_List_100");
    	
    	Thread.sleep(2000);
    	
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
    	
        jse.executeScript("window.scrollBy(0,500)", "");
    	
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }

    public void clickNewContactOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
        
    	contacts.click();
    	
    	Thread.sleep(2000);
	
    	WebElement viewContacts = driver.findElement(By.cssSelector("a[title=\"View Contacts.\"]"));
    	
    	viewContacts.click();
    	
    	WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/i"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
        
    	WebElement newContact = driver.findElement(By.linkText("New Contact"));

    	newContact.click();
    	
    	WebElement contactEmail = driver.findElement(By.id("contact_email"));
    	
    	contactEmail.sendKeys("Automation Contact 00");
    	
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
    	
        jse.executeScript("window.scrollBy(0,500)", "");
    	
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);  	
	}	
    public void clickNewContactsFieldOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
       
        contacts.click();
    
        Thread.sleep(2000);
		
        WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/i"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
        
    	WebElement newField = driver.findElement(By.linkText("New Field"));

    	newField.click();
    	
    	Thread.sleep(2000);
    	
    	driver.switchTo().activeElement();
    	
    	Thread.sleep(2000);
    	
    	WebElement fieldName = driver.findElement(By.id("custom_field_name"));
        
        fieldName.sendKeys("Automation_Field_100");
    	
    	Thread.sleep(2000);
    	
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }

    public void clickNewContactsTagOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
       
        contacts.click();
    
        Thread.sleep(2000);
		
        WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/i"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
        
    	WebElement newField = driver.findElement(By.linkText("New Tag"));

    	newField.click();
    	
    	Thread.sleep(2000);
    	
    	driver.switchTo().activeElement();
    	
    	Thread.sleep(2000);
    	
    	WebElement tagName = driver.findElement(By.id("tag_name"));
        
        tagName.sendKeys("Automation_Tag_100");
    	
    	Thread.sleep(2000);
    	
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }

    public void clickNewContactsBrandOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
       
        contacts.click();
    
        Thread.sleep(2000);
		
        WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/i"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
        
    	WebElement newField = driver.findElement(By.linkText("New Brand"));

    	newField.click();
    	
    	Thread.sleep(2000);
    	
    	driver.switchTo().activeElement();
    	
    	Thread.sleep(2000);
    	
    	WebElement brandName = driver.findElement(By.id("brand_name"));
        
        brandName.sendKeys("Automation_Brand_100");
    	
    	Thread.sleep(2000);
    	
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }

    public void clickNewContactsSecureListOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
       
        contacts.click();
    
        Thread.sleep(2000);
		
        WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/i"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
        
    	WebElement newField = driver.findElement(By.linkText("New Secure List"));

    	newField.click();
    	
    	Thread.sleep(2000);
    	
    	driver.switchTo().activeElement();
    	
    	Thread.sleep(2000);
    	
    	WebElement secureListName = driver.findElement(By.id("secure_list_name"));
        
        secureListName.sendKeys("Automation_Secure_List_00");
    	
    	Thread.sleep(2000);
    	
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }

    public void clickNewContactsTableOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
       
        contacts.click();
    
        Thread.sleep(2000);
		
        WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/i"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
        
    	WebElement newTable = driver.findElement(By.linkText("New Table"));

    	newTable.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement tableName = driver.findElement(By.id("relational_table_name"));
        
        tableName.sendKeys("automationtable00");
    	
    	Thread.sleep(2000);
    	
    	WebElement name = driver.findElement(By.xpath("//*[@id=\"relational_table_relational_columns_attributes_0_name\"]"));
        
        name.sendKeys("automationtable");
        
        WebElement primaryKeyCheckbox = driver.findElement(By.xpath("//*[@id=\"relational_table_relational_columns_attributes_0_primary_key\"]"));
        
        primaryKeyCheckbox.click();
        
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }

    public void clickNewContactsSQLQueryOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
       
        contacts.click();
    
        Thread.sleep(2000);
		
        WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/i"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
        
    	WebElement newSQLQuery = driver.findElement(By.linkText("New SQL Query"));

    	newSQLQuery.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement sqlQueryName = driver.findElement(By.id("relational_query_name"));
        
        sqlQueryName.sendKeys("automationsql00");
    	
    	Thread.sleep(2000);
    	
    	WebElement sqlQuery = driver.findElement(By.id("relational_query_query"));
        
        sqlQuery.sendKeys("SELECT Email,Subject From demo_123");
        
        WebElement primaryKeyCheckbox = driver.findElement(By.xpath("//*[@id=\"relational_query_target_ids_\"]"));
        
        primaryKeyCheckbox.click();
        
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }

    public void clickNewContactsNewPreferencePageOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
       
        contacts.click();
    
        Thread.sleep(2000);
		
        WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/i"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
        
    	WebElement newPreferencePage = driver.findElement(By.linkText("New Preference Page"));

    	newPreferencePage.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement preferencePageName = driver.findElement(By.id("preference_page_name"));
        
    	preferencePageName.sendKeys("automationpreferencepage00");
    	
    	Thread.sleep(2000);
    	
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
    	
        jse.executeScript("window.scrollBy(0,500)", "");
    	
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }

    public void clickEditContactsListOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
        
        contacts.click();
    
        Thread.sleep(2000);
	
    	WebElement editList = driver.findElement(By.cssSelector("a[title=\"Edit list.\"]"));
    	
    	editList.click();
    	
    	driver.switchTo().activeElement();
    	
    	Thread.sleep(2000);
    	
    	WebElement editPage = driver.findElement(By.id("list_description"));
        
    	editPage.sendKeys("editing the list");
    	
    	Thread.sleep(2000);
    	
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
    	
        jse.executeScript("window.scrollBy(0,500)", "");
    	
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }
    
    public void clickEditContactsTableOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(contacts).build().perform();
        
    	WebElement tables = driver.findElement(By.linkText("Tables"));

    	tables.click();
    	
    	Thread.sleep(2000);
	
    	WebElement editTableRow = driver.findElement(By.cssSelector("a[title=\"Edit relational table\"]"));
    	
    	editTableRow.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement tableEditPage = driver.findElement(By.id("relational_table_name"));
        
    	tableEditPage.clear();
    	
    	tableEditPage.sendKeys("tableedited");
    	
    	Thread.sleep(2000);
    
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }

    public void clickEditContactsSQLQueryOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(contacts).build().perform();
        
    	WebElement query = driver.findElement(By.linkText("SQL Queries"));

    	query.click();
    	
    	Thread.sleep(2000);
	
    	WebElement editQuery = driver.findElement(By.cssSelector("a[title=\"Edit query\"]"));
    	
    	editQuery.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement queryEditPage = driver.findElement(By.id("relational_query_name"));
        
    	queryEditPage.clear();
    	
    	queryEditPage.sendKeys("queryedited");
    	
    	Thread.sleep(2000);
    
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }

    public void clickEditContactsPreferencePageOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(contacts).build().perform();
        
    	WebElement preferencePage = driver.findElement(By.linkText("Preference Management"));

    	preferencePage.click();
    	
    	Thread.sleep(2000);
	
    	WebElement editQuery = driver.findElement(By.cssSelector("a[title=\"Edit preference page.\"]"));
    	
    	editQuery.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement preferenceEditPage = driver.findElement(By.id("preference_page_name"));
        
    	preferenceEditPage.clear();
    	
    	preferenceEditPage.sendKeys("pageedited");
    	
    	Thread.sleep(2000);
    	
    	JavascriptExecutor jse = (JavascriptExecutor) driver;
    	
        jse.executeScript("window.scrollBy(0,500)", "");
    
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }

    public void clickEditContactsSecureListOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(contacts).build().perform();
        
    	WebElement secureListPage = driver.findElement(By.linkText("Secure Lists"));

    	secureListPage.click();
    	
    	Thread.sleep(2000);
	
    	WebElement editSecureList = driver.findElement(By.cssSelector("a[title=\"Edit List\"]"));
    	
    	editSecureList.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement editPage = driver.findElement(By.id("secure_list_name"));
        
    	editPage.clear();
    	
    	editPage.sendKeys("securelistedited");
    	
    	Thread.sleep(2000);
    
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }

    public void clickEditContactsBrandOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(contacts).build().perform();
        
    	WebElement brandPage = driver.findElement(By.linkText("Brands"));

    	brandPage.click();
    	
    	Thread.sleep(2000);
	
    	WebElement editBrandname = driver.findElement(By.cssSelector("a[title=\"Edit brand.\"]"));
    	
    	editBrandname.click();
    	
    	Thread.sleep(2000);
    	
    	driver.switchTo().activeElement();
    	
    	Thread.sleep(2000);
    	
    	WebElement editPage = driver.findElement(By.id("brand_name"));
        
    	editPage.clear();
    	
    	editPage.sendKeys("brandedited");
    	
    	Thread.sleep(2000);
    
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    }
 
    public void clickDeleteContactsListOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
        
        contacts.click();
    
        Thread.sleep(2000);
        
    	WebElement deleteList = driver.findElement(By.cssSelector("a[title=\"Delete list permanently.\"]"));
    	
    	deleteList.click();
    	
    	driver.switchTo().alert().accept();
    	
    	Thread.sleep(2000);
    }
    
    public void clickDeleteContactsTagOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(contacts).build().perform();
        
    	WebElement tables = driver.findElement(By.linkText("Tags"));

    	tables.click();
    	
    	Thread.sleep(2000);
	
    	WebElement deleteTag = driver.findElement(By.cssSelector("a[title=\"Delete tag permanently\"]"));
    	
    	deleteTag.click();
    	
    	driver.switchTo().alert().accept();
    	
    	Thread.sleep(2000);
    }

    public void clickDeleteContactsTableOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(contacts).build().perform();
        
    	WebElement tables = driver.findElement(By.linkText("Tables"));

    	tables.click();
    	
    	Thread.sleep(2000);
	
    	WebElement deleteTableRow = driver.findElement(By.cssSelector("a[title=\"Delete table permanently\"]"));
    	
    	deleteTableRow.click();
    	
    	driver.switchTo().alert().accept();
    	
    	Thread.sleep(2000);
    }

    public void clickDeleteContactsSQLQueryOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(contacts).build().perform();
        
    	WebElement query = driver.findElement(By.linkText("SQL Queries"));

    	query.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement deleteQuery = driver.findElement(By.cssSelector("a[title=\"Delete query permanently\"]"));
    	
    	deleteQuery.click();
    	
    	driver.switchTo().alert().accept();
    	
    	Thread.sleep(2000);
    }

    public void clickDeleteContactsPreferencePageOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(contacts).build().perform();
        
    	WebElement preferencePage = driver.findElement(By.linkText("Preference Management"));

    	preferencePage.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement deletePreferencePage = driver.findElement(By.cssSelector("a[title=\"Delete preference page permanently.\"]"));
    	
    	deletePreferencePage.click();
    	
    	driver.switchTo().alert().accept();
    	
    	Thread.sleep(2000);
    }
    
    public void clickDeleteContactsSecureListOption() throws InterruptedException{     
        
    	WebElement contacts = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[2]/a"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(contacts).build().perform();
        
    	WebElement secureListPage = driver.findElement(By.linkText("Secure Lists"));

    	secureListPage.click();
    	
    	Thread.sleep(2000);
    	
    	WebElement deleteSecureListPage = driver.findElement(By.cssSelector("a[title=\"Delete secure list permanently\"]"));
    	
    	deleteSecureListPage.click();
    	
    	driver.switchTo().alert().accept();
    	
    	Thread.sleep(2000);
    }
 
}



