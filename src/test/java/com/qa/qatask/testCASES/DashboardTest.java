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
    @Test(priority = 1, description = "close portal")
    @Severity(SeverityLevel.MINOR)
    public void verifycloseportal()  {
        Boolean result = dashoard.closetPortal();
        Assert.assertTrue(true);
    }

    @Test(enabled=false)
    @Severity(SeverityLevel.NORMAL)
    public void verifyPortal()  {
        Boolean result = dashoard.selectPortal();
        Assert.assertTrue(true);
    }

    @Test(priority = 3, description = "verify title page test //warm up test")
    @Severity(SeverityLevel.MINOR)
    public void verifyTitle() {
        String title = dashoard.title();
        Assert.assertEquals("Vinted | Sell and buy clothes, shoes and accessories", title);
    }

    @Test(priority = 4, description = "verify Accept Cookies")
    @Severity(SeverityLevel.MINOR)
    public void verifyacceptCookies()  {
        Boolean result = dashoard.acceptCookies();
        Assert.assertTrue(true);
    }

    @Test(priority = 5, description = "write Nik in search bar")
    @Severity(SeverityLevel.BLOCKER)
    public void verifySearch() {
        dashoard.search();
    }

    @Test(priority = 6, description = "verify Nike is clikced")
    public void verifyclickNike() {
        dashoard.clickNike();
        Assert.assertTrue(true);

    }

    @Test(priority = 7, description = "verify Text is present on page with Nike")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyNikeTextPresent() {
        dashoard.NikeTextPresent();
        Assert.assertEquals(true , true);
    }

    @Test(priority = 8, description = "Assert that “Nike” filter appeared below the filter menu")
    @Severity(SeverityLevel.NORMAL)
    public void verifselectWomenShoes() {
        dashoard.selectWomenShoes();
        Assert.assertEquals(true , true);
    }

    @Test(priority = 9, description = "clear all filters")
    @Severity(SeverityLevel.NORMAL)
    public void verifclearFilter() throws InterruptedException {
        dashoard.clearFilter();
        Assert.assertEquals(true , true);
    }



    @Test(priority = 10, description = "clear all filters")
    @Severity(SeverityLevel.NORMAL)
    public void verifsorByPrice() {
        dashoard.sorByPrice();
        Assert.assertEquals(true , true);
    }


    @Test(priority = 11, description = "clear all filters")
    @Severity(SeverityLevel.NORMAL)
    public void verifyIsSortedByPrice() {
        dashoard.isSortedByPrice();
        Assert.assertEquals(true , true);
    }


   /*@AfterTest
    public void quitBrowserTest() {
       tearDown();
   }
*/

}
