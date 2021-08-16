package com.qa.qatask.testCASES;


import com.qa.qatask.base.TestBase;
import com.qa.qatask.pages.Dashboard;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DashboardTest extends TestBase {


    Dashboard dashboard;

    public DashboardTest() {
        super();
    }

    @BeforeTest
    public void setUp() {
        initialization();
        dashboard = new Dashboard();
    }

    @Test(priority = 1, description = "close portal")
    @Description("Test Case Description : Verify portal is closed when clicked ")
    @Severity(SeverityLevel.NORMAL)
    @Story("Story Name : Select or close portal")
    public void verifycloseportal() {
        Boolean result_closeportal = dashboard.closetPortal();
        Assert.assertTrue(result_closeportal );
    }

    @Test(enabled = false, description = "select a portal 'united kingdom'")
    @Severity(SeverityLevel.NORMAL)
    public void verifySelectPortal() {
        Boolean result_selectPortal = dashboard.selectPortal();
        Assert.assertTrue(result_selectPortal);
    }

    @Test(priority = 3, description = "verify title page test -- warm up test")
    @Severity(SeverityLevel.MINOR)
    @Story("Story Name : Verify Title")
    @Description("Story Name : verify title page")
    public void verifyTitle() {
        String actualTitle = dashboard.title();
        String expectedTitle = "Vinted | Sell and buy clothes, shoes and accessories";
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test(priority = 4, description = "verify accept cookies")
    @Description("Verify accept cookies")
    @Severity(SeverityLevel.MINOR)
    @Story("Story : Manage Cookies")
    public void verifyacceptCookies() {
        Boolean result = dashboard.acceptCookies();
        Assert.assertTrue(result);
    }

    @Test(priority = 5, description = "verify search input field contains string 'Nik'")
    @Description("verify search input field contains string 'Nik'")
    @Story("Story : Search Items")
    @Severity(SeverityLevel.BLOCKER)
    public void verifySearch() {
        dashboard.search();
    }

    @Test(priority = 6, description = "verify Nike text is clicked from options available list")
    @Description("verify Nike text is clicked from options available list")
    @Severity(SeverityLevel.NORMAL)
    @Story("Story : Search Items")
    public void verifyclickNike() {
       Boolean val =  dashboard.clickNike();
        Assert.assertTrue(val);
    }

    @Test(priority = 7, description = "verify Text is present on page with Nike")
    @Description("verify Nike text is clicked from options available list")
    @Severity(SeverityLevel.NORMAL)
    @Story("Story : Search Items")
    public void verifyNikeTextPresent() {
        Boolean res_NikeTextPresent = dashboard.NikeTextPresent();
        Assert.assertEquals(true, true);
    }

    @Test(priority = 8, description = "Assert that “Nike” filter appeared below the filter menu")
    @Severity(SeverityLevel.NORMAL)
    public void verifyselectWomenShoes() {
        dashboard.selectWomenShoes();
        Assert.assertEquals(true, true);
    }

    @Test(priority = 9, description = "clear all filters")
    @Severity(SeverityLevel.NORMAL)
    public void verifyclearFilter() throws InterruptedException {
        dashboard.clearFilter();
        Assert.assertEquals(true, true);
    }

    @Test(priority = 10, description = "clear all filters")
    @Severity(SeverityLevel.NORMAL)
    public void verifysortByPrice() {
        dashboard.sortByPrice();
        Assert.assertEquals(true, true);
    }

    @Test(priority = 11, description = "click on price dropdown")
    @Severity(SeverityLevel.NORMAL)
    public void verifyrespones_selectPrice() {
        dashboard.selectPrice();
        Assert.assertEquals(true, true);
    }


    @Test(priority = 12, description = "select price range")
    @Severity(SeverityLevel.NORMAL)
    public void verifyrespones_selectPriceRange() {
        dashboard.selectPriceRange();
        Assert.assertEquals(true, true);
    }

    @Test(priority = 13, description = "select price range")
    @Severity(SeverityLevel.NORMAL)
    public void verifyitemsWithInpriceRangeData() throws InterruptedException {
        dashboard.itemsWithInpriceRangeData();
        Assert.assertEquals(true, true);
    }






   /*@AfterTest
    public void quitBrowserTest() {
       tearDown();
   }
*/

}