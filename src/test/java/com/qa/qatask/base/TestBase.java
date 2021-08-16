package com.qa.qatask.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.qatask.util.TestUtil;

import java.io.File;
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
        public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
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


        public WebDriver initialization()  {
                String browserName = prop.getProperty("browser");
                if (browserName.equalsIgnoreCase("chrome")) {
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                }else if (browserName.equalsIgnoreCase("firefox")) {
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                }

                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.get(prop.getProperty("url"));
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                tdriver.set(driver);
                return getDriver();
        }


        public static synchronized WebDriver getDriver() {
                return tdriver.get();
        }


        public String getScreenshot() {
                File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
                String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
                File destination = new File(path);
                try {
                        FileUtils.copyFile(src, destination);
                } catch (IOException e) {
                        System.out.println("Capture Failed " + e.getMessage());
                }
                return path;
        }


        public static void tearDown(){
                driver.quit();
        }



}
