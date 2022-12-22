package Test;

import Methods.Result;
import Methods.Search;
import Settings.Configs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static Methods.Search.searchSelectors;

public class SearchTest {
    Configs configs = new Configs();
    Search search = new Search(configs.driver);
    Result result = new Result(configs.driver);

    @BeforeEach
    public void setup() {
        configs.open("");
    }

    @ParameterizedTest
    @MethodSource("Data.SearchPage#provideSearchData")
    public void testSearchFunctionality(String data){
        search.search(data);
        result.checkTitlesUntil(data, 5);
    }

    @ParameterizedTest
    @MethodSource("Data.SearchPage#providePinItems")
    public void testPinFunctionality(String item, String id){
        search.click(searchSelectors.getAddPinned());
        search.type(searchSelectors.getPinnedSearchInput(), item);
        search.isPinDisplayed(id);
        search.click(searchSelectors.getPinnedCheckbox());
        search.click(searchSelectors.getPinnedSaveButton());
        search.isPinnedDisplayed();
    }

    @ParameterizedTest
    @MethodSource("Data.SearchPage#provideUrls")
    public void testMenuLinks(int child, String url) {
        search.click(searchSelectors.getMenuIcon());
        search.isMenuDisplayed();
        search.click(searchSelectors.getMenuItem(child));
        configs.nextTab();
        search.contain(configs.getUrl(), url);
        configs.prevTab();
    }

    @AfterEach
    public void tearDown() {
        configs.quit();
    }
}
