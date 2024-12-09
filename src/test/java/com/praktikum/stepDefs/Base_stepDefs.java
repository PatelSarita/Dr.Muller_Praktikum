package com.praktikum.stepDefs;

import com.praktikum.pages.*;
import com.praktikum.pages.LoginPage;

public abstract class Base_stepDefs {
    LoginPage loginPage = new LoginPage();
    CustomerPage customerPage = new CustomerPage();
    HomePage homePage= new HomePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckoutPage checkoutPage=new CheckoutPage();
    RegisterPage registerPage = new RegisterPage();
}
