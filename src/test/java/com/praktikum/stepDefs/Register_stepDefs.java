package com.praktikum.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Register_stepDefs extends Base_stepDefs{

    @When("The user clicks on the register button")
    public void theUserClicksOnTheRegisterButton() {
        loginPage.registerBtn.click();
    }

    @And("The user enters valid information {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
    public void theUserEntersValidInformationAnd(String gender, String firstName, String lastName, String day, String month, String year,
                                      String email, String companyName, String password, String confirmPassword) {
        registerPage.register(gender,firstName,lastName,day,month,year,email,companyName,password,confirmPassword);
    }
    @Then("The user should see the message {string}")
    public void theUserShouldSeeTheMessage(String registerMsjText) {
        assertEquals(registerMsjText,registerPage.accountCreatedMessage.getText());
    }

    @And("The user re-enters the existing information as {string},{string},{string},{string},{string},{string},{string},{string},{string} and {string}")
    public void theUserReEntersTheExistingInformationAsAnd(String gender, String firstName, String lastName, String day, String month, String year,
                                                           String email, String companyName, String password, String confirmPassword) {
        registerPage.register(gender,firstName,lastName,day,month,year,email,companyName,password,confirmPassword);
    }

    @Then("The user should see the error message {string}")
    public void theUserShouldSeeTheErrorMessage(String existingMsjText) {
        assertEquals(existingMsjText,registerPage.existingMessage.getText());
    }
    @When("The user leaves required fields blank")
    public void theUserLeavesRequiredFieldsBlank() {
        registerPage.registerBtn.click();
    }

    @Then("Verify that the following messages are displayed")
    public void verifyThatTheFollowingMessagesAreDisplayed(List<String> messageList) {
        registerPage.requiredMessagesIsDisplayed(messageList);
    }

    @When("The user enters valid information in the {string},{string},{string} fields and enters spaces in the Password and Confirm Password fields.")
    public void theUserEntersValidInformationInTheFieldsAndEntersSpacesInThePasswordAndConfirmPasswordFields(String firstName, String lastName, String email) {
        registerPage.enterPasswordWithSpaces(firstName,lastName,email);
    }
}
