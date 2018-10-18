import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    public void  successfulLoginTest () {//throws InterruptedException {
        /*String logIn = "avdieievm@gmail.com";
        String password = "Blastek17";
        WebDriver webDriver = new FirefoxDriver();
        webDriver.navigate().to(  "https://www.linkedin.com");
        //Assert.assertEquals("actual", "expected", "error msg");
        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.linkedin.com/", "wrong Homepage URL");
        WebElement loginField = webDriver.findElement(By.id("login-email"));
        WebElement passwordField = webDriver.findElement(By.id("login-password"));
        loginField.sendKeys(logIn);
        passwordField.sendKeys(password);
        passwordField.sendKeys(Keys.RETURN);
        sleep (10000);
        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.linkedin.com/feed/","Incorrect page is loaded");

        webDriver.quit();*/


            webDriver.get("https://linkedin.com");
            LoginPage loginPage = new LoginPage(webDriver);

            Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",
                    "Login page URL is wrong.");

            loginPage.login("avdieievm@gmail.com", "Blastek17");

            Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/feed/",
                    "Home page URL is wrong.");
        }
    @Test
    public void negativeLoginTest(){
        webDriver.get("https://linkedin.com");
        LoginPage loginPage = new LoginPage(webDriver);
        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");

        loginPage.login("avdieiev@gmail.com", "123");;

        Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",
                "Login page URL is wrong.");
    }
    @Test
    public void negativePasswordTest() {
    webDriver.get("https://linkedin.com");
    LoginPage loginPage = new LoginPage(webDriver);
    Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/",
            "Login page URL is wrong.");

    loginPage.login("avdieievm@gmail.com", "Blastek18");;

    Assert.assertEquals(webDriver.getCurrentUrl(), "https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME",
            "target page URL is wrong.");
}

    }