package com.praktikum.pages;

import com.praktikum.utilities.BrowserUtils;
import com.praktikum.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AddressPage extends BasePage {

    @FindBy(xpath = "(//a[text()='Addresses'])[1]")
    public WebElement addressButton;
    @FindBy(css = "[class='btn btn-primary col-12 col-md-4']")
    public WebElement newAddressButton;
    @FindBy(id = "Address_FirstName")
    public WebElement addressFirstName;
    @FindBy(id = "Address_LastName")
    public WebElement addressLastName;
    @FindBy(id = "Address_Email")
    public WebElement addressEmail;
    @FindBy(id = "Address_Company")
    public WebElement addressCompany;
    @FindBy(id = "Address_CountryId")
    public WebElement addressCountryDropdown;
    @FindBy(xpath = "//select[@name='Address.StateProvinceId']")
    public WebElement addressStateDropdown;
    @FindBy(id = "Address_City")
    public WebElement addressCity;
    @FindBy(id = "Address_Address1")
    public WebElement addressAddress1;
    @FindBy(id = "Address_Address2")
    public WebElement addressAddress2;
    @FindBy(id = "Address_ZipPostalCode")
    public WebElement addressZipPostalCode;
    @FindBy(id = "Address_PhoneNumber")
    public WebElement addressPhoneNumber;
    @FindBy(id = "Address_FaxNumber")
    public WebElement addressFaxNumber;
    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement addressSaveButton;
    @FindBy(xpath = "(//button[@type='button'])[1]")
    public WebElement addressUpdateButton;
    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));

    public void addnewAddress(String firstName, String lastName,
                              String email, String companyName, String country,String state,String city, String address1, String address2, String zip, String phoneNumber, String faxNumber) {

        wait.until(ExpectedConditions.visibilityOf(newAddressButton)).click();
        wait.until(ExpectedConditions.visibilityOf(addressFirstName)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOf(addressLastName)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOf(addressEmail)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(addressCompany)).sendKeys(companyName);
        selectCountryStateFromDropdown(country, state);
        wait.until(ExpectedConditions.visibilityOf(addressCity)).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOf(addressAddress1)).sendKeys(address1);
        wait.until(ExpectedConditions.visibilityOf(addressAddress2)).sendKeys(address2);
        wait.until(ExpectedConditions.visibilityOf(addressZipPostalCode)).sendKeys(zip);
        wait.until(ExpectedConditions.visibilityOf(addressPhoneNumber)).sendKeys(phoneNumber);
        wait.until(ExpectedConditions.visibilityOf(addressFaxNumber)).sendKeys(faxNumber);
    }

    public void selectCountryStateFromDropdown(String text1, String text2) {
        Select selectCountry = new Select(addressCountryDropdown);
        selectCountry.selectByVisibleText(text1); // Select the option by visible text
        BrowserUtils.waitFor(1); // Wait for 1 second (if necessary)

        Select selectState = new Select(addressStateDropdown);
        selectState.selectByVisibleText(text2); // Select the option by visible text
        BrowserUtils.waitFor(1); // Wait for 1 second (if necessary)
    }

    public void updateAddress(String firstName, String lastName,
                              String email, String country,String state,String city, String address1, String zip, String phoneNumber) {

        wait.until(ExpectedConditions.visibilityOf(addressUpdateButton)).click();
        wait.until(ExpectedConditions.visibilityOf(addressFirstName)).clear();
        wait.until(ExpectedConditions.visibilityOf(addressFirstName)). sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOf(addressLastName)).clear();
        wait.until(ExpectedConditions.visibilityOf(addressLastName)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOf(addressEmail)).clear();
        wait.until(ExpectedConditions.visibilityOf(addressEmail)).sendKeys(email);
        selectCountryStateFromDropdown(country, state);
        wait.until(ExpectedConditions.visibilityOf(addressCity)).clear();
        wait.until(ExpectedConditions.visibilityOf(addressCity)).sendKeys(city);
        wait.until(ExpectedConditions.visibilityOf(addressAddress1)).clear();
        wait.until(ExpectedConditions.visibilityOf(addressAddress1)).sendKeys(address1);
        wait.until(ExpectedConditions.visibilityOf(addressZipPostalCode)).clear();
        wait.until(ExpectedConditions.visibilityOf(addressZipPostalCode)).sendKeys(zip);
        wait.until(ExpectedConditions.visibilityOf(addressPhoneNumber)).clear();
        wait.until(ExpectedConditions.visibilityOf(addressPhoneNumber)).sendKeys(phoneNumber);

    }
}
