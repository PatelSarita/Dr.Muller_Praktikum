package com.praktikum.pages;

import com.praktikum.utilities.BrowserUtils;
import com.praktikum.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;


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
    @FindBy(css = "[class='widget-title text-light']")
    public List<WebElement> footerTitleList;
    @FindBy(css = "[class='widget-list-link']")
    public List<WebElement> footerLinkList;
    @FindBy(xpath = "//h1[@class='h3 text-light mb-0']")
    public WebElement pageName;
    @FindBy(xpath = "//input[@id='newsletter-email']")
    public WebElement followUsEmailInput;
    @FindBy(xpath = "//input[@id='newsletter-subscribe-button']")
    public WebElement subscribeBtn;

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
///////////////////////Footer Functionality/////////////////////////////////////////////

    public void footerTitleMenu(List<String> footerList){
        for (int i = 0; i < footerTitleList.size(); i++) {
            assertEquals(footerTitleList.get(i).getText(), footerList.get(i));
        }
    }

    public List<String> clickFooterLinkAndGetTitles(){
        List<String> pageTitles = new ArrayList<>();

        for (int i = 0; i < footerLinkList.size(); i++) {
            footerLinkList.get(i).click();
            pageTitles.add(pageName.getText());
        }
        return pageTitles;
    }

    public void verifyClickFooterLink(List<String> expectedPageNameList){
        List<String> actualPageNameList = clickFooterLinkAndGetTitles();
        Assert.assertEquals(expectedPageNameList,actualPageNameList);
    }

    public void signUpFollowUsField(String email){
        followUsEmailInput.sendKeys(email);
        subscribeBtn.click();
    }

    public WebElement verifySignUpMessage(String msg){
        WebElement message = Driver.get().findElement(By.xpath("//*[text()='"+msg+"']"));
        return message;
    }
}
