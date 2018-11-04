import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class PasswordResetTest {

    /**
     * PreConditions
     * - Open new browser
     * - Navigate to https://linkedin.com
     * <p>
     * Scenario
     * - Verify that Login page is loaded
     * - Click on "Forgot password?" link
     * - Verify that Password reset page is loaded
     * - Enter the valid email address
     * - Click the 'Find Account' button
     * - Wait until email with reset password link is received
     * - Copy-paste link to browser and go to its destination
     * - Enter new password
     * - Login with your new password
     * - Verify that HomePage is loaded
     * <p>
     * PostCondition
     * - Close the browser
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
    public void successfulResetPasswordTest() {
        String newUserPassword = "Abcd12#4%";

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
        RequestPasswordResetPage requestPasswordResetPage = loginPage.clickForgotPassword();
        Assert.assertTrue(requestPasswordResetPage.isPageLoaded(), "Reset Password page is not loaded");
        ChooseNewPasswordPage chooseNewPasswordPage = requestPasswordResetPage.findAccount("avdieievm@gmail.com");

        try {
            sleep(90000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(chooseNewPasswordPage.isPageLoaded(), "Set New Password page is not loaded");

        SuccessfulPasswordResetPage successfulPasswordResetPage = chooseNewPasswordPage.setNewUserPassword(newUserPassword);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(successfulPasswordResetPage.isPageLoaded(),"Incorrect page is loaded");

        HomePage homePage = successfulPasswordResetPage.clickGoToHomeButton();
        Assert.assertTrue(homePage.isPageLoaded(), "HomePage is not loaded");
    }
}
