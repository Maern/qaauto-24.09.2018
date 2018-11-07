package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.*;

import static java.lang.Thread.sleep;

public class PasswordResetTest extends BaseTest{

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
     * - Verify that page.HomePage is loaded
     * <p>
     * PostCondition
     * - Close the browser
     */

    @Test
    public void successfulResetPasswordTest() {
        String newUserPassword = "Abcd12#4%";

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded");
        RequestPasswordResetPage requestPasswordResetPage = loginPage.clickForgotPassword();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(requestPasswordResetPage.isPageLoaded(), "Reset Password page is not loaded");
        ResetPasswordSubmitPage resetPasswordSubmitPage = requestPasswordResetPage.findAccount("avdieievm@gmail.com");

        try {
            sleep(90000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(resetPasswordSubmitPage.isPageLoaded(), "Password Submit page is not loaded");
        ChooseNewPasswordPage chooseNewPasswordPage = resetPasswordSubmitPage.navigateToLinkFromEmail();
        Assert.assertTrue(chooseNewPasswordPage.isPageLoaded(), "Set New Password page is not loaded");

        SuccessfulPasswordResetPage successfulPasswordResetPage = chooseNewPasswordPage.setNewUserPassword(newUserPassword);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(successfulPasswordResetPage.isPageLoaded(),"Incorrect page is loaded");

        HomePage homePage = successfulPasswordResetPage.clickGoToHomeButton();
        Assert.assertTrue(homePage.isPageLoaded(), "page.HomePage is not loaded");
    }
}
