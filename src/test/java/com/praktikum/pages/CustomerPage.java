package com.praktikum.pages;

import com.praktikum.pages.BasePage;
import com.praktikum.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




public class CustomerPage extends BasePage {
    //@FindBy(xpath = "(//a[@class='nav-link-style d-flex align-items-center px-3 py-2'])[1]")
    //@FindBy(xpath = "//a[text()='Customer info']")
    //  @FindBy(xpath = "(//a[@class='nav-link-style d-flex align-items-center px-3 py-2'])[1]")
    @FindBy(css = "[class='border-bottom mb-0 customer-info active']")
    public WebElement customerInfo;
    @FindBy(css = "[class='ml-5 female']")
    public WebElement genderFemale;
    @FindBy(css = "[class='male']")
    public WebElement genderMale;
    @FindBy(id = "FirstName")
    public WebElement firstNameInputBox;
    @FindBy(id = "LastName")
    public WebElement lastNameInputBox;
    @FindBy(id = "Email")
    public WebElement emailInputBox;
    @FindBy(id = "Company")
    public WebElement companyInputBox;
    @FindBy(css = "[class='custom-control-label ml-1']")
    public WebElement newsletterButton;
    @FindBy(id = "save-info-button")
    public WebElement saveButton;
    @FindBy(id = "FirstName-error")
    public WebElement firstNameErrorMsg;
    @FindBy(id = "LastName-error")
    public WebElement lastNameErrorMsg;
    @FindBy(id = "Email-error")
    public WebElement emailWrongMsg;
    @FindBy(id = "Email-error")
    public WebElement emailErrorMsg;


    RegisterPage registerPage = new RegisterPage();

    public void updateCustomerInformation(String gender, String firstName, String lastName, String day, String month, String year,
                                          String email, String companyName) {
        BrowserUtils.waitFor(2);
        // customerInfo.click();
        // WebElement genderRadioBtn = Driver.get().findElement(By.cssSelector("label[for='gender-" + gender + "']"));
        //genderRadioBtn.click();
        if (gender.equals("female")) {
            genderFemale.click();
        } else {
            genderMale.click();
        }

        firstNameInputBox.clear();
        lastNameInputBox.clear();
        emailInputBox.clear();
        companyInputBox.clear();

        firstNameInputBox.sendKeys(firstName);
        lastNameInputBox.sendKeys(lastName);
        registerPage.dateOfBirth(day, month, year);
        emailInputBox.sendKeys(email);
        companyInputBox.sendKeys(companyName);
        BrowserUtils.waitFor(2);
        if (newsletterButton.isSelected()) {
            newsletterButton.click();
        }
        saveButton.click();
        BrowserUtils.waitFor(2);
    }

}
