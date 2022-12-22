package Settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Configs implements BaseData {
    public WebDriver driver;

    public Configs() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void open(String url) {
        driver.get(this.URL + url);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void nextTab() {
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
    }

    public void prevTab() {
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    public void quit() {
        driver.quit();
    }
}
