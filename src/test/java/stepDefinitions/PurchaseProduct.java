package stepDefinitions;
import PageObjects.ArticlePage;
import PageObjects.HomePage;
import PageObjects.PurchaseFlow;
import PageObjects.SearchResultsPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseProduct {

    private WebDriver driver;
    private HomePage hpDriver;
    private SearchResultsPage sDriver;
    private ArticlePage aDriver;
    private PurchaseFlow fDriver;


    // ** Check Faded Short Sleeve T-shirts price product price: **

    @Given("I launched Chrome browser")
    public void iLaunchedChromeBrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ibrah\\Desktop\\ChromeDriver\\chromedriver1.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        hpDriver = new HomePage(driver);
        sDriver = new SearchResultsPage(driver);
        aDriver = new ArticlePage(driver);
        fDriver = new PurchaseFlow(driver);
    }

    @And("I am on {string} site homepage")
    public void i_am_on_homepage(String automationpractice) {
        driver.get(automationpractice);
    }

    @When("I searched for {string}")
    public void i_searched_for_fadedShortSleeveTshirt(String fadedShortSleeveTshirt) {
        // Enter article name in search field
        hpDriver.enterArticleName(fadedShortSleeveTshirt);
        // Select searchButton
        hpDriver.selectSearchButton();
        // check if the price is displayed
        sDriver.searchedPriceIsDisplayed();
    }

    @And("I select the product")
    public void i_select_the_product() {
        // Select article
        sDriver.selectFadedShortSleeveArticle();
        // Validate the description info from article page
        aDriver.verifyArticleInfo();
    }

    @Then("correct product price should be displayed")
    public void correct_product_price_should_be_displayed() {
        // Verify that price is displayed
        aDriver.priceIsDisplayed();
        // Verify that price equals to 16.51
        aDriver.verifyArticlePrice();
    }


    // *** Buy 2 blue M size Faded Short Sleeve T-shirts and assert order is successful: ***


    @Given("I selected quantity to {string}")
    public void i_selected_quantity(String two) {
        aDriver.changeQuantity(two);
    }

    @And("I selected size {string}")
    public void i_selected_size(String M) {
        aDriver.selectTShirtSize(M);
    }

    @And("I select color {string}")
    public void i_select_color(String colorOption) {
        aDriver.selectBlueColor(colorOption);
    }

    @And("I selected {string} button")
    public void i_selected_button(String AddToCart) {
        aDriver.selectAddToCartButton(AddToCart);
    }

    @When("I proceed with the happy path of purchase the articles")
    public void i_proceed_with_the_happy_path_of_purchase_the_articles() {
        aDriver.selectProceedToCheckOutModal();
        //Starting the flow
        fDriver.selectStandardCheckout();
        // login during purchase
        fDriver.loginDuringPurchase();
        //Select proceed to checkout on Address
        fDriver.selectProceedToCheckoutAddress();
        // Agree the terms and conditions
        fDriver.checkAgreeTerms();
        // Select proceed to checkout on Shipping
        fDriver.selectProceedToCheckOutShipping();
        // Select pay by bank wire
        fDriver.selectPayByBankWire();
        // Select I confirm my order
        fDriver.selectIConfirmMyOrder();
        // Get total order price
        fDriver.getOrderTotalPrice();
    }

    @Then("I should be able to purchase it successfully")
    public void i_should_be_able_to_purchase_it_successfully() {
        // Validate that order is completed
        fDriver.assertOrderConfirmation();
        // Assert if total price of the order is same as total price in cart
        Assert.assertEquals("$35.02", fDriver.getOrderTotalPrice());


    }
}