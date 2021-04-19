package wheelsUp.enums;

public enum SecondLevelMenuItems {
    DOWNLOAD_FLY("DOWNLOAD & FLY"),
    CONNECT_MEMBERSHIP("CONNECT MEMBERSHIP"),
    CORE_MEMBERSHIP("CORE MEMBERSHIP"),
    CORPORATE_SOLUTIONS("CORPORATE SOLUTIONS");

    String value;

    SecondLevelMenuItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}