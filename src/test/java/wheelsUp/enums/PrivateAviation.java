package wheelsUp.enums;

public enum PrivateAviation {
    SHARED_FLIGHTS("SHARED FLIGHTS"),
    SHUTTLE_FLIGHTS("SHUTTLE FLIGHTS"),
    HOT_FLIGHTS("HOT FLIGHTS");

    String option;

    PrivateAviation(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
