package com.qamad.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.qamad.core.DriverFactory.getDriver;

@Getter
public class AccountPage {

    public AccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(css = "[class='list-unstyled'] [class*='text-center'] a[href*='account']")
    private List<WebElement> accountLinks;

}
