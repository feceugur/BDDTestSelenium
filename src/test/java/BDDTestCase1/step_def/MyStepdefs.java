package BDDTestCase1.step_def;

import BDDTestCase1.pages.Homepage;
import BDDTestCase1.pages.ProductPage;
import BDDTestCase1.pages.SearchResultPage;
import BDDTestCase1.pages.SigninPage;
import BDDTestCase1.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {

    Homepage homepage = new Homepage();
    SearchResultPage searchResultPage = new SearchResultPage();
    SigninPage signinPage = new SigninPage();
    ProductPage productPage = new ProductPage();

    @Given("homepage is open")
    public void homepageIsOpen() {
        homepage.chooseUS();
    }

    @When("I close the pop up")
    public void iCloseThePopUp() { homepage.closePopup(); }

    @Then("logo should be displayed")
    public void logoShouldBeDisplayed() {
        homepage.verifyLogo();
    }

    @When("I search for {string}")
    public void iSearchFor(String searchKey) {
        homepage.searchFor(searchKey);
    }

    @Then("search result should be for {string}")
    public void searchResultShouldBeSeen(String searchKey) {
        searchResultPage.verifySearchResult(searchKey); }

    @And("verification of page title")
    public void verificationPagetitle(){
        homepage.verifyTitle();
    }

    @And("maximize window")
    public void maximizeWindow(){
        homepage.maximizeWindow();
    }

    @And("I open {string} dropdown menu")
    public void iOpenDropdownMenu(String dropdown) {
        homepage.openDropdown(dropdown);}

    @When("I choose Sing In page")
    public void iChoosePage() {
        homepage.openSignin();
    }

    @Then("sign in page should open")
    public void signInPageShouldOpen() {
        signinPage.verifyTitle();
    }

    @And("login with email and password")
    public void loginWith(){
        signinPage.login();}

    @And("I open my best buy credit card page")
    public void iOpenMyBestBuyCreditCardPage() {
        homepage.openMyCreditCardPage();
    }

    @Then("verification of singing")
    public void verificationofSigning(){
        signinPage.verificationSigning();
    }

    @And("sign in with Google with email and password")
    public void singinWithGoogle() {
        signinPage.signinwithGoogle();}

    @And("open new tab")
    public void openNewTab(){
        Driver.get().manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        homepage.new_Tab();}

    @And("I open Menu")
    public void openMenu(){homepage.subMenu();}

    @And("I open Audio submenu")
    public void openAudio(){homepage.openAudio();}

    @And("I open Headphones submenu")
    public void openHeadphones(){homepage.openHeadphones();}

    @And("I open Wireless Headphones submenu")
    public void openWireless(){homepage.openWireless();}

    @And("Select Brand")
    public void selectBrand(){
        homepage.selectBrand();
    }


    @And("Select second product")
    public void selectProd(){
        productPage.select();}

    @And("wait until page loads")
    public void waitLoad(){
        homepage.waitLoads();}

    @Then("Save product")
    public void saveProduct() {productPage.saveforLater();}


    @And("verification of {string} page")
    public void verificationOfPage(String item) {
        productPage.verifySavedItem(item);
    }

}
