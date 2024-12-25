package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

/// global variables

  public static WebDriver driver;
  public static Properties prop;

    public TestBase(){

        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/Users/adityatiwari/Documents/SeleniumPractice/FreeCRMTest/src/main/java/com/crm/" +
                    "qa/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("edge")) {
            System.setProperty("webdriver.edge.driver", "/Users/adityatiwari/Documents/SeleniumPractice/FreeCRMTest/src/test/java/drivers/msedgedriver");
            driver = new EdgeDriver();
        } else if (browserName.equals("ff")) {
            System.setProperty("webdriver.firefox.driver", "/Users/adityatiwari/Documents/SeleniumPractice/FreeCRMTest/src/test/java/drivers/geckodriver");
            WebDriver dr = new FirefoxDriver();
        }
//            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);

            driver.get(prop.getProperty("url"));
    }
}

