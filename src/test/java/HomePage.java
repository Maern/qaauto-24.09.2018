import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends ParentLoginPage {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id='profile-nav-item']")
    private WebElement profileNavItem;
    @FindBy(xpath="//a[@data-control-name='nav.settings_signout']")
    private WebElement signOutButton;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isprofileNavItemDisplayed() {
        return profileNavItem.isDisplayed();
    }

    public boolean isPageLoaded() {
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/feed/") &&
                webDriver.getTitle().contains("LinkedIn") &&
                isprofileNavItemDisplayed();

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
