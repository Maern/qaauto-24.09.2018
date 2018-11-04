import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LoginPage{ //extends ParentLoginPage {

    private WebDriver webDriver;
    @FindBy(xpath = "//*[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//*[@id='login-submit']")
    private WebElement signInButton;

    @FindBy(xpath="//a[@class='link-forgot-password']")
    private WebElement forgotPasswordLink;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public RequestPasswordResetPage clickForgotPassword() {
        try {
            sleep (3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        forgotPasswordLink.click();
        return new RequestPasswordResetPage(webDriver);
    }

    public boolean isSignInButtonDisplayed() {
        return signInButton.isDisplayed();
    }

    public <T> T login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(webDriver.getCurrentUrl().contains("/feed/")) {
            return (T) new HomePage(webDriver);
        }
        if (webDriver.getCurrentUrl().contains("/uas/login-submit")) {
        return (T) new LoginSubmitPage(webDriver);
    }
        else {
        return (T) new LoginPage(webDriver);
    }
    }

   /* public ParentLoginPage login (String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        if (webDriver.getCurrentUrl().equals("https://www.linkedin.com/")){
            return new LoginPage(webDriver);
        }
        else if (webDriver.getCurrentUrl().contains("https://www.linkedin.com/feed/")){
            return new HomePage(webDriver);
        }

        else return new LoginSubmitPage(webDriver);
    }*/


    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/") &&
                webDriver.getTitle().equals("LinkedIn: Log In or Sign Up") &&
                isSignInButtonDisplayed();

    }

    public boolean isinocrrectEmailError() {
        return false;
    }

    public boolean ispasswordWrongError() {
        return false;
    }

    public boolean ispasswordShortError() {
        return false;
    }

    public boolean isnoEmailLoginError() {
        return false;
    }
}