import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class SearchTest {
    /**
     * PreConditions:
     * - Open new Browser.
     * - Navigate to http://linkedin.com
     * <p>
     * Scenario:
     * - Verify that Login page is loaded
     * - Log in with valid credentials
     * - Verify that Home page is loaded
     * - Enter 'searchTerm' into Search field and press Return key
     * - Verify that Search page is loaded
     * - Verify 10 searchResults displayed on page
     * - Verify each result item contains searchTerm
     * <p>
     * PostConditions:
     * - Close FF browser
     */
    WebDriver webDriver;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://linkedin.com");
        loginPage = new LoginPage(webDriver);
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }


    @Test
    public void basicSearchTest() {
        String searchTerm = "HR";

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");

        HomePage homePage = loginPage.login("avdieievm@gmail.com", "Blastek17");

        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SearchPage searchPage = homePage.search(searchTerm);

        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(searchPage.isPageLoaded(), "Search page is not loaded");
        Assert.assertEquals(searchPage.getResultNumber(), 10, "Incorrect number of search results");

        List <String> searchResultsList = searchPage.getSearchResults();
        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()), "SearchTerm"+searchTerm+"not found in"+searchResult);
        }
    }
}
