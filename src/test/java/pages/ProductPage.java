package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class ProductPage extends BasePage{

    private WebDriver driver;
    public By quantityItems = By.xpath("//div[@class=\"product-quantity-title\"]/following::span//input");

    public ProductPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    public String getQuantityItems(){
        String quantity = null;
        Set<String> allWindowHandles  = getWindowHandles();

        for (String windowHandle : allWindowHandles){
            if(!mainWindow.equals(windowHandle)){
                switchTo(windowHandle);
                quantity = findElement(quantityItems).getAttribute("value");
                break;
            }
        }
        return quantity;
    }


}
