package BDDTestCase1.utils;

import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.Set;

public class Helper {


    public static void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickWithLinkText(String linkText){
        Driver.get().findElement(By.linkText(linkText)).click();
    }

    public static void switchLastTab() {
        String originTab = Driver.get().getWindowHandle();
        Set<String> allTabs = Driver.get().getWindowHandles();

        for(String tab : allTabs){
            if(!originTab.equals(tab))
                Driver.get().switchTo().window(tab);
        }


    }

    public static Properties readConfig(){
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();

        File file = new File(s + "\\src\\test\\resources\\config.properties");

        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();

        try {
            prop.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

}
