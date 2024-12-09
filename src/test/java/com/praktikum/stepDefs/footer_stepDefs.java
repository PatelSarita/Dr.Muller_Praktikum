package com.praktikum.stepDefs;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class footer_stepDefs extends Base_stepDefs {

    @Given("The user should be able to verify that the Footer is visible with the following headers.")
    public void theUserShouldBeAbleToVerifyThatTheFooterIsVisibleWithTheFollowingHeaders(List<String> footerList) {
        homePage.footerTitleMenu(footerList);
    }

    @Then("The user should see that the footer titles are clickable and move on to the following pages.")
    public void theUserShouldSeeThatTheFooterTitlesAreClickableAndMoveOnToTheFollowingPages(List<String> expectedPageName) {
        homePage.verifyClickFooterLink(expectedPageName);
    }


    @When("The user enters {string} in the Follow Us field")
    public void theUserEntersInTheFollowUsField(String email) {
        homePage.signUpFollowUsField(email);
    }

    @Then("The user should see a sign up {string}")
    public void theUserShouldSeeASignUp(String message) {
        Assert.assertTrue(homePage.verifySignUpMessage(message).isDisplayed());
    }
}
