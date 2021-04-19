package tests;

import aquality.selenium.browser.JavaScript;
import org.testng.Assert;
import org.testng.annotations.Test;
import wheelsUp.enums.MainMenuOptions;
import wheelsUp.enums.SecondLevelMenuItems;
import wheelsUp.forms.CoreMembershipPage;
import wheelsUp.forms.MainPage;
import wheelsUp.forms.RequestInfoForm;
import wheelsUp.models.UserInfo;

public class WheelUpTest extends BaseTest {
    private final MainPage mainPage = new MainPage();
    private final CoreMembershipPage coreMembershipPage = new CoreMembershipPage();
    private final RequestInfoForm requestInfoForm = new RequestInfoForm();

    private static final String REQUEST_INFO = "request-info";

    @Test
    public void testShouldBePossibleToOpenUrlInNewTab() {
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page is not opened");
        getLoggerInfo(mainPage.getDescriptionText());
        getLoggerInfo(mainPage.getWaysToFlyDescription());
        getBrowser().executeScript(JavaScript.SCROLL_TO_BOTTOM);
        getLoggerInfo(mainPage.getContactUsDescription());
        getLoggerInfo(mainPage.getFindUsDescription());
        getBrowser().executeScript(JavaScript.SCROLL_TO_TOP);
        mainPage.getMainMenu().openMainMenuByName(MainMenuOptions.FLY);
        mainPage.getMainMenu().openSecondLevelItemByName(SecondLevelMenuItems.CORE_MEMBERSHIP);
        getBrowser().waitForPageToLoad();
        Assert.assertTrue(coreMembershipPage.state().waitForDisplayed(), "Core Membership page is not opened");
        coreMembershipPage.enterUserData("Dmitry", "Test");
        Assert.assertTrue(getBrowser().getCurrentUrl().contains(REQUEST_INFO), String.format("Url is not contain %s", REQUEST_INFO));
        Assert.assertTrue(requestInfoForm.state().waitForDisplayed(), "Request Info page is not opened");
        UserInfo userInfo = new UserInfo("Dmitry", "Test");
        requestInfoForm.fillUserData(userInfo);
        requestInfoForm.selectRandomPrivateFlights();
        requestInfoForm.selectRandomTravelOption();
        requestInfoForm.selectRandomLeadSource();
        requestInfoForm.clickClose();
    }
}
