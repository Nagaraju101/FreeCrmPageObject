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
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase
{
    LoginPage loginPage; 
    HomePage homePage; 
    TestUtil testUtil; 

    public HomePageTest() throws IOException, FileNotFoundException
    {
       PageFactory.initElements(driver, this);
    }

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException
    {
        initialization();
        loginPage = new LoginPage();
        testUtil = new TestUtil(); 
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

    }
    
//    @Test (priority =2)
//    public void verifyHomePageTitleTest()
//    {
//       String homePageTitle =  homePage.verifyHomePageTitle();
//       Assert.assertEquals(homePageTitle, "CRMPRO", "Actutal Title is not matching with expected Title");
//    }
    
    @Test(priority =1)
    public void verifyUserNameTest() {
        testUtil.switichToFrame(1);
        Assert.assertTrue(homePage.verifyCorrectUsername());
    }
    
    
    
    
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
