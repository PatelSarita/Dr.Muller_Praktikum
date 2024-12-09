package com.praktikum.pages;

import com.praktikum.utilities.BrowserUtils;
import com.praktikum.utilities.ConfigurationReader;
import com.praktikum.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;


public class PasswordPage extends BasePage {
    @FindBy(css = "[class='czi-compare mr-2']")
    public WebElement ChgPasswordIcon;
    @FindBy(id = "OldPassword")
    public WebElement OldPassInput;
    @FindBy(id = "NewPassword")
    public WebElement NewPassInput;
    @FindBy(id = "ConfirmNewPassword")
    public WebElement CnfNewPassInput;
    @FindBy(css = "[id='OldPassword-error']")
    public WebElement oldPasswordError;

    @FindBy(css = "[id='NewPassword-error']")
    public WebElement newPasswordError;

    @FindBy(css = "[id='ConfirmNewPassword-error']")
    public WebElement confPasswordError;

    @FindBy(css = "[class='btn btn-primary col-12 col-md-4']")
    public WebElement ChnPasswordBtn;

    @FindBy(xpath = "//*[text()='Password was changed']")
    public WebElement validMsg;
//    @FindBy(xpath = "//div[@class='message-error alert alert-danger validation-summary-errors']")
//    public WebElement ErrorOldMsg;


    public void validChangePassword(String newPassword, String confirmNewPassword) {
        BrowserUtils.waitFor(2);
        OldPassInput.sendKeys(ConfigurationReader.get("password"));
        NewPassInput.sendKeys(newPassword);
        CnfNewPassInput.sendKeys(confirmNewPassword);
        ChnPasswordBtn.click();
    }
    public void changePassword(String oldPassword, String newPassword, String confirmNewPassword) {
        BrowserUtils.waitFor(2);
        OldPassInput.sendKeys(oldPassword);
        NewPassInput.sendKeys(newPassword);
        CnfNewPassInput.sendKeys(confirmNewPassword);
        ChnPasswordBtn.click();
    }

            //This method is used if you need to verify more than one error msg.
    public void verifyErrMessages(String oldErrorMsg, String newErrorMsg, String confirmErrorMsg) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(oldPasswordError));
            if (oldPasswordError.getText().equals(oldErrorMsg)) {
                System.out.println("Old error message verified: " + oldErrorMsg);
            } else {
                System.err.println("Does not match the expected old error message. Expected: " + oldErrorMsg + ", Found: " + oldPasswordError.getText());
            }
        } catch (Exception e) {
            System.err.println("Old password error item was not displayed.");
        }
        try {
            wait.until(ExpectedConditions.visibilityOf(newPasswordError));
            if (newPasswordError.getText().equals(newErrorMsg)) {
                System.out.println("New error message verified: " + newErrorMsg);
            } else {
                System.err.println("Does not match the expected new error message.");
            }
        } catch (Exception e) {
            System.err.println("New password error item not displayed.");
        }
        try {
            wait.until(ExpectedConditions.visibilityOf(confPasswordError));
            if (confPasswordError.getText().equals(confirmErrorMsg)) {
                System.out.println("Confirm error message verified: " + confirmErrorMsg);
            } else {
                System.err.println("Expected validation does not match error message.");
            }
        } catch (Exception e) {
            System.err.println("Verification password error item not displayed.");
        }
    }
}

