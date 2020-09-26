package com.crm.qa.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{

    public ContactsPage() throws IOException, FileNotFoundException
    {
     
        PageFactory.initElements(driver, this);       
    }

    @FindBy(xpath="//td[text()='K']")
    WebElement namesStartWithK; 
    
    @FindBy(xpath="//td[contains(text(),'-K- Contacts')]")
    WebElement expectedK; 
    
    
    
    public boolean clickOnContactStartWithK()
    {
       namesStartWithK.click();
       boolean flag = expectedK.isDisplayed();
       return flag;                
    }
    
}
