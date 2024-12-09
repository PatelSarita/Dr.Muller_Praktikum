package com.praktikum.stepDefs;

import com.praktikum.utilities.BrowserUtils;
import com.praktikum.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class Customer_stepDefs extends Base_stepDefs {

    @When("The user enters valid information {string},{string},{string},{string},{string},{string},{string},{string}")
    public void theUserEntersValidInformation(String gender, String firstName, String lastName, String day, String month, String year, String email, String companyName) {
        customerPage.updateCustomerInformation(gender, firstName, lastName, day, month, year, email, companyName);
    }
    @Then("And the updated {string} should reflect the new values in the Customer Info section")
    public void andTheUpdatedShouldReflectTheNewValuesInTheCustomerInfoSection(String firstName) {
        assertEquals(firstName, customerPage.firstNameInputBox.getAttribute("value"));
    }
    @Then("And the updated {string} should reflect the new value in the Customer Info section")
    public void andTheUpdatedShouldReflectTheNewValueInTheCustomerInfoSection(String email) {
        assertEquals(email, customerPage.emailInputBox.getAttribute("value"));
    }
    @When("The user leaves the firstName field empty")
    public void theUserLeavesTheFirstNameFieldEmpty() {
        customerPage.firstNameInputBox.clear();
        customerPage.saveButton.click();
    }
    @Then("The error message for First Name {string} should be displayed")
    public void theErrorMessageForFirstNameShouldBeDisplayed(String firstNameMsg) {
        BrowserUtils.waitFor(2);
        assertEquals(firstNameMsg,customerPage.firstNameErrorMsg.getText());
        BrowserUtils.waitFor(2);
    }
    @When("The user leaves the lastName field empty")
    public void theUserLeavesTheLastNameFieldEmpty() {
        customerPage.lastNameInputBox.clear();
        customerPage.saveButton.click();
    }
    @Then("The error message for Last Name {string} should be displayed")
    public void theErrorMessageForLastNameShouldBeDisplayed(String lastNameMsg) {
        BrowserUtils.waitFor(2);
        assertEquals(lastNameMsg,customerPage.lastNameErrorMsg.getText());
        BrowserUtils.waitFor(2);
    }
    @When("The user leaves the email field empty")
    public void theUserLeavesTheEmailFieldEmpty() {
        customerPage.emailInputBox.clear();
        customerPage.saveButton.click();
    }
    @Then("The error message for Email {string} should be displayed")
    public void theErrorMessageForEmailShouldBeDisplayed(String emailMsg) {
        BrowserUtils.waitFor(2);
        assertEquals(emailMsg,customerPage.emailErrorMsg.getText());
        BrowserUtils.waitFor(2);
    }
    @Then("The user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String wrongEmailMsg) {
        assertEquals(wrongEmailMsg,customerPage.emailWrongMsg.getText());
    }
    @Then("The user should not be able to choose invalid {string}")
    public void theUserShouldNotBeAbleToChooseInvalid(String day) {
        WebElement dayDropdown = Driver.get().findElement(By.cssSelector("[style='width: 5rem;']"));
        String dayValue = dayDropdown.getAttribute("value");
        Assert.assertNotEquals(day, dayValue);
        }
    }



