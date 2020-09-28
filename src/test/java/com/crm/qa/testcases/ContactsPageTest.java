package com.crm.qa.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public ContactsPageTest() throws IOException, FileNotFoundException
    {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException
    {
      Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
//      Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
        initialization();
        loginPage = new LoginPage();
        testUtil = new TestUtil();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switichToFrame("mainpanel");
        Thread.sleep(5000);     
        
    }

    @Test(priority = 2)
    public void clickOnContactStartWithATest() throws FileNotFoundException, IOException
    {       
        contactsPage = homePage.clickOnContactsLink();
        boolean flag = contactsPage.clickOnContactStartWithA();
        Assert.assertTrue(flag);
    }

    @Test(priority = 1)
    public void verifyContactLabelTest() throws FileNotFoundException, IOException
    {
        contactsPage = homePage.clickOnContactsLink();
        boolean flag = contactsPage.verifyContactLabel();
        Assert.assertTrue(flag, "Contacts label is missing");
    }

    @Test(priority = 3)
    public void checkContactTest() throws FileNotFoundException, IOException
    {
        contactsPage = homePage.clickOnContactsLink();
        contactsPage.getContactsByLetter("J");
        contactsPage.checkContact("Jack peter");
        contactsPage.getContactsByLetter("K");
        contactsPage.checkContact("K C");
    }

    
    @Test(priority =4)
    public void validateCreateNewContact() throws FileNotFoundException, IOException
    {   
        contactsPage = homePage.clickOnContactsLink();
        contactsPage.clickOnNewContact();
        contactsPage.createNewContact("Mr.","Naga","Ankamreddi","X");
    }
    
    
    @AfterMethod
    public void tearDown() throws IOException
    {
        driver.quit();


    }
}
