package wheelsUp.enums;

public enum MainMenuOptions {
    FLY("Fly"),
    FLEET("Fleet"),
    LIFESTYLE("Lifestyle"),
    OWNERSHIP("Ownership");

    String value;

    MainMenuOptions(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
