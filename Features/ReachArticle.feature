Feature: PurchaseTShirtFlow

  Scenario: Verify that product price present on "Faded Short Sleeve T-shirts"
    Given I launched Chrome browser
    And  I am on "http://automationpractice.com/index.php" site homepage
    When I searched for "Faded Short Sleeve T-Shirt"
    And I select the product
    Then correct product price should be displayed


