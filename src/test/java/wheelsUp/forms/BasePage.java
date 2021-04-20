package wheelsUp.forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import wheelsUp.menus.MainMenu;

public abstract class BasePage extends Form {
    protected MainMenu mainMenu = new MainMenu();

    BasePage(By locator, String name) {
        super(locator, name);
    }
}