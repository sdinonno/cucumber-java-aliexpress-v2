#language: en
  Feature: Search product

    @Search
    Scenario: Search second ad on the second page
      Given the Aliexpress website is displayed
      When the client searches for "Iphone"
      And the client clicks the second product on the second page
      Then the client see the product with at least "1" item



