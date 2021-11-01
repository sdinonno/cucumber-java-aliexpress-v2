package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.BasePage;
import pages.HomePage;
import pages.ProductPage;

public class SearchSteps {

    HomePage homePage = new HomePage(BasePage.getDriver());
    ProductPage productPage;

    @Before
    public void setUp(){
        homePage.setUp();
    }
    
    @Given("the Aliexpress website is displayed")
    public void theAliexpressWebsiteIsDisplayed() {
        homePage.clickCloseDiscount();
        homePage.clickDontAllowNotifications();
        Assert.assertEquals(homePage.getTitle(), "AliExpress - Online Shopping for Popular Electronics, Fashion, Home & Garden, Toys & Sports, Automobiles and More products - AliExpress");
    }

    @When("the client searches for {string}")
    public void theClientSearchesFor(String word) {
        homePage.searchProduct(word);
    }

    @And("the client clicks the second product on the second page")
    public void theClientClicksTheSecondProductOnTheSecondPage() {
        homePage.goToResultsPage(2);
        productPage = homePage.openProduct(2);
    }

    @Then("the client see the product with at least {string} item")
    public void theClientSeeTheProductWithAtLeastItem(String items) {
        //Assert.assertTrue(productPage.elementIsVisible(productPage.quantityItems));
        String items1 = productPage.getQuantityItems();
        Assert.assertTrue(Integer.parseInt(items1) >= Integer.parseInt(items));
    }

    @After
    public void tearDown(){
        homePage.tearDown();
    }
}
