package wheelsUp.forms;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public abstract class BasePage extends Form {

    BasePage(By locator, String name) {
        super(locator, name);
    }
}
