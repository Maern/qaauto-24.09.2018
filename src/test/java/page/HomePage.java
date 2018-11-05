package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id='profile-nav-item']")
    private WebElement profileNavItem;
    @FindBy(xpath="//a[@data-control-name='nav.settings_signout']")
    private WebElement signOutButton;

    @FindBy (xpath="//input[@role='combobox']")
    private WebElement searchField;

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
    public SearchPage search(String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return new SearchPage(webDriver);

    }

}