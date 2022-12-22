package Selectors;

import lombok.Getter;

@Getter
public class SearchSelectors {
    private final String searchInput = "#text";
    private final String searchButton = "|[class^=\"search3__button\"]";
    private final String searchClear = "|[class*=\"search3__clear\"]";
    private final String addPinned = "|[class*=\"services-pinned__add\"]";
    private final String pinnedSearchInput = "|[class=\"services-pinned__popup-search\"]";
    private final String pinnedCheckbox = "|[data-id=\"music\"] ~ .services-pinned__popup-item-checkbox-icon";
    private final String pinnedSaveButton = "|[class=\"services-pinned__popup-save-button\"]";
    private final String pinned = "|[class=\"home-link2 services-pinned__item\"]";
    private final String menuIcon = "|[class*=\"headline__personal-menu\"]";
    private final String menuBody = "|[class*=\"popup2_view_default\"]";

    private final String mailUrl = "https://mail.yandex.ru/?origin=web_profile_menu";
    private final String chatUrl = "https://yandex.ru/chat#/";
    private final String collectionsUrl = "https://yandex.ru/collections/";
    private final String marketUrl = "https://market.yandex.ru";
    private final String diskUrl = "https://disk.yandex.ru/";
    private final String reviewUrl = "https://reviews.yandex.ru/ugcpub/cabinet?utm_source=big_home";
    private final String childUrl = "https://passport.yandex.ru/auth/child/landing?utm_campaign=kids&utm_source=profile_menu&utm_content=bear";

    public String getMenuItem(int child) {
        return "|.usermenu-redesign__list > a:nth-child(" + child + ")";
    }

    public String getFoundPin(String id) {
        return "|[data-id=\"" + id + "\"] + div";
    }
}
