package com.praktikum.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class Password_stepDefs extends Base_stepDefs{
    @Given("The user clicks on the Change Password icon")
    public void theUserClicksOnThePage() {
        passwordPage.ChgPasswordIcon.click();
    }

    @When("The user enters valid {string} and {string}")
    public void theUserEntersValidAnd(String newPassword, String confirmNewPassword) {
        passwordPage.validChangePassword(newPassword, confirmNewPassword);
    }

    @Then("Verify that the user sees a message: {string}")
    public void verifyThatTheUserSeesAMessage(String validMsg) {
        assertEquals(validMsg, passwordPage.validMsg.getText());
    }

    @When("The user enters {string} and {string} and {string}")
    public void theUserEntersAndAnd(String oldPassword, String newPassword, String confirmNewPassword) {
        passwordPage.changePassword(oldPassword, newPassword, confirmNewPassword);
    }

    @Then("Verify that the user sees an {string} and {string} and {string}")
    public void verifyThatTheUserSeesAnAndAnd(String oldErrorMsg, String newErrorMsg, String confirmErrorMsg) {
        passwordPage.verifyErrMessages(oldErrorMsg, newErrorMsg, confirmErrorMsg);


    }
}
