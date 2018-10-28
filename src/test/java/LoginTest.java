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

    @BeforeMethod
    public void beforeMethod() {
        webDriver = new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod() {
        webDriver.quit();
    }

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "avdieievm@gmail.com", "Blastek17" },
                { "avdieievM@gmail.com","Blastek17" },
                { " avdieievm@gmail.com ", "Blastek17" }
        };


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

    //Todo - err message. err message for pwd, email, pwd in data provider for neg tests
    //todo - dataprovider for case with empty password
    @Test(dataProvider = "validDataProvider")
    public void  successfulLoginTest (String userEmail, String userPassword) throws InterruptedException {

            webDriver.get("https://linkedin.com");
            LoginPage loginPage = new LoginPage(webDriver);

            Assert.assertTrue(loginPage.isPageLoaded(),"Login page is not loaded");

            HomePage homePage = loginPage.login(userEmail, userPassword);
            sleep(10000);
            Assert.assertTrue(homePage.isPageLoaded(),"Home page is not loaded");

        }
    @DataProvider
    public Object[][] emptyPasswordDataProvider() {
        return new Object[][]{
                {"avdieievm@gmail.com", ""},
        };
    }

    @Test(dataProvider = "emptyPasswordDataProvider")
    public void negativeLoginWithEmptyPasswordTest(String userEmail, String userPassword){
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
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
    public void negativePasswordTest(String userEmail, String userPassword,
                                     String userEmailError, String userPasswordError) throws InterruptedException {
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page URL is wrong.");

        LoginSubmitPage loginSubmitPage = loginPage.login(userEmail, userPassword);
        sleep(4000);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(),"target page URL is wrong.");
        Assert.assertEquals(loginSubmitPage.passwordErrorText(),userPasswordError,"incorrect password message displayed");
        Assert.assertEquals(loginSubmitPage.loginErrorText(),userEmailError, "incorrect login message displayed");
}
   /* @Test
    public void negativeShortPasswordTest() throws InterruptedException {
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page URL is wrong.");

        ParentLoginPage loginSubmitPage = loginPage.login("avdieievm@gmail.com", "Bla8");
        sleep(3000);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(),"target page URL is wrong.");
        Assert.assertTrue(loginSubmitPage.ispasswordShortError(),"incorrect message displayed");
        }
    @Test
    public void negativeNoEmailTest() throws InterruptedException {
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page URL is wrong.");
        ParentLoginPage loginSubmitPage =  loginPage.login("John Doe", "Blastek17");
        sleep(3000);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(),"target page URL is wrong.");
        Assert.assertTrue(loginSubmitPage.isnoEmailLoginError(),"incorrect error message displayed");
        }
    @Test
    public void negativeIncorrectEmailTest() throws InterruptedException {
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertTrue(loginPage.isPageLoaded(),"Login page URL is wrong.");
        ParentLoginPage loginSubmitPage = loginPage.login("avdieievm@gmail.co", "Blastek17");
        sleep(3000);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(),"target page URL is wrong.");
        Assert.assertTrue(loginSubmitPage.isinocrrectEmailError(),"incorrect error message displayed");
    }*/

    }