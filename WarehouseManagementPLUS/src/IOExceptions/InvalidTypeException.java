package IOExceptions;

/**
 * Signals an invalid enum or domain type value.
 */
public class InvalidTypeException extends Exception {

    /**
     * Creates an exception with the message that should be shown to the user.
     *
     * @param message error message
     */
    public InvalidTypeException(String message) {
        super(message);
    }
}
