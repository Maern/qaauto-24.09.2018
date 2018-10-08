import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.List;
import static java.lang.Thread.sleep;



public class BadCodeExample {
//main must be one
    //wait instead of sleep to be later
    public static void main(String args[]) throws InterruptedException {
        String searchTerm = "Selenium";
        WebDriver webDriver = new FirefoxDriver();
        webDriver.navigate().to(  "https://www.google.com");
        WebElement searchField = webDriver.findElement(By.xpath("//*[@id='lst-ib']"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.RETURN);
        sleep(15000);

        List<WebElement> searchResults = webDriver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));

        System.out.println("Search results count: "+searchResults.size());

        //WebElement searchText = webDriver.findElement(By.xpath("//*/span[@class='st']")); //declare searchTerm variable which looks to search results
        for(//int i =0;i<searchResults.size();i++)
            WebElement searchResult : searchResults) {
            //String elementText = searchResults.get(i).getText();
            //System.out.println(elementText);
            String searchResultText = searchResult.getText();
            System.out.println(searchResult.getText());
            /*if (searchText.getText().contains("Selenium"))  //check if text block contains "Selenium"
            {
                System.out.println("searchTerm was found");
            }
            else {
                System.out.println("searchTerm wasn't found");
            }*/
            if(searchResultText.toLowerCase().contains(searchTerm.toLowerCase()))
            {
                System.out.println("searchTerm " +searchTerm +" was found");
            }
            else {
                System.out.println("searchTerm" +searchTerm +" wasn't found");
            }
        }
    }
}
