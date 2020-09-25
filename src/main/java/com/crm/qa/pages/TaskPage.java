package com.crm.qa.pages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class TaskPage extends TestBase
{

    public TaskPage() throws IOException, FileNotFoundException
    {
        PageFactory.initElements(driver, this);
    }

}
