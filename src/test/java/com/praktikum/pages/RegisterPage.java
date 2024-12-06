package com.praktikum.pages;

import com.praktikum.utilities.BrowserUtils;
import com.praktikum.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
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
  
    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));

    public void register(String gender, String firstName, String lastName, String day, String month, String year,
                         String email, String companyName, String password, String confirmPassword) {

        WebElement genderRadioBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='gender-" + gender + "']")));
        genderRadioBtn.click();
        wait.until(ExpectedConditions.visibilityOf(firstNameInput)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOf(lastNameInput)).sendKeys(lastName);
        dateOfBirth(day, month, year);
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(companyInput)).sendKeys(companyName);
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(confirmPasswordInput)).sendKeys(confirmPassword);
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn)).click();

    }

    public void dateOfBirth(String day, String month, String year) {
        WebElement dayDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[style='width: 5rem;']")));
        Select selectDay = new Select(dayDropdown);
        selectDay.selectByVisibleText(day);

        WebElement monthDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[style='width: 7rem;']")));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(month);

        WebElement yearDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[style='width: 6rem;']")));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year);
    }

    public void requiredMessagesIsDisplayed(List<String> message){
        for (String m : message) {
            WebElement requiredMsg = Driver.get().findElement(By.id(""+m+"-error"));
            requiredMsg.isDisplayed();

           BrowserUtils.waitFor(2);
            requiredMsg.isDisplayed();
        }
    }

    public void enterPasswordWithSpaces(String firstName, String lastName, String email){
        wait.until(ExpectedConditions.visibilityOf(firstNameInput)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOf(lastNameInput)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
        passwordInput.sendKeys("       ");
        confirmPasswordInput.sendKeys("       ");
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn)).click();

    }

}

