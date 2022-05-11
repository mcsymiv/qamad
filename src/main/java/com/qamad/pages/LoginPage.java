package com.qamad.pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static com.qamad.config.PropertiesConfig.getProperty;

@Getter
public class LoginPage extends BasePage {

    private String URL = getProperty("baseUrl") + getProperty("loginUrl");

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    // verity of selectors (css, xpath) used only for demonstration purposes

    @FindBy(how = How.CSS, using = "[class=\"form-group\"] > label[for=\"input-email\"] ~ input")
    private WebElement userNameInputField;

    @FindBy(how = How.ID, using = "input-password")
    private WebElement passwordInputField;

    @FindBy(how = How.XPATH, using = "//form[contains(@action, 'login')]//input[@type='submit']")
    private WebElement loginBtn;

    @FindBy(how = How.CLASS_NAME, using = "well")
    private List<WebElement> loginFormBlockElements;

    @FindBy(how = How.CSS, using = "#input-password ~ a[href*='forgotten']")
    private WebElement forgotPasswordLink;

    public LoginPage open() {
        getDriver().get(URL);
        return new LoginPage();
    }

    public void enterUserName(String username) {
        userNameInputField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInputField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginBtn.click();
    }

    public boolean isLoginPage() {
        boolean isFormContent = true;

        for (WebElement formElement : loginFormBlockElements) {
            if (formElement.getText().isEmpty()) {
                isFormContent = false;
                break;
            }
        }

        return isFormContent;
    }

    public List<WebElement> getAllElements() {
        return List.of(
                userNameInputField,
                passwordInputField,
                loginBtn,
                forgotPasswordLink);
    }
}
