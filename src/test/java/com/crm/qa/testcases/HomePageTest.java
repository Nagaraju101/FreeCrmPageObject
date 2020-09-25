package com.crm.qa.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase
{
    LoginPage loginPage; 
    HomePage homePage; 

    public HomePageTest() throws IOException, FileNotFoundException
    {
       PageFactory.initElements(driver, this);
    }

    @BeforeMethod
    public void setUp() throws IOException
    {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

    }
    
    @Test
    public void verifyHomePageTitleTest()
    {
       String homePageTitle =  homePage.verifyHomePageTitle();
       Assert.assertEquals(homePageTitle, "CRMPRO", "Actutal Title is not matching with expected Title");
    }
    
    
    
    
    
    
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
