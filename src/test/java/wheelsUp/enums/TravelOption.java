package wheelsUp.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum TravelOption {
    YES("Yes"),
    NO("No");

    String option;

    TravelOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public static List<String> getValues() {
        return Arrays.stream(TravelOption.values()).map(TravelOption::getOption).collect(Collectors.toList());
    }
}
