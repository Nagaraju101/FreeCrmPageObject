package com.crm.qa.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
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

    public ContactsPage clickOnContactsLick()
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
}
