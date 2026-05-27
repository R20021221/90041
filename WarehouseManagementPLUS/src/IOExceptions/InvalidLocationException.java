package IOExceptions;

/**
 * Signals an invalid warehouse location.
 */
public class InvalidLocationException extends Exception {

    public InvalidLocationException(String message) {
        super(message);
    }
}
