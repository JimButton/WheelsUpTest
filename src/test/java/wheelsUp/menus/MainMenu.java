package wheelsUp.menus;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import wheelsUp.enums.MainMenuOptions;
import wheelsUp.enums.SecondLevelMenuItems;

public class MainMenu extends Form {
    private static final String MEGA_MENU_PATTERN_LOC = "//nav[contains(@class, 'items')]";
    private static final String MEGA_MENU_FIRST_LEVEL_ITEM_PATTERN_LOC = MEGA_MENU_PATTERN_LOC + "//a[normalize-space(text()) = '%s']";
    private static final String MEGA_MENU_SECOND_LEVEL_ITEM_PATTERN_LOC = "//div[contains(@class, 'menu-item')]//a[normalize-space(text()) = '%s']";

    public MainMenu() {
        super(
                By.xpath(MEGA_MENU_PATTERN_LOC), "Menu"
        );
    }

    public void openMainMenuByName(MainMenuOptions option) {
        String value = option.getValue();
        getElementFactory().getLink(By.xpath(String.format(MEGA_MENU_FIRST_LEVEL_ITEM_PATTERN_LOC, value)), value).clickAndWait();
    }

    public void openSecondLevelItemByName(SecondLevelMenuItems item) {
        String value = item.getValue();
        getElementFactory().getLink(By.xpath(String.format(MEGA_MENU_SECOND_LEVEL_ITEM_PATTERN_LOC, value)), value).clickAndWait();
    }
}
