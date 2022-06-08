package mazurek.it.climbingcompetition.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    FEMALE("F", "Kobieta"),
    MALE("M", "Mężczyzna"),
    SENIOR_50("S", "+50"),
    JUNIOR("J", "Junior"),
    J_MALE("JM", "Junior - chłopiec"),
    J_FEMALE("JF", "Junior - dziewczynka");
    private final String code;
    private final String fullName;
}
