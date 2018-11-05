package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordSubmitPage extends BasePage{

    @FindBy(xpath = "//button[@class='resend__link']")
    private WebElement resendLinkButton;

    public ResetPasswordSubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);

    }
public boolean isresentButtonDisplayed(){
        return resendLinkButton.isDisplayed();
}
public boolean isPageLoaded(){
        return isresentButtonDisplayed() && webDriver.getCurrentUrl().contains("/rp/request-password-reset-submit") &&
                webDriver.getTitle().contains("Please check your mail for reset password link.  | LinkedIn");

}

/*public page.ChooseNewPasswordPage navigateToLinkFromEmail(){
    String messageSubject = "Mykola, here's the link to reset your password";
    String messageTo = "avdieievm@gmail.com";
    String messageFrom = "security-noreply@linkedin.com";

    String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);
StringUtils.

return ChooseNewPasswordPage(webDriver);
}*/

}
