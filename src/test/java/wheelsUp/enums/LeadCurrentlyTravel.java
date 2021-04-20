package wheelsUp.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LeadCurrentlyTravel {
    COMMERCIAL("Commercial"),
    CHARTER("Charter"),
    JET_CARD("Jet Card"),
    FRACTIONAL("Fractional"),
    OTHER_MEMBERSHIP("Other Membership"),
    WHOLE_AIRCRAFT("Whole Aircraft");

    String option;

    LeadCurrentlyTravel(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public static List<String> getValues() {
        return Arrays.stream(LeadCurrentlyTravel.values()).map(LeadCurrentlyTravel::getOption).collect(Collectors.toList());
    }
}
