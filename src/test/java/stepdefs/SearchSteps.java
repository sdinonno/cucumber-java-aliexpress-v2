package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
    
    @Given("the Aliexpress website is displayed")
    public void theAliexpressWebsiteIsDisplayed() {
    }

    @When("the client searches for {string}")
    public void theClientSearchesFor(String word) {
    }

    @And("the client clicks the second product on the second page")
    public void theClientClicksTheSecondProductOnTheSecondPage() {

    }

    @Then("the client see the product with at least {string} item")
    public void theClientSeeTheProductWithAtLeastItem(int items) {
    }
}
