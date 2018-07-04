package email_module_pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MaropostEmailCampaignsPage {

    WebDriver driver;
    
    By useremail = By.id("user_email");

    By userpassword = By.id("user_password");

    By signin = By.name("commit");

    By signout = By.xpath("/html/body/header/div/nav/ul/li[7]/a");
  
    By campaignname = By.id("campaign_name"); 
    
    By subject = By.xpath("//*[@id=\"campaign_subject\"]");
  
    By preheader = By.xpath("//*[@id=\"campaign_preheader\"]");  // Optional
    
    By fromname = By.xpath("//*[@id=\"campaign_from_name\"]");
    
    By fromemail = By.xpath("//*[@id=\"campaign_from_email\"]");
    
    By replyto = By.xpath("//*[@id=\"campaign_reply_to\"]");
  
    By content = By.xpath("//*[@id=\"new_campaign\"]/div[6]/div/div/div[1]/div/div[7]/div/div[1]");
  
    By selectlist = By.xpath("//*[@id=\"new_campaign\"]/div[6]/div/div/div[1]/div/div[9]/span/span[1]/span/ul");
  
    By groupAcontent = By.xpath("//*[@id=\"campaign_groups\"]/div[1]/table/tbody/tr/td[2]/div[2]/span/input");
    
    By groupBcontent = By.xpath("//*[@id=\"campaign_groups\"]/div[2]/table/tbody/tr/td[2]/div[2]/span/input");
    
    By groupASubject = By.xpath("//*[@id=\"campaign_campaign_groups_attributes_0_subject\"]");
    
    By groupBSubject = By.xpath("//*[@id=\"campaign_campaign_groups_attributes_1_subject\"]");
  
    By groupAFromName = By.xpath("//*[@id=\"campaign_campaign_groups_attributes_0_from_name\"]");
    
    By groupBFromName = By.xpath("//*[@id=\"campaign_campaign_groups_attributes_1_from_name\"]");
    
    By groupASize = By.xpath("//*[@id=\"campaign_campaign_groups_attributes_0_percentage\"]");
    
    By groupBSize = By.xpath("//*[@id=\"campaign_campaign_groups_attributes_1_percentage\"]");
    
    public MaropostEmailCampaignsPage(WebDriver driver) throws InterruptedException{

        this.driver = driver;
        
        Thread.sleep(3000);
        
    }

    public void enterCampaignName(String strCampaignName){

        driver.findElement(campaignname).sendKeys(strCampaignName);

    }
    
    public void enterSubject(String strSubject){

        driver.findElement(subject).sendKeys(strSubject);

    }
    
    public void enterPreHeader(String strPreHeader){

        driver.findElement(preheader).sendKeys(strPreHeader);
        
    }
    
    public void enterFromName(String strFromName){

        driver.findElement(fromname).sendKeys(strFromName);

    }
    
    public void enterFromEmail(String strFromEmail){

        driver.findElement(fromemail).sendKeys(strFromEmail);

    }
    
    public void enterReplyTo(String strReplyTo){

        driver.findElement(replyto).sendKeys(strReplyTo);

    }
    
    public void enterContent(String strContent){

        driver.findElement(content).sendKeys(strContent);

    }
    
    public void enterSelectList(String strSelectList){

        driver.findElement(selectlist).sendKeys(strSelectList);

    }
    
    public void enterGroupAContent(String strGroupAContent){

        driver.findElement(groupAcontent).sendKeys(strGroupAContent);

    }
    
    public void enterGroupBContent(String strGroupBContent){

        driver.findElement(groupBcontent).sendKeys(strGroupBContent);

    }
    
    public void enterGroupASubject(String strGroupASubject){

        driver.findElement(groupASubject).sendKeys(strGroupASubject);

    }
    
    public void enterGroupBSubject(String strGroupBSubject){

        driver.findElement(groupBSubject).sendKeys(strGroupBSubject);

    }
    
    public void enterGroupAFromName(String strGroupAFromName){

        driver.findElement(groupAFromName).sendKeys(strGroupAFromName);

    }
    
    public void enterGroupBFromName(String strGroupBFromName){

        driver.findElement(groupBFromName).sendKeys(strGroupBFromName);

    }
    
    public void enterGroupASize(String strGroupASize){

    	driver.findElement(groupASize).clear();
    	
        driver.findElement(groupASize).sendKeys(strGroupASize);

    }
    
    public void enterGroupBSize(String strGroupBSize){
    	
    	driver.findElement(groupBSize).clear();

        driver.findElement(groupBSize).sendKeys(strGroupBSize);

    }
    
    //Set user name in text box

    public void setUserEmail(String strUserName){

        driver.findElement(useremail).sendKeys(strUserName);

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
    
    //click button
    
    public void click(){
    	
    	driver.switchTo().alert().accept();
    	
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
    public void newCampaignTagPopup(){
    
    	// driver.switchTo().defaultContent();
    	
    	// driver.findElement(By.id("ctag_name")).sendKeys("Pendyala Tag");
    	
    	// driver.findElement(By.name("commit")).click();
    	
    	driver.switchTo().alert().accept();
    	
    }

    public void clickNewCampaignTag() throws InterruptedException{     
    	
    	WebElement Campaign = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[1]/a"));

    	Campaign.click();
    	
		WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/i"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
        
    	WebElement newCampaignTag = driver.findElement(By.linkText("New Campaign Tag"));

    	newCampaignTag.click();
    	
    	Thread.sleep(2000);
    		
    	driver.switchTo().activeElement();
    	
    	Thread.sleep(2000);
    	
    	driver.findElement(By.id("ctag_name")).sendKeys("BBC");
    	
    	Thread.sleep(2000);
    	
    	driver.findElement(By.name("commit")).click();
    	
    	Thread.sleep(3000);
    	
    }				
  
    public void clickNewCampaignTagWithoutName() throws InterruptedException{     
    	
    	WebElement Campaign = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[1]/a"));

    	Campaign.click();
    	
		WebElement element = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[2]/div[2]/i"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
        
    	WebElement newCampaignTag = driver.findElement(By.linkText("New Campaign Tag"));

    	newCampaignTag.click();
    	
    	Thread.sleep(2000);
    	
    }			
    public void clickNewCampaignOption() throws InterruptedException{     
    	
    	WebElement Campaign = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[1]/a"));

    	Campaign.click();
    	
    	WebElement newCampaign = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div[2]/div/a[1]"));

    	newCampaign.click();
    }
    
    public void enterNewCampaignDetails(String strCampaignName, String strSubject, String strPreHeader, String strFromName, String strFromEmail, String strReplyTo, String strContent, String strSelectList) throws InterruptedException{     
        
    	this.enterCampaignName(strCampaignName);
    
    	this.enterSubject(strSubject);
   
    	this.enterPreHeader(strPreHeader);
    
    	this.enterFromName(strFromName);
    
    	this.enterFromEmail(strFromEmail);
    
    	this.enterReplyTo(strReplyTo);
    	
    	Thread.sleep(2000);
    	
    	this.enterContent(strContent);
   	
    	Thread.sleep(1000);
    	
    	this.enterSelectList(strSelectList);
    	
    	Thread.sleep(2000);
    	
    	// Select list option
    	// WebElement list = driver.findElement(By.id("list_24432"));
    	// list.click();
    }	
    	
    public void newCampaignNextButton() throws InterruptedException{     
    	    
    	// Click on next button
        
    	WebElement next = driver.findElement(By.xpath("//*[@id=\"schedule_campaign_btn\"]"));
   	 
    	next.click();
    	
    	Thread.sleep(10000);
    	
    	WebElement spamNext = driver.findElement(By.partialLinkText("Next"));
      	 
    	spamNext.click();
    	
    	Thread.sleep(5000);
    	
    	
    }
    public void newCampaignScheduleRecurring() throws InterruptedException{
    	
    	WebElement schedulerecurring = driver.findElement(By.xpath("//*[@id=\"campaign_recurring_schedule_monthly\"]"));
      	 
    	schedulerecurring.click();
    	
    	Thread.sleep(5000);
  
    	WebElement scheduleButton = driver.findElement(By.linkText("Schedule"));
     	 
    	scheduleButton.click();
    	
    	Thread.sleep(5000);
    	
    	WebElement confirmSchedule = driver.findElement(By.xpath("//*[@id=\"details_tab_div\"]/div/div[1]/a[1]"));
      	 
    	confirmSchedule.click();
    	
    	Thread.sleep(5000);
 	
    } 
    
    public void newCampaignSchedulePriority() throws InterruptedException{
    	
    	WebElement schedulepriority = driver.findElement(By.xpath("//*[@id=\"campaign_send_at\"]"));
    	
    	schedulepriority.sendKeys("January 01, 2018 12:00 AM");
    	
    	Thread.sleep(5000);
  
    	WebElement scheduleButton = driver.findElement(By.linkText("Schedule"));
     	 
    	scheduleButton.click();
    	
    	Thread.sleep(5000);
    	
    	WebElement confirmSchedule = driver.findElement(By.xpath("//*[@id=\"details_tab_div\"]/div/div[1]/a[1]"));
      	 
    	confirmSchedule.click();
    	
    	Thread.sleep(5000);
    } 
    
    public void newCampaignSchedulePriorityWithoutDate() throws InterruptedException{
    	
    	WebElement schedulepriority = driver.findElement(By.xpath("//*[@id=\"campaign_schedule\"]/div[1]/label"));
    	
    	schedulepriority.click();
    	
    	Thread.sleep(5000);
  
    	WebElement scheduleButton = driver.findElement(By.linkText("Schedule"));
     	 
    	scheduleButton.click();
    	
    	Thread.sleep(5000);
    	
    	WebElement confirmSchedule = driver.findElement(By.xpath("//*[@id=\"details_tab_div\"]/div/div[1]/a[1]"));
      	 
    	confirmSchedule.click();
    	
    	Thread.sleep(5000);
 	
    } 

    public void newGroupACampaignSchedulePriority() throws InterruptedException{
    	
    	WebElement groupASchedulePriority = driver.findElement(By.xpath("//*[@id=\"campaign_campaign_groups_attributes_0_send_at\"]"));
    	
    	groupASchedulePriority.sendKeys("January 01, 2018 12:00 AM");	
    	
    	Thread.sleep(2000);
	}
    
    public void newGroupBCampaignSchedulePriority() throws InterruptedException{
    	
    	WebElement groupBSchedulePriority = driver.findElement(By.xpath("//*[@id=\"campaign_campaign_groups_attributes_1_send_at\"]"));
    	
    	groupBSchedulePriority.sendKeys("January 01, 2018 12:00 AM");	
    	
    	Thread.sleep(2000);
    }	
    
    public void newABCampaignSchedulePriority() throws InterruptedException{
    	
    	Select winningcriteria = new Select(driver.findElement(By.id("campaign_decided_by")));
    	
    	winningcriteria.selectByVisibleText("Highest Open Rate");
    	
    	Thread.sleep(2000);
    	
    	WebElement scheduleButton = driver.findElement(By.xpath("//*[@id=\"ab_step_2\"]/input[2]"));
     	 
    	scheduleButton.click();
    	
    	Thread.sleep(5000);
    } 

    //click button
    
    public void switchToClick(){
    	
    	driver.switchTo().alert().accept();
    	
    }
    
    public void editCampaign() throws InterruptedException{
        
    	WebElement Campaign = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[1]/a"));

    	Campaign.click();
    	
    	WebElement editCampaign = driver.findElement(By.cssSelector("a[title=\"Edit campaign\"]"));
    	
    	editCampaign.click();
    	
    	Thread.sleep(1000);
    	
    	driver.switchTo().alert().accept();
    	
    	Thread.sleep(2000);
    	
    	WebElement campaignEditPage = driver.findElement(By.id("campaign_name"));
        
    	campaignEditPage.clear();
    	
    	campaignEditPage.sendKeys("campaignpageedited");
    	
    	Thread.sleep(2000);
    	
    } 
  
    public void deleteCampaign() throws InterruptedException{
    
    	WebElement Campaign = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[1]/a"));

    	Campaign.click();
    	
    	WebElement campaignDelete = driver.findElement(By.cssSelector("a[title=\"Delete campaign permanently\"]"));
    	
    	campaignDelete.click();
    	
    	Thread.sleep(2000);
    	
    	this.switchToClick();
    	
    	Thread.sleep(2000);
    } 
  
    public void clickNewABCampaignOption() throws InterruptedException{     
        
    	WebElement Campaign = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div[1]/ul/li[1]/a"));

       	Campaign.click();
        	
       	WebElement newABCampaign = driver.findElement(By.xpath("//*[@id=\"main-container\"]/div[2]/div/div[2]/div/a[2]"));
        	
       	newABCampaign.click();
    }

    public void enterNewABCampaignDetails(String strCampaignName, String strFromEmail, String strReplyTo) throws InterruptedException{     
        
    	this.enterCampaignName(strCampaignName);
    	
    	this.enterFromEmail(strFromEmail);
    
    	this.enterReplyTo(strReplyTo);
    	
    	// Select list option
    	
    	WebElement list = driver.findElement(By.id("list_24432"));
    	 
    	list.click();
    	
    	Thread.sleep(2000);
    }	
    
    public void newABCampaignNextButton() throws InterruptedException{     
	    
    	// Click on next button
        
    	WebElement next = driver.findElement(By.xpath("//*[@id=\"ab_step_1_next_btn\"]"));
   	 
    	next.click();
    	
    	Thread.sleep(10000);
    }	
    
    public void newABCampaignGroupSelection(String strGroupAContent, String strGroupBContent, String strGroupASubject, String strGroupBSubject, String strGroupAFromName, String strGroupBFromName, String strGroupASize, String strGroupBSize) throws InterruptedException{     
	    
    	this.enterGroupAContent(strGroupAContent);
    	
    	this.enterGroupBContent(strGroupBContent);
    	
    	this.enterGroupASubject(strGroupASubject);
    	
    	this.enterGroupBSubject(strGroupBSubject);
    	
    	this.enterGroupAFromName(strGroupAFromName);
    	
    	this.enterGroupBFromName(strGroupBFromName);
    	
    	this.enterGroupASize(strGroupASize);
    	
    	this.enterGroupBSize(strGroupBSize);
    	
    	Thread.sleep(3000);
    }	
  
    
    public void newABCampaignScheduleButton() throws InterruptedException{     
	    
    	// Click on schedule button
        
    	WebElement schedule = driver.findElement(By.xpath("//*[@id=\"ab_step_2\"]/input[2]"));
   	 
    	schedule.click();
    	
    	Thread.sleep(5000);
    }	

    /*
    public void clickOnNameUnderCampaign() throws InterruptedException{    
    	
    	WebElement nameCampaign = driver.findElement(By.linkText("AA"));
        
        nameCampaign.click(); 
      
        WebElement Campaign = driver.findElement(By.xpath("//*[@id=\"header\"]/div/ul/li[3]/a"));
        
        Campaign.click(); 
    }   
    
    public void clickOnSignOutOption() throws InterruptedException{     
        
    	WebElement element = driver.findElement(By.linkText("Jatin Goel"));
        
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
 
        WebElement menuOption = driver.findElement(By.linkText("Sign Out"));
        
        menuOption.click();
    
    }*/
}