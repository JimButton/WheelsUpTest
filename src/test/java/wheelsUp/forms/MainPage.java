package wheelsUp.forms;

import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;
import wheelsUp.menus.MainMenu;

public class MainPage extends BasePage {

    private final ILabel lblContentDescription = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'background-content')]//div[contains(@class, 'content')]"),
            "Description");

    private final ILabel lblWaysToFlyDescription = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'ways-to-fly')]//div[contains(@class, 'module-title')]"),
            "Ways to fly");

    private final ILabel lblContactUsDescription = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'links')][./div[contains(., 'Contact Us')]]//ul[contains(@class, 'list')]"),
            "Contact Us");

    private final ILabel lblFindUsDescription = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'links')][./div[contains(., 'Find Us')]]//ul[contains(@class, 'list')]"),
            "Find Us");

    public MainPage() {
        super(By.xpath("//div[contains(@class, 'planes')]"), "Wheels Up main page");
    }

    public String getDescriptionText() {
        return lblContentDescription.getText();
    }

    public String getWaysToFlyDescription() {
        lblWaysToFlyDescription.getJsActions().scrollIntoView();
        return lblWaysToFlyDescription.getText();
    }

    public String getContactUsDescription() {
        return lblContactUsDescription.getText();
    }

    public String getFindUsDescription() {
        return lblFindUsDescription.getText();
    }

    public MainMenu getMainMenu() {
        return mainMenu;
    }
}
