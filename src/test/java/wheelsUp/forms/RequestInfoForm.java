package wheelsUp.forms;


import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import wheelsUp.models.UserInfo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RequestInfoForm extends Form {
    private final static String DROPDOWN_ITEM = "//li[contains(@class, 'dropdown-box-items') and normalize-space(.) = '%s']";
    private ITextBox tbxFirstName = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'FirstName')]"), "First Name");
    private ITextBox tbxLastName = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'LastName')]"), "Last Name");
    private ITextBox tbxEmail = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'Email')]"), "Email");
    private ITextBox tbxPhoneNumber = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'Phone')]"), "Phone Number");
    private ITextBox tbxCompanyName = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'Company')]"), "Company Name");
    private ITextBox tbxStreetAddress = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'Address')]"), "Street Address");
    private ITextBox tbxCity = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'City')]"), "City");
    private ITextBox tbxZipCode = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'PostalCode')]"), "Zip Code");
    private ITextBox tbxState = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'State')]"), "State");
    private ITextBox tbxCountry = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'Country')]"), "Country");

    private ITextBox lblSecondHome = getElementFactory().getTextBox(By.xpath("//div[contains(@id, 'Do_you_own')]//div[contains(@class, 'dropdown')]"),
            "Do you own or travel to a second home?");



    protected RequestInfoForm() {
        super(By.xpath("//div[contains(@class, 'RequestInfo')]"), "Request Info");
    }

    public void fillUserData(UserInfo userInfo){
        tbxFirstName.clearAndType(userInfo.getFirstName());
        tbxLastName.clearAndType(userInfo.getLastName());
        tbxEmail.clearAndType(userInfo.getEmail());
        tbxPhoneNumber.clearAndType(userInfo.getPhoneNumber());
        tbxCompanyName.clearAndType(userInfo.getCompanyName());
        tbxStreetAddress.clearAndType(userInfo.getStreetAddress());
        tbxCity.clearAndType(userInfo.getCity());
        tbxZipCode.clearAndType(userInfo.getZipCode());
        tbxState.clearAndType(userInfo.getState());
        tbxCountry.clearAndType(userInfo.getCountry());
    }

    enum TravelOption{
        YES("Yes"),
        NO("No");

        String option;

        TravelOption(String option){
            this.option = option;
        }

        public String getOption() {
            return option;
        }
    }
}
