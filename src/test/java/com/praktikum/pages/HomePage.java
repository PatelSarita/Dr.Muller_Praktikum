package com.praktikum.pages;

import com.praktikum.utilities.BrowserUtils;
import com.praktikum.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[text()='Home page']")
    public WebElement homePageMenu;
    @FindBy(xpath = "//i[@class='navbar-tool-icon czi-cart']")
    public WebElement cartIcon;

    @FindBy(css = ".btn.btn-success.btn-sm")
    public WebElement goToCartButton;

    @FindBy(xpath = "//select[@class='form-control custom-select MctCartQtyDrp']")
    public WebElement quantityDropdown;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-shadow btn-block']")
    public WebElement addToCart;

    @FindBy(xpath = "//div[@class='bar-notification success']")
    public WebElement productAddedToCartMsg;

    public WebElement getCategoryName(String text){
        WebElement categoryName= Driver.get().findElement(By.xpath("//h3[text()='" + text + "']"));
        return categoryName;
    }

    public WebElement getProductName(String text) {
        WebElement pageElements = Driver.get().findElement(By.xpath("//*[@class='product-title']/*[text()='" + text + "']"));
        return pageElements;
    }
    public void addProduct(String productName,String productQuantity){
        getProductName(productName).click();
        Select quantitySelect = new Select(quantityDropdown);
        quantitySelect.selectByValue(productQuantity);
        addToCart.click();
        BrowserUtils.waitFor(1);
    }
    public void selectProductCategory(String text){
        BrowserUtils.waitFor(1);
        titleMenu("Home page").click();
        getCategoryName(text).click();
        BrowserUtils.waitFor(1);

    }
}
