package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * LoginSubmitPage PageObject
 */
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

    /**
     * Method to get text from specific webElement
     * @return string with text
     */
    public String getAlertMessageText() {
        return pageErrorMessage.getText();
    }

    /**
     * Standard method to check that page is loaded
     * @return boolean value of check
     */
    public boolean isPageLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME") &&
                webDriver.getTitle().equals("Sign In to LinkedIn");
    }

    /**
     * Method to get text from loginErrorMessage element
     * @return string for corresponding webElement
     */
    public String loginErrorText() {
        return loginErrorMessage.getText();
    }

    /**
     * Method to get text from passwordErrorMessage element
     * @return text from specific element
     */
    public String passwordErrorText() {
        return passwordErrorMessage.getText();
    }

}
