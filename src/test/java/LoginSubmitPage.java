import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//span[@id='session_password-login-error'] - password related errors
//div[@id='control_gen_1'] - general error element
//span[@id='session_key-login-error'] - login related errors

public class LoginSubmitPage {
    private WebDriver webDriver;
    private WebElement pageErrorMessage;
    private WebElement loginErrorMessage;
    private WebElement passwordErrorMessage;

    public LoginSubmitPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }

    public boolean ispageErrorMessageDisplayed() {
        return pageErrorMessage.isDisplayed();
    }
    public boolean isloginErrorMessageDisplayed(){
        return loginErrorMessage.isDisplayed();
    }

    public boolean ispasswordErrorMessageDisplayed() {
        return passwordErrorMessage.isDisplayed();
    }

    private void initElements() {
        pageErrorMessage = webDriver.findElement(By.xpath("//div[@id='control_gen_1']"));
        loginErrorMessage = webDriver.findElement(By.xpath("//span[@id='session_key-login-error']"));
        passwordErrorMessage = webDriver.findElement(By.xpath("//span[@id='session_password-login-error']"));
    }

    public boolean isPageLoaded(){
        return webDriver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME") &&
                webDriver.getTitle().equals("Sign In to LinkedIn") && ispageErrorMessageDisplayed();
    }
    public boolean isnoEmailLoginError (){
        return isloginErrorMessageDisplayed() && loginErrorMessage.getText().contains("Please enter a valid email address.");
    }
    public boolean isinocrrectEmailError(){
        return isloginErrorMessageDisplayed() && loginErrorMessage.getText().contains("Hmm, we don't recognize that email. Please try again.");
    }
    public boolean ispasswordWrongError (){
        return ispasswordErrorMessageDisplayed()&& passwordErrorMessage.getText().contains
                ("Hmm, that's not the right password. Please try again or request a new one.");
    }
    public boolean ispasswordShortError (){
        return ispasswordErrorMessageDisplayed()&& passwordErrorMessage.getText().contains
                ("The password you provided must have at least 6 characters.");
    }
}
