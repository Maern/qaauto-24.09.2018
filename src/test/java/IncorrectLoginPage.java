import org.openqa.selenium.WebDriver;

public class IncorrectLoginPage {
    private WebDriver webDriver;

    public IncorrectLoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        initElements();
    }
}
