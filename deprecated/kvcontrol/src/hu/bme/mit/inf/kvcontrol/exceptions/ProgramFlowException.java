package hu.bme.mit.inf.kvcontrol.exceptions;

/**
 *
 * @author zsoltmazlo
 */
public class ProgramFlowException extends Exception {

    public ProgramFlowException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProgramFlowException(String message) {
        super(message);
    }

    public ProgramFlowException(Throwable cause) {
        super(cause);
    }

}
