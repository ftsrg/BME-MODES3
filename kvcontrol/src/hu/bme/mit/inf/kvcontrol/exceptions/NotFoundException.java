package hu.bme.mit.inf.kvcontrol.exceptions;

/**
 *
 * @author zsoltmazlo
 */
public class NotFoundException extends Exception {

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

}
