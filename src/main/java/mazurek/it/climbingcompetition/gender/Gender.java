package mazurek.it.climbingcompetition.gender;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Gender {
    MALE("K"), FEMALE("M"), OTHER("X"), JUNIOR("J");

    private final String code;
}
