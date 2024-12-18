package com.praktikum.pages;

import com.praktikum.utilities.ConfigurationReader;
import com.praktikum.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {
    @FindBy(id = "Email")
    public WebElement emailInput;
    @FindBy(id = "Password")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[@class='btn btn-primary col-12']")
    public WebElement loginBtn;
    @FindBy(css = "[class='btn btn-success col-12']")
    public WebElement registerBtn;
    @FindBy(tagName = "h1")
    public WebElement customerInfo;

    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
    public void login() {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOf(emailInput));
        emailElement.clear();
        emailElement.sendKeys(ConfigurationReader.get("email"));
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOf(passwordInput));
        passwordElement.clear();
        passwordElement.sendKeys(ConfigurationReader.get("password"));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginButton.click();
    }
}



