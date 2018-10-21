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
    public void negativePasswordTest() {
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page URL is wrong.");

        loginPage.login("avdieievm@gmail.com", "Blastek18");
        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(webDriver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(),"target page URL is wrong.");
        Assert.assertTrue(loginSubmitPage.ispasswordWrongError(),"incorrect message displayed");
}
    @Test
    public void negativeShortPasswordTest(){
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page URL is wrong.");

        loginPage.login("avdieievm@gmail.com", "Bla8");
        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(webDriver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(),"target page URL is wrong.");
        Assert.assertTrue(loginSubmitPage.ispasswordShortError(),"incorrect message displayed");
        }
    @Test
    public void negativeNoEmailTest(){
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page URL is wrong.");
        loginPage.login("Joh Doe", "Blastek17");
        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(webDriver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(),"target page URL is wrong.");
        Assert.assertTrue(loginSubmitPage.isnoEmailLoginError(),"incorrect error message displayed");
        }
    @Test
    public void negativeIncorrectEmailTest(){
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page URL is wrong.");
        loginPage.login("avdieievm@gmail.co", "Blastek17");
        LoginSubmitPage loginSubmitPage = new LoginSubmitPage(webDriver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(),"target page URL is wrong.");
        Assert.assertTrue(loginSubmitPage.isinocrrectEmailError(),"incorrect error message displayed");
    }
//TO DO: negative test - short password
    //to do - negative test - no email
    }