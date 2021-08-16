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
    public void verify_closeportal() {
        Boolean res_closeportal = dashboard.closetPortal();
        Assert.assertTrue(res_closeportal );
    }

    @Test(enabled = false, description = "select a portal 'united kingdom'")
    @Severity(SeverityLevel.NORMAL)
    public void verify_selectPortal() {
        Boolean res_selectPortal = dashboard.selectPortal();
        Assert.assertTrue(res_selectPortal);
    }

    @Test(priority = 3, description = "verify title page test -- warm up test")
    @Severity(SeverityLevel.MINOR)
    @Story("Story Name : Verify Title")
    @Description("Story Name : verify title page")
    public void verify_Title() {
        String actualTitle = dashboard.title();
        String expectedTitle = "Vinted | Sell and buy clothes, shoes and accessories";
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test(priority = 4, description = "verify accept cookies")
    @Description("Verify accept cookies")
    @Severity(SeverityLevel.MINOR)
    @Story("Story : Manage Cookies")
    public void verify_acceptCookies() {
        Boolean res_acceptCookies = dashboard.acceptCookies();
        Assert.assertTrue(res_acceptCookies);
    }

    @Test(priority = 5, description = "verify search input field contains string 'Nik'")
    @Description("verify search input field contains string 'Nik'")
    @Story("Story : Search Items")
    @Severity(SeverityLevel.BLOCKER)
    public void verify_search() {
        dashboard.search();
    }

    @Test(priority = 6, description = "verify Nike text is clicked from options available list")
    @Description("verify Nike text is clicked from options available list")
    @Severity(SeverityLevel.NORMAL)
    @Story("Story : Search Items")
    public void verify_clickNike() {
       Boolean res_clickNike =  dashboard.clickNike();
        Assert.assertTrue(res_clickNike);
    }

    @Test(priority = 7, description = "verify Text is present on page with Nike")
    @Description("verify Nike text is clicked from options available list")
    @Severity(SeverityLevel.NORMAL)
    @Story("Story : Search Items")
    public void verify_isNikeTextPresent() {
        Boolean res_isNikeTextPresent = dashboard.isNikeTextPresent("Nike");
        Assert.assertTrue(res_isNikeTextPresent);
    }

    @Test(priority = 8, description = "Assert that “Nike” filter appeared below the filter menu")
    @Severity(SeverityLevel.NORMAL)
    public void verify_selectWomenShoes() {
        Boolean res_selectWomenShoes = dashboard.selectWomenShoes();
        Assert.assertTrue(res_selectWomenShoes);
    }

    @Test(priority = 9, description = "clear all filters")
    @Severity(SeverityLevel.NORMAL)
    public void verify_clearFilter() throws InterruptedException {
        Boolean res_clearFilter =  dashboard.clearFilter();
        Assert.assertTrue(res_clearFilter);
    }

    @Test(priority = 10, description = "clear all filters")
    @Severity(SeverityLevel.NORMAL)
    public void verify_sortByPriceClick() {
        Boolean res_sortByPriceClick =  dashboard.sortByPriceClick();
        Assert.assertTrue(res_sortByPriceClick);
    }

    @Test(priority = 11, description = "select price range")
    @Severity(SeverityLevel.NORMAL)
    public void verify_isSortedByLowToHigh() throws InterruptedException {
        Boolean res_isSortedByLowToHigh  = dashboard.isSortedByLowToHigh();
        Assert.assertTrue(res_isSortedByLowToHigh);
    }


    @Test(priority = 12, description = "click on price dropdown")
    @Severity(SeverityLevel.NORMAL)
    public void verify_clickPrice() {
        Boolean res_clickPrice = dashboard.clickPrice();
        Assert.assertTrue(res_clickPrice);
    }

    @Test(priority = 13, description = "select price range")
    @Severity(SeverityLevel.NORMAL)
    public void verify_selectPriceRange() {
        dashboard.selectPriceRange();
    }

    @Test(priority = 14, description = "select price range")
    @Severity(SeverityLevel.NORMAL)
    public void verify_itemsWithInpriceRangeData() throws InterruptedException {
        Boolean res_itemsWithInpriceRangeData  = dashboard.itemsWithInpriceRangeData();
        Assert.assertTrue(res_itemsWithInpriceRangeData);
    }


@AfterTest
    public void quitBrowserTest() {
       tearDown();
   }


}