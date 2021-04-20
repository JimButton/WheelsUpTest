package wheelsUp.forms;


import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import wheelsUp.enums.*;
import wheelsUp.models.UserInfo;

import java.util.List;
import java.util.Random;

public class RequestInfoForm extends Form {
    private final static String DROPDOWN_ITEM = "//li[contains(@class, 'dropdown-box-items') and normalize-space(.) = '%s']";
    private final static String TRAVEL_WITH_PETS_TEMPLATE = "//div[contains(@id, 'travel_with_pets')]//label[normalize-space(.) = '%s']";
    private final static String LEAD_CURRENTLY_TRAVEL_TEMPLATE = "//div[contains(@id, 'currently_Travel')]//label[normalize-space(.) = '%s']";
    private final static String PRODUCT_INTEREST_TEMPLATE = "//div[contains(@id, 'Product_Interest')]//label[normalize-space(.) = '%s']";

    private final ITextBox tbxFirstName = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'FirstName')]"), "First Name");
    private final ITextBox tbxLastName = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'LastName')]"), "Last Name");
    private final ITextBox tbxEmail = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'Email')]"), "Email");
    private final ITextBox tbxPhoneNumber = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'Phone')]"), "Phone Number");
    private final ITextBox tbxCompanyName = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'Company')]"), "Company Name");
    private final ITextBox tbxStreetAddress = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'Address')]"), "Street Address");
    private final ITextBox tbxCity = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'City')]"), "City");
    private final ITextBox tbxZipCode = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'PostalCode')]"), "Zip Code");
    private final ITextBox tbxState = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'State')]"), "State");
    private final ITextBox tbxCountry = getElementFactory().getTextBox(By.xpath("//input[contains(@id, 'Country')]"), "Country");
    private final ITextBox tbxComment = getElementFactory().getTextBox(By.xpath("//div[contains(@id, 'WebFormComment')]//textarea"), "Comment");
    private final ILabel lblSecondHome = getElementFactory().getLabel(By.xpath("//div[contains(@id, 'Do_you_own')]//div[contains(@class, 'text-select')]//p"),
            "Do you own or travel to a second home?");
    private final ILabel lblPrivateFlights = getElementFactory().getLabel(By.xpath("//div[contains(@id, 'How_Many_Private')]//div[contains(@class, 'text-select')]//p"),
            "How many private flights do you take a year?");
    private final ILabel lblLeadSourceWebList = getElementFactory().getLabel(By.xpath("//div[contains(@id, 'leadSourceWebList')]//div[contains(@class, 'text-select')]//p"),
            "How did you hear about us?");


    private final IButton btnClose = getElementFactory().getButton(By.xpath("//div[contains(@aria-labelledby, 'btnMenu')]//i[contains(@class, 'icon-close')]"), "Close");

    public RequestInfoForm() {
        super(By.xpath("//div[contains(@class, 'RequestInfo')]"), "Request Info");
    }

    public void fillUserData(UserInfo userInfo) {
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

    public void selectRandomFlightOptions() {
        selectRandomOption(lblSecondHome, TravelOption.getValues());
        selectRandomOption(lblPrivateFlights, PrivateFlight.getValues());
        selectRandomOption(lblLeadSourceWebList, LeadSource.getValues());
        clickRandomRadioBtnOption(TravelWithPetsOption.getValues(), TRAVEL_WITH_PETS_TEMPLATE);
        clickRandomRadioBtnOption(LeadCurrentlyTravel.getValues(), LEAD_CURRENTLY_TRAVEL_TEMPLATE);
        clickRandomRadioBtnOption(MembershipType.getValues(), PRODUCT_INTEREST_TEMPLATE);
    }

    private void selectRandomOption(ILabel lblSelect, List<String> values) {
        lblSelect.getJsActions().scrollToTheCenter();
        lblSelect.clickAndWait();
        String randomOption = values.get(new Random().nextInt(values.size()));
        ILabel lblRandomOption = getElementFactory().getLabel(By.xpath(String.format(DROPDOWN_ITEM, randomOption)), randomOption);
        lblRandomOption.getJsActions().scrollToTheCenter();
        lblRandomOption.getJsActions().clickAndWait();
    }

    private void clickRandomRadioBtnOption(List<String> values, String template) {
        String randomOption = values.get(new Random().nextInt(values.size()));
        ILabel lblRandomOption = getElementFactory().getLabel(By.xpath(String.format(template, randomOption)), randomOption);
        lblRandomOption.getJsActions().scrollToTheCenter();
        lblRandomOption.clickAndWait();
    }

    public void fillCommentArea(String comment) {
        tbxComment.clearAndType(comment);
    }

    public void clickClose() {
        btnClose.clickAndWait();
    }
}
