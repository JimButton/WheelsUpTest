package wheelsUp.enums;

public enum WheelsUpJsonObject {
    HEADER("header"),
    FOOTER("footer"),
    KEYS("keys"),
    REDIRECTS("redirects"),
    REQUEST_INFO("request-info");

    String objectName;

    WheelsUpJsonObject(String objectName) {
        this.objectName = objectName;
    }

    public String getObjectName() {
        return objectName;
    }
}