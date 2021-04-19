package wheelsUp.forms;

import org.openqa.selenium.By;

public class CoreMembershipPage extends BasePage{

    public CoreMembershipPage() {
        super(By.xpath("//h1[contains(text(), 'Wheels Up Core Membership')]"), "Core Membership ");
    }
}
