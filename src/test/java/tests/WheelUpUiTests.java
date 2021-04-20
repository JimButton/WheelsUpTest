package tests;

import aquality.selenium.browser.JavaScript;
import aquality.selenium.core.logging.Logger;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import wheelsUp.enums.MainMenuOptions;
import wheelsUp.enums.PrivateAviation;
import wheelsUp.enums.SecondLevelMenuItems;
import wheelsUp.forms.CoreMembershipPage;
import wheelsUp.forms.MainPage;
import wheelsUp.forms.RequestInfoForm;
import wheelsUp.models.UserInfo;

public class WheelUpUiTests extends BaseTest {
    private static final String REQUEST_INFO = "request-info";

    private final MainPage mainPage = new MainPage();
    private final CoreMembershipPage coreMembershipPage = new CoreMembershipPage();
    private final RequestInfoForm requestInfoForm = new RequestInfoForm();
    private final UserInfo testUser = new UserInfo("Dmitry", "Test");

    @Test
    public void testShouldFillWheelsUpUserData() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page is not opened");
        Logger.getInstance().info(mainPage.getDescriptionText());
        Logger.getInstance().info(mainPage.getWaysToFlyDescription());
        getBrowser().executeScript(JavaScript.SCROLL_TO_BOTTOM);
        Logger.getInstance().info(mainPage.getContactUsDescription());
        Logger.getInstance().info(mainPage.getFindUsDescription());
        getBrowser().executeScript(JavaScript.SCROLL_TO_TOP);
        mainPage.getMainMenu().openMainMenuByName(MainMenuOptions.FLY);
        mainPage.getMainMenu().openSecondLevelItemByName(SecondLevelMenuItems.CORE_MEMBERSHIP);
        getBrowser().waitForPageToLoad();
        Assert.assertTrue(coreMembershipPage.state().waitForDisplayed(), "Core Membership page is not opened");
        coreMembershipPage.scrollToPrivateAviationSection();
        Logger.getInstance().info(String.format("%s: %s", PrivateAviation.SHARED_FLIGHTS.getOption(), coreMembershipPage.getSectionDescription(PrivateAviation.SHARED_FLIGHTS)));
        Logger.getInstance().info(String.format("%s: %s", PrivateAviation.HOT_FLIGHTS.getOption(), coreMembershipPage.getSectionDescription(PrivateAviation.HOT_FLIGHTS)));
        Logger.getInstance().info(String.format("%s: %s", PrivateAviation.SHUTTLE_FLIGHTS.getOption(), coreMembershipPage.getSectionDescription(PrivateAviation.SHUTTLE_FLIGHTS)));
        coreMembershipPage.enterUserData(testUser);
        Assert.assertTrue(getBrowser().getCurrentUrl().contains(REQUEST_INFO), String.format("Url is not contain %s", REQUEST_INFO));
        Assert.assertTrue(requestInfoForm.state().waitForDisplayed(), "Request Info page is not opened");
        requestInfoForm.fillUserData(testUser);
        requestInfoForm.selectRandomFlightOptions();
        requestInfoForm.fillCommentArea(Faker.instance().lorem().paragraph());
        requestInfoForm.clickClose();
        Assert.assertTrue(requestInfoForm.state().waitForNotDisplayed(), "Request Info page should be closed");
    }
}