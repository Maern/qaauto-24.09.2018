package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    /**
     * Standard method to check that page is loaded
     * @return boolean value of check
     */
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

}
