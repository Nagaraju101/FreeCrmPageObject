package com.crm.qa.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{

    @FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
    WebElement userLabel;
    
    @FindBy(xpath= "//a[contains(text(),'Contacts')]")
    WebElement contactsLink;
    
    @FindBy(xpath ="//a[contains(text(),'New Contact')]")
    WebElement newContactLink;
    
    @FindBy(xpath="//a[contains(text(),'Deals')]")
    WebElement dealsLink;
    
    @FindBy(xpath="//a[contains(text(),'Tasks')]")
    WebElement tasksLink;
    
    
    
    public HomePage() throws IOException, FileNotFoundException
    {
       PageFactory.initElements(driver, this);
    }
    
    public String verifyHomePageTitle()
    {
        return driver.getTitle();
    }

    public ContactsPage clickOnContactsLink() throws FileNotFoundException, IOException
    {
        contactsLink.click();
        return new ContactsPage(); 
    }
    
    public DealsPage clickOnDealsLick()
    {
        dealsLink.click();
        return new DealsPage(); 
    }
    
    public TaskPage tasksLick() throws FileNotFoundException, IOException
    {
        dealsLink.click();
        return new TaskPage();
    }
    
    public boolean verifyCorrectUsername()
    {
       return userLabel.isDisplayed();
        
    }
    
   public void clickOnNewContactLink() throws InterruptedException {
       Actions action = new Actions(driver); 
       action.moveToElement(contactsLink).build().perform();
       Thread.sleep(5000);
       newContactLink.click();
       
   }
}
