package com.qamad.pages;

import com.qamad.config.PropertiesConfig;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class NavigationTopPage extends BasePage {

    public NavigationTopPage() {
        PageFactory.initElements(getDriver(), this);
    }

    //findBy rule differs only for demonstration purposes

    @FindBy(css = "form[action*='language'] button")
    private List<WebElement> languageFormElements;

    @FindBy(css = "#account-login [class*='alert']")
    private WebElement errorMessageLogin;

    public LoginPage switchLanguageTo(String languageNameCode) {
        for (WebElement element : languageFormElements) {
            if (element.getAttribute("name").contains(languageNameCode)
                    && element.getCssValue("color").equalsIgnoreCase(PropertiesConfig.getProperty("brandRgbaColor"))) {
                element.click();
                break;
            }
        }

        return new LoginPage();
    }

}
