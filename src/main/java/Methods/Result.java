package Methods;

import Common.Common;
import Selectors.ResultSelectors;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class Result extends Common {
    private final ResultSelectors resultSelectors;

    public Result(WebDriver driver) {
        super(driver);
        resultSelectors = new ResultSelectors();
    }

    public void checkTitlesUntil(String text, int end) {
        List<String> titles = getTexts(resultSelectors.getResults());
        titles.subList(0, end).forEach(title -> {
            contain(title, text);
        });
    }
}
