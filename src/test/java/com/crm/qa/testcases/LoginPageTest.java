package com.crm.qa.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
    LoginPage loginPage;
    HomePage homepage;

    public LoginPageTest() throws IOException
    {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException
    {
        initialization();
        loginPage = new LoginPage();

    }

    @Test(priority = 1)

    public void validateLoginPageTitleTest()
    {
        String title = loginPage.validateLoginPageTitle(); 
        Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
    }

    @Test(priority = 2)
    public void loginTest() throws InterruptedException
    {
        homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
