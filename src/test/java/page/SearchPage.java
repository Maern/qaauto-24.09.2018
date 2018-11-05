package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchPage {
    private WebDriver webDriver;
    @FindBy(xpath = "//h3 [contains(@class, 'search-results__total')]")
    private WebElement searchResultsTotal;

    @FindBy(xpath = "//li[contains(@class, 'search-result__occluded')]")
    private List <WebElement> searchResults;

    public boolean issearchResultsTotalDisplayed() {
        return searchResultsTotal.isDisplayed();
    }

    public boolean isPageLoaded() {
        return webDriver.getCurrentUrl().contains("https://www.linkedin.com/search/results") &&
                webDriver.getTitle().contains("Search | LinkedIn") &&
                issearchResultsTotalDisplayed();
    }

    public SearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public int getResultNumber() {
        return searchResults.size();
    }

    public List <String> getSearchResults() {
        List <String> responseResultsList = new ArrayList <String>();
        for (WebElement searchResult : searchResults) {
            ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();",searchResult);
            responseResultsList.add(searchResult.getText());
        }
        return responseResultsList;
    }
}
