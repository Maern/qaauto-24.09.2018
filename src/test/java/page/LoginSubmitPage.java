package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//span[@id='session_password-login-error'] - password related errors
//div[@id='control_gen_1'] - general error element
//span[@id='session_key-login-error'] - login related errors

public class LoginSubmitPage extends BasePage {
    private WebDriver webDriver;
    @FindBy(xpath = "//div[@role='alert']")
    private WebElement pageErrorMessage;

    @FindBy(xpath = "//span[@id='session_key-login-error']")
    private WebElement loginErrorMessage;

    @FindBy(xpath = "//span[@id='session_password-login-error']")
    private WebElement passwordErrorMessage;

    public LoginSubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getAlertMessageText() {
        return pageErrorMessage.getText();
    }

    public boolean isloginErrorMessageDisplayed() {
        return loginErrorMessage.isDisplayed();
    }


    public boolean ispasswordErrorMessageDisplayed() {
        return passwordErrorMessage.isDisplayed();
    }

    public boolean isPageLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME") &&
                webDriver.getTitle().equals("Sign In to LinkedIn");
    }

    public String loginErrorText() {
        return loginErrorMessage.getText();
    }

    public String passwordErrorText() {
        return passwordErrorMessage.getText();
    }


    @Override
    public boolean isnoEmailLoginError() {
        return checkLogInError("Please enter a valid email address.");
    }

    @Override
    public boolean isinocrrectEmailError() {
        return checkLogInError("Hmm, we don't recognize that email. Please try again.");
    }

    private boolean checkLogInError(String wrongEmail) {
        return isloginErrorMessageDisplayed() && loginErrorMessage.getText().contains(wrongEmail);
    }

    private boolean checkPasswordError(String wrongPassword) {
        return ispasswordErrorMessageDisplayed() && passwordErrorMessage.getText().contains(wrongPassword);
    }

    @Override
    public boolean ispasswordWrongError() {
        return checkPasswordError
                ("Hmm, that's not the right password. Please try again or request a new one.");
    }

    @Override
    public boolean ispasswordShortError() {
        return checkPasswordError
                ("The password you provided must have at least 6 characters.");
    }


}
