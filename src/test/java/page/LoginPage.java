package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;
/**
 * LoginPage PageObject class
 */
public class LoginPage extends page.BasePage {

//    private WebDriver webDriver;
    @FindBy(xpath = "//*[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//*[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath="//a[@class='link-forgot-password']")
    private WebElement forgotPasswordLink;

    /**
     * Constructor for LoginPage
     *
     * @param webDriver - WebDriver instance from tests
     */
    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method to click on forgotPassword link
     *
     * @return RequestPasswordResetPage PageObject
     */
    public RequestPasswordResetPage clickForgotPassword() {
        waitUntilElementIsClickable(forgotPasswordLink);
        forgotPasswordLink.click();
        return new RequestPasswordResetPage(webDriver);
    }

    /**
     * Simple check if web element is displayed, results used in isPageLoaded method below
     *
     * @return boolean value of check
     */
    public boolean isSignInButtonDisplayed() {
        return signInButton.isDisplayed();
    }

    /**
     * Method is used to enter user Email and Password, then click on SignIn button
     * @param userEmail - String with user email
     * @param userPassword - String with user password
     * @param <T> - generic type used to return correct PageObject
     * @return - returns HomePage, LoginSubmitPage or LoginPage PageObject
     */
    public <T> T login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();

        if(waitPageUrlContains("/feed/")) {
            return (T) new HomePage(webDriver);
        }
        if (waitPageUrlContains("/uas/login-submit")) {
        return (T) new LoginSubmitPage(webDriver);
    }
        else {
        return (T) new LoginPage(webDriver);
    }
    }


    /**
     * Method checks if page loaded by using isSignInButtonDisplayed and webElements presense
     *
     * @return boolean value of checks
     */
    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/") &&
                webDriver.getTitle().equals("LinkedIn: Log In or Sign Up") &&
                isSignInButtonDisplayed();

    }

}