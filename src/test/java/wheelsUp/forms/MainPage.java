package wheelsUp.forms;

import aquality.selenium.elements.interfaces.ILabel;
import bsh.This;
import org.openqa.selenium.By;
import org.testng.log4testng.Logger;
import wheelsUp.menus.MainMenu;

public class MainPage extends BasePage{

    private MainMenu mainMenu = new MainMenu();

    private ILabel lblContentDescription = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'background-content')]//div[contains(@class, 'content')]"),
            "Description");

    private ILabel lblWaysToFlyDescription = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'ways-to-fly')]//div[contains(@class, 'module-title')]"),
            "Ways to fly");

    private ILabel lblContactUsDescription = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'links')][./div[contains(., 'Contact Us')]]//ul[contains(@class, 'list')]"),
            "Contact Us");

    private ILabel lblFindUsDescription = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'links')][./div[contains(., 'Find Us')]]//ul[contains(@class, 'list')]"),
            "Find Us");

    public MainPage() {
        super(By.xpath("//div[contains(@class, 'planes')]"), "Wheels Up main page");
    }

    public String getDescriptionText(){
        return lblContentDescription.getText();
    }

    public String getWaysToFlyDescription(){
        lblWaysToFlyDescription.getJsActions().scrollIntoView();
        return lblWaysToFlyDescription.getText();
    }

    public String getContactUsDescription(){
        return lblContactUsDescription.getText();
    }

    public String getFindUsDescription(){
        return lblFindUsDescription.getText();
    }

    public MainMenu getMainMenu(){
        return mainMenu;
    }
}
