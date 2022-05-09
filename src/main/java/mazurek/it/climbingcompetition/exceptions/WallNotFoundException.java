package mazurek.it.climbingcompetition.exceptions;

public class WallNotFoundException extends RuntimeException{
    public WallNotFoundException(Long id) {
        super("Could not find wall with id: "+ id);
    }
}
