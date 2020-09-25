package com.crm.qa.pages;



import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
    
    

   //Page Factory or Object Repository
    @FindBy(xpath="//input[@name='username']")
    WebElement username;
    
    @FindBy(xpath="//input[@name='password']")
    WebElement password; 
    
    @FindBy(xpath="//input[@type='submit']")
    WebElement loginBtn; 
    
    @FindBy(xpath="//button[contains(text()='Sign Up')]")
    WebElement SignUpBtn;
    
    @FindBy(xpath="//*[@class='logo_text' and text()='CRMPRO']")
    WebElement crmLogo;
    
    @FindBy(name="mainpanel")
    WebElement frame; 
    
    public LoginPage() throws IOException
    {
        PageFactory.initElements(driver, this);        
    }

    public String validateLoginPageTitle()
    {
        return driver.getTitle(); 
    }
    
    public boolean validateCRMIage()
    {
        return crmLogo.isDisplayed();
    }
    
    public HomePage login(String user, String pwd) throws FileNotFoundException, IOException
    {
        username.sendKeys(user);
        password.sendKeys(pwd);
        loginBtn.click(); 
        
        return new HomePage(); 
    }
    
     
}
