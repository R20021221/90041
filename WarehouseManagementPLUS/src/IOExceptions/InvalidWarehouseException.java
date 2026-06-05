package IOExceptions;

/**
 * Signals invalid warehouse data or state.
 */
public class InvalidWarehouseException extends Exception {

    /**
     * Creates an exception with the message that should be shown to the user.
     *
     * @param message error message
     */
    public InvalidWarehouseException(String message) {
        super(message);
    }
}
