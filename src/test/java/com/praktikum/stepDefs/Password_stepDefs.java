package com.praktikum.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;

public class Password_stepDefs extends Base_stepDefs{
    @Given("The user clicks on the {string} icon")
    public void theUserClicksOnThePage(String Password) {
        passwordPage.ChgPasswordIcon.click();
    }

    @When("The user enters  {string} and {string} and {string}")
    public void theUserEntersAndAnd(String OldPassword, String NewPassword, String ConfirmNewPassword) {
        passwordPage.changePassword(OldPassword,NewPassword,ConfirmNewPassword);
    }

    @Then("Verify that the user sees an error message: {string}")
    public void verifyThatTheUserSeesAnErrorMessage(String errorMsg) {
        assertTrue(passwordPage.passwordErrorMsg(errorMsg).isDisplayed());
        assertTrue(passwordPage.ErrorOldMsg.isDisplayed());
    }
    @Then("Verify that the user sees an old password error message: {string}")
    public void verifyThatTheUserSeesAnOldPasswordErrorMessage(String arg0) {
    }


    @When("The user enters valid {string} and {string} and {string}")
    public void theUserEntersValidAndAnd(String arg0, String arg1, String arg2) {
    }
}
