package com.praktikum.pages;

import com.praktikum.utilities.BrowserUtils;
import com.praktikum.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends BasePage {
    @FindBy(css = "[class='czi-compare mr-2']")
    public WebElement ChgPasswordIcon;
    @FindBy(id = "OldPassword")
    public WebElement OldPassInput;
    @FindBy(id = "NewPassword")
    public WebElement NewPassInput;
    @FindBy(id = "ConfirmNewPassword")
    public WebElement CnfNewPassInput;
    @FindBy(xpath = "//li[text()=\"Old password doesn't match\"]")
    public WebElement ErrorOldMsg;
    @FindBy(css = "[class='btn btn-primary col-12 col-md-4']")
    public WebElement ChnPasswordBtn;

    public void changePassword(String OldPassword, String NewPassword, String ConfirmNewPassword) {
        BrowserUtils.waitFor(2);
        OldPassInput.sendKeys(OldPassword);
        NewPassInput.sendKeys(NewPassword);
        CnfNewPassInput.sendKeys(ConfirmNewPassword);
        ChnPasswordBtn.click();

    }

    public WebElement passwordErrorMsg(String errorMsg) {
        WebElement errorText = Driver.get().findElement(By.xpath("//*[text()='" + errorMsg + "']"));
        return errorText;
    }

    public WebElement oldErrorMsg(String errorMsg) {
        WebElement oldErrorText = Driver.get().findElement(By.cssSelector("[class='btn btn-primary col-12 col-md-4']"));
        return oldErrorText;
    }

    public void validChangePassword(String OldPassword, String NewPassword, String ConfirmNewPassword) {
        BrowserUtils.waitFor(2);
        OldPassInput.sendKeys(OldPassword);
        NewPassInput.sendKeys(NewPassword);
        CnfNewPassInput.sendKeys(ConfirmNewPassword);
        ChnPasswordBtn.click();
    }
}