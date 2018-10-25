import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver webDriver;

    @FindBy(xpath = "//*[@id='profile-nav-item']")
    private WebElement profileNavItem;

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
}
