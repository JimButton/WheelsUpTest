package wheelsUp.forms;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import org.openqa.selenium.By;
import wheelsUp.enums.PrivateAviation;
import wheelsUp.models.UserInfo;

public class CoreMembershipPage extends BasePage {
    private final static String SECTION_DESCRIPTION_TEMPLATE = "//div[contains(@class, 'content')][./h3[normalize-space(text()) = '%s']]//*[contains(@class, 'description')]";
    private final ITextBox tbxFirstName = getElementFactory().getTextBox(By.xpath("//div[contains(@class, 'input')]//input[contains(@id, 'FirstName')]"), "First Name", ElementState.EXISTS_IN_ANY_STATE);
    private final ITextBox tbxLastName = getElementFactory().getTextBox(By.xpath("//div[contains(@class, 'input')]//input[contains(@id, 'LastName')]"), "Last Name", ElementState.EXISTS_IN_ANY_STATE);
    private final IButton btnContinue = getElementFactory().getButton(By.xpath("//div[contains(@class, 'btn')]//a[contains(., 'CONTINUE')]"), "Continue");
    private final ILabel lblPrivateAviation = getElementFactory().getLabel(By.xpath("//div[contains(@class, 'module-title') and contains(., 'Private aviation')]"), "Private aviation");

    public CoreMembershipPage() {
        super(By.xpath("//h1[contains(text(), 'Wheels Up Core Membership')]"), "Core Membership ");
    }

    public void enterUserData(UserInfo userInfo) {
        tbxFirstName.clearAndType(userInfo.getFirstName());
        tbxLastName.clearAndType(userInfo.getLastName());
        btnContinue.clickAndWait();
    }

    public void scrollToPrivateAviationSection() {
        lblPrivateAviation.getJsActions().scrollIntoView();
    }

    public String getSectionDescription(PrivateAviation option) {
        return getElementFactory().getLabel(By.xpath(String.format(SECTION_DESCRIPTION_TEMPLATE, option.getOption())), option.getOption()).getText();
    }
}
