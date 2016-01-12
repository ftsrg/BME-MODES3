package hu.bme.mit.inf.kv.yakindu.control.helper;

import java.io.PrintStream;

/**
 *
 * @author benedekh
 */
public class SimpleLogger {

    private static boolean STATUS_LOG_ENABLED = false;

    public static final PrintStream STATUS_LOGGER = System.out;
    private static final PrintStream ERROR_LOGGER = System.err;

    public static void setStatusLogEnabled(boolean statusLogEnabled) {
        STATUS_LOG_ENABLED = statusLogEnabled;
    }

    public static void printErrorMessage(String sender, String message) {
        ERROR_LOGGER.println("[" + sender + "] " + message);
    }

    public static void printLogMessage(String sender, String message) {
        if (STATUS_LOG_ENABLED) {
            STATUS_LOGGER.println("[" + sender + "] " + message);
        }
    }

}
