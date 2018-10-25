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

    public void  successfulLoginTest () throws InterruptedException {

            webDriver.get("https://linkedin.com");
            LoginPage loginPage = new LoginPage(webDriver);

            Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded");

            ParentPage homePage = loginPage.login("avdieievm@gmail.com", "Blastek17");
            sleep(10000);
            Assert.assertTrue(homePage.isPageLoaded(),"Home page is not loaded");

        }

    @Test
    public void negativeLoginWithEmptyPasswordTest(){
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page URL is wrong.");

        loginPage.login("avdieievm@gmail.com", "");

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page URL is wrong.");
    }
    @Test
    public void negativePasswordTest() throws InterruptedException {
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page URL is wrong.");

        LoginSubmitPage loginSubmitPage = (LoginSubmitPage) loginPage.login("avdieievm@gmail.com", "Blastek18");
        sleep(5000);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(),"target page URL is wrong.");
        Assert.assertTrue(loginSubmitPage.ispasswordWrongError(),"incorrect message displayed");
}
    @Test
    public void negativeShortPasswordTest() throws InterruptedException {
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page URL is wrong.");

        LoginSubmitPage loginSubmitPage = (LoginSubmitPage) loginPage.login("avdieievm@gmail.com", "Bla8");
        sleep(3000);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(),"target page URL is wrong.");
        Assert.assertTrue(loginSubmitPage.ispasswordShortError(),"incorrect message displayed");
        }
    @Test
    public void negativeNoEmailTest() throws InterruptedException {
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page URL is wrong.");
        LoginSubmitPage loginSubmitPage = (LoginSubmitPage) loginPage.login("John Doe", "Blastek17");
        sleep(3000);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(),"target page URL is wrong.");
        Assert.assertTrue(loginSubmitPage.isnoEmailLoginError(),"incorrect error message displayed");
        }
    @Test
    public void negativeIncorrectEmailTest() throws InterruptedException {
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page URL is wrong.");
        LoginSubmitPage loginSubmitPage = (LoginSubmitPage) loginPage.login("avdieievm@gmail.co", "Blastek17");
        sleep(3000);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(),"target page URL is wrong.");
        Assert.assertTrue(loginSubmitPage.isinocrrectEmailError(),"incorrect error message displayed");
    }

    }