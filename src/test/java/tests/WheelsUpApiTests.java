package tests;

import aquality.selenium.core.logging.Logger;
import com.github.javafaker.Faker;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import wheelsUp.enums.KeysJsonField;
import wheelsUp.enums.WheelsUpJsonObject;
import wheelsUp.utils.JsonReader;

public class WheelsUpApiTests {
    private static final String JSON_API_URL = "https://wheelsup.com/_mock_/initial-data.json";
    private static final String INSTAGRAM = "https://www.facebook.com/WheelsUp8760";
    private static final String TWITTER = "https://twitter.com/WheelsUp";
    private String json = null;

    @BeforeMethod
    protected void beforeMethod() {
        json = JsonReader.getJSON(JSON_API_URL);
    }

    @Test
    public void testShouldCompareSocialLinks() {
        Assert.assertNotNull(json, "Error to receive json response");
        verifySocialAccounts(TWITTER, INSTAGRAM);
    }

    @Test
    public void testShouldOperateWithJsonValues() {
        Assert.assertNotNull(json, "Error to receive json response");
        displayEditedKeys();
    }

    private void verifySocialAccounts(String twitter, String instagram) {
        JsonObject wheelsUpJsonObject = new JsonParser().parse(json).getAsJsonObject();
        String actualInstagram = wheelsUpJsonObject.getAsJsonObject(WheelsUpJsonObject.KEYS.getObjectName()).get(KeysJsonField.FACEBOOK.getObjectField()).getAsString();
        String actualTwitter = wheelsUpJsonObject.getAsJsonObject(WheelsUpJsonObject.KEYS.getObjectName()).get(KeysJsonField.TWITTER.getObjectField()).getAsString();
        Assert.assertEquals(actualInstagram, instagram, String.format("Actual instagram value %s is " +
                "not equal to expected %s", actualInstagram, instagram));
        Assert.assertEquals(actualTwitter, twitter, String.format("Actual twitter value %s is " +
                "not equal to expected %s", actualInstagram, twitter));
    }

    private void displayEditedKeys() {
        JsonObject keysWheelsUpJsonObject = new JsonParser().parse(json).getAsJsonObject().getAsJsonObject(WheelsUpJsonObject.KEYS.getObjectName());
        Logger.getInstance().info("Size of keys values: %d", keysWheelsUpJsonObject.size());
        keysWheelsUpJsonObject.remove(KeysJsonField.GOOGLE_TAG_MANAGER.getObjectField());
        keysWheelsUpJsonObject.remove(KeysJsonField.MAPBOX_ACCESSTOKEN.getObjectField());
        keysWheelsUpJsonObject.remove(KeysJsonField.FOOTER_DISCLAIMER.getObjectField());
        keysWheelsUpJsonObject.addProperty(KeysJsonField.EMAIL.getObjectField(), Faker.instance().internet().emailAddress());
        Logger.getInstance().info(String.format("Json object after editing values: %s", keysWheelsUpJsonObject));
    }
}