package Data;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static Methods.Search.searchSelectors;

public class SearchPage {
    public static Stream<Arguments> provideUrls() {
        return Stream.of(
                Arguments.of(2, searchSelectors.getMailUrl()),
                Arguments.of(4, searchSelectors.getChatUrl()),
                Arguments.of(6, searchSelectors.getCollectionsUrl()),
                Arguments.of(8, searchSelectors.getMarketUrl()),
                Arguments.of(10, searchSelectors.getDiskUrl()),
                Arguments.of(12, searchSelectors.getReviewUrl()),
                Arguments.of(14, searchSelectors.getChildUrl())
        );
    }

    public static Stream<Arguments> providePinItems() {
        return Stream.of(
                Arguments.of("Музыка", "music")
        );
    }

    public static Stream<Arguments> provideSearchData() {
        return Stream.of(
                Arguments.of("Tesla"),
                Arguments.of("Java"),
                Arguments.of("Python"),
                Arguments.of("Google")
        );
    }
}