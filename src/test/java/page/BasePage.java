package page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GMailService;

public abstract class BasePage {

    WebDriver webDriver;

    public abstract boolean isPageLoaded();

    public void waitUntilElementIsClickable(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }


    public boolean waitPageUrlContains(String incompleteUrl) {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        try {
            return wait.until(ExpectedConditions.urlContains(incompleteUrl));
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected static GMailService gMailService = new GMailService();

}
