package wheelsUp.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum PrivateFlight {
    ZERO("0"),
    ONE_FIVE("1-5"),
    FIVE_TEN("5-10"),
    MORE_THEN_TEN("10+");

    String option;

    PrivateFlight(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public static List<String> getValues() {
        return Arrays.stream(PrivateFlight.values()).map(PrivateFlight::getOption).collect(Collectors.toList());
    }
}