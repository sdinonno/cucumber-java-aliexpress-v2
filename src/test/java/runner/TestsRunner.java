package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@CucumberOptions(features = "src/test/resources/Search.feature", glue = "stepdefs")
@Test
public class TestsRunner extends AbstractTestNGCucumberTests {

    private WebDriver driver;
    private String baseURL = "https://aliexpress.com/";

    @Before
    protected void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu","--ignore-certificate-errors");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

    }

    @After
    protected void tearDown(){
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
