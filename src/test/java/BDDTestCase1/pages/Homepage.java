package BDDTestCase1.pages;

import BDDTestCase1.utils.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage {

    public Homepage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "[alt='United States']")
    public WebElement country;

    @FindBy(css = ".c-close-icon.c-modal-close-icon")
    public WebElement closeButton;

    @FindBy(className = "logo")
    public WebElement logo;

    @FindBy(id = "gh-search-input")
    public WebElement searchBox;

    @FindBy(css = "[aria-label='submit search']")
    public WebElement searchIcon;

    @FindBy(css = "a.btn.btn-white.btn-sm")
    public WebElement learnmoreButton;

    @FindBy(css = ".c-button.c-button-secondary.c-button-sm.sign-in-btn")
    public WebElement signButton;

    @FindBy(css = "[data-id=\"node-601\"]")
    public WebElement audio;

    @FindBy(css = "[data-id=\"node-552\"]")
    public WebElement headphones;

    @FindBy(css = "[data-lid=\"ubr_au_hed_wless\"]")
    public WebElement wirelesshead;

    @FindBy(css = "[data-track=\"Brand - Show More\"]")
    public WebElement showmore;

    @FindBy(css = "[id = \"brand_facet-Philips-modal-17\"]")
    public WebElement brandbox;

    @FindBy(css = ".c-button.c-button-secondary.c-button-md.large-facet-group-show-results")
    public WebElement showresult;

    @FindBy(css = ".sale-event-wrapper.grid")
    public WebElement body;

    @FindBy(css = ".c-button-unstyled.hamburger-menu-button")
    public WebElement menu;

    public void chooseUS(){
        country.click();
    }

    public void closePopup(){
        closeButton.click();
    }

    public void verifyLogo(){
        Assert.assertTrue(logo.isDisplayed());
    }

    public void verifyTitle(){
        String title = Driver.get().getTitle();
        Assert.assertEquals("Best Buy | Official Online Store | Shop Now & Save", title);
    }

    public void searchFor(String searchKey) {
        searchBox.click();
        searchBox.sendKeys(searchKey);
        searchIcon.click();
    }

    public void openDropdown(String dropdown) {
        String locator = "//span[text()='" + dropdown + "']";
        Driver.get().findElement(By.xpath(locator)).click();
    }

    public void openSignin() {
        signButton.click();
    }

    public void openMyCreditCardPage() {
        learnmoreButton.click();
    }

    public void maximizeWindow(){
        Driver.get().manage().window().maximize();
    }


    public void waitLoads(){
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(body));}


    public void new_Tab() {
        ((JavascriptExecutor) Driver.get()).executeScript("window.open('https://www.bestbuy.com/')");}


    public void subMenu(){menu.click();}

    public void openAudio() {audio.click();}

    public void openHeadphones(){headphones.click();}

    public void openWireless(){wirelesshead.click();}

    public void selectBrand(){
        ((JavascriptExecutor)Driver.get()).executeScript("scroll(0,400)");
        showmore.click();
        brandbox.click();
        showresult.click();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

}
