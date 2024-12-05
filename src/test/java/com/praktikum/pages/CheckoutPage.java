package com.praktikum.pages;

import com.praktikum.utilities.BrowserUtils;
import com.praktikum.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//div[@class='order-lg-1 pr-lg-4 text-center text-lg-left']")
    public WebElement checkoutTitle;
    @FindBy(xpath = "//select[@name='billing_address_id']")
    public WebElement billingAddressDropdown;

    @FindBy(xpath = "//select[@name='shipping_address_id']")
    public WebElement shippingAddressDropdown;

    @FindBy(xpath = "//input[@name='BillingNewAddress.FirstName']")
    public WebElement firstNameBillingAddress;
    @FindBy(id = "BillingNewAddress_LastName")
    public WebElement lastNameBillingAddress;
    @FindBy(id = "BillingNewAddress_Email")
    public WebElement emailBillingAddress;
    @FindBy(xpath = "//select[@id=\"BillingNewAddress_CountryId\"]")
    public WebElement countryBillingAddress;
    @FindBy(xpath = "//select[@id=\"BillingNewAddress_StateProvinceId\"]")
    public WebElement stateBillingAddress;
    @FindBy(id = "BillingNewAddress_City")
    public WebElement cityBillingAddress;
    @FindBy(id = "BillingNewAddress_Address1")
    public WebElement addressBillingAddress;
    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    public WebElement zipBillingAddress;
    @FindBy(id = "BillingNewAddress_PhoneNumber")
    public WebElement phoneBillingAddress;
    @FindBy(xpath = "//input[@id=\"ShipToSameAddress\"]")
    public WebElement shipToSameAddressCheckBox;


    public WebElement navigateToRelevantSection(String text) {
        WebElement pageElements = Driver.get().findElement(By.xpath("//*[text()='" + text + "']"));
        return pageElements;

    }

    public void continueButtonOnCheckoutPage(String text) {
        WebElement continueButton = Driver.get().findElement(By.xpath("//button[text()='Continue'][@onclick='" + text + ".save()']"));
        continueButton.click();
    }

    public void selectAddressFromDropdown(String text) {
        Select selectAddress = new Select(billingAddressDropdown);
        selectAddress.getFirstSelectedOption();
        BrowserUtils.waitFor(1);
        continueButtonOnCheckoutPage(text);
    }

    public void editNewAddressFromDropdown(String firstName, String lastName, String email, String country, String state, String city, String address, String zipCode, String phone, String text) {

        BrowserUtils.waitFor(1);
        firstNameBillingAddress.sendKeys(firstName);
        BrowserUtils.waitFor(1);
        lastNameBillingAddress.sendKeys(lastName);
        BrowserUtils.waitFor(1);
        emailBillingAddress.sendKeys(email);
        BrowserUtils.waitForVisibility(countryBillingAddress, 5);
        Select selectCountry = new Select(countryBillingAddress);
        BrowserUtils.waitFor(2);
        selectCountry.selectByVisibleText(country);
        BrowserUtils.waitForVisibility(stateBillingAddress, 5);
        Select selectState = new Select(stateBillingAddress);
        BrowserUtils.waitFor(1);
        selectState.selectByVisibleText(state);
        BrowserUtils.waitFor(1);
        cityBillingAddress.sendKeys(city);
        BrowserUtils.waitFor(1);
        addressBillingAddress.sendKeys(address);
        BrowserUtils.waitFor(1);
        zipBillingAddress.sendKeys(zipCode);
        BrowserUtils.waitFor(1);
        phoneBillingAddress.sendKeys(phone);
        BrowserUtils.waitFor(1);
        continueButtonOnCheckoutPage(text);
        BrowserUtils.waitFor(1);

    }

    public void enterOnlySpacesInToField(String firstName, String lastName, String email, String city, String address, String zip, String phone, String text,String fieldName) {
        BrowserUtils.waitFor(1);
        firstNameBillingAddress.sendKeys(firstName);
        BrowserUtils.waitFor(1);
        lastNameBillingAddress.sendKeys(lastName);
        BrowserUtils.waitFor(1);
        emailBillingAddress.sendKeys(email);
        BrowserUtils.waitFor(1);
        cityBillingAddress.sendKeys(city);
        BrowserUtils.waitFor(1);
        addressBillingAddress.sendKeys(address);
        BrowserUtils.waitFor(1);
        zipBillingAddress.sendKeys(zip);
        BrowserUtils.waitFor(1);
        phoneBillingAddress.sendKeys(phone);
        BrowserUtils.waitFor(1);
        WebElement field;
        switch (fieldName.toLowerCase()) {
            case "first name":
                field = firstNameBillingAddress;
                break;
            case "last name":
                field = lastNameBillingAddress;
                break;
            case "email":
                field = emailBillingAddress;
                break;
            case "city":
                field = cityBillingAddress;
                break;
            case "address":
                field = addressBillingAddress;
                break;
            case "zip":
                field = zipBillingAddress;
                break;
            case "phone":
                field = phoneBillingAddress;
                break;
            default:
                throw new IllegalArgumentException("Invalid field name: " + fieldName);
        }
        field.clear();
        field.sendKeys("       ");
        BrowserUtils.waitFor(1);
        continueButtonOnCheckoutPage(text);
        BrowserUtils.waitFor(1);

    }

}
