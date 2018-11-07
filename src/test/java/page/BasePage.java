package page;

import org.openqa.selenium.WebDriver;
import util.GMailService;

public abstract class BasePage {

    WebDriver webDriver;

    public abstract boolean isPageLoaded();

    protected static GMailService gMailService = new GMailService();

}
