package com.qa.qatask.pages;

import com.qa.qatask.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestUtil;


import java.util.concurrent.TimeUnit;

public class Dashboard extends TestBase {

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement we_acceptCookies;

    @FindBy(xpath = "//div[@data-icon-name='x']")
    WebElement we_closeDialog;

    @FindBy(xpath = "//div[@role='dialog']//div/descendant::span[contains(text(),'United Kingdom')]")
    WebElement we_portal;
    //div[@class='u-ui-padding-regular u-fill-width']//div/descendant::span[text()='United Kingdom']

    @FindBy(id="search_text")
    WebElement we_search;

    @FindBy(xpath = "//div[@class='card free']//div[@class='card-title'][6]")
    WebElement getPowerConsumedWE;


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
    public Boolean selectPortal(){
        we_portal.click();
        return true;
    }

    //close Portal
    public Boolean closetPortal() {
        we_closeDialog.click();
        return true;
    }

    //accept all cookies
    public Boolean acceptCookies()  {
        we_acceptCookies.click();
        return true;

    }

    public void search(){
        we_search.sendKeys("Nik");
    }

}
