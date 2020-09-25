package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.crm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{
    public static WebDriver driver;
    public static Properties prop;

    public TestBase() throws IOException , FileNotFoundException
    {
        prop = new Properties();
        try
        {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +( "/src/main/resources/properties/config.properties"));
            prop.load(fis);
            
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization()
    {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();

            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setAcceptInsecureCerts(true);

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.merge(dc);

            driver = new ChromeDriver(chromeOptions);
            driver.get(prop.getProperty("url"));

        }
        else
            if (browserName.equals("FF"))
            {
                WebDriverManager.firefoxdriver().setup();
                DesiredCapabilities dc = new DesiredCapabilities();
                dc.setAcceptInsecureCerts(true);

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.merge(dc);

                driver = new FirefoxDriver(firefoxOptions);
                driver.get(prop.getProperty("url"));

            }

        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

}
