package com.praktikum.stepDefs;


import com.praktikum.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class Address_stepDefs extends Base_stepDefs {
    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));

    @When("The user enters valid information {string},{string},{string},{string},{string},{string}{string},{string},{string},{string},{string},{string}")
    public void theUserEntersValidInformation(String firstName, String lastName, String email, String company, String country, String state, String city, String address1, String address2, String zip, String phoneNumber, String faxNumber) {
        wait.until(ExpectedConditions.visibilityOf(addressPage.addressButton)).click();
        addressPage.addnewAddress(firstName,lastName,email,company,country,state,city,address1,address2,zip,phoneNumber,faxNumber);
    }
    @Then("The user should be able to save")
    public void theUserShouldBeAbleToSave() {
        addressPage.addressSaveButton.click();
    }
    @When("The user enters valid information {string},{string},{string},{string},{string}{string},{string},{string},{string}")
    public void theUserEntersValidInformation(String firstName, String lastName, String email, String country, String state, String city, String address1, String zip, String phoneNumber) {
        wait.until(ExpectedConditions.visibilityOf(addressPage.addressButton)).click();
        addressPage.updateAddress(firstName,lastName,email,country,state,city,address1,zip,phoneNumber);
    }
    @Then("The user should be able to save updates")
    public void theUserShouldBeAbleToSaveUpdates() {
        addressPage.addressSaveButton.click();
    }
}