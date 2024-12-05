package com.praktikum.pages;

import com.praktikum.utilities.BrowserUtils;
import com.praktikum.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage{

    @FindBy (css = ".h3.text-light.mb-0")
    public WebElement shoppingCartTitle;

    @FindBy(xpath = "(//td[@class='cart-total-right'])[4]")
    public WebElement productPrice;
    @FindBy(xpath="//button[@name='checkout']")
    public WebElement checkoutButton;
HomePage homePage=new HomePage();

    public WebElement getProductQuantity(String text) {
        WebElement pageElements = Driver.get().findElement(By.xpath("//option[@value='" + text + "']"));
        return pageElements;
    }
    public WebElement getCartProductName(String text){
        WebElement pageElement= Driver.get().findElement(By.xpath("//*[@class='text-danger']/*[text()='" + text + "']"));
        return pageElement;
    }
    public void navigateToCheckoutPage() {
        BrowserUtils.hover(homePage.cartIcon);
        BrowserUtils.waitFor(1);
        homePage.goToCartButton.click();
        checkoutButton.click();
        BrowserUtils.waitFor(1);
    }

}
