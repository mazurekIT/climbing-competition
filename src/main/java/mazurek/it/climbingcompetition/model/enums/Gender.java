package mazurek.it.climbingcompetition.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    MALE("K","Kobieta"),
    FEMALE("M","Mężczyzna"),
    SENIOR_50("S","+50"),
    JUNIOR("J","Junior"),
    J_MALE("JM","Junior - dziewczynka"),
    J_FEMALE("JF","Junior - chłopiec");
    private final String code;
    private final String fullName;
}
