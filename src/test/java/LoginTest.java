import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
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
        WebDriver webDriver = new FirefoxDriver();
        webDriver.navigate().to(  "https://www.linkedin.com");
        //Assert.assertEquals("actual", "expected", "error msg");
        Assert.assertEquals(webDriver.getCurrentUrl(),"https://www.linkedin.com/", "wrong Homepage URL");

        webDriver.quit();
    }
}
