package wheelsUp.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

public class CoreMembershipPage extends BasePage{

    private ITextBox tbxFirstName = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'FirstName')]"), "First Name");
    private ITextBox tbxLastName = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'LastName')]"), "Last Name");
    private IButton btnContinue = getElementFactory().getButton(By.xpath("//div[contains(@class, 'btn')]//a[contains(., 'CONTINUE')]"), "Continue");

    public CoreMembershipPage() {
        super(By.xpath("//h1[contains(text(), 'Wheels Up Core Membership')]"), "Core Membership ");
    }

    public void enterUserData(String firstName, String lastName){
        tbxFirstName.getJsActions().scrollIntoView();
        tbxFirstName.clearAndType(firstName);
        tbxLastName.clearAndType(lastName);
        btnContinue.clickAndWait();
    }
}
