package com.qamad.pages;

import com.qamad.core.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected static final Logger log = LogManager.getLogger(BasePage.class.getName());

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }
}
