package com.qa.qatask.pages;

import com.qa.qatask.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.List;

public class Dashboard extends TestBase {

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement we_acceptCookies;

    @FindBy(xpath = "//div[@data-icon-name='x']")
    WebElement we_closePortal;

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

    @FindBy(xpath = "//button[@type='button']//span/descendant::span[text()='Price']")
    WebElement we_price;

    @FindBy(id = "price_from")
    WebElement we_priceFrom;

    @FindBy(id = "price_to")
    WebElement we_priceTo;

    @FindBy(xpath = "//h1[@class='u-margin-top-none']")
    WebElement we_getOutOfPriceDiv;


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
        try {
            we_portal.click();
            return true;
        } catch (WebDriverException e) {
            e.printStackTrace();
            return false;
        }
    }

    //close Portal
    public Boolean closetPortal() {
        try {
            we_closePortal.click();
            return true;
        } catch (WebDriverException e) {
            e.printStackTrace();
            return false;
        }

    }

    //accept all cookies
    public Boolean acceptCookies() {
        try {
            we_acceptCookies.click();
            return true;
        } catch (WebDriverException e) {
            e.printStackTrace();
            return false;
        }

    }

    //search with key 'Nik;
    public void search() {
        we_search.sendKeys("Nik");
    }

    //click on 'Nike'
    public Boolean clickNike() {
        try {
            we_clickNike.click();
            return true;
        } catch (WebDriverException e) {
            e.printStackTrace();
            return false;
        }
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

    public Boolean sortByPrice() {
        we_sortBy.click();
        List<WebElement> priceList = driver.findElements(By.xpath("//ul[@class=\"pile\"]"));
        for (WebElement element : priceList) {
            if (element.getText().contains("Price: Low to High")) {
                element.click();
            }
        }
        return true;
    }

    public Boolean selectPrice() {
        we_price.click();
        return true;
    }


    public Boolean selectPriceRange() {

        we_priceFrom.clear();
        we_priceFrom.sendKeys("5");
        we_priceTo.clear();
        we_priceTo.sendKeys("10");
        return true;
    }


    public Boolean itemsWithInpriceRangeData() throws InterruptedException {
        we_getOutOfPriceDiv.click();

        Thread.sleep(5000);
        List<WebElement> itemsWithInPriceRange = driver.findElements(By.xpath("//div[@class=\"ItemBox_title__2FmDy\"]//div/descendant::h3[@class='Text_text__QBn4- Text_subtitle__1I9iB Text_left__3s3CR Text_amplified__2ccjx Text_bold__1scEZ']"));
        List<Float> all_elements_text = new ArrayList<Float>();

        for (int i = 0; i < itemsWithInPriceRange.size(); i++) {
            //loading text of each element in to array all_elements_text
            String value = (itemsWithInPriceRange.get(i).getText());
            value = value.replace("£", "");
            all_elements_text.add(Float.parseFloat(value));
        }
        Boolean verifyIfResultTrue = inRange(all_elements_text, 5, 10);
        System.out.println("verifyIfResultTrue" + verifyIfResultTrue);
        return verifyIfResultTrue;
    }


    private static boolean inRange(List<Float> list, float min, float max) {
        return list.stream().allMatch(i -> i >= min && i <= max);
    }


}
