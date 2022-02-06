package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseFlow {

    public WebDriver fdriver;
    String totalAmount;

    public PurchaseFlow(WebDriver flowDriver){
        fdriver = flowDriver;
        PageFactory.initElements(flowDriver, this);
    }


    @FindBy (css = "#total_price")
    @CacheLookup
    WebElement cartTotalAmount;

    @FindBy (css = ".standard-checkout")
    @CacheLookup
    WebElement standardCheckout;

    @FindBy(xpath = "//input[@id='email']")
    @CacheLookup
    WebElement userEmail;

    @FindBy (xpath = "//input[@id='passwd']")
    @CacheLookup
    WebElement userPassword;

    @FindBy (css = "#SubmitLogin")
    @CacheLookup
    WebElement submitLogin;

    @FindBy (css = "[name='processAddress']")
    @CacheLookup
    WebElement proceedToCheckoutAddress;

    @FindBy (xpath = "//input[@id='cgv']")
    @CacheLookup
    WebElement agreeTerms;

    @FindBy (xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]/span[1]")
    @CacheLookup
    WebElement proceedToCheckOutShipping;

    @FindBy (css = "[title='Pay by bank wire']")
    @CacheLookup
    WebElement payByBankWire;

    @FindBy (xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]")
    @CacheLookup
    WebElement confirmOrderButton;

    @FindBy (xpath = "//h1[contains(text(),'Order confirmation')]")
    @CacheLookup
    WebElement orderConfirmation;

    @FindBy (css = ".price strong")
    @CacheLookup
    WebElement orderTotalAmount;


    public void selectStandardCheckout(){
        standardCheckout.click();
    }

    public void loginDuringPurchase(){
        userEmail.clear();
        userEmail.sendKeys("vase5555@gmail.com");
        userPassword.clear();
        userPassword.sendKeys("Test@123");
        submitLogin.click();
    }

    public void selectProceedToCheckoutAddress(){
        proceedToCheckoutAddress.click();
    }

    public void checkAgreeTerms(){
        agreeTerms.click();
    }

    public void selectProceedToCheckOutShipping(){
        proceedToCheckOutShipping.click();
    }

    public void selectPayByBankWire(){
        payByBankWire.click();
    }

    public void selectIConfirmMyOrder(){
        confirmOrderButton.click();
    }

    public void assertOrderConfirmation(){
        Assert.assertEquals("ORDER CONFIRMATION", orderConfirmation.getText());
    }

    public String getOrderTotalPrice(){
        return orderTotalAmount.getText();
    }
}
