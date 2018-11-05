package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseNewPasswordPage extends BasePage{

    @FindBy(xpath = "//button[@id='reset-password-submit-button']")
    private WebElement submitNewPasswordButton;

    @FindBy(xpath = "//input[@id='newPassword']")
    private WebElement newPasswordField;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPasswordField;


    public ChooseNewPasswordPage(WebDriver webDriver) {
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public boolean isSubmitButtonDisplayed(){
        return submitNewPasswordButton.isDisplayed();
    }

    public boolean isPageLoaded(){
        return isSubmitButtonDisplayed() && webDriver.getTitle().contains("Reset Your Password | LinkedIn");
    }
    public SuccessfulPasswordResetPage setNewUserPassword(String newUserPassword){
        newPasswordField.sendKeys(newUserPassword);
        confirmPasswordField.sendKeys(newUserPassword);
        submitNewPasswordButton.click();
        return new SuccessfulPasswordResetPage(webDriver);
    }
}
