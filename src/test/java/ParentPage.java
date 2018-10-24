import org.openqa.selenium.WebDriver;

public abstract class ParentPage {
    private WebDriver webDriver;
    public String getPageUrl(){
        return webDriver.getCurrentUrl();
    }
    public String getPageTitle(){
        return webDriver.getTitle();
    }
    public abstract boolean isPageLoaded();
}
