package com.crm.qa.util;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase
{
    public TestUtil() throws IOException, FileNotFoundException
    {
        super();
    }
    
    
    public static long PAGE_LOAD_TIMEOUT = 30;
    public static long IMPLICIT_TIMEOUT = 15;
    

    public void switichToFrame(String frame)
    {
        driver.switchTo().frame(frame);
    }
    
    public void switichToFrame(int id)
    {
        driver.switchTo().frame(id);
    }
    
//    public void selectContact(String name)
//    {
//       driver.findElement(By) "//a[text()='a b']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']"
//    }
    
}
