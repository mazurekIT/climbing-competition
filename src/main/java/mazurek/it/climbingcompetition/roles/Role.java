package mazurek.it.climbingcompetition.roles;

public enum Role {
    SUPER_ADMIN("S-ADM"), ADMIN("ADM"), CLIMBER("CLM");
    private String code;

    Role (String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
