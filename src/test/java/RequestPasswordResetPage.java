import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestPasswordResetPage {

    private WebDriver webDriver;

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement resetPasswordButton;

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userNameField;

    public RequestPasswordResetPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isresetPasswordButtonDisplayed() {
        return resetPasswordButton.isDisplayed();
    }

    public boolean isPageLoaded() {
        return webDriver.getCurrentUrl().contains("uas/request-password-reset") &&
                webDriver.getTitle().contains("Reset Password | LinkedIn") &&
                isresetPasswordButtonDisplayed();
    }

    public ChooseNewPasswordPage findAccount(String userName){
        userNameField.sendKeys(userName);
        resetPasswordButton.click();
        return new ChooseNewPasswordPage(webDriver);
    }

}
