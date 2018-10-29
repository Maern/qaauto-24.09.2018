import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LoginTest {
    WebDriver webDriver;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                {"avdieievm@gmail.com", "Blastek17"},
                {"avdieievM@gmail.com", "Blastek17"},
                {" avdieievm@gmail.com ", "Blastek17"}
        };


    }

    /**
     * Preconditions:
     * - Open FF browser
     * - Clear cookies
     * <p>
     * Scenario
     * - Navigate to http://linkedin.com
     * - Verify that login page is loaded
     * - Enter username in username field
     * - Enter password ino userPassword field
     * - Click on signIn button
     * - Verify that home page is loaded
     * <p>
     * Postcondition:
     * - Close FF browser
     */

    @Test(dataProvider = "validDataProvider")

    public void successfulLoginTest(String userEmail, String userPassword) throws InterruptedException {

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");

        HomePage homePage = loginPage.login(userEmail, userPassword);
        sleep(10000);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded");

    }

    @DataProvider
    public Object[][] emptyPasswordDataProvider() {
        return new Object[][]{
                {"avdieievm@gmail.com", ""},
        };
    }

    @Test(dataProvider = "emptyPasswordDataProvider")
    public void negativeLoginWithEmptyPasswordTest(String userEmail, String userPassword) {

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page URL is wrong.");

        loginPage.login(userEmail, userPassword);

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page URL is wrong.");
    }

    @DataProvider
    public Object[][] negativeTestsDataProvider() {
        return new Object[][]{
                {"avdieievm@gmail.com", "Blastek18", "", "Hmm, that's not the right password. Please try again or request a new one."},
                {"avdieievm@gmail.com", "Bte18", "", "The password you provided must have at least 6 characters."},
                {"avdieievm@gmail.co", "Blastek17", "Hmm, we don't recognize that email. Please try again.", ""},
                {"John Doe", "Blastek17", "Please enter a valid email address.", ""},
        };
    }

    @Test(dataProvider = "negativeTestsDataProvider")
    public void validationMessagesOnInvalidEmailPasswordTest(String userEmail, String userPassword,
                                     String emailValidationMessage, String passwordValidationMessage) throws InterruptedException {
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page URL is wrong.");

        LoginSubmitPage loginSubmitPage = loginPage.login(userEmail, userPassword);
        sleep(8000);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "target page URL is wrong.");
        Assert.assertEquals(loginSubmitPage.getAlertMessageText(),"There were one or more errors in your submission. Please correct the marked fields below.", "Alert message text is wrong");
        Assert.assertEquals(loginSubmitPage.passwordErrorText(), passwordValidationMessage, "incorrect password message displayed");
        Assert.assertEquals(loginSubmitPage.loginErrorText(), emailValidationMessage, "incorrect login message displayed");
    }

}