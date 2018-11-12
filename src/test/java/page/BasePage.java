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

    /**
     * Method to wait until webElement is clickable
     * @param webElement - webElement which should be checked for ExpectedConditions
     */
    public void waitUntilElementIsClickable(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(webDriver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Method to wait until webpage contains part of specified URL
     * @param incompleteUrl - string which contains part of URL to be checked
     * @return - wait until URL contains string incompleteUrl
     */
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
