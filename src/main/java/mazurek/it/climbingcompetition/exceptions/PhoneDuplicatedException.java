package mazurek.it.climbingcompetition.exceptions;

public class PhoneDuplicatedException extends RuntimeException {
    public PhoneDuplicatedException(){
        super("Phone is duplicated, is existing in Data Base.");
    }
}
