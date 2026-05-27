package IOExceptions;

/**
 * Signals that requested data could not be found.
 */
public class NotFoundException extends Exception {

    public NotFoundException(String message) {
        super(message);
    }
}
