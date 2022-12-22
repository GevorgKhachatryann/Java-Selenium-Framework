package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class Common extends Assert {
    protected WebDriver driver;

    public Common(WebDriver driver) {
        this.driver = driver;
    }

    public void click(String element) {
        find(element).click();
    }

    public void type(String element, String text) {
        find(element).sendKeys(text);
    }

    public void clear(String element) {
        find(element).clear();
    }

    public String getText(String element) {
        return find(element).getText();
    }

    public List<String> getTexts(String element) {
        return finds(element).stream().map(WebElement::getText).collect(Collectors.toList());
    }

    protected WebElement find(String selector){
        return driver.findElement(identifySelector(selector));
    }

    protected List<WebElement> finds(String selector){
        return driver.findElements(identifySelector(selector));
    }

    private By identifySelector(String selector) {
        return switch (selector.charAt(0)){
            case '#' -> By.id(selector.substring(1));
            case '.' -> By.className(selector.substring(1));
            case '/' -> By.xpath(selector.substring(2));
            case '|' -> By.cssSelector(selector.substring(1));
            default -> By.cssSelector(selector);
        };
    }
}
