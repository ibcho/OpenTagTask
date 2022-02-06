Feature: Purchase Flow

  Scenario:Purchase 2 blue M size Faded Short Sleeve T-shirts
    Given I launched Chrome browser
    And  I am on "http://automationpractice.com/index.php" site homepage
    And I searched for "Faded Short Sleeve T-Shirt"
    And I select the product
    Given I selected quantity to "2"
    And I selected size "M"
    And I select color "Blue"
    And I selected "Add to car" button
    When I proceed with the happy path of purchase the articles
    Then I should be able to purchase it successfully