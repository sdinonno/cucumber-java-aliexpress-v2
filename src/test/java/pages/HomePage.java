package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {

    private WebDriver driver;
    private By closeDiscountButton = By.xpath("//img[@class=\"btn-close\"]");
    private By dontAllowButton = By.xpath("//div[contains(text(), \"Don't allow\")]");
    private By searchBox = By.id("search-key");
    private By searchButton = By.className("search-button");

    private String productResultsBaseXpath = "//div[@class=\"top-container\"]/following-sibling::div[1]/a";
    private String pageResultsButtonsXpath = "//div[@class = \"next-pagination-list\"]/button";


    public HomePage(WebDriver driver){
        super(driver);
    }

    public void searchProduct(String phrase){
        inputText(searchBox, phrase);
        click(searchButton);
    }

    public void goToResultsPage(int number){
        String numberButton = pageResultsButtonsXpath.concat(('[' + String.valueOf(number) + ']'));
        By pageResult = By.xpath(numberButton);

        executeScript("window.scrollTo(0,4115)");
        click(pageResult);

    }

    public ProductPage openProduct(int position){
        String product = productResultsBaseXpath.concat("[" + String.valueOf(position) + "]/div[1]/img");
        By producResult = By.xpath(product);
        mainWindow = getWindowHandle();

        click(producResult);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        return new ProductPage(driver);

    }

    public void clickDontAllowNotifications(){
        click(dontAllowButton);
    }

    public void clickCloseDiscount(){
        click(closeDiscountButton);
    }
}
