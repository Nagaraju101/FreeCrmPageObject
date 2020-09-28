package com.crm.qa.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{

    public ContactsPage() throws IOException, FileNotFoundException
    {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td[text()='A']")
    WebElement namesStartWithK;

    @FindBy(xpath = "//td[contains(text(),'User: Demo User')]")
    WebElement userLabel;

    @FindBy(xpath = "//td[contains(text(),'-A- Contacts')]")
    WebElement expectedK;

    @FindBy(xpath = "//td[contains(text(),'Contacts')]")
    WebElement contactLabel;

    @FindBy(xpath = "//select[@name='title']")
    WebElement dropDown;

    @FindBy(id = "first_name")
    WebElement firstName;

    @FindBy(id = "surname")
    WebElement lastName;

    @FindBy(xpath = "//input[@name='client_lookup']")
    WebElement companyName;
    
    @FindBy(xpath= "//input[@value='New Contact']")
    WebElement newContactLink;
    
    @FindBy(xpath="//input[@type='submit' and @value='Save']")
    WebElement submitBtn; 
    
    @FindBy(xpath= "//a[contains(text(),'Contacts')]")
    WebElement contactsLink;

    public boolean clickOnContactStartWithA()
    {
        namesStartWithK.click();
        boolean flag = expectedK.isDisplayed();
        return flag;
    }

    public boolean verifyContactLabel()
    {
        return contactLabel.isDisplayed();
    }

    public void checkContact(String name)
    {
        driver.findElement(By.xpath("//a[text()='" + name + "']"
                + "//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']"
                + "//input[@name='contact_id']")).click();

    }

    public void getContactsByLetter(String ch)
    {
        driver.findElement(By.xpath("//td[text()='" + ch + "']")).click();
    }
    
    public void enterFirstName(String fname)
    {
        driver.findElement(By.name("first_name")).sendKeys(fname);
    }
    
    public void enterSurName(String fname)
    {
        driver.findElement(By.name("surname")).sendKeys(fname);
    }
    
    public void clickOnSubmitButton()
    {
        driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click();
        
    }
    
    public void clickOnNewContact()
    {
        newContactLink.click();
    }
    public void createNewContact( String title, String fname, String lname, String company)
    {
        Select select = new Select(driver.findElement(By.name("title")));
        select.selectByVisibleText(title);
        
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        companyName.sendKeys(company);
        submitBtn.click();

    }

    public void clickOnNewContactLink() throws InterruptedException {
        Actions action = new Actions(driver); 
        action.moveToElement(contactsLink).build().perform();
        Thread.sleep(5000);
        newContactLink.click();
        
    }


}

