import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LoginTest {
    WebDriver webDriver;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }

    /**
     *Preconditions:
     * - Open FF browser
     * - Clear cookies
     *
     * Scenario
     * - Navigate to http://linkedin.com
     * - Verify that login page is loaded
     * - Enter username in username field
     * - Enter password ino userPassword field
     * - Click on signIn button
     * - Verify that home page is loaded
     *
     * Postcondition:
     * - Close FF browser
     */
    @Test

    public void  successfulLoginTest () {

            webDriver.get("https://linkedin.com");
            LoginPage loginPage = new LoginPage(webDriver);

            Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded");

            loginPage.login("avdieievm@gmail.com", "Blastek17");

            HomePage homePage = new HomePage(webDriver);
            Assert.assertTrue(homePage.ishomePageLoaded(),"Home page is not loaded");

        }
    @Test
    public void negativeLoginWithEmptyPasswordTest(){
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");

        loginPage.login("avdieiev@gmail.com", "");

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");
    }
    @Test
    public void negativePasswordTest() {
    webDriver.get("https://linkedin.com");
    LoginPage loginPage = new LoginPage(webDriver);
    Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",
            "Login page URL is wrong.");

    loginPage.login("avdieievm@gmail.com", "Blastek18");

    Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME",
            "target page URL is wrong.");
}
//TO DO: negative test - short password
    }