package mazurek.it.climbingcompetition.exceptions.advice;

import mazurek.it.climbingcompetition.exceptions.RoleDuplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RoleAdvice extends BasicAdvice {
    @ResponseBody
    @ExceptionHandler(RoleDuplicationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String roleNameIsDuplicatedHandler(RoleDuplicationException ex) {
        return ex.getMessage();
    }
}
