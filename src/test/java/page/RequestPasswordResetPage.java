package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class RequestPasswordResetPage extends BasePage{

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement resetPasswordButton;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userNameField;

    public RequestPasswordResetPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    //GMailService gMailService = new GMailService();

    public boolean isresetPasswordButtonDisplayed() {
        return resetPasswordButton.isDisplayed();
    }

    public boolean isPageLoaded() {
        return webDriver.getCurrentUrl().contains("uas/request-password-reset") &&
                webDriver.getTitle().contains("Reset Password | LinkedIn") &&
                isresetPasswordButtonDisplayed();
    }

    public ResetPasswordSubmitPage findAccount(String userName){


        gMailService.connect();

        userNameField.sendKeys(userName);
        resetPasswordButton.click();

        /*String messageSubject = "here's the link to reset your password";
        String messageTo = "avdieievm@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);
        String emailResetLink = StringUtils.substringBetween(message, "password, click <a href=\"", "\" style=").replace("amp;","");
        System.out.println(emailResetLink);
        webDriver.get(emailResetLink);*/


        return new ResetPasswordSubmitPage(webDriver);
    }

}
