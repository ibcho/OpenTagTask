package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver hdriver;

    public HomePage(WebDriver homedriver){
        hdriver = homedriver;
        PageFactory.initElements(homedriver, this);
    }

    @FindBy(id = "search_query_top")
    @CacheLookup
    WebElement searchField;

    @FindBy(css =".button-search" )
    @CacheLookup
    WebElement searchButton;

    public void enterArticleName(String articleName){
        searchField.clear();
        searchField.sendKeys(articleName);
    }

    public void selectSearchButton(){
        searchButton.click();
    }

}
