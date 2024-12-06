package com.praktikum.stepDefs;

import com.praktikum.pages.*;

public abstract class Base_stepDefs {
    LoginPage loginPage = new LoginPage();
    CustomerPage customerPage = new CustomerPage();
    HomePage homePage= new HomePage();
    ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
    CheckoutPage checkoutPage=new CheckoutPage();
    RegisterPage registerPage = new RegisterPage();
    AddressPage addressPage=new AddressPage();
}
