package BDDTestCase1.pages;

import BDDTestCase1.utils.Driver;
import BDDTestCase1.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Set;

public class SigninPage {

    public SigninPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "h1")
    public WebElement title;

    public void verifyTitle() {
        Assert.assertEquals("Sign In to Best Buy", title.getText());
    }

    @FindBy(id = "fld-e")
    public WebElement Email;

    @FindBy(id = "fld-p1")
    public WebElement Password;

    @FindBy(css = ".plButton-label.v-ellipsis")
    public WebElement accountHi;

    @FindBy(css = ".c-button.c-button-outline.c-button-lg.c-button-block.c-button-icon.c-button-icon-leading.svg-button.social-button.undefined")
    public WebElement withGoogle;

    @FindBy(id = "identifierId")
    public WebElement g_email;

    @FindBy(xpath = "//*[@id=\"password\"]/div[1]/div/div[1]/input")
    public WebElement g_password;

    public void login() {
        String email = Helper.readConfig().getProperty("email");
        String password = Helper.readConfig().getProperty("password");
        Email.sendKeys(email);
        Password.sendKeys(password, Keys.ENTER);
    }



    public void verificationSigning() {
        Assert.assertTrue(accountHi.getText().contains("Hi,"));
    }

    public void signinwithGoogle(){
        String email_g = Helper.readConfig().getProperty("email");
        String password_g = Helper.readConfig().getProperty("password");
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        withGoogle.click();
        String mainWindow = Driver.get().getWindowHandle();
        Set<String> allWindowsHandles = Driver.get().getWindowHandles();

        for (String ChildWindow : allWindowsHandles) {
            if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
                Driver.get().switchTo().window(ChildWindow);
                g_email.sendKeys(email_g, Keys.ENTER);
                g_password.sendKeys(password_g, Keys.ENTER);
            }
        }
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }
}
