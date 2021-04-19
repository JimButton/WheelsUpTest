package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.browser.JavaScript;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import wheelsUp.enums.MainMenuOptions;
import wheelsUp.enums.SecondLevelMenuItems;
import wheelsUp.forms.CoreMembershipPage;
import wheelsUp.forms.MainPage;

public class WheelUpTest extends BaseTest{
    private final MainPage mainPage = new MainPage();
    private final CoreMembershipPage coreMembershipPage = new CoreMembershipPage();

    @Test
    public void testShouldBePossibleToOpenUrlInNewTab() {
        Assert.assertTrue(mainPage.state().isDisplayed(), "Main page is not opened");
        getLoggerInfo(mainPage.getDescriptionText());
        getLoggerInfo(mainPage.getWaysToFlyDescription());
        getBrowser().executeScript(JavaScript.SCROLL_TO_BOTTOM);
        getLoggerInfo(mainPage.getContactUsDescription());
        getLoggerInfo(mainPage.getFindUsDescription());
        getBrowser().executeScript(JavaScript.SCROLL_TO_TOP);
        mainPage.getMainMenu().openMainMenuByName(MainMenuOptions.FLY);
        mainPage.getMainMenu().openSecondLevelItemByName(SecondLevelMenuItems.CORE_MEMBERSHIP);
        Assert.assertTrue(coreMembershipPage.state().isDisplayed(), "Main page is not opened");

    }
}
