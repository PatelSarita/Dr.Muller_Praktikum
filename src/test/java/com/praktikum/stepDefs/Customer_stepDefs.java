package com.praktikum.stepDefs;


import com.praktikum.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;


public class Customer_stepDefs extends Base_stepDefs {

    @When("The user enters valid information {string},{string},{string},{string},{string},{string},{string},{string}")
    public void theUserEntersValidInformation(String gender, String firstName, String lastName, String day, String month, String year, String email, String companyName) {
      // customerPage.myAccountIcon.click();
      //  customerPage.customerInfo.click();
        customerPage.updateCustomerInformation(gender, firstName, lastName, day, month, year, email, companyName);
    }
    @Then("And the updated {string} should reflect the new values in the Customer Info section")
    public void andTheUpdatedShouldReflectTheNewValuesInTheCustomerInfoSection(String firstName) {
      //  customerPage.customerInfo.click();
        System.out.println("firstName = " + firstName);
        System.out.println("customerPage.firstNameInputBox = " + customerPage.firstNameInputBox.getAttribute("value"));
       // assertEquals(firstName, customerPage.firstNameInputBox.getText());
        assertEquals(firstName, customerPage.firstNameInputBox.getAttribute("value"));

    }

    @Then("And the updated {string} should reflect the new value in the Customer Info section")
    public void andTheUpdatedShouldReflectTheNewValueInTheCustomerInfoSection(String email) {
      //  customerPage.customerInfo.click();
       // assertEquals(email, customerPage.emailInputBox.getText());
        System.out.println("email = " + email);
        System.out.println("customerPage.emailInputBox.getAttribute(\"value\") = " + customerPage.emailInputBox.getAttribute("value"));

        assertEquals(email, customerPage.emailInputBox.getAttribute("value"));
    }


    @When("The user leaves the firstName field empty")
    public void theUserLeavesTheFirstNameFieldEmpty() {
        customerPage.firstNameInputBox.clear();
    }
    @Then("The error message for First Name {string} should be displayed")
    public void theErrorMessageForFirstNameShouldBeDisplayed(String firstNameMsg) {
        assertEquals(firstNameMsg,customerPage.firstNameErrorMsg.getText());
    }

    @When("The user leaves the lastName field empty")
    public void theUserLeavesTheLastNameFieldEmpty() {
        customerPage.lastNameInputBox.clear();
    }
    @Then("The error message for Last Name {string} should be displayed")
    public void theErrorMessageForLastNameShouldBeDisplayed(String lastNameMsg) {
        assertEquals(lastNameMsg,customerPage.lastNameErrorMsg.getText());
    }

    @When("The user leaves the email field empty")
    public void theUserLeavesTheEmailFieldEmpty() {
        customerPage.emailInputBox.clear();
    }
    @Then("The error message for Email {string} should be displayed")
    public void theErrorMessageForEmailShouldBeDisplayed(String emailMsg) {
        assertEquals(emailMsg,customerPage.emailErrorMsg.getText());
    }


    @Then("The user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String wrongEmailMsg) {
        assertEquals(wrongEmailMsg,customerPage.emailWrongMsg.getText());
    }


    @Then("The user should not be able to choose invalid {string}")
    public void theUserShouldNotBeAbleToChooseInvalid(String day) {

        WebElement dayDropdown = Driver.get().findElement(By.cssSelector("[style='width: 5rem;']"));
        Select selectDay = new Select(dayDropdown);
        selectDay.selectByVisibleText(day);
    }



}



