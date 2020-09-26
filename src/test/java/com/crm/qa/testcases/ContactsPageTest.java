package com.crm.qa.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

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
        initialization();
        loginPage = new LoginPage();
        testUtil = new TestUtil();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

    }

    @Test
    public void clickOnContactStartWithKTest() throws FileNotFoundException, IOException
    {
        testUtil.switichToFrame(1);
        contactsPage = homePage.clickOnContactsLick();
        boolean flag = contactsPage.clickOnContactStartWithK();
        Assert.assertTrue(flag);
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
