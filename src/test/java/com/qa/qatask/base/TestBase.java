package com.qa.qatask.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

        // global variables
        public static WebDriver driver;
        public static Properties prop;
        public static WebDriverWait wait;




        // class constructor
        public TestBase() {

                prop = new Properties();
                try {
                        FileInputStream ip = new FileInputStream(
                                "src/test/java/com/qa/qatask/config/config.properties");
                        try {
                                prop.load(ip);
                        } catch (IOException e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                        }
                } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        System.out.println("File not found !");
                }
        }


        public static void initialization()  {
                String browserName = prop.getProperty("browser");
                if (browserName.equals("chrome")) {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                }else if (browserName.equals("firefox")) {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                }

                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.get(prop.getProperty("url"));
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);





        }


        public static void tearDown(){
                driver.quit();
        }


}
