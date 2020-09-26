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
    HomePage homePage;

    public LoginPageTest() throws IOException
    {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException
    {
        initialization();
        loginPage = new LoginPage();
        homePage = new HomePage(); 
    }

    @Test(priority = 3)
    public void validateLoginPageTitleTest()
    {
        String title = loginPage.validateLoginPageTitle(); 
        Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
    }

    @Test(priority =2)
    public void loginTest() throws FileNotFoundException, InterruptedException, IOException
    {
        homePage =  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }
    
    
    @Test(priority = 1)
    public void verifyLogoTest() throws InterruptedException, FileNotFoundException, IOException
    {           
      boolean flag = loginPage.verifyLogoText();
      Assert.assertTrue(flag);
    }
    
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }

}
