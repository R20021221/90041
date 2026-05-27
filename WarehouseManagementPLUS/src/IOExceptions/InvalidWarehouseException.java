package IOExceptions;

/**
 * Signals invalid warehouse data or state.
 */
public class InvalidWarehouseException extends Exception {

    public InvalidWarehouseException(String message) {
        super(message);
    }
}
