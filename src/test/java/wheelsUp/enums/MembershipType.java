package wheelsUp.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MembershipType {
    WHEELS_UP_CONNECT_MEMBERSHIP("Wheels Up Connect Membership"),
    WHEELS_UP_CORE_MEMBERSHIP("Wheels Up Core Membership"),
    WHEELS_UP_BUSINESS_MEMBERSHIP("Wheels Up Business Membership");

    String option;

    MembershipType(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public static List<String> getValues() {
        return Arrays.stream(MembershipType.values()).map(MembershipType::getOption).collect(Collectors.toList());
    }
}