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
    
    
    
    
    
    public void switchFrame(int id) {
        driver.switchTo().frame(id);
    }
    
    public void switchFrame(String name) {
        driver.switchTo().frame(name);
    }
    
}
