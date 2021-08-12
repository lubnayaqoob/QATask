package com.qa.qatask.pages;

import com.qa.qatask.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestUtil;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dashboard extends TestBase {

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement we_acceptCookies;

    @FindBy(xpath = "//div[@data-icon-name='x']")
    WebElement we_closeDialog;

    @FindBy(xpath = "//div[@role='dialog']//div/descendant::span[contains(text(),'United Kingdom')]")
    WebElement we_portal;
    //div[@class='u-ui-padding-regular u-fill-width']//div/descendant::span[text()='United Kingdom']

    @FindBy(id = "search_text")
    WebElement we_search;

    @FindBy(xpath = "//ul[@class='pile']//li/descendant::a[@href='/vetements?search_text=Nike']")
    WebElement we_clickNike;

    @FindBy(xpath = "//a[@class='c-tabs__link js-header-navigation-tab-item' and @href=\"/women\"]")
    WebElement we_women;

    @FindBy(xpath = "//a[@class='c-cell__link js-browse-tab' and @href=\"/women/shoes\"]")
    WebElement we_womenShoes;

    @FindBy(xpath = "//div[@data-id='543' and @data-title='Heels']")
    WebElement we_womenShoesHeels;

    @FindBy(xpath = "//a[@href=\"/women/shoes/heels/high-heels\"]")
    WebElement we_womenShoesHeelsHighHeels;

    @FindBy(xpath = "//span[@class=\"Button_content__1Pyrd\"]//span/descendant::span[text()='Clear filters']")
    WebElement we_clearFilter;

    @FindBy(xpath = "//span[@class=\"Button_label__3jCra\"]//span[text()='Sort by']")
    WebElement we_sortBy;

    @FindBy(xpath = "//span[text()='Price: Low to High']//parent::h2[@class='Text_text__QBn4- Text_title__2EQGT Text_left__3s3CR']")
    WebElement we_lowToHighPrice;

    @FindBy(xpath = "//li[@class=\"pile__element\"]//div/descendant::span[text()='Price: high to low']")
    WebElement we_lowToHighPrice1;


    //constructor of the class
    public Dashboard() {
        PageFactory.initElements(driver, this);

    }

    //get title
    public String title() {
        String title = driver.getTitle();
        return title;
    }

    //select Portal
    public Boolean selectPortal() {
        we_portal.click();
        return true;
    }

    //close Portal
    public Boolean closetPortal() {
        we_closeDialog.click();
        return true;
    }

    //accept all cookies
    public Boolean acceptCookies() {
        we_acceptCookies.click();
        return true;

    }

    //search with key 'Nik;
    public void search() {
        we_search.sendKeys("Nik");
    }

    //click on 'Nike'
    public Boolean clickNike() {
        we_clickNike.click();
        return true;
    }

    //Nike text present
    public Boolean NikeTextPresent() {
        driver.getPageSource().contains("Nike");
        return true;
    }

    //click on dropdown list and select  and click price filter
    public Boolean selectWomenShoes() {
        we_women.click();
        we_womenShoes.click();
        we_womenShoesHeels.click();
        we_womenShoesHeelsHighHeels.click();
        return true;
    }

    public Boolean clearFilter() throws InterruptedException {
        Thread.sleep(5000);
        we_clearFilter.click();
        return true;
    }

    public Boolean sorByPrice() {
        we_sortBy.click();
        List<WebElement> priceList = driver.findElements(By.xpath("//ul[@class=\"pile\"]"));
        for (WebElement element : priceList) {
            if (element.getText().contains("Price: Low to High")) {
                element.click();
            }
        }
       return true;
    }


    public Boolean isSortedByPrice(){

        List<WebElement> priceList = driver.findElements(By.xpath("//div[@class=\"ItemBox_title-content__1LClm\"]"));
        List<Integer> values = new ArrayList<Integer>();


            for (WebElement element : priceList) {
                values.add(Integer.parseInt(element.getText()));

            }
            for( int j = 0; j <values.size(); j++)
                System.out.println(" values.add(Integer.parseInt(element.getText()))======" + values.get(j));
            //List ourAl = new ArrayList<>();
        return true;
        }



}
