package com.qamad.steps;

import com.qamad.pages.LoginPage;
import com.qamad.pages.MainPage;
import com.qamad.pages.NavigationTopPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BaseSteps {

    protected final Logger log = LogManager.getLogger(this.getClass());

    protected LoginPage loginPage = new LoginPage();
    protected NavigationTopPage navigationTopPage = new NavigationTopPage();
    protected MainPage mainPage = new MainPage();

}
