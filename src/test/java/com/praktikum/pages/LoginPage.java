package com.praktikum.pages;

import com.praktikum.utilities.BrowserUtils;
import com.praktikum.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(id = "Email")
    public WebElement emailInput;
    @FindBy(id = "Password")
    public WebElement passwordInput;
    @FindBy(css = "[class='btn btn-primary col-12']")
    public WebElement loginBtn;
    @FindBy(css = "[class='btn btn-success col-12']")
    public WebElement registerBtn;


    public void login(){
        emailInput.sendKeys(ConfigurationReader.get("email"));
        BrowserUtils.waitFor(2);
        passwordInput.sendKeys(ConfigurationReader.get("password"));
        BrowserUtils.waitFor(2);
        loginBtn.click();
        BrowserUtils.waitFor(2);
      // titleMenu("Home page").click();

    }



}
