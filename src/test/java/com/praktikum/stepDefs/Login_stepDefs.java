package com.praktikum.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_stepDefs extends Base_stepDefs{

    @Given("The user navigates to the {string} on the website")
    public void theUserNavigatesToTheOnTheWebsite(String menuName) {
        loginPage.titleMenu(menuName).click();
    }

    @When("The user enters valid credentials")
    public void theUserEntersValidCredentials() {
        loginPage.login();
    }

    @Then("The user should go to the {string} page")
    public void theUserShouldGoToThePage(String text) {
        Assert.assertEquals(text,loginPage.customerInfo.getText());
    }
}
