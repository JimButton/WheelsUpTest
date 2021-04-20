package wheelsUp.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum TravelWithPetsOption {
    YES("Yes"),
    NO("No");

    String option;

    TravelWithPetsOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public static List<String> getValues() {
        return Arrays.stream(TravelWithPetsOption.values()).map(TravelWithPetsOption::getOption).collect(Collectors.toList());
    }
}
