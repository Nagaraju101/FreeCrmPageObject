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
    

    public void switichToFrameByName(String frame)
    {
        driver.switchTo().frame(frame);
    }
    
    public void switichToFrameByName(int id)
    {
        driver.switchTo().frame(id);
    }

    
}
