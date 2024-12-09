package com.praktikum.stepDefs;

import com.praktikum.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;


public class Purchase_stepDefs extends Base_stepDefs {

    @And("The user is on Home page and clicks on {string}")
    public void theUserIsOnHomePageAndClicksOn(String productCategory) {
        homePage.selectProductCategory(productCategory);
    }

    @And("select the {string} and {string} and clicks on Add to cart")
    public void selectTheAndAndClicksOnAddToCart(String product, String quantity) {
        homePage.addProduct(product, quantity);

    }


    @Then("The Product added to your shopping cart message {string} should be displayed")
    public void theProductAddedToYourShoppingCartMessageShouldBeDisplayed(String expectedMsg) {
        assertEquals(expectedMsg, homePage.productAddedToCartMsg.getText());
        BrowserUtils.waitFor(1);
    }

    @When("The user hover over on the Cart icon and clicks on The Go to cart button")
    public void theUserHoverOverOnTheCartIconAndClicksOnTheGoToCartButton() {
        BrowserUtils.hover(homePage.cartIcon);
        BrowserUtils.waitFor(1);
        homePage.goToCartButton.click();
        BrowserUtils.waitForVisibility(shoppingCartPage.shoppingCartTitle, 1);
    }

    @Then("The user should be able to see details {string} and {string} and {string}")
    public void theUserShouldBeAbleToSeeDetailsAndAnd(String productName, String productQuantity, String productPrice) {
        assertEquals(productName, shoppingCartPage.getCartProductName(productName).getText());
        BrowserUtils.waitFor(1);
        assertEquals(productQuantity, shoppingCartPage.getProductQuantity(productQuantity).getText());
        BrowserUtils.waitFor(1);
        assertEquals(productPrice, shoppingCartPage.productPrice.getText());
        BrowserUtils.waitFor(1);

    }

    @When("The user clicks on Checkout button from Shopping Cart page")
    public void theUserClicksOnCheckoutButtonFromShoppingCartPage() {
        BrowserUtils.hover(homePage.cartIcon);
        BrowserUtils.waitFor(1);
        homePage.goToCartButton.click();
        shoppingCartPage.checkoutButton.click();
        BrowserUtils.waitFor(1);
    }

    @Then("The user should be able to navigate to {string} page and continue {string}")
    public void theUserShouldBeAbleToNavigateToPageAndContinue(String page, String guestCheckout) {
        assertEquals(page, checkoutPage.checkoutTitle.getText());
        checkoutPage.navigateToRelevantSection(guestCheckout).click();

    }

    @When("The user click on {string} dropdown and click New Address and edit {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and clicks {string} continue button")
    public void theUserClickOnDropdownAndClickNewAddressAndEditAndClicksContinueButton(String page, String firstName, String lastName, String email, String country, String state, String city, String address, String zipCode, String phone, String text) {
        assertEquals(page, checkoutPage.navigateToRelevantSection(page).getText());
        BrowserUtils.waitFor(1);
        checkoutPage.editNewAddressFromDropdown(firstName, lastName, email, country, state, city, address, zipCode, phone, text);
    }


    @Then("The user is navigated to {string} section and click {string} continue button")
    public void theUserIsNavigatedToSectionAndClickContinueButton(String page, String text) {
        assertEquals(page, checkoutPage.navigateToRelevantSection(page).getText());
        BrowserUtils.waitFor(2);
        checkoutPage.continueButtonOnCheckoutPage(text);
        BrowserUtils.waitFor(1);
    }

    @Then("The user is able to see order confirmation {string}")
    public void theUserIsAbleToSeeOrderConfirmation(String msg) {
        assertEquals(msg, checkoutPage.navigateToRelevantSection(msg).getText());
        BrowserUtils.waitFor(2);
    }


    @When("The user click on {string} dropdown and click New Address and edit {string}, {string}, {string}, {string}, {string}, {string}, {string},{string} and clicks {string} continue button")
    public void theUserClickOnDropdownAndClickNewAddressAndEditAndClicksContinueButton(String page,String firstName,String lastName,String email,String city,String address,String zip,String phone,String fieldName,String text) {
        assertEquals(page, checkoutPage.navigateToRelevantSection(page).getText());
        checkoutPage.enterOnlySpacesInToField(firstName,lastName,email,city, address, zip, phone, text, fieldName);

    }
}
