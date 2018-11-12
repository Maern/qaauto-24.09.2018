package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessfulPasswordResetPage extends BasePage{

    @FindBy(xpath = "//button[text()='Go to homepage']")
    private WebElement goToHomeButton;

    public SuccessfulPasswordResetPage(WebDriver webDriver) {
        this.webDriver=webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public boolean isGoToHomeDisplayed(){
        return goToHomeButton.isDisplayed();
    }
    public boolean isPageLoaded(){
        return webDriver.getTitle().contains("You've successfully reset your password. | LinkedIn") && isGoToHomeDisplayed();
    }

    /**
     * Method to click goToHomeButton after changing password
     * @return HomePage PageObject
     */
    public HomePage clickGoToHomeButton(){
        goToHomeButton.click();
        return new HomePage(webDriver);
    }
}
