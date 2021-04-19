package wheelsUp.forms;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;

public class CoreMembershipPage extends BasePage{

    private final ITextBox tbxFirstName = getElementFactory().getTextBox(By.xpath("//div[contains(@class, 'input')]//input[contains(@id, 'FirstName')]"), "First Name", ElementState.EXISTS_IN_ANY_STATE);
    private final ITextBox tbxLastName = getElementFactory().getTextBox(By.xpath("//div[contains(@class, 'input')]//input[contains(@id, 'LastName')]"), "Last Name", ElementState.EXISTS_IN_ANY_STATE);
    private final IButton btnContinue = getElementFactory().getButton(By.xpath("//div[contains(@class, 'btn')]//a[contains(., 'CONTINUE')]"), "Continue");

    public CoreMembershipPage() {
        super(By.xpath("//h1[contains(text(), 'Wheels Up Core Membership')]"), "Core Membership ");
    }

    public void enterUserData(String firstName, String lastName){
        tbxFirstName.clearAndType(firstName);
        tbxLastName.clearAndType(lastName);
        btnContinue.clickAndWait();
    }
}
