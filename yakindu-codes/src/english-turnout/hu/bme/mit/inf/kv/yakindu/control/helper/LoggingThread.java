package hu.bme.mit.inf.kv.yakindu.control.helper;

/**
 *
 * @author benedekh
 */
public class LoggingThread extends Thread {

    protected void logMessage(String message) {
        SimpleLogger.printLogMessage(getName(), message);
    }

    protected void logErrorMessage(String message) {
        SimpleLogger.printErrorMessage(getName(), message);
    }
}
