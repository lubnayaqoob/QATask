package com.qa.qatask.testCASES;


import com.qa.qatask.base.TestBase;
import com.qa.qatask.pages.Dashboard;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DashboardTest extends TestBase {


    Dashboard dashoard;

    public DashboardTest() {
        super();
    }

    @BeforeTest
    public void setUp() {
        initialization();
        dashoard = new Dashboard();
    }

    @Test(priority = 3, description = "verify title page test")
    @Severity(SeverityLevel.BLOCKER)
    public void verifyTitle() {
        String title = dashoard.title();
        Assert.assertEquals("Vinted | Sell and buy clothes, shoes and accessories", title);
    }

    @Test(priority = 1)
    public void verifyPortal()  {
        Boolean result = dashoard.selectPortal();
        Assert.assertTrue(true);
    }

    @Test(enabled=false)
    public void verifycloseportal()  {
        Boolean result = dashoard.closetPortal();
        Assert.assertTrue(true);
    }
    @Test(priority = 4)
    public void verifyacceptCookies() throws InterruptedException {

        Boolean result = dashoard.acceptCookies();
        Assert.assertTrue(true);
    }

    @Test(priority = 5)
    public void verifySearch() {
        dashoard.search();
    }





/*    @AfterTest
    public void quitBrowserTest(){
        tearDown();
    }*/


}
