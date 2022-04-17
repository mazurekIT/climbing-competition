package mazurek.it.climbingcompetition.walls;

public enum Wall {
    BLOK_LINE("BL"), KARMA("KA"), UNITED("UN");
    private String code;

    Wall(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
