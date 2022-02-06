package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
    public WebDriver sdriver;

    public SearchResultsPage(WebDriver sResultDriver){
        sdriver = sResultDriver;
        PageFactory.initElements(sResultDriver, this);
    }

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/div[1]/span[1]")
    @CacheLookup
    WebElement searchedArticlePrice;

    @FindBy(xpath = "//a[contains(text(),'Faded Short Sleeve T-shirts')]")
    @CacheLookup
    WebElement selectArticle;

    public void searchedPriceIsDisplayed(){
        searchedArticlePrice.isDisplayed();
    }

    public String getSearchedArticlePrice(){
        return searchedArticlePrice.getText();
    }

    public void selectFadedShortSleeveArticle(){
        selectArticle.click();


    }
}
