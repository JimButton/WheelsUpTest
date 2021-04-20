package wheelsUp.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LeadSource {
    AMEX("AMEX"),
    Airport("Airport"),
    In_The_News("In The News"),
    Partner_Companies("Partner Companies");

    String option;

    LeadSource(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public static List<String> getValues() {
        return Arrays.stream(LeadSource.values()).map(LeadSource::getOption).collect(Collectors.toList());
    }
}
