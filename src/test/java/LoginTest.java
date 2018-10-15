import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

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

    public void  successfulLoginTest () throws InterruptedException {
        String logIn = "avdieievm@gmail.com";
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

        webDriver.quit();
    }
}
