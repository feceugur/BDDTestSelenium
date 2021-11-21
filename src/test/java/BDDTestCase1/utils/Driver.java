package BDDTestCase1.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class Driver {

    private Driver() {
    }

    private static WebDriver driver;

    public static WebDriver get() {
        String browser  = Helper.readConfig().getProperty("Browser");


        if (driver == null) {
            if(Objects.equals(browser, "Chrome")){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            else if(Objects.equals(browser, "Firefox")){

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            }
            else if(Objects.equals(browser, "Edge")){
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
