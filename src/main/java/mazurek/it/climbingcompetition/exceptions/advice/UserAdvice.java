package mazurek.it.climbingcompetition.exceptions.advice;

import mazurek.it.climbingcompetition.exceptions.MailDuplicationException;
import mazurek.it.climbingcompetition.exceptions.PhoneDuplicatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserAdvice extends BasicAdvice {

    @ResponseBody
    @ExceptionHandler(MailDuplicationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String mailDuplicationAdvice(MailDuplicationException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(PhoneDuplicatedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String phoneDuplicationAdvice(PhoneDuplicatedException ex) {
        return ex.getMessage();
    }

}
