package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

import static java.lang.Thread.sleep;

public class ResetPasswordSubmitPage extends BasePage {

    @FindBy(xpath = "//button[@id='resend-url']")
    private WebElement resendLinkButton;

    public ResetPasswordSubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

    }

    //GMailService gMailService = new GMailService();

    public boolean isresentButtonDisplayed() {
        return resendLinkButton.isDisplayed();
    }

    public boolean isPageLoaded() {
        return isresentButtonDisplayed() && webDriver.getCurrentUrl().contains("/rp/request-password-reset-submit") &&
                webDriver.getTitle().contains("Please check your mail for reset password link");

    }

    private String getEmailUrl(String resetLink) {
        String beginUrlString = "password, click <a href=\"";
        int beginIndex = resetLink.indexOf(beginUrlString);
        if (beginIndex != -1) {
            int endIndex = resetLink.indexOf("\" style=", beginIndex);
            if (endIndex != -1) {
                return resetLink.substring(beginIndex+beginUrlString.length(), endIndex).replaceAll("amp;","");
            }

        }
        return null;
    }

    public page.ChooseNewPasswordPage navigateToLinkFromEmail() {
        String messageSubject = "here's the link to reset your password";
        String messageTo = "avdieievm@gmail.com";
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);
        //String emailResetLink = StringUtils.substringBetween(message, "password, click <a href=\"", "\" style=").replace("amp;","");
        String resetLink = getEmailUrl(message);
        System.out.println(resetLink);
        webDriver.get(resetLink);
        return new ChooseNewPasswordPage(webDriver);
    }

}
