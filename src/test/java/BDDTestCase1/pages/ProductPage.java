package BDDTestCase1.pages;

import BDDTestCase1.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProductPage {
    public ProductPage(){
        PageFactory.initElements(Driver.get(),this);}

    @FindBy(xpath = "//*[@id=\"main-results\"]/ol/li[3]/div/div/div[1]/div/div/div")
    public WebElement item;

    @FindBy(xpath = "//*[@id=\"shop-save-for-later-678c288c-e52e-4f12-b668-5dcaefa65bcb\"]/div/div/div/button")
    public WebElement save;

    @FindBy(css = "[data-track = \"navlist_saved_items_see all your saved items\"]")
    public WebElement savedItem;

    public void selectProd(String p){
        String locator = "//*[@id=\"main-results\"]/ol/li[\""+(p+1)+"\"]/div/div/div[1]/div/div/div";
        Driver.get().findElement(By.xpath(locator)).click();
    }

    public void select(){
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ((JavascriptExecutor)Driver.get()).executeScript("scroll(0,300)");
        item.click();
    }

    public void saveforLater(){
        ((JavascriptExecutor) Driver.get()).executeScript("scroll(0,400)");
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        save.click();
        ((JavascriptExecutor)Driver.get()).executeScript("scroll(0,-400)");
    }

    public void verifySavedItem(String Item) {
        Assert.assertTrue(savedItem.getText().contains(Item));
    }
}
