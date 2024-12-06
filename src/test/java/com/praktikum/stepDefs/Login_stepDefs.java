package com.praktikum.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Login_stepDefs extends Base_stepDefs{

    @Given("The user navigates to the {string} on the website")
    public void theUserNavigatesToTheOnTheWebsite(String menuName) {

        loginPage.titleMenu(menuName).click();
    }

    @When("The user enters valid credentials")
    public void theUserEntersValidCredentials() {

        loginPage.login();
    }
}
