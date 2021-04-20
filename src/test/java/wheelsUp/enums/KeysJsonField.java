package wheelsUp.enums;

public enum KeysJsonField {
    GOOGLE_TAG_MANAGER("google_tag_manager"),
    MAPBOX_ACCESSTOKEN("mapbox_accesstoken"),
    FOOTER_DISCLAIMER("footer_disclaimer"),
    EMAIL("email"),
    FACEBOOK("facebook"),
    TWITTER("twitter");

    String field;

    KeysJsonField(String field) {
        this.field = field;
    }

    public String getObjectField() {
        return field;
    }
}