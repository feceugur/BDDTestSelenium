package BDDTestCase1.pages;

import BDDTestCase1.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

public class SearchResultPage {
    public SearchResultPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = ".search-title")
    public WebElement resultTitle;

    //String search;
    public void verifySearchResult(String searchKey) {
        searchKey = searchKey.toLowerCase(Locale.ROOT);
        Assert.assertTrue(resultTitle.getText().contains(searchKey));
    }
}
