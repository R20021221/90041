package IOExceptions;

/**
 * Signals that a CSV line has an invalid structure.
 */
public class InvalidLineException extends Exception {

    /**
     * Creates an exception with the message that should be shown to the user.
     *
     * @param message error message
     */
    public InvalidLineException(String message) {
        super(message);
    }
}
