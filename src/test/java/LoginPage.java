import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ParentPage {

    private WebDriver webDriver;
    @FindBy(xpath = "//*[@id='login-email']")
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy(xpath = "//*[@id='login-submit']")
    private WebElement signInButton;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isSignInButtonDisplayed() {
        return signInButton.isDisplayed();
    }


    public ParentPage login(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        if (webDriver.getCurrentUrl().contains("https://www.linkedin.com/")) {
            return this;
        } else if (webDriver.getCurrentUrl().contains("https://www.linkedin.com/feed/")) {
            return new HomePage(webDriver);
        } else {
            return new LoginSubmitPage(webDriver);
        }
    }

        public boolean isPageLoaded() {
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/") &&
                webDriver.getTitle().equals("LinkedIn: Log In or Sign Up") &&
                isSignInButtonDisplayed();

    }
}