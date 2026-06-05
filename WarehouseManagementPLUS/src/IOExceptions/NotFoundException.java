package IOExceptions;

/**
 * Signals that requested data could not be found.
 */
public class NotFoundException extends Exception {

    /**
     * Creates an exception with the message that should be shown to the user.
     *
     * @param message error message
     */
    public NotFoundException(String message) {
        super(message);
    }
}
