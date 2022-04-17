package mazurek.it.climbingcompetition.gender;

public enum Gender {
    MALE("K"), FEMALE("M"), OTHER("X"), JUNIOR("J");
    private String code;

    Gender(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
