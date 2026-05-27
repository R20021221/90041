package IOExceptions;

/**
 * Signals an invalid enum or domain type value.
 */
public class InvalidTypeException extends Exception {

    public InvalidTypeException(String message) {
        super(message);
    }
}
