package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ChooseNewPasswordPage PageObject class
 *
 */
public class ChooseNewPasswordPage extends BasePage{

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitNewPasswordButton;

    @FindBy(xpath = "//input[@id='newPassword']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPasswordField;

    /**
     * Constructor for ChooseNewPasswordPage PageObject
     * @param webDriver - WebDriver instance from the tests
     */
    public ChooseNewPasswordPage(WebDriver webDriver) {
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method to check if webElement displayed
     * @return submitNewPasswordButton element is displayed
     */
    public boolean isSubmitButtonDisplayed(){
        return submitNewPasswordButton.isDisplayed();
    }

    /**
     * Method to check if page is loaded, using 2 webElements and isSubmitButtonDisplayed method
     * @return result of the check True/False
     */
    public boolean isPageLoaded(){
        return isSubmitButtonDisplayed() && webDriver.getTitle().contains("Reset Your Password | LinkedIn");
    }

    /**
     * Method sends new password in password reset form
     * @param newUserPassword contains alphanumeric user password
     * @return SuccessfulPasswordResetPage page object
     */
    public SuccessfulPasswordResetPage setNewUserPassword(String newUserPassword){
        newPasswordField.sendKeys(newUserPassword);
        confirmPasswordField.sendKeys(newUserPassword);
        submitNewPasswordButton.click();
        return new SuccessfulPasswordResetPage(webDriver);
    }
}
