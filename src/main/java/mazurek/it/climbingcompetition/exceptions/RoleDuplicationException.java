package mazurek.it.climbingcompetition.exceptions;

public class RoleDuplicationException extends RuntimeException {
    public RoleDuplicationException(){
        super("Role existing in Data Base.");
    }
}
