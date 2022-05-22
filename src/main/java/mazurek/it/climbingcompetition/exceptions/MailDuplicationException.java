package mazurek.it.climbingcompetition.exceptions;

public class MailDuplicationException extends RuntimeException {
    public MailDuplicationException() {
        super("Mail existing in Data Base");
    }

}
