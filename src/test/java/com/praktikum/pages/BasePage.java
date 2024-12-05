package com.praktikum.pages;

import com.praktikum.utilities.BrowserUtils;
import com.praktikum.utilities.ConfigurationReader;
import com.praktikum.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//img[@alt='EN' and contains(@src, '/images/flags/us.png')]")
    public WebElement englishIcon;





    /**
     * You may use the method below to locate elements with their text.
     * List of Elements:
     * 1- Home page = 'Home page'
     * 2- Restorative Produkte = 'Restorative Produkte'
     * 3- Catalog = 'Catalog'
     * 4- e-IFU = 'e-IFU'
     * 5- About us = 'About us'
     * 6- My account = 'My account'
     * 7- Contact us = 'Contact us'
     */
    public WebElement titleMenu(String menuName){
        WebElement title = Driver.get().findElement(By.xpath("//a[text()='"+menuName+"']"));
        return title;
    }

    public void navigateToWebSite(){
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(3);
        englishIcon.click();
    }




}

