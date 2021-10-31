package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BasePage {

    public static WebDriver driver;
    protected String mainWindow;
    private String baseURL = "https://aliexpress.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu","--ignore-certificate-errors");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        navigate(baseURL);

    }

    public void tearDown(){
        driver.close();
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    protected void navigate(String url){
        driver.navigate().to(url);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    protected WebElement findElement(By locator){
        try {
            return driver.findElement(locator);
        }
        catch (NoSuchElementException e){
            System.out.println("Element not found: " + locator);
            throw new NoSuchElementException(e.getMessage());
        }
    }

    protected List<WebElement> findElements(By locator){
        try {
            return driver.findElements(locator);
        }
        catch (NoSuchElementException e){
            System.out.println("Elements not found: " + locator);
            throw new NoSuchElementException(e.getMessage());
        }
    }

    protected void click(By locator){

        WebElement element = findElement(locator);

        try{
            if(element.isDisplayed())
                element.click();

        }
        catch (Exception e) {
            System.out.println("Error trying to click element.");
            throw new NoSuchElementException(e.getMessage());
        }
    }

    protected void inputText(By locator, String text){
        try {
            findElement(locator).sendKeys(text);
        }
        catch (Exception e) {
            System.out.println("Error trying to enter text.");
            throw new NoSuchElementException(e.getMessage());
        }
    }

    protected void switchTo(String window){
        driver.switchTo().window(window);
    }

    protected String getWindowHandle(){
        return driver.getWindowHandle();
    }

    protected Set<String> getWindowHandles(){
        return driver.getWindowHandles();
    }

    public boolean elementIsVisible(By locator){
        try {
            findElement(locator).isDisplayed();
            return true;
        }
        catch (Exception e){
            System.out.println("Error trying to find element.");
            throw new NoSuchElementException(e.getMessage());
        }

    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void executeScript(String script){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script);
    }


}
