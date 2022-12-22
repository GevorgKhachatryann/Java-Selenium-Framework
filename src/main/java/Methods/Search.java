package Methods;

import Common.Common;
import Selectors.SearchSelectors;
import org.openqa.selenium.WebDriver;

public class Search extends Common {
    public static final SearchSelectors searchSelectors = new SearchSelectors();

    public Search(WebDriver driver) {
        super(driver);
    }

    public void search(String text) {
        type(searchSelectors.getSearchInput(), text);
        click(searchSelectors.getSearchButton());
    }

    public void isPinDisplayed(String id) {
        displayed(find(searchSelectors.getFoundPin(id)));
    }

    public void isPinnedDisplayed() {
        displayed(find(searchSelectors.getPinned()));
    }

    public void isMenuDisplayed() {
        displayed(find(searchSelectors.getMenuBody()));
    }
}
