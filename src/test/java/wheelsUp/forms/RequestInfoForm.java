package wheelsUp.forms;


import aquality.selenium.browser.JavaScript;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import wheelsUp.models.UserInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RequestInfoForm extends Form {
    private final static String DROPDOWN_ITEM = "//li[contains(@class, 'dropdown-box-items') and normalize-space(.) = '%s']";
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

    public void selectRandomTravelOption(){
        lblSecondHome.getJsActions().scrollIntoView();
        lblSecondHome.clickAndWait();
        String randomOption = TravelOption.getValues().get(new Random().nextInt(TravelOption.getValues().size()));
        getElementFactory().getLabel(By.xpath(String.format(DROPDOWN_ITEM, randomOption)), randomOption).clickAndWait();
    }

    public void selectRandomPrivateFlights(){
        lblPrivateFlights.clickAndWait();
        String randomOption = PrivateFlight.getValues().get(new Random().nextInt(PrivateFlight.getValues().size()));
        getElementFactory().getLabel(By.xpath(String.format(DROPDOWN_ITEM, randomOption)), randomOption).clickAndWait();
    }

    public void selectRandomLeadSource(){
        lblLeadSourceWebList.getJsActions().scrollIntoView();
        lblLeadSourceWebList.clickAndWait();
        String randomOption = LeadSource.getValues().get(new Random().nextInt(LeadSource.getValues().size()));
        getElementFactory().getLabel(By.xpath(String.format(DROPDOWN_ITEM, randomOption)), randomOption).clickAndWait();
    }

    public void clickClose(){
        btnClose.clickAndWait();
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

        public static List<String> getValues() {
           return Arrays.stream(TravelOption.values()).map(TravelOption::getOption).collect(Collectors.toList());
        }
    }

    enum PrivateFlight{
        ZERO("0"),
        ONE_FIVE("1-5"),
        FIVE_TEN("5-10"),
        MORE_THEN_TEN("10+");

        String option;

        PrivateFlight(String option){
            this.option = option;
        }

        public String getOption() {
            return option;
        }

        public static List<String> getValues() {
            return Arrays.stream(TravelOption.values()).map(TravelOption::getOption).collect(Collectors.toList());
        }
    }

    enum LeadSource{
        AMEX("AMEX"),
        Airport("Airport"),
        In_The_News("In The News"),
        Partner_Companies("Partner Companies");

        String option;

        LeadSource(String option){
            this.option = option;
        }

        public String getOption() {
            return option;
        }

        public static List<String> getValues() {
            return Arrays.stream(TravelOption.values()).map(TravelOption::getOption).collect(Collectors.toList());
        }
    }
}
