package com.praktikum.pages;

import com.praktikum.utilities.BrowserUtils;
import com.praktikum.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterPage extends BasePage {

    @FindBy(id = "FirstName")
    public WebElement firstNameInput;
    @FindBy(id = "LastName")
    public WebElement lastNameInput;
    @FindBy(id = "Email")
    public WebElement emailInput;
    @FindBy(id = "Company")
    public WebElement companyInput;
    @FindBy(id = "Password")
    public WebElement passwordInput;
    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPasswordInput;
    @FindBy(id = "register-button")
    public WebElement registerBtn;
    @FindBy(css = "[class='result alert alert-success']")
    public WebElement accountCreatedMessage;
    @FindBy(css = "[class='alert alert-primary alert alert-danger validation-summary-errors']")
    public WebElement existingMessage;


    public void register(String gender, String firstName, String lastName, String day, String month, String year,
                         String email, String companyName, String password, String confirmPassword) {
        WebElement genderRadioBtn = Driver.get().findElement(By.cssSelector("label[for='gender-"+gender+"']"));
        genderRadioBtn.click();
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        dateOfBirth(day,month,year);
        emailInput.sendKeys(email);
        companyInput.sendKeys(companyName);
        BrowserUtils.waitFor(2);
        passwordInput.sendKeys(password);
        BrowserUtils.waitFor(2);
        confirmPasswordInput.sendKeys(confirmPassword);
        BrowserUtils.waitFor(2);
        registerBtn.click();
        BrowserUtils.waitFor(2);
    }

    public void dateOfBirth(String day, String month, String year) {
        WebElement dayDropdown = Driver.get().findElement(By.cssSelector("[style='width: 5rem;']"));
        Select selectDay = new Select(dayDropdown);
        selectDay.selectByVisibleText(day);

        WebElement monthDropdown = Driver.get().findElement(By.cssSelector("[style='width: 7rem;']"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(month);

        WebElement yearDropdown = Driver.get().findElement(By.cssSelector("[style='width: 6rem;']"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year);
    }

    public void requiredMessagesIsDisplayed(List<String> message){
        for (String m : message) {
            WebElement requiredMsg = Driver.get().findElement(By.id(""+m+"-error"));
            requiredMsg.isDisplayed();
        }


    }

}

