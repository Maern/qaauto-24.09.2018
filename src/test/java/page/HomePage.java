package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * PageObject for HomePage class
 */
public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id='profile-nav-item']")
    private WebElement profileNavItem;
    @FindBy(xpath="//a[@data-control-name='nav.settings_signout']")
    private WebElement signOutButton;

    @FindBy (xpath="//input[@role='combobox']")
    private WebElement searchField;

    /**
     * Constructor for HomePage class
     * @param webDriver - webDriver instance from tests
     */
    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isprofileNavItemDisplayed() {
        return profileNavItem.isDisplayed();
    }

    /**
     * Method to check if page is loaded
     * @return true or false value of the check
     */
    public boolean isPageLoaded() {
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/feed/") &&
                webDriver.getTitle().contains("LinkedIn") &&
                isprofileNavItemDisplayed();

    }

    /**
     * Method to perform a search on LinkedIn HomePge
     * @param searchTerm string with search term to be inserted in searchfield
     * @return SearchPage PageObject
     */
    public SearchPage search(String searchTerm){
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        return new SearchPage(webDriver);

    }

}
