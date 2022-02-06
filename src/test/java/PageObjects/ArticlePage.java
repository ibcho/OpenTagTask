package PageObjects;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.util.List;

public class ArticlePage {
    public WebDriver adriver;

    public ArticlePage(WebDriver articlePageDriver){
        adriver = articlePageDriver;
        PageFactory.initElements(articlePageDriver, this);
    }

    @FindBy(css = "#short_description_block")
    @CacheLookup
    WebElement articleInfo;

    @FindBy(xpath = "//span[@id='our_price_display']")
    @CacheLookup
    WebElement articlePrice;

    @FindBy(xpath = "//input[@id='quantity_wanted']")
    @CacheLookup
    WebElement quantityField;

    @FindBy(xpath = "//ul[@id='color_to_pick_list']")
    @CacheLookup
    WebElement colorList;

    @FindBy(xpath = "//a[@id='color_14']")
    @CacheLookup
    WebElement blueColor;

    @FindBy(xpath = "//select[@id='group_1']" )
    @CacheLookup
    WebElement articleSize;

    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    @CacheLookup
    WebElement addToCartButton;

    @FindBy(xpath = "//span[@id='total_price']")
    @CacheLookup
    WebElement cartTotalPrice;

    @FindBy (css = ".button-medium[title='Proceed to checkout']")
    @CacheLookup
    WebElement proceedToCheckoutButtonModal;



    public void verifyArticleInfo() {
        Assert.assertEquals("Faded short sleeve t-shirt with high neckline. " +
                "Soft and stretchy material for a comfortable fit. " +
                "Accessorize with a straw hat and you're ready for summer!", articleInfo.getText());
    }

    public void priceIsDisplayed(){
        articlePrice.isDisplayed();
    }


    public void verifyArticlePrice(){
        String artPrice = articlePrice.getText();
        Assert.assertEquals("$16.51", artPrice);
    }

    public void changeQuantity(String quantity){
        quantityField.clear();
        quantityField.sendKeys(quantity);
    }

    public void selectTShirtSize(String size){
        Select sizeNumber = new Select(articleSize);
        sizeNumber.selectByVisibleText(size);
    }

    public void selectBlueColor(String color){
//        List<WebElement>
//                for(WebElement c : colorList){
//                    if(c.getAttribute("title").equals(color)){
//                    }
//                }
        blueColor.click();
    }

    public void selectAddToCartButton(String addToCart){
        addToCartButton.click();
    }

    public void selectProceedToCheckOutModal(){
        proceedToCheckoutButtonModal.click();

    }

    public String getCartTotalPrice(){
        return cartTotalPrice.getText();
    }


}
