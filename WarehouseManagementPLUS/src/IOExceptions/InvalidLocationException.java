package IOExceptions;

/**
 * Signals an invalid warehouse location.
 */
public class InvalidLocationException extends Exception {

    /**
     * Creates an exception with the message that should be shown to the user.
     *
     * @param message error message
     */
    public InvalidLocationException(String message) {
        super(message);
    }
}
