package IOExceptions;

/**
 * Signals that a CSV line has an invalid structure.
 */
public class InvalidLineException extends Exception {

    public InvalidLineException(String message) {
        super(message);
    }
}
