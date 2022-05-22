package mazurek.it.climbingcompetition.exceptions;

public class PhoneDuplicatedException extends RuntimeException {
    public PhoneDuplicatedException(){
        super("Phone existing in Data Base.");
    }
}
