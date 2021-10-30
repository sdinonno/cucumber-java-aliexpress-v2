package pages;

import org.apache.commons.lang.NotImplementedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private WebDriver driver;
    private By closeDiscountButton = By.xpath("//img[@class=\"btn-close\"]");
    private By dontAllowButton = By.xpath("//div[contains(text(), \"Don't allow\")]");
    private By searchBox = By.id("search-key");
    private By searchButton = By.className("search-button");
    private By pageResultsButtons = By.xpath("//div[@class = \"next-pagination-list\"]/button");
    private By productResults = By.xpath("//div[@class=\"top-container\"]/following-sibling::div[1]/div");


    public HomePage(WebDriver driver){
        super(driver);
    }

    public void searchProduct(String phrase){
        inputText(searchBox, phrase);
        click(searchButton);
    }

    public void goToResultsPage(int number){
        String numberButton = pageResultsButtons.toString().concat(String.valueOf('[' + number + ']'));
        By pageResult = By.xpath(numberButton);

        click(pageResult);

    }

    public ProductPage openProduct(int position){
        String product = productResults.toString().concat(String.valueOf('[' + position + ']'));
        By producResult = By.xpath(product);
        mainWindow = getWindowHandle();

        click(producResult);
        return new ProductPage(driver);

    }
}
