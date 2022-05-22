package mazurek.it.climbingcompetition.exceptions;

public class MailDuplicationException extends RuntimeException {
    public MailDuplicationException(){
        super("Mail is duplicated, is existing in Data Base");
    }
}
