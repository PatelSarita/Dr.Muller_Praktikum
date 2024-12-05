package com.praktikum.stepDefs;

import com.praktikum.pages.CustomerPage;
import com.praktikum.pages.LoginPage;

public abstract class Base_stepDefs {
    LoginPage loginPage = new LoginPage();

    CustomerPage customerPage = new CustomerPage();
}
