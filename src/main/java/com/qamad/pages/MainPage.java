package com.qamad.pages;

import org.openqa.selenium.support.PageFactory;

import static com.qamad.core.DriverFactory.getDriver;

public class MainPage {

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean isMainPage() {
        getDriver().getCurrentUrl();
        //stub
        return true;
    }
}
